package com.br.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import com.br.tech4me.tech4music.model.Music;
import com.br.tech4me.tech4music.shared.MusicDTO;

public interface MusicService {
    MusicDTO criarMusic(Music music);
    List<Music> obterTodos();
    Optional<MusicDTO> obterPorId(String id);
    void removerMusic(String id);
    MusicDTO atualizarMusic(String id, Music music);
}
