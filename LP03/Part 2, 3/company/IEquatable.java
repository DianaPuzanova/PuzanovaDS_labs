package com.company;

public interface IEquatable<T extends  IEquatable>
{
    boolean Equals(T other);
}
