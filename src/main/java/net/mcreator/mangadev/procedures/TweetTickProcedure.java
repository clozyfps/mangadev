package net.mcreator.mangadev.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class TweetTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double tweettype = 0;
		double randomuser = 0;
		double firstletter = 0;
		double secondletter = 0;
		double thirdletter = 0;
		double fourthletter = 0;
		double fifthletter = 0;
		double sixthletter = 0;
		double beyondThird = 0;
		double beyondFourth = 0;
		double beyondFifth = 0;
		if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 100) {
			if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
					&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("mangadev:it_only_gets_better"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mangadev:it_only_gets_better"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			firstletter = Mth.nextInt(RandomSource.create(), 1, 10);
			secondletter = Mth.nextInt(RandomSource.create(), 1, 7);
			thirdletter = Mth.nextInt(RandomSource.create(), 1, 8);
			fourthletter = Mth.nextInt(RandomSource.create(), 1, 9);
			fifthletter = Mth.nextInt(RandomSource.create(), 1, 9);
			beyondThird = Mth.nextInt(RandomSource.create(), 1, 2);
			if (beyondThird == 2) {
				beyondFourth = Mth.nextInt(RandomSource.create(), 1, 2);
				if (fourthletter == 1) {
					{
						String _setval = "_";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FourthLetterRandomizer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (fourthletter == 2) {
					{
						String _setval = "1";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FourthLetterRandomizer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (fourthletter == 3) {
					{
						String _setval = "2";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FourthLetterRandomizer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (fourthletter == 4) {
					{
						String _setval = "3";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FourthLetterRandomizer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (fourthletter == 5) {
					{
						String _setval = "4";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FourthLetterRandomizer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (fourthletter == 6) {
					{
						String _setval = "6";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FourthLetterRandomizer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (fourthletter == 7) {
					{
						String _setval = "7";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FourthLetterRandomizer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (fourthletter == 8) {
					{
						String _setval = "8";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FourthLetterRandomizer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (fourthletter == 9) {
					{
						String _setval = "9";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FourthLetterRandomizer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (beyondFourth == 2) {
					if (fifthletter == 1) {
						{
							String _setval = "_";
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FifthLetterRandomizer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (fifthletter == 2) {
						{
							String _setval = "1";
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FifthLetterRandomizer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (fifthletter == 3) {
						{
							String _setval = "2";
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FifthLetterRandomizer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (fifthletter == 4) {
						{
							String _setval = "3";
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FifthLetterRandomizer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (fifthletter == 5) {
						{
							String _setval = "4";
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FifthLetterRandomizer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (fifthletter == 6) {
						{
							String _setval = "6";
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FifthLetterRandomizer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (fifthletter == 7) {
						{
							String _setval = "7";
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FifthLetterRandomizer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (fifthletter == 8) {
						{
							String _setval = "8";
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FifthLetterRandomizer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (fifthletter == 9) {
						{
							String _setval = "9";
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FifthLetterRandomizer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if (firstletter == 1) {
				{
					String _setval = "b";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StarterLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (firstletter == 2) {
				{
					String _setval = "f";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StarterLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (firstletter == 3) {
				{
					String _setval = "d";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StarterLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (firstletter == 4) {
				{
					String _setval = "c";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StarterLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (firstletter == 5) {
				{
					String _setval = "n";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StarterLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (firstletter == 6) {
				{
					String _setval = "y";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StarterLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (firstletter == 7) {
				{
					String _setval = "r";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StarterLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (firstletter == 8) {
				{
					String _setval = "v";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StarterLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (secondletter == 1) {
				{
					String _setval = "o";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SecondLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (secondletter == 2) {
				{
					String _setval = "u";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SecondLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (secondletter == 3) {
				{
					String _setval = "i";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SecondLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (secondletter == 4) {
				{
					String _setval = "e";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SecondLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (secondletter == 5) {
				{
					String _setval = "a";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SecondLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (secondletter == 6) {
				{
					String _setval = "_";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SecondLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (secondletter == 7) {
				{
					String _setval = "r";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SecondLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (thirdletter == 1) {
				{
					String _setval = "b";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirdLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (thirdletter == 2) {
				{
					String _setval = "f";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirdLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (thirdletter == 3) {
				{
					String _setval = "d";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirdLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (thirdletter == 4) {
				{
					String _setval = "c";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirdLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (thirdletter == 5) {
				{
					String _setval = "n";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirdLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (thirdletter == 6) {
				{
					String _setval = "y";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirdLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (thirdletter == 7) {
				{
					String _setval = "r";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirdLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (thirdletter == 8) {
				{
					String _setval = "v";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirdLetterRandomizer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (!((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FourthLetterRandomizer).isEmpty()
					&& ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FifthLetterRandomizer).isEmpty()) {
				{
					String _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).StarterLetterRandomizer + ""
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SecondLetterRandomizer
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).ThirdLetterRandomizer
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FourthLetterRandomizer;
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RandomUser = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (!((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FourthLetterRandomizer).isEmpty()
					&& !((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FifthLetterRandomizer).isEmpty()) {
				{
					String _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).StarterLetterRandomizer + ""
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SecondLetterRandomizer
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).ThirdLetterRandomizer
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FourthLetterRandomizer
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FifthLetterRandomizer;
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RandomUser = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FourthLetterRandomizer).isEmpty()
					&& ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).FifthLetterRandomizer).isEmpty()) {
				{
					String _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).StarterLetterRandomizer + ""
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).SecondLetterRandomizer
							+ (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).ThirdLetterRandomizer;
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RandomUser = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (Math.random() < (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RecentChapterViews / 10000) {
				tweettype = Mth.nextInt(RandomSource.create(), 1, 3);
				if (tweettype == 1) {
					OpinionChatTypeProcedure.execute(entity);
				} else if (tweettype == 2) {
					CharacterOpinionChatTypeProcedure.execute(entity);
				} else if (tweettype == 3) {
					MainEventChatTypeProcedure.execute(entity);
				}
			}
		}
	}
}
