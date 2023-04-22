package fenitride.chemicallaboratory.proxy;

import fenitride.chemicallaboratory.lists.Blocks;
import fenitride.chemicallaboratory.lists.Items;
import fenitride.chemicallaboratory.lists.PotionTypes;
import fenitride.chemicallaboratory.lists.Potions;
import fenitride.chemicallaboratory.register.BrewingRecipeRegister;
import fenitride.chemicallaboratory.register.EventRegister;
import fenitride.chemicallaboratory.register.VanillaItemModifier;

public class CommonProxy {
	public void registerPre() {
		EventRegister.register();
		Potions.register();
		PotionTypes.register();
		// EnchantmentRegister.register();
		Blocks.register();
		Items.register();
		BrewingRecipeRegister.register();
		VanillaItemModifier.modify();
	}

	public void register() {
	}
}