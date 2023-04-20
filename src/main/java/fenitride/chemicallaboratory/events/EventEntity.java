package fenitride.chemicallaboratory.events;

import net.minecraft.init.Items;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.PotionEvent.PotionRemoveEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventEntity {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPotionRemoved(PotionRemoveEvent event) {
        if (event.getEntityLiving().getActiveItemStack().getItem() == Items.MILK_BUCKET) {
            PotionEffect effect = event.getPotionEffect();
            if (effect != null) {
                int duration = effect.getDuration();
                effect = new PotionEffect(effect.getPotion(), duration < 600 ? 0 : duration - 600, effect.getAmplifier(), effect.getIsAmbient(), effect.doesShowParticles());
                event.setCanceled(true);
            }
        }
    }
}
