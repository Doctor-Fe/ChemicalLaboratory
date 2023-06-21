package fenitride.chemicallaboratory.register;

import fenitride.chemicallaboratory.items.colorhandler.SyringeColorHandler;
import fenitride.chemicallaboratory.lists.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.ItemColors;

public class ColorHandlerRegister {
    public static void register() {
        ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
        itemColors.registerItemColorHandler(new SyringeColorHandler(), Items.SYRINGE);
    }
}
