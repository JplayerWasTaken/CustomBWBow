package net.mcreator.nocustomstuffheretoseenope.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.nocustomstuffheretoseenope.NocustomstuffheretoseenopeModElements;
import net.mcreator.nocustomstuffheretoseenope.NocustomstuffheretoseenopeMod;

import java.util.Map;

@NocustomstuffheretoseenopeModElements.ModElement.Tag
public class OneShotBowClickProcedure extends NocustomstuffheretoseenopeModElements.ModElement {
	public OneShotBowClickProcedure(NocustomstuffheretoseenopeModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NocustomstuffheretoseenopeMod.LOGGER.warn("Failed to load dependency entity for procedure OneShotBowClick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"give @s nocustomstuffheretoseenope:one_shot_bow");
			}
		}
	}
}
