package fenitride.chemicallaboratory.tiles;

import java.util.ArrayList;

import javax.annotation.Nullable;

import fenitride.chemicallaboratory.capability.FluidStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
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
        if (this.world.isRemote) {
            return;
        }
        if (this.tank != null && !this.tank.isEmpty()) {
            TileEntity tile = this.world.getTileEntity(this.pos.offset(EnumFacing.DOWN));
            if (tile != null) {
                IFluidHandler capability = tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, EnumFacing.UP);
                if (capability != null) {
                    this.tank.tryFillTo(capability, 125);
                }
            }
        }
        if (!this.tank.isEmpty()) {
            ArrayList<IFluidHandler> tiles = new ArrayList<IFluidHandler>();
            for (int i = 0; i < 4; i += 1) {
                EnumFacing facing = EnumFacing.getHorizontal(i);
                EnumFacing opposite = facing.getOpposite();
                TileEntity tile = this.world.getTileEntity(this.pos.offset(facing));
                if (tile != null) {
                    IFluidHandler handler = tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, opposite);
                    if (handler != null) {
                        tiles.add(handler);
                    }
                }
            }
            for (IFluidHandler handler : tiles) {
                this.tank.tryFillTo(handler, 125);
            }
        }
        if (!this.tank.isEmpty()) {
            TileEntity tile = this.world.getTileEntity(this.pos.offset(EnumFacing.UP));
            if (tile != null) {
                IFluidHandler capability = tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, EnumFacing.DOWN);
                if (capability != null) {
                    this.tank.tryFillTo(capability, 125);
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
        } else {
            this.tank = new FluidStorage(125);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        NBTTagCompound tag = this.tank.getTagCompound();
        if (tag != null) {
            compound.setTag("tank0", tag);
        }
        return compound;
    }

    @Override
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 0, this.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }
}
