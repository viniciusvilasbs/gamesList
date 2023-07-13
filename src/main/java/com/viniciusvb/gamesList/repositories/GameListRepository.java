package com.viniciusvb.gamesList.repositories;

import com.viniciusvb.gamesList.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
