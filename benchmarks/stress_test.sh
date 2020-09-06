
# need install apache2-utils before run script

# N (Count parallel requests) - 10
# C (Count requests) - 100

ab -n 1000 -c 100 http://localhost:8080/users
ab -n 1000 -c 100 http://localhost:8080/users/some-uuid

json='{ "name" : "some_name", "last_name" : "some_last_name"}'
ab -T application/json  -n 1000 -c 10 http://localhost:8080/users
