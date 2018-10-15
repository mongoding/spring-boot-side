package org.spring.springboot.zipkin;

import brave.Span;
import brave.Tracer;
import com.alibaba.dubbo.rpc.*;

/**
 * dubbo拦截抽象
 *
 * @author mongoding
 * @since 2017年11月04 20:17
 **/
public abstract class DrpcAbstractInterceptor implements Filter {
    /**
     * 一次全局Span
     */
    protected Span span = null;
    /**
     * SpanInScope
     */
    protected Tracer.SpanInScope spanInScope = null;

    /**
     * 开始之前调用
     *
     * @param invoker    invoker
     * @param invocation invocation
     */
    public abstract void preHandle(Invoker<?> invoker, Invocation invocation);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        preHandle(invoker, invocation);
        Result result = invoker.invoke(invocation);
        afterCompletion(invoker, invocation);
        return result;
    }

    /**
     * 结束之后调用
     *
     * @param invoker
     * @param invocation
     */
    abstract void afterCompletion(Invoker<?> invoker, Invocation invocation);

}
