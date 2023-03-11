package fenitride.chemicallaboratory.proxy;

import fenitride.chemicallaboratory.lists.Blocks;
import fenitride.chemicallaboratory.lists.Items;
import fenitride.chemicallaboratory.register.EventRegister;

public class CommonProxy {
	public void registerPre() {
		EventRegister.register();
		// EnchantmentRegister.register();
		Blocks.register();
		Items.register();
	}

	public void register() {
	}
}