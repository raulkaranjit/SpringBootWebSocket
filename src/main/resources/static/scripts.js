var stompClient = null;

$(document).ready(function() {
    console.log("Index page is ready");

    $("#connect").click(function() {
    	connect($("#username").val());
    });

    $("#send").click(function() {
        sendMessage();
    });
});

function connect(username) {
    var socket = new SockJS('/hello');
    stompClient = Stomp.over(socket);
    stompClient.connect({ username: username, }, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/users/queue/messages', function (message) {
            showMessage(message);
        });
    });
}

function showMessage(message) {
    $("#messages").append("<tr><td>" + message + "</td></tr>");
}

function sendMessage() {
    console.log("sending message");
    stompClient.send("/app/hello", {}, $("#message").val());
}