package com.company;

import com.lp02.*;

import java.util.Hashtable;

public class Main
{
    public static void main(String[] args)
    {
        Message msg = new Message();
        msg.putData("Test", 2);

//        Hashtable<String, Object> serializedData = msg.Serialize("");
//        System.out.println(serializedData);
//        msg.putData("", 0);
//        System.out.println(msg.getText() + " " + msg.getInfluence());
//        msg.Deserealize("", serializedData);
//        System.out.println(msg.getText() + " " + msg.getInfluence());

//        Choleric person = new Choleric(2);
//        person.say(msg);
//
//        Hashtable<String, Object> serealizedData = person.Serialize("");
//        System.out.println(serealizedData);
//
//        Choleric otherPerson = new Choleric(3);
//        otherPerson.Deserealize("", serealizedData);
//
//        System.out.println(otherPerson.Serialize(""));

        Sanguine firstPerson = new Sanguine(1);
        Sanguine second = new Sanguine(1);

        firstPerson.say(msg);

        System.out.println(firstPerson.Equals(second));
    }
}
