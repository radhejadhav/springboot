package com.microservices.zuulApiGateway.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreFilter extends ZuulFilter {
	
	private Logger log = LoggerFactory.getLogger(PreFilter.class);

	public String filterType() {
		return "pre";
	}

	public int filterOrder() {
		return 6;
	}

	public boolean shouldFilter() {
		return true;
	}

	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("Request:"+request+" Request Url: "+request.getRequestURL());
		return null;
	}
}
