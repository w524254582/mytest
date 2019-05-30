<%--
  Created by IntelliJ IDEA.
  User: kdnight
  Date: 2019/5/30
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult!=null}">
                        <div class="alert alert-${baseResult.status == 200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <h7><i class="icon fa fa-info"></i>提示</h7>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <!-- Horizontal Form -->
                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header with-border">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <div class="form-group">
                                <label for="title" class="col-sm-2 control-label">标题</label>

                                <div class="col-sm-10">
                                    <input id="title" class="form-control" placeholder="标题"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="subTitle" class="col-sm-2 control-label">子标题</label>

                                <div class="col-sm-10">
                                    <input id="subTitle" class="form-control" placeholder="子标题"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="titleDesc" class="col-sm-2 control-label">标题描述</label>
                                <div class="col-sm-10">
                                    <input id="titleDesc" class="form-control" placeholder="标题描述"/>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="button" class="btn btn-info pull-right" onclick="search();">搜索</button>
                        </div>
                        <!-- /.box-footer -->

                    </div>
                    <!-- /.box -->
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <a href="/content/form" type="button" class="btn btn-sm btn-default"><i
                                    class="fa fa-plus">新增</i></a>&nbsp;&nbsp;
                            <button type="button" class="btn btn-sm btn-default"
                                    onclick="App.deleteMulti('/content/delete')"><i
                                    class="fa fa-trash-o">批量删除</i></button>&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm btn-default"><i
                                    class="fa fa-sign-in">导入</i></a>&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm btn-default"><i
                                    class="fa fa-sign-out">导出</i></a>&nbsp;&nbsp;
                            <button type="button" class="btn btn-sm btn-primary"
                                    onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')">
                                <i class="fa fa-search">搜索</i></button>
                        </div>
                        <div class="box-body table-responsive ">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master"/></th>
                                    <th>ID</th>
                                    <th>标题</th>
                                    <th>子标题</th>
                                    <th>标题描述</th>
                                    <th>链接</th>
                                    <th>图片1</th>
                                    <th>图片2</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<!-- ./wrapper -->
<jsp:include page="../includes/footer.jsp"/>

<!-- 自定义模态框-->
<sys:modal/>


<script>
    var _dataTable;
    $(function () {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.id + '" type="checkbox" class="minimal"/>';
                }
            },
            {"data": "id"},
            {"data": "title"},
            {"data": "subTitle"},
            {"data": "titleDesc"},
            {
                "data": function (row, type, val, meta) {
                    if(row.url == null)
                        return '';
                    return '<a href="'+row.url+'" target="_blank">查看</a>';
                }
            },
            {
                "data": function (row, type, val, meta) {
                    if(row.pic == null)
                        return '';
                    return '<a href="'+row.pic+'" target="_blank">查看</a>';
                }
            },
            {
                "data": function (row, type, val, meta) {
                    if(row.pic2 == null)
                        return '';
                    return '<a href="'+row.pic2+'" target="_blank">查看</a>';
                }
            },
            {
                "data": function (row, type, val, meta) {
                    return DateTime.format(row.updated, "yyyy-MM-dd HH:mm:ss");
                }
            },
            {
                "data": function (row, type, val, meta) {
                    var detailUrl = "/content/detail?id=" + row.id;
                    return '<button type="button" class="btn btn-sm btn-default" onclick="App.showDetail(\'' + detailUrl + '\');"><i class="fa fa-search">查看</i></button >' +
                        '<a href="/content/form?id=' + row.id + '"type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit">编辑</i></a>' +
                        '<a href="#" type="button" class="btn btn-sm btn-danger"><i class="fa fa-trash">删除</i></a>';
                }
            }
        ];
        _dataTable = App.initDataTables("/content/page", _columns);

    });

    function search() {
        var title = $("#title").val();
        var subTitle = $("#subTitle").val();
        var titleDesc = $("#titleDesc").val();

        /**
         * 获取类名#title 获取到值，并存到parmam中，然后通过 .settings()[0].ajax.data 把该值放到ajax下的data里面，传至后端
         */
        var param = {
            "title": title,
            "subTitle": subTitle,
            "titleDesc": titleDesc
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    };
</script>
</body>
</html>

