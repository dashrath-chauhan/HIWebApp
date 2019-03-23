
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <title>Heer International</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
              crossorigin="anonymous">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="WEB-INF/html/bootstrap/css/style.css" type="text/css">
        <link rel="stylesheet" href="WEB-INF/html/bootstrap/css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/dateTimePicker/jquery.datetimepicker.css">
        <% System.setProperty("java.awt.headless", "false");%>
    </head>

    <body>
        <div class="jumbotron vertical-center">
            <form method="post" class="form-signin col-lg-4 container col-md-4 col-md-offset-6">
                <div class="text-center mb-4">
                    <img class="mb-4" src="<%=request.getContextPath()%>/images/logo.png" alt="" width="72" height="72">
                    <h1 class="h3 mb-3 font-weight-normal text-primary"><strong>Heer International</strong></h1>
                </div>

                <div class="form-label-group">
                    <label for="inputEmail">Email address</label>
                    <input type="email" id="email" class="form-control" placeholder="Email address" required autofocus>
                </div>

                <div class="form-label-group mt-4">
                    <label for="inputPassword">Password</label>
                    <input type="password" id="password" class="form-control" placeholder="Password" required>
                </div>
                <a class="btn btn-lg btn-primary btn-block mt-5" id="login-button" role="button">Sign in</a>
                <p class="text-muted text-center mt-4">&copy; 2019</p>
            </form>
        </div>

  </footer>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/users.js"></script>
</body>
</html>