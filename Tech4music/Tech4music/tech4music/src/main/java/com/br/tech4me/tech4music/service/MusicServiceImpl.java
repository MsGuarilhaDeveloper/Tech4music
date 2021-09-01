package com.br.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import com.br.tech4me.tech4music.model.Music;
import com.br.tech4me.tech4music.repository.MusicRepository;
import com.br.tech4me.tech4music.shared.MusicDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepository repositorio;

    @Override
    public MusicDTO criarMusic(Music music){
        repositorio.save(music);

        return new ModelMapper().map(music, MusicDTO.class);
    }

    @Override
    public List<Music> obterTodos(){
        return repositorio.findAll();
    }

    @Override
    public Optional<MusicDTO> obterPorId(String id){
        Optional<Music> music = repositorio.findById(id);


        if (music.isPresent()){
            return Optional.of(new ModelMapper().map(music.get(), MusicDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public void removerMusic(String id){
        repositorio.deleteById(id);
    }

    @Override
    public MusicDTO atualizarMusic(String id, Music musicNovo){
        musicNovo.setId(id);
        repositorio.save(musicNovo);
        return new ModelMapper().map(musicNovo, MusicDTO.class);
    }
}
