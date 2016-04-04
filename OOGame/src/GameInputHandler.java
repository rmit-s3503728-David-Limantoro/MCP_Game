import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameInputHandler implements ActionListener, KeyListener {
	Player player;
	JPanel prevPanel;
	Game game;
	SettingWindow sw;

	public GameInputHandler(Player player, JPanel panel, Game game) {
		this.player = player;
		this.game = game;
		prevPanel = panel;

		sw = new SettingWindow(game.getSetting(), game);
		sw.getSettingWinFrame().setSize(700, 700);
		sw.getSettingWinFrame().setLocationRelativeTo(null); // center the frame
		sw.getSettingWinFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		else if (((JButton) e.getSource()).getText().compareTo("setting") == 0) {
			sw.getSettingWinFrame().setVisible(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.destinationCell = new Cell(player.currentCell.row - 1, player.currentCell.col);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.destinationCell = new Cell(player.currentCell.row + 1, player.currentCell.col);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.destinationCell = new Cell(player.currentCell.row, player.currentCell.col - 1);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.destinationCell = new Cell(player.currentCell.row, player.currentCell.col + 1);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
