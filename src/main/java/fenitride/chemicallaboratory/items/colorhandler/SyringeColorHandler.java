package fenitride.chemicallaboratory.items.colorhandler;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;

public class SyringeColorHandler implements IItemColor {
    @Override
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        return tintIndex == 0 ? PotionUtils.getColor(stack) : -1;
    }
}
