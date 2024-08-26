package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.Entity;

public class GenreWarningDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getDouble("genretimer") > 0) {
			return "\u00A7l2 or more genres selected!";
		}
		return "\u00A7lMain Genre";
	}
}
