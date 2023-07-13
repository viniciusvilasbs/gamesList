package com.viniciusvb.gamesList.repositories;

import com.viniciusvb.gamesList.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
