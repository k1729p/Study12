@echo on
@set SITE=http://localhost:8080
@set CURL=c:\tools\curl-7.58.0\bin\curl.exe
@set CURL=%CURL% -g -i 

@powershell -Command Write-Host "----------------------------------------------------------------------" -foreground "Yellow"
@powershell -Command Write-Host "GET Web Application Description Language" -foreground "Green"
%CURL% "%SITE%/application.wadl"
@echo.

@powershell -Command Write-Host "FINISH" -foreground "Red"
pause