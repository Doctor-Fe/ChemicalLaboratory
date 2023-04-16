package fenitride.chemicallaboratory.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockPomp extends BlockBase {

    public BlockPomp() {
        super("pomp", Material.IRON);
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }
}
