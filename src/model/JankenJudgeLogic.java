package model;

public class JankenJudgeLogic {

	public int battle(int myHand, int cpuHand) {

		int judge = 0;

		if (isWin(myHand, cpuHand)) {
			judge = 0;
		} else if (isLose(myHand, cpuHand)) {
			judge = 1;
		} else {
			judge = 2;
		}
		return judge;
	}

	private boolean isLose(int myHand, int cpuHand) {
		return (myHand == 0 && cpuHand == 2) || (myHand == 1 && cpuHand == 0) || (myHand == 2 && cpuHand == 1);
	}

	private boolean isWin(int myHand, int cpuHand) {
		return (myHand == 0 && cpuHand == 1) || (myHand == 1 && cpuHand == 2) || (myHand == 2 && cpuHand == 0);
	}

}
