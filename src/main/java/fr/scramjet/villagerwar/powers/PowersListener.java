package fr.scramjet.villagerwar.powers;

import fr.scramjet.villagerwar.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;



public class PowersListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e){
       if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
           if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getDefensivePearl().defencivePearl().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getDefensivePearl().defensivePearlAction(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
               return;
           }
           if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getOffensivePearl().offensivePearl().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getOffensivePearl().offensivePearlAction(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
               return;
           }
           if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getOffensiveFlint().offensiveFlint().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getOffensiveFlint().offensiveFlintAction(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
               return;
           }
           if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getDefensiveFlint().defensiveFlint().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getDefensiveFlint().defensiveFlintAction(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
               return;
           }
           if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getOffensiveTotem().offensiveTotem().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getOffensiveTotem().offensiveTotemAction(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
               return;
           }
           if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getDefensiveTotem().defensiveTotem().getItemMeta().getPersistentDataContainer())){
               e.setCancelled(true);
               e.getPlayer().updateInventory();
               Main.getMain().getPowers().getDefensiveTotem().offensiveTotemAction(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
               return;
           }





       }

    }

    @EventHandler
    public void onResurect(EntityResurrectEvent e){
        if(e.getEntity() instanceof Player){
            Player player = (Player) e.getEntity();
            if(player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getOffensiveTotem().offensiveTotem().getItemMeta().getPersistentDataContainer())&& player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getDefensiveTotem().defensiveTotem().getItemMeta().getPersistentDataContainer())){
                e.setCancelled(true);
            }
            if(player.getInventory().getItemInOffHand().getItemMeta() != null && player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getOffensiveTotem().offensiveTotem().getItemMeta().getPersistentDataContainer())&& player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(Main.getMain().getPowers().getDefensiveTotem().defensiveTotem().getItemMeta().getPersistentDataContainer())){
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onDie(PlayerDeathEvent e){

        Main.getMain().getPowers().removeUsingPowerPlayer(e.getEntity().getPlayer());
    }



}
