package fenitride.chemicallaboratory.events;

import fenitride.chemicallaboratory.lists.Potions;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.PotionEvent.PotionRemoveEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventEntity {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPotionRemoved(PotionRemoveEvent event) {
        EntityLivingBase base = event.getEntityLiving();
        PotionEffect effect = base.getActivePotionEffect(Potions.ANTIDOTE);
        if (base.getActiveItemStack().getItem() == Items.MILK_BUCKET &&
            (effect == null || !Potions.ANTIDOTE.isReady(effect.getDuration(), effect.getAmplifier())))
        {
            event.setCanceled(true);
        }
    }
}
