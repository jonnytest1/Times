call ./war/Times/gradlew.bat -p ./war/Times/ build
docker build -t jonathanheindl/test .
cd ./../../synced/Times/
#pause
start up.bat
exit