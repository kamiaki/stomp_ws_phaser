//ws工具
var MyWebSocket = function () {
    this.stompClient = null;

    //连接
    this.connect = function () {
        var myws = this;
        myws.stompClient = Stomp.over(new SockJS(connect));
        myws.stompClient.connect({}, function (frame) {
            //订阅
            myws.stompClient.subscribe(subM + sub1, function (data) {
                myws.receiveMsg(data);
            });
        });
    };
    //断开
    this.disconnect = function () {
        var myws = this;
        if (myws.stompClient != null) {
            myws.stompClient.disconnect();
        }
    }
    //发送消息
    this.sendMsg = function (objMsg) {
        var myws = this;
        myws.stompClient.send(mappingM + mapping1, {}, JSON.stringify(objMsg));
    }
    //接收消息
    this.receiveMsg = function (data) {}
}

