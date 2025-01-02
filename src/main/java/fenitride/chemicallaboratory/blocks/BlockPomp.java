package fenitride.chemicallaboratory.blocks;

import javax.annotation.Nullable;

import fenitride.chemicallaboratory.tiles.TilePomp;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPomp extends BlockBase {

    public BlockPomp() {
        super("pomp", Material.IRON);
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    @Nullable
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TilePomp();
    }
}
