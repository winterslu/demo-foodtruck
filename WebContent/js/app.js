/**
 * Created by winters on 11/3/14.
 */
window.FT = window.FT || {};
(function($){
    FT.Router = Backbone.Router.extend({
        routes: {
            "": "home",
            "newtruck": "newTruck",
            "about": "about"
        },

        initialize: function(){
            this.headerView = new FT.HeaderView();
            $('#headerView').html(this.headerView.render().el);
            this.footerView = new FT.FooterView();
            $('#footerView').html(this.footerView.render().el);

        },

        home: function(){
            // Only instantiate once
            if(!this.homeView){
                this.homeView = new FT.HomeView();
                this.homeView.render();
            }else{
                this.homeView.delegateEvents();
            }
            $("#content").html(this.homeView.el);
            this.headerView.select('home');

            // Initiate List
//            if(!this.ListView){
//                var self = this;
//                this.foodTruckList = new FT.FoodTruckCollection();
//                this.foodTruckList.findClosest(37.7491426, -122.4361673, 10,
//                    function(){
//                        self.listView = new FT.ListView({model: self.foodTruckList});
//                        self.homeView.updateMap(self.foodTruckList.models);
//                        $("#content-list").html(self.listView.el);
//                    }
//                );
//            }

        },

        newTruck: function(){
            this.detailView = new FT.DetailView();
            $("#content").html(this.detailView.render().el);
            this.headerView.select('newtruck');
        },

        about: function(){
            this.aboutView = new FT.AboutView();
            $("#content").html(this.aboutView.render().el);
            this.headerView.select('about');
        }

    });

    FT.templateLoader.load(["HeaderView", "FooterView", "HomeView", "DetailView", "AboutView", "ListView", "ListItemView"]
        , function(){
            app = new FT.Router();
            Backbone.history.start();
        }
    );

})(jQuery);