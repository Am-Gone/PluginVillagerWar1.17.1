package fr.scramjet.villagerwar.commands;

import fr.scramjet.villagerwar.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DebugCommands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
       if(string.equals("debug1")) {
           if (commandSender instanceof Player) {
               Player player = (Player) commandSender;
               player.getInventory().setItem(1, Main.getMain().getPowers().getDefensivePearl().defencivePearl());
           }
       }
       if(string.equals("debug2")) {
           if (commandSender instanceof Player) {
               Player player = (Player) commandSender;
               //player.getInventory().setItem();
           }
       }
        return false;
    }
}
