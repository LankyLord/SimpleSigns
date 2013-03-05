package com.github.lankylord.SimpleSigns;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.block.Block;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleSigns extends JavaPlugin {

    public HashMap<String, Block> sign = new HashMap();
    static final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onDisable() {
        logger.info("[SimpleSigns] Plugin disabled.");
    }

    @Override
    public void onEnable() {
        Listeners();
        PluginDescriptionFile pdfFile;
        pdfFile = getDescription();
        logger.log(Level.INFO, "[SimpleSigns] Plugin version {0} enabled.",
                pdfFile.getVersion());
        try {
            MetricsLite metrics = new MetricsLite(this);
            metrics.start();
        } catch (IOException e) {
        }
    }

    public void Listeners() {
        getServer().getPluginManager().registerEvents(new SignListener(this),
                this);
    }
}