package com.viniciusvb.gamesList.service;

import com.viniciusvb.gamesList.dto.GameMinDTO;
import com.viniciusvb.gamesList.entities.Game;
import com.viniciusvb.gamesList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> allGamesList = gameRepository.findAll();
        return allGamesList.stream()
                .map(game -> new GameMinDTO(game))
                .toList();
    }
}