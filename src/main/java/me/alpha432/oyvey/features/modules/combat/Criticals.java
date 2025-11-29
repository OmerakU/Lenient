private LivingEntity lastTarget = null;
private long lastHitTime = 0;
private final long cooldownMs = 500; // 0.5 seconds

@Subscribe
private void onUpdate(UpdateWalkingPlayerEvent event) {
    if (mc.player == null || mc.level == null) return;

    double range = 4.5;
    HitResult result = mc.player.pick(range, 0f, false);

    if (!(result instanceof EntityHitResult ehr)) {
        lastTarget = null;
        return;
    }

    if (!(ehr.getEntity() instanceof LivingEntity target)) {
        lastTarget = null;
        return;
    }

    // cooldown check
    long now = System.currentTimeMillis();
    boolean canAct = (now - lastHitTime) >= cooldownMs;

    if (canAct && target != null) {
        mc.gameMode.attack(target); // actually swings at the entity
        lastHitTime = now;
        lastTarget = target;
}

    }
}

private void doAction(LivingEntity target) {
    // Safe placeholder (particles, sound, log, etc.)
    sendMessage("Action triggered on: " + target.getName().getString());
}
