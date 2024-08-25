package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.mangadev.network.MangadevModVariables;

import java.util.HashMap;

public class CreateCharacterProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!(guistate.containsKey("text:CharacterName") ? ((EditBox) guistate.get("text:CharacterName")).getValue() : "").isEmpty()) {
			entity.getPersistentData().putDouble("characternametimer", 20);
			{
				String _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters + " "
						+ (guistate.containsKey("text:CharacterName") ? ((EditBox) guistate.get("text:CharacterName")).getValue() : "");
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Characters = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters)), false);
		} else if ((guistate.containsKey("text:CharacterName") ? ((EditBox) guistate.get("text:CharacterName")).getValue() : "").isEmpty()) {
			entity.getPersistentData().putDouble("characternamebadtimer", 20);
		}
	}
}
