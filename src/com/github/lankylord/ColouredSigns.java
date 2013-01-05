package com.github.lankylord;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.block.Block;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class ColouredSigns extends JavaPlugin{
    public HashMap<String, Block> sign = new HashMap();
    static final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onDisable() {
        logger.info("[ColouredSigns] Plugin disabled.");
    }
    
    @Override
    public void onEnable() {
        Listeners();
        PluginDescriptionFile pdfFile;
        pdfFile = getDescription();
        logger.log(Level.INFO, "[ColouredSigns] Plugin version {0} enabled.",
                pdfFile.getVersion());
    }
    
    public void Listeners() {
        getServer().getPluginManager().registerEvents(new SignListener(this), 
                this);
    }
}