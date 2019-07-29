package com.daniinyan.core.challenge;

import com.daniinyan.core.challenge.domain.DataAnalyzer;

import java.io.IOException;
import java.nio.file.*;

public class Watcher extends Thread {

    private static final String INPUT_FILE_PATH = "in";

    private DataAnalyzer dataAnalyzer;
    private String directoryPathToWatch;

    public Watcher(String directoryPath) {
        this.dataAnalyzer = new DataAnalyzer(directoryPath);
        this.directoryPathToWatch = directoryPath + INPUT_FILE_PATH;
    }

    @Override
    public void run() {
        while(true) {
            watchInput();

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void watchInput() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();

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
                }
                key.reset();
            }

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
