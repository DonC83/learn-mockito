package com.donc.testing;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by donovan on 31/10/16.
 */
@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    private static final int ANY_NUMBER = 1;

    private Object[] getGamesWon() {
        return new Object[] {
                1,2,3,4,5
        };
    }
    
    private Object[] getIllegalGamesWon() {
        return new Object[] {
                -10, -3
        };
    }

    @Test
    @Parameters(method = "getGamesWon")
    public void constuctorShouldSetGamesWon(final int gamesWon) throws Exception {
        FootballTeam team = new FootballTeam(gamesWon);
        assertEquals(gamesWon +" games were passed to the constructor but " + team.getGamesWon() + " was returned",
                gamesWon, team.getGamesWon());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getIllegalGamesWon")
    public void constructorShouldThrowIAE(final int gamesWon) throws IllegalArgumentException {
        new FootballTeam(gamesWon);
    }

    @Test
    public void classShouldBeComparable() throws Exception {
        FootballTeam team = new FootballTeam(ANY_NUMBER);
        assertTrue(team.getClass().getName() + " should implement Comparable", team instanceof Comparable);
    }

    @Test
    public void teamsWithMoreWinShouldBeGreater() throws Exception {
        FootballTeam teamA = new FootballTeam(1);
        FootballTeam teamB = new FootballTeam(2);
        assertTrue("teamA with " + teamA.getGamesWon() + " win should be ranked below teamB with " +
                teamB.getGamesWon() + " wins", teamB.compareTo(teamA) > 0);
    }

    @Test
    public void teamsWithLessWinsShouldBeLesser() throws Exception {
        FootballTeam teamA = new FootballTeam(1);
        FootballTeam teamB = new FootballTeam(2);
        assertTrue("teamB with " + teamB.getGamesWon() + " win should be ranked above teamA with " +
                teamA.getGamesWon() + " wins", teamA.compareTo(teamB) < 0);
    }

    @Test
    public void teamsWithSameWinsShouldBeEqual() throws Exception {
        FootballTeam teamA = new FootballTeam(1);
        FootballTeam teamB = new FootballTeam(1);
        assertTrue("teamA with " + teamA.getGamesWon() + " should be equal in rank with teamB with " + teamB.getGamesWon(),
                teamA.compareTo(teamB)==0);

    }
}

