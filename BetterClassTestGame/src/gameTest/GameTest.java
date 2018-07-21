package gameTest;
import game.Player;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

public class GameTest {
	
	@Test
	public void playerMoveTest() {
	Player player = new Player("player");
	player.playerMove();
	//Input = west
	assertEquals("Wrong Position", "Your coordinates are [-1,0]", player.getPlayerCoordinates());
	}

}
