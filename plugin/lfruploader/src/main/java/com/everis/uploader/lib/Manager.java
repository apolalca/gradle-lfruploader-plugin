package com.everis.uploader.lib;

import com.everis.uploader.ConnectionType;
import org.gradle.api.logging.Logger;

import com.everis.uploader.UploaderConfiguration;
import org.gradle.internal.impldep.com.google.common.annotations.VisibleForTesting;

import java.io.File;

public abstract class Manager {
    @VisibleForTesting
    protected UploaderConfiguration uploaderConfiguration;
    protected Logger log;

    public static Manager instance(UploaderConfiguration uploaderConfiguration, Logger log) {
        Manager manager = null;
        ConnectionType connection = uploaderConfiguration.getConnection();
        String fullPathOfTheClass = "com.everis.uploader.lib." + connection + "Manager";

        try {
            Class<?> cls = Class.forName(fullPathOfTheClass);
            manager = (Manager) cls.getDeclaredConstructor(UploaderConfiguration.class, Logger.class)
                    .newInstance(uploaderConfiguration, log);
        } catch (ReflectiveOperationException ex) {
            ex.printStackTrace();
        }

        return manager;
    }

    protected Manager(UploaderConfiguration uploaderConfiguration, Logger log) {
        this.uploaderConfiguration = uploaderConfiguration;
        this.log = log;
    }

    public abstract void connect() throws ManagerException;

    public abstract boolean upload(File file, String remotePath) throws ManagerException;

    public abstract void disconnect();

    public abstract void command() throws ManagerException;
}
