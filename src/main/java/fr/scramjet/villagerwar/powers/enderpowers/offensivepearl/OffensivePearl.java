package fr.scramjet.villagerwar.powers.enderpowers.offensivepearl;

import fr.scramjet.villagerwar.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;


import java.util.List;


public class OffensivePearl {



    public void addPlayerWaitingList(Player player, ItemStack itemStack){
        Main.getMain().getPowers().addUsingPowerPlayer(player);
        itemStack.setType(Material.MAGENTA_GLAZED_TERRACOTTA);
        int duration = Main.getPlugin().getConfig().getInt("powerstime.time");
        new BukkitRunnable() {
            int dur = duration;
            @Override
            public void run() {

                dur--;
                if (dur <= 0) {
                    Main.getMain().getPowers().removeUsingPowerPlayer(player);
                    itemStack.setType(Material.ENDER_PEARL);
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0, 20);
    }

    public NamespacedKey getOffensivePearlTag(){
        NamespacedKey key = new NamespacedKey(Main.getPlugin(), "opearl");
        return key;
    }
    // Giver of the ItemStack DO NOT USE <.isSimilar> -> use the Tag ↑↑↑↑
    public ItemStack offensivePearl(){
        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta pearlM = pearl.getItemMeta();
        pearlM.displayName(Component.text("Offensive Pearl").color(TextColor.color(255, 0, 0)));
        pearlM.getPersistentDataContainer().set(getOffensivePearlTag(), PersistentDataType.INTEGER, 3);
        pearl.setItemMeta(pearlM);
        return pearl;
    }
    public void offensivePearlAction(Player player, ItemStack itemStack) {
        if (!Main.getMain().getPowers().isUsingPowerPlayer(player)) {
            addPlayerWaitingList(player, itemStack);
            Location playerl = player.getLocation();
            Double lastDistance = Double.MAX_VALUE;
            List<Entity> near = player.getNearbyEntities(25, 25, 25);
            Entity result = null;
            for (Entity p : near) {
                if (p instanceof Entity) {
                    if (player == p) {
                        continue;
                    }
                    double distance = playerl.distance(p.getLocation());
                    if (distance < lastDistance) {
                        lastDistance = distance;
                        result = p;

                    }
                }
            }
            if (result != null) {
                Location tloc = result.getLocation();
                tloc.add(result.getLocation().getDirection().multiply(-2));
                tloc.add(0, 1, 0);
                tloc.setYaw(result.getLocation().getYaw());
                player.teleport(tloc);

            } else {
                player.sendMessage("[Game]→ Unable to find a player");
                Main.getMain().getPowers().removeUsingPowerPlayer(player);
                itemStack.setType(Material.ENDER_PEARL);
            }


        }
    }
}
