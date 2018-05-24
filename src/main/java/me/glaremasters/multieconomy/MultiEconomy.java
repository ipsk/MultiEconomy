package me.glaremasters.multieconomy;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import me.glaremasters.multieconomy.events.JoinEvent;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class MultiEconomy extends JavaPlugin {

    private static MultiEconomy i;

    public static MultiEconomy getI() {
        return i;
    }

    public File dataFile = new File(this.getDataFolder(), "data.yml");
    public YamlConfiguration dataFileConfig = YamlConfiguration.loadConfiguration(this.dataFile);

    @Override
    public void onEnable() {
        i = this;
        saveDefaultConfig();
        saveData();

        getServer().getPluginManager().registerEvents(new JoinEvent(i), this);
    }

    @Override
    public void onDisable() {

    }

    public void saveData() {
        try {
            dataFileConfig.save(dataFile);
        } catch (IOException e) {
            getLogger().log(Level.WARNING, "Could not save data file!");
            e.printStackTrace();
        }
    }
}
