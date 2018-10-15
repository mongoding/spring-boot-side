package org.spring.springboot.base.chain.arrayfor;

public class SensitiveFilter implements Filter {

	@Override
	public String doFilter(String str) {
		//process the sensitive words
		String r = str.replace("被就业", "就业")
			 .replace("敏感", "");
		
		return r;
	}

}
