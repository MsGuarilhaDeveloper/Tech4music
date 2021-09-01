package com.br.tech4me.tech4music.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.br.tech4me.tech4music.model.Music;
import com.br.tech4me.tech4music.service.MusicService;
import com.br.tech4me.tech4music.shared.MusicDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tech4music")
public class MusicController {
    @Autowired
    private MusicService servico;


    @GetMapping
    public ResponseEntity<List<Music>> obterMusic(){
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<MusicDTO> obterPorId(@PathVariable String id){
        Optional<MusicDTO> music = servico.obterPorId(id);

        if (music.isPresent()){
            return new ResponseEntity<>(music.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<MusicDTO> criarMusic(@RequestBody @Valid Music music){
        return new ResponseEntity<>(servico.criarMusic(music), HttpStatus.CREATED);
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> removerMusic(@PathVariable String id){
        servico.removerMusic(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<MusicDTO> atualizarMusic(@PathVariable String id, @RequestBody Music musicNovo){
        return new ResponseEntity<>(servico.atualizarMusic(id, musicNovo), HttpStatus.OK);
    }

}
