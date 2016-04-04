import java.util.ArrayList;

public class Score implements java.io.Serializable {
	private ArrayList<Integer> topscores = new ArrayList<Integer>();

	public void updateScore(int newScore) {
		for (int x = 0; x < 6; x++) { //goes through the entire arraylist starting from score[0], which is the highest score
			if (newScore > topscores.get(x)) { //compares the current highest score to the new score
				topscores.add(x, newScore); //inserts the current score in the appropriate position
				break;
			}
		}
		if (topscores.size() > 5) { //removes any scores beyond the top 5
			topscores.remove(5);
		}
	}

	public ArrayList<Integer> getScores() {
		return topscores;
	}
}
