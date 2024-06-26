package com.keletu.arcane_arteries.item;

import WayofTime.bloodmagic.BloodMagic;
import WayofTime.bloodmagic.api.impl.BloodMagicAPI;
import WayofTime.bloodmagic.util.DamageSourceBloodMagic;
import WayofTime.bloodmagic.util.helper.PlayerSacrificeHelper;
import WayofTime.bloodmagic.util.helper.PurificationHelper;
import com.keletu.arcane_arteries.ArcaneArteries;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ItemThaumicDaggerOfSacrifice extends Item {
    public ItemThaumicDaggerOfSacrifice() {
        setRegistryName("thaumic_dagger_of_sacrifice");
        setTranslationKey("thaumic_dagger_of_sacrifice");
        setCreativeTab(ArcaneArteries.tabForgottenRelics);

        setMaxStackSize(1);
        setFull3D();
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (attacker instanceof FakePlayer)
            return false;

        if (target == null || attacker == null || attacker.getEntityWorld().isRemote || (attacker instanceof EntityPlayer && !(attacker instanceof EntityPlayerMP)))
            return false;

        if (!target.isNonBoss())
            return false;

        if (target instanceof EntityPlayer)
            return false;

        if (target.isChild() && !(target instanceof IMob))
            return false;

        if (target.isDead || target.getHealth() < 0.5F)
            return false;

        EntityEntry entityEntry = EntityRegistry.getEntry(target.getClass());
        if (entityEntry == null)
            return false;
        int lifeEssenceRatio = BloodMagicAPI.INSTANCE.getValueManager().getSacrificial().getOrDefault(entityEntry.getRegistryName(), 25);

        if (lifeEssenceRatio <= 0)
            return false;

        int lifeEssence = (int) (lifeEssenceRatio * target.getHealth() * 1.25);
        if (target instanceof EntityAnimal) {
            lifeEssence = (int) (lifeEssence * (1.5 + PurificationHelper.getCurrentPurity((EntityAnimal) target)));
        }

        if (target.isChild()) {
            lifeEssence *= 0.5F;
        }

        if (PlayerSacrificeHelper.findAndFillAltar(attacker.getEntityWorld(), target, lifeEssence, true)) {
            target.getEntityWorld().playSound(null, target.posX, target.posY, target.posZ, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (target.getEntityWorld().rand.nextFloat() - target.getEntityWorld().rand.nextFloat()) * 0.8F);
            target.setHealth(-1);
            target.onDeath(DamageSourceBloodMagic.INSTANCE);
        }

        return false;
    }
}