package com.nebula.app.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info("Entrando a post");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoTranscurrido = tiempoFinal - tiempoInicio;
		log.info(String.format("Tiempo transcurrido en segundos %s seg", tiempoTranscurrido.doubleValue()/100.00));
		log.info(String.format("Tiempo transcurrido en milisegundos %s ms", tiempoTranscurrido.doubleValue()));
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
