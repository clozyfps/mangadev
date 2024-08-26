package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.Entity;

public class TypeWarningDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getDouble("typetimer") > 0) {
			return "\u00A7l2 or more types selected!";
		}
		return "\u00A7lType";
	}
}
