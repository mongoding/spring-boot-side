package org.spring.springboot.base.chain.array;


public class Main {
	public static void main(String[] args) {
		String msg = "hello";
		Request request = new Request();
		request.setRequestStr(msg);
		Response response = new Response();
		response.setResponseStr("response");
		FilterChain fc = new FilterChain();
		fc.addFilter(new HTMLFilter())
		  .addFilter(new SensitiveFilter())
		  ;
		
		fc.doFilter(request, response, fc);
		System.out.println(request.getRequestStr());
		System.out.println(response.getResponseStr());
	}

}
