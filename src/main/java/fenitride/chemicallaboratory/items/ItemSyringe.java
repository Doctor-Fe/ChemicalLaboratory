package fenitride.chemicallaboratory.items;

import java.util.List;

import javax.annotation.Nullable;

import fenitride.chemicallaboratory.ChemicalLaboratory;
import fenitride.chemicallaboratory.lists.Items;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSyringe extends Item {
    public ItemSyringe() {
        this.setRegistryName(ChemicalLaboratory.MODID, "syringe");
        this.setUnlocalizedName("syringe");
        this.setMaxStackSize(16);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity instanceof EntityLivingBase) {
            applyAllEffectTo(stack, player, (EntityLivingBase)entity);
        }
        return false;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        return applyAllEffectTo(stack, entityLiving, entityLiving);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 16;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.NONE;
    }

    public ItemStack applyAllEffectTo(ItemStack stack, EntityLivingBase source, EntityLivingBase target) {
        if (!target.world.isRemote) {
            List<PotionEffect> effects = PotionUtils.getEffectsFromStack(stack);
            for (PotionEffect effect: effects) {
                if (effect.getPotion().isInstant()) {
                    effect.getPotion().affectEntity(source, source, target, effect.getAmplifier(), 1.0D);
                } else {
                    target.addPotionEffect(new PotionEffect(effect));
                }
            }
            if (source instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer)source;
                if (!player.capabilities.isCreativeMode) {
                    stack.shrink(1);
                    player.addItemStackToInventory(new ItemStack(Items.EMPTY_SYRINGE, 1));
                }
            }
        }
        return stack;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        PotionUtils.addPotionTooltip(stack, tooltip, 1.0f);
    }
}
