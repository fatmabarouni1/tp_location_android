@echo off
setlocal
set "JAR=gradle\wrapper\gradle-wrapper.jar"
if exist "%JAR%" (
  echo Gradle wrapper deja installe.
  exit /b 0
)
echo Telechargement du Gradle Wrapper...
powershell -NoProfile -ExecutionPolicy Bypass -Command "Invoke-WebRequest -Uri 'https://raw.githubusercontent.com/gradle/gradle/v8.9.0/gradle/wrapper/gradle-wrapper.jar' -OutFile '%JAR%'"
if exist "%JAR%" (
  echo OK - gradle-wrapper.jar installe.
) else (
  echo Echec du telechargement. Verifiez votre connexion Internet.
  exit /b 1
)
endlocal
