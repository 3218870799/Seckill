package com.xqc.seckill.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xqc.seckill.entity.Seckill;
/**
 * ��ɱDao�ӿ�
 * 
 * @author A Cang��xqc��
 *
 */
public interface SeckillDao {

    /**
     * �����
     * @param seckillId
     * @param killTime
     * @return ���Ӱ������>1����ʾ���µļ�¼����
     */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    /**
     * ����id��ѯ��ɱ����
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * ����ƫ������ѯ��ɱ��Ʒ�б�
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offet, @Param("limit") int limit);

    /**
     * ʹ�ô洢����ִ����ɱ
     * @param paramMap
     */
    void killByProcedure(Map<String,Object> paramMap);

}
