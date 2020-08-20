# Resilience4j-Bulkhead
Resilience4j is a lightweight, easy-to-use fault tolerance library inspired by. Netflix Hystrix, but designed for Java 8 and functional programming. Lightweight, because the library only uses Vavr, which does not have any other external library dependencies.
There are six core modules in Resilience4j - 
- resilience4j-circuitbreaker: Circuit breaking
- resilience4j-ratelimiter: Rate limiting
- resilience4j-bulkhead: Bulkheading
- resilience4j-retry: Automatic retrying (sync and async)
- resilience4j-cache: Result caching
- resilience4j-timelimiter: Timeout handling

It's possible to limit the number of concurrent calls to a particular service by using resilience4j-Bulkhead.

Resilience4j provides two implementations of a bulkhead pattern that can be used to limit the number of concurrent execution:

- a SemaphoreBulkhead which uses Semaphores
- a FixedThreadPoolBulkhead which uses a bounded queue and a fixed thread pool.
The SemaphoreBulkheadshould work well across a variety of threading and I/O models. It is based on a semaphore, and unlike Hystrix, does not provide "shadow" thread pool option. It is up to the us to ensure correct thread pool sizing that will be consistent with bulkhead configuration.

