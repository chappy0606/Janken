package model;

public class JankenJudgeLogic {
	
	public String battle(int myHand, int cpuHand) {

		
		String judge = null;

		if (isWin(myHand, cpuHand)) {
			judge = "勝ち";
		} else if (isLose(myHand, cpuHand)) {
			judge = "負け";
		} else {
			judge = "あいこ";
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
