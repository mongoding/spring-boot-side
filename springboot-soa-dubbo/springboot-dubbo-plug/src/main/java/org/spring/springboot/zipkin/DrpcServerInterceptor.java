/*
package org.spring.springboot.zipkin;

import brave.Span;
import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import org.spring.springboot.zipkin.common.TracingConfig;
import org.spring.springboot.zipkin.common.TracingThreadLocal;

import java.util.Map;

*/
/**
 * dubbo服务端拦截器
 *
 * @author mongoding
 * @since 2017年11月04 10:50
 **//*

@Activate(group = Constants.PROVIDER)
public class DrpcServerInterceptor extends DrpcAbstractInterceptor {
    @Override
    public void preHandle(Invoker<?> invoker, Invocation invocation) {
        Map<String, String> at = invocation.getAttachments();
        try {
            span = TracingConfig.getSingle().handleReceive(at);
            String path = RpcContext.getContext().getMethodName();
            span.kind(Span.Kind.SERVER).name("rpc-producer-" + path);
            span.annotate(System.currentTimeMillis(), zipkin.Constants.SERVER_RECV);
            TracingThreadLocal.set(span.context());
            span.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    void afterCompletion(Invoker<?> invoker, Invocation invocation) {
        if (span != null) {
            if (!span.isNoop()) {
                return;
            }
            span.annotate(System.currentTimeMillis(), zipkin.Constants.SERVER_SEND);
            span.finish();
            TracingThreadLocal.close();
        }
    }
}
*/
