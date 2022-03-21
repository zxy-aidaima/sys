var timeController; //timer变量，控制时间
var count = 5; //间隔函数，1秒执行
var remainCount;//当前剩余秒数
function sendMessage() {
    remainCount = count;
    //设置button效果，开始计时
    $("#btnSendCode").attr("disabled", "true");
    $("#btnSendCode").val("请在" + remainCount + "秒内输入验证码");//加上这一句不会出现延迟，否则倒计时延迟1s
    timeController = setInterval("SetRemainTime()", 1000); //启动计时器，1秒执行一次
    //向后台发送处理数据
    var mobile = document.getElementById("phonenumber").value;
    $.ajax({
        asynch : "false",
        type : "POST", //用POST方式传输     　　
        url : 'reAction.action?mt=' + Math.random(), //目标地址.
        dataType : "json", //数据格式:JSON
        data : "&phonenumber=" + mobile,
        success : function(data) {
            var remessage = eval("(" + data + ")");
            $("#codemessage").html(remessage.codemessage);
            $("#code").val(remessage.code);
        },
        error : function() {
            $("#codemessage").html("发送失败请重试");
        }
    });
}
//timer处理函数
function SetRemainTime() {
    if (remainCount == 0) {
        clearInterval(timeController);//停止计时器
        $("#btnSendCode").removeAttr("disabled");//启用按钮
        $("#btnSendCode").val("重新发送验证码");
    } else {
        remainCount--;
        $("#btnSendCode").val("请在" + remainCount + "秒内输入验证码");
    }
}