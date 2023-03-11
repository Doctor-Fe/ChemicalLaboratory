package fenitride.chemicallaboratory.lists;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Items {

	public static Item SYRINGE;

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
	}
}