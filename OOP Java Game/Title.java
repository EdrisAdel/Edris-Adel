/* Edris Adel
 * Title Class
 */
public class Title {
	static void titleScreen() {
		String VampEscapadeTitle =  (""+ //it's weird, but it works!
"                                 __      __                   ______                               _       \n"+
"				 V {    / /                  |  ____|                             | |      \n"+
"				  { {  / /_ _ _ __ ___  _ __ | |__   ___  ___ __ _ _ __   __ _  __| | ___  \n"+
"				   { {/ / _` | '_ ` _ {| '_ {|  __| / __|/ __/ _` | '_ { / _` |/ _` |/ _ { \n"+
"				    {  / (_| | | | | | | |_) | |____{__ { (_| (_| | |_) | (_| | (_| |  __/ \n"+
"				     {/ {__,_|_| |_| |_| .__/|______|___/{___{__,_| .__/ {__,_|{__,_|{___| \n"+
"				                       | |                        | |                      \n"+
"				                       |_|                        |_|                      \n");
		
		while (Main.gameState == 0) { //static gamestate
			s.s(VampEscapadeTitle	+ "               "
					+ "You are a vampire, ditched in a cave... You feel an ominous presence lurking around these ends, and with your\n 				 combat knowledge, you are ready to fight these creatures! \n"
					+ "(HINT: Encountering an enemy you are presented with 2 choices of attacks, your dash which has a low chance to crit, but does a lot of damage. And then your Vampire life steal attack, which has a mid level chance to crit, does minimal damage, but life steals what ever amount of damage you did.) \n							Press Enter To Start");
			
			String userInput = Main.scan.nextLine(); //we scan if they press enter, and start the game
			if (userInput.equals("")) {
				Main.gameState++;
			} 
		}
}
}
