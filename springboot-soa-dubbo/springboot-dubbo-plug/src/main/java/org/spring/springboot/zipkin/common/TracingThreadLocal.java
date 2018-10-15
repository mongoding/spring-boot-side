package org.spring.springboot.zipkin.common;

import brave.propagation.TraceContext;

/**
 * @author mongoding
 * @since 2018年03月30 16:15
 **/
public class TracingThreadLocal {
    private static ThreadLocal<TraceContext> local  = new InheritableThreadLocal<>();

    public static TraceContext get() {
        return local.get();
    }
    public static void set(TraceContext context) {
        local.set(context);
    }

    public static void close() {
        local.remove();
    }


}
