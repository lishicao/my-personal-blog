<%--
  Created by IntelliJ IDEA.
  User: lishicao
  Date: 15/9/28
  Time: 上午1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
          <meta charset="utf-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
          <meta name="description" content="">
          <meta name="author" content="">

          <title>Login</title>

          <!-- Bootstrap core CSS -->
          <link href="../../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

          <!-- Custom styles for this template -->
          <link href="../../../resources/self/css/signin.css" rel="stylesheet">
    </head>

<body>

<div class="container">

  <form class="form-signin" action="/login" method="post">
    <h2 class="form-signin-heading">Please sign in</h2>
    <label for="inputUserName" class="sr-only">User Name</label>
    <input type="text" id="inputUserName" class="form-control" placeholder="User Name" name="username" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  </form>

</div>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../../resources/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
