package com.github.apolalca.uploader;

import com.github.apolalca.uploader.lib.Manager;
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
        Class instacer = Class.forName("com.github.apolalca.uploader.lib." + connectionType.toString() + "Manager");

        Assert.assertTrue("Manager is not instanceof " + connectionType, manager.getClass().isAssignableFrom(instacer));
    }
}
