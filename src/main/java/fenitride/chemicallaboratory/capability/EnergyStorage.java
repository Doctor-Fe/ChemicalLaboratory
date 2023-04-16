package fenitride.chemicallaboratory.capability;

import net.minecraftforge.energy.IEnergyStorage;

public class EnergyStorage implements IEnergyStorage {

    protected int amount;
    protected final int capacity;

    public EnergyStorage(int capacity) {
        this.capacity = capacity;
        this.amount = 0;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int actualAmount = Math.min(maxReceive, this.capacity - this.amount);
        if (!simulate) {
            this.amount += actualAmount;
        }
        return actualAmount;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int actualAmount = Math.min(maxExtract, this.amount);
        if (!simulate) {
            this.amount -= actualAmount;
        }
        return actualAmount;
    }

    @Override
    public int getEnergyStored() {
        return this.amount;
    }

    @Override
    public int getMaxEnergyStored() {
        return this.capacity;
    }

    @Override
    public boolean canExtract() {
        return true;
    }

    @Override
    public boolean canReceive() {
        return true;
    }
    
}
