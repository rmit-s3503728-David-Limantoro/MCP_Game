import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Saving implements java.io.Serializable{
	
	private Game game;
	
	public Saving (Game g) {
		game = g;
	}

	public void savegame(Login log, Score s, Cell[][] cel2d, Cell[] c, ArrayList<Monster> m, Player p, Setting set, int t) {
		SaveGameFile sgf = new SaveGameFile();
		sgf.login = log;
		sgf.scores = s;
		sgf.cells2d = cel2d;
		sgf.cells = c;
		sgf.monsters = m;
		sgf.player = p;
		sgf.settings = set;
		sgf.timeelapsed = t;
		try {
			FileOutputStream savefile = new FileOutputStream("SaveGame.ser");
			ObjectOutputStream out = new ObjectOutputStream(savefile);
			out.writeObject(sgf);
			out.close();
			savefile.close();
			System.out.println("Game Saved. Time Elapsed: " + sgf.timeelapsed);
		} catch (IOException i) {
			System.err.println("SaveGameFile has not been saved.");
			return;
		}
	}

	public void loadSavedGame() {
		SaveGameFile sgf = new SaveGameFile();
		System.out.println("File Opened");
		try {
			FileInputStream loadfile = new FileInputStream("SaveGame.ser");
			ObjectInputStream in = new ObjectInputStream(loadfile);
			sgf = (SaveGameFile)in.readObject();
			in.close();
			loadfile.close();
			game.setUpGameOnLoad(sgf.login, sgf.scores, sgf.cells2d, sgf.cells, sgf.monsters, sgf.player, sgf.settings, sgf.timeelapsed);
			System.out.println("Game Loaded. Time Elapsed: " + sgf.timeelapsed);
		}
		
		catch (IOException i) {
			System.err.println("GameFile did not load.");
		}
		catch (ClassNotFoundException fnfe) {
			System.err.println("GameFile not found");
		}
	}

	
	//creating a new object that holds all the necessary data that can then be saved
	public class SaveGameFile implements java.io.Serializable {
		private Login login;
		private Score scores;
		private Cell[][] cells2d;
		private Cell[] cells;
		private ArrayList<Monster> monsters = new ArrayList<Monster>();
		private Player player;
		private Setting settings;
		private int timeelapsed;
	}
}