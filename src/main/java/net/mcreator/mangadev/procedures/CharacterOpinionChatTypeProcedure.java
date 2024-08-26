package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.mangadev.network.MangadevModVariables;

public class CharacterOpinionChatTypeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String randomCharacter = "";
		double random = 0;
		random = Mth.nextInt(RandomSource.create(), 1, 10);
		if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RecentRating == 5) {
			if (random == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " went crazy in the newest chapter")), false);
			} else if (random == 2) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is designed so well")), false);
			} else if (random == 3) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is the greatest character of all time")), false);
			} else if (random == 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ "I have a connection with " + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter)), false);
			} else if (random == 5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] " + "I ship "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " with "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + ", they'd be so good together")), false);
			} else if (random == 6) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " needs more screen time.")), false);
			} else if (random == 7) {
				randomCharacter = (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters))
						.split(" ")[(Mth.nextInt(RandomSource.create(), 0, (int) (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CharacterAmount))];
				if (!(randomCharacter.contains((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter)
						|| randomCharacter.contains((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter)
						|| randomCharacter.contains((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MainEvent))) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
								+ (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters))
										.split(" ")[(Mth.nextInt(RandomSource.create(), 1, (int) (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CharacterAmount))]
								+ "should've been in \u00A7l #" + new java.text.DecimalFormat("#").format((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Chapters))),
								false);
				} else {
					CharacterOpinionChatTypeProcedure.execute(entity);
				}
			} else if (random == 8) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " in \u00A7l #"
							+ new java.text.DecimalFormat("#").format((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Chapters) + " was cooking")), false);
			} else if (random == 9) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] " + "Im in love with "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter)), false);
			} else if (random == 10) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " SUPREMECY")), false);
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RecentRating == 4) {
			if (random == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " went crazy in the newest chapter")), false);
			} else if (random == 2) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is designed so well")), false);
			} else if (random == 3) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is the greatest character of all time")), false);
			} else if (random == 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ "I have a connection with " + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter)), false);
			} else if (random == 5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] " + "I ship "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " with "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + ", they'd be so good together")), false);
			} else if (random == 6) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " needs more screen time.")), false);
			} else if (random == 7) {
				randomCharacter = (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters))
						.split(" ")[(Mth.nextInt(RandomSource.create(), 0, (int) (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CharacterAmount))];
				if (!(randomCharacter.contains((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter)
						|| randomCharacter.contains((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter)
						|| randomCharacter.contains((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MainEvent))) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
								+ (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters))
										.split(" ")[(Mth.nextInt(RandomSource.create(), 0, (int) (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CharacterAmount))]
								+ "should've been in \u00A7l #" + new java.text.DecimalFormat("#").format((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Chapters))),
								false);
				} else {
					CharacterOpinionChatTypeProcedure.execute(entity);
				}
			} else if (random == 8) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " in \u00A7l #"
							+ new java.text.DecimalFormat("#").format((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Chapters) + " was cooking")), false);
			} else if (random == 9) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] " + "Im in love with "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter)), false);
			} else if (random == 10) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " SUPREMACY")), false);
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RecentRating == 3) {
			if (random == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " was cool in the latest chapter")), false);
			} else if (random == 2) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is cool ig")), false);
			} else if (random == 3) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + "'s appearance was nice")), false);
			} else if (random == 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + "'s personality is soothing")), false);
			} else if (random == 5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is so me")), false);
			} else if (random == 6) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " is so sick")), false);
			} else if (random == 7) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] #"
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + "thegoat")), false);
			} else if (random == 8) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] #"
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + "supremacy")), false);
			} else if (random == 9) {
				randomCharacter = (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters))
						.split(" ")[(Mth.nextInt(RandomSource.create(), 0, (int) (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CharacterAmount))];
				if (!(randomCharacter.contains((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter)
						|| randomCharacter.contains((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter)
						|| randomCharacter.contains((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MainEvent))) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] where was "
								+ (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters))
										.split(" ")[(Mth.nextInt(RandomSource.create(), 0, (int) (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CharacterAmount))]
								+ " at in the latest chapter??!")), false);
				} else {
					CharacterOpinionChatTypeProcedure.execute(entity);
				}
			} else if (random == 10) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] I need more of "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter)), false);
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RecentRating == 2) {
			if (random == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " was kinda annoying")), false);
			} else if (random == 2) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is weird im ngl")), false);
			} else if (random == 3) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is someone i dont wanna be around")), false);
			} else if (random == 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " needs a better design")), false);
			} else if (random == 5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is a alright character ig")), false);
			} else if (random == 6) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " needs to stay a side character lol")), false);
			} else if (random == 7) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " is fine how they are")), false);
			} else if (random == 8) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " kinda gets on my nerves")), false);
			} else if (random == 9) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " is getting annoying, im sure it'll get better though")), false);
			} else if (random == 10) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " was aight ig...")), false);
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RecentRating == 1) {
			if (random == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is so annoying bro holy")), false);
			} else if (random == 2) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " needs to actually jump")), false);
			} else if (random == 3) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] I hope "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " dies next chapter")), false);
			} else if (random == 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is so irritating dawg")), false);
			} else if (random == 5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FocusedCharacter + " is so stupid")), false);
			} else if (random == 6) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " genuinely needs mental help")), false);
			} else if (random == 7) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] GOD "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " is stupid")), false);
			} else if (random == 8) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " makes me mad internally")), false);
			} else if (random == 9) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] hoping "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " dies")), false);
			} else if (random == 10) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A79[@" + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RandomUser + "] "
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SideCharacter + " is just useless")), false);
			}
		}
	}
}
