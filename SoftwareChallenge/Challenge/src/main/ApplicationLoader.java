package main;

import controller.ChallengeController;
import view.ChallengeFrame;
import model.Room;

public class ApplicationLoader {
	public static void main(String[] args) {
		ChallengeFrame view = new ChallengeFrame();
		Room model = new Room();
		
		@SuppressWarnings("unused")
		ChallengeController controller = new ChallengeController(view, model);
	}
}
