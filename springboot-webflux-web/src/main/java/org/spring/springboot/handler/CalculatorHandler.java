package org.spring.springboot.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.function.BiFunction;

@Component
public class CalculatorHandler {

    public Mono<ServerResponse> add(final ServerRequest request) {
        return calculate(request, (v1, v2) -> v1 + v2);
    }

    public Mono<ServerResponse> subtract(final ServerRequest request) {
        return calculate(request, (v1, v2) -> v1 - v2);
    }

    public Mono<ServerResponse> multiply(final ServerRequest request) {
        return calculate(request, (v1, v2) -> v1 * v2);
    }

    public Mono<ServerResponse> divide(final ServerRequest request) {
        return calculate(request, (v1, v2) -> v1 / v2);
    }

    private Mono<ServerResponse> calculate(final ServerRequest request,
                                           final BiFunction<Integer, Integer, Integer> calculateFunc) {
        final Tuple2<Integer, Integer> operands = extractOperands(request);
        return ServerResponse
                .ok()
                .body(Mono.just(calculateFunc.apply(operands.getT1(), operands.getT2())), Integer.class);
    }

    private Tuple2<Integer, Integer> extractOperands(final ServerRequest request) {
        return Tuples.of(parseOperand(request, "v1"), parseOperand(request, "v2"));
    }

    private int parseOperand(final ServerRequest request, final String param) {
        try {
            return Integer.parseInt(request.queryParam(param).orElse("0"));
        } catch (final NumberFormatException e) {
            return 0;
        }
    }
}