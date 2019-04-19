<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
    <style>
        #mrmy {
            animation: change 10s linear 0s infinite;
            font-size: 30px;
            font-weight: 700;
        }

        @keyframes change {
            0% {
                color: #333;
            }
            25% {
                color: #ff0;
            }
            50% {
                color: #f60;
            }
            75% {
                color: #cf0;
            }
            100% {
                color: #f00;
            }
        }
    </style>
    <script type="text/javascript" language=JavaScript charset="UTF-8">
        var password;
        var keycode = new Array(65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90);
        var zimucode = new Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'
            , 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        document.onkeydown = function (event) {
            var e = event || window.event || arguments.callee.caller.arguments[0];
            if (e && e.keyCode == 13) { // enter 键
                alert(password);
            } else {
                password = 'aaaa';
            }
        };
    </script>
</head>
<body>
<div id="mrmy">
    <img src="/images/banner_bd.jpg">
    <br/>
    ${randomMrmy}
</div>
</body>
</html>
