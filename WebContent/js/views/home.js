/**
 * Created by winters on 11/4/14.
 */
window.FT = window.FT || {};
(function($){
    FT.HomeView = Backbone.View.extend({
        events: {

        },
        initialize: function() {
        },

        activateMap: function(){
            var mapOptions = {
                zoom: 10,
                disableDefaultUI: true,
                center: new google.maps.LatLng(37.5219895, -122.2234742),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var domElement = this.$('#map-canvas');
            this.map = new google.maps.Map(domElement.get(0),mapOptions);
            var self = this;

            // Try HTML5 geolocation
            if(navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function(position) {
                    var pos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);

                    var infowindow = new google.maps.InfoWindow({
                        map: self.map,
                        position: pos,
                        content: 'Location found using HTML5.'
                    });

                    self.map.setCenter(pos);
                    var beachMarker = new google.maps.Marker({
                        position: new google.maps.LatLng(37.5219895, -122.2234742),
                        map: self.map,
                        icon: 'img/foodtruck_marker.png'
                    });


                }, function() {
                    self.handleNoGeolocation(true);
                });
            } else {
                // Browser doesn't support Geolocation
                this.handleNoGeolocation(false);
            }
        },

        updateMap: function(){

        },

        handleNoGeolocation: function(errorFlag){
            var content = "";
            if (errorFlag) {
                content = 'Error: The Geolocation service failed.';
            } else {
                content = 'Error: Your browser doesn\'t support geolocation.';
            }

            var mapOptions = {
                map: this.map,
                position: new google.maps.LatLng(37.5219895, -122.2234742),
                content: content
            };

            var infowindow = new google.maps.InfoWindow(mapOptions);
            this.map.setCenter(mapOptions.position);
        },


        render: function(){
            $(this.el).html(this.template());
            this.activateMap();
            return this;
        }

    });



    FT.ListView = Backbone.View.extend({
        initialize: function(){
            this.render();
        },

        render: function(){
            var list = this.model.models;
            var len = list.length;

            $(this.el).html(this.template());
            for(var i=0; i<len; i++){
                $('#truckList', this.el).append(new FT.ListItemView({model: list[i]}).render().el);
            }
            return this;
        }

    });

    FT.ListItemView = Backbone.View.extend({
        initialize: function() {

        },

        render: function(){
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
        }

    });


})(jQuery);