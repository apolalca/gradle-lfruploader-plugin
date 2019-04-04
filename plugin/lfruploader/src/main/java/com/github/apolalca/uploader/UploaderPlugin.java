package com.github.apolalca.uploader;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

public class UploaderPlugin implements Plugin<Project> {

    @Override
    public void apply(Project target) {
        Task plugin = target.getTasks().create("lfruploader", UploaderTask.class, (task) -> {
            task.setLogger(target.getProject().getLogger());
            task.setFileBuild(target.getBuildDir());
        });
        plugin.dependsOn("build");
    }
}
