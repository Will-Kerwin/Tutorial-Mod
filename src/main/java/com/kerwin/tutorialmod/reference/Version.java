package com.kerwin.tutorialmod.reference;

public class Version {
    // big major change
    public static final int MAJOR = 1;
    // changes and additions in features to major
    public static final int MINOR = 0;
    // little bits and bobs
    public static final int REVISION = 1;

    public static final String VERSION = MAJOR + "." + MINOR + "." + REVISION;

    private Version() {

    }

}
