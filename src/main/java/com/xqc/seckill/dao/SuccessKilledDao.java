package com.xqc.seckill.dao;

import org.apache.ibatis.annotations.Param;

import com.xqc.seckill.entity.SuccessKilled;

/**
 * 秒杀成功DAO接口
 * 
 * @author A Cang（xqc）
 *
 */
public interface SuccessKilledDao {
	
	/**
	 * 插入购买明细
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
    int insertSuccessKilled(@Param("seckillId") long seckillId ,@Param("userPhone") long userPhone);
    
    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
