package net.mcreator.nocustomstuffheretoseenope.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.nocustomstuffheretoseenope.NocustomstuffheretoseenopeModElements;
import net.mcreator.nocustomstuffheretoseenope.NocustomstuffheretoseenopeMod;

import java.util.Map;

@NocustomstuffheretoseenopeModElements.ModElement.Tag
public class IthasbeendoneProcedure extends NocustomstuffheretoseenopeModElements.ModElement {
	public IthasbeendoneProcedure(NocustomstuffheretoseenopeModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NocustomstuffheretoseenopeMod.LOGGER.warn("Failed to load dependency entity for procedure Ithasbeendone!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"give @a nocustomstuffheretoseenope:a_normal_bow");
			}
		}
	}
}
