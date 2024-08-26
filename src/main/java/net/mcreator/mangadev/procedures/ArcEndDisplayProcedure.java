package net.mcreator.mangadev.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ArcEndDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("arcendbadtimer") > 0) {
			return true;
		}
		return false;
	}
}
