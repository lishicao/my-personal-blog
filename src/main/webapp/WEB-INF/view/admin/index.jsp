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

    <script src="../../../resources/bootstrap-paginator/build/bootstrap-paginator.min.js"></script>
    <script src="../../../resources/self/js/jquery-1.11.3.js"></script>
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
                <li><a href="#">Settings</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
                <li><a href="#">New Blog</a></li>
                <li><a href="#">Blog Classification</a></li>
                <li><a href="#">New Blog Classification</a></li>
                <li><a href="#">Blog Label</a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <li><a href="">Resources</a></li>
                <li><a href="">New Resources</a></li>
                <li><a href="">Resources Classification</a></li>
                <li><a href="">New Resources Classification</a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <li><a href="">Comment</a></li>
                <li><a href="">Write About Me</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Dashboard</h1>

            <h2 class="sub-header">Section title</h2>
            <div class="table-responsive">
                <div id="example"></div>
            </div>
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
                if (data != null) {
                    $.each(eval("(" + data + ")").list, function (index, item) { //遍历返回的json
                        $("#list").append('<table id="data_table" class="table table-striped">');
                        $("#list").append('<thead>');
                        $("#list").append('<tr>');
                        $("#list").append('<th>Id</th>');
                        $("#list").append('<th>部门名称</th>');
                        $("#list").append('<th>备注</th>');
                        $("#list").append('<th> </th>');
                        $("#list").append('</tr>');
                        $("#list").append('</thead>');
                        $("#list").append('<tbody>');
                        $("#list").append('<tr>');
                        $("#list").append('<td>' + item.Id + '</td>');
                        $("#list").append('<td>' + item.Name + '</td>');
                        $("#list").append('<td>备注</td>');
                        $("#list").append('<td>');
                        $("#list").append('<button class="btn btn-warning" onclick="Edit(' + item.Id + ' );">修改</button>');
                        $("#list").append('<button class="btn btn-warning" onclick="Edit(' + item.Id + ' );">删除</button>');
                        $("#list").append('</td>');
                        $("#list").append('</tr>');
                        $("#list").append('</tbody>');

                        $("#list").append('<tr>');
                        $("#list").append('<td>内容</td>');
                        $("#list").append('<td>' + item.Message + '</td>');
                        $("#list").append('</tr>');
                        $("#list").append('</table>');
                    });
                    var pageCount = eval("(" + data + ")").pageCount; //取到pageCount的值(把返回数据转成object类型)
                    var currentPage = eval("(" + data + ")").CurrentPage; //得到CurrentPage
                    var options = {
                        bootstrapMajorVersion: 3, //版本
                        currentPage: currentPage, //当前页数
                        totalPages: pageCount, //总页数
                        itemTexts: function (type, page, current) {
                            switch (type) {
                                case "first":
                                    return "首页";
                                case "prev":
                                    return "上一页";
                                case "next":
                                    return "下一页";
                                case "last":
                                    return "末页";
                                case "page":
                                    return page;
                            }
                        },//点击事件，用于通过Ajax来刷新整个list列表
                        onPageClicked: function (event, originalEvent, type, page) {
                            $.ajax({
                                url: "/admin/listBlog",
                                dataType: "json",
                                type: "Post",
                                data: "page=" + page,
                                success: function (data1) {
                                    if (data1 != null) {
                                        $.each(eval("(" + data + ")").list, function (index, item) { //遍历返回的json
                                            $("#list").append('<table id="data_table" class="table table-striped">');
                                            $("#list").append('<thead>');
                                            $("#list").append('<tr>');
                                            $("#list").append('<th>Id</th>');
                                            $("#list").append('<th>部门名称</th>');
                                            $("#list").append('<th>备注</th>');
                                            $("#list").append('<th> </th>');
                                            $("#list").append('</tr>');
                                            $("#list").append('</thead>');
                                            $("#list").append('<tbody>');
                                            $("#list").append('<tr>');
                                            $("#list").append('<td>' + item.Id + '</td>');
                                            $("#list").append('<td>' + item.Name + '</td>');
                                            $("#list").append('<td>备注</td>');
                                            $("#list").append('<td>');
                                            $("#list").append('<button class="btn btn-warning" onclick="Edit(' + item.Id + ' );">修改</button>');
                                            $("#list").append('<button class="btn btn-warning" onclick="Edit(' + item.Id + ' );">删除</button>');
                                            $("#list").append('</td>');
                                            $("#list").append('</tr>');
                                            $("#list").append('</tbody>');

                                            $("#list").append('<tr>');
                                            $("#list").append('<td>内容</td>');
                                            $("#list").append('<td>' + item.Message + '</td>');
                                            $("#list").append('</tr>');
                                            $("#list").append('</table>');
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

</body>
</html>
