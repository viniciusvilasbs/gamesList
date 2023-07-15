package com.viniciusvb.gamesList.service;

import com.viniciusvb.gamesList.dto.GameListDTO;
import com.viniciusvb.gamesList.dto.GameMinDTO;
import com.viniciusvb.gamesList.entities.GameList;
import com.viniciusvb.gamesList.projections.GameMinProjection;
import com.viniciusvb.gamesList.repositories.GameListRepository;
import com.viniciusvb.gamesList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> allListsResult = gameListRepository.findAll();
        return allListsResult.stream()
                .map(gameList -> new GameListDTO(gameList))
                .toList();
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> gameMinProjectionsList = gameRepository.searchByList(listId);

        GameMinProjection movedObj = gameMinProjectionsList.remove(sourceIndex);
        gameMinProjectionsList.add(destinationIndex, movedObj);

        int minimum = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int maximum = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = minimum; i < maximum; i++) {
            gameListRepository.updateBelongingPosition(listId, gameMinProjectionsList.get(i).getId(), i);
        }
    }
}
