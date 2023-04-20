package fenitride.chemicallaboratory.register;

import fenitride.chemicallaboratory.lists.Items;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ModelRegister {
    public static void register() {
        ModelLoader.setCustomModelResourceLocation(Items.POISON_POWDER, 0, new ModelResourceLocation(Items.POISON_POWDER.getRegistryName(), "inventory"));
    }
}
