package user.carboncotton.mc.kiln_only.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import user.carboncotton.mc.kiln_only.KilnOnlyMod;
import user.carboncotton.mc.kiln_only.content.AllObjects;
import user.carboncotton.mc.kiln_only.content.client.KilnFurnaceScreen;

@EventBusSubscriber(modid = KilnOnlyMod.MOD_ID, value = Dist.CLIENT)
public class KilnOnlyNeoForgeClient {
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(AllObjects.getRawKilnMenuType(), KilnFurnaceScreen::new);
    }
}
