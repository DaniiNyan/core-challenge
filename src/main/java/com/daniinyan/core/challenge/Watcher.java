package com.daniinyan.core.challenge;

import com.daniinyan.core.challenge.domain.DataAnalyzer;
import com.daniinyan.core.challenge.domain.FilePath;

import java.io.IOException;
import java.nio.file.*;

public class Watcher extends Thread {

    private DataAnalyzer dataAnalyzer;
    private String directoryPathToWatch;

    public Watcher() {
        this.dataAnalyzer = new DataAnalyzer(FilePath.DEFAULT_FOLDER.getPath());
        this.directoryPathToWatch = FilePath.DEFAULT_FOLDER.getPath() + FilePath.INPUT_FOLDER.getPath();
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
