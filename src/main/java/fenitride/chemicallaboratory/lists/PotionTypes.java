package fenitride.chemicallaboratory.lists;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionTypes {

	public static PotionType STRONGEST_POISON = new PotionType("strongest_poison", new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:poison"), 1200, 2)).setRegistryName("chemical_laboratory:strongest_poison");

	public static void register()
	{
        ForgeRegistries.POTION_TYPES.registerAll(STRONGEST_POISON);
	}
}
