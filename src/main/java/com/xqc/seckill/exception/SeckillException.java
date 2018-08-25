package com.xqc.seckill.exception;

/**
 * 秒杀相关业务异常
 * 
 * @author A Cang（xqc）
 *
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
