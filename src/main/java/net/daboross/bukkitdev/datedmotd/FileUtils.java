/*
 * Copyright (C) 2013 Dabo Ross <www.daboross.net>
 */
package net.daboross.bukkitdev.datedmotd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author daboross
 */
public class FileUtils {

    private final Plugin plugin;

    public FileUtils(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Reads a file into an array list of strings
     *
     * @param file this is the file to read from
     * @return The text in the file, or null if it doesn't exist
     */
    public List<String> readFile(File file) {
        ArrayList<String> lines = new ArrayList<String>();
        if (file.canRead()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader bf = new BufferedReader(fr);
                while (true) {
                    String line = bf.readLine();
                    if (line == null) {
                        break;
                    }
                    lines.add(line);
                }
                bf.close();
            } catch (Exception ex) {
                plugin.getLogger().log(Level.WARNING, "[FileUtils] Exception reading file " + file.getAbsolutePath(), ex);
            }
        } else {
            plugin.getLogger().log(Level.WARNING, "[FileUtils] No read access to file {0}", file.getAbsolutePath());
        }
        lines.trimToSize();
        return lines;
    }
}
