package com.viniciusvb.gamesList.dto;

import com.viniciusvb.gamesList.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(){
    }

    public GameListDTO(GameList entityList) {
        this.id = entityList.getId();
        this.name = entityList.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
