package fenitride.chemicallaboratory.blocks;

import fenitride.chemicallaboratory.ChemicalLaboratory;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BlockBase extends Block {

    public BlockBase(String id, Material materialIn) {
        super(materialIn);
        setRegistryName(ChemicalLaboratory.MODID, id);
        setUnlocalizedName(id);
    }
    
}
