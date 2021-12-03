package fr.scramjet.villagerwar.powers.overpower;

import fr.scramjet.villagerwar.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class OffensiveTotem {

    List<Player> regPlayer = new ArrayList<>();
    public boolean isRegPlayer(Player player){return regPlayer.contains(player);}


    public NamespacedKey getOffensiveFlintTag() {
        NamespacedKey key = new NamespacedKey(Main.getPlugin(), "oTotem");
        return key;
    }

    // Giver of the ItemStack DO NOT USE <.isSimilar> -> use the Tag ↑↑↑↑
    public ItemStack offensiveTotem() {
        ItemStack flint = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta flintM = flint.getItemMeta();
        flintM.displayName(Component.text("Offensive Totem").color(TextColor.color(255, 0, 0)));
        flintM.getPersistentDataContainer().set(getOffensiveFlintTag(), PersistentDataType.INTEGER, 45);
        flint.setItemMeta(flintM);
        return flint;


    }
    public void offensiveTotemAction(Player player, ItemStack itemStack) {
        if (!Main.getMain().getPowers().isUsingPowerPlayer(player)) {
            Main.getMain().getPowers().addUsingPowerPlayer(player);
            itemStack.setType(Material.MAGENTA_GLAZED_TERRACOTTA);
            regPlayer.add(player);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000, 1));
            int duration = Main.getPlugin().getConfig().getInt("powerstime.time");
            new BukkitRunnable() {
                int dur = duration;

                @Override
                public void run() {

                    dur--;
                    if (dur <= 0) {
                        regPlayer.remove(player);
                        player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                        player.removePotionEffect(PotionEffectType.SLOW);
                        Main.getMain().getPowers().removeUsingPowerPlayer(player);
                        itemStack.setType(Material.TOTEM_OF_UNDYING);
                        cancel();
                    }
                }
            }.runTaskTimer(Main.getPlugin(), 0, 20);
        }
    }
}
