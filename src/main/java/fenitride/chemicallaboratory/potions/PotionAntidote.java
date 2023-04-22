package fenitride.chemicallaboratory.potions;

import java.util.ArrayList;

import fenitride.chemicallaboratory.ChemicalLaboratory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class PotionAntidote extends Potion {
    public PotionAntidote() {
        super(false, 0xffdc80); // FIXME ポーションの色が反映されない
        setRegistryName(ChemicalLaboratory.MODID, "antidote");
        setPotionName("effect.antidote");
    }

    @Override
    public boolean shouldRender(PotionEffect effect) {
        return false;
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        ArrayList<PotionEffect> tmp = new ArrayList<PotionEffect>();
        for (PotionEffect potion: entityLivingBaseIn.getActivePotionEffects()) {
            if (potion.getPotion().isBadEffect()) {
                tmp.add(new PotionEffect(potion.getPotion(), Math.max(potion.getDuration() - 20 * (amplifier + 1), 0), potion.getAmplifier(), potion.getIsAmbient(), potion.doesShowParticles()));
            }
        }
        for (PotionEffect potion: tmp) {
            if (potion.getDuration() > 0) {
                entityLivingBaseIn.removeActivePotionEffect(potion.getPotion());
                entityLivingBaseIn.addPotionEffect(potion);
            } else {
                entityLivingBaseIn.removePotionEffect(potion.getPotion());
            }
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 3 == 0;
    }
}
