package fr.scramjet.villagerwar.powers;

import fr.scramjet.villagerwar.powers.enderpowers.defensivepearl.DefensivePearl;
import fr.scramjet.villagerwar.powers.enderpowers.offensivepearl.OffensivePearl;
import fr.scramjet.villagerwar.powers.netherpowers.DefensiveFlint;
import fr.scramjet.villagerwar.powers.netherpowers.OffensiveFlint;
import fr.scramjet.villagerwar.powers.overpower.DefensiveTotem;
import fr.scramjet.villagerwar.powers.overpower.OffensiveTotem;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Powers {

   private final List<Player> usingPowerPlayer = new ArrayList<>();
   public void addPlayerUsingPower(Player player) {
       usingPowerPlayer.add(player);
   }

   public void removePlayerUsingPower(Player player) {
       usingPowerPlayer.remove(player);
   }

   public boolean isPlayerUsingPower(Player player) {
       return usingPowerPlayer.contains(player);
   }

    public void clearPlayersUsingPower(){
       usingPowerPlayer.clear();
   }


    DefensivePearl defensivePearl = new DefensivePearl();
    public DefensivePearl getDefensivePearl(){
        return defensivePearl;
    }

    OffensivePearl offensivePearl = new OffensivePearl();
    public OffensivePearl getOffensivePearl(){return offensivePearl;}

    OffensiveFlint offensiveFlint = new OffensiveFlint();
    public OffensiveFlint getOffensiveFlint(){return offensiveFlint;}

    DefensiveFlint defensiveFlint = new DefensiveFlint();
    public DefensiveFlint getDefensiveFlint(){return defensiveFlint;}

    OffensiveTotem offensiveTotem = new OffensiveTotem();
    public OffensiveTotem getOffensiveTotem() {return offensiveTotem;}

    DefensiveTotem defensiveTotem = new DefensiveTotem();
    public DefensiveTotem getDefensiveTotem() {return defensiveTotem;}
}
