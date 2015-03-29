package com.lp02;

import com.company.IEquatable;

import java.util.Hashtable;

public class Melancholiac extends Person
{
	public Melancholiac(int mood)
	{
		super(mood);
	}

	@Override
	public Message say(Message answer) {
		Message mess = new Message();

		if (answer.getText().equals("Hello")) {
			mess.putData("Hi", -2);
			return mess;

		} else if (answer.getText().equals(" ")) {
			mess.putData("Hello", 0);
			return mess;

		} else if (answer.getText().equals("Hi")) {
			mess.putData("How are you?", -2);
			return mess;

		} else if (answer.getText().equals("How are you?")) {
			if(this.mood > 3)
			{
				mess.putData("Perfectly!", 2);

			} else if(this.mood > 0)
			{
				mess.putData("I am happy:)", 1);

			} else if(this.mood == 0)
			{
				mess.putData("Normal", -1);

			} else
			{
				mess.putData("So-So:(", -2);
			}
			return mess;

		} else if (answer.getText().equals("Perfectly!")
				|| answer.getText().equals("I am happy:)")
				|| answer.getText().equals("Normal")
				|| answer.getText().equals("So-So:(")) {
			mess.putData("What did you do yesterday?", -2);
			return mess;

		} else if (answer.getText().equals("What did you do yesterday?")) {
			mess.putData("I was sad:(", -2);
			return mess;

		} else if (answer.getText().equals("Bye")) {
			mess.putData("Bye", 0);
			return mess;

		} else {
			mess.putData("Bye", 0);
			return mess;
		}
	}

    @Override
    public String GetSerializationPrefix()
    {
        return "Melancholiac.";
    }

    @Override
    public boolean Equals(Person other)
    {
        return super.Equals(other) && other.GetSerializationPrefix().equals(this.GetSerializationPrefix());
    }
}