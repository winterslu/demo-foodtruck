/**
 * Created by winters on 11/4/14.
 */
window.FT = window.FT || {};
(function($){
    FT.templateLoader = {
        load: function(views, callback){
            var deferreds = [];
            $.each(views, function(index, view) {
                if (window.FT[view]) {
                    deferreds.push($.get('pages/' + view + '.html', function(data) {
                        window.FT[view].prototype.template = _.template(data);
                    }, 'html'));
                } else {
                    alert(view + " is missing");
                }
            });

            $.when.apply(null, deferreds).done(callback);
        }
    };
})(jQuery);