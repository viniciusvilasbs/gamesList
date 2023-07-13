package com.viniciusvb.gamesList.service;

import com.viniciusvb.gamesList.dto.GameListDTO;
import com.viniciusvb.gamesList.dto.GameMinDTO;
import com.viniciusvb.gamesList.entities.GameList;
import com.viniciusvb.gamesList.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> allListsResult = gameListRepository.findAll();
        return allListsResult.stream()
                .map(gameList -> new GameListDTO(gameList))
                .toList();
    }
}
