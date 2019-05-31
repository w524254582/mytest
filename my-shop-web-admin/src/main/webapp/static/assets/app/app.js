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
        });
        //判断用户是否选择了数据项
        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
        } else {
            $("#modal-message").html("您确定要删除数据项吗？");
        }
        //点击删除按钮时弹出模态框
        $("#modal-default").modal("show");
        //如果用户选择了数据项则调用删除方法
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
                        //请求成功后，无论成功还是失败都需要弹出模态框进行提示，所以需要先解绑原来的click事件
                        "success": function (data) {
                            $("#btnModalOk").unbind("click");
                            //删除成功
                            if (data.status === 200) {
                                //刷新页面
                                $("#btnModalOk").bind("click", function () {
                                    window.location.reload();
                                });
                            } else {
                                //确定按钮的事件改为隐藏模态框
                                $("#btnModalOk").bind("click", function () {
                                    $("modal-default").modal("hide");
                                });
                            }
                            //无论如何都要提示信息，所以模态框是必须调用的
                            $("#modal-message").html(data.message);
                            $("#modal-default").modal("show");
                        }
                    });
                }, 500);
            }
        };
    };

    /**
     * 初始化 DataTables
     */
    var handlerInitDataTable = function (url, columns) {
        var _dataTable = $("#dataTable").DataTable({
            "paging": true,
            "info": true,
            "lengthChange": false,
            "ordering": false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url,
            },
            "columns": columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function (settings) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            },
        });
        return _dataTable;
    };

    var handlerShowDetail = function (url) {
        //ajax请求html的方式将 jsp 装载到模态框中
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success: function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };

    /**
     * 初始化zTree
     * @param url
     * @param autoParam
     * @param callback
     * @returns {{init: init, initZTree: initZTree, deleteMulti: deleteMulti, initDataTables: (function(*=, *=): jQuery), showDetail: showDetail}}
     */
    var handlerInitZTree = function (url, autoParam, callback) {
        var setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                url: url,
                autoParam: autoParam,
            }
        };
        $.fn.zTree.init($("#myTree"), setting);

        $("#btnModalOk").bind("click", function () {
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            var nodes = zTree.getSelectedNodes();
            //未选择
            if (nodes.length == 0) {
                alert("请选择一个节点");
            } else {
                callback(nodes);
            }
        });
    };

    //暴露这个方法
    return {
        //初始化
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },
        //批量删除
        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        },
        //初始化datatable
        initDataTables: function (url, columns) {
            return handlerInitDataTable(url, columns);

        },
        //显示详情
        showDetail: function (url) {
            handlerShowDetail(url);
        },
        initZTree: function (url, autoParam, callback) {
            handlerInitZTree(url, autoParam, callback);
        },

    };
}();

$(document).ready(function () {
    App.init();
});