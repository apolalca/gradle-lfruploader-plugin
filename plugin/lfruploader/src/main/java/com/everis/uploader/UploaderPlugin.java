package com.everis.uploader;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class UploaderPlugin implements Plugin<Project> {

    @Override
    public void apply(Project target) {
        target.getTasks().create("lfruploader", UploaderTask.class, (task) -> {
            task.setLogger(target.getProject().getLogger());
            task.setFileBuild(target.getBuildDir());
        });
    }
}
