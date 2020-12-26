<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0" />
    <title></title>
    <link rel="stylesheet" href="css/viewer.min.css" />
    <link rel="stylesheet" href="css/loading.css" />
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="bootstrap-table/bootstrap-table.min.css" />
    <script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="js/jquery.form.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrap-table/bootstrap-table.min.js"></script>

    <link type="text/css" rel="stylesheet" href="bootstrap-fileinput/css/fileinput.css" />
    <script type="text/javascript" src="bootstrap-fileinput/js/fileinput.js"></script>
    <script type="text/javascript" src="bootstrap-fileinput/js/locales/zh.js"></script>
<body>
<h1>文件预览项目接入和测试界面</h1>
<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion"
                   href="#collapseOne">
                    接入说明
                </a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse">
            <div class="panel-body">
                <div>
                    如果你的项目需要接入文件预览项目，达到对docx、excel、ppt、jpg等文件的预览效果，那么通过在你的项目中加入下面的代码就可以
                    成功实现：
                    <pre style="background-color: #2f332a;color: #cccccc">
var url = 'http://127.0.0.1:8080/file/test.txt'; //要预览文件的访问地址
window.open('http://127.0.0.1:8012/onlinePreview?url='+encodeURIComponent(url));
                    </pre>
                </div>
                <div>
                    新增多图片同时预览功能，接口如下：
                    <pre style="background-color: #2f332a;color: #cccccc">
var fileUrl =url1+"|"+"url2";//多文件使用“|”字符隔开
window.open('http://127.0.0.1:8012/picturesPreview?urls='+encodeURIComponent(fileUrl));
                    </pre>
                </div>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion"
                   href="#collapseTwo">
                    预览测试
                </a>
            </h4>
        </div>
        <div id="collapseTwo" class="panel-collapse collapse">
            <div class="panel-body">
                <div style="padding: 10px">
                    <form enctype="multipart/form-data" id="fileUpload">
                        <input type="file" name="file" />
                        <input type="button" id="btnsubmit" value=" 上 传 " />
                    </form>
                </div>
                <div>
                    <table id="table" data-pagination="true"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    导入图纸excel
</button>
<#--模态框（Modal）-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    ×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    excel导入
                </h4>
            </div>
            <div class="modal-body"><!-- 在这里添加一些文本 -->
                <form id="importFile" name="importFile" class="form-horizontal" method="post"
                      enctype="multipart/form-data">
                    <div>
                        <label class="control-label">请选择要导入的excel文件：</label>
                        <input id="excelFile" name="file" class="file-loading" type="file" multiple accept=".xls,.xlsx">
                    </div>
                </form>

            </div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<#--<button class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#myModalc">
    导入组子件图纸excel
</button>-->
<button class="btn btn-primary" data-toggle="modal" data-target="#myModalc">
    导入组子件图纸excel
</button>
<#--模态框（Modal）-->
<div class="modal fade" id="myModalc" tabindex="-1" role="dialog" aria-labelledby="myModalLabelc" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    ×
                </button>
                <h4 class="modal-title" id="myModalLabelc">
                    组子件excel导入
                </h4>
            </div>
            <div class="modal-body"><!-- 在这里添加一些文本 -->
                <form id="importFilec" name="importFilec" class="form-horizontal" method="post"
                      enctype="multipart/form-data">
                    <div>
                        <label class="control-label">请选择要导入的excel文件：</label>
                        <input id="childexcelFile" name="file" class="file-loading" type="file" multiple accept=".xls,.xlsx">
                    </div>
                </form>

            </div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script type="text/javascript">
    //批量导入excel
    initUpload("excelFile","excelFileUpload");
    function initUpload(ctrlName,uploadUrl){
        var control = $("#"+ctrlName);
        control.fileinput({
            language:"zh",//设置语言
            uploadUrl:uploadUrl,//上传的地址
            uploadAsync:true,//默认异步上传
            showCaption:true,//是否显示标题
            showUpload:true,//是否显示上传按钮
            browseClass:"btn btn-primary",//按钮样式
            allowedFileExtensions: ["xls", "xlsx"], //接收的文件后缀
            showPreview: true, //是否显示预览
     		allowPreviewTypes:null,//是否显示预览
            previewFileIconSettings:{
                'docx':'<i class="glyphicon glyphcion-file"></i>',
                'xlsx':'<i class="glyphicon glyphcion-file"></i>',
                'pptx':'<i class="glyphicon glyphcion-file"></i>',
                'jpg':'<i class="glyphicon glyphcion-picture"></i>',
                'pdf':'<i class="glyphicon glyphcion-file"></i>',
                'zip':'<i class="glyphicon glyphcion-file"></i>',
            },
            minImageWidth: 50, //图片的最小宽度
            minImageHeight: 50,//图片的最小高度
            maxImageWidth: 1000,//图片的最大宽度
            maxImageHeight: 1000,//图片的最大高度
            maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
            minFileCount: 1, //每次上传允许的最少文件数。如果设置为0，则表示文件数是可选的。默认为0
            maxFileCount: 0, //每次上传允许的最大文件数。如果设置为0，则表示允许的文件数是无限制的。默认为0
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",//当检测到用于预览的不可读文件类型时，将在每个预览文件缩略图中显示的图标。默认为<i class="glyphicon glyphicon-file"></i>
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",//字符串，当文件数超过设置的最大计数时显示的消息 maxFileCount。默认为：选择上传的文件数（{n}）超出了允许的最大限制{m}。请重试您的上传！
            uploadExtraData:function(){
                var extraValue = "test";
                return {"excelType": extraValue};
            },
            layoutTemplates:{
                /*actionUpload:'',//去除上传预览缩略图中的上传图片
                actionZoom:'',   //去除上传预览缩略图中的查看详情预览的缩略图标
                actionDownload:'' ,//去除上传预览缩略图中的下载图标
                actionDelete:'', //去除上传预览的缩略图中的删除图标*/
            },//对象用于渲染布局的每个部分的模板配置。您可以设置以下模板来控制窗口小部件布局.eg:去除上传图标
        }).on('filebatchpreupload', function(event, data) { //该方法将在上传之前触发
        /*var id = $('#id option:selected').val();
        if(id == 0){
            return {
                message: "请选择", // 验证错误信息在上传前要显示。如果设置了这个设置，插件会在调用时自动中止上传，并将其显示为错误消息。您可以使用此属性来读取文件并执行自己的自定义验证
                data:{} // any other data to send that can be referred in `filecustomerror`
            };
        }*/
        });
    }

    $("#excelFile").on("fileuploaded",function(exevt,data,previewId,index){
        console.log("data:"+data.response.message);
        console.info(data);
        if(200 == data.response.code){
            alert("导入成功！"+data.response.message);
            $("#excelFile").fileinput("clear");
            $("#excelFile").fileinput("reset");
            $("#excelFile").fileinput("refresh");
            $("#excelFile").fileinput("enable");
            $(".close").click();
            $("#reload").click();
        }else{
            alert("导入失败:"+data.response.msg);
            $("#excelFile").fileinput("clear");
            $("#excelFile").fileinput("reset");
            $("#excelFile").fileinput("refresh");
            $("#excelFile").fileinput("enable");
        }
    });


    //批量导入excel
    initUpload("childexcelFile","excelChilddrawingsFileUpload");
    function initUpload(ctrlName,uploadUrl){
        var control = $("#"+ctrlName);
        control.fileinput({
            language:"zh",//设置语言
            uploadUrl:uploadUrl,//上传的地址
            uploadAsync:true,//默认异步上传
            showCaption:true,//是否显示标题
            showUpload:true,//是否显示上传按钮
            browseClass:"btn btn-primary",//按钮样式
            allowedFileExtensions: ["xls", "xlsx"], //接收的文件后缀
            showPreview: true, //是否显示预览
            allowPreviewTypes:null,//是否显示预览
            previewFileIconSettings:{
                'docx':'<i class="glyphicon glyphcion-file"></i>',
                'xlsx':'<i class="glyphicon glyphcion-file"></i>',
                'pptx':'<i class="glyphicon glyphcion-file"></i>',
                'jpg':'<i class="glyphicon glyphcion-picture"></i>',
                'pdf':'<i class="glyphicon glyphcion-file"></i>',
                'zip':'<i class="glyphicon glyphcion-file"></i>',
            },
            minImageWidth: 50, //图片的最小宽度
            minImageHeight: 50,//图片的最小高度
            maxImageWidth: 1000,//图片的最大宽度
            maxImageHeight: 1000,//图片的最大高度
            maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
            minFileCount: 1, //每次上传允许的最少文件数。如果设置为0，则表示文件数是可选的。默认为0
            maxFileCount: 0, //每次上传允许的最大文件数。如果设置为0，则表示允许的文件数是无限制的。默认为0
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",//当检测到用于预览的不可读文件类型时，将在每个预览文件缩略图中显示的图标。默认为<i class="glyphicon glyphicon-file"></i>
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",//字符串，当文件数超过设置的最大计数时显示的消息 maxFileCount。默认为：选择上传的文件数（{n}）超出了允许的最大限制{m}。请重试您的上传！
            uploadExtraData:function(){
                var extraValue = "test";
                return {"excelType": extraValue};
            },
            layoutTemplates:{
                /*actionUpload:'',//去除上传预览缩略图中的上传图片
                actionZoom:'',   //去除上传预览缩略图中的查看详情预览的缩略图标
                actionDownload:'' ,//去除上传预览缩略图中的下载图标
                actionDelete:'', //去除上传预览的缩略图中的删除图标*/
            },//对象用于渲染布局的每个部分的模板配置。您可以设置以下模板来控制窗口小部件布局.eg:去除上传图标
        }).on('filebatchpreupload', function(event, data) { //该方法将在上传之前触发
            /*var id = $('#id option:selected').val();
            if(id == 0){
                return {
                    message: "请选择", // 验证错误信息在上传前要显示。如果设置了这个设置，插件会在调用时自动中止上传，并将其显示为错误消息。您可以使用此属性来读取文件并执行自己的自定义验证
                    data:{} // any other data to send that can be referred in `filecustomerror`
                };
            }*/
        });
    }

    $("#childexcelFile").on("fileuploaded",function(exevt,data,previewId,index){
        console.log("data:"+data.response.message);
        console.info(data);
        if(200 == data.response.code){
            alert("导入成功！"+data.response.message);
            $("#childexcelFile").fileinput("clear");
            $("#childexcelFile").fileinput("reset");
            $("#childexcelFile").fileinput("refresh");
            $("#childexcelFile").fileinput("enable");
            $(".close").click();
            $("#reload").click();
        }else{
            alert("导入失败:"+data.response.msg);
            $("#childexcelFile").fileinput("clear");
            $("#childexcelFile").fileinput("reset");
            $("#childexcelFile").fileinput("refresh");
            $("#childexcelFile").fileinput("enable");
        }
    });
</script>
<script>
    function deleteFile(fileName) {
        $.ajax({
            url: '${baseUrl}deleteFile?fileName=' + encodeURIComponent(fileName),
            success: function (data) {
                // 删除完成，刷新table
                if (1 == data.code) {
                    alert(data.msg);
                } else{
                    $('#table').bootstrapTable('refresh', {});
                }
            },
            error: function (data) {
                console.log(data);
            }
        })
    }

    function downloadFile(fileName) {
       window.open('${baseUrl}downloadFile?fileName=' + encodeURIComponent(fileName))
    }
    $(function () {
        $('#table').bootstrapTable({
            url: '${baseUrl}listFiles',
            columns: [{
                field: 'fileName',
                title: '文件名'
            }, {
                field: 'action',
                title: '操作'
            },]
        }).on('pre-body.bs.table', function (e,data) {
            console.log(data)
            // 每个data添加一列用来操作
            $(data).each(function (index, item) {
                item.action = "<a class='btn btn-default' target='_blank' href='${baseUrl}onlinePreview?url="+ encodeURIComponent('${baseUrl}' + item.fileName) +"'>预览</a>" +
                    "<a class='btn btn-default' href='javascript:void(0);' onclick='deleteFile(\""+item.fileName+"\")'>删除</a>"+
                    "<a class='btn btn-default' href='javascript:void(0);' onclick='downloadFile(\""+item.fileName+"\")'>下载</a>";
            });
            return data;
        }).on('post-body.bs.table', function (e,data) {
            return data;
        });


        function showLoadingDiv() {
            var height = window.document.documentElement.clientHeight - 1;
            $(".loading_container").css("height", height).show();
        }

        $("#btnsubmit").click(function () {
            showLoadingDiv();
            $("#fileUpload").ajaxSubmit({
                success: function (data) {
                    // 上传完成，刷新table
                    if (1 == data.code) {
                        alert(data.msg);
                    } else {
                        $('#table').bootstrapTable('refresh', {});
                    }
                    $(".loading_container").hide();
                },
                error: function () {
                    alert('上传失败，请联系管理员');
                    $(".loading_container").hide();
                },
                url: 'fileUpload', /*设置post提交到的页面*/
                type: "post", /*设置表单以post方法提交*/
                dataType: "json" /*设置返回值类型为文本*/
            });
        });
    });
</script>
</body>
</html>