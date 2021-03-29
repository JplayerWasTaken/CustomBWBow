package net.mcreator.nocustomstuffheretoseenope.procedures;

@NocustomstuffheretoseenopeModElements.ModElement.Tag
public class TNTBowBulletHitsBlockProcedure extends NocustomstuffheretoseenopeModElements.ModElement {

	public TNTBowBulletHitsBlockProcedure(NocustomstuffheretoseenopeModElements instance) {
		super(instance, 14);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NocustomstuffheretoseenopeMod.LOGGER.warn("Failed to load dependency x for procedure TNTBowBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NocustomstuffheretoseenopeMod.LOGGER.warn("Failed to load dependency y for procedure TNTBowBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NocustomstuffheretoseenopeMod.LOGGER.warn("Failed to load dependency z for procedure TNTBowBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NocustomstuffheretoseenopeMod.LOGGER.warn("Failed to load dependency world for procedure TNTBowBulletHitsBlock!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new TNTEntity(EntityType.TNT, (World) world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);

			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

			world.addEntity(entityToSpawn);
		}

	}

}
