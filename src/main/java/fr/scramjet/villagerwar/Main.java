package fr.scramjet.villagerwar;

import fr.scramjet.villagerwar.commands.DebugCommands;
import fr.scramjet.villagerwar.listeners.TabListener;
import fr.scramjet.villagerwar.powers.Powers;
import fr.scramjet.villagerwar.powers.PowersListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    static Main main;
    static Plugin plugin;
    private List<Player> connectedPlayers = new ArrayList<>();
    Powers powers = new Powers();

    @Override
    public void onEnable() {
        main = this;
        plugin = this;
        getCommand("debug1").setExecutor(new DebugCommands());
        getCommand("debug2").setExecutor(new DebugCommands());
        PluginManager manager = this.getServer().getPluginManager();
        manager.registerEvents(new TabListener(), this);
        manager.registerEvents(new PowersListener(), this);
        getLogger().info("Plugin by Scramjet_#6310");
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
    public boolean isConnectedPlayer(Player player){
        return connectedPlayers.contains(player);
    }
    public void setConnectedPlayers(Player player){
        if(!isConnectedPlayer(player)) {
            connectedPlayers.add(player);
        }
    }
    public void removeConnectedPlayer(Player player){
        if(isConnectedPlayer(player)){
            connectedPlayers.remove(player);
        }
    }
    public Powers getPowers (){
        return powers;
    }


}
