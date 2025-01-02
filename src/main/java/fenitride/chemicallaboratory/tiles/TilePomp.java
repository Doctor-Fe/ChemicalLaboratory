package fenitride.chemicallaboratory.tiles;

import fenitride.chemicallaboratory.capability.EnergyStorage;
import fenitride.chemicallaboratory.capability.FluidStorage;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class TilePomp extends TileEntity implements ITickable {

    public static final String ID = "pomp";
    protected FluidStorage tank = new FluidStorage(1000);
    protected EnergyStorage energy = new EnergyStorage(2000);

    @Override
    public void update() {
        BlockPos pos = this.getPos();
        TileEntity te0 = this.world.getTileEntity(pos.offset(EnumFacing.DOWN));
        if (te0 == null) {
            return;
        }
        IFluidHandler fluidHandler0 = te0.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, EnumFacing.UP);
        if (fluidHandler0 == null) {
            return;
        }
        if (this.tank != null) {
            this.tank.tryFillTo(fluidHandler0, 100);
        }
    }
}
