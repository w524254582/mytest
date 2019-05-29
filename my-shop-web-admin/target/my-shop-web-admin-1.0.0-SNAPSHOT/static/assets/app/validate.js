/**
 * 函数对象
 * @constructor
 */
var Validate = function () {

    /**
     * 初始化 Jquery validation
     */
    var handlerInitValidate = function () {
        $("#inputForm").validate({
            errorElement: 'span',
            errorClass: 'help-block',

            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });

    };

    /**
     * 自定义验证规则
     */
    var handlerInitCustomValidate = function () {
        $.validator.addMethod("mobile", function(value, element) {
            var length = value.length;
            var mobile =  /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/
            ;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");

    };
    /**
     * return以上为私有方法， 以下为共有
     * 而return可以把私有方法暴露出来
     * 初始化
     */
    return {
        init: function () {
            handlerInitValidate();
            handlerInitCustomValidate();
        }
    }
}();


$(document).ready(function () {
    Validate.init();
});