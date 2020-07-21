$(document).ready(
    function () {
        $.ajax({
            type:"post",
            url:"/query",
            success:function (data) {
               // var json =  JSON.parse(data);
              $("#tb").html("<tr>" +
                  "<td><input id='username' type='text' style='width:50px;border: none' value='"+data.username+"' required /></td>" +
                  "<td><input id='password' style='border: none;width:65px' value='"+data.password+"' required/></td>" +
                  "<td><input id='nikename' style='border: none;width:65px' value='"+data.nikename+"' required/></td>" +
                  "<td><input id='signature' style='border: none;width:120px' value='"+data.signature+"' required/></td>" +
                  "</tr>");
            }
        });

        $("#xg").click(function () {
         var username = encodeURI(encodeURIComponent( $("#username").val()));
         var password =  encodeURI(encodeURIComponent( $("#password").val()));
         var nikename =  encodeURI(encodeURIComponent( $("#nikename").val()));
         var signature =  encodeURI(encodeURIComponent( $("#signature").val()));
         var data = username+","+password+","+nikename+","+signature;
            $.ajax({
                type: "POST",
                url:"/update",
                data:"data="+data,
                success:function (data) {
                    var i = JSON.parse(data);
                    if (i===0){
                        alert("修改失败！");
                    }else {
                        alert("修改成功!");
                    }
                }
            });
        });
    }
);