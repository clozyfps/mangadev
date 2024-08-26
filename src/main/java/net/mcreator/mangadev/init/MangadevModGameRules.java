
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mangadev.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MangadevModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> FAN_CHAT_OUTPUT = GameRules.register("fanChatOutput", GameRules.Category.CHAT, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> TWEET_CHAT_OUTPUT = GameRules.register("tweetChatOutput", GameRules.Category.CHAT, GameRules.BooleanValue.create(true));
}
