package fenitride.chemicallaboratory.lists;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionTypes {

	public static final PotionType STRONGEST_POISON = new PotionType("strongest_poison", new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:poison"), 1200, 2)).setRegistryName("chemical_laboratory:strongest_poison");
	public static final PotionType ANTIDOTE_1 = new PotionType("antidote", new PotionEffect(Potions.ANTIDOTE, 1200, 0, false, false)).setRegistryName("chemical_laboratory:antidote");

	public static void register()
	{
        ForgeRegistries.POTION_TYPES.registerAll(ANTIDOTE_1, STRONGEST_POISON);
	}
}
