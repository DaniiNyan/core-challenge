package com.daniinyan.core.challenge;

import com.daniinyan.core.challenge.domain.Watcher;

public class Application {
    public static void main(String[] args) {
        Watcher watcher = new Watcher();
        watcher.start();
    }
}