package com.github.apolalca.uploader.lib;

public class ManagerException extends Exception {

    public ManagerException(String str) {
        super("ERROR: " + str);
    }

    public ManagerException(Exception ex) {
        super(ex);
    }
}
