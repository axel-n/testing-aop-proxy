# Benchmark results
send 100k requests for every method

## Get users
in code setup wait 200ms
```bash
# ab results
Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   3.2      0      56
Processing:   216 1017  53.2   1020    1139
Waiting:      209 1017  53.3   1020    1139
Total:        266 1018  50.3   1021    1139
```

```bash
# in db
max - 247
avg - 200.4182
min - 200
```


## Get user
in code setup wait 50ms
```bash
# ab results
Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   8.8      0    1029
Processing:    54  271  21.5    261     554
Waiting:       54  270  21.5    261     554
Total:         78  271  22.9    261    1289
```

```bash
# in db
max - 83
avg - 50.139
min - 50
```

## Create user
in code setup wait 100ms
```bash
# ab results
Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   6.1      0    1013
Processing:   104  514  24.3    514     620
Waiting:      103  513  24.3    514     620
Total:        124  514  23.2    514    1522
```

```bash
# in db
max - 137
avg - 100.199
min - 100
```