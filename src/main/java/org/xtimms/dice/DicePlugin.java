package org.xtimms.dice;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public class DicePlugin extends JavaPlugin {

    Logger logger = getLogger();

    @Override
    public void onEnable() {
        logger.info("Hey! Dice is enabled right now! :O");
        Config config = new Config(this);
        Bukkit.getScheduler().runTaskAsynchronously(this, () -> Objects.requireNonNull(getCommand("rtp")).setExecutor(new Throwing(config)));
    }

    @Override
    public void onDisable() {
        logger.info("Dice is disabled. Bye-bye! ;)");
    }
}
