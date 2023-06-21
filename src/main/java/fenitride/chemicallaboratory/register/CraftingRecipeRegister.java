package fenitride.chemicallaboratory.register;

import fenitride.chemicallaboratory.recipes.RecipeAddEffectToSyringe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CraftingRecipeRegister {
    public static void register() {
        ForgeRegistries.RECIPES.register(new RecipeAddEffectToSyringe().setRegistryName("chemical_laboratory:add_potion_syringe"));
    }
}
