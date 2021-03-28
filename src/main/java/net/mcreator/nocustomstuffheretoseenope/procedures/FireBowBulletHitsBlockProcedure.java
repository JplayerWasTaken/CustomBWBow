package net.mcreator.nocustomstuffheretoseenope.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.nocustomstuffheretoseenope.NocustomstuffheretoseenopeModElements;
import net.mcreator.nocustomstuffheretoseenope.NocustomstuffheretoseenopeMod;

import java.util.Map;

@NocustomstuffheretoseenopeModElements.ModElement.Tag
public class FireBowBulletHitsBlockProcedure extends NocustomstuffheretoseenopeModElements.ModElement {
	public FireBowBulletHitsBlockProcedure(NocustomstuffheretoseenopeModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NocustomstuffheretoseenopeMod.LOGGER.warn("Failed to load dependency x for procedure FireBowBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NocustomstuffheretoseenopeMod.LOGGER.warn("Failed to load dependency y for procedure FireBowBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NocustomstuffheretoseenopeMod.LOGGER.warn("Failed to load dependency z for procedure FireBowBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NocustomstuffheretoseenopeMod.LOGGER.warn("Failed to load dependency world for procedure FireBowBulletHitsBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.1)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.LAVA.getDefaultState(), 3);
		}
	}
}
