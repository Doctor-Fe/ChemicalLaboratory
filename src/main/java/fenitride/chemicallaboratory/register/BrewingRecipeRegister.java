package fenitride.chemicallaboratory.register;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class BrewingRecipeRegister {
    public static void register() {
        tryRegisterWithPotionType("minecraft:strong_poison", new ItemStack(fenitride.chemicallaboratory.lists.Items.POISON_POWDER, 1), "chemical_laboratory:strongest_poison");
        tryRegisterWithPotionType("minecraft:awkward", new ItemStack(fenitride.chemicallaboratory.lists.Items.POISON_POWDER, 1), "minecraft:poison");
        tryRegisterWithPotionType("minecraft:awkward", new ItemStack(Item.getByNameOrId("ic2:itemmisc"), 1, 150), "minecraft:poison");
        tryRegisterWithPotionType("minecraft:awkward", new ItemStack(Items.SKULL, 1, 1), "minecraft:wither");
    }

    /**
     * ポーションの醸造レシピを追加する関数です。
     * @param oldEffect 要求されるポーション
     * @param stack 要求されるアイテム
     * @param newEffect 生成されるポーション
     */
    private static void tryRegisterWithPotionType(String oldEffect, ItemStack stack, String newEffect) {
        ItemStack oldStack = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionType.getPotionTypeForName(oldEffect));
        ItemStack newStack = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionType.getPotionTypeForName(newEffect));
        tryRegister(oldStack, stack, newStack);
    }

    /**
     * 醸造レシピを追加する関数です。
     * @param oldPotion 要求されるアイテム (ポーションの位置に置かれるアイテム)
     * @param stack 要求されるアイテム
     * @param newStack 生成されるアイテム
     */
    private static void tryRegister(ItemStack oldStack, ItemStack item, ItemStack newStack) {
        if (oldStack != null && item != null && newStack != null) {
            BrewingRecipeRegistry.addRecipe(oldStack, item, newStack);
        }
    }
}
