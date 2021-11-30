package fr.scramjet.villagerwar.powers.netherpowers;

import fr.scramjet.villagerwar.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class DefensiveFlint {

    List<Player> regPlayer = new ArrayList<>();
    public boolean isRegPlayer(Player player){return regPlayer.contains(player);}
    // Tag to reference the ItemStack
    public NamespacedKey getOffensiveFlintTag(){
        NamespacedKey key = new NamespacedKey(Main.getPlugin(), "dFlint");
        return key;
    }
    // Giver of the ItemStack DO NOT USE <.isSimilar> -> use the Tag ↑↑↑↑
    public ItemStack defensiveFlint(){
        ItemStack flint = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta flintM = flint.getItemMeta();
        flintM.displayName(Component.text("Defensive Flint").color(TextColor.color(0, 0, 255)));
        flintM.getPersistentDataContainer().set(getOffensiveFlintTag(), PersistentDataType.INTEGER, 2);
        flint.setItemMeta(flintM);
        return flint;
    }
    public void defensiveFlintAction(Player player, ItemStack itemStack) {
        if (!Main.getMain().getPowers().isUsingPowerPlayer(player)) {
            regPlayer.add(player);
            Main.getMain().getPowers().addUsingPowerPlayer(player);
            int duration = 15;
            itemStack.setType(Material.GREEN_GLAZED_TERRACOTTA);
            new BukkitRunnable() {
                int dur = duration;

                @Override
                public void run() {

                    dur--;
                    if (dur <= 0) {
                        regPlayer.remove(player);
                        Main.getMain().getPowers().removeUsingPowerPlayer(player);
                        itemStack.setType(Material.FLINT_AND_STEEL);
                        cancel();
                    }
                }
            }.runTaskTimer(Main.getPlugin(), 0, 20);
        }
    }



}
