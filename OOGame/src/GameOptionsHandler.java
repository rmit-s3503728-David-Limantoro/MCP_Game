import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameOptionsHandler implements ActionListener {
	Game game;
	
	public GameOptionsHandler(Game g) {
		game = g;
	}

	/* responds to various option-buttons as clicked*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getText().compareTo("Save") == 0)
			game.savegame();
		else if (((JButton) e.getSource()).getText().compareTo("Load") == 0)
			game.loadgame();
	}
	
}
