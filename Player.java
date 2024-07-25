/*
 * Edris Adel 
 * Player Class
 */
public class Player {
	private int hp; // hitpoints
	private int atk;// main attack
	private int atk2;// secondary attack
	static boolean lose;// a condition to check if we lose

	public Player(int hp1, int attk1, int attk2) {
		this.hp = hp1;
		this.atk = attk1;
		this.atk2 = attk2; // constructors
	}

	public int getHP() {	//getters
		return this.hp;
	}

	public int getAtk() {
		return this.atk;   // getter
	}

	public int getAttk() {
		return this.atk2;  // getter
	}

	public int attack(String input) {  // damage calculation
		if (input.equals("1")) {
			// dash atk apprx a 15% chance to critical
			int max = getAtk();
			int min = getAtk() - (getAtk() - 1) / 2;
			int range = max - min;
			if ((Math.random() * range) + min > 6.2) {// math.random {0.01 - 0.99}  // 6.2 is the base line to see if we critical or not
				// 2.0 + 4
				s.s("You hit a CRITICAL HIT!");
				return 11;   // our attack does now base 11 damage!
			}
			return (int) (Math.random() * range) + min;
			// if we dont crit, we just deal this amount of damage
		}
		if (input.equals("2")) {
			// life steal apprx 50% chance to crit
			int max2 = getAttk();
			int min2 = getAttk() - 1;
			int range2 = max2 - min2 + 1;
			int rand = (int) (Math.random() * range2) + min2;
			if ((Math.random() * range2) + min2 > 2) { // another base line
				s.s("You hit a CRITICAL HIT!");
				this.hp += 4; //since our base damage is 4, we give 4 hp since we deal that much damage
				return 4;
			}
			this.hp += rand;	//otherwise we deal and gain the random amount of damage as hp
			return rand;
		}
		return 0;	// if nothing has been pressed and went through, we return
	}

	public void setHP(int i) { //setters
		this.hp = i;
	}

}
