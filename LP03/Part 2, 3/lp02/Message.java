package com.lp02;

public class Message
{
	private String text;
	private int influence;

	public Message()
	{
		this.text = " ";
		this.influence = 0;
	}

	public void putData(String text, int influence) {
		this.text = text;
		this.influence = influence;
	}

	public int getInfluence() {
		return this.influence;
	}

	public String getText() {
		return this.text;
	}
}
