package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.Entity;

public class ArcNameCreationDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("arcnametimer") > 0) {
			return true;
		}
		return false;
	}
}
