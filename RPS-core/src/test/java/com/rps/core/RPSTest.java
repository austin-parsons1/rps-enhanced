package com.rps.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RPSTest {

    @Test
    void play_shouldHavePlayer2WinWithPlayer1RockAndPlayer2Paper() {
        Outcome actual = RPS.play(Throw.PAPER, Throw.ROCK);

        assertEquals(Outcome.P2_WINS, actual);

    }


}