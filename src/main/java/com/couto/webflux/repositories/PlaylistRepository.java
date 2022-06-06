package com.couto.webflux.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.couto.webflux.documents.Playlist;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}
