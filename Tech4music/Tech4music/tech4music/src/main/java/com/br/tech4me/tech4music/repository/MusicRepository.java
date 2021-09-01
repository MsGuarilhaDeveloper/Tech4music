package com.br.tech4me.tech4music.repository;

import com.br.tech4me.tech4music.model.Music;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicRepository extends MongoRepository<Music, String>{
    
}
