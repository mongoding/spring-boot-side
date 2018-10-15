package org.spring.springboot.zipkin.common;

/**
 * Zipkin中默认rpc调用默认key名
 *
 * @author mongoding
 * @since 2017年11月02 15:52
 **/
public class DubboTraceConst {

    /**
     * 全局唯一key
     * 128 or 64-bit trace ID lower-hex encoded into 32 or 16 characters (required)
     */
    public static final String TRACE_ID_NAME = "traceId";
    /**
     * 一次rpc调用一个span
     * 64-bit span ID lower-hex encoded into 16 characters (required)
     */
    public static final String SPAN_ID_NAME = "spanId";
    /**
     * 64-bit parent span ID lower-hex encoded into 16 characters (absent on root span)
     */
    public static final String PARENT_SPAN_ID_NAME = "parentSpanId";
    /**
     * "1" means report this span to the tracing system, "0" means do not. (absent means defer the
     * decision to the receiver of this header).
     */
    public static final String SAMPLED_NAME = "sampled";
    /**
     * 是否收集数据
     * "1" implies sampled and is a request to override collection-tier sampling policy.
     */
    public static final String FLAGS_NAME = "flags";
    /**
     * zipkin服务器地址
     */
    public static final String ZIP_CONF_URL = "zipkin.serviceUrl";
    /**
     * 服务名称
     */
    public static final String ZIP_CONF_NAME = "zipkin.serviceName";
    /**
     * KAFKA 服务器地址
     */
    public static final String ZIP_KAFKA_CONF_URL = "kafka.serviceUrl";

}
