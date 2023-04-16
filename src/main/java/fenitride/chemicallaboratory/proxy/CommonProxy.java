package fenitride.chemicallaboratory.proxy;

import fenitride.chemicallaboratory.lists.Blocks;
import fenitride.chemicallaboratory.lists.Items;
import fenitride.chemicallaboratory.register.EventRegister;
import fenitride.chemicallaboratory.register.TileEntityRegister;

public class CommonProxy {
	public void registerPre() {
		EventRegister.register();
		TileEntityRegister.register();
		// EnchantmentRegister.register();
		Blocks.register();
		Items.register();
	}

	public void register() {
	}
}