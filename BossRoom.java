/* BOSSROOM.JAVA 
type "god" whilst moving to activate dev testing
This class should be a SUBCLASS of the Room class. 

/* Edris Adel
 * BossRoom SubClass of rooms
 */
import java.util.Scanner;
import java.lang.Math;

public class BossRoom extends Rooms { // bossroom instead will have enemies inside them. (EXTENSTION)
	int currentID;		//initialize the variables
	String userInput;
	int bosshp;
	int bossatk;
	boolean bossalive = true;
	public static Scanner scan = new Scanner(System.in);
	boolean fight = false;

	String roomPicture =    //me and akram found the replace function which replaces whatever character in a string with whatever we wanted, so we only have one room image
			  "|========================================================================|\n"
			+ "|                              n     n                                   |\n"
			+ "|                              n     n                                   |\n"
			+ "|                              n     n                                   |\n"
			+ "|                              n     n                                   |\n"
			+ "|                              n     n                                   |\n"
			+ "|                              n#NNN#n                                   |\n"
			+ "|wwwwwwwwwwwwwwwwwwwwwwwwwwwwww#     #eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee|\n"
			+ "|                           P   ,X                                  |\n"
			+ "|wwwwwwwwwwwwwwwwwwwwwwwwwwwwww#     #eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee|\n"
			+ "|                              s#SSS#s                                   |\n"
			+ "|                              s     s                                   |\n"
			+ "|                              s     s                                   |\n"
			+ "|                              s     s                                   |\n"
			+ "|                              s     s                                   |\n"
			+ "|========================================================================|";

	BossRoom(int roomnumber, int n, int w, int s, int e, int hp, int atk, boolean alive) {  //constructors
		super(roomnumber, n, w, s, e);
		this.currentID = roomnumber;
		this.ndestination = n;
		this.sdestination = s;
		this.wdestination = w;
		this.edestination = e;
		this.bosshp = hp;
		this.bossalive = alive;
		this.bossatk = atk;
	}

	public void drawRoom() {  // overrides normal drawroom so if it is a boss room, it draws it differently
		if (npath) {
			north = "|";   // if there is a path upwards, then we replace all the n's in the roompicture, with lines to represent a pathway
			Nc = " ";      // extra details.
		} else { 		   // else
			north = " ";   // make the n's disappear to signify that there is no way north.
			Nc = "=";
		}
		if (spath) {	   // same for south, west, and east.
			south = "|";
			Sc = " ";
		} else {
			south = " ";
			Sc = "=";
		}
		if (wpath) {
			west = "=";
			Wc = " ";
		} else {
			west = " ";
			Wc = "|";
		}
		if (epath) {
			east = "=";
			Ec = " ";
		} else {
			east = " ";
			Ec = "|";
		}

		roomPicture = roomPicture.replaceAll("n", north);  // this replaces all of the characters said above, and we make this equal to our modified roompicture
		roomPicture = roomPicture.replaceAll("N", Nc);
		roomPicture = roomPicture.replaceAll("e", east);
		roomPicture = roomPicture.replaceAll("E", Ec);
		roomPicture = roomPicture.replaceAll("w", west);
		roomPicture = roomPicture.replaceAll("W", Wc);
		roomPicture = roomPicture.replaceAll("s", south);
		roomPicture = roomPicture.replaceAll("S", Sc);
		roomPicture = roomPicture.replaceAll("P", P);
		s.s(roomPicture);							// so we can print it no matter what room we are in.
		
		
		if (this.bossalive) {		// if boss is alive,
			s.s("You have entered A bossroom!");	
			fight = true;			// activate a condition
			while (fight) {
				inititateFight();	//whilst we are fighting,
			}
		}

		if (!fight && !bossalive) {	//if there is no enemy anymore 
			roomPicture = roomPicture.replaceAll(",X", "  ");	//we get rid of our enemy icon
			s.s("There seems to be no enemy anymore...");
		} 
		if (player.getHP() > 0) {	// this will only print whilst we are alive
		s.s("Your HP:" + player.getHP() + "\n\nCurrent RoomID: " + currentID + "\nw = " + ndestination + " a = " + wdestination + "\ns = " + sdestination + " and d = " + edestination);
		} else {	// gg we lost because we have negative / zero hp
			s.s("You took too much damage, and have perished... Good luck next time.");
		}
	}

	public void inititateFight() {

		int max = bossatk + bossatk / 2;  // the enemies damage is variable. meaning it deals a range of damage
		int min = bossatk - ((bossatk - 1) / 2);
		int range = max - min;

		if (this.bossalive) { // make sure that the enemy is there.
			while (fight) {   //          and that we are fighting.
				s.s(" What do you want to do? \n"
						+ " Attack 1: Regular Dash Base Dmg = -" + player.getAtk() + "HP\n"
						+ " Attack 2: Vampire Life Steal Base Dmg = -" + player.getAttk() + "HP\n"
						+ " Enemy HP: "+ this.bosshp + "\n"
            + " Enemy Base Dmg: "+ this.bossatk + " Atk\n"
						+ " Your HP:" + player.getHP());
				userInput = scan.nextLine();
//damage calculations
				if (userInput.equals("1") || userInput.equals("2")) {
					s.s("You exchanged hits!");
          this.bosshp -= player.attack(userInput);	// the enemy takes damage depending on our player.attack(input) function
					player.setHP((player.getHP() - ((int) (Math.random() * range) + min)));   // player's hp is set to the hp minus the variable damage given by our random function and these fights are not order based, you will hit each other at the same time, meaning its possible to kill the enemy, and the enemy kills you and results in the losing screen

				} else {
					s.s("Oops, you have to press either 1, or 2 for attacks!");//catches if we say anything other than 1 or 2
				}

				if (this.bosshp <= 0) {	//if the enemy dies,
					fight = false;		// we break our condition
					this.bossalive = false;	//make this specific enemy dead
					roomPicture = roomPicture.replaceAll(",X", "  ");
					s.s(roomPicture + "");	// and print our new room
				}
				if (player.getHP() <= 0) {	//if we die
					fight = false;			// we break the condition
					Player.lose = true; 	// and we start the losing screen
				}

			}

		}
	}
}
