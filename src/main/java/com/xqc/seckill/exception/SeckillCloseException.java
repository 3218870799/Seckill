package com.xqc.seckill.exception;

/**
 * ��ɱ�ر��쳣
 * @author A Cang��xqc��
 *
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
