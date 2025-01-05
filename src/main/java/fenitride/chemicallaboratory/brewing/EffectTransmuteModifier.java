package fenitride.chemicallaboratory.brewing;

import java.util.HashMap;
package fenitride.chemicallaboratory.brewing;

import java.util.HashMap;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EffectTransmuteModifier implements IBrewingModifier {
    
    public final Potion FROM;
    public final Potion TO;
    public final float DURATION_MULTIPLIER;

    public EffectTransmuteModifier(Potion from, Potion to, float durationMultiplier) {
        this.FROM = from;
        this.TO = to;
        this.DURATION_MULTIPLIER = durationMultiplier;
    }

    @Override
    public void apply(HashMap<String, PotionEffect> effects, int time) {
        PotionEffect from_effect = effects.get(FROM.getName());
        if (from_effect == null) {
            return;
        }
        PotionEffect to_effect = effects.get(TO.getName());
        if (to_effect == null) {
            effects.remove(FROM.getName());
            int new_duration = (int)(from_effect.getDuration() * this.DURATION_MULTIPLIER);
            if (new_duration > 0) {
                effects.put(TO.getName(), new PotionEffect(TO, new_duration, from_effect.getAmplifier(), from_effect.getIsAmbient(), from_effect.doesShowParticles()));
            }
        }
    }
}
