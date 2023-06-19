package fenitride.chemicallaboratory.events;

import java.util.Optional;

import fenitride.chemicallaboratory.lists.Potions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.PotionEvent.PotionAddedEvent;
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

    @SubscribeEvent
    public void onPotionAdded(PotionAddedEvent event) {
        EntityLivingBase base = event.getEntityLiving();
        PotionEffect effect = event.getPotionEffect();
        Potion potion = effect.getPotion();
        if (potion == Potions.PURIFICATION && base.isEntityUndead()) {
            base.addPotionEffect(new PotionEffect(Potion.getPotionById(18), effect.getDuration(), effect.getAmplifier(), false, false));
        }
    }

    @SubscribeEvent
    public void onEntityHurt(LivingHurtEvent event) {
        Optional<Entity> source = Optional.ofNullable(event.getSource().getTrueSource());
        if (event.getEntityLiving().isEntityUndead() && source.isPresent() && source.get() instanceof EntityLivingBase) {
            EntityLivingBase base = (EntityLivingBase)source.get();
            Optional<PotionEffect> effect = Optional.ofNullable(base.getActivePotionEffect(Potions.PURIFICATION));
            if (effect.isPresent()) {
                event.setAmount(event.getAmount() + 2.0f * (effect.get().getAmplifier() + 1));
            }
        }
    }
}
