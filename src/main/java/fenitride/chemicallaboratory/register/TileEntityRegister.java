package fenitride.chemicallaboratory.register;

import fenitride.chemicallaboratory.ChemicalLaboratory;
import fenitride.chemicallaboratory.tiles.TilePipe;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRegister {
    /**
     * タイルエンティティを登録するクラス
     * @param isRemote クライアント側の時 true
     */
    public static void register(boolean isRemote) {
        if (isRemote) { // TESR を使用するときのために。
            TileEntity.register(ChemicalLaboratory.MODID + ":" + TilePipe.ID, TilePipe.class);
        } else {
            TileEntity.register(ChemicalLaboratory.MODID + ":" + TilePipe.ID, TilePipe.class);
        }
    }
}
