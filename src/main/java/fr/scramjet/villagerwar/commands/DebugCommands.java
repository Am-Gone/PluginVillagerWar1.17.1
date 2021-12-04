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
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cVous devez être un joueur pour exécuter cette commande.");
            return false;
        }

        Player player = (Player) commandSender;

        switch (string) {
            case "debug1" -> player.getInventory().addItem(Main.getMain().getPowers().getDefensivePearl().defensivePearl());
            case "debug2" -> player.getInventory().addItem(Main.getMain().getPowers().getOffensivePearl().offensivePearl());
            case "debug3" -> player.getInventory().addItem(Main.getMain().getPowers().getOffensiveFlint().offensiveFlint());
            case "debug4" -> player.getInventory().addItem(Main.getMain().getPowers().getDefensiveFlint().defensiveFlint());
            case "debug5" -> player.getInventory().addItem(Main.getMain().getPowers().getOffensiveTotem().offensiveTotem());
            case "debug6" -> player.getInventory().addItem(Main.getMain().getPowers().getDefensiveTotem().defensiveTotem());
        }
        return false;
    }
}
