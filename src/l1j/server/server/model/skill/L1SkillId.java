/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l1j.server.server.model.skill;

public class L1SkillId {
	/** 魔法開頭 */
	public static final int SKILLS_BEGIN = 1;

	/*
	 * Regular Magic Lv1-10
	 */
	/** 法師魔法 (初級治癒術) */
	public static final int HEAL = 1; // E: LESSER_HEAL

	/** 法師魔法 (日光術) */
	public static final int LIGHT = 2;

	/** 法師魔法 (防護罩) */
	public static final int SHIELD = 3;

	/** 法師魔法 (光箭) */
	public static final int ENERGY_BOLT = 4;

	/** 法師魔法 (指定傳送) */
	public static final int TELEPORT = 5;

	/** 法師魔法 (冰箭) */
	public static final int ICE_DAGGER = 6;

	/** 法師魔法 (風刃) */
	public static final int WIND_CUTTER = 7; // E: WIND_SHURIKEN

	/** 法師魔法 (神聖武器) */
	public static final int HOLY_WEAPON = 8;

	/** 法師魔法 (解毒術) */
	public static final int CURE_POISON = 9;

	/** 法師魔法 (寒冷戰慄) */
	public static final int CHILL_TOUCH = 10;

	/** 法師魔法 (毒咒) */
	public static final int CURSE_POISON = 11;

	/** 法師魔法 (擬似魔法武器) */
	public static final int ENCHANT_WEAPON = 12;

	/** 法師魔法 (無所遁形術) */
	public static final int DETECTION = 13;

	/** 法師魔法 (負重強化) */
	public static final int DECREASE_WEIGHT = 14;

	/** 法師魔法 (地獄之牙) */
	public static final int FIRE_ARROW = 15;

	/** 法師魔法 (火箭) */
	public static final int STALAC = 16;

	/** 法師魔法 (極光雷電) */
	public static final int LIGHTNING = 17;

	/** 法師魔法 (起死回生術) */
	public static final int TURN_UNDEAD = 18;

	/** 法師魔法 (中級治癒術) */
	public static final int EXTRA_HEAL = 19; // E: HEAL

	/** 法師魔法 (闇盲咒術) */
	public static final int CURSE_BLIND = 20;

	/** 法師魔法 (鎧甲護持) */
	public static final int BLESSED_ARMOR = 21;

	/** 法師魔法 (寒冰氣息) */
	public static final int FROZEN_CLOUD = 22;

	/** 法師魔法 (能量感測) */
	public static final int WEAK_ELEMENTAL = 23; // E: REVEAL_WEAKNESS

	// none = 24
	/** 法師魔法 (燃燒的火球) */
	public static final int FIREBALL = 25;

	/** 法師魔法 (通暢氣脈術) */
	public static final int PHYSICAL_ENCHANT_DEX = 26; // E: ENCHANT_DEXTERITY

	/** 法師魔法 (壞物術) */
	public static final int WEAPON_BREAK = 27;

	/** 法師魔法 (吸血鬼之吻) */
	public static final int VAMPIRIC_TOUCH = 28;

	/** 法師魔法 (緩速術) */
	public static final int SLOW = 29;

	/** 法師魔法 (岩牢) */
	public static final int EARTH_JAIL = 30;

	/** 法師魔法 (魔法屏障) */
	public static final int COUNTER_MAGIC = 31;

	/** 法師魔法 (冥想術) */
	public static final int MEDITATION = 32;

	/** 法師魔法 (木乃伊的詛咒) */
	public static final int CURSE_PARALYZE = 33;

	/** 法師魔法 (極道落雷) */
	public static final int CALL_LIGHTNING = 34;

	/** 法師魔法 (高級治癒術) */
	public static final int GREATER_HEAL = 35;

	/** 法師魔法 (迷魅術) */
	public static final int TAMING_MONSTER = 36; // E: TAME_MONSTER

	/** 法師魔法 (聖潔之光) */
	public static final int REMOVE_CURSE = 37;

	/** 法師魔法 (冰錐) */
	public static final int CONE_OF_COLD = 38;

	/** 法師魔法 (魔力奪取) */
	public static final int MANA_DRAIN = 39;

	/** 法師魔法 (黑闇之影) */
	public static final int DARKNESS = 40;

	/** 法師魔法 (造屍術) */
	public static final int CREATE_ZOMBIE = 41;

	/** 法師魔法 (體魄強健術) */
	public static final int PHYSICAL_ENCHANT_STR = 42; // E: ENCHANT_MIGHTY

	/** 法師魔法 (加速術) */
	public static final int HASTE = 43;

	/** 法師魔法 (魔法相消術) */
	public static final int CANCELLATION = 44; // E: CANCEL MAGIC

	/** 法師魔法 (地裂術) */
	public static final int ERUPTION = 45;

	/** 法師魔法 (烈炎術) */
	public static final int SUNBURST = 46;

	/** 法師魔法 (弱化術) */
	public static final int WEAKNESS = 47;

	/** 法師魔法 (祝福魔法武器) */
	public static final int BLESS_WEAPON = 48;

	/** 法師魔法 (體力回復術) */
	public static final int HEAL_ALL = 49; // E: HEAL_PLEDGE

	/** 法師魔法 (冰矛圍籬) */
	public static final int ICE_LANCE = 50;

	/** 法師魔法 (召喚術) */
	public static final int SUMMON_MONSTER = 51;

	/** 法師魔法 (神聖疾走) */
	public static final int HOLY_WALK = 52;

	/** 法師魔法 (龍捲風) */
	public static final int TORNADO = 53;

	/** 法師魔法 (強力加速術) */
	public static final int GREATER_HASTE = 54;

	/** 法師魔法 (狂暴術) */
	public static final int BERSERKERS = 55;

	/** 法師魔法 (疾病術) */
	public static final int DISEASE = 56;

	/** 法師魔法 (全部治癒術) */
	public static final int FULL_HEAL = 57;

	/** 法師魔法 (火牢) */
	public static final int FIRE_WALL = 58;

	/** 法師魔法 (冰雪暴) */
	public static final int BLIZZARD = 59;

	/** 法師魔法 (隱身術) */
	public static final int INVISIBILITY = 60;

	/** 法師魔法 (返生術) */
	public static final int RESURRECTION = 61;

	/** 法師魔法 (震裂術) */
	public static final int EARTHQUAKE = 62;

	/** 法師魔法 (治癒能量風暴) */
	public static final int LIFE_STREAM = 63;

	/** 法師魔法 (魔法封印) */
	public static final int SILENCE = 64;

	/** 法師魔法 (雷霆風暴) */
	public static final int LIGHTNING_STORM = 65;

	/** 法師魔法 (沉睡之霧) */
	public static final int FOG_OF_SLEEPING = 66;

	/** 法師魔法 (變形術) */
	public static final int SHAPE_CHANGE = 67; // E: POLYMORPH

	/** 法師魔法 (聖結界) */
	public static final int IMMUNE_TO_HARM = 68;

	/** 法師魔法 (集體傳送術) */
	public static final int MASS_TELEPORT = 69;

	/** 法師魔法 (火風暴) */
	public static final int FIRE_STORM = 70;

	/** 法師魔法 (藥水霜化術) */
	public static final int DECAY_POTION = 71;

	/** 法師魔法 (強力無所遁形術) */
	public static final int COUNTER_DETECTION = 72;

	/** 法師魔法 (創造魔法武器) */
	public static final int CREATE_MAGICAL_WEAPON = 73;

	/** 法師魔法 (流星雨) */
	public static final int METEOR_STRIKE = 74;

	/** 法師魔法 (終極返生術) */
	public static final int GREATER_RESURRECTION = 75;

	/** 法師魔法 (集體緩速術) */
	public static final int MASS_SLOW = 76;

	/** 法師魔法 (究極光裂術) */
	public static final int DISINTEGRATE = 77; // E: DESTROY

	/** 法師魔法 (絕對屏障) */
	public static final int ABSOLUTE_BARRIER = 78;

	/** 法師魔法 (靈魂昇華) */
	public static final int ADVANCE_SPIRIT = 79;

	/** 法師魔法 (冰雪颶風) */
	public static final int FREEZING_BLIZZARD = 80;
	
	// none = 81 - 86
	/*
	 * Knight skills
	 */
	/** 騎士魔法 (衝擊之暈) */
	public static final int SHOCK_STUN = 87; // E: STUN_SHOCK

	/** 騎士魔法 (增幅防禦) */
	public static final int REDUCTION_ARMOR = 88;

	/** 騎士魔法 (尖刺盔甲) */
	public static final int BOUNCE_ATTACK = 89;

	/** 騎士魔法 (堅固防護) */
	public static final int SOLID_CARRIAGE = 90;

	/** 騎士魔法 (反擊屏障) */
	public static final int COUNTER_BARRIER = 91;

	// none = 92-96
	/*
	 * Dark Spirit Magic
	 */
	/** 黑暗妖精魔法 (暗隱術) */
	public static final int BLIND_HIDING = 97;

	/** 黑暗妖精魔法 (附加劇毒) */
	public static final int ENCHANT_VENOM = 98;

	/** 黑暗妖精魔法影 (影之防護) */
	public static final int SHADOW_ARMOR = 99;

	/** 黑暗妖精魔法(提煉魔石) */
	public static final int BRING_STONE = 100;

	/** 黑暗妖精魔法 (行走加速) */
	public static final int MOVING_ACCELERATION = 101; // E: PURIFY_STONE

	/** 黑暗妖精魔法 (燃燒鬥志) */
	public static final int BURNING_SPIRIT = 102;

	/** 黑暗妖精魔法 (暗黑盲咒) */
	public static final int DARK_BLIND = 103;

	/** 黑暗妖精魔法 (毒性抵抗) */
	public static final int VENOM_RESIST = 104;

	/** 黑暗妖精魔法 (雙重破壞) */
	public static final int DOUBLE_BRAKE = 105;

	/** 黑暗妖精魔法 (暗影閃避) */
	public static final int UNCANNY_DODGE = 106;

	/** 黑暗妖精魔法 (暗影之牙) */
	public static final int SHADOW_FANG = 107;

	/** 黑暗妖精魔法 (會心一擊) */
	public static final int FINAL_BURN = 108;

	/** 黑暗妖精魔法  (力量提升) */
	public static final int DRESS_MIGHTY = 109;

	/** 黑暗妖精魔法 (敏捷提升) */
	public static final int DRESS_DEXTERITY = 110;

	/** 黑暗妖精魔法 (閃避提升) */
	public static final int DRESS_EVASION = 111;

	// none = 112
	/*
	 * Royal Magic
	 */
	/** 王族魔法 (精準目標) */
	public static final int TRUE_TARGET = 113;

	/** 王族魔法特殊級 (激勵士氣) */
	public static final int GLOWING_AURA = 114;

	/**王族魔法特殊級 (鋼鐵士氣) */
	public static final int SHINING_AURA = 115;

	/** 王族魔法 (呼喚盟友) */
	public static final int CALL_CLAN = 116; // E: CALL_PLEDGE_MEMBER

	/** 王族魔法特殊級 (衝擊士氣) */
	public static final int BRAVE_AURA = 117;

	/** 王族魔法特殊級 (援護盟友) */
	public static final int RUN_CLAN = 118;

	// unknown = 119 - 120
	// none = 121 - 128
	/*
	 * Spirit Magic
	 */

	/** 妖精魔法 (魔法防禦) */
	public static final int RESIST_MAGIC = 129;

	/** 妖精魔法 (心靈轉換) */
	public static final int BODY_TO_MIND = 130;

	/** 妖精魔法 (世界樹的呼喚) */
	public static final int TELEPORT_TO_MATHER = 131;

	/** 妖精魔法 (三重矢) */
	public static final int TRIPLE_ARROW = 132;

	/** 妖精魔法 (弱化屬性) */
	public static final int ELEMENTAL_FALL_DOWN = 133;

	/** 妖精魔法 (鏡反射) */
	public static final int COUNTER_MIRROR = 134;

	// none = 135 - 136
	/** 妖精魔法 (淨化精神) */
	public static final int CLEAR_MIND = 137;

	/** 妖精魔法 (屬性防禦) */
	public static final int RESIST_ELEMENTAL = 138;

	// none = 139 - 144
	/** 妖精魔法 (釋放元素) */
	public static final int RETURN_TO_NATURE = 145;

	/** 妖精魔法 (魂體轉換) */
	public static final int BLOODY_SOUL = 146; // E: BLOOD_TO_SOUL

	/** 妖精魔法 (單屬性防禦) */
	public static final int ELEMENTAL_PROTECTION = 147; // E:PROTECTION_FROM_ELEMENTAL

	/** 妖精魔法 (火焰武器) */
	public static final int FIRE_WEAPON = 148;

	/** 妖精魔法 (風之神射) */
	public static final int WIND_SHOT = 149;

	/** 妖精魔法 (風之疾走) */
	public static final int WIND_WALK = 150;

	/** 妖精魔法 (大地防護) */
	public static final int EARTH_SKIN = 151;

	/** 妖精魔法 (地面障礙) */
	public static final int ENTANGLE = 152;

	/** 妖精魔法 (魔法消除) */
	public static final int ERASE_MAGIC = 153;

	/** 妖精魔法 (召喚屬性精靈) */
	public static final int LESSER_ELEMENTAL = 154; // E:SUMMON_LESSER_ELEMENTAL

	/** 妖精魔法 (烈炎氣息) */
	public static final int FIRE_BLESS = 155; // E: BLESS_OF_FIRE

	/** 妖精魔法 (暴風之眼) */
	public static final int STORM_EYE = 156; // E: EYE_OF_STORM

	/** 妖精魔法 (大地屏障) */
	public static final int EARTH_BIND = 157;

	/** 妖精魔法 (生命之泉) */
	public static final int NATURES_TOUCH = 158;

	/** 妖精魔法 (大地的祝福) */
	public static final int EARTH_BLESS = 159; // E: BLESS_OF_EARTH

	/** 妖精魔法 (水之防護) */
	public static final int AQUA_PROTECTER = 160;

	/** 妖精魔法 (精靈魔法 (封印禁地) */
	public static final int AREA_OF_SILENCE = 161;

	/** 妖精魔法 (召喚強力屬性精靈) */
	public static final int GREATER_ELEMENTAL = 162; // E:SUMMON_GREATER_ELEMENTAL

	/** 妖精魔法 (烈炎武器) */
	public static final int BURNING_WEAPON = 163;

	/** 妖精魔法 (生命的祝福) */
	public static final int NATURES_BLESSING = 164;

	/** 妖精魔法 (生命呼喚) */
	public static final int CALL_OF_NATURE = 165; // E: NATURES_MIRACLE

	/** 妖精魔法  (暴風神射) */
	public static final int STORM_SHOT = 166;

	/** 妖精魔法 (風之枷鎖) */
	public static final int WIND_SHACKLE = 167;

	/** 妖精魔法 (鋼鐵防護) */
	public static final int IRON_SKIN = 168;

	/** 妖精魔法 (體能激發) */
	public static final int EXOTIC_VITALIZE = 169;

	/** 妖精魔法 (水之元氣) */
	public static final int WATER_LIFE = 170;

	/** 妖精魔法 (屬性之火) */
	public static final int ELEMENTAL_FIRE = 171;

	/** 妖精魔法 (暴風疾走) */
	public static final int STORM_WALK = 172;

	/** 妖精魔法 (污濁之水) */
	public static final int POLLUTE_WATER = 173;

	/** 妖精魔法 (精準射擊) */
	public static final int STRIKER_GALE = 174;

	/** 妖精魔法 (烈焰之魂) */
	public static final int SOUL_OF_FLAME = 175;

	/** 妖精魔法 (能量激發) */
	public static final int ADDITIONAL_FIRE = 176;

	// none = 177-180
	/*
	 * Dragon Knight skills
	 */
	/** 龍騎士魔法 (龍之護鎧) */
	public static final int DRAGON_SKIN = 181;

	/** 龍騎士魔法 (燃燒擊砍) */
	public static final int BURNING_SLASH = 182;

	/** 龍騎士魔法 (護衛毀滅) */
	public static final int GUARD_BRAKE = 183;

	/** 龍騎士魔法 (岩漿噴吐) */
	public static final int MAGMA_BREATH = 184;

	/** 龍騎士魔法 (覺醒安塔瑞斯) */
	public static final int AWAKEN_ANTHARAS = 185;

	/** 龍騎士魔法 (血之渴望) */
	public static final int BLOODLUST = 186;

	/** 龍騎士魔法 (屠宰者) */
	public static final int FOE_SLAYER = 187;

	/** 龍騎士魔法 (恐懼無助) */
	public static final int RESIST_FEAR = 188;

	/** 龍騎士魔法 (衝擊之膚) */
	public static final int SHOCK_SKIN = 189;

	/** 龍騎士魔法 (覺醒法利昂) */
	public static final int AWAKEN_FAFURION = 190;

	/** 龍騎士魔法 (致命身軀) */
	public static final int MORTAL_BODY = 191;

	/** 龍騎士魔法 (奪命之雷) */
	public static final int THUNDER_GRAB = 192;

	/** 龍騎士魔法 (驚悚死神) */
	public static final int HORROR_OF_DEATH = 193;

	/** 龍騎士魔法 (寒冰噴吐) */
	public static final int FREEZING_BREATH = 194;

	/** 龍騎士魔法 (覺醒巴拉卡斯) */
	public static final int AWAKEN_VALAKAS = 195;

	// none = 196-200
	/*
	 * Illusionist Magic
	 */
	/** 幻術士魔法 (鏡像) */
	public static final int MIRROR_IMAGE = 201;

	/** 幻術士魔法 (混亂) */
	public static final int CONFUSION = 202;

	/** 幻術士魔法 (暴擊) */
	public static final int SMASH = 203;

	/** 幻術士魔法 (幻覺歐吉) */
	public static final int ILLUSION_OGRE = 204;

	/** 幻術士魔法 (立方燃燒) */
	public static final int CUBE_IGNITION = 205;

	/** 幻術士魔法 (專注) */
	public static final int CONCENTRATION = 206;

	/** 幻術士魔法 (心靈破壞) */
	public static final int MIND_BREAK = 207;

	/** 幻術士魔法 (骷髏毀壞) */
	public static final int BONE_BREAK = 208;

	/** 幻術士魔法 (幻覺巫妖) */
	public static final int ILLUSION_LICH = 209;

	/** 幻術士魔法 (立方地裂) */
	public static final int CUBE_QUAKE = 210;

	/** 幻術士魔法 (耐力) */
	public static final int PATIENCE = 211;

	/** 幻術士魔法 (幻想) */
	public static final int PHANTASM = 212;

	/** 幻術士魔法 (武器破壞者) */
	public static final int ARM_BREAKER = 213;

	/** 幻術士魔法 (幻覺鑽石高崙) */
	public static final int ILLUSION_DIA_GOLEM = 214;

	/** 幻術士魔法 (立方衝擊) */
	public static final int CUBE_SHOCK = 215;

	/** 幻術士魔法 (洞察) */
	public static final int INSIGHT = 216;

	/** 幻術士魔法 (恐慌) */
	public static final int PANIC = 217;

	/** 幻術士魔法 (疼痛的歡愉) */
	public static final int JOY_OF_PAIN = 218;

	/** 幻術士魔法 (幻覺：化身) */
	public static final int ILLUSION_AVATAR = 219;

	/** 幻術士魔法 (立方和諧) */
	public static final int CUBE_BALANCE = 220;

	/** 魔法結尾*/
	public static final int SKILLS_END = 220;

	/*
	 * Status
	 */
	public static final int STATUS_BEGIN = 1000;

	public static final int STATUS_BRAVE = 1000;

	public static final int STATUS_HASTE = 1001;

	public static final int STATUS_BLUE_POTION = 1002;

	public static final int STATUS_UNDERWATER_BREATH = 1003;

	public static final int STATUS_WISDOM_POTION = 1004;

	public static final int STATUS_CHAT_PROHIBITED = 1005;

	public static final int STATUS_POISON = 1006;

	public static final int STATUS_POISON_SILENCE = 1007;

	public static final int STATUS_POISON_PARALYZING = 1008;

	public static final int STATUS_POISON_PARALYZED = 1009;

	public static final int STATUS_CURSE_PARALYZING = 1010;

	public static final int STATUS_CURSE_PARALYZED = 1011;

	public static final int STATUS_FLOATING_EYE = 1012;

	public static final int STATUS_HOLY_WATER = 1013;

	public static final int STATUS_HOLY_MITHRIL_POWDER = 1014;

	public static final int STATUS_HOLY_WATER_OF_EVA = 1015;

	public static final int STATUS_ELFBRAVE = 1016;

	public static final int STATUS_RIBRAVE = 1017;

	public static final int STATUS_CUBE_IGNITION_TO_ALLY = 1018;

	public static final int STATUS_CUBE_IGNITION_TO_ENEMY = 1019;

	public static final int STATUS_CUBE_QUAKE_TO_ALLY = 1020;

	public static final int STATUS_CUBE_QUAKE_TO_ENEMY = 1021;

	public static final int STATUS_CUBE_SHOCK_TO_ALLY = 1022;

	public static final int STATUS_CUBE_SHOCK_TO_ENEMY = 1023;

	public static final int STATUS_MR_REDUCTION_BY_CUBE_SHOCK = 1024;

	public static final int STATUS_CUBE_BALANCE = 1025;

	public static final int STATUS_END = 1025;

	public static final int GMSTATUS_BEGIN = 2000;

	public static final int GMSTATUS_INVISIBLE = 2000;

	public static final int GMSTATUS_HPBAR = 2001;

	public static final int GMSTATUS_SHOWTRAPS = 2002;

	public static final int GMSTATUS_FINDINVIS = 2003;

	public static final int GMSTATUS_END = 2003;

	public static final int COOKING_NOW = 2999;

	public static final int COOKING_BEGIN = 3000;

	public static final int COOKING_1_0_N = 3000;

	public static final int COOKING_1_1_N = 3001;

	public static final int COOKING_1_2_N = 3002;

	public static final int COOKING_1_3_N = 3003;

	public static final int COOKING_1_4_N = 3004;

	public static final int COOKING_1_5_N = 3005;

	public static final int COOKING_1_6_N = 3006;

	public static final int COOKING_1_7_N = 3007;

	public static final int COOKING_1_0_S = 3008;

	public static final int COOKING_1_1_S = 3009;

	public static final int COOKING_1_2_S = 3010;

	public static final int COOKING_1_3_S = 3011;

	public static final int COOKING_1_4_S = 3012;

	public static final int COOKING_1_5_S = 3013;

	public static final int COOKING_1_6_S = 3014;

	public static final int COOKING_1_7_S = 3015;

	public static final int COOKING_2_0_N = 3016;

	public static final int COOKING_2_1_N = 3017;

	public static final int COOKING_2_2_N = 3018;

	public static final int COOKING_2_3_N = 3019;

	public static final int COOKING_2_4_N = 3020;

	public static final int COOKING_2_5_N = 3021;

	public static final int COOKING_2_6_N = 3022;

	public static final int COOKING_2_7_N = 3023;

	public static final int COOKING_2_0_S = 3024;

	public static final int COOKING_2_1_S = 3025;

	public static final int COOKING_2_2_S = 3026;

	public static final int COOKING_2_3_S = 3027;

	public static final int COOKING_2_4_S = 3028;

	public static final int COOKING_2_5_S = 3029;

	public static final int COOKING_2_6_S = 3030;

	public static final int COOKING_2_7_S = 3031;

	public static final int COOKING_3_0_N = 3032;

	public static final int COOKING_3_1_N = 3033;

	public static final int COOKING_3_2_N = 3034;

	public static final int COOKING_3_3_N = 3035;

	public static final int COOKING_3_4_N = 3036;

	public static final int COOKING_3_5_N = 3037;

	public static final int COOKING_3_6_N = 3038;

	public static final int COOKING_3_7_N = 3039;

	public static final int COOKING_3_0_S = 3040;

	public static final int COOKING_3_1_S = 3041;

	public static final int COOKING_3_2_S = 3042;

	public static final int COOKING_3_3_S = 3043;

	public static final int COOKING_3_4_S = 3044;

	public static final int COOKING_3_5_S = 3045;

	public static final int COOKING_3_6_S = 3046;

	public static final int COOKING_3_7_S = 3047;

	public static final int COOKING_END = 3047;

	/** 殷海薩的祝福 */
	public static final int EXP_POTION = 7013;
	
	/** 思克巴瀕死傳送延遲*/
	public static final int SUCCBUS_TELEPORT_DELAY = 7014;
	
	public static final int STATUS_FREEZE = 10071;

	public static final int CURSE_PARALYZE2 = 10101;

	public static final int STATUS_CURSE_BARLOG = 1015;

	public static final int STATUS_CURSE_YAHEE = 1014;
	
	/** 三段加速 */
	public static final int STATUS_THIRD_SPEED = 551788;
	
	/** 新手保護(遭遇的守護) */
	public static final int STATUS_NOVICE = 8000;

}
