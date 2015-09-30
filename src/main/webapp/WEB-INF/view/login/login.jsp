<%--
  Created by IntelliJ IDEA.
  User: lishicao
  Date: 15/9/28
  Time: 上午1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
  <form action="/login" method="post">
    <div>
      <label>用户名</label>
      <input type="text"class="textTheme" data-valid-rule="notNull" name="username"  />
    </div>

    <div>
      <label>密码</label>
      <input type="password" class="textTheme" data-valid-rule="notNull" name="password"  />
    </div>

    <div>
      <input type="submit" value="登录" class="btn">
      <input type="reset" value="取消"  class="btn">
    </div>
  </form>
<body>

</body>
</html>
