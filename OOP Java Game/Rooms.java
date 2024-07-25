/* Edris Adel
 * Rooms SuperClass
 */
public class Rooms {

	int roomID;  //initializing
	boolean epath;
	boolean spath;
	boolean npath;
	boolean wpath;
	int ndestination;
	int sdestination;
	int wdestination;
	int edestination;
	static Player player = new Player(25, 7, 2);  // our STATIC player will be here, if not static, we call a new object in each room

	String roomPicture =  //me and akram found the replace function which replaces whatever character in a string with whatever we wanted, so we only have one room image
			  "|========================================================================|\n"
			+ "|                              n     n                                   |\n"
			+ "|                              n     n                                   |\n"
			+ "|                              n     n                                   |\n"
			+ "|                              n     n                                   |\n"
			+ "|                              n     n                                   |\n"
			+ "|                              n     n                                   |\n"
			+ "|wwwwwwwwwwwwwwwwwwwwwwwwwwwwww#NNNNN#eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee|\n"
			+ "|                               P                                   |\n"
			+ "|wwwwwwwwwwwwwwwwwwwwwwwwwwwwww#SSSSS#eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee|\n"
			+ "|                              s     s                                   |\n"
			+ "|                              s     s                                   |\n"
			+ "|                              s     s                                   |\n"
			+ "|                              s     s                                   |\n"
			+ "|                              s     s                                   |\n"
			+ "|========================================================================|";
	
	String north = "n", east = "e", south = "s", west = "w", Nc = "N", Wc = "W", Ec = "E", Sc = "S", P = "(oᵥᵥo)";
			 //xC is the capital version of the letters to close off the path if it is not there."
	
	public void drawRoom() {
		if (npath) {
			north = "|";  // if there is a path upwards, then we replace all the n's in the roompicture, with lines to represent a pathway
			Nc = " ";
		} else {
			north = " ";
			Nc = "=";
		}
		if (spath) {
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
		
		roomPicture = roomPicture.replaceAll("n", north); roomPicture = roomPicture.replaceAll("e", east);   //explained just like in bossrooms
		roomPicture = roomPicture.replaceAll("w", west);  roomPicture = roomPicture.replaceAll("s", south);
		roomPicture = roomPicture.replaceAll("N", Nc);    roomPicture = roomPicture.replaceAll("E", Ec);
		roomPicture = roomPicture.replaceAll("W", Wc);    roomPicture = roomPicture.replaceAll("S", Sc);
		roomPicture = roomPicture.replaceAll("P", P);
		s.s(roomPicture);
		s.s("What room do you want to go to?(Type w for north, a for west, d for east, s for south.) \n"   // tells the user their choices and hp stat, as well as what room they are in.
				+   "Your HP: " + player.getHP() + "\n\nCurrent RoomID: " + this.roomID);

		s.s("w = " + this.ndestination + " a = " + this.wdestination + "\ns = " + this.sdestination + " and d = " + this.edestination); // which room leads where
		
	}

	// Rooms( roomID, north up, west left , south down, , east right) constructors
	// to not be confused
	Rooms(int roomnumber, int n, int w, int s, int e) {
		roomID = roomnumber;
		this.ndestination = n;
		this.sdestination = s;
		this.wdestination = w;
		this.edestination = e;
		this.npath = !(roomID == this.ndestination);  // we make sure there's a path by making sure that the roomid is not equal to the destination roomid.
		this.epath = !(roomID == this.edestination);
		this.wpath = !(roomID == this.wdestination);
		this.spath = !(roomID == this.sdestination);
	}

	public int moveRoom(String input) { // wasd = north,west,south,east
		if (input.equalsIgnoreCase("w")) { // north = w
			if (npath) {    // checking if you can go up.
				return this.ndestination;
			} else {
				s.s("you bonked ur head silly");  // haha you hit your head
			}
		}
		if (input.equalsIgnoreCase("s")) { // south = s
			if (spath) {     //chck
				return this.sdestination;
			}
		}
		if (input.equalsIgnoreCase("a")) { // west = a
			if (wpath) {	//chck
				return this.wdestination;
			}
		}
		if (input.equalsIgnoreCase("d")) { // east = d
			if (epath) {		//chck
				return this.edestination;
			}
		}
		if (input.equalsIgnoreCase("god")) { //type god to test the game like a real devtester
			player.setHP(999);  // dev method
		}
		s.s("ERROR 1690. Invalid Choice (TIP: Slow down with the inputs.)");
		//if anything else is said that is not valid, we hit them with an error
		return this.roomID; // return same roomId so we dont move.
	}
}
