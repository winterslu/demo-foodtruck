/**
 * Created by winters on 11/4/14.
 */
window.FT = window.FT || {};
(function($){

    FT.HomeView = Backbone.View.extend({
        MAP_TYPE : {
            RANDOM : 0,
            RANGE : 1,
            CLOSEST : 2
        },
        DEFAULT_RANGESEARCH_RANGE : 1500,
        DEFAULT_CLOSESTSEARCH_COUNT : 20,

        events: {
            "click #range" : "initRangeSearch",
            "click #random" : "initRandomSearch",
            "click #closest" : "initClosestSearch"
        },

        initialize: function() {
            this.maptype = this.MAP_TYPE.RANDOM;
            if(!this.foodTruckList){
                this.foodTruckList = new FT.FoodTruckCollection();
            }
        },

        initRandomSearch: function() {
            this.maptype = this.MAP_TYPE.RANDOM;
            var self = this;
            this.foodTruckList.getRandom(function(){
                self.listView = new FT.ListView({model: self.foodTruckList});
                self.updateMap(self.foodTruckList.models);
            });
            $('.nav-pills li').removeClass('active');
            $('#random').addClass('active');
        },
        initRangeSearch: function() {
            this.maptype = this.MAP_TYPE.RANGE;
            var self = this;
            this.foodTruckList.findInDistance(
                this.currentPos.lat(),
                this.currentPos.lng(),
                this.DEFAULT_RANGESEARCH_RANGE / 1000,
                function(){
                    self.listView = new FT.ListView({model: self.foodTruckList});
                    self.updateMap(self.foodTruckList.models);
            });
            $('.nav-pills li').removeClass('active');
            $('#range').addClass('active');
        },
        initClosestSearch: function() {
            this.maptype = this.MAP_TYPE.CLOSEST;
            var self = this;
            this.foodTruckList.findClosest(
                this.currentPos.lat(),
                this.currentPos.lng(),
                this.DEFAULT_CLOSESTSEARCH_COUNT,
                function(){
                    self.listView = new FT.ListView({model: self.foodTruckList});
                    self.updateMap(self.foodTruckList.models);
            });
            $('.nav-pills li').removeClass('active');
            $('#closest').addClass('active');
        },

        activateMap: function(){
            this.currentPos = new google.maps.LatLng(37.7491426, -122.4361673);

            this.mapOptions = {
                zoom: 11,
                disableDefaultUI: true,
                center: this.currentPos,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var domElement = this.$('#map-canvas');
            this.map = new google.maps.Map(domElement.get(0), this.mapOptions);

            this.rangeOptions = {
                strokeColor: '#FF0000',
                strokeOpacity: 0.5,
                strokeWeight: 2,
                fillColor: '#FF0000',
                fillOpacity: 0.2,
                map: this.map,
                center: this.currentPos,
                radius: this.DEFAULT_RANGESEARCH_RANGE / 0.6213,
                editable: true
            };

            var self = this;

            // Try HTML5 geolocation
            if(navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function(position) {
                    self.currentPos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);

//                    var infowindow = new google.maps.InfoWindow({
//                        map: self.map,
//                        position: pos,
//                        content: 'Location found using HTML5.'
//                    });

//                    self.map.setCenter(pos);

                }, function() {
                    self.handleNoGeolocation(true);
                });
            } else {
                // Browser doesn't support Geolocation
                this.handleNoGeolocation(false);
            }
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
                position: new google.maps.LatLng(37.7491426, -122.4361673),
                content: content
            };

//            var infowindow = new google.maps.InfoWindow(mapOptions);
            this.map.setCenter(mapOptions.position);
        },

        updateMap: function(dataSets){
            var self = this;
            if(this.rangeCircle != undefined){
                this.rangeCircle.setMap(null);
            }
            if(this.maptype == this.MAP_TYPE.RANGE){
                this.rangeOptions.center = this.currentPos;
                this.rangeCircle = new google.maps.Circle(this.rangeOptions);
                google.maps.event.addListener(this.rangeCircle, 'center_changed', function(){
                    self.foodTruckList.findInDistance(
                        self.rangeCircle.getCenter().lat(),
                        self.rangeCircle.getCenter().lng(),
                        self.rangeCircle.getRadius() / 1000 * 0.6213,
                        function(){
                            self.listView = new FT.ListView({model: self.foodTruckList});
                            self.resetMarkers(self.foodTruckList.models);
                        });
                });
                google.maps.event.addListener(this.rangeCircle, 'radius_changed', function(){
                    self.foodTruckList.findInDistance(
                        self.rangeCircle.getCenter().lat(),
                        self.rangeCircle.getCenter().lng(),
                            self.rangeCircle.getRadius() / 1000 * 0.6213,
                        function(){
                            self.listView = new FT.ListView({model: self.foodTruckList});
                            self.resetMarkers(self.foodTruckList.models);
                        });
                });
            }
            this.resetMarkers(dataSets);
        },

        resetMarkers: function(dataSets){
            if(this.markers instanceof Array)
                for (var i = 0; i < this.markers.length; i++) {
                    this.markers[i].setMap(null);
                }
            this.markers = [];
            var infoWindow = new google.maps.InfoWindow();
            for(var i=0; i<dataSets.length; i++){
                var location =
                    new google.maps.LatLng(dataSets[i].get('latitude'), dataSets[i].get('longitude'));
                var icon = "img/foodtruck_marker_default.png";
                if(dataSets[i].get('facilityType') == 'Truck')
                    icon = "img/foodtruck_marker_truck.png";
                var marker = new google.maps.Marker({
                    animation: google.maps.Animation.DROP,
                    position: location,
                    map: this.map,
                    icon: icon
                });
                this.markers.push(marker);

                // Set marker info based on input dataSets
                var self = this;
                google.maps.event.addListener(marker, 'click', (function(marker, i) {
                    return function() {
                        var dataSet = dataSets[i];
                        infoWindow.setContent(
                            "<dl><dt>" + dataSet.get('applicant') +
                                "</dt><dd>" + dataSet.get('address') +
                                "</dd></dl>");
                        infoWindow.open(self.map, marker);
                    }
                })(marker, i));

            }

            // Update list content that shows all result.
            $("#content-list").html(this.listView.el);
        },


        render: function(){
            $(this.el).html(this.template());
            this.activateMap();
            this.initRandomSearch();
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