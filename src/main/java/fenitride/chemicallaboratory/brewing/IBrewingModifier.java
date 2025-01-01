package fenitride.chemicallaboratory.brewing;

import java.util.HashMap;

import net.minecraft.potion.PotionEffect;

/**
 * この Mod で実装される醸造レシピであることを示すインターフェース
 */
public interface IBrewingModifier {
    /** 効果を適用した後のエフェクト効果
     * @param effects エフェクト効果のリストです。このリストを書き換えます。
     * @param time 過去に同じ効果を適用した回数です。
     */
    public abstract void apply(HashMap<String, PotionEffect> effects, int time);
}
