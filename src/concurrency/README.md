Notes on java.util.concurrency package 
 
*Executor*: is an interface that represents an object that executes provided tasks.
	* The task may or may not run in a separate thread
	* Executor does not strictly require the task execution to be asynchronous. An executor can invoke the submitted task instantly in the invoking thread.

* *ExecutorService*: complete solution for asynchronous processing. It manages an in-memory queue and schedules submitted tasks based on thread availability.
	* shutdown: waits till the all submitted task finish executing
	* shutdownNow: immediately terminates all the pending/executing tasks
	* awaitTermination: forcefully blocks until all tasks have completed execution after a shutdown event triggered or execution-timeout occurred, or the execution thread itself is interrupted,

* *ScheduledExecutorService*: similar interface to ExecutorService, but it can perform tasks periodically.
	* scheduleAtFixedRate
	* scheduleWithFixedDelay

* *Future*: used to represent the result of an asynchronous operation.

* *CountDownLatch*: utility class which blocks a set of threads until some operation completes. A CountDownLatch is initialized with a counter(Integer type); this counter decrements as the dependent threads complete execution. But once the counter reaches zero, other threads get released.
	* we could just call countdown() after each thread finishes, guaranteeing that a dependent thread calling await() will block until the worker threads are finished.

* *CyclicBarrier*: CyclicBarrier works almost same as CountDownLatch except that we can reuse it. Unlike CountDownLatch, it allows multiple threads to wait for each other using await() method(known as barrier condition) before invoking the final task.

* *Semaphore*: The Semaphore is used for blocking thread level access to some part of the physical or logical resource. A semaphore contains a set of permits; whenever a thread tries to enter the critical section, it needs to check the semaphore if a permit is available or not.

* *ThreadFactory*: ThreadFactory acts as a thread (non-existing) pool which creates a new thread on demand.

* *BlockingQueue*: Implements a producer-consumer design pattern

* *DelayQueue*: DelayQueue is an infinite-size blocking queue of elements where an element can only be pulled if it’s expiration time (known as user defined delay) is completed. 

* *Locks*: Lock is a utility for blocking other threads from accessing a certain segment of code, apart from the thread that’s executing it currently.
	* The main difference between a Lock and a Synchronized block is that synchronized block is fully contained in a method; however, we can have Lock API’s lock() and unlock() operation in separate methods.
	* We can achieve fairness within the Lock APIs by specifying the fairness property. It makes sure that longest waiting thread is given access to the lock
	* The Lock API provides tryLock() method. The thread acquires lock only if it’s available and not held by any other thread. 
	* The Lock API provides a method lockInterruptibly() which can be used to interrupt the thread when it’s waiting for the lock.

* *Phaser*: Phaser is a more flexible solution than CyclicBarrier and CountDownLatch – used to act as a reusable barrier on which the dynamic number of threads need to wait before continuing execution. We can coordinate multiple phases of execution, reusing a Phaser instance for each program phase.
