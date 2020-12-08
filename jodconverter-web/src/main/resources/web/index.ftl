<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="favicon.ico" type="image/ico">
    <title></title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <!--<link rel="stylesheet" href="/bootstrap/bootstrap-table/bootstrap-table.css">-->

    <!--在线音乐播放功能-->
    <link rel="stylesheet" href="/aplayer/APlayer.min.css">
    <script src="/aplayer/APlayer.min.js"></script>

    <script src="/js/jquery.min.js"></script>
    <!--<script src="/js/jquery.zclip.js"></script>-->
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <!--<script src="/bootstrap/bootstrap-table/bootstrap-table.js"></script>-->
    <!--<script src="/bootstrap/bootstrap-table/bootstrap-table-zh-CN.js"></script>-->
    <script src="/webuploader/webuploader.js"></script>
    <!--剪切板的功能-->
    <script src="/js/clipboard.min.js"></script>

    <link rel="stylesheet" href="css/pdfh5.css" />

    <script src="js/pdf.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/pdf.worker.js" type="text/javascript" charset="utf-8"></script>
    <#--<script src="js/jquery-2.1.1.min.js" type="text/javascript" charset="utf-8"></script>-->
    <script src="js/pdfh5.js" type="text/javascript" charset="utf-8"></script>

    <style>
        a {
            font-family: "微软雅黑";
            cursor: pointer;
        }

        a.list-group-item:hover {
            background-color: rgba(51, 150, 200, 0.8);
        }

        tr {
            font-family: "微软雅黑";
        }

        .blur {
            filter: url(blur.svg#blur); /* FireFox, Chrome, Opera */
            -webkit-filter: blur(7px); /* Chrome, Opera */
            -moz-filter: blur(7px);
            -ms-filter: blur(7px);
            filter: blur(7px);
            filter: progid:DXImageTransform.Microsoft.Blur(PixelRadius=7, MakeShadow=false); /* IE6~IE9 */
        }

        .loading {
            width: 100%;
            height: 100%;
            position: fixed;
            top: 0%;
            left: 0%;
            line-height: 56px;
            background: #000;
            color: #fff;
            padding-left: 60px;
            font-size: 15px;
            opacity: 0.7;
            z-index: 9999;
            filter: progid:DXImageTransform.Microsoft.Alpha(opacity=70);
        }
        .input-group[class*="col-"] {
            float: right;
            padding-right: 20px;
        }
        /* 媒体查询：适配移动端(0-480px屏幕)的样式 */
        @media only screen and (max-width: 480px) {
            .input-group {
                margin-top: 7px !important;
            }
        }
        .strogeSpaceBar{background: #4cae4c; height: 20px;text-align: center;font-weight: bold;font-family: 'Microsoft Yahei'; color: #FFF;}
    </style>

<body>
<div id="loading" class="loading" style="display: none;">
    <div style="background:url(images/loading.gif) no-repeat 10px 50%;
            width:56px;
            height:56px;
            position: absolute;
            top:50%;
            left:40%;
            ">
    </div>
    <p style="position: absolute;top:50%;left:45%;">文件生成中，请稍候……</p>
</div>
<#--<div id="imgbackground" class="blur"
     style="background: url('images/bg1.jpg');top:0; position: fixed;width: 100%;height: 100%;z-index: -1;">
</div>-->
<div id="container" class="container"
     style="width: 90%;margin-top:20px;margin-bottom: 20px; background-color: rgba(255,255,255,0.7);border-radius: 10px;">
    <#--<div class="header clearfix" style="margin: 0px; ">
        <img src="images/pan-top.png" style="max-height: 55px;">
        <span>
                <ul class="nav nav-pills pull-right" style="margin-top: 10px;">
                    <li role="presentation"><a id="userLName" href="/" th:text="${author}"
                                               style="color: firebrick;background: unset;"></a></li>
                    <li id="homeBtn" role="presentation"><a href="/">主页</a></li>
                    <li id="contactBtn" role="presentation"><a data-toggle="modal" data-target="#donateDlg">捐助</a></li>
                    <li id="quitBtn" role="presentation"><a style="cursor: pointer">退出</a></li>
                </ul>
            </span>
    </div>-->
    <div id="player_music"></div>
    <div id="demo"></div>
    <div class="row" style="margin-top: 15px;">
        <div class="col-sm-12">
            <div class="btn-group" role="group" aria-label="...">
                <button class="btn btn-default" data-toggle="modal" data-target="#uploadModal"><i
                            class="glyphicon glyphicon-upload"></i> 上传文件
                </button>
                &nbsp;&nbsp;
            </div>
            <button class="btn btn-default" data-toggle="modal" data-target="#createDirDlg"><i
                        class="glyphicon glyphicon-folder-open"></i> 新建文件夹
            </button>
            &nbsp;&nbsp;
            <button class="btn btn-default" onclick="refreshUserFileList();"><i class="glyphicon glyphicon-refresh"></i>
                刷新
            </button>
            &nbsp;&nbsp;
            <button class="btn btn-default" onclick="onekeymusic();"><i class="glyphicon glyphicon-music"></i>
                一键音乐播放
            </button>

            <button id="copyIeplayLink" style="display: none" class="btn btn-primary"></button>

            <div class="input-group col-sm-3" >
                <input type="text" id="find" autocomplete="off"
                       class="form-control" placeholder="搜索当前目录" />
                <span class="input-group-btn">
               <input type="button" id="search" class="btn btn-info btn-search"
                      onclick="findfile()" value="搜索"/>
            </span>
            </div>

        </div>
    </div>
    <br/>
    <!-- /.row -->

    <ol id="storgeBread" class="breadcrumb mybc" style="text-align: center;">
        <div id="totalSpace" style="background-color: #8c8c8c; text-align: left;height: 20px;margin-top: 10px;border: 2px solid #6b6b6b;border-radius: 15px;">
            <div id="freeSpace" class="strogeSpaceBar" style="width:0%;border-right: 3px solid white;height: 100%;border-radius: 15px;">0 GB</div>
        </div>
        <p id="totalSpaceInfo" style="display: inline-block;font-weight: bold;font-family: 'Microsoft Yahei';text-align: right; margin-top: 10px">0 GB / 0 GB / 0 GB （剩余 / 已用 / 总容量）</p>
    </ol>
    <ol id="breadcrumb" class="breadcrumb mybc">
        <li onclick="jumpToRootPath()"><a>根目录</a></li>
    </ol>

    <div id="table_file_bg" class="table-responsive" style="max-height: 500px;overflow: auto;">
        <table id="table_filelist" class="table table-hover">
            <thead>
            <tr>
                <th style="width: 35px;vertical-align: middle;"></th>
                <th>文件</th>
                <th>大小</th>
                <th>修改时间</th>
                <th></th>
                <th></th>
                <th>操作</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
        </table>
    </div>

    <!-- Modal 文件上传-->
    <div class="modal fade" id="uploadModal" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">上传文件</h4>
                </div>
                <div class="modal-body">
                    <div id="file_drop_target" style="font-size: 20px;">
                        <h2 id="upload_file_path">请选择要上传的文件</h2>
                        <br/><br/>
                        <button id="pickerbtn" class="btn btn-info btn-lg active">选择文件
                            <button id="picker" class="hide" multiple></button>
                        </button>
                        &nbsp;&nbsp;
                        <button id="uploadbtn" class="btn btn-info btn-lg active">开始上传
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal 捐助我们-->
    <div class="modal fade" id="donateDlg" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">捐助我们</h4>
                </div>
                <div class="modal-body" style="text-align: center;">
                    <img src="images/cf_code.jpg" style="max-height: 350px;display: inline-block">
                    <img src="images/jfz_code.jpg" style="max-height: 350px;display: inline-block">
                </div>
            </div>
        </div>
    </div>

    <!-- Modal 图片预览-->
    <div class="modal fade" id="imgviewDlg" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">图片预览</h4>
                </div>
                <div class="modal-body" style="text-align: center;">
                    <img id="imgview" src="images/cf_code.jpg" style="max-height: 350px;display: inline-block">
                    <!--                    <img src="images/jfz_code.jpg" style="max-height: 350px;display: inline-block">-->
                </div>
            </div>
        </div>
    </div>

    <!-- Modal 建立新文件夹-->
    <div class="modal fade" id="createDirDlg" role="dialog">
        <div class="modal-dialog modal-lg" style="width:60%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">新建文件夹</h4>
                </div>
                <div class="modal-body" style="text-align: center;">
                    <h4 style="text-align: left;">输入新文件夹的名字：</h4>
                    <input id="newDirText" type="text" class="form-control" data-options="required:true">
                    <br>
                    <button id="confirmDirBtn" class="btn btn-primary">确定</button>
                    <button id="closeDirBtn" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal 分享功能-->
    <div class="modal fade" id="getcodeDlg" role="dialog">
        <div class="modal-dialog modal-lg" style="width:60%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">获取下载码</h4>
                </div>
                <div class="modal-body" style="text-align: left;">
                    <h4>要分享的文件：
                        <span id="shareSelectedFile" style="font-family: '微软雅黑';font-size: 16px"></span>
                    </h4>
                    <h4>
                        <span style="font-family: '微软雅黑';">请选择文件分享的有效期： </span>
                        &nbsp;&nbsp;
                        <span id="selectExpireDay"></span>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span class="checkbox" style="display: inline-block;">
                            <label>
                                <input id="outer_share" type="checkbox"> 外网分享
                            </label>
                        </span>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button id="createLink" class="btn btn-primary">创建链接</button>
                    </h4>

                    <div id="sharetext" style="display:none;">
                        <h4 style="text-align: left;">下载地址：</h4>
                        <span style="position: relative;"><a id="shareLink" style="word-wrap: break-word;" target="_blank"></a></span>
                        <h4 style="text-align: left;">提取码：</h4>
                        <span style="position: relative;"><a id="fetchSecret"></a></span>
                        <!--target="_blank"-->
                        <br>
                    </div>
                    <div id="shareLinkCopyCancel" style="margin-top: 10px;text-align: center;display: none">
                        <button id="copyLinkBtn" class="btn btn-primary"  data-clipboard-action="copy">一键复制</button>
                        <button id="closeLinkBtn" class="btn btn-default" data-dismiss="modal">取消分享</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="moveDlg" role="dialog" data-backdrop="static">
        <div class="modal-dialog modal-lg" style="width: 45%;height: 30%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">移动文件</h4>
                </div>
                <div class="modal-body">
                    <p id="moveSelectedFile" style="font-family: '微软雅黑';"></p>
                    <ol id="breadcrumbmove" class="breadcrumb mybc">
                        <li><a href="/">根目录</a></li>
                    </ol>
                    <div id="file_list_group" class="list-group">
                        <!--<a class="list-group-item active">根目录</a>-->
                        <!--<a href="#" class="list-group-item active">复制</a>-->
                        <!--<a href="#" class="list-group-item">图像的数量</a>-->
                    </div>
                    <div style="margin-top: 10px;text-align: center;">
                        <button id="setMoveBtn" class="btn btn-primary">确定</button>
                        <button id="closeMoveBtn" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--<footer class="footer" style="margin: 0px; margin-top: 40px;">-->
    <!--<p style="text-align: center; font-family: '微软雅黑'; color: red;">-->
    <!--异想家、国花制作，新年贺礼-->
    <!--</p>-->
    <!--</footer>-->
</div>

<script>
    var $chunkSize = 10*1024*1024, // 分片尺寸 10M
        $maxSingleSize = 1024*1024*1024, // 单文件最大尺寸
        $maxSize = 10*1024*1024*1024; // 所有文件最大尺寸
    $fileArray = new Array(), // 要上传的文件列表
        $nameArray = new Array(), // 文件名称
        count = 0;// 正在上传的文件在上传列表中的位置
    // uploader; // Web Uploader实例
    // var fileMd5=null;
    var tem;
    var username=$("#userLName").text();
    var create = 0;
    //生成链接的响应函数
    $('#createLink').click(function (e) {
        var expireDay_temp=$('input[name="rationExpireDay"]:checked').val();
        //去除空格
        var expireDay=expireDay_temp.replace(/(^\s*)|(\s*$)/g,"");
        $.ajax({
            type: "POST",
            url: "/generateShareLink",
            data: {fileName: tem, path: nowUserPath, expireDay: expireDay},
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    document.getElementById("sharetext").style.display="block";
                    document.getElementById("shareLinkCopyCancel").style.display="block";
                    var rootLink = window.location.host;
                    if($("#outer_share").is(":checked")){
                        rootLink = "cjpan.jfz.me";
                    }
                    var tgLink = "http://" + rootLink + "/sharefile?link=" + data.msg;
                    var tgReLink = tgLink.split("##");
                    $('#shareLink').text(tgReLink[0]);
                    $('#shareLink').attr({href: tgReLink[0]});
                    $("#fetchSecret").text(tgReLink[1]);
                }
            }
        });
    });

    $(function () {
        // 不支持ie浏览器
        if (isIE() == true) {
            alert("网站不支持ie内核的浏览器，请使用Chrome内核的浏览器，现在为您退出！");
            $("#quitBtn").click();
            window.opener = null;
            window.open('', '_self');
            window.close();
        }

        $("#userLName").text("您好，" + $("#userLName").text());
        // 刷新用户文件列表
        refreshUserFileList();
    });

    // 根目录路径
    var rootUserPath = "/";
    // 当前用户路径
    var nowUserPath = "/";
    // 当前用户路径
    var nowMovePath = "/";
    // 要移动的文件名
    var moveFile = {name: "", folder: false};

    // 音乐播放对象
    var apa = undefined;

    // 文件夹标识
    var folder_label = "文件夹";

    $('#quitBtn').click(function (e) {
        $.ajax({
            type: "GET",
            url: "/quit",
            dataType: "text",
            success: function (data) {
                window.location.href = "/";
            }
        });
    });

    $('#pickerbtn').click(function () {
        $('#picker input[type="file"]').click();
    });

    // 监听分块上传的三个事件
    WebUploader.Uploader.register({
        "before-send-file" : "beforeSendFile", // 所有分块上传之前
        "before-send" : "beforeSend", // 每个分块上传之前
        "after-send-file" : "afterSendFile" // 所有分块上传完成后
    }, {
        beforeSendFile: function (file) {
            var deferred = WebUploader.Deferred();
            // 计算文件的MD5
            (new WebUploader.Uploader()).md5File(file, 0, 10 * 1024 * 1024)
                // 及时显示进度
                .progress(function (percentage) {
                })
                // 计算完成，继续下一步
                .then(function (val) {
                    $nameArray.push(file.name);
                    // fileMd5=val;
                    deferred.resolve();
                });
            return deferred.promise();
        },
        beforeSend: function (block) {
            var deferred = WebUploader.Deferred();
            // 每个分块上传之前校验是否已上传
            var url = "/check",
                param = {
                    fileName: $nameArray[count],
                    // fileMd5: fileMd5,
                    chunk: block.chunk,
                    chunkSize: block.end - block.start
                };
            // 同步校验，防止没校验完就上传了
            $.ajaxSetup({async: false});
            $.post(url, param, function (data) {
                // 已上传则跳过，否则继续上传
                if (data.msg) {
                    // alert(data);
                    deferred.reject();
                } else {
                    // alert(data);
                    deferred.resolve();
                }
            });
            $.ajaxSetup({async: true});
            // this.owner.options.formData.fileMd5 = fileMd5;
            deferred.resolve();
            return deferred.promise();
        },
        afterSendFile: function () {
            // 所有分块上传完毕，通知后台合并分块
            // alert(nowUserPath);
            var url = "/merge",
                // 上传前设置其它参数
                param = {
                    path:nowUserPath,
                    // fileMd5: fileMd5,
                    fileName: $nameArray[count]
                };
            $.ajaxSetup({async: false});
            $.post(url, param, function (data) {
                count++;
                if (count <= $fileArray.length - 1) {
                    uploader.upload($fileArray[count].id);
                }
            });
            $.ajaxSetup({async: true});
        }
    })

    var uploader = WebUploader.create({
        // swf文件路径
        swf: 'webuploader/Uploader.swf',
        // 文件接收服务端。
        server: '/uploadsevlet',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker',
        resize: false,                               // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        duplicate: true,                              //是否可重复选择同一文件
        threads: 5,
        fileNumLimit: 10,                             // 发送限制单文件
        fileSingleSizeLimit: 20000 * 1024 * 1024,    // 20000M
        fileVal: "file"  ,                             //指明参数名称，后台也用这个参数接收文件
        chunkSize : $chunkSize, // 如果要分片，分多大一片？ 10M默认大小为5M
        chunked : true// 是否要分片处理大文件上传
    });
    // // 选择了文件后，在文件被添加进队列前
    // uploader.on( 'beforeFileQueued', function( file ) {             // 发送限制单文件
    //     var fnum = uploader.getFiles().length;                        // 如果有文件在队列中
    //     if(fnum>0) uploader.reset();                                  // 清除队列
    // });
    // 当有文件被添加进队列的时候
    uploader.on('fileQueued', function (file) {
        // $('#upload_file_path').val(file.name);
        // document.getElementById('upload_file_path').innerHTML = file.name;
        $('#upload_file_path').append('<div id="' + file.id + '" class="item">' +
            '<span class="info">文件： ' + file.name + '</span>' +
            '<span class="state">&nbsp;等待上传...</span>' +
            '</div>');
    });
    // 文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {
        var $li = $('#' + file.id),
            $percent = $li.find('.progress .progress-bar');

        // 避免重复创建
        if (!$percent.length) {
            $percent = $('<br/><br/><div class="progress progress-striped active">' +
                '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                '</div>' +
                '</div>').appendTo($li).find('.progress-bar');
        }
        $li.find('span.state').text('   上传中');
        $percent.css('width', percentage * 100 + '%');
    });
    uploader.on('error', function (type) {             // 选择文件出错
        if (type == "F_EXCEED_SIZE") {
            alert("附件不能大于20G");
        }
    });
    uploader.on('uploadComplete', function (file) {
        // $( '#'+file.id ).find('.progress').fadeOut();
        // $( '#'+file.id ).fadeOut();

        var nowStates = uploader.getStats();
        // uploader.reset();
        // uploader.removeFile(file.id,true);

        if (nowStates.progressNum == 0) {
            if (nowStates.uploadFailNum != 0) {
                alert(nowStates.uploadFailNum + '个文件上传失败！');
                $('#uploadModal').modal('hide');
                refreshUserFileList();
            }
            if (nowStates.successNum == uploader.getFiles().length) {
                // alert(nowStates.successNum + '个文件上传成功！');
                alert('所有文件成功上传！');
                $('#uploadModal').modal('hide');
                refreshUserFileList();
            }
            $('#upload_file_path').html("请选择要上传的文件");
            uploader.reset();
        }
    });
    uploader.on('uploadAccept', function (file, response) {
        if (response.success == false) {
            // 通过return false来告诉组件，此文件上传有错。
            alert('上传失败\r\n' + response.msg);
            $('#' + file.file.id).find('.state').text('   上传失败，失败原因：' + response.msg);
        }
        else {
            $('#' + file.file.id).find('.state').text('   上传中');
            // $("#output_table").html();

        }
    });

    $('#uploadbtn').on('click', function () {
        uploader.options.formData.path = nowUserPath;
        uploader.upload();
    });

    // 刷新文件列表
    function refreshUserFileList() {
        var cell_start = 1;
        var rowobj_a_start = 0;
        var title_list = $("#breadcrumb");
        title_list.empty();
        title_list.append('<li onclick="jumpToRootPath()"><a>根目录</a></li>');
        // <a href="/" onclick="jumpToUpperPath('/')">
        // 获取文件夹层级
        var folderList = nowUserPath.split("/");
        var folderListLen = folderList.length;
        // 清除空的切片
        for (var i = 0; i < folderListLen; i++) {
            if (folderList[i] == "") {
                folderList.splice(i, 1);//从第i个开始，删除1个字符
            }
        }
        if (nowUserPath != "/") {
            // 不是根目录的情况下，写入文件层级
            for (var i = 0; i < folderList.length; i++) {
                if (i != (folderList.length - 1)) {
                    title_list.append('<li><a onclick="jumpToUpperPath(this.innerText)">' + folderList[i] + '</a></li>');
                }
                // 最后一层的时候不触发事件
                else {
                    title_list.append('<li class="active" style="font-family: \'微软雅黑\';" onclick=" ;">' + folderList[i] + '</li>');
                }
            }
        }
        $.ajax({
            type: "GET",
            url: "/getspacesize",
            data: {},
            dataType: "json",
            success: function (data) {
                if (data.success){
                    var storgeinfo = data.msg;
                    var jsonstorgeinfo = $.parseJSON(storgeinfo);
                    var freepercentage = parseInt(Math.round(parseFloat(jsonstorgeinfo.freeSpace) / parseFloat(jsonstorgeinfo.totalSpace) * 100));
                    var usedpercentage = parseInt(100 - freepercentage);

                    if (freepercentage > 75)
                        $("#freeSpace").css("background-color","#4cae4c");
                    else if(freepercentage > 35 && freepercentage <= 75)
                        $("#freeSpace").css("background-color","#e2bf11");
                    else if(freepercentage <= 35)
                        $("#freeSpace").css("background-color","#ea2121");

                    var strFree = (freepercentage).toString() + "%";
                    var strUsed = (usedpercentage).toString() + "%";
                    // $("#freeSpace").width(strFree);
                    document.getElementById("freeSpace").style.width = strFree;
                    $("#freeSpace").text(jsonstorgeinfo.freeSpace + " GB");
                    // $("#usedSpace").width(strUsed);
                    $("#totalSpaceInfo").text(parseFloat(jsonstorgeinfo.freeSpace).toFixed(2) + " GB / " + (parseFloat(jsonstorgeinfo.totalSpace)-parseFloat(jsonstorgeinfo.freeSpace)).toFixed(2).toString()  +
                        "GB / " + parseFloat(jsonstorgeinfo.totalSpace).toFixed(2) + " GB （剩余 / 已用 / 总容量）");

                }
            }
        });

        $.ajax({
            type: "POST",
            url: "/userfilelist",
            data: {path: nowUserPath},
            dataType: "json",
            success: function (data) {
                // 将现在的表内容存储并清空
                var oTabNow = document.getElementById('table_filelist');
                var nowTabRowLen = oTabNow.rows.length;
                for (var i = 1; i < nowTabRowLen; i++) {
                    var rowObj = oTabNow.rows[1];
                    if (isIE()) {
                        rowObj.parentNode.removeChild(rowObj);
                    }
                    else {
                        rowObj.remove();
                    }
                }

                var hdfsMode = false;
                var downloadlist = new Array();
                if (data.length > 0) {
                    hdfsMode = data[0].link == "HDFS" ? true : false;
                }

                for (var i = 0; i < data.length; i++) {
                    var rowObj = oTabNow.insertRow(oTabNow.rows.length); // 添加一行
                    // var rowObj = oTabNow.insertRow(i+1); // 添加一行
                    // 判断是否为目录，是目录则去掉“/”
                    if (data[i].size.indexOf("Directory") != -1) {
                        data[i].name = data[i].name.replace("/", "");
                        data[i].size = folder_label;
                        rowObj.insertCell(0).innerHTML = '<img src="images/p_folder.png" style="height: 25px;">';
                    }
                    else {
                        rowObj.insertCell(0).innerHTML = '<img src="images/p_file.png" style="height: 25px;">';
                    }
//<a class='btn btn-default' target='_blank' href='${baseUrl}onlinePreview?url="+ encodeURIComponent('${baseUrl}' + item.fileName) +"'>预览</a>
                    rowObj.insertCell(cell_start).innerHTML = '<a >' + data[i].name + '</a>';
                    rowObj.insertCell(cell_start + 1).innerHTML = data[i].size;
                    rowObj.insertCell(cell_start + 2).innerHTML = data[i].time;
                    rowObj.insertCell(cell_start + 3).innerHTML = '<a>分享</a>';
                    rowObj.insertCell(cell_start + 4).innerHTML = '<a>移动</a>';
                    rowObj.insertCell(cell_start + 5).innerHTML = '<a>下载</a>';
                    rowObj.insertCell(cell_start + 6).innerHTML = '<a>重命名</a>';
                    rowObj.insertCell(cell_start + 7).innerHTML = '<a>删除</a>';
                    downloadlist.push(data[i].link);

                    // 文件夹操作响应事件
                    rowObj.getElementsByTagName('a')[0].onclick = function (event) {
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        // 如果已经处于重命名状态，就退出
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        if (tempName.indexOf("div") != -1) return;

                        // 去掉html元素
                        tempName = tempName.replace("<a>", "");
                        tempName = tempName.replace("</a>", "");

                        // 判断是否为目录
                        var tempSize = oTabNow.rows[tempIdx].cells[cell_start + 1].innerHTML;
                        if (tempSize.indexOf(folder_label) != -1) {
                            if (create === 1) {
                                // event.preventDefault();
                                return ;
                            }
                            create = 1;
                            nowUserPath += tempName + "/";
                            refreshUserFileList();
                            setTimeout(function(){ create = 0; }, 1000);
                        }
                        // 文件的话就下载
                        else {
                            var fileType = tempName.split(".");
                            fileType = fileType[fileType.length - 1];
                            fileType = fileType.toLowerCase();
                            if (fileType.indexOf("mp4") != -1 || fileType.indexOf("flv") != -1 || fileType.indexOf("mkv") != -1)
                            {
                                window.open("/onlineplayer?fileName=" + encodeURI(encodeURI(tempName)) + "&filePath=" + encodeURI(encodeURI(downloadlist[tempIdx - 1])));
                            }
                            else if (fileType.indexOf("mp3") != -1)
                            {
                                if (apa==undefined){
                                    var ap1 = new APlayer({
                                        container: document.getElementById('player_music'),
                                        autoplay: true,
                                        theme: '#FADFA3',
                                        fixed:true,
                                        audio: [{
                                            name: tempName,
                                            artist: username,
                                            url: downloadlist[tempIdx - 1],
                                            cover: 'images/aplayer.png'
                                        }]
                                    });
                                    apa = ap1;
                                }
                                else{
                                    // 获取当前播放列表所有文件名
                                    var musiclist = new Array();
                                    for (i in apa.list.audios){
                                        musiclist.push(apa.list.audios[i].name);
                                    }
                                    // 要播放的音频在列表里，直接跳转，不在就添加列表
                                    var musicidx = musiclist.indexOf(tempName);
                                    if (musicidx !=-1){
                                        apa.list.switch(musicidx);
                                    }
                                    else {
                                        apa.list.add([{
                                            name: tempName,
                                            artist: username,
                                            url: downloadlist[tempIdx - 1],
                                            cover: 'images/aplayer.png'
                                        }]);
                                        apa.list.switch(apa.list.audios.length-1);
                                    }
                                }
                            }
                            else if (fileType.indexOf("rmvb") != -1 || fileType.indexOf("3gp") != -1 || fileType.indexOf("rm") != -1 || fileType.indexOf("avi") != -1 || fileType.indexOf("wmv") != -1)
                            {
                                // 可以用IE播放的特殊处理
                                if(fileType.indexOf("avi") != -1 || fileType.indexOf("wmv") != -1 || fileType.indexOf("3gp") != -1){
                                    if(window.confirm("avi、3gp和wmv格式的文件不能用chrome浏览器在线播放，只支持IE浏览器的在线播放，是否继续播放？")) {
                                        // window.open("/onlineplayer?fileName=" + tempName + "&filePath=" + downloadlist[tempIdx - 1]);
                                        $("#copyIeplayLink").text("http://" + window.location.host + "/onlineplayer?fileName=" + encodeURI(encodeURI(tempName)) + "&filePath=" + encodeURI(encodeURI(downloadlist[tempIdx - 1])));
                                        $("#copyIeplayLink").click();
                                        return;
                                    }
                                }
                                else if(fileType.indexOf("rmvb") != -1 || fileType.indexOf("rm") != -1){
                                    if(window.confirm("rmvb和rm格式的文件在线播放可能会有小bug，并只支持chrome浏览器，是否继续播放？")) {
                                        window.open("/onlineplayer?fileName=" + encodeURI(encodeURI(tempName)) + "&filePath=" + encodeURI(encodeURI(downloadlist[tempIdx - 1])));
                                        return;
                                    }
                                }
                                var transcodestatus = data[tempIdx - 1].transcode;
                                if(transcodestatus=="transcoding") {
                                    alert("该视频正在转码中，请勿重复操作！查看进度可通过刷新页面并再次点击该文件进行！");
                                    return;
                                }
                                else if (transcodestatus=="failed") {
                                    alert("该视频曾转码失败，请使用本地转码工具进行转码！");
                                    return;
                                }
                                else if (transcodestatus=="complete") {
                                    alert("该视频已完成转码，在线播放请刷新页面后点mp4文件，下载请点击下载按钮！");
                                    return;
                                }
                                else if (transcodestatus=="transcodable") {
                                    if(window.confirm("该视频可转码为mp4后在线播放，是否需要转码？")) {
                                        $.ajax({
                                            type: "POST",
                                            url: "/videoconvert",
                                            data: {filepath: downloadlist[tempIdx - 1]},
                                            dataType: "json",
                                            success: function (data)
                                            {
                                                if (data.success) {
                                                    // alert("转码已完成，地址：" + data.msg);
                                                    refreshUserFileList();
                                                }
                                            }
                                        });
                                        alert("视频正在转码中，查看进度可通过刷新页面并再次点击该文件进行！");
                                    }
                                }
                            }
                            else if(fileType.indexOf("jpg") != -1 || fileType.indexOf("gif") != -1 || fileType.indexOf("png") != -1 || fileType.indexOf("jpeg") != -1 || fileType.indexOf("bmp") != -1)
                            {
                                document.getElementById("imgview").src=downloadlist[tempIdx - 1];
                                $('#imgviewDlg').modal('show');
                            }
                            else {
                                var baseurl='${baseUrl}';
                                var url = baseurl+downloadlist[tempIdx - 1]; //要预览文件的访问地址
                                //window.open(baseurl+'onlinePreview?url='+encodeURIComponent(url));
                                var pdfh5 = new Pdfh5('#demo', {
                                    pdfurl: baseurl+'onlinePreview?url='+encodeURIComponent(url)
                                });
                            }//oTabNow.rows[tempIdx].getElementsByTagName('a')[3].onclick();
                        }
                    }
                    // 分享操作响应事件
                    rowObj.getElementsByTagName('a')[1].onclick = function () {
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        // 如果已经处于重命名状态，就退出
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        if (tempName.indexOf("div") != -1) return;

                        // 去掉html元素
                        tempName = tempName.replace("<a>", "");
                        tempName = tempName.replace("</a>", "");
                        tem = tempName;
                        // 判断是否为目录
                        var tempSize = oTabNow.rows[tempIdx].cells[cell_start + 1].innerHTML;
                        // 是目录的时候
                        if (tempSize.indexOf(folder_label) != -1) {
                            alert("文件夹不支持分享哦！");
                            return;
                        }
                        //提交几天过期
                        $('#getcodeDlg').modal('show');
                        $("#shareLink").empty();
                        $("#fetchSecret").empty();
                        $('#shareSelectedFile').text(tempName);
                        $("#selectExpireDay").empty();
                        $('#selectExpireDay').append(" <input type='radio' name='rationExpireDay' value='永久有效' checked='checked'/>永久有效&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                        $('#selectExpireDay').append("<input type='radio' name='rationExpireDay'  value='7' />7天&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                        $('#selectExpireDay').append("<input type='radio' name='rationExpireDay' value='1' />1天");
                    }
                    // 移动操作响应事件
                    rowObj.getElementsByTagName('a')[2].onclick = function () {
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        // 如果已经处于重命名状态，就退出
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        if (tempName.indexOf("div") != -1) return;

                        var transcodestatus = data[tempIdx - 1].transcode;
                        if(transcodestatus=="transcoding") {
                            alert("该视频正在转码中，请勿移动！");
                            return;
                        }

                        // 去掉html元素
                        tempName = tempName.replace("<a>", "");
                        tempName = tempName.replace("</a>", "");

                        $("#moveDlg").modal('show');

                        // 判断是否为目录
                        var tempSize = oTabNow.rows[tempIdx].cells[cell_start + 1].innerHTML;
                        // 是目录的时候
                        if (tempSize.indexOf(folder_label) != -1) {
                            $("#moveSelectedFile").text("要移动的文件夹：" + tempName);
                            moveFile.folder = true;
                        }
                        else {
                            $("#moveSelectedFile").text("要移动的文件夹：" + tempName);
                            moveFile.folder = false;
                        }
                        moveFile.name = tempName;
                        nowMovePath = rootUserPath;
                        listUserFolder(rootUserPath);
                    }
                    // 下载操作响应事件
                    rowObj.getElementsByTagName('a')[3].onclick = function () {
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        // 如果已经处于重命名状态，就退出
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        if (tempName.indexOf("div") != -1) return;

                        // 去掉html元素
                        tempName = tempName.replace("<a>", "");
                        tempName = tempName.replace("</a>", "");

                        // 判断是否为目录
                        var tempSize = oTabNow.rows[tempIdx].cells[cell_start + 1].innerHTML;
                        // 是目录的时候
                        if (tempSize.indexOf(folder_label) != -1) {
                            alert("文件夹不支持下载哦！");
                            return;
                        }
                        // 不支持ie下载
                        if (isIE() == true) {
                            alert("不支持ie内核的浏览器下载，请使用Chrome内核的浏览器下载！");
                            return;
                        }
                        // hdfs模式使用请求下载
                        // 普通模式直接下载
                        if (hdfsMode) {
                            $("#loading").show();
                            $.ajax({
                                type: "POST",
                                url: "/download",
                                data: {fileName: tempName, path: nowUserPath},
                                dataType: "json",
                                success: function (data) {
                                    $("#loading").hide();
                                    if (data.success) {
                                        allDownloadFile(data.msg, tempName);
                                    }
                                }
                            });
                        }
                        else {
                            // window.downloadFile(downloadlist[tempIdx - 1]);
                            allDownloadFile(downloadlist[tempIdx - 1], tempName);
                        }
                    }
                    // 重命名操作响应事件
                    rowObj.getElementsByTagName('a')[4].onclick = function () {
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        var rowRename = oTabNow.rows[tempIdx].cells[cell_start];
                        // 如果已经处于重命名状态，就退出重命名
                        if (tempName.indexOf("div") != -1) return;

                        var transcodestatus = data[tempIdx - 1].transcode;
                        if(transcodestatus=="transcoding") {
                            alert("该视频正在转码中，请勿重命名！");
                            return;
                        }

                        // 去掉html元素
                        tempName = tempName.replace("<a>", "");
                        tempName = tempName.replace("</a>", "");
                        // 进入重命名模式
                        rowRename.innerHTML =
                            '<div class="input-group">' +
                            '<input  id="' + tempName + 'Id' + '" style="width: 120px; height: 29px" type="text" class = "form-control" data-options="required:true " value="' + tempName + '">&nbsp;&nbsp;' +
                            '<button id="' + tempName + 'BtnOK' + '" class = "glyphicon glyphicon-ok" style="height: 29px"></button>&nbsp;&nbsp;' +
                            '<button id="' + tempName + 'BtnRemove' + '" class = "glyphicon glyphicon-remove" style="height: 29px"></button>' +
                            '</div>'
                        // 确认重命名
                        rowRename.getElementsByTagName('button')[0].onclick = function () {
                            // rowRename.innerHTML = this.parentNode.childNodes[0].value;
                            var oldName = this.parentNode.childNodes[0].defaultValue;
                            var newName = this.parentNode.childNodes[0].value;
                            if (newName == "") {
                                rowRename.getElementsByTagName('button')[1].onclick();
                                return;
                            }
                            // 判断是否为目录
                            var tempSize = oTabNow.rows[tempIdx].cells[2].innerHTML;
                            // 是目录的时候
                            if (tempSize.indexOf(folder_label) != -1) {
                                $.ajax({
                                    type: "POST",
                                    url: "/filerename",
                                    data: {oldName: "@dir@", newName: newName, path: nowUserPath + oldName},
                                    dataType: "json",
                                    success: function (data) {
                                        refreshUserFileList();
                                    }
                                });
                            }
                            else {
                                $.ajax({
                                    type: "POST",
                                    url: "/filerename",
                                    data: {oldName: oldName, newName: newName, path: nowUserPath},
                                    dataType: "json",
                                    success: function (data) {
                                        refreshUserFileList();
                                        alert(data.msg);
                                    }
                                });
                            }
                        }
                        // 取消重命名
                        rowRename.getElementsByTagName('button')[1].onclick = function () {
                            rowRename.innerHTML = "<a>" + this.parentNode.childNodes[0].defaultValue + "</a>";
                        }
                    }
                    // 删除操作响应事件
                    rowObj.getElementsByTagName('a')[5].onclick = function () {
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        // 如果已经处于重命名状态，就退出
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        if (tempName.indexOf("div") != -1) return;

                        var transcodestatus = data[tempIdx - 1].transcode;
                        if(transcodestatus=="transcoding") {
                            alert("该视频正在转码中，请勿删除！");
                            return;
                        }

                        if(window.confirm("确定删除吗？")){
                            // 去掉html元素
                            tempName = tempName.replace("<a>", "");
                            tempName = tempName.replace("</a>", "");

                            // 判断是否为目录
                            var tempSize = oTabNow.rows[tempIdx].cells[cell_start + 1].innerHTML;
                            if (tempSize.indexOf(folder_label) != -1) {
                                $.ajax({
                                    type: "POST",
                                    url: "/filedelete",
                                    data: {fileName: "@dir@", path: nowUserPath + tempName},
                                    dataType: "json",
                                    success: function (data) {
                                        refreshUserFileList();
                                    }
                                });
                            }
                            else {
                                $.ajax({
                                    type: "POST",
                                    url: "/filedelete",
                                    data: {fileName: tempName, path: nowUserPath},
                                    dataType: "json",
                                    success: function (data) {
                                        refreshUserFileList();
                                    }
                                });
                            }
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        });
    }

    function jumpToRootPath() {
        nowUserPath = "/";
        refreshUserFileList();
    }

    function jumpToUpperPath(filePathName) {
        // 检查当前路径中是否含有目标路径
        var temp_index = nowUserPath.indexOf(filePathName);
        if (temp_index == -1) return;
        nowUserPath = nowUserPath.slice(0, temp_index) + filePathName + "/";
        refreshUserFileList();
    }

    $('#confirmDirBtn').on('click', function () {
        var newFolderName = $('#newDirText').val();
        if (newFolderName == "") return;
        $.ajax({
            type: "POST",
            url: "/dircreate",
            data: {dirName: newFolderName, path: nowUserPath},
            dataType: "json",
            success: function (data) {
                if (data.success == true) {
                    refreshUserFileList();
                }
            }
        });
        $('#createDirDlg').modal('hide');
    });

    function isIE() { //ie?
        if (!!window.ActiveXObject || "ActiveXObject" in window)
            return true;
        else
            return false;
    }

    //IE浏览器图片保存本地
    function SaveAs5(imgURL) {
        var oPop = window.open(imgURL, "", "width=1, height=1, top=5000, left=5000");
        for (; oPop.document.readyState != "complete";) {
            if (oPop.document.readyState == "complete") break;
        }
        oPop.document.execCommand("SaveAs");
        oPop.close();
    }

    // 生成下载连接函数
    function downloadFile(url, fileName_download) {
        try {
            var elemIF = document.createElement("a");
            elemIF.src = url;
            elemIF.href = url;
            elemIF.download = fileName_download;
            elemIF.style.display = "none";
            document.body.appendChild(elemIF);
            elemIF.click();
        } catch (e) {
            alert(e)
        }
        // window.open(url);
    }

    // 兼容所有浏览器的下载接口
    function allDownloadFile(url, fileName_download) {
        if (isIE()) {
            SaveAs5(url);
        }
        else {
            downloadFile(url, fileName_download);
        }
    }

    // 剪贴板响应函数
    var clipboard = new ClipboardJS('.btn-primary', {
        text: function(trigger) {
            if (trigger.id=="copyLinkBtn")
                return "下载地址：" + document.getElementById("shareLink").innerText+ "\n提取码：" + document.getElementById("fetchSecret").innerText;
            else if (trigger.id=="copyIeplayLink")
                return  $("#copyIeplayLink").text();
            else
                return;
        }
    });
    // 剪切成功响应函数
    clipboard.on('success', function(e) {
        if (e.trigger.id=="copyIeplayLink"){
            alert("已将播放链接复制到剪贴板，请打开IE浏览器查看！");
        }
        else
            alert("已复制到剪贴板！");
        e.clearSelection();
    });
    // 剪切失败响应函数
    clipboard.on('error', function(e) {
        alert("复制失败！");
    });

    // 移动到里面的跳转上级文件夹
    function jumpToMoveUpperPath(filePathName) {
        // 检查当前路径中是否含有目标路径
        var temp_index = nowMovePath.indexOf(filePathName);
        if (temp_index == -1) return;
        nowMovePath = nowMovePath.slice(0, temp_index) + filePathName + "/";
        listUserFolder(nowMovePath);
    }

    // 根据路径获取文件夹结构
    function listUserFolder(path_in) {
        var title_list = $("#breadcrumbmove");
        title_list.empty();
        title_list.append('<li><a onclick="nowMovePath=rootUserPath;listUserFolder(nowMovePath);">根目录</a></li>');
        // 获取文件夹层级
        var folderList = nowMovePath.split("/");
        var folderListLen = folderList.length;
        // 清除空的切片
        for (var i = 0; i < folderListLen; i++) {
            if (folderList[i] == "") {
                folderList.splice(i, 1);
            }
        }
        if (nowMovePath != "/") {
            // 不是根目录的情况下，写入文件层级
            for (var i = 0; i < folderList.length; i++) {
                if (i != (folderList.length - 1)) {
                    title_list.append('<li><a onclick="jumpToMoveUpperPath(this.innerText)">' + folderList[i] + '</a></li>');
                }
                // 最后一层的时候不触发事件
                else {
                    title_list.append('<li class="active" style="font-family: \'微软雅黑\';" onclick=" ;">' + folderList[i] + '</li>');
                }

            }
        }
        $("#file_list_group").html("");

        $.ajax({
            type: "POST",
            url: "/userfilelist",
            data: {path: path_in},
            dataType: "json",
            success: function (data) {
                var activeObj = $("#file_list_group");
                for (var i = 0; i < data.length; i++) {
                    // 判断是否为目录，是目录则去掉“/”
                    if (data[i].size.indexOf("Directory") != -1) {
                        data[i].name = data[i].name.replace("/", "");
                        activeObj.append('<a class="list-group-item">' +
                            '<img src="images/p_folder.png" style="height: 25px;margin-right: 15px;">' +
                            data[i].name + '</a>');
                    }
                }
                activeObj.find('a').each(function (index) {
                    $(this).on('click', function () {
                        nowMovePath += $(this).text() + "/";
                        listUserFolder(nowMovePath);
                    });
                });
            }
        });
    }

    $('#setMoveBtn').click(function () {
        var oldpath = nowUserPath;
        var newpath = nowMovePath;
        $.ajax({
            type: "POST",
            url: "/filemove",
            data: {
                fileName: ((moveFile.folder == true) ? "@dir@" : moveFile.name),
                oldPath: ((moveFile.folder == true) ? (oldpath + moveFile.name) : oldpath),
                newPath: newpath
            },
            dataType: "json",
            success: function (data) {
                if (data.success == true) {
                    alert("移动成功！");
                }
                else {
                    alert("移动失败！请稍候再试！");
                }
                $("#moveDlg").modal('hide');
                refreshUserFileList();
            }
        });
    });

    // 搜索响应函数
    $("#find").keydown(function(event){
        if(event.which == "13"){
            findfile();
        }
    });

    $("#newDirText").keydown(function(event){
        if(event.which == "13"){
            $("#confirmDirBtn").click();
        }
    });

    // 文件搜索核心函数
    function findfile() {
        var cell_start = 1;
        var rowobj_a_start = 0;
        var title_list = $("#breadcrumb");
        title_list.empty();
        title_list.append('<li><a href="/">根目录</a></li>');
        // 获取文件夹层级
        var folderList = nowUserPath.split("/");
        var folderListLen = folderList.length;
        // 清除空的切片
        for (var i = 0; i < folderListLen; i++) {
            if (folderList[i] == "") {
                folderList.splice(i, 1);//从第i个开始，删除1个字符
            }
        }
        if (nowUserPath != "/") {
            // 不是根目录的情况下，写入文件层级
            for (var i = 0; i < folderList.length; i++) {
                if (i != (folderList.length - 1)) {
                    title_list.append('<li><a onclick="jumpToUpperPath(this.innerText)">' + folderList[i] + '</a></li>');
                }
                // 最后一层的时候不触发事件
                else {
                    title_list.append('<li class="active" style="font-family: \'微软雅黑\';" onclick=" ;">' + folderList[i] + '</li>');
                }

            }
        }
        var input = $("#find").val();
        //alert(input);
        if (input == "") {
            alert("请输入搜索");
        } else
        {$.ajax({
            type: "POST",
            url: "/search",
            data: {key: input, path: nowUserPath},
            dataType: "json",
            success: function (data) {
                // 将现在的表内容存储并清空
                $("#breadcrumb").empty();
                $("#breadcrumb").append("<li onclick=\"jumpToRootPath()\"><a>返回上一级</a></li>")
                $("#breadcrumb").append(" <li value=input>搜索：" + input + "</li>");
                var oTabNow = document.getElementById('table_filelist');
                var nowTabRowLen = oTabNow.rows.length;
                for (var i = 1; i < nowTabRowLen; i++) {
                    var rowObj = oTabNow.rows[1];
                    if (isIE()) {
                        rowObj.parentNode.removeChild(rowObj);
                    }
                    else {
                        rowObj.remove();
                    }
                }
                var hdfsMode = false;
                var downloadlist = new Array();
                if (data.length > 0) {
                    hdfsMode = data[0].link == "HDFS" ? true : false;
                }

                for (var i = 0; i < data.length; i++) {
                    var rowObj = oTabNow.insertRow(oTabNow.rows.length); // 添加一行
                    // var rowObj = oTabNow.insertRow(i+1); // 添加一行
                    // 判断是否为目录，是目录则去掉“/”
                    if (data[i].size.indexOf("Directory") != -1) {
                        data[i].name = data[i].name.replace("/", "");
                        data[i].size = folder_label;
                        rowObj.insertCell(0).innerHTML = '<img src="images/p_folder.png" style="height: 25px;">';
                    }
                    else {
                        rowObj.insertCell(0).innerHTML = '<img src="images/p_file.png" style="height: 25px;">';
                    }

                    rowObj.insertCell(cell_start).innerHTML = '<a>' + data[i].name + '</a>';
                    rowObj.insertCell(cell_start + 1).innerHTML = data[i].size;
                    rowObj.insertCell(cell_start + 2).innerHTML = data[i].time;
                    rowObj.insertCell(cell_start + 3).innerHTML = '<a>分享</a>';
                    rowObj.insertCell(cell_start + 4).innerHTML = '<a>移动</a>';
                    rowObj.insertCell(cell_start + 5).innerHTML = '<a>下载</a>';
                    rowObj.insertCell(cell_start + 6).innerHTML = '<a>重命名</a>';
                    rowObj.insertCell(cell_start + 7).innerHTML = '<a>删除</a>';
                    downloadlist.push(data[i].link);
                    // 文件夹操作响应事件
                    rowObj.getElementsByTagName('a')[0].onclick = function () {
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        // 如果已经处于重命名状态，就退出
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        if (tempName.indexOf("div") != -1) return;

                        // 去掉html元素
                        tempName = tempName.replace("<a>", "");
                        tempName = tempName.replace("</a>", "");

                        // 判断是否为目录
                        var tempSize = oTabNow.rows[tempIdx].cells[cell_start + 1].innerHTML;
                        if (tempSize.indexOf(folder_label) != -1) {
                            nowUserPath += tempName + "/";
                            refreshUserFileList();
                        }
                        // 文件的话就下载
                        else {
                            var fileType = tempName.split(".");
                            fileType = fileType[fileType.length - 1];
                            fileType = fileType.toLowerCase();
                            if (fileType.indexOf("mp4") != -1 || fileType.indexOf("flv") != -1 || fileType.indexOf("mkv") != -1)
                            {
                                window.open("/onlineplayer?fileName=" + encodeURI(encodeURI(tempName)) + "&filePath=" + encodeURI(encodeURI(downloadlist[tempIdx - 1])));
                            }
                            else if (fileType.indexOf("mp3") != -1)
                            {
                                if (apa==undefined){
                                    var ap1 = new APlayer({
                                        container: document.getElementById('player_music'),
                                        autoplay: true,
                                        theme: '#FADFA3',
                                        fixed:true,
                                        audio: [{
                                            name: tempName,
                                            artist: username,
                                            url: downloadlist[tempIdx - 1],
                                            cover: 'images/aplayer.png'
                                        }]
                                    });
                                    apa = ap1;
                                }
                                else{
                                    // 获取当前播放列表所有文件名
                                    var musiclist = new Array();
                                    for (i in apa.list.audios){
                                        musiclist.push(apa.list.audios[i].name);
                                    }
                                    // 要播放的音频在列表里，直接跳转，不在就添加列表
                                    var musicidx = musiclist.indexOf(tempName);
                                    if (musicidx !=-1){
                                        apa.list.switch(musicidx);
                                    }
                                    else {
                                        apa.list.add([{
                                            name: tempName,
                                            artist: username,
                                            url: downloadlist[tempIdx - 1],
                                            cover: 'images/aplayer.png'
                                        }]);
                                        apa.list.switch(apa.list.audios.length-1);
                                    }
                                }
                            }
                            else if (fileType.indexOf("rmvb") != -1 || fileType.indexOf("3gp") != -1 || fileType.indexOf("rm") != -1 || fileType.indexOf("avi") != -1 || fileType.indexOf("wmv") != -1)
                            {
                                // 可以用IE播放的特殊处理
                                if(fileType.indexOf("avi") != -1 || fileType.indexOf("wmv") != -1 || fileType.indexOf("3gp") != -1){
                                    if(window.confirm("avi、3gp和wmv格式的文件不能用chrome浏览器在线播放，只支持IE浏览器的在线播放，是否继续播放？")) {
                                        // window.open("/onlineplayer?fileName=" + tempName + "&filePath=" + downloadlist[tempIdx - 1]);
                                        $("#copyIeplayLink").text("http://" + window.location.host + "/onlineplayer?fileName=" + encodeURI(encodeURI(tempName)) + "&filePath=" + encodeURI(encodeURI(downloadlist[tempIdx - 1])));
                                        $("#copyIeplayLink").click();
                                        return;
                                    }
                                }
                                else if(fileType.indexOf("rmvb") != -1 || fileType.indexOf("rm") != -1){
                                    if(window.confirm("rmvb和rm格式的文件在线播放可能会有小bug，并只支持chrome浏览器，是否继续播放？")) {
                                        window.open("/onlineplayer?fileName=" + encodeURI(encodeURI(tempName)) + "&filePath=" + encodeURI(encodeURI(downloadlist[tempIdx - 1])));
                                        return;
                                    }
                                }
                                var transcodestatus = data[tempIdx - 1].transcode;
                                if(transcodestatus=="transcoding") {
                                    alert("该视频正在转码中，请勿重复操作！查看进度可通过刷新页面并再次点击该文件进行！");
                                    return;
                                }
                                else if (transcodestatus=="failed") {
                                    alert("该视频曾转码失败，请使用本地转码工具进行转码！");
                                    return;
                                }
                                else if (transcodestatus=="complete") {
                                    alert("该视频已完成转码，在线播放请刷新页面后点mp4文件，下载请点击下载按钮！");
                                    return;
                                }
                                else if (transcodestatus=="transcodable") {
                                    if(window.confirm("该视频可转码为mp4后在线播放，是否需要转码？")) {
                                        $.ajax({
                                            type: "POST",
                                            url: "/videoconvert",
                                            data: {filepath: downloadlist[tempIdx - 1]},
                                            dataType: "json",
                                            success: function (data)
                                            {
                                                if (data.success) {
                                                    // alert("转码已完成，地址：" + data.msg);
                                                    refreshUserFileList();
                                                }
                                            }
                                        });
                                        alert("视频正在转码中，查看进度可通过刷新页面并再次点击该文件进行！");
                                    }
                                }
                            }
                            else if(fileType.indexOf("jpg") != -1 || fileType.indexOf("gif") != -1 || fileType.indexOf("png") != -1 || fileType.indexOf("jpeg") != -1 || fileType.indexOf("bmp") != -1)
                            {
                                document.getElementById("imgview").src=downloadlist[tempIdx - 1];
                                $('#imgviewDlg').modal('show');
                            }
                            else oTabNow.rows[tempIdx].getElementsByTagName('a')[3].onclick();
                        }
                    }
                    // 分享操作响应事件
                    rowObj.getElementsByTagName('a')[1].onclick = function () {
                        //获取搜索后文件的实际位置
                        var cou = $(this).parent().parent().index();//获取行的索引
                        var filelink=downloadlist[cou-1];
                        var strarr = filelink.split('/');
                        var text='/';
                        if (strarr.length>4){
                            for(i=3;i<strarr.length-1;i++){
                                text=text+strarr[i];
                                text=text+'/'
                            }
                        }
                        nowUserPath=text;
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        // 如果已经处于重命名状态，就退出
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        if (tempName.indexOf("div") != -1) return;

                        // 去掉html元素
                        tempName = tempName.replace("<a>", "");
                        tempName = tempName.replace("</a>", "");
                        tem = tempName;
                        // alert(tem);
                        // 判断是否为目录
                        var tempSize = oTabNow.rows[tempIdx].cells[cell_start + 1].innerHTML;
                        // 是目录的时候
                        if (tempSize.indexOf(folder_label) != -1) {
                            alert("文件夹不支持分享哦！");
                            return;
                        }
                        //提交几天过期
                        $('#getcodeDlg').modal('show');
                        $("#shareLink").empty();
                        $("#fetchSecret").empty();
                        $('#shareSelectedFile').text(tempName);
                        $("#selectExpireDay").empty();
                        $('#selectExpireDay').append(" <input type='radio' name='rationExpireDay' value='永久有效' checked='checked'/>永久有效&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                        $('#selectExpireDay').append("<input type='radio' name='rationExpireDay'  value='7' />7天&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                        $('#selectExpireDay').append("<input type='radio' name='rationExpireDay' value='1' />1天");
                    }
                    // 移动操作响应事件
                    rowObj.getElementsByTagName('a')[2].onclick = function () {
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        // 如果已经处于重命名状态，就退出
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        if (tempName.indexOf("div") != -1) return;

                        var transcodestatus = data[tempIdx - 1].transcode;
                        if(transcodestatus=="transcoding") {
                            alert("该视频正在转码中，请勿移动！");
                            return;
                        }

                        // 去掉html元素
                        tempName = tempName.replace("<a>", "");
                        tempName = tempName.replace("</a>", "");

                        $("#moveDlg").modal('show');

                        // 判断是否为目录
                        var tempSize = oTabNow.rows[tempIdx].cells[cell_start + 1].innerHTML;
                        // 是目录的时候
                        if (tempSize.indexOf(folder_label) != -1) {
                            $("#moveSelectedFile").text("要移动的文件夹：" + tempName);
                            moveFile.folder = true;
                        }
                        else {
                            $("#moveSelectedFile").text("要移动的文件夹：" + tempName);
                            moveFile.folder = false;
                        }
                        moveFile.name = tempName;

                        // 文件真实路径
                        var tmprealpath = data[tempIdx - 1].link;
                        tmprealpath = tmprealpath.substring(0, tmprealpath.lastIndexOf("/")+1);
                        tmprealpath = tmprealpath.replace("/data/", "");
                        tmprealpath = tmprealpath.substring(tmprealpath.indexOf("/"));
                        nowUserPath = tmprealpath;

                        nowMovePath = rootUserPath;
                        listUserFolder(rootUserPath);
                    }
                    // 下载操作响应事件
                    rowObj.getElementsByTagName('a')[3].onclick = function () {
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        // 如果已经处于重命名状态，就退出
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        if (tempName.indexOf("div") != -1) return;

                        // 去掉html元素
                        tempName = tempName.replace("<a>", "");
                        tempName = tempName.replace("</a>", "");

                        // 判断是否为目录
                        var tempSize = oTabNow.rows[tempIdx].cells[cell_start + 1].innerHTML;
                        // 是目录的时候
                        if (tempSize.indexOf(folder_label) != -1) {
                            alert("文件夹不支持下载哦！");
                            return;
                        }
                        // 不支持ie下载
                        if (isIE() == true) {
                            alert("不支持ie内核的浏览器下载，请使用Chrome内核的浏览器下载！");
                            return;
                        }
                        //获取搜索后文件的实际位置
                        var cou = $(this).parent().parent().index();//获取行的索引
                        var filelink=downloadlist[cou-1];
                        var strarr = filelink.split('/');
                        var text='/';
                        if (strarr.length>4){
                            for(i=3;i<strarr.length-1;i++){
                                text=text+strarr[i];
                                text=text+'/'
                            }
                        }
                        nowUserPath=text;
                        // hdfs模式使用请求下载
                        // 普通模式直接下载
                        if (hdfsMode) {
                            $("#loading").show();
                            $.ajax({
                                type: "POST",
                                url: "/download",
                                data: {fileName: tempName, path: nowUserPath},
                                dataType: "json",
                                success: function (data) {
                                    $("#loading").hide();
                                    if (data.success) {
                                        allDownloadFile(data.msg, tempName);
                                    }
                                }
                            });
                        }
                        else {
                            // window.downloadFile(downloadlist[tempIdx - 1]);
                            allDownloadFile(downloadlist[tempIdx - 1], tempName);
                        }
                    }
                    // 重命名操作响应事件
                    rowObj.getElementsByTagName('a')[4].onclick = function () {
                        //获取搜索后文件的实际位置
                        var cou = $(this).parent().parent().index();//获取行的索引
                        var filelink=downloadlist[cou-1];
                        var strarr = filelink.split('/');
                        var text='/';
                        if (strarr.length>4){
                            for(i=3;i<strarr.length-1;i++){
                                text=text+strarr[i];
                                text=text+'/'
                            }
                        }
                        nowUserPath=text;
                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        var rowRename = oTabNow.rows[tempIdx].cells[cell_start];
                        // 如果已经处于重命名状态，就退出重命名
                        if (tempName.indexOf("div") != -1) return;

                        var transcodestatus = data[tempIdx - 1].transcode;
                        if(transcodestatus=="transcoding") {
                            alert("该视频正在转码中，请勿重命名！");
                            return;
                        }

                        // 去掉html元素
                        tempName = tempName.replace("<a>", "");
                        tempName = tempName.replace("</a>", "");
                        // 进入重命名模式
                        rowRename.innerHTML =
                            '<div class="input-group">' +
                            '<input  id="' + tempName + 'Id' + '" style="width: 120px; height: 29px" type="text" class = "form-control" data-options="required:true " value="' + tempName + '">&nbsp;&nbsp;' +
                            '<button id="' + tempName + 'BtnOK' + '" class = "glyphicon glyphicon-ok" style="height: 29px"></button>&nbsp;&nbsp;' +
                            '<button id="' + tempName + 'BtnRemove' + '" class = "glyphicon glyphicon-remove" style="height: 29px"></button>' +
                            '</div>'
                        // 确认重命名
                        rowRename.getElementsByTagName('button')[0].onclick = function () {
                            // rowRename.innerHTML = this.parentNode.childNodes[0].value;
                            var oldName = this.parentNode.childNodes[0].defaultValue;
                            var newName = this.parentNode.childNodes[0].value;
                            if (newName == "") {
                                rowRename.getElementsByTagName('button')[1].onclick();
                                return;
                            }
                            // 判断是否为目录
                            var tempSize = oTabNow.rows[tempIdx].cells[2].innerHTML;
                            // 是目录的时候
                            if (tempSize.indexOf(folder_label) != -1) {
                                $.ajax({
                                    type: "POST",
                                    url: "/filerename",
                                    data: {oldName: "@dir@", newName: newName, path: nowUserPath + oldName},
                                    dataType: "json",
                                    success: function (data) {
                                        refreshUserFileList();
                                    }
                                });
                            }
                            else {
                                $.ajax({
                                    type: "POST",
                                    url: "/filerename",
                                    data: {oldName: oldName, newName: newName, path: nowUserPath},
                                    dataType: "json",
                                    success: function (data) {
                                        refreshUserFileList();
                                        alert(data.msg);
                                    }
                                });
                            }
                        }
                        // 取消重命名
                        rowRename.getElementsByTagName('button')[1].onclick = function () {
                            rowRename.innerHTML = "<a>" + this.parentNode.childNodes[0].defaultValue + "</a>";
                        }
                    }
                    // 删除操作响应事件
                    rowObj.getElementsByTagName('a')[5].onclick = function () {
                        //获取搜索后文件的实际位置
                        var cou = $(this).parent().parent().index();//获取行的索引
                        var filelink=downloadlist[cou-1];
                        var strarr = filelink.split('/');
                        var text='/';
                        if (strarr.length>4){
                            for(i=3;i<strarr.length-1;i++){
                                text=text+strarr[i];
                                text=text+'/'
                            }
                        }
                        nowUserPath=text;

                        var tempIdx = this.parentNode.parentNode.rowIndex;
                        // 如果已经处于重命名状态，就退出
                        var tempName = oTabNow.rows[tempIdx].cells[cell_start].innerHTML;
                        if (tempName.indexOf("div") != -1) return;

                        var transcodestatus = data[tempIdx - 1].transcode;
                        if(transcodestatus=="transcoding") {
                            alert("该视频正在转码中，请勿删除！");
                            return;
                        }


                        if(window.confirm('确定删除吗？')){
                            // 去掉html元素
                            tempName = tempName.replace("<a>", "");
                            tempName = tempName.replace("</a>", "");

                            // 判断是否为目录
                            var tempSize = oTabNow.rows[tempIdx].cells[cell_start + 1].innerHTML;
                            if (tempSize.indexOf(folder_label) != -1) {
                                $.ajax({
                                    type: "POST",
                                    url: "/filedelete",
                                    data: {fileName: "@dir@", path: nowUserPath + tempName},
                                    dataType: "json",
                                    success: function (data) {
                                        refreshUserFileList();
                                    }
                                });
                            }
                            else {
                                $.ajax({
                                    type: "POST",
                                    url: "/filedelete",
                                    data: {fileName: tempName, path: nowUserPath},
                                    dataType: "json",
                                    success: function (data) {
                                        refreshUserFileList();
                                    }
                                });
                            }
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
        });}
    }

    function onekeymusic() {
        $.ajax({
            type: "POST",
            url: "/search",
            data: {key: ".mp3", path: "/"},
            dataType: "json",
            success: function (data) {
                if (apa==undefined){
                    var ap1 = new APlayer({
                        container: document.getElementById('player_music'),
                        autoplay: true,
                        theme: '#FADFA3',
                        fixed:true,
                    });
                    apa = ap1;
                }
                else apa.list.clear();
                for (i in data){
                    if (data[i].size.indexOf("Directory") != -1) continue;
                    var mname = data[i].name;
                    var suffix = mname.substring(mname.lastIndexOf(".")+1).toLowerCase();
                    if (suffix=="mp3")
                    {
                        // 获取当前播放列表所有文件名
                        var musiclist = new Array();
                        for (j in apa.list.audios){
                            musiclist.push(apa.list.audios[j].name);
                        }
                        // 要播放的音频在列表里就跳过，不在就添加列表
                        var musicidx = musiclist.indexOf(mname);
                        if (musicidx !=-1){
                            continue;
                        }
                        else {
                            apa.list.add([{
                                name: data[i].name,
                                artist: username,
                                url: data[i].link,
                                cover: 'images/aplayer.png'
                            }]);
                        }
                    }
                }
                apa.play();
            }
        });
    }

</script>
</body>

</html>
