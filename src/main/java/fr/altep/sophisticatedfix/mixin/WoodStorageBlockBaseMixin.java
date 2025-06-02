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

        ci.cancel();
    }
}
