package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.mangadev.network.MangadevModVariables;

import java.util.HashMap;

public class CreateCharacterProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!(guistate.containsKey("text:CharacterName") ? ((EditBox) guistate.get("text:CharacterName")).getValue() : "").isEmpty()) {
			if (guistate.containsKey("checkbox:Hero") && ((Checkbox) guistate.get("checkbox:Hero")).selected()
					&& !(guistate.containsKey("checkbox:Neutral") && ((Checkbox) guistate.get("checkbox:Neutral")).selected() || guistate.containsKey("checkbox:Villain") && ((Checkbox) guistate.get("checkbox:Villain")).selected())) {
				{
					String _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).HeroCharacters + " "
							+ (guistate.containsKey("text:CharacterName") ? ((EditBox) guistate.get("text:CharacterName")).getValue() : "");
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HeroCharacters = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:Neutral") && ((Checkbox) guistate.get("checkbox:Neutral")).selected()
					&& !(guistate.containsKey("checkbox:Hero") && ((Checkbox) guistate.get("checkbox:Hero")).selected() || guistate.containsKey("checkbox:Villain") && ((Checkbox) guistate.get("checkbox:Villain")).selected())) {
				{
					String _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).NeutralCharacters + " "
							+ (guistate.containsKey("text:CharacterName") ? ((EditBox) guistate.get("text:CharacterName")).getValue() : "");
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NeutralCharacters = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:Villain") && ((Checkbox) guistate.get("checkbox:Villain")).selected()
					&& !(guistate.containsKey("checkbox:Neutral") && ((Checkbox) guistate.get("checkbox:Neutral")).selected() || guistate.containsKey("checkbox:Hero") && ((Checkbox) guistate.get("checkbox:Hero")).selected())) {
				{
					String _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).VillainCharacters + " "
							+ (guistate.containsKey("text:CharacterName") ? ((EditBox) guistate.get("text:CharacterName")).getValue() : "");
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.VillainCharacters = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			entity.getPersistentData().putDouble("characternametimer", 20);
			{
				String _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters + " "
						+ (guistate.containsKey("text:CharacterName") ? ((EditBox) guistate.get("text:CharacterName")).getValue() : "");
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Characters = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CharacterAmount + 1;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CharacterAmount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Characters: " + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters)), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Hero Characters: " + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).HeroCharacters)), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Neutral Characters: " + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).NeutralCharacters)), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Villain Characters: " + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).VillainCharacters)), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Dead Characters: " + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).DeadCharacters)), false);
		} else if ((guistate.containsKey("text:CharacterName") ? ((EditBox) guistate.get("text:CharacterName")).getValue() : "").isEmpty()) {
			entity.getPersistentData().putDouble("characternamebadtimer", 20);
		}
	}
}
