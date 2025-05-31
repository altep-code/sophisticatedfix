package fr.altep.sophisticatedfix.mixin;


import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.p3pp3rf1y.sophisticatedstorage.block.WoodStorageBlockBase;
import net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks;
import net.p3pp3rf1y.sophisticatedstorage.item.WoodStorageBlockItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(WoodStorageBlockBase.class)
public class WoodStorageBlockBaseMixin {

    @Inject(method = "addCreativeTabItems", at = @At("HEAD"), cancellable = true)
    private void addCreativeTabItemsFix(Consumer<ItemStack> itemConsumer, CallbackInfo ci) {

        itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.SPRUCE));

        if ((WoodStorageBlockBase)(Object)this == ModBlocks.BARREL.get()) {
            itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.OAK));
            itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.BIRCH));
            itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.JUNGLE));
            itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.ACACIA));
            itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.DARK_OAK));
            itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.MANGROVE));
            itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.CHERRY));
            itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.BAMBOO));
            itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.CRIMSON));
            itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack((Block)(Object)this), WoodType.WARPED));
        }


        //if (!Config.CLIENT_SPEC.isLoaded() || Boolean.TRUE.equals(Config.CLIENT.showSingleWoodVariantOnly.get())) {
        //    itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack(this), WoodType.ACACIA));
        //} else {
        //    CUSTOM_TEXTURE_WOOD_TYPES.keySet().forEach(woodType -> itemConsumer.accept(WoodStorageBlockItem.setWoodType(new ItemStack(this), woodType)));
        //}

        //if (isBasicTier() || Boolean.TRUE.equals(!Config.CLIENT_SPEC.isLoaded() || Config.CLIENT.showHigherTierTintedVariants.get())) {
        //    for (DyeColor color : DyeColor.values()) {
        //        ItemStack storageStack = new ItemStack(this);
        //        if (storageStack.getItem() instanceof ITintableBlockItem tintableBlockItem) {
        //            tintableBlockItem.setMainColor(storageStack, color.getTextureDiffuseColor());
        //            tintableBlockItem.setAccentColor(storageStack, color.getTextureDiffuseColor());
        //        }
        //        itemConsumer.accept(storageStack);
        //    }
        //    ItemStack storageStack = new ItemStack(this);
        //    if (storageStack.getItem() instanceof ITintableBlockItem tintableBlockItem) {
        //        tintableBlockItem.setMainColor(storageStack, DyeColor.YELLOW.getTextureDiffuseColor());
        //        tintableBlockItem.setAccentColor(storageStack, DyeColor.LIME.getTextureDiffuseColor());
        //    }
        //    itemConsumer.accept(storageStack);
        //}

        ci.cancel();
    }
}
