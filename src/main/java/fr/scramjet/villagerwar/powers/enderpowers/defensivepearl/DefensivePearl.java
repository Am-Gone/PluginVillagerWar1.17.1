package fr.scramjet.villagerwar.powers.enderpowers.defensivepearl;

import fr.scramjet.villagerwar.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;


import java.util.concurrent.ThreadLocalRandom;

public class DefensivePearl {

    public void addPlayerWaitingList(Player player, ItemStack itemStack) {
        Main.getMain().getPowers().addPlayerUsingPower(player);
        itemStack.setType(Material.PINK_GLAZED_TERRACOTTA);
        int duration = Main.getPlugin().getConfig().getInt("powerstime.time");
        new BukkitRunnable() {
            int dur = duration;

            @Override
            public void run() {
                dur--;
                if (dur <= 0) {
                    Main.getMain().getPowers().removePlayerUsingPower(player);
                    itemStack.setType(Material.ENDER_PEARL);
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0, 20);
    }


    // Tag to reference the ItemStack
    public NamespacedKey getDefencivePearlTag() {
        return new NamespacedKey(Main.getPlugin(), "dpearl");
    }

    // Giver of the ItemStack DO NOT USE <.isSimilar> -> use the Tag ↑↑↑↑
    public ItemStack defensivePearl() {
        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta pearlM = pearl.getItemMeta();
        pearlM.displayName(Component.text("Defensive Pearl").color(TextColor.color(8, 0, 255)));
        pearlM.getPersistentDataContainer().set(getDefencivePearlTag(), PersistentDataType.INTEGER, 2);
        pearl.setItemMeta(pearlM);
        return pearl;
    }

    public void defensivePearlAction(Player player, ItemStack itemStack) {
        if (!Main.getMain().getPowers().isPlayerUsingPower(player)) {
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
