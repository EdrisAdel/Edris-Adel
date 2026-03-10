
# OOP Maze Game (VampEscapade)

A small **console/terminal** maze game written in Java. You play as a vampire trying to navigate an ASCII maze, occasionally entering **boss rooms** where you must win a short turn-based fight to continue.

Each room prints your current HP, current room ID, and the destination room IDs for each direction.

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
