package fenitride.chemicallaboratory.lists;

import fenitride.chemicallaboratory.ChemicalLaboratory;
import fenitride.chemicallaboratory.items.ItemSyringe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Items {

	public static final Item EMPTY_SYRINGE = getItemFromName(ChemicalLaboratory.MODID, "empty_syringe");
	public static final Item SYRINGE = new ItemSyringe();
	public static final Item POISON_POWDER = getItemFromName(ChemicalLaboratory.MODID, "poison_powder");

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
		ForgeRegistries.ITEMS.registerAll(EMPTY_SYRINGE, POISON_POWDER, SYRINGE);
	}
}