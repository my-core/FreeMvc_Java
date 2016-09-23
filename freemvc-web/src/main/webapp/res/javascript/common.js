/*公共JS类*/

//显示当前时间
function ShowTime(obj) {
    var now_time = new Date();
    var years = now_time.getFullYear();
    var months = now_time.getMonth();
    var dates = now_time.getDate();
    var days = now_time.getDay();
    var today = years + "年" + (months + 1) + "月" + dates + "日";
    var weeks;
    if (days == 0)
        weeks = "星期日";
    if (days == 1)
        weeks = "星期一";
    if (days == 2)
        weeks = "星期二";
    if (days == 3)
        weeks = "星期三";
    if (days == 4)
        weeks = "星期四";
    if (days == 5)
        weeks = "星期五";
    if (days == 6)
        weeks = "星期六";
    var hours = now_time.getHours();
    var minutes = now_time.getMinutes();
    var seconds = now_time.getSeconds();
    var timer = hours;
    timer += ((minutes < 10) ? ":0" : ":") + minutes;
    timer += ((seconds < 10) ? ":0" : ":") + seconds;
    var doc = document.getElementById(obj);
    doc.innerHTML = today + " " + timer + " " + weeks;
    setTimeout("ShowTime('" + obj + "')", 1000);
}



//公用的操作回调方法(result对应Yandex.Web.Models.AjaxResult)
//执行ajax
function DoAjax(url, data) {
    ShowLoading();
    $.ajax({
        url: url,
        data: data,
        dataType: 'json',
        type: 'POST',
        success: function (d) {
            if (Callback != null)
                Callback(d);
            CloseLoading();
        }
    });
}
function Callback(result) {
    if (result.isOk) {
        layer.alert(result.msg, { icon: 1, shadeClose: false, title: '操作提示' }, function () {
            if (result.data != null && result.data != '')
                location.href = result.data;
            else
                location.reload();
        });

    }
    else {
        layer.alert(result.msg, { icon: 2, shadeClose: true, title: '操作提示' });
    }
}
//公用的删除数据方法
function Delete(url) {
    layer.confirm('确认是否要删除？', {
        btn: ['确认', '取消'] //按钮
    }, function () {
        //确认
        DoAjax(url,null);
    }, function () {
        //取消
    });
}

/*layer相关方法
=================================*/
var loadi;
//需关闭加载层时，执行layer.close(loadi)即可
function ShowLoading() {
    loadi = layer.load(0, { time: 15 * 1000 });//设定最长等待15秒 
}
//关闭加载层
function CloseLoading() {
    layer.close(loadi);
}

