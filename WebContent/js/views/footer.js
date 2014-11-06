/**
 * Created by winters on 11/4/14.
 */
window.FT = window.FT || {};
(function($){
    FT.FooterView = Backbone.View.extend({
        events: {

        },
        initialize: function() {

        },
        render: function(){
            $(this.el).html(this.template());
            return this;
        }


    });


})(jQuery);