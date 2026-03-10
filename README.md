
# OOP Maze Game (VampEscapade)

A small **console/terminal** maze game written in Java. You play as a vampire trying to navigate an ASCII maze, occasionally entering **boss rooms** where you must win a short turn-based fight to continue.

## Requirements

- Java **JDK 8+** (so you have `javac` and `java` available)
- A terminal (PowerShell, CMD, macOS Terminal, etc.)

## Run

From the project folder:

```bash
# 1) Compile
javac *.java

# 2) Run
java Main
```

If compilation succeeds, you’ll see a title screen—press **Enter** to start.

## How To Play

### Movement

- Type:
	- `w` = north (up)
	- `a` = west (left)
	- `s` = south (down)
	- `d` = east (right)

Each room prints your current HP, current room ID, and the destination room IDs for each direction.

If you try to move into a blocked direction, you stay in the same room (you’ll also get a message like “bonked ur head”).

### Combat (Boss Rooms)

Some rooms contain an enemy. When you enter one of these rooms, combat starts automatically.

During combat, type:

- `1` — **Regular Dash** (higher base damage, low crit chance)
- `2` — **Vampire Life Steal** (lower damage, medium crit chance, heals you by the damage dealt)

You and the enemy exchange hits each turn. If your HP drops to **0 or below**, you lose.

### Winning / Ending

- You start in room **0**.
- Reaching the **end room** (room **7**) ends the game.

## Dev / Testing

There is a simple cheat for testing:

- While moving between rooms, type `god` to set your HP to **999**.

## Project Structure (Quick Tour)

- `Main.java`
	- Creates the room graph (IDs `0`–`63`)
	- Runs the main game loop and delegates to the current room
- `Rooms.java`
	- Base room class: renders the ASCII room and handles movement (`moveRoom`)
	- Holds a static `Player` instance shared across all rooms
- `BossRoom.java`
	- Subclass of `Rooms` that overrides `drawRoom()` to start combat when an enemy is alive
- `EndRoom.java`
	- Subclass of `Rooms` that prints the ending and exits the game
- `Player.java`
	- Player stats + attack logic (including crit/life steal behavior)
- `Title.java`
	- Title screen / intro text
- `s.java`
	- Tiny helper wrapper around `System.out.println`

## Notes

- The maze layout is defined in `Main.java` via the `Rooms[]` array. To change the map, edit those room connections.
- Boss rooms are currently created in `Main.java` (e.g., IDs like `3`, `6`, `22`, `24`, `33`, `39`, `41`, `59`, `60`).

