package fr.scramjet.villagerwar.powers;

import fr.scramjet.villagerwar.Main;


import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.concurrent.ThreadLocalRandom;


public class WalkerListener implements Listener {
    @EventHandler
    public void playerMoveEvent(PlayerMoveEvent e){
        if(Main.getMain().getPowers().getDefensiveFlint().isRegPlayer(e.getPlayer())){
            e.getPlayer().spawnParticle(Particle.DRIP_LAVA, e.getPlayer().getLocation(), 100, 1, 2, 1);
            return;
        }
        if(Main.getMain().getPowers().getOffensiveTotem().isRegPlayer(e.getPlayer())){
            int randomR = ThreadLocalRandom.current().nextInt(0, 255);
            int randomG = ThreadLocalRandom.current().nextInt(0, 255);
            int randomB = ThreadLocalRandom.current().nextInt(0, 255);
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(randomR, randomG, randomB), 2.5F);
            e.getPlayer().spawnParticle(Particle.REDSTONE, e.getPlayer().getLocation().add(e.getPlayer().getLocation().getDirection().multiply(-2)), 50, 0, 0, 0, dustOptions);
            return;
        }
        if (Main.getMain().getPowers().getDefensiveTotem().isRegPlayer(e.getPlayer())){
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 0, 0), 3.0F);
            e.getPlayer().spawnParticle(Particle.REDSTONE, e.getPlayer().getLocation().add(e.getPlayer().getLocation().getDirection().multiply(-6)), 120, 2, 3, 2, dustOptions);
        }
    }



}
