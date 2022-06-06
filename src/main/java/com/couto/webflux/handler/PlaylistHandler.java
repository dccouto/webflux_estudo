package com.couto.webflux.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.couto.webflux.documents.Playlist;
import com.couto.webflux.services.PlaylistService;

import reactor.core.publisher.Mono;

@Component
public class PlaylistHandler {

	@Autowired
	private PlaylistService playlistService;
	
	public Mono<ServerResponse> getAllPlaylist(ServerRequest request){
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(playlistService.findAll(), Playlist.class);
	}
	
	public Mono<ServerResponse> getPlaylistById(ServerRequest request){
		String id = request.pathVariable("id");
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(playlistService.findById(id), Playlist.class);
	}
	
	public Mono<ServerResponse> savePlaylist(ServerRequest request){
		final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(playlist.flatMap(playlistService::save), Playlist.class));
	}
}
