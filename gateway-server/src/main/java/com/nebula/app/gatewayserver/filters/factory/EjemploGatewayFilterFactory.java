package com.nebula.app.gatewayserver.filters.factory;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class EjemploGatewayFilterFactory extends AbstractGatewayFilterFactory<Configuracion> {

	private final Logger logger = LoggerFactory.getLogger(EjemploGatewayFilterFactory.class);
	
	public EjemploGatewayFilterFactory() {
		super(Configuracion.class);
	}

	@Override
	public GatewayFilter apply(Configuracion config) {
		return (exchange, chain) -> {
			
			logger.info("ejecutando pre gateway filter factory " + config.getMessage());

			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				Optional.ofNullable(config.getCookieValor()).ifPresent(cookie -> {
					exchange.getResponse().addCookie(ResponseCookie.from(config.getCoolieNombre(), cookie).build());
				});
				
				logger.info("ejecutando post gateway filter factory " + config.getMessage());
			}));
		};
	}

	
}
