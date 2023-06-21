package fenitride.chemicallaboratory.lists;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionTypes {

	public static final PotionType ANTIDOTE_1 = new PotionType("antidote", new PotionEffect(Potions.ANTIDOTE, 1200, 0, false, false)).setRegistryName("chemical_laboratory:antidote");
	public static final PotionType PURIFICATION_1 = new PotionType("purification", new PotionEffect(Potions.PURIFICATION, 600, 0, false, true)).setRegistryName("chemical_laboratory:purification");
	public static final PotionType STRONGEST_POISON = new PotionType("strongest_poison", new PotionEffect(MobEffects.POISON, 1200, 2)).setRegistryName("chemical_laboratory:strongest_poison");

	public static void register()
	{
        ForgeRegistries.POTION_TYPES.registerAll(ANTIDOTE_1, PURIFICATION_1, STRONGEST_POISON);
	}
}
