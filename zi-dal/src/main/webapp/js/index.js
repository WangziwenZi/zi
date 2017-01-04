(function ($) {
    tools = {
        /**
         * 获取可视区域高度
         * @returns {*}
         */
        findByHeight: function () {
            return $("body").height();
        },
        /**
         * 获取可视区域宽度
         * @returns {*}
         */
        findByWidth: function () {
            return $("body").width();
        },
        /**
         * 获取表单信息
         * @param _this 表单DOM
         */
        findBySerializeJson: function (_this) {
            var result = {};
            $.each(_this.serializeArray(), function (k, v) {
                if (!result[v.name]) {
                    result[v.name] = v.value;
                } else {
                    result[v.name] += "," + v.value;
                }
            });
            return result;
        }
    }
})(jQuery)