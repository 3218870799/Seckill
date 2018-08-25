package com.xqc.seckill.service;


import java.util.List;

import com.xqc.seckill.dto.Exposer;
import com.xqc.seckill.dto.SeckillExecution;
import com.xqc.seckill.entity.Seckill;
import com.xqc.seckill.exception.RepeatKillException;
import com.xqc.seckill.exception.SeckillCloseException;
import com.xqc.seckill.exception.SeckillException;

/**
 * ҵ��ӿ�:վ��"ʹ����"�Ƕ���ƽӿ�
 * ��������:������������,����,��������(return ����/�쳣)
 * @author A Cang��xqc��
 *
 */
public interface SeckillService {

    /**
     * ��ѯ������ɱ��¼
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * ��ѯ������ɱ��¼
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * ��ɱ���������ɱ�ӿڵ�ַ,
     * �������ϵͳʱ�����ɱʱ��
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * ִ����ɱ����
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException,RepeatKillException,SeckillCloseException;

    /**
     * ִ����ɱ����by �洢����
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);

}
