package net.mcreator.mangadev.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.mangadev.MangadevMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MangadevModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MangadevMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Fans = original.Fans;
			clone.Chapters = original.Chapters;
			clone.Yen = original.Yen;
			clone.RecentChapter = original.RecentChapter;
			clone.RecentRating = original.RecentRating;
			clone.RecentChapterViews = original.RecentChapterViews;
			clone.RecentChapterFans = original.RecentChapterFans;
			clone.MangaGenre = original.MangaGenre;
			clone.MangaName = original.MangaName;
			clone.Characters = original.Characters;
			clone.FocusedCharacter = original.FocusedCharacter;
			clone.SideCharacter = original.SideCharacter;
			clone.MainEvent = original.MainEvent;
			clone.PopularityGeneration = original.PopularityGeneration;
			clone.PopularityAuto = original.PopularityAuto;
			clone.DiscoveryRate = original.DiscoveryRate;
			clone.RecentTweet = original.RecentTweet;
			clone.RandomUser = original.RandomUser;
			clone.CharacterAmount = original.CharacterAmount;
			clone.HeroCharacters = original.HeroCharacters;
			clone.VillainCharacters = original.VillainCharacters;
			clone.NeutralCharacters = original.NeutralCharacters;
			clone.DeadCharacters = original.DeadCharacters;
			clone.ShortMangaName = original.ShortMangaName;
			clone.CurrentArc = original.CurrentArc;
			clone.ArcRating = original.ArcRating;
			clone.MangaType = original.MangaType;
			clone.ArcEndChapter = original.ArcEndChapter;
			clone.CurrentArcChapters = original.CurrentArcChapters;
			clone.FifthLetterRandomizer = original.FifthLetterRandomizer;
			clone.FourthLetterRandomizer = original.FourthLetterRandomizer;
			clone.ThirdLetterRandomizer = original.ThirdLetterRandomizer;
			clone.StarterLetterRandomizer = original.StarterLetterRandomizer;
			clone.SixthLetterRandomizer = original.SixthLetterRandomizer;
			clone.SecondLetterRandomizer = original.SecondLetterRandomizer;
			if (!event.isWasDeath()) {
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("mangadev", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double Fans = 0;
		public double Chapters = 0;
		public double Yen = 0;
		public String RecentChapter = "";
		public double RecentRating = 0;
		public double RecentChapterViews = 0;
		public double RecentChapterFans = 0;
		public String MangaGenre = "";
		public String MangaName = "";
		public String Characters = "";
		public String FocusedCharacter = "";
		public String SideCharacter = "";
		public String MainEvent = "";
		public double PopularityGeneration = 0;
		public double PopularityAuto = 0;
		public double DiscoveryRate = 0;
		public String RecentTweet = "";
		public String RandomUser = "";
		public double CharacterAmount = 0;
		public String HeroCharacters = "";
		public String VillainCharacters = "";
		public String NeutralCharacters = "";
		public String DeadCharacters = "";
		public String ShortMangaName = "";
		public String CurrentArc = "";
		public double ArcRating = 0.0;
		public String MangaType = "\"\"";
		public boolean ArcEndChapter = false;
		public double CurrentArcChapters = 0;
		public String FifthLetterRandomizer = "";
		public String FourthLetterRandomizer = "";
		public String ThirdLetterRandomizer = "";
		public String StarterLetterRandomizer = "";
		public String SixthLetterRandomizer = "0";
		public String SecondLetterRandomizer = "\"\"";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				MangadevMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Fans", Fans);
			nbt.putDouble("Chapters", Chapters);
			nbt.putDouble("Yen", Yen);
			nbt.putString("RecentChapter", RecentChapter);
			nbt.putDouble("RecentRating", RecentRating);
			nbt.putDouble("RecentChapterViews", RecentChapterViews);
			nbt.putDouble("RecentChapterFans", RecentChapterFans);
			nbt.putString("MangaGenre", MangaGenre);
			nbt.putString("MangaName", MangaName);
			nbt.putString("Characters", Characters);
			nbt.putString("FocusedCharacter", FocusedCharacter);
			nbt.putString("SideCharacter", SideCharacter);
			nbt.putString("MainEvent", MainEvent);
			nbt.putDouble("PopularityGeneration", PopularityGeneration);
			nbt.putDouble("PopularityAuto", PopularityAuto);
			nbt.putDouble("DiscoveryRate", DiscoveryRate);
			nbt.putString("RecentTweet", RecentTweet);
			nbt.putString("RandomUser", RandomUser);
			nbt.putDouble("CharacterAmount", CharacterAmount);
			nbt.putString("HeroCharacters", HeroCharacters);
			nbt.putString("VillainCharacters", VillainCharacters);
			nbt.putString("NeutralCharacters", NeutralCharacters);
			nbt.putString("DeadCharacters", DeadCharacters);
			nbt.putString("ShortMangaName", ShortMangaName);
			nbt.putString("CurrentArc", CurrentArc);
			nbt.putDouble("ArcRating", ArcRating);
			nbt.putString("MangaType", MangaType);
			nbt.putBoolean("ArcEndChapter", ArcEndChapter);
			nbt.putDouble("CurrentArcChapters", CurrentArcChapters);
			nbt.putString("FifthLetterRandomizer", FifthLetterRandomizer);
			nbt.putString("FourthLetterRandomizer", FourthLetterRandomizer);
			nbt.putString("ThirdLetterRandomizer", ThirdLetterRandomizer);
			nbt.putString("StarterLetterRandomizer", StarterLetterRandomizer);
			nbt.putString("SixthLetterRandomizer", SixthLetterRandomizer);
			nbt.putString("SecondLetterRandomizer", SecondLetterRandomizer);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Fans = nbt.getDouble("Fans");
			Chapters = nbt.getDouble("Chapters");
			Yen = nbt.getDouble("Yen");
			RecentChapter = nbt.getString("RecentChapter");
			RecentRating = nbt.getDouble("RecentRating");
			RecentChapterViews = nbt.getDouble("RecentChapterViews");
			RecentChapterFans = nbt.getDouble("RecentChapterFans");
			MangaGenre = nbt.getString("MangaGenre");
			MangaName = nbt.getString("MangaName");
			Characters = nbt.getString("Characters");
			FocusedCharacter = nbt.getString("FocusedCharacter");
			SideCharacter = nbt.getString("SideCharacter");
			MainEvent = nbt.getString("MainEvent");
			PopularityGeneration = nbt.getDouble("PopularityGeneration");
			PopularityAuto = nbt.getDouble("PopularityAuto");
			DiscoveryRate = nbt.getDouble("DiscoveryRate");
			RecentTweet = nbt.getString("RecentTweet");
			RandomUser = nbt.getString("RandomUser");
			CharacterAmount = nbt.getDouble("CharacterAmount");
			HeroCharacters = nbt.getString("HeroCharacters");
			VillainCharacters = nbt.getString("VillainCharacters");
			NeutralCharacters = nbt.getString("NeutralCharacters");
			DeadCharacters = nbt.getString("DeadCharacters");
			ShortMangaName = nbt.getString("ShortMangaName");
			CurrentArc = nbt.getString("CurrentArc");
			ArcRating = nbt.getDouble("ArcRating");
			MangaType = nbt.getString("MangaType");
			ArcEndChapter = nbt.getBoolean("ArcEndChapter");
			CurrentArcChapters = nbt.getDouble("CurrentArcChapters");
			FifthLetterRandomizer = nbt.getString("FifthLetterRandomizer");
			FourthLetterRandomizer = nbt.getString("FourthLetterRandomizer");
			ThirdLetterRandomizer = nbt.getString("ThirdLetterRandomizer");
			StarterLetterRandomizer = nbt.getString("StarterLetterRandomizer");
			SixthLetterRandomizer = nbt.getString("SixthLetterRandomizer");
			SecondLetterRandomizer = nbt.getString("SecondLetterRandomizer");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MangadevMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	public static class PlayerVariablesSyncMessage {
		private final int target;
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
			this.target = buffer.readInt();
		}

		public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
			this.data = data;
			this.target = entityid;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
			buffer.writeInt(message.target);
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.level().getEntity(message.target).getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Fans = message.data.Fans;
					variables.Chapters = message.data.Chapters;
					variables.Yen = message.data.Yen;
					variables.RecentChapter = message.data.RecentChapter;
					variables.RecentRating = message.data.RecentRating;
					variables.RecentChapterViews = message.data.RecentChapterViews;
					variables.RecentChapterFans = message.data.RecentChapterFans;
					variables.MangaGenre = message.data.MangaGenre;
					variables.MangaName = message.data.MangaName;
					variables.Characters = message.data.Characters;
					variables.FocusedCharacter = message.data.FocusedCharacter;
					variables.SideCharacter = message.data.SideCharacter;
					variables.MainEvent = message.data.MainEvent;
					variables.PopularityGeneration = message.data.PopularityGeneration;
					variables.PopularityAuto = message.data.PopularityAuto;
					variables.DiscoveryRate = message.data.DiscoveryRate;
					variables.RecentTweet = message.data.RecentTweet;
					variables.RandomUser = message.data.RandomUser;
					variables.CharacterAmount = message.data.CharacterAmount;
					variables.HeroCharacters = message.data.HeroCharacters;
					variables.VillainCharacters = message.data.VillainCharacters;
					variables.NeutralCharacters = message.data.NeutralCharacters;
					variables.DeadCharacters = message.data.DeadCharacters;
					variables.ShortMangaName = message.data.ShortMangaName;
					variables.CurrentArc = message.data.CurrentArc;
					variables.ArcRating = message.data.ArcRating;
					variables.MangaType = message.data.MangaType;
					variables.ArcEndChapter = message.data.ArcEndChapter;
					variables.CurrentArcChapters = message.data.CurrentArcChapters;
					variables.FifthLetterRandomizer = message.data.FifthLetterRandomizer;
					variables.FourthLetterRandomizer = message.data.FourthLetterRandomizer;
					variables.ThirdLetterRandomizer = message.data.ThirdLetterRandomizer;
					variables.StarterLetterRandomizer = message.data.StarterLetterRandomizer;
					variables.SixthLetterRandomizer = message.data.SixthLetterRandomizer;
					variables.SecondLetterRandomizer = message.data.SecondLetterRandomizer;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
