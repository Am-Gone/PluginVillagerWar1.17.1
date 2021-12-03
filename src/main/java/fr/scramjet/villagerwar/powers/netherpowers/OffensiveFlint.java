package fr.scramjet.villagerwar.powers.netherpowers;

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




public class OffensiveFlint {



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
                    itemStack.setType(Material.FLINT_AND_STEEL);
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0, 20);
    }

    // Tag to reference the ItemStack
    public NamespacedKey getOffensiveFlintTag(){
        NamespacedKey key = new NamespacedKey(Main.getPlugin(), "oFlint");
        return key;
    }
    // Giver of the ItemStack DO NOT USE <.isSimilar> -> use the Tag ↑↑↑↑
    public ItemStack offensiveFlint(){
        ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta flintM = flint.getItemMeta();
        flintM.displayName(Component.text("Offensive Flint").color(TextColor.color(255, 0, 0)));
        flintM.getPersistentDataContainer().set(getOffensiveFlintTag(), PersistentDataType.INTEGER, 2);
        flint.setItemMeta(flintM);
        return flint;
    }

    public void offensiveFlintAction(Player player, ItemStack itemStack){
        if(!Main.getMain().getPowers().isUsingPowerPlayer(player)) {
            addPlayerWaitingList(player, itemStack);
            World world = player.getWorld();
            Location location = player.getLocation();
            int radius = 5;
            Location pLocation = player.getLocation();
            for (int x = pLocation.getBlockX() - radius; x <= pLocation.getBlockX() + radius; x++) {
                for (int z = pLocation.getBlockZ() - radius; z <= pLocation.getBlockZ() + radius; z++) {
                    for (int y = pLocation.getBlockY() - radius; y <= pLocation.getBlockY() + radius; y++) {
                        location.set(x, y, z);
                        if (location.getBlock().getType().equals(Material.AIR)) {
                            location.getBlock().setType(Material.FIRE);
                        }
                    }


                }
            }
        }


    }

}
