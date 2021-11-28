package fr.scramjet.villagerwar.powers;

import fr.scramjet.villagerwar.powers.enderpowers.defensivepearl.DefensivePearl;
import fr.scramjet.villagerwar.powers.enderpowers.offensivepearl.OffensivePearl;

public class Powers {

DefensivePearl defensivePearl = new DefensivePearl();
OffensivePearl offensivePearl = new OffensivePearl();


public DefensivePearl getDefensivePearl(){
    return defensivePearl;
}
public OffensivePearl getOffensivePearl(){
    return offensivePearl;
}



}
