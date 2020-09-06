# Test aop proxy
target - how much AOP increase execution time

#Results
you can found extended results:
 - [without proxy](https://github.com/axel-n/testing-aop-proxy/blob/without_proxy/benchmarks/results.md)
 - [with proxy](https://github.com/axel-n/testing-aop-proxy/blob/with_proxy/benchmarks/results.md)

## Short 
I sent 100k requests for all methods in controller with tool ab (from apache)
And receive ~0.0096%...0.02% increase execution time

###without proxy 
| method | max | avg | min |
| :--- | :--- | :--- | :--- |
| getUsers | 251 | 200.3697128712871287 | 200 |
| getUser | 77 | 50.1563960396039604 | 50 |
| createUser | 123 | 100.1985643564356436 | 100 |


### with proxy 
| method | max | avg | min |
| :--- | :--- | :--- | :--- |
| getUsers | 328 | 200.3890693069306931 | 200 |
| getUser | 70 | 50.1425148514851485 | 50 |
| createUser | 120 | 100.1873762376237624 | 100 |

#### How calculated
this tables - just sql)
```sql
select method, max(duration), avg(duration), min(duration) 
from statistic
group by method
```