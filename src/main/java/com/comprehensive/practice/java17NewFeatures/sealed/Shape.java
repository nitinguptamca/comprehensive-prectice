package com.comprehensive.practice.java17NewFeatures.sealed;

public sealed interface Shape permits Circle,Triangle,Rectangle{
    public void display();
}
