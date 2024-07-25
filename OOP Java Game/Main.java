import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);  
	public static int gameState;  //static game state int to change it across classes

	public static void main(String[] args) {
		// vampire adventure type guy
		// Rooms( roomID, north up or w, west left or a, south down or s, , east right
		// or d) constructors to not be confused
		Rooms[] Rooms = new Rooms[] {   // rooms, see image for reference to these rooms placements.
				 new Rooms(0, 0, 0, 8, 1),     					new Rooms(1, 1, 0, 1, 2),      					new Rooms(2, 2, 1, 2, 3),         new BossRoom(3, 3, 2, 11, 3, 10, 2, true),      new Rooms(4, 4, 4, 12, 5),        				 new Rooms(5, 5, 4, 13, 5),     new BossRoom(6, 6, 6, 14, 7, 75, 8, true),  	new EndRoom(7, 7, 6, 7, 7),
				 new Rooms(8, 0, 8, 16, 8),     				new Rooms(9, 9, 9, 17, 10),    					new Rooms(10, 10, 9, 18, 11),     new Rooms(11, 3, 10, 19, 11),  				  new Rooms(12, 4, 12, 20, 12),     				 new Rooms(13, 5, 13, 21, 13),  new Rooms(14, 6, 14, 14, 15),  					new Rooms(15, 15, 14, 23, 15),
				 new Rooms(16, 8, 16, 24, 16),  				new Rooms(17, 9, 17, 25, 18),  					new Rooms(18, 10, 17, 26, 19),    new Rooms(19, 11, 18, 27, 20), 				  new Rooms(20, 12, 19, 28, 21),    				 new Rooms(21, 13, 20, 29, 21), new BossRoom(22, 22, 22, 30, 23, 30, 1, true),  new Rooms(23, 15, 22, 23, 23),
				 new BossRoom(24, 16, 24, 32, 25, 12, 3, true), new Rooms(25, 17, 24, 33, 25), 					new Rooms(26, 18, 26, 34, 27),    new Rooms(27, 19, 26, 35, 28), 				  new Rooms(28, 20, 27, 36, 28),    				 new Rooms(29, 21, 29, 37, 29), new Rooms(30, 22, 30, 30, 31), 					new Rooms(31, 31, 30, 39, 31),
				 new Rooms(32, 24, 32, 40, 32), 				new BossRoom(33, 25, 33, 33, 33, 50, 5, true),  new Rooms(34, 26, 34, 42, 34),    new Rooms(35, 27, 35, 43, 36), 				  new Rooms(36, 28, 35, 44, 36),   				 	 new Rooms(37, 29, 37, 45, 37), new Rooms(38, 38, 38, 46, 39), 					new BossRoom(39, 31, 38, 39, 39, 50, 4, true),
				 new Rooms(40, 32, 40, 48, 41), 				new BossRoom(41, 41, 40, 41, 41, 30, 7, true),  new Rooms(42, 34, 42, 50, 43),    new Rooms(43, 35, 42, 51, 44),                  new Rooms(44, 36, 43, 52, 45),    				 new Rooms(45, 37, 44, 53, 45), new Rooms(46, 38, 46, 46, 47), 					new Rooms(47, 47, 46, 55, 47),
				 new Rooms(48, 40, 48, 56, 49), 				new Rooms(49, 49, 48, 49, 50), 					new Rooms(50, 42, 49, 58, 51),    new Rooms(51, 43, 50, 59, 52),                  new Rooms(52, 44, 51, 60, 53),   				     new Rooms(53, 45, 52, 61, 53), new Rooms(54, 53, 54, 62, 55),					new Rooms(55, 47, 54, 63, 55),
				 new Rooms(56, 48, 56, 56, 57), 				new Rooms(57, 57, 56, 57, 58), 					new Rooms(58, 50, 57, 58, 59),    new BossRoom(59, 51, 58, 59, 60, 15, 12, true), new BossRoom(60, 52, 59, 60, 61, 30, 6, true),   	 new Rooms(61, 53, 60, 61, 62), new Rooms(62, 54, 61, 62, 63), 					new Rooms(63, 55, 62, 63, 63),
				};				   //new bossroom has extra constructor inputs, that being enemy stats																												//id, w, a, s, d, int hp, int atk, boolean alive						
		//		 	
		String userInput = null;  // userinput initialize 
		//
		Title.titleScreen();  // call titlescreen static which puts gameState to 1
		int currentRoom = 0;  // initialize currentRoom int
		while (gameState == 1) {   //while playing 
			Rooms[currentRoom].drawRoom();   //whatever room we are in call that drawRoom method
			if (!Player.lose) {				 //if the player is not dead, scan
			userInput = scan.nextLine();

			currentRoom = Rooms[currentRoom].moveRoom(userInput);
			} else {  						// if the player IS dead then gamestate plus to get outof the while loop
				gameState++;
			}
		}
	}
}
