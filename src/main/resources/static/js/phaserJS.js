//连接 websocket 地址
var connect_sw_url = "/ws/connect_sw_url";
//订阅 接收 主地址
var main_receive_url = "/main_receive_url";
//player接收
var receive_player_info = "/receive_player_info";
//发送 主地址
var main_send_url = "/main_send_url";
//发送 子地址1
var send_player_info = "/send_player_info";

//ws工具
var MyWebSocket = function () {
    this.stompClient = null;

    //连接
    this.connect = function () {
        var myws = this;
        myws.stompClient = Stomp.over(new SockJS(connect_sw_url));
        myws.stompClient.connect({}, function (frame) {
            //订阅
            myws.stompClient.subscribe(main_receive_url + receive_player_info, function (data) {
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
        myws.stompClient.send(main_send_url + send_player_info, {}, JSON.stringify(objMsg));
    }
    //接收消息
    this.receiveMsg = function (data) {}
}

