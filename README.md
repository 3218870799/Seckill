# Seckill

## 目的：
>>>> 这是一个跟着慕课网老师做的秒杀系统，主要用来学习高并发API事务管理

## 系统分析：
>>>>### 本系统主要学习高并发，所以只是模拟秒杀，所以仅仅有以下功能
>>>>>>> 秒杀接口暴露
>>>>>>> 执行秒杀
>>>>>>> 相关查询
	
## 知识记录：
>>>>### 竞争：
>>>>### 事务：strat，update ，insert，commit
>>>>### 行级锁：当update时该线程获得锁，其他线程等待，当该线程commit后其他线程再获得锁<br>
				难点：如何高效处理竞争
## 高并发优化分析以及优化思路
>>>>### 1：详情页：
>>>>>>>> 部署到CDN上，一般静态资源基本都在CDN上，不用访问系统	
>>>>### 2：获取系统时间：
>>>>>>>> 用户可能会不断刷新获取系统时间，但是访问内存只需10ns，一般不需要优化
>>>>### 3：秒杀地址暴露接口：后端服务Redis优化
>>>>>>>> request——>reids——>Mysql
>>>>### 4：执行秒杀操作:	数据库操作
>>>>>>>> 其实Mysql执行也是很快的，一秒钟大约可以执行40000左右，影响速度的大部分是因为行级锁锁定，网络延迟，可能还会有GC（垃圾回收机制）
>>>>>>>> 我们能做的首先就是减少行级锁的持有时间。
>>>>>>>> 然后对于延迟和GC，我们可以把客户端逻辑放到MYSQL服务端执行，因为MYSQL的执行是相对较快的，这样可以避免网络延迟和GC影响
>>>>>>>> 解决方案：定制SQL，修该MYSQL源码，update/*+[auto_commit]*/当执行完update时自动回滚，当update影响为：1，自动commit，影响0执行回滚
>>>>>>>> 使用存储过程：整个事务在MYSQL端完成
>>>>#### 使用Redis进行后端缓存优化编码：关于Redis的具体使用可以参考我以前写的博客	https://www.cnblogs.com/nullering/p/9332589.html
>>>>##### 1：引入redis访问客户端Jdeis
>>>>##### 2：优化ServiceImpl的exportSeckillUrl暴露接口方法
>>>>>>>>>>>> 新建数据访问对象RedisDao
>>>>>>>>>>>> get from cache
>>>>>>>>>>>> if null
>>>>>>>>>>>> get db
>>>>>>>>>>>> put cache
>>>>>>>>>>>> else locgoin
>>>>##### 序列化问题：自定义序列化，采用protostuf
>>>>###### 反序列化
>>>>>>>>>>>> 1： private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);
>>>>>>>>>>>> 2；byte[] bytes = jedis.get(key.getBytes());
>>>>>>>>>>>> 3：Seckill seckill = schema.newMessage();
>>>>>>>>>>>> ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);//参数：字节数组，空对象，schema返回的seckill已进行了反序列化
>>>>###### 序列化：
>>>>>>>>>>>> byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema,
>>>>>>>>>>>> LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
>>>>>>>>>>>> //超时缓存
>>>>>>>>>>>> int timeout = 60 * 60;//1小时
>>>>>>>>>>>> String result = jedis.setex(key.getBytes(), timeout, bytes);
>>>>>>>>>>>> return result;//正确则返回ok
	