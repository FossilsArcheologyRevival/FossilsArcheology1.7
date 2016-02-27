package com.github.revival.client.renderer.entity;

import com.github.revival.server.entity.mob.QuaggaEntity;
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Map;

@SideOnly(Side.CLIENT)
public class QuaggaRenderer extends RenderLiving {
    private static final Map field_110852_a = Maps.newHashMap();
    private static final ResourceLocation quaggaTexture = new ResourceLocation("fossil:textures/model/quagga_0/quagga.png");

    public QuaggaRenderer(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2);
    }

    protected void scale(QuaggaEntity par1QuaggaEntity, float par2) {
        float f1 = 1.0F;
        GL11.glScalef(f1, f1, f1);
        super.preRenderCallback(par1QuaggaEntity, par2);
    }

    protected void func_110846_a(QuaggaEntity par1QuaggaEntity, float par2, float par3, float par4, float par5, float par6, float par7) {
        if (par1QuaggaEntity.isInvisible()) {
            this.mainModel.setRotationAngles(par2, par3, par4, par5, par6, par7, par1QuaggaEntity);
        } else {
            this.bindEntityTexture(par1QuaggaEntity);
            this.mainModel.render(par1QuaggaEntity, par2, par3, par4, par5, par6, par7);
        }
    }

    protected ResourceLocation func_110849_a(QuaggaEntity par1QuaggaEntity) {
        if (!par1QuaggaEntity.func_110239_cn()) {
            return quaggaTexture;
        }
        return this.func_110848_b(par1QuaggaEntity);
    }

    private ResourceLocation func_110848_b(QuaggaEntity par1EntityHorse) {
        String s = par1EntityHorse.getHorseTexture();
        ResourceLocation resourcelocation = (ResourceLocation) field_110852_a.get(s);

        if (resourcelocation == null) {
            resourcelocation = new ResourceLocation(s);
            Minecraft.getMinecraft().getTextureManager().loadTexture(resourcelocation, new LayeredTexture(par1EntityHorse.getVariantTexturePaths()));
            field_110852_a.put(s, resourcelocation);
        }

        return resourcelocation;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        this.scale((QuaggaEntity) par1EntityLivingBase, par2);
    }

    /**
     * Renders the model in RenderLiving
     */
    protected void renderModel(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.func_110846_a((QuaggaEntity) par1EntityLivingBase, par2, par3, par4, par5, par6, par7);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return this.func_110849_a((QuaggaEntity) par1Entity);
    }
}