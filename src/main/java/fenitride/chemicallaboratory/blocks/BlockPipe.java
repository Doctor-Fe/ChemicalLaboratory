package fenitride.chemicallaboratory.blocks;

import javax.annotation.Nullable;

import fenitride.chemicallaboratory.tiles.TilePipe;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPipe extends BlockBase {

    public static final PropertyBool BOTTOM = PropertyBool.create("bottom");
    public static final PropertyBool TOP = PropertyBool.create("top");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool[] FACING_PROPERTIES = { BOTTOM, TOP, NORTH, SOUTH, WEST, EAST };

    public BlockPipe() {
        super("pipe", Material.IRON);
    }
    
    @Override
    @Nullable
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TilePipe();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }
}
