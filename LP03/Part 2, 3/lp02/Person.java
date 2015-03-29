package com.lp02;
import com.company.IEquatable;
import com.company.ISerializable;

import java.util.Hashtable;

public abstract class Person implements ISerializable, IEquatable<Person>
{
	protected int mood;

	public Person(int mood)
    {
		this.mood = mood;
	}

	public void changeMood(int influence)
	{
		mood = mood + influence;
	}

	public void listen(Message message)
    {
		changeMood(message.getInfluence());
	}

    public String GetSerializationPrefix()
    {
        return "Person.";
    }

    public Hashtable<String, Object> Serialize(String prefix)
    {
        Hashtable<String, Object> result = new Hashtable<String, Object>();

        result.put(prefix + "mood", mood);

        return result;
    }

    public boolean Deserealize(String prefix, Hashtable<String, Object> serealizedData)
    {
        prefix += GetSerializationPrefix();

        if (serealizedData.containsKey(prefix + "mood"))
        {
            mood = Integer.parseInt((String) serealizedData.get("mood"));

            return true;
        }

        return false;
    }

    public boolean Equals(Person other)
    {
        return mood == other.mood;
    }

	public abstract Message say(Message answer);
}