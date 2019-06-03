<%--
  Created by IntelliJ IDEA.
  User: kdnight
  Date: 2019/5/30
  Time: 13:43
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
    <%--zTree--%>
    <link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css">
    <%--DropZone--%>
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/dropzone.min.css"/>
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/basic.min.css"/>
    <link rel="stylesheet" href="/static/assets/plugins/wangEditor/wangEditor-3.0.16/release/wangEditor.min.css"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                内容管理 | ${tbContent.id==null?"新增":"编辑"}
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>


        <!-- Main content -->
        <section class="content">
            <div class="col-xs-12">
                <c:if test="${baseResult!=null}">
                    <div class="alert alert-${baseResult.status == 200?"success":"danger"} alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <h4><i class="icon fa fa-info"></i>提示</h4>
                            ${baseResult.message}
                    </div>
                </c:if>
                <div class="row">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">请填写信息</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="inputForm" cssClass="form-horizontal" action="/content/save" method="post"
                                   commandName="tbContent">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group ">
                                    <label for="tbContentCategory.id" class="col-sm-2 control-label">父级类目</label>
                                    <div class="col-sm-10">
                                        <form:hidden id="categoryId" path="tbContentCategory.id"/>
                                        <input id="categoryName" class="form-control required" placeholder="请选择"
                                               readonly="true" data-toggle="modal" data-target="#modal-default" value="${tbContent.tbContentCategory.name}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="title" class="col-sm-2 control-label">标题</label>

                                    <div class="col-sm-10">
                                        <form:input path="title" class="form-control required"
                                                    placeholder="标题"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="subTitle" class="col-sm-2 control-label">子标题</label>

                                    <div class="col-sm-10">
                                        <form:input path="subTitle" class="form-control required "
                                                    placeholder="子标题"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="titleDesc" class="col-sm-2 control-label">标题描述</label>

                                    <div class="col-sm-10">
                                        <form:input path="titleDesc" class="form-control required "
                                                    placeholder="标题描述"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="url" class="col-sm-2 control-label">链接</label>

                                    <div class="col-sm-10">
                                        <form:input path="url" class="form-control required "
                                                    placeholder="链接"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="pic" class="col-sm-2 control-label">图片1</label>
                                    <div class="col-sm-10">
                                        <form:input path="pic" class="form-control required "
                                                    placeholder="图片1"/>
                                        <div id="dropz" class="dropzone"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="pic2" class="col-sm-2 control-label">图片2</label>
                                    <div class="col-sm-10">
                                        <form:input path="pic2" class="form-control required"
                                                    placeholder="图片2"/>
                                        <div id="dropz2" class="dropzone"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <form:hidden path="content" />
                                    <label  class="col-sm-2 control-label">详情</label>
                                    <div class="col-sm-10">
                                        <div id="editor">${tbContent.content}</div>
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button id="btnSubmit" type="submit" class="btn btn-info pull-right" >提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>

                    </div>
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
<%--zTree--%>
<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<%--DropZone--%>
<script src="/static/assets/plugins/dropzone/min/dropzone.min.js"></script>
<%--WangEditor--%>
<script src="/static/assets/plugins/wangEditor/wangEditor-3.0.16/release/wangEditor.min.js"></script>

<%--自定义模态框--%>
<sys:modal title="请选择" msg="<ul id='myTree' class='ztree'></ul>"/>
<script>
    //jQuery的初始化方法
    $(function () {
        App.initZTree("/content/category/tree/data", ["id"], function (nodes) {
            var node = nodes[0];
            $("#categoryId").val(node.id);
            $("#categoryName").val(node.name);
            $("#modal-default").modal("hide");
        });
        initWangEditor();
    });

    /**
     * 初始化富文本编辑器
     */
    function initWangEditor(){
        var E = window.wangEditor;
        var editor = new E('#editor');
        // 配置服务器端地址
        editor.customConfig.uploadImgServer = '/upload';
        editor.customConfig.uploadFileName = 'editorFile';
        editor.create();
        $("#btnSubmit").bind("click", function () {
            var contentHtml = editor.txt.html();
            $("#content").val(contentHtml);
        });
    };
    App.initDropzone({
        id :"#dropz",
        url :"/upload",
        init:function(){
            this.on("success", function (file, data) {
                $("#pic").val(data.fileName);
            });
        }
    });
    App.initDropzone({
        id :"#dropz2",
        url :"/upload",
        init:function(){
            this.on("success", function (file, data) {
                $("#pic2").val(data.fileName);
            });
        }
    });

</script>
</body>
</html>

