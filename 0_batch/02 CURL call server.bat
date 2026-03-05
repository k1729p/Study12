@echo on
@set SITE=http://localhost:8080/boxes
@set CURL=c:\tools\curl-7.58.0\bin\curl.exe
@set CURL=%CURL% -g -i -H "Accept: application/json" -H "Content-Type: application/json"

@powershell -Command Write-Host "----------------------------------------------------------------------" -foreground "Yellow"
@powershell -Command Write-Host "CREATE" -foreground "Green"
%CURL% -d {\"text\":\"D\"} -X POST "%SITE%/"
@echo.

@powershell -Command Write-Host "----------------------------------------------------------------------" -foreground "Yellow"
@powershell -Command Write-Host "GET single" -foreground "Green"
%CURL% "%SITE%/1"
@echo.

@powershell -Command Write-Host "----------------------------------------------------------------------" -foreground "Yellow"
@powershell -Command Write-Host "UPDATE" -foreground "Green"
%CURL% -d {\"id\":\"4\",\"text\":\"Y\"} -X PUT "%SITE%/1"
@echo.

@powershell -Command Write-Host "----------------------------------------------------------------------" -foreground "Yellow"
@powershell -Command Write-Host "DELETE" -foreground "Green"
%CURL% -X DELETE "%SITE%/1"
@echo.

@powershell -Command Write-Host "----------------------------------------------------------------------" -foreground "Yellow"
@powershell -Command Write-Host "GET all" -foreground "Green"
%CURL% "%SITE%/"
@echo.

@powershell -Command Write-Host "FINISH" -foreground "Red"
pause