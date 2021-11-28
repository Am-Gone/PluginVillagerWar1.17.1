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
import org.bukkit.util.Vector;

import java.util.List;


public class OffensivePearl {

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
    public void offensivePearlAction(Player player){
        Location playerl = player.getLocation();
        Double lastDistance = Double.MAX_VALUE;
        List<Entity> near = player.getNearbyEntities(25, 25, 25);
        Entity result = null;
        for(Entity p : near) {
            if (p instanceof Entity) {
                if (player == p) {
                    continue;
                }
                double distance = playerl.distance(p.getLocation());
                if (distance < lastDistance) {
                    lastDistance = distance;
                    result =  p;

                }
            }
        }
        if(result != null){
            Location tloc = result.getLocation();
            tloc.add(result.getLocation().getDirection().multiply(-2));
            tloc.add(0, 1, 0);
            tloc.setYaw(result.getLocation().getYaw());
           player.teleport(tloc);

        }else {
            player.sendMessage("[Game]→ Unable to find a player");
        }


    }
}
