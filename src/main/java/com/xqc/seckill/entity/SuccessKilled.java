package com.xqc.seckill.entity;

import java.util.Date;

/**
 * ��ɱ�ɹ�ʵ����
 * 
 * @author A Cang��xqc��
 *
 */
public class SuccessKilled {

	//��ɱ�ɹ���ID
    private long seckillId;

    //�û��ֻ���
    private long userPhone;

    //״̬��0����-1����1����
    private short state;

    //����ʱ��
    private Date createTime;

    // ���һ
    private Seckill seckill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
