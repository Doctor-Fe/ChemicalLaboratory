package fenitride.chemicallaboratory.register;

public class VanillaItemModifier {
    public static void modify() {
		net.minecraft.init.Items.POTIONITEM.setMaxStackSize(16);
		net.minecraft.init.Items.SPLASH_POTION.setMaxStackSize(16);
		net.minecraft.init.Items.LINGERING_POTION.setMaxStackSize(16);
    }
}
