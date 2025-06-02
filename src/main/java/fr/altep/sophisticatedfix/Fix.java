package fr.altep.sophisticatedfix;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.Tags;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Fix.MODID)
public class Fix {
    public static final String MODID = "sophisticatedfix";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Fix(IEventBus modEventBus, ModContainer modContainer) {

    }
}
