# Seckill

## Ŀ�ģ�
>>>> ����һ������Ľ������ʦ������ɱϵͳ����Ҫ����ѧϰ�߲���API�������

## ϵͳ������
>>>>### ��ϵͳ��Ҫѧϰ�߲���������ֻ��ģ����ɱ�����Խ��������¹���
>>>>>>> ��ɱ�ӿڱ�¶
>>>>>>> ִ����ɱ
>>>>>>> ��ز�ѯ
	
## ֪ʶ��¼��
>>>>### ������
>>>>### ����strat��update ��insert��commit
>>>>### �м�������updateʱ���̻߳�����������̵߳ȴ��������߳�commit�������߳��ٻ����<br>
				�ѵ㣺��θ�Ч������
## �߲����Ż������Լ��Ż�˼·
>>>>### 1������ҳ��
>>>>>>>> ����CDN�ϣ�һ�㾲̬��Դ��������CDN�ϣ����÷���ϵͳ	
>>>>### 2����ȡϵͳʱ�䣺
>>>>>>>> �û����ܻ᲻��ˢ�»�ȡϵͳʱ�䣬���Ƿ����ڴ�ֻ��10ns��һ�㲻��Ҫ�Ż�
>>>>### 3����ɱ��ַ��¶�ӿڣ���˷���Redis�Ż�
>>>>>>>> request����>reids����>Mysql
>>>>### 4��ִ����ɱ����:	���ݿ����
>>>>>>>> ��ʵMysqlִ��Ҳ�Ǻܿ�ģ�һ���Ӵ�Լ����ִ��40000���ң�Ӱ���ٶȵĴ󲿷�����Ϊ�м��������������ӳ٣����ܻ�����GC���������ջ��ƣ�
>>>>>>>> �������������Ⱦ��Ǽ����м����ĳ���ʱ�䡣
>>>>>>>> Ȼ������ӳٺ�GC�����ǿ��԰ѿͻ����߼��ŵ�MYSQL�����ִ�У���ΪMYSQL��ִ������ԽϿ�ģ��������Ա��������ӳٺ�GCӰ��
>>>>>>>> �������������SQL���޸�MYSQLԴ�룬update/*+[auto_commit]*/��ִ����updateʱ�Զ��ع�����updateӰ��Ϊ��1���Զ�commit��Ӱ��0ִ�лع�
>>>>>>>> ʹ�ô洢���̣�����������MYSQL�����
>>>>#### ʹ��Redis���к�˻����Ż����룺����Redis�ľ���ʹ�ÿ��Բο�����ǰд�Ĳ���	https://www.cnblogs.com/nullering/p/9332589.html
>>>>##### 1������redis���ʿͻ���Jdeis
>>>>##### 2���Ż�ServiceImpl��exportSeckillUrl��¶�ӿڷ���
>>>>>>>>>>>> �½����ݷ��ʶ���RedisDao
>>>>>>>>>>>> get from cache
>>>>>>>>>>>> if null
>>>>>>>>>>>> get db
>>>>>>>>>>>> put cache
>>>>>>>>>>>> else locgoin
>>>>##### ���л����⣺�Զ������л�������protostuf
>>>>###### �����л�
>>>>>>>>>>>> 1�� private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);
>>>>>>>>>>>> 2��byte[] bytes = jedis.get(key.getBytes());
>>>>>>>>>>>> 3��Seckill seckill = schema.newMessage();
>>>>>>>>>>>> ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);//�������ֽ����飬�ն���schema���ص�seckill�ѽ����˷����л�
>>>>###### ���л���
>>>>>>>>>>>> byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema,
>>>>>>>>>>>> LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
>>>>>>>>>>>> //��ʱ����
>>>>>>>>>>>> int timeout = 60 * 60;//1Сʱ
>>>>>>>>>>>> String result = jedis.setex(key.getBytes(), timeout, bytes);
>>>>>>>>>>>> return result;//��ȷ�򷵻�ok
	