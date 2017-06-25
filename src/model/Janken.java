package model;

import java.io.Serializable;


public class Janken implements Serializable {
	private int hand;
	private int cpuHand;
	private String result;

	public int getHand() {
		return hand;
	}

	public void setHand(int hand) {
		this.hand = hand;
	}

	public int getCpuHand() {
		return cpuHand;
	}

	public void setCpuHand(int cpuHand) {
		this.cpuHand = cpuHand;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
