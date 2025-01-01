package fenitride.chemicallaboratory.brewing;

import java.util.HashMap;

import net.minecraft.potion.PotionEffect;

public class EffectAddModifier implements IBrewingModifier {

    public final String EFFECT_ID;
    public final PotionEffect EFFECT;

    public EffectAddModifier(PotionEffect effect) {
        this.EFFECT = effect;
        this.EFFECT_ID = effect.getEffectName();
    }

    @Override
    public void apply(HashMap<String, PotionEffect> effects, int time) {
        if (time == 0) {
            PotionEffect e = effects.get(EFFECT.getEffectName());
            if (e == null) {
                effects.put(EFFECT_ID, EFFECT);
            } else {
                e.getDuration();
            }
        }
    }
    
}
