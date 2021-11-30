package fr.scramjet.villagerwar.powers;

import fr.scramjet.villagerwar.Main;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;


public class PowersListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e){
       if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
           if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getDefensivePearl().defencivePearl().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getDefensivePearl().defensivePearlAction(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
           }
           if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getOffensivePearl().offensivePearl().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getOffensivePearl().offensivePearlAction(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
           }
           if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getOffensiveFlint().offensiveFlint().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getOffensiveFlint().offensiveFlintAction(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
           }
           if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getDefensiveFlint().defensiveFlint().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getDefensiveFlint().defensiveFlintAction(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
           }





       }

    }

    @EventHandler
    public void playerMoveEvent(PlayerMoveEvent e){
        if(Main.getMain().getPowers().getDefensiveFlint().isRegPlayer(e.getPlayer())){
           if(e.getPlayer().getLocation().getBlock().getRelative(BlockFace.UP).getType().equals(Material.AIR)) {
               e.getPlayer().getLocation().getBlock().getRelative(BlockFace.UP).setType(Material.SOUL_FIRE);
               e.getPlayer().sendMessage("y");
           }
           e.getPlayer().sendMessage("Yo bro");
        }
    }

}
