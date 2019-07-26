package com.daniinyan.core.challenge;

import com.daniinyan.core.challenge.domain.DataAnalyzer;

import java.io.IOException;
import java.nio.file.*;

public class Watcher {

    private static final String INPUT_FILE_PATH = "in";

    private DataAnalyzer dataAnalyzer;
    private String directoryPathToWatch;

    public Watcher(String directoryPath) {
        this.dataAnalyzer = new DataAnalyzer(directoryPath);
        this.directoryPathToWatch = directoryPath + INPUT_FILE_PATH;
    }

    public void createOutputFile() {
        dataAnalyzer.createOutputFile();
        System.out.println("Create file.");
    }

    public void watchInput() {
        try {
            WatchService watchService
                    = FileSystems.getDefault().newWatchService();

            Path path = Paths.get(directoryPathToWatch);

            path.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    dataAnalyzer.update();
                    System.out.println("updated");
                    Object context = event.context();
                    System.out.println( String.format( "Event %s, type %s", context, event.kind()));
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
