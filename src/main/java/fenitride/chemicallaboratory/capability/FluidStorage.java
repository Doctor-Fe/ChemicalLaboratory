package fenitride.chemicallaboratory.capability;

import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

public class FluidStorage implements IFluidTank, IFluidHandler {

    protected Optional<FluidStack> stack;
    protected final int capacity;
	protected IFluidTankProperties[] tankProperties;

    public FluidStorage(int capacity) {
        this.capacity = capacity;
        this.stack = Optional.empty();
    }

    public boolean canFillTo(FluidStack stack) {
        return this.stack.map(a -> a.isFluidEqual(stack)).orElse(true);
    }

    public boolean isEmpty() {
        return this.stack.map(a -> a.amount == 0).orElse(true);
    }

    @Override
    @Nullable
    public FluidStack getFluid() {
        return this.stack.isPresent() ? this.stack.get() : null;
    }

    @Override
    public int getFluidAmount() {
        return this.stack.map(t -> t.amount).orElse(0);
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
            int actualAmount = Math.min(v, resource.amount);
            if (doFill) {
                if (this.stack.isPresent()) {
                    this.stack.get().amount += actualAmount;
                } else {
                    this.stack = Optional.of(new FluidStack(resource.getFluid(), actualAmount));
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
                FluidStack stack = new FluidStack(this.stack.get().getFluid(), actualAmount);
                if (doDrain) {
                    this.stack.get().amount = getFluidAmount() - actualAmount;
                    if (this.getFluidAmount() == 0) {
                        this.stack = Optional.empty();
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
        if (!this.isEmpty() && this.stack.get().isFluidEqual(resource)) {
            return drain(resource.amount, doDrain);
        } else {
            return null;
        }
    }

    public void readFromNBT(NBTTagCompound compound) {
        FluidStack stack = FluidStack.loadFluidStackFromNBT(compound);
        this.stack = Optional.ofNullable(stack);
    }

    public Optional<NBTTagCompound> getTagCompound() {
        if (this.stack.isPresent()) {
            FluidStack stack = this.stack.get();
            NBTTagCompound tag = new NBTTagCompound();
            stack.writeToNBT(tag);
            return Optional.of(tag);
        } else {
            return Optional.empty();
        }
    }
}
