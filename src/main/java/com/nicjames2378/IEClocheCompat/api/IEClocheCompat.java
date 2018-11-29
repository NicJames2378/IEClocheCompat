package com.nicjames2378.IEClocheCompat.api;

import blusunrize.immersiveengineering.api.tool.BelljarHandler;
import com.nicjames2378.IEClocheCompat.Main;
import com.nicjames2378.IEClocheCompat.utils.ConversionUtils;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class IEClocheCompat {

    public static boolean registerCrop(ItemStack seed, ItemStack[] output, ItemStack soil, Block crop) {
        try {
            BelljarHandler.cropHandler.register(seed, output, soil, crop.getDefaultState());
            Main.log.info(String.format("Added item '%1$s', with output '%2$s', with soil '%3$s', with crop '%4$s'", seed.getItem().getRegistryName(), ConversionUtils.ItemStackArrayToString(output), soil.getItem().getRegistryName(), crop.getRegistryName()));
            return true;
        } catch (Exception e) {
            Main.log.info(String.format("!!!Error occured adding item '%1$s', with output '%2$s', with soil '%3$s', with crop '%4$s'!!!", seed.getItem().getRegistryName(), ConversionUtils.ItemStackArrayToString(output), soil.getItem().getRegistryName(), crop.getRegistryName()));
            Main.log.error(e);
            Main.log.info("Attempting to continue!");
            return false;
        }
    }

    public static boolean registerCrop(CropFormat newCrop) {
        ItemStack seed = newCrop.getSeed();
        ItemStack[] output = newCrop.getOutputs();
        ItemStack soil = newCrop.getSoil();
        Block crop = newCrop.getCrop();

        return IEClocheCompat.registerCrop(seed, output, soil, crop);
    }

    public static void registerAllCrops(CropFormat[] newCrops) {
        for (CropFormat newCrop : newCrops) {
            registerCrop(newCrop);
        }
    }
}