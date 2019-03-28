package com.everis.uploader;

import com.everis.uploader.lib.Manager;
import com.everis.uploader.lib.SFTPManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ManagerTest {

    @Test
    public void manager_instances() throws ClassNotFoundException {
        for (ConnectionType type : ConnectionType.values()) {
            assertManagerInstance(type);
        }
    }

    private void assertManagerInstance(ConnectionType connectionType) throws ClassNotFoundException {
        UploaderConfiguration uploaderConfiguration = new UploaderConfiguration();
        uploaderConfiguration.setConnection(connectionType);
        Manager manager = Manager.instance(uploaderConfiguration, null);
        Class instacer = Class.forName("com.everis.uploader.lib." + connectionType.toString() + "Manager");

        Assert.assertTrue("Manager is not instanceof " + connectionType, manager.getClass().isAssignableFrom(instacer));
    }
}
