package fenitride.chemicallaboratory.proxy;

import fenitride.chemicallaboratory.register.ColorHandlerRegister;
import fenitride.chemicallaboratory.register.ModelRegister;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerPre() {
		super.registerPre();
		ModelRegister.register();
	}

	@Override
	public void register() {
		ColorHandlerRegister.register();
	}
}