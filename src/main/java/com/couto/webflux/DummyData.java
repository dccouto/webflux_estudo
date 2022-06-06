package com.couto.webflux;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.couto.webflux.documents.Playlist;
import com.couto.webflux.repositories.PlaylistRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

/**
 * Classe que irá inserir alguns dados iniciais no banco de dados ao rodar a aplicação
 * */
/*
 * @AllArgsConstructor
 * 
 * @Component public class DummyData implements CommandLineRunner{
 * 
 * private final PlaylistRepository playlistRepository;
 * 
 * 
 * 
 * @Override public void run(String... args) throws Exception {
 * 
 * playlistRepository.deleteAll() .thenMany( Flux.just("API REST","AWS",
 * "Oracle Cloud","Certificação Java","Spring boot") .map(nome -> new
 * Playlist(UUID.randomUUID().toString(), nome))
 * .flatMap(playlistRepository::save)) .subscribe(System.out::println);
 * 
 * }
 * 
 * }
 */
