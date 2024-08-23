作业: 1.maven或者gradle本身就是可以动态管理jar包的工具,移除day05 lib的配置方式 
2.熟悉如何创建线程,线程间通信,线程池的使用,以及安全的线程集合,如何避免线程死锁

1.在pom.xml中添加配置依赖
2.
a.线程创建有四种方式
1.继承Thread类,
2.实现Runnable接口,
3.实现Callable接口，
4.以及线程池的方式，
区别：是继承了Thread类之后无非继承其他类，实现接口还可以继承类，并且Callable接口是可以有返回值的
通过Future，调用get方法获取返回值，还有的区别是实现Runnable接口重写run方法是不可以抛出异常的，
只能内部消化，而Callable接口重写的call()方法可以抛出异常。

b.线程间的通信
1.synchronized关键字
2.wait()和notify()方法
3.Lock锁
4.ReentrantLock锁
5.Condition条件变量
6.Thread.join()
7.管道输入、输出流

c.死锁
死锁是指两个或两个以上的进程在执行过程中由于竞争资源或者彼此通信而造成的一种阻塞现象
死锁经常发生在线程有多个锁的时候
死锁的产生的四个必要条件：
1.互斥条件：一个资源每次只能被一个进程使用。
2.不可剥夺条件：进程已获得的资源在未使用完之前不能被其他进程强行剥夺，只有进程自己主动释放资源。
3.请求和保持条件：进程已获得的资源再次请求时，必须同时保持其他资源不放弃。
4.循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。
避免死锁就是破坏上面四个必要条件之一。
检查死锁的方式
1.首先在终端运行jps 输出JVM中运行的进程状态信息
2.jstack -l 输出线程的堆栈信息，查看日志检查是否有死锁。

d.线程安全集合
1.ArrayList	CopyOnWriteArrayList
2.HashSet CopyOnWriteArraySet
3.HashMap   HashTable、ConcurrentHashMap


