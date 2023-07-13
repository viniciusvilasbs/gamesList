package com.viniciusvb.gamesList.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
    @EmbeddedId
    private BelongingPK belongingPKId = new BelongingPK();
    private Integer position;

    public Belonging(){
    }

    public Belonging(Game game, GameList gameList, Integer position) {
        this.belongingPKId.setGame(game);
        this.belongingPKId.setGameList(gameList);
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(belongingPKId, belonging.belongingPKId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(belongingPKId);
    }

    public BelongingPK getBelongingPKId() {
        return belongingPKId;
    }

    public void setBelongingPKId(BelongingPK belongingPKId) {
        this.belongingPKId = belongingPKId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
