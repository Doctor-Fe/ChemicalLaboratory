package fenitride.chemicallaboratory.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockMultipart6Dir extends Block {

    public static final PropertyBool BOTTOM = PropertyBool.create("bottom");
    public static final PropertyBool TOP = PropertyBool.create("top");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool[] FACING_PROPERTIES = { BOTTOM, TOP, NORTH, SOUTH, WEST, EAST };

    public BlockMultipart6Dir(Material material, MapColor color) {
        super(material, color);
        setDefaultState(blockState.getBaseState()
            .withProperty(NORTH, false)
            .withProperty(SOUTH, false)
            .withProperty(EAST, false)
            .withProperty(WEST, false)
            .withProperty(TOP, false)
            .withProperty(BOTTOM, false)
        );
    }

    // ---- ブロックの見た目に関する処理 ----

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
            EnumFacing side) {
        return true;
    }

    // ---- ブロックの動作に関する処理 ----

    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state
            .withProperty(BOTTOM, isConnectedTo(worldIn, pos, EnumFacing.DOWN))
            .withProperty(TOP, isConnectedTo(worldIn, pos, EnumFacing.UP))
            .withProperty(NORTH, isConnectedTo(worldIn, pos, EnumFacing.NORTH))
            .withProperty(SOUTH, isConnectedTo(worldIn, pos, EnumFacing.SOUTH))
            .withProperty(WEST, isConnectedTo(worldIn, pos, EnumFacing.WEST))
            .withProperty(EAST, isConnectedTo(worldIn, pos, EnumFacing.EAST));
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        updateConnection(worldIn, pos, state);
    }

    @Override
    public void observedNeighborChange(IBlockState observerState, World world, BlockPos observerPos, Block changedBlock, BlockPos changedBlockPos) {
        updateConnection((World) world, observerPos, observerState);
    }

    protected void updateConnection(World worldIn, BlockPos pos, IBlockState state) {
        boolean[] data = new boolean[6];
        for (EnumFacing facing : EnumFacing.values()) {
            data[facing.getIndex()] = isConnectedTo(worldIn, pos, facing);
        }
        worldIn.setBlockState(pos, state
                .withProperty(NORTH, data[2])
                .withProperty(SOUTH, data[3])
                .withProperty(EAST, data[5])
                .withProperty(WEST, data[4])
                .withProperty(TOP, data[1])
                .withProperty(BOTTOM, data[0]));
    }

    // ---- BlockStateの管理に関する処理 ----

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { NORTH, SOUTH, EAST, WEST, TOP, BOTTOM });
    }

    /** 隣接するブロックと接続するかを返します。
     * @param worldIn ワールドデータ
     * @param pos ブロックの座標
     * @param facing 判定する方向
     * @return 接続する場合は`true`を、そうでなければ`false`を返します。
     */
    protected abstract boolean isConnectedTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing);
}
