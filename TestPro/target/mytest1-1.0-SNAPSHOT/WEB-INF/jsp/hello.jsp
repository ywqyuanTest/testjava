
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello word</title>
    <script src="/WEB-INF/public/js/jquery-1.12.0.min.js" rel="stylesheet"></script>
</head>

<script>

    var TimeFunc = function(){
        setInterval(function(){
            location.reload();
        },1000);
    }
 $(function () {
     TimeFunc;
 })
</script>

<body>
<h1>Hello !</h1>
<h2>当前时间：${currentTime}</h2>

</body>
</html>
