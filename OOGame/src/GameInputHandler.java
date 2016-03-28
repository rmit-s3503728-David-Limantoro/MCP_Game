import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameInputHandler implements ActionListener {
	Player player;

	public GameInputHandler(Player player) {
		this.player = player;
	}

	/* responds to various button clicked messages */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getText().compareTo("up") == 0)
			player.setDestination('U');
		else if (((JButton) e.getSource()).getText().compareTo("down") == 0)
			player.setDestination('D');
		else if (((JButton) e.getSource()).getText().compareTo("left") == 0)
			player.setDestination('L');
		else if (((JButton) e.getSource()).getText().compareTo("right") == 0)
			player.setDestination('R');
		else if (((JButton) e.getSource()).getText().compareTo("start") == 0)
			player.setReady(true);
	}
}
