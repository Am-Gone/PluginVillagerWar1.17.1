package fr.scramjet.villagerwar.powers;

import fr.scramjet.villagerwar.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class PowersListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e){
       if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
           if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getDefensivePearl().defencivePearl().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getDefensivePearl().defensivePearlAction(e.getPlayer());
           }
           if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getOffensivePearl().offensivePearl().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getOffensivePearl().offensivePearlAction(e.getPlayer());
           }





       }

    }

}
