package fenitride.chemicallaboratory;

import org.apache.logging.log4j.Logger;

import fenitride.chemicallaboratory.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ChemicalLaboratory.MODID, name = ChemicalLaboratory.NAME, version = ChemicalLaboratory.VERSION)
public class ChemicalLaboratory {
    public static final String MODID = "chemical_laboratory";
    public static final String NAME = "Chemical Laboratory";
    public static final String VERSION = "0.1.0";

    public static Logger logger;

    @SidedProxy(clientSide = "fenitride.chemicallaboratory.proxy.ClientProxy", serverSide = "fenitride.chemicallaboratory.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Instance(ChemicalLaboratory.MODID)
    public static ChemicalLaboratory chemicalLaboratory;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("ChemicalLaboratory.preInit was called.");
        proxy.registerPre();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.register();
    }
}
