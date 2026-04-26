package walksy.anticrystalrefresh.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ItemStack.class})
public abstract class ItemStackMixin {

    @Shadow
    public abstract Item getItem();

    @Inject(method = {"getBobbingAnimationTime"}, at = {@At("HEAD")}, cancellable = true)
    private void reducePlaceDelay(CallbackInfoReturnable<Integer> info) {
        if (this.getItem().equals(Items.END_CRYSTAL)) {
            info.setReturnValue(0);
        }
    }
}
