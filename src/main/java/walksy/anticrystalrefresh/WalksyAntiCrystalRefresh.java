package walksy.anticrystalrefresh;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class WalksyAntiCrystalRefresh implements ClientModInitializer {

    public static MinecraftClient mc;

    @Override
    public void onInitializeClient() {
        mc = MinecraftClient.getInstance();
    }
}
