package fenitride.chemicallaboratory.recipes;

import java.util.Optional;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipeAddEffectToSyringe extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean canFit(int width, int height) {
        return width * height > 1;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack stack1 = ItemStack.EMPTY;
        for (int i = 0; i < inv.getWidth(); i += 1) {
            for (int j = 0; j < inv.getHeight(); j += 1) {
                ItemStack stack = inv.getStackInRowAndColumn(i, j);
                if (stack.getItem() == Items.POTIONITEM) {
                    stack1 = stack;
                }
            }
        }
        ItemStack newStack = new ItemStack(fenitride.chemicallaboratory.lists.Items.SYRINGE);
        Optional<NBTTagCompound> compound = Optional.ofNullable(stack1.getTagCompound());
        NBTTagCompound newCompound = new NBTTagCompound();
        if (compound.isPresent()) {
            NBTTagCompound compound2 = compound.get();
            if (compound2.hasKey("Potion")) {
                newCompound.setTag("Potion", compound2.getTag("Potion"));
            }
            if (compound2.hasKey("CustomPotionEffects")) {
                newCompound.setTag("CustomPotionEffects", compound2.getTag("CustomPotionEffects"));
            }
            if (compound2.hasKey("CustomPotionColor")) {
                newCompound.setTag("CustomPotionColor", compound2.getTag("CustomPotionColor"));
            }
        }
        newStack.setTagCompound(newCompound);
        return newStack;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        int emptySyringes = 0;
        int potions = 0;
        for (int i = 0; i < inv.getWidth(); i += 1) {
            for (int j = 0; j < inv.getHeight(); j += 1) {
                ItemStack stack = inv.getStackInRowAndColumn(i, j);

                if (!stack.isEmpty()) {
                    Item item = stack.getItem();
                    if (item == Items.POTIONITEM) {
                        potions += 1;
                    } else if (item == fenitride.chemicallaboratory.lists.Items.EMPTY_SYRINGE) {
                        emptySyringes += 1;
                    }
                }
            }
        }
        return emptySyringes == 1 && potions == 1;
    }

    @Override
    public boolean isDynamic() {
        return true;
    }
}
