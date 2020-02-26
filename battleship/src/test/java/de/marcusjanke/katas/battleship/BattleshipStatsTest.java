package de.marcusjanke.katas.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleshipStatsTest {

    private final BattleshipStats battleshipStats = new BattleshipStats();

    @Test
    void shouldIdentifySunkShip() {
        assertEquals("1,0", battleshipStats.solution(12, "1A 2A,4A 4A", "4A"));
        assertEquals("2,0", battleshipStats.solution(12, "1A 2A,12A 12A", "12A 1A 2A 1B 2B"));
    }

    @Test
    void shouldIdentifyPartiallyHitShip() {
        assertEquals("0,1", battleshipStats.solution(12, "1A 2A,4A 4A", "2A"));
        assertEquals("0,2", battleshipStats.solution(12, "1A 2A,12A 12B", "2A 12B"));
    }
}