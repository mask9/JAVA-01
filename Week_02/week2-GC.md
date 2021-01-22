#### Serial GC

1.一个单线程的GC

2.CPU利用率最高，GC时会有停顿。

3.可以通过-XX:+UseSerialGC 设置GC

4.新生代的gc

#### Parallel GC

1.多线程的并行GC，GC时不会造成停顿

2.停顿时间短，吞吐量较好

3.新生代的gc，使用复制算法

#### CMS GC

1.并发GC，响应很快，GC停顿时间较短

2.老年代的GC，使用标记清楚算法



#### G1 GC

1.很多个连续的区域（region），G1会调整、计算堆内空间分配

2.适用于4G+ 堆内存，低于4G会退化为Parallel GC，需要注意

3.G1可设置暂停时间

4.G1使用标记、整理和复制的算法，响应很快



#### 常用GC组合

1.Serial+Serial Old 实现单线程的低延迟垃圾回收机制；
2.ParNew+CMS，实现多线程的低延迟垃圾回收机制；
3.Parallel Scavenge和Parallel ScavengeOld，实现多线程的高吞吐量垃圾回收机制；