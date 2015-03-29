package com.company;

import java.util.Hashtable;

public interface ISerializable
{
    String GetSerializationPrefix();

    Hashtable<String, Object> Serialize(String prefix);
    boolean Deserealize(String prefix, Hashtable<String, Object> serealizedData);
}