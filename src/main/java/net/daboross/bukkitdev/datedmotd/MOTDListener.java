/*
 * Copyright (C) 2013 Dabo Ross <www.daboross.net>
 */
package net.daboross.bukkitdev.datedmotd;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author daboross
 */
public class MOTDListener implements Listener {

    private final DatedMOTDPlugin plugin;

    public MOTDListener(DatedMOTDPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent evt) {
        Player p = evt.getPlayer();
        p.sendMessage(plugin.getParser().getParsedMOTD(p));
    }
}
