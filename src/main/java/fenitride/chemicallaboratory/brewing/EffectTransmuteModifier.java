package fenitride.chemicallaboratory.brewing;

import java.util.HashMap;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EffectTransmuteModifier implements IBrewingModifier {
    
    public final String FROM_EFFECT_ID;
    public final Potion TO_EFFECT;
    public final float DURATION_MULTIPLIER;

    public EffectTransmuteModifier(Potion from, Potion to, float durationMultiplier) {
        FROM_EFFECT_ID = from.getName();
        TO_EFFECT = to;
        DURATION_MULTIPLIER = durationMultiplier;
    }

    @Override
    public void apply(HashMap<String, PotionEffect> effects, int time) {
        if (effects.containsKey(FROM_EFFECT_ID)) {
            PotionEffect effect = effects.remove(FROM_EFFECT_ID);
            effects.put(TO_EFFECT.getName(), new PotionEffect(TO_EFFECT, (int)(effect.getDuration() * DURATION_MULTIPLIER), effect.getAmplifier(), effect.getIsAmbient(), true));
        }
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }

    
}
