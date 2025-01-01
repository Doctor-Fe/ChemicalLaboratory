package fenitride.chemicallaboratory.brewing;

import java.util.HashMap;

import net.minecraft.potion.PotionEffect;

public abstract class BrewingModifier {
    /** 効果を適用した後のエフェクト効果
     * @param effects エフェクト効果のリストです。このリストを書き換えます。
     * @param time 過去に同じ効果を適用した回数です。
     */
    public abstract void apply(HashMap<String, PotionEffect> effects, int time);
}
