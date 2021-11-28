package fr.scramjet.villagerwar.listeners;

import fr.scramjet.villagerwar.Main;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TabListener implements Listener {

    public void onPlayerConnect(PlayerJoinEvent event){
        Main.getMain().setConnectedPlayers(event.getPlayer());
    }
    public void onPlayerDisconnect(PlayerQuitEvent event){
        Main.getMain().removeConnectedPlayer(event.getPlayer());
    }
}
