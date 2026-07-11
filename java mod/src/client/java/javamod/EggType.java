package javamod;

import java.util.Locale;
import java.util.regex.Pattern;

enum EggType {
	DEFAULT("Default", 1, 1),
	DESERT("Desert", 2, 1),
	CACTUS("Cactus", 3, 1),
	ICE("Ice", 4, 1),
	HELL("Hell", 5, 1),
	HEAVENLY("Heavenly", 6, 1),
	BRAIN_ROT("Brain-Rot", 7, 1),
	DINO("Dino", 1, 2),
	PUMPKIN("Pumpkin", 2, 2),
	WITCH("Witch", 3, 2),
	ROBOT("Robot", 4, 2),
	VOID("Void", 5, 2),
	CORRUPT("Corrupt", 6, 2),
	DRAGON("Dragon", 7, 2),
	ALIEN("Alien", 1, 3),
	AI("AI", 2, 3),
	ANCIENT("Ancient", 3, 3),
	MEDIEVEL("Medieval", 4, 3);

	final String displayName;
	final int slot;
	final int page;
	final Pattern chatNameMatcher;

	EggType(String displayName, int slot, int page) {
		this.displayName = displayName;
		this.slot = slot;
		this.page = page;
		this.chatNameMatcher = buildChatNameMatcher(displayName);
	}

	public boolean isSecondPage(){
		return page == 2;
	}

	public boolean isThirdPage(){
		return page == 3;
	}
	
	private static Pattern buildChatNameMatcher(String displayName) {
		String raw = displayName == null ? "" : displayName;
		String[] tokens = raw.toLowerCase(Locale.ROOT).split("[^a-z0-9]+");

		StringBuilder regex = new StringBuilder("(?i)\\b");
		boolean first = true;
		for (String token : tokens) {
			if (token == null || token.isBlank()) {
				continue;
			}
			if (!first) {
				regex.append("[-\\s_]*");
			}
			regex.append(Pattern.quote(token));
			first = false;
		}
		if (first) {
			regex.append(Pattern.quote(raw.toLowerCase(Locale.ROOT)));
		}
		regex.append("\\b");
		return Pattern.compile(regex.toString());
	}
}

