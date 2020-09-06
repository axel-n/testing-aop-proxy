# Benchmark results
send 100k requests for every method

## Get users
in code setup wait 200ms
```bash
# ab results
Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1  13.8      0    1019
Processing:   209 1016  46.7   1018    1141
Waiting:      208 1015  46.8   1017    1139
Total:        229 1016  47.0   1018    1975
```

```bash
# in db
max - 269
avg - 200.297025
min - 200
```


## Get user
in code setup wait 50ms
```bash
# ab results
Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   2.8      0      55
Processing:    52  269  20.6    261     389
Waiting:       52  269  20.6    261     389
Total:         95  270  19.1    261     389
```

```bash
# in db
max - 164
avg - 50.34625
min - 50
```

## Create user
in code setup wait 100ms
```bash
# ab results
Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   2.7      0      56
Processing:   107  514  22.8    514     609
Waiting:      106  514  22.8    514     609
Total:        158  515  20.4    514     610
```

```bash
# in db
max - 141
avg - 100.19088
min - 100
```