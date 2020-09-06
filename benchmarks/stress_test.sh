# need install apache2-utils before run script

# n (Count parallel requests) - 10
# c (Count requests) - 100
ab -n 1000 -c 100 http://localhost:8080/users
ab -n 1000 -c 100 http://localhost:8080/users/some-uuid
ab  -n 1000 -c 100 -T application/json -p user.json http://localhost:8080/users
