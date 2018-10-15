package org.spring.springboot.base.chain.array;

public interface Filter {
	void doFilter(Request request, Response response, FilterChain fc);
}
