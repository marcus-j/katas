package de.marcusjanke.katas.battleship;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class BattleshipStats {

    private static final String REGEX_ALPHA = "[A-Z]";
    private static final String REGEX_NUMERIC = "[0-9]";
    private static final String REGEX_COORDINATE_SPLIT = ",";
    private static final String EMPTY = "";
    private static final List<String> ALPHABET = stream("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(EMPTY)).collect(toList());

    public String solution(int mapSize, String shipString, String hitString) {
        final List<List<String>> ships = stream(shipString.split(REGEX_COORDINATE_SPLIT))
                .map(coordinates -> coordinates.split(" "))
                .map(coordinateArray -> explodeCoordinates(coordinateArray[0], coordinateArray[1]))
                .collect(toList());
        final List<String> hits =  stream(hitString.split(" ")).collect(toList());

        long sunk = ships.stream().filter(ship -> isSunk(ship, hits)).count();
        long hitButNotSunk = ships.stream().filter(ship -> isHitButNotSunk(ship, hits)).count();

        return String.format("%s,%s", sunk, hitButNotSunk);
    }

    private boolean isSunk(List<String> ship, List<String> hits) {
        return hits.containsAll(ship);
    }

    private boolean isHitButNotSunk(List<String> ship, List<String> hits) {
        return !isSunk(ship, hits) && ship.stream().anyMatch(hits::contains);
    }

    private List<String> explodeCoordinates(String topLeft, String bottomRight) {
        int topLeftRow = Integer.parseInt(topLeft.replaceAll(REGEX_ALPHA,EMPTY));
        int topLeftColumn= ALPHABET.indexOf(topLeft.replaceAll(REGEX_NUMERIC,EMPTY)) + 1;
        int bottomRightRow = Integer.parseInt(bottomRight.replaceAll(REGEX_ALPHA, EMPTY));
        int bottomRightColumn= ALPHABET.indexOf(bottomRight.replaceAll(REGEX_NUMERIC, EMPTY)) + 1;

        final List<String> explodedCoordinates = new ArrayList<>();

        for (int row = topLeftRow; row <= bottomRightRow; row++) {
            for (int column = topLeftColumn; column <= bottomRightColumn; column++) {
                explodedCoordinates.add(row + ALPHABET.get(column-1));
            }
        }

        return explodedCoordinates;
    }
}