package com.xqc.seckill.exception;

/**
 * �ظ���ɱ�쳣
 * 
 * @author A Cang��xqc��
 *
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
