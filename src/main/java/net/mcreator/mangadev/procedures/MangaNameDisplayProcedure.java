package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.Entity;

public class MangaNameDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("manganametimer") > 0) {
			return true;
		}
		return false;
	}
}
