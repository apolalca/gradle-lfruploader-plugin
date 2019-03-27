package com.everis.uploader;

import com.everis.uploader.lib.Manager;
import com.everis.uploader.lib.SSHManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ManagerTest {

    @Test
    public void manager_instance() {
        ConnectionType type = ConnectionType.SFTP;
        assertManagerInstance(type);
    }

    private void assertManagerInstance(ConnectionType connectionType) {
        UploaderConfiguration uploaderConfiguration = new UploaderConfiguration();
        uploaderConfiguration.setConnection(connectionType);
        Manager manager = Manager.instance(uploaderConfiguration, null);

        Assert.assertTrue(manager instanceof SSHManager);
    }
}
