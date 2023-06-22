package fenitride.chemicallaboratory.potions;

import fenitride.chemicallaboratory.ChemicalLaboratory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class PotionPurification extends Potion {

    public PotionPurification() {
        super(false, 0xf0f080);
        setRegistryName(ChemicalLaboratory.MODID, "purification");
        setPotionName("effect.purification");
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 15 == 0;
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        if (entityLivingBaseIn.isEntityUndead())
            entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 1.0f * Math.min(5, amplifier + 1));
    }
}
