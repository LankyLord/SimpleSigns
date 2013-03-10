package com.github.lankylord.SimpleSigns;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignListener implements Listener {

    SimpleSigns plugin;
    static final Logger logger = Logger.getLogger("Minecraft");

    public SignListener(SimpleSigns instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("simplesigns.colour")) {
            return;
        }
        String[] lines = event.getLines();
        for (int i = 0; i < lines.length; i++) {
            event.setLine(i, ChatColor.translateAlternateColorCodes('&', lines[i]));
        }
    }
}