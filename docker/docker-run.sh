docker stop some-mysql
docker rm some-mysql
docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mysql:8.0.23
# root is the super user