package model;

import java.io.Serializable;

public class Janken implements Serializable {
	private int hand;
	private int cpuHand;
	private String result;

	public Janken() {

	}

	public Janken(int hand, int cpuHand) {
		this.hand = hand;
		this.cpuHand = cpuHand;
	}

	public int getHand() {
		return hand;
	}

	public int getCpuHand() {
		return cpuHand;
	}

	public void setHand(int hand) {
		this.hand = hand;
	}

	public void setCpuHand(int cpuHand) {
		this.cpuHand = cpuHand;
	}

	public String getResult() {
		return result;
	}

	public void setResult(int result) {
		String resultStr[] = new String[] { "勝ち", "負け", "あいこ" };
		this.result = resultStr[result];
	}

}
