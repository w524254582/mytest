var App = function () {

    //Icheck
    var _mastercheckbox;
    var _checkbox;

    //数组 用于存放id
    var _idArray;

    /**
     * 私有方法,初始化icheck
     */
    var handlerInitCheckbox = function () {
        //激活
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
        });
        //获取控制端 checkbox
        _mastercheckbox = $('input[type="checkbox"].minimal.icheck_master');
        //获取全部 checkbox 集合
        _checkbox = $('input[type="checkbox"].minimal');
    };
    /**
     * check全选功能
     */
    var handlerCheckboxAll = function () {
        _mastercheckbox.on("ifClicked", function (e) {
            //选中为false
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            } else {
                _checkbox.iCheck("check");
            }
        });

    };

    var handlerDeleteMulti = function (url) {
        _idArray = new Array();

        //将选中元素的 ID 放入 数组中
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && $(this).attr("id") != "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
            console.log(_idArray.length);
        });
        console.log("输出完毕");
        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
        } else {
            $("#modal-message").html("您确定要删除数据项吗？");
        }
        $("#modal-default").modal("show");


        $("#btnModalOk").bind("click", function () {
            del();
        });

        /**
         * 当前私有函数的私有函数 删除数据
         */
        function del() {
            $("#modal-default").modal("hide");
            //如果没有选择数据项，则关闭模态框
            if (_idArray.length === 0) {
                //...
            } else {
                setTimeout(function () {
                    //否则执行删除操作
                    $.ajax({
                        "url": url,
                        "type": "POST",
                        "data": {"ids": _idArray.toString()},
                        "dataType": "JSON",
                        "success": function (data) {
                            //删除成功
                            if (data.status === 200) {
                                window.location.reload();
                            } else {
                                $("#btnModalOk").unbind("click");
                                $("#btnModalOk").bind("click", function () {
                                    $("modal-default").modal("hide");
                                });

                                $("#modal-message").html(data.message);
                                $("modal-default").modal("show");
                            }
                        }
                    });
                }, 500);
            }
        }
    };


    //暴露这个方法
    return {
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },
        getCheckbox: function () {
            return _checkbox;
        },
        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        }
    };
}();

$(document).ready(function () {
    App.init();
});