package walksy.anticrystalrefresh;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class WalksyAntiCrystalRefresh implements ClientModInitializer {

    /**
     * Walksy is wishing he had this when DrDonutt banned him. D:
     */

    public static MinecraftClient mc;

    @Override
    public void onInitializeClient() {
        mc = MinecraftClient.getInstance();
    }
}
