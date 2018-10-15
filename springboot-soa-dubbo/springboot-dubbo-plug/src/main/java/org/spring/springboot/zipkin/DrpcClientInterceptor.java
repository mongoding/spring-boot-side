/*
package org.spring.springboot.zipkin;

import brave.Span;
import brave.Tracer;
import brave.Tracing;
import brave.internal.Platform;
import brave.propagation.TraceContext;
import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.github.kristofa.brave.IdConversion;
import org.spring.springboot.zipkin.common.DubboTraceConst;
import org.spring.springboot.zipkin.common.TracingConfig;
import org.spring.springboot.zipkin.common.TracingThreadLocal;

import java.util.Map;

*/
/**
 * dubbo客户端拦截
 *
 * @author mongoding
 * @since 2017年11月04 11:28
 **//*

@Activate(group = Constants.CONSUMER)
public class DrpcClientInterceptor extends DrpcAbstractInterceptor {
    @Override
    public void preHandle(Invoker<?> invoker, Invocation invocation) {
        try {
            Map<String, String> at = invocation.getAttachments();
            Tracer tracer = Tracing.currentTracer();
            TraceContext traceContext = null;
            TraceContext context = TracingThreadLocal.get();
            Long currenSpanId = null;
            if (tracer == null) {
                span = TracingConfig.getSingle().handleReceive(at);
                traceContext = Tracing.current().currentTraceContext().get();
                if (traceContext == null) {
                    traceContext = intoContext();
                    span = Tracing.current().tracer().toSpan(traceContext);
                }
            } else {
                Span currentSpan = tracer.currentSpan();
                if (currentSpan != null) {
                    currenSpanId = currentSpan.context().spanId();
                }
                if (currenSpanId == null && context != null) {
                    currenSpanId = context.spanId();
                    this.span = tracer.joinSpan(context);
                } else {
                    this.span = tracer.nextSpan();
                    spanInScope = tracer.withSpanInScope(this.span);
                }
                traceContext = span.context();
            }
            span.kind(Span.Kind.CLIENT);
            span.name("rpc-consumer-" + invocation.getMethodName());
            span.annotate(System.currentTimeMillis(), zipkin.Constants.CLIENT_SEND);
            if (traceContext != null) {
                span.start();
                if (currenSpanId != null) {
                    at.put(DubboTraceConst.PARENT_SPAN_ID_NAME, IdConversion.convertToString(currenSpanId));
                }
                at.put(DubboTraceConst.SPAN_ID_NAME, IdConversion.convertToString(traceContext.spanId()));
                at.put(DubboTraceConst.TRACE_ID_NAME, traceContext.traceIdString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    void afterCompletion(Invoker<?> invoker, Invocation invocation) {
        if (span != null) {
            span.annotate(System.currentTimeMillis(), zipkin.Constants.CLIENT_RECV);
            if (spanInScope != null) {
                spanInScope.close();
            }
            span.finish();
            TracingThreadLocal.close();
        }
    }

    private static TraceContext intoContext() {
        long nextId = Platform.get().randomLong();
        return TraceContext.newBuilder()
                .sampled(true)
                .debug(true)
                .traceIdHigh(nextId)
                .traceId(nextId)
                .spanId(nextId).build();
    }


}
*/
