package com.couto.webflux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couto.webflux.documents.Playlist;
import com.couto.webflux.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
	
	@Autowired
	private PlaylistService playlistService;

	@GetMapping
	public Flux<Playlist> getAllPlaylist(){
		return playlistService.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Playlist> getAllPlaylist(@PathVariable String id){
		return playlistService.findById(id);
	}
	
	@PostMapping
	public Mono<Playlist> savePlaylist(@RequestBody Playlist playlist){
		return playlistService.save(playlist);
	}
}
