package fenitride.chemicallaboratory.tiles;

import java.util.Optional;

import javax.annotation.Nullable;

import fenitride.chemicallaboratory.capability.FluidStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class TilePipe extends TileEntity implements ITickable {

    public static final String ID = "pipe";
    protected FluidStorage tank = new FluidStorage(125);

    @Override
    public void update() {
        if (!world.isRemote) {
            Optional<TileEntity> tile = Optional.ofNullable(this.world.getTileEntity(this.pos.offset(EnumFacing.DOWN)));
            if (tile.isPresent()) {
                Optional<IFluidHandler> capability = Optional.ofNullable(tile.get().getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, EnumFacing.UP));
                if (capability.isPresent()) {
                    IFluidHandler cap = capability.get();
                    int amount = cap.fill(tank.getFluid(), false);
                    if (amount > 0) {
                        cap.fill(tank.getFluid(), true);
                        tank.drain(amount, true);
                    }
                }
            }
        }
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
            return true;
        else
            return super.hasCapability(capability, facing);
    }

    @Override
    @Nullable
    @SuppressWarnings("unchecked")
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return (T)tank;
        } else {
            return super.getCapability(capability, facing);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("tank0")) {
            this.tank.readFromNBT(compound.getCompoundTag("tank0"));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        Optional<NBTTagCompound> tag = this.tank.getTagCompound();
        if (tag.isPresent()) {
            compound.setTag("tank0", tag.get());
        }
        return compound;
    }
}
