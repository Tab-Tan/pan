$(document).ready(function () {

    //上传测试
    $("#up").click(function () {
        var formData = new FormData($("#formData")[0]);
        $.ajax({
            data:formData,
            type:"POST",
            url:"/panFile/upload/1",
            contentType:false,
            processData: false,
            success:function (data) {
                if (data==1){
                    alert("上传成功!")
                }
            }
        });
    });

    //下载测试
    $.get("/panFile/queryfile",function (files) {

       $.each(files,function (i) {
            $("#tb").append("<tr>" +
                "<td><input name='ap' type='checkbox' value='"+files[i].id+"' style='border: none'/></td>" +
                "<td><input type='text' value='"+files[i].colid+"' style='border: none' disabled/></td>" +
                "<td><input type='text' value='"+files[i].fname+"' style='border: none' disabled/></td>" +
                "<td><input type='text' value='"+files[i].count+"' style='border: none' disabled/></td>" +
                "<td><a class='btn btn-success' href='/panFile/download/"+files[i].id+"' id='"+i+"'>下载</a></td>" +
                "</tr>");
            $("#h"+i).attr('value',files[i].id);
       });
    });
    //删除测试
    $("#del").click(function () {
        let ids = "";
        $("input[name='ap']:checked").each(function () {
           ids += $(this).val()+","
        });
        $.get("/panFile/deleteFile/"+ids,function (i) {
            if(i<1){
                alert("删除失败！");
            }else {
                alert("成功删除:"+i+"条数据！");
            }
        })
    });
    //======================社区功能======================
    $.get("/share/queryopen",function (files) {

        $.each(files,function (i) {
            $("#stb").append("<tr>" +
                "<td><input name='sap' type='checkbox' value='"+files[i].id+"' style='border: none'/></td>" +
                "<td><input type='text' value='"+files[i].colid+"' style='border: none' disabled/></td>" +
                "<td><input type='text' value='"+files[i].fname+"' style='border: none' disabled/></td>" +
                "<td><input type='text' value='"+files[i].count+"' style='border: none' disabled/></td>" +
                "<td><a class='btn btn-success' href='/panFile/download/"+files[i].id+"' id='s"+i+"'>下载</a></td>" +
                "</tr>");
            $("#sh"+i).attr('value',files[i].id);
        });
    });
});