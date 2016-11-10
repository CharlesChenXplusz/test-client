<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>

    <asset:javascript src="jquery"/>
    <asset:javascript src="spring-websocket"/>

    <script type="text/javascript">
        $(function () {
            var socket = new SockJS("${createLink(uri: '/stomp')}");
            var client = Stomp.over(socket);

            client.connect({}, function () {
                client.subscribe("/topic/hello", function (message) {
                    $("#helloDiv").append(JSON.parse(message.body));
                    $("#helloDiv").append('<br>');
                });
            });

            $("#helloButton").click(function () {
                client.send("/app/hello", {}, JSON.stringify($('#msg').val()));
            });
        });
    </script>
</head>

<body>
<input type="text" name="msg" id="msg">
<button id="helloButton">hello</button>

<div id="helloDiv"></div>
</body>
</html>