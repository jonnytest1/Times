call ./war/Times/gradlew.bat -p ./war/Times/ build
docker build -t jonathanheindl/test .
docker push jonathanheindl/test