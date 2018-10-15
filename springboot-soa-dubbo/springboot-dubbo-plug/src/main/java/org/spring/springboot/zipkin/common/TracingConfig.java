/*
package org.spring.springboot.zipkin.common;

import brave.Tracer;
import brave.Tracing;
import brave.http.HttpTracing;
import brave.propagation.SamplingFlags;
import brave.propagation.TraceContext;
import brave.propagation.TraceContextOrSamplingFlags;
import com.alibaba.dubbo.common.utils.ConfigUtils;
import com.alibaba.dubbo.rpc.RpcContext;
import zipkin.reporter.AsyncReporter;
import zipkin.reporter.Encoding;
import zipkin.reporter.urlconnection.URLConnectionSender;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.reporter.kafka11.KafkaSender;

import java.util.Map;

import static brave.internal.HexCodec.lowerHexToUnsignedLong;

*/
/**
 * Tracing获取配置
 *
 * @author mongoding
 * @since 2017年11月04 11:30
 **//*

public class TracingConfig {
    private TracingConfig() {
        getTracer();
    }

    */
/**
     * kafka接受
     *//*

    public static final String KAFKA_CONTROLLER = "Kafka_Controller";
    */
/**
     * http接受
     *//*

    public static final String HTTP_CONTROLLER = "http_Controller";


    private static Tracer tracer;

    private static HttpTracing httpTracing() {
        Tracing myService = Tracing.newBuilder().localServiceName(getServiceName())
                //.spanReporter(getReporter())
                .build();
        return HttpTracing.newBuilder(myService).build();
    }

    private static void getTracer() {
        HttpTracing httpTracing = httpTracing();
        tracer = httpTracing.tracing().tracer();
    }

    private static TracingConfig tracingConfig;

    public static synchronized TracingConfig getSingle() {
        if (tracingConfig == null) {
            tracingConfig = new TracingConfig();
        }
        return tracingConfig;
    }


    private static String getServiceName() {
        String applicationName = ConfigUtils.getProperty("dubbo.application.name");
        String serviceName = PropertiesUtils.getProperty(DubboTraceConst.ZIP_CONF_NAME);
        if (applicationName == null || applicationName.trim().length() == 0) {
            applicationName =  RpcContext.getContext().getMethodName();
        }
        return serviceName == null || serviceName.trim().length() == 0 ? applicationName : serviceName;
    }

    private TraceContextOrSamplingFlags extract(Map<String, String> carrier) {
        String sampledString = carrier.get(DubboTraceConst.SAMPLED_NAME);

        Boolean sampled = sampledString != null
                ? "1".equals(sampledString) || "true".equalsIgnoreCase(sampledString)
                : null;
        boolean debug = "1".equals(carrier.get(DubboTraceConst.FLAGS_NAME));

        String traceIdString = carrier.get(DubboTraceConst.TRACE_ID_NAME);
        if (traceIdString == null) {
            return TraceContextOrSamplingFlags.create(
                    new SamplingFlags.Builder().sampled(true).debug(debug).build()
            );
        }

        TraceContext.Builder result = TraceContext.newBuilder().sampled(sampled).debug(debug);
        result.traceIdHigh(
                traceIdString.length() == 32 ? lowerHexToUnsignedLong(traceIdString, 0) : 0
        );
        result.traceId(lowerHexToUnsignedLong(traceIdString));
        String spanIdString = carrier.get(DubboTraceConst.SPAN_ID_NAME);
        if (spanIdString != null) {
            result.spanId(lowerHexToUnsignedLong(spanIdString));
        }
        String parentSpanIdString = carrier.get(DubboTraceConst.PARENT_SPAN_ID_NAME);
        if (parentSpanIdString != null) {
            result.parentId(lowerHexToUnsignedLong(parentSpanIdString));
        }
        return TraceContextOrSamplingFlags.create(result);
    }


    private brave.Span nextSpan(TraceContextOrSamplingFlags contextOrFlags) {
        TraceContext extracted = contextOrFlags.context();
        if (extracted != null) {
            if (extracted.sampled() != null) {
                return tracer.joinSpan(contextOrFlags.context());
            }
            return tracer.joinSpan(extracted.toBuilder()
                    .sampled(SamplingFlags.SAMPLED.sampled())
                    .build());
        }

        // There was no trace in the incoming requests. However, there might be sampling flags
        SamplingFlags flags = contextOrFlags.samplingFlags();
        if (flags.sampled() == null) {
            flags = new SamplingFlags.Builder()
                    .sampled(SamplingFlags.SAMPLED.sampled())
                    .debug(flags.debug()) // should always be false if unsampled!
                    .build();
        }
        return tracer.newTrace(flags);
    }

    public brave.Span handleReceive(Map<String, String> carrier) {
        brave.Span span = nextSpan(extract(carrier));
        if (span.isNoop()) {
            return span;
        }
        String path = RpcContext.getContext().getMethodName();
        if (path != null) {
            span.tag("rpc.methodName", path);
        }
        Endpoint.Builder remoteEndpoint = Endpoint.newBuilder();
        if (parseClientAddress(remoteEndpoint)) {
            span.remoteEndpoint(remoteEndpoint.build());
        }
        return span;
    }

    public boolean parseClientAddress(Endpoint.Builder builder) {
        String ip = RpcContext.getContext().getUrl().getIp();
        if (builder.parseIp(ip)) {
            builder.port(RpcContext.getContext().getUrl().getPort());
            return true;
        }
        return false;
    }

    private static AsyncReporter<Span> getReporter() {
        String kafkaUrl = PropertiesUtils.getProperty(DubboTraceConst.ZIP_KAFKA_CONF_URL);
        if (kafkaUrl == null || kafkaUrl.trim().length() == 0) {
            return sendHttpController();
        } else {
            return sendKafkaController();
        }
    }

    private static AsyncReporter<Span> sendKafkaController() {
        KafkaSender kafkaSender = KafkaSender.create(PropertiesUtils.getProperty(DubboTraceConst.ZIP_KAFKA_CONF_URL)).toBuilder().encoding(Encoding.JSON).build();
        return AsyncReporter.builder(kafkaSender).buildV2();
    }

    private static AsyncReporter<Span> sendHttpController() {
        URLConnectionSender json = URLConnectionSender.json(PropertiesUtils.getProperty(DubboTraceConst.ZIP_CONF_URL) + "/api/v2/spans");
        return AsyncReporter.builder(json).build();
    }
}
*/
