/**
 * Created by winters on 11/4/14.
 */
Backbone.sync = function(method, model, success, error){
    success();
};

var FoodTruck = Backbone.Model.extend({
    defaults:{
        part1: 'hello',
        part2: 'world'
    }
});

var FoodTruckList = Backbone.Collection.extend({
    model: FoodTruck
});


var FoodTruckView = Backbone.View.extend({
    tagName: 'li',

    events: {
        'click span.swap': 'swap',
        'click span.delete': 'remove'
    },
    initialize: function(){
        _.bindAll(this, 'render', 'unrender', 'swap', 'remove');
        this.model.bind('change', this.render);
        this.model.bind('remove', this.unrender);
    },

    render: function(){
        $(this.el).html('<span style="color:black;">'+this.model.get('part1')+' '+this.model.get('part2')+'</span> &nbsp; &nbsp; <span class="swap" style="font-family:sans-serif; color:blue; cursor:pointer;">[swap]</span> <span class="delete" style="cursor:pointer; color:red; font-family:sans-serif;">[delete]</span>');
        return this;
    },
    unrender: function(){
        $(this.el).remove();
    },
    swap: function(){
        var swapped = {
            part1: this.model.get('part2'),
            part2: this.model.get('part1')
        };
        this.model.set(swapped);
    },
    remove: function(){
        this.model.destroy();
    }
});

var AppView = Backbone.View.extend({
    el: $('body'),

    events: {
        'click button#add':'addFoodTruck'
    },
    initialize: function(){
        _.bindAll(this, 'render', 'addFoodTruck', 'appendFoodTruck');
        this.collection = new FoodTruckList();
        this.collection.bind('add', this.appendFoodTruck);

        this.counter = 0;
        this.render();
    },

    render: function(){
        var self = this;
        $(this.el).append("<button id='add'>Add list item</button>");
        $(this.el).append("<ul></ul>");
        $(this.collection.models).each(function(foodTruck){
            self.appendFoodTruck(foodTruck);
        }, this);
    },

    addFoodTruck: function(){
        this.counter++;
        var foodTruck = new FoodTruck();
        foodTruck.set({
            part2: foodTruck.get('part2') + this.counter
        });
        this.collection.add(foodTruck);

//            $('ul', this.el).append("<li>hello world"+this.counter+"</li>");
    },

    appendFoodTruck: function(foodTruck){
        var foodTruckView = new FoodTruckView({
            model: foodTruck
        });
        $('ul', this.el).append(foodTruckView.render().el);
    }

});

var appView = new AppView();