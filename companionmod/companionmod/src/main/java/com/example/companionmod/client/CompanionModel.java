package com.example.companionmod.client;

import com.example.companionmod.CompanionMod;
import com.example.companionmod.entity.CompanionEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CompanionModel extends GeoModel<CompanionEntity> {
    @Override
    public ResourceLocation getModelResource(CompanionEntity entity) {
        return new ResourceLocation(CompanionMod.MOD_ID, "geo/companion.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CompanionEntity entity) {
        return new ResourceLocation(CompanionMod.MOD_ID, "textures/entity/companion.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CompanionEntity entity) {
        return new ResourceLocation(CompanionMod.MOD_ID, "animations/companion.animation.json");
    }
}
