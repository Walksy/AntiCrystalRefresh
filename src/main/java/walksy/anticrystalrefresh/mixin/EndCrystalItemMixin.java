package walksy.anticrystalrefresh.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.EndCrystalItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static walksy.anticrystalrefresh.WalksyAntiCrystalRefresh.mc;


@Mixin({EndCrystalItem.class})
public class EndCrystalItemMixin {

    @Inject(method = {"useOnBlock"}, at = {@At("HEAD")}, cancellable = true)
    private void modifyDecrementAmount(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (mc.isInSingleplayer()) {
            return;
        }

        if (this.canPlaceCrystalServer(context.getBlockPos())) {
            context.getStack().decrement(-1);
        }
    }

    @Unique
    private boolean canPlaceCrystalServer(BlockPos block) {
        BlockState blockState = mc.world.getBlockState(block);
        if (!blockState.isOf(Blocks.OBSIDIAN) && !blockState.isOf(Blocks.BEDROCK)) {
            return false;
        }
        BlockPos blockPos2 = block.up();
        if (!mc.world.isAir(blockPos2)) {
            return false;
        }
        double d = blockPos2.getX();
        double e = blockPos2.getY();
        double f = blockPos2.getZ();
        List<Entity> list = mc.world.getOtherEntities((Entity)null, new Box(d, e, f, d + 1.0D, e + 2.0D, f + 1.0D));
        return list.isEmpty();
    }
}
