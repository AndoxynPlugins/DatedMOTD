/*
 * Copyright (C) 2013 Dabo Ross <www.daboross.net>
 */
package net.daboross.bukkitdev.datedmotd;

import org.bukkit.entity.Player;

/**
 *
 * @author daboross
 */
public class MOTDParser {

    private final DatedMOTDPlugin plugin;

    public MOTDParser(DatedMOTDPlugin plugin) {
        this.plugin = plugin;
    }

    public String[] getParsedMOTD(Player p) {
        String[] motd = plugin.getMOTDConfig().getConfigCopy();
        String server = null, player = null, date = null, ampmLower = null, ampmUpper = null;
        for (int i = 0; i < motd.length; i++) {
            String line = motd[i];
            if (line.contains("%server")) {
                line = line.replace("%server", server == null ? server = plugin.getServer().getServerName() : server);
            }
            if (line.contains("%player")) {
                line = line.replace("%player", player == null ? player = p.getName() : player);
            }
            if (line.contains("%date")) {
                line = line.replace("%date", date == null ? date = getDate() : date);
            }
            if (line.contains("%ampm")) {
                line = line.replace("%ampm", ampmLower == null ? ampmLower = getAmPmLower() : ampmLower);
            }
            if (line.contains("%AMPM")) {
                line = line.replace("%AMPM", ampmUpper == null ? ampmUpper = getAmPmUpper() : ampmUpper);
            }
            motd[i] = line;
        }
        return motd;
    }

    private String getDate() {
        return null;
    }

    private String getAmPmLower() {
        return null;
    }

    private String getAmPmUpper() {
        return null;
    }
}
