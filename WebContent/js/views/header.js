/**
 * Created by winters on 11/4/14.
 */
window.FT = window.FT || {};
(function($){
    FT.HeaderView = Backbone.View.extend({
        events: {

        },
        initialize: function() {

        },
        render: function(){
            $(this.el).html(this.template());
            return this;
        },

        search: function(){
        },

        select: function(menuItem) {
            $('.masthead-nav li').removeClass('active');
            $('.' + menuItem).addClass('active');
        }

    });


})(jQuery);