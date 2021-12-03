package fr.scramjet.villagerwar;

import fr.scramjet.villagerwar.commands.DebugCommands;
import fr.scramjet.villagerwar.powers.Powers;
import fr.scramjet.villagerwar.powers.PowersListener;
import fr.scramjet.villagerwar.powers.WalkerListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    static Main main;
    static Plugin plugin;
    Powers powers = new Powers();

    @Override
    public void onEnable() {
        main = this;
        plugin = this;
        getCommand("debug1").setExecutor(new DebugCommands());
        getCommand("debug2").setExecutor(new DebugCommands());
        getCommand("debug3").setExecutor(new DebugCommands());
        getCommand("debug4").setExecutor(new DebugCommands());
        getCommand("debug5").setExecutor(new DebugCommands());
        getCommand("debug6").setExecutor(new DebugCommands());
        PluginManager manager = this.getServer().getPluginManager();
        manager.registerEvents(new PowersListener(), this);
        manager.registerEvents(new WalkerListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("VillagerWar OFF !, plugin by Scramjet_#6310");
    }
    //Static methods
    public static Plugin getPlugin(){
        return plugin;
    }
    public static Main getMain(){
        return main;
    }
    //---------------
    //Getter and Setter


    public Powers getPowers (){
        return powers;
    }


}
