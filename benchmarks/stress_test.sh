# need install apache2-utils before run script

# n (Count parallel requests) - 10
# c (Count requests) - 100
ab -n 100000 -c 1000 http://localhost:8080/users
ab -n 100000 -c 1000 http://localhost:8080/users/some-uuid
ab  -n 100000 -c 1000 -T application/json -p user.json http://localhost:8080/users
