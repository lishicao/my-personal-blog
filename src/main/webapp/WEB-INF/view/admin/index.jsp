<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../resources/self/image/cat.ico">
    <title>Dashboard</title>

    <!-- Bootstrap core CSS -->
    <link href="../../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../../resources/self/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="../../../resources/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../../resources/assets/js/ie-emulation-modes-warning.js"></script>

    <script src="../../../resources/self/js/jquery-1.11.3.js"></script>
    <script src="../../../resources/bootstrap-paginator/build/bootstrap-paginator.min.js"></script>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">My Blog</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin/index">Dashboard</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Blogs<span class="sr-only">(current)</span></a></li>
                <li><a href="/admin/toAddBlog">New Blog</a></li>
                <li><a href="/admin/listBlogClassification">Blog Classification</a></li>
                <li><a href="/admin/toAddBlogClassification">New Blog Classification</a></li>
                <li><a href="/admin/listBlogLabel">Blog Label</a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <li><a href="/admin/listResources">Resources</a></li>
                <li><a href="/admin/toAddResources">New Resources</a></li>
                <li><a href="/admin/listResourcesClassification">Resources Classification</a></li>
                <li><a href="/admin/toResourcesClassification">New Resources Classification</a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <li><a href="/admin/toListComment">Comment</a></li>
                <li><a href="/admin/toWriteAboutMe">Write About Me</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">
                Blogs
                <form class="navbar-form navbar-right">
                    <input type="text" class="form-control" placeholder="Search...">
                </form>
            </h1>
            <br>
            <div class="table-responsive">
                <table id="data_table" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>title</th>
                        <th>createTime</th>
                        <th>clickCount</th>
                        <th>operation</th>
                    </tr>
                    </thead>
                    <tbody id="list">

                    </tbody>
                </table>
            </div>
            <ul id="example"></ul>

        </div>
    </div>
</div>

<script>
    $(function () {
//        var carId = 1;
        $.ajax({
            url: "/admin/listBlog",
            datatype: 'json',
            type: "Post",
            data: "page=" + 1,
            success: function (data) {
                $("#list").empty();
                if (data != null) {
                    $.each(data.list, function (index, item) {
                        $("#list").append(  "<tr>" +
                                            "<td>#</td>" +
                                            "<td>" + item.title + "</td>" +
                                            "<td>" + item.createTime + "</td>" +
                                            "<td>" + item.clickCount + "</td>" +
                                            "<td>" +
                                            '<a href="/admin/detailBlog?blogId=' + item.id + '"><button class="btn btn-sm btn-default">view</button></a>'+
                                            '<a href="/admin/toEditBlog?blogId=' + item.id + '"><button class="btn btn-sm btn-default">edit</button></a>'+
                                            '<a href="/admin/toDeleteBlog?blogId=' + item.id + '"><button class="btn btn-sm btn-default">delete</button></a>'+
                                            "</tr>");
                    });
                    var pageCount = data.pageCount;       //
                    var currentPage = data.currentPage;   //
                    var options = {
                        bootstrapMajorVersion: 3,   //版本
                        currentPage: currentPage,   //当前页数
                        totalPages: pageCount,      //总页数
                        itemTexts: function (type, page, current) {
                            switch (type) {
                                case "first":
                                    return "first";
                                case "prev":
                                    return "prev";
                                case "next":
                                    return "next";
                                case "last":
                                    return "last";
                                case "page":
                                    return page;
                            }
                        },
                        //点击事件
                        onPageClicked: function (event, originalEvent, type, page) {
                            $.ajax({
                                url: "/admin/listBlog",
                                dataType: "json",
                                type: "Post",
                                data: "page=" + page,
                                success: function (data1) {
                                    $("#list").empty();
                                    if (data1 != null) {
                                        $.each(data1.list, function (index, item) {
                                            $("#list").append(  "<tr>" +
                                                    "<td>#</td>" +
                                                    "<td>" + item.title + "</td>" +
                                                    "<td>" + item.createTime + "</td>" +
                                                    "<td>" + item.clickCount + "</td>" +
                                                    "<td>" +
                                                    '<a href="/admin/detailBlog?blogId=' + item.id + '"><button class="btn btn-sm btn-default">view</button></a>'+
                                                    '<a href="/admin/toEditBlog?blogId=' + item.id + '"><button class="btn btn-sm btn-default">edit</button></a>'+
                                                    '<a href="/admin/toDeleteBlog?blogId=' + item.id + '"><button class="btn btn-sm btn-default">delete</button></a>'+
                                                    "</tr>");
                                        });
                                    }
                                }
                            });
                        }
                    };
                    $('#example').bootstrapPaginator(options);
                }
            }
        });
    })
</script>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../../../resources/bootstrap/js/bootstrap.min.js"></script>
<script src="../../../resources/assets/js/ie10-viewport-bug-workaround.js"></script>
<script src="../../../resources/assets/js/vendor/holder.min.js"></script>
<script src="../../../resources/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
