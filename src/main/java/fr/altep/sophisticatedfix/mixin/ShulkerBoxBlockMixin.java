package fr.altep.sophisticatedfix.mixin;


import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import net.p3pp3rf1y.sophisticatedstorage.block.ShulkerBoxBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ShulkerBoxBlock.class)
public class ShulkerBoxBlockMixin {

    @Inject(method = "addCreativeTabItems", at = @At("HEAD"), cancellable = true)
    private void addCreativeTabItemsFix(Consumer<ItemStack> itemConsumer, CallbackInfo ci) {

        itemConsumer.accept(new ItemStack((Block)(Object)this));


        ci.cancel();
    }
}
