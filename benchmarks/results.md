# Benchmark results

## Get users
in code setup wait 200ms
```bash
# ab results
Connection Times (ms)
                 min  mean[+/-sd] median   max
   Connect:        0    0   0.5      0       3
   Processing:   203  230  34.2    216     381
   Waiting:      203  224  25.1    215     378
   Total:        203  230  34.3    216     381
```

```bash
# in db
max - 225
avg - 200.7465
min - 200
```


## Get user
in code setup wait 50ms
```bash
# ab results
Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   2.0      0       9
Processing:    54   69  12.3     66     176
Waiting:       53   68  12.0     65     168
Total:         54   70  13.5     67     182
```

```bash
# in db
max - 83
avg - 50.819
min - 50
```

## Create user
in code setup wait 100ms
```bash
# ab results
Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   2.3      0      12
Processing:   102  118  32.5    106     233
Waiting:      101  118  32.2    106     233
Total:        102  119  34.6    106     243
```

```bash
# in db
max - 137
avg - 101.8395
min - 100
```