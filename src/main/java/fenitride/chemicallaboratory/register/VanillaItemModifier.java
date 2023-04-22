package fenitride.chemicallaboratory.register;

import net.minecraft.init.Items;

public class VanillaItemModifier {
    public static void modify() {
		Items.POTIONITEM.setMaxStackSize(16);
		Items.SPLASH_POTION.setMaxStackSize(16);
		Items.LINGERING_POTION.setMaxStackSize(16);
    }
}
