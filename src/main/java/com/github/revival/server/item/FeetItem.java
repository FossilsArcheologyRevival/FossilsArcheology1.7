package com.github.revival.server.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class FeetItem extends ItemArmor {
    public FeetItem(ArmorMaterial par2ArmorMaterial, int par3, int par4) {
        super(par2ArmorMaterial, par3, par4);
        //this.setCreativeTab(Revival.tabFArmor);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:Bone_Boots");
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == FAItemRegistry.skullHelmet || stack.getItem() == FAItemRegistry.ribCage || stack.getItem() == FAItemRegistry.feet) {
            return "fossil:textures/armor/bone_1.png";
        }

        if (stack.getItem() == FAItemRegistry.femurs) {
            return "fossil:textures/armor/bone_2.png";
        }

        return "fossil:textures/armor/bone_2.png";
    }
}