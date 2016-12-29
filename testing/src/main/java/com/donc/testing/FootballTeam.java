package com.donc.testing;

import static com.google.common.base.Preconditions.*;

/**
 * Created by donovan on 31/10/16.
 */
public class FootballTeam implements Comparable<FootballTeam> {

    private int gamesWon;

    public FootballTeam(int gamesWon) {
        checkArgument(gamesWon>=0);
        this.gamesWon = gamesWon;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    @Override
    public int compareTo(FootballTeam o) {
        return gamesWon-o.getGamesWon();
    }

}
