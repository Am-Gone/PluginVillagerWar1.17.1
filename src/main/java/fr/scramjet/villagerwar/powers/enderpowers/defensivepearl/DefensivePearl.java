package fr.scramjet.villagerwar.powers.enderpowers.defensivepearl;

import fr.scramjet.villagerwar.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DefensivePearl {

    private List<Player> usingPlayers = new ArrayList<>();

    public void addPlayerWaitingList(Player player, ItemStack itemStack) {
        usingPlayers.add(player);
        itemStack.setType(Material.PINK_GLAZED_TERRACOTTA);
        int duration = 15;
        new BukkitRunnable() {
            int dur = duration;

            @Override
            public void run() {

                dur--;
                if (dur <= 0) {
                    usingPlayers.remove(player);
                    itemStack.setType(Material.ENDER_PEARL);
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0, 20);
    }


    // Tag to reference the ItemStack
    public NamespacedKey getDefencivePearlTag(){
        NamespacedKey key = new NamespacedKey(Main.getPlugin(), "dpearl");
        return key;
    }
    // Giver of the ItemStack DO NOT USE <.isSimilar> -> use the Tag ↑↑↑↑
    public ItemStack defencivePearl(){
        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta pearlM = pearl.getItemMeta();
        pearlM.displayName(Component.text("Defensive Pearl").color(TextColor.color(8, 0, 255)));
        pearlM.getPersistentDataContainer().set(getDefencivePearlTag(), PersistentDataType.INTEGER, 2);
        pearl.setItemMeta(pearlM);
        return pearl;
    }
    public void defensivePearlAction(Player player, ItemStack itemStack){
        if(!usingPlayers.contains(player)) {
            addPlayerWaitingList(player, itemStack);
            World world = player.getWorld();
            Location location = player.getLocation();
            double randomX = ThreadLocalRandom.current().nextInt(-25, 25);
            double randomZ = ThreadLocalRandom.current().nextInt(-25, 25);
            double realX = (location.getX() + randomX);
            double realZ = (location.getZ() + randomZ);
            location = location.set(realX, 0, realZ);
            double randomY = world.getHighestBlockYAt(location);
            location = location.set(realX, (randomY + 2), realZ);
            player.teleport(location);
        }
    }

}
