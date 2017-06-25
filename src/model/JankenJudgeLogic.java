package model;

public class JankenJudgeLogic {
	public void execute(Janken janken) {

		int hand = janken.getHand();

		double ransu = Math.random();
		int CPUhand = (int) (ransu * 3);
		String judge = null;

		if ((hand == 0 && CPUhand == 0) || (hand == 1 && CPUhand == 1) || (hand == 2 && CPUhand == 2)) {
			judge = "あいこ";
		} else if ((hand == 0 && CPUhand == 1) || (hand == 1 && CPUhand == 2) || (hand == 2 && CPUhand == 0)) {
			judge = "勝ち";
		} else if ((hand == 0 && CPUhand == 2) || (hand == 1 && CPUhand == 0) || (hand == 2 && CPUhand == 1)) {
			judge = "負け";
		}

		janken.setResult(judge);
		janken.setCpuHand(CPUhand);

	}

}
