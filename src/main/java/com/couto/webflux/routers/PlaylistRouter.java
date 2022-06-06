package com.couto.webflux.routers;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.couto.webflux.handler.PlaylistHandler;

//Essa classe onde as rotas do webflux serão montadas

@Configuration
public class PlaylistRouter {
	
	@Bean
	public RouterFunction<ServerResponse> route(PlaylistHandler handler){
		return RouterFunctions
				.route(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), handler::getAllPlaylist)
				.andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::getPlaylistById)
				.andRoute(POST("/playlist").and(accept(MediaType.APPLICATION_JSON)), handler::savePlaylist);
	}

}
