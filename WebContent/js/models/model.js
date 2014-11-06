/**
 * Created by winters on 11/4/14.
 */
(function($){



    FT.FoodTruck = Backbone.Model.extend({

        urlRoot: "foodtrucks",

        initialize:function(){

        },

        defaults:{
            part1: 'hello',
            part2: 'world'
        }
    });

    FT.FoodTruckList = Backbone.Collection.extend({
        model: FoodTruck
    });
})(jQuery);
