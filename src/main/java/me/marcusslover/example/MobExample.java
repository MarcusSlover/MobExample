package me.marcusslover.example;

import me.marcusslover.example.command.PetCommand;
import me.marcusslover.example.pet.PetListener;
import me.marcusslover.example.pet.PetManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MobExample extends JavaPlugin {

    private static MobExample instance;

    public static MobExample getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        PetManager petManager = new PetManager();
        petManager.initialize();

        this.getCommand("pet").setExecutor(new PetCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PetListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
