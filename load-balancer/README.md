# Load Balancer Kata

For a given list of request durations, this load balancer should divide the list into three parts for distribution
using the following constraints

* the list of request duration may have between 5 and 100.000 items.
* the three resulting parts should have the exact same sum of request durations
* balancing is done by dropping two requests:
  * the first after the first batch of requests
  * the second between the second and third batch of requests 
  
*Example:*

Given a list of durations {1, 3, 4, 2, 2, 2, 1, 1, 2}, we are able to drop the third and sixth item in the list 
resulting in the following three batches with the same sum of four: {1, 3}, {2, 2} and {1, 1, 2}.

## Interface

```java
public boolean solution(int[] requestDurations) ;
```

* The `request durations` defines a given list of request durations with between 5 and 100.000 items.
* The `return value` of the method returns _true_ if an equally distributed load balancing is possible and _false_ otherwise.