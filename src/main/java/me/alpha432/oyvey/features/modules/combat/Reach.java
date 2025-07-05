package me.alpha432.oyvey.features.modules.combat;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.setting.Setting;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.client.MinecraftClient;

public class ReachExtender extends Module {
    public Setting<Double> reach = this.register(new Setting<>("Reach", 4.5, 3.0, 10.0));

    public ReachExtender() {
        super("ReachExtender", "Цохилтын хүрээг өргөтгөнө.", Category.COMBAT, true, false, false);
    }

    // Call this method when calculating attack reach, example in attack logic
    public double getReach() {
        return reach.getValue();
    }
    
    // Example usage: replace vanilla reach check in your attack handling with this method
    public boolean canReachEntity(PlayerEntity player, PlayerEntity target) {
        double distSq = player.squaredDistanceTo(target);
        double maxReach = getReach();
        return distSq <= maxReach * maxReach;
    }
}
