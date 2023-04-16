package fenitride.chemicallaboratory.register;

import fenitride.chemicallaboratory.ChemicalLaboratory;
import fenitride.chemicallaboratory.tiles.TilePipe;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRegister {
    public static void register() {
        TileEntity.register(ChemicalLaboratory.MODID + ":" + TilePipe.ID, TilePipe.class);
    }
}
