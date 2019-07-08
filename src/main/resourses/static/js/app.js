

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

/*
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});
*/
$( document ).ready(function() {
   //var stompClient = null;
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/greetings', function (isActive) {
            var h1 = $('#isLamp');
            if (isActive.body == 'false') {
                h1.text("LAMP IS OFF");
            } else {
                h1.text("LAMP IS ON");
            }

        });
        stompClient.send("/app/check", {}, '');
    });
    $("#send2").click(function () {
        stompClient.send("/app/hello", {}, '');
    })
});