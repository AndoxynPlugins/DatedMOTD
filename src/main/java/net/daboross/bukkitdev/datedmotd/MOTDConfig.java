/*
 * Copyright (C) 2013 Dabo Ross <http://www.daboross.net/>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.daboross.bukkitdev.datedmotd;

import java.io.File;
import java.util.List;
import org.bukkit.ChatColor;

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
        for (int i = 0; i < config.size(); i++) {
            config.set(i, ChatColor.translateAlternateColorCodes('&', config.get(i)));
        }
    }
}
