# Battleship Kata

So what's the task? For a given state of the game [Battleship](https://en.wikipedia.org/wiki/Battleship_(game)), 
we would like to know how many ships have been partially hit and how many ships have been fully hit (aka sunk) so far.

## Interface

The method signature is given as follows:

```java
public String solution(int mapSize, String shipString, String hitString);
```

* The `map size` _n_  defines the size of a square map with 
  * _n_ rows and _n_ columns,
  * values for n between 1 and 26
  * columns being identified by letters from A to Z
  * row being identified by number between 1 and 26
* The `ship string` defines the current coordinates of a player's ships, e.g. "1A 2A,4A 4A"
  * The format includes tuples of coordinates separated by commas.
  * the list is unordered
  * Ships always have a rectangular format.  
  * Each tuple consists of a coordinate for the top left and bottom right coordinate of a ship separate by a space, e.g.:
    * "4A 4A" includes the cells 4A,
    * "1A 2A" includes the cells 1A and 2A,
    * "1A 2B" includes the cells 1A, 2A, 2A and 2B
* The `hit string` defines the current coordinates of correct hits, e.g. "2B 12A 4C"
  * The format includes coordinates separated by spaces.
  * the list is unordered
* The `return value` of the method provides the amount of hit ships partially hit and fully hit (aka sunk) ships, e.g. "1,0"
  * the first value denotes the amount of fully hit (aka sunk) ships
  * the first value denotes the amount of partially hit ships
  * "2,1" would indicate two sunk ships and one partially hit ship
