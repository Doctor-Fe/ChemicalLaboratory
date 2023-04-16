package fenitride.chemicallaboratory.lists;

import fenitride.chemicallaboratory.blocks.BlockPipe;
import fenitride.chemicallaboratory.blocks.BlockPomp;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Blocks {

	public static Block PIPE = new BlockPipe();
	public static Block POMP = new BlockPomp();

	public static void register() {
		ForgeRegistries.BLOCKS.registerAll(PIPE, POMP);
	}
}