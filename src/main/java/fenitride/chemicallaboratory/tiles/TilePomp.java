package fenitride.chemicallaboratory.tiles;

import fenitride.chemicallaboratory.capability.EnergyStorage;
import fenitride.chemicallaboratory.capability.FluidStorage;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TilePomp extends TileEntity implements ITickable {

    public static final String ID = "pomp";
    protected FluidStorage tank = new FluidStorage(1000);
    protected EnergyStorage energy = new EnergyStorage(2000);

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }
    
}
