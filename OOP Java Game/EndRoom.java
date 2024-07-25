/* Edris Adel
 * Endroom subClass of Rooms
 */
public class EndRoom extends Rooms {
	int roomID;

	public EndRoom(int roomnumber, int n, int w, int s, int e) {
		super(roomnumber, n, w, s, e);
		this.roomID = roomnumber;
	}

	public void drawRoom() { // if we are in the endroom, we congratulate the player for winning
		if(player.getHP() > 0) {
		s.s("Thanks for playing! You have escaped the maze as a vampire, but realized as soon as you stepped out, the sun rays hit you, and you died. GG");
		s.s(	  "|========================================================================|\n"
				+ "|                                                                        |\n"
				+ "|                          :D                                            |\n"
				+ "|                                                                        |\n"
				+ "|                                                    :D                  |\n"
				+ "|                  :D                                                    |\n"
				+ "|                                                                        |\n"
				+ "|                                        *blood*                         |\n"
				+ "|                   :D             (^ᵥᵥ^)                                |\n"
				+ "|                                                                        |\n"
				+ "|                                     :D                                 |\n"
				+ "|                       :D                                               |\n"
				+ "|                                                                        |\n"
				+ "|                                                                        |\n"
				+ "|                                                                        |\n"
				+ "|========================================================================|");
		Main.gameState++;
		} else {
			s.s("How did we get here?");  // if we somehow reach the end with zero hp or lower.
			Main.scan.close();
		}
	}
}
