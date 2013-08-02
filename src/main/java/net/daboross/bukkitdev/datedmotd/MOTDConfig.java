/*
 * Copyright (C) 2013 Dabo Ross <www.daboross.net>
 */
package net.daboross.bukkitdev.datedmotd;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author daboross
 */
public class MOTDConfig {

    private final DatedMOTDPlugin plugin;
    private final FileUtils fileUtils;
    private File configFile;
    private List<String> config;

    public MOTDConfig(DatedMOTDPlugin plugin) {
        this.plugin = plugin;
        this.fileUtils = new FileUtils(plugin);
    }

    public void copyDefaultConfig() {
        plugin.saveResource("motd.txt", false);
    }

    /**
     * Gets a copy of the configuration. This method will reload the
     * configuration if it is not loaded.
     *
     * @return The contents of the file motd.txt when last reloaded.
     */
    public String[] getConfigCopy() {
        loadConfig();
        return config.toArray(new String[config.size()]);
    }

    /**
     * Reloads the configuration if it is not already loaded. This method will
     * do nothing if the configuration has already been loaded.
     */
    public void loadConfig() {
        if (config == null) {
            reloadConfig();
        }
    }

    /**
     * Reloads the configuration from file.
     */
    public void reloadConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), "motd.txt");
        }
        if (!configFile.exists()) {
            copyDefaultConfig();
        }
        config = fileUtils.readFile(configFile);
    }
}
