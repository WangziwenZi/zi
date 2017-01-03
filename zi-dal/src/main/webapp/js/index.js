(function($){
    tools = {
        /**
         * 获取可视区域高度
         * @returns {*}
         */
        findByHeight:function(){
            return $("body").height();
        },
        /**
         * 获取可视区域宽度
         * @returns {*}
         */
        findByWidth:function(){
            return $("body").width();
        }
        ,
    }
})(jQuery)