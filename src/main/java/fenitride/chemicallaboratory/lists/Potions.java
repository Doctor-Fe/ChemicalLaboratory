package fenitride.chemicallaboratory.lists;

import fenitride.chemicallaboratory.potions.PotionAntidote;
import fenitride.chemicallaboratory.potions.PotionPurification;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Potions {
    public static final Potion ANTIDOTE = new PotionAntidote();
    public static final Potion PURIFICATION = new PotionPurification();

    public static void register() {
        ForgeRegistries.POTIONS.registerAll(ANTIDOTE, PURIFICATION);
    }
}
