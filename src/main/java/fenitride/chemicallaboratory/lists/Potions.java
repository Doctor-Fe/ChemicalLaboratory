package fenitride.chemicallaboratory.lists;

import fenitride.chemicallaboratory.potions.PotionAntidote;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Potions {
    public static final Potion ANTIDOTE = new PotionAntidote();

    public static void register() {
        ForgeRegistries.POTIONS.registerAll(ANTIDOTE);
    }
}
