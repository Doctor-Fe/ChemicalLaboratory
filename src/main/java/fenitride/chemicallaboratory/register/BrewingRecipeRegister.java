package fenitride.chemicallaboratory.register;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class BrewingRecipeRegister {
    public static void register() {
        BrewingRecipeRegistry.addRecipe(
            PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionType.getPotionTypeForName("minecraft:strong_poison")),
            new ItemStack(fenitride.chemicallaboratory.lists.Items.POISON_POWDER, 1),
            PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionType.getPotionTypeForName("chemical_laboratory:strongest_poison"))
        );
        BrewingRecipeRegistry.addRecipe( // Poison of Potion's another recipe.
            PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionType.getPotionTypeForName("minecraft:awkward")),
            new ItemStack(fenitride.chemicallaboratory.lists.Items.POISON_POWDER),
            PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionType.getPotionTypeForName("minecraft:poison"))
        );
        // BrewingRecipeRegistry.addRecipe( // Grinpowder to Potion of Poison
        //     PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionType.getPotionTypeForName("minecraft:awkward")),
        //     new ItemStack(Item.getByNameOrId("ic2:itemmisc"), 1, 150),
        //     PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionType.getPotionTypeForName("minecraft:poison"))
        // );
    }
}
