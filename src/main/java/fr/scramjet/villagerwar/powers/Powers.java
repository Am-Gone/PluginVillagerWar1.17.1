package fr.scramjet.villagerwar.powers;

import fr.scramjet.villagerwar.powers.enderpowers.defensivepearl.DefensivePearl;
import fr.scramjet.villagerwar.powers.enderpowers.offensivepearl.OffensivePearl;
import fr.scramjet.villagerwar.powers.netherpowers.DefensiveFlint;
import fr.scramjet.villagerwar.powers.netherpowers.OffensiveFlint;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Powers {


   private List<Player> usingPowerPlayer = new ArrayList<>();
   public void addUsingPowerPlayer(Player player){usingPowerPlayer.add(player);}
   public void removeUsingPowerPlayer(Player player){usingPowerPlayer.remove(player);}
   public boolean isUsingPowerPlayer(Player player){return usingPowerPlayer.contains(player);}


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






}
