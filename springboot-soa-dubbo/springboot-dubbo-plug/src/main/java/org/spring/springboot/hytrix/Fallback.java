package org.spring.springboot.hytrix;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * 业务失败返回处理函数
 * Created by mongoding on 2018/2/26.
 */
@SPI
public interface Fallback {
    Object invoke();
}
