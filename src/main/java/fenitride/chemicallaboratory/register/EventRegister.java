package fenitride.chemicallaboratory.register;

import fenitride.chemicallaboratory.events.EventEntity;
import net.minecraftforge.common.MinecraftForge;

public class EventRegister {
    public static void register() {
        MinecraftForge.EVENT_BUS.register(new EventEntity());
    }
}