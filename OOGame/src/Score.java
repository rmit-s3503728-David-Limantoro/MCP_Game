
public class Score {
	private int[] scores;

	public void updateScore(int newScore) {
		// TODO Update score list accordingly
	}

	public int[] getScores() {
		return scores;
	}

	public Score(int[] inputScore) {
		scores = inputScore;
	}

	public Score() {
		scores = new int[10];
	}
}
