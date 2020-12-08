@echo off
set "KKFILEVIEW_BIN_FOLDER=%cd%"
cd "%KKFILEVIEW_BIN_FOLDER%"
echo Using KKFILEVIEW_BIN_FOLDER %KKFILEVIEW_BIN_FOLDER%
echo Starting kkFileView...
java -Dsun.java2d.cmm=sun.java2d.cmm.kcms.KcmsServiceProvider  -jar kkFileView-2.2.1.jar -> ..\log\kkFileView.log