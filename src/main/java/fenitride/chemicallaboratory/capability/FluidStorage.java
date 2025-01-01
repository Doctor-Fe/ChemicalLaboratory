package fenitride.chemicallaboratory.capability;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

public class FluidStorage implements IFluidTank, IFluidHandler {

    protected FluidStack stack;
    protected final int capacity;
	protected IFluidTankProperties[] tankProperties;

    public FluidStorage(int capacity) {
        this.capacity = capacity;
        this.stack = null;
    }

    public boolean canFillTo(FluidStack stack) {
        return this.stack == null || this.stack.isFluidEqual(stack);
    }

    public boolean isEmpty() {
        return this.stack == null || this.stack.amount == 0;
    }

    @Override
    @Nullable
    public FluidStack getFluid() {
        return stack;
    }

    @Override
    public int getFluidAmount() {
        return this.stack == null ? 0 : this.stack.amount;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public FluidTankInfo getInfo() {
        return new FluidTankInfo(this);
    }

    @Override
    public int fill(FluidStack resource, boolean doFill) {
        if (this.canFillTo(resource)) {
            int v = this.capacity - getFluidAmount();
            int actualAmount = Math.min(v, resource != null ? resource.amount : 0);
            if (doFill) {
                if (this.stack != null) {
                    this.stack.amount += actualAmount;
                } else {
                    this.stack = new FluidStack(resource.getFluid(), actualAmount);
                }
            }
            return actualAmount;
        } else {
            return 0;
        }
    }

    @Override
    @Nullable
    public FluidStack drain(int maxDrain, boolean doDrain) {
        if (!isEmpty()) {
            int actualAmount = Math.min(this.getFluidAmount(), maxDrain);
            if (actualAmount > 0) {
                FluidStack stack = new FluidStack(this.stack.getFluid(), actualAmount);
                if (doDrain) {
                    this.stack.amount = getFluidAmount() - actualAmount;
                    if (this.getFluidAmount() == 0) {
                        this.stack = null;
                    }
                }
                return stack;
            }
        }
        return null;
    }

    @Override
    public IFluidTankProperties[] getTankProperties() {
        return new IFluidTankProperties[] {new FluidTankProperties(this.getFluid(), capacity)};
    }

    @Override
    @Nullable
    public FluidStack drain(FluidStack resource, boolean doDrain) {
        if (!this.isEmpty() && this.stack.isFluidEqual(resource)) {
            return drain(resource.amount, doDrain);
        } else {
            return null;
        }
    }

    public void readFromNBT(NBTTagCompound compound) {
        FluidStack stack = FluidStack.loadFluidStackFromNBT(compound);
        this.stack = stack;
    }

    @Nullable
    public NBTTagCompound getTagCompound() {
        if (this.stack != null) {
            NBTTagCompound tag = new NBTTagCompound();
            this.stack.writeToNBT(tag);
            return tag;
        } else {
            return null;
        }
    }
}
