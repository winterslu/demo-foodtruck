/**
 * Created by winters on 11/4/14.
 */
window.FT = window.FT || {};
(function($){



    FT.FoodTruck = Backbone.Model.extend({

        urlRoot: "foodtrucks",

        initialize:function(){

        },

        defaults:{
            id: 0,
            locationId: 0,
            applicant: "",
            facilityType: "",
            cnn: 0,
            locationDescription: "",
            address: "",
            block: "",
            lot: "",
            permit: "",
            status: "",
            food_items: "",
            x: 0,
            y: 0,
            latitude: 0,
            longitude: 0,
            schedule: "",
            noiSent: 0,
            approved: 0,
            received: "",
            priorPermit: 0,
            expirationDate: 0
        }
    });

    FT.FoodTruckCollection = Backbone.Collection.extend({
        model: FT.FoodTruck,
        url: "services/foodtrucks",
        initialize: function(){
            console.log("Random FoodTruck Collection initialized");
        },

        getRandom: function(successCallback){
            var formedUrl = this.url + '/random';
            var self = this;
            $.ajax({
                url: formedUrl,
                dataType: "json",
                success: function(data){
                    self.reset(data);
                    successCallback();
                }
            });
        },

        findClosest: function(latitude, longitude, count, successCallback){
            latitude = typeof latitude == 'number'? latitude : null;
            longitude = typeof longitude == 'number'? longitude : null;
            count = typeof count == 'number'? count : null;

            var formedUrl = this.url + '/closest?lat=' + latitude + '&lng=' + longitude + '&count=' + count;
            var self = this;
            $.ajax({
                url: formedUrl,
                dataType: "json",
                success: function(data){
                    self.reset(data);
                    successCallback();
                }
            });
        },

        findInDistance: function(latitude, longitude, dist, successCallback){
            latitude = typeof latitude == 'number'? latitude : null;
            longitude = typeof longitude == 'number'? longitude : null;
            dist = typeof dist == 'number'? dist : null;

            var formedUrl = this.url + '/indistance?lat=' + latitude + '&lng=' + longitude + '&dist=' + dist;
            var self = this;
            $.ajax({
                url: formedUrl,
                dataType: "json",
                success: function(data){
                    self.reset(data);
                    successCallback();
                }
            });
        }


    });


})(jQuery);
