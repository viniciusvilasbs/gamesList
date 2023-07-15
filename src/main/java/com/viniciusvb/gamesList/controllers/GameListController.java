package com.viniciusvb.gamesList.controllers;

import com.viniciusvb.gamesList.dto.GameDTO;
import com.viniciusvb.gamesList.dto.GameListDTO;
import com.viniciusvb.gamesList.dto.GameMinDTO;
import com.viniciusvb.gamesList.dto.ReplacementDTO;
import com.viniciusvb.gamesList.entities.GameList;
import com.viniciusvb.gamesList.service.GameListService;
import com.viniciusvb.gamesList.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> allLists = gameListService.findAll();
        return allLists;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> findByListResult = gameService.findByList(listId);
        return  findByListResult;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void moveObj(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
