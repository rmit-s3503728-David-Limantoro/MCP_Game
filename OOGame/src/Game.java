import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/* This class is the main System level class which creates all the objects 
 * representing the game logic (model) and the panel for user interaction. 
 * It also implements the main game loop 
 */

public class Game extends JFrame {

	private final int TIMEALLOWED = 100;

	private JButton up = new JButton("up");
	private JButton down = new JButton("down");
	private JButton left = new JButton("left");
	private JButton right = new JButton("right");
	private JButton start = new JButton("start");
	private JLabel mLabel = new JLabel("Time Remaining : " + TIMEALLOWED);

	private Grid grid;
	private Player player;
	private ArrayList<Monster> monster;
	private BoardPanel bp;
	private GameInputHandler gih;
	private Setting setting;
	private Score score;
	private Login login;
	

	/*
	 * This constructor creates the main model objects and the panel used for
	 * UI. It throws an exception if an attempt is made to place the player or
	 * the monster in an invalid location.
	 */

	public Game() throws Exception {
		grid = new Grid();
		player = new Player(grid, 1, 0);
		monster = new ArrayList<Monster>();
		monster.add(new MonsterAdult(grid, player, 5, 5, monster));
		bp = new BoardPanel(grid, player, monster.get(0));
		gih = new GameInputHandler(player);

		// Create a separate panel and add all the buttons
		JPanel panel = new JPanel();
		panel.add(up);
		panel.add(down);
		panel.add(left);
		panel.add(right);
		panel.add(start);
		panel.add(mLabel);

		// add Action listeners to all button events
		up.addActionListener(gih);
		down.addActionListener(gih);
		left.addActionListener(gih);
		right.addActionListener(gih);
		start.addActionListener(gih);

		// add panels to frame
		add(bp, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}

	// method to delay by specified time in ms
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method waits until play is ready (until start button is pressed)
	 * after which it updates the moves in turn until time runs out (player won)
	 * or player is eaten up (player lost).
	 */
	public String play() throws Exception { 
		int time = 0;
		String message;
		// player.setDirection(' '); // set to no direction
		while (!player.isReady())
			delay(100);
		do {

			// Cell newPlayerCell = player.move();
			// if (newPlayerCell == monster.get(0).getCell())
			// break;

			player.move();
			// player.setDirection(' '); // reset to no direction

			for (int x = 0; x < monster.size(); x++) {
				if (monster.get(x) instanceof MonsterInfant) {
					if (((MonsterInfant) monster.get(x)).checktime() == 0) {
						// replace MonsterChild with MonsterInfant
						monster.add(new MonsterChild(monster.get(x).grid, player, monster.get(x).getCell().row,
								monster.get(x).getCell().col, monster));
						monster.remove(x);
						break;
					}
					((MonsterInfant) monster.get(x)).reducecountdownToChild();
				}
			}
			monster.get(0).move();
			if (monster.get(0).currentCell == player.getCell())
				break;

			// update time and repaint
			time++;
			mLabel.setText("Time Remaining : " + (TIMEALLOWED - time));
			delay(1000);
			bp.repaint();

		} while (time < TIMEALLOWED);

		if (time < TIMEALLOWED) // players has been eaten up
			message = "Player Lost";
		else
			message = "Player Won";

		mLabel.setText(message);
		return message;
	}

	public void save() {
		Saving saveclass = new Saving(this);
		saveclass.savegame(login, score, grid.cells2D, grid.cells, monster, player, setting);
	}
	
	public void load() {
		Saving saveclass = new Saving(this);
		saveclass.loadGame();
	}
	
	public void setUpGameOnLoad(Login log, Score s, Cell[][] cel2d, Cell[] c, ArrayList<Monster> m, Player p, Setting set) {
		login = log;
		score = s;
		grid.cells2D = cel2d;
		grid.cells = c;
		monster = m;
		player = p;
		setting = set;
	}
	
	public static void main(String args[]) throws Exception {
		Game game = new Game();
		game.setting = new Setting();
		game.score = new Score();
		game.login = new Login();
		game.setTitle("Monster Game");
		game.setSize(700, 700);
		game.setLocationRelativeTo(null); // center the frame
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
		game.play();
	}
}
