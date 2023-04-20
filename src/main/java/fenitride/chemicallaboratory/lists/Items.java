package fenitride.chemicallaboratory.lists;

import fenitride.chemicallaboratory.ChemicalLaboratory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Items {

	public static Item SYRINGE;
	public static Item POISON_POWDER = getItemFromName(ChemicalLaboratory.MODID, "poison_powder");

	private static Item getItemFromBlock(Block block)
	{
		return new ItemBlock(block).setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getUnlocalizedName());
	}

	private static Item getItemFromName(String modID, String name)
	{
		return new Item().setRegistryName(modID, name).setUnlocalizedName(name);
	}

	public static void register()
	{
		ForgeRegistries.ITEMS.registerAll(POISON_POWDER);
	}
}