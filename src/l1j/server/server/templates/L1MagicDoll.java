package l1j.server.server.templates;

import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.MagicDollTable;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.random.RandomGenerator;
import l1j.server.server.random.RandomGeneratorFactory;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_SystemMessage; //TODO 經驗加倍魔法娃娃訊息byhot183

public class L1MagicDoll {

	private static RandomGenerator _random = RandomGeneratorFactory.newRandom();

	public static int getHitAddByDoll(L1Character _master) { //TODO 近接命中力増加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getHit();
			}
		}
		return s;
	}

	public static int getDamageAddByDoll(L1Character _master) { //TODO 近接攻撃力増加
		int s = 0;
		int chance = _random.nextInt(100) + 1;
		boolean isAdd = false;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				if (doll.getDmgChance() > 0 && !isAdd) {
					if (doll.getDmgChance() >= chance) {
						s += doll.getDmg();
						isAdd = true;
					}
				} else if (doll.getDmg() != 0) {
					s += doll.getDmg();
				}
			}
		}
		if (isAdd) {
			if (_master instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) _master;
				pc.sendPackets(new S_SkillSound(_master.getId(), 6319));
			}
			_master.broadcastPacket(new S_SkillSound(_master.getId(), 6319));
		}
		return s;
	}

	public static int getDamageReductionByDoll(L1Character _master) { //TODO ダメージリダクション
		int s = 0;
		int chance = _random.nextInt(100) + 1;
		boolean isReduction = false;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				if (doll.getDmgReductionChance() > 0 && !isReduction) {
					if (doll.getDmgReductionChance() >= chance) {
						s += doll.getDmgReduction();
						isReduction = true;
					}
				} else if (doll.getDmgReduction() != 0) {
					s += doll.getDmgReduction();
				}
			}
		}
		if (isReduction) {
			if (_master instanceof L1PcInstance) {
				L1PcInstance pc = (L1PcInstance) _master;
				pc.sendPackets(new S_SkillSound(_master.getId(), 6320));
			}
			_master.broadcastPacket(new S_SkillSound(_master.getId(), 6320));
		}
		return s;
	}

	public static int getDamageEvasionByDoll(L1Character _master) { //TODO 回避率
		int chance = _random.nextInt(100) + 1;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				if (doll.getDmgEvasionChance() >= chance) {
					if (_master instanceof L1PcInstance) {
						L1PcInstance pc = (L1PcInstance) _master;
						pc.sendPackets(new S_SkillSound(_master.getId(), 6320));
					}
					_master.broadcastPacket(new S_SkillSound(_master.getId(),6320));
					return 1;
				}
			}
		}
		return 0;
	}

	public static int getBowHitAddByDoll(L1Character _master) { //TODO 弓一般遠距離命中
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getBowHit();
			}
		}
		return s;
	}

	public static int getBowDamageByDoll(L1Character _master) { //TODO 弓一般遠距離額外
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getBowDmg();
			}
		}
		return s;
	}

	public static int getAcByDoll(L1Character _master) { //TODO AC増加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getAc();
			}
		}
		return s;
	}

	public static int getRegistStoneByDoll(L1Character _master) { //TODO 石化耐性増加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getRegistStone();
			}
		}
		return s;
	}

	public static int getRegistStunByDoll(L1Character _master) { //TODO スタン耐性増加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getRegistStun();
			}
		}
		return s;
	}

	public static int getRegistSustainByDoll(L1Character _master) { //TODO ホールド耐性増加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getRegistSustain();
			}
		}
		return s;
	}

	public static int getRegistBlindByDoll(L1Character _master) { //TODO 暗闇耐性増加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getRegistBlind();
			}
		}
		return s;
	}

	public static int getRegistFreezeByDoll(L1Character _master) { //TODO 凍結耐性増加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getRegistFreeze();
			}
		}
		return s;
	}

	public static int getRegistSleepByDoll(L1Character _master) { //TODO 睡眠耐性増加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getRegistSleep();
			}
		}
		return s;
	}

	public static int getWeightReductionByDoll(L1Character _master) { //TODO 重量軽減
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getWeightReduction();
			}
		}
		return s;
	}

	public static int getHprByDoll(L1Character _master) { //TODO 直接加給玩家的HPR效果
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				if (doll.getHpr() != 0) {
					s += doll.getHpr();
				}
			}
		}
		return s;
	}

	public static int getMprByDoll(L1Character _master) { //TODO 直接加給玩家的MPR效果
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				if (doll.getMpr() != 0) {
					s += doll.getMpr();
				}
			}
		}
		return s;
	}

	public static boolean isItemMake(L1Character _master) {
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				L1Item item = ItemTable.getInstance().getTemplate(
						(doll.getMakeItemId()));
				if (item != null) {
					return true;
				}
			}
		}
		return false;
	}

	public static int getMakeItemId(L1Character _master) { //TODO アイテム獲得
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				L1Item item = ItemTable.getInstance().getTemplate(
						(doll.getMakeItemId()));
				if (item != null) {
					return item.getItemId();
				}
			}
		}
		return 0;
	}

	public static int getHpByDoll(L1Character _master) { //TODO 魔法娃娃額外追加的HPR
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				if (doll.getHprTime() > 0 && doll.getAddHprByDoll() != 0) {
					s += doll.getAddHprByDoll();
				}
			}
		}
		return s;
	}

	public static int getDollHprTime(L1Character _master) { //TODO 魔法娃娃額外追加的HPR恢復間隔時間
		int Time = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				if (doll.getHprTime() > 0 && doll.getAddHprByDoll() != 0) {
					Time += doll.getHprTime();
				}
			}
		}
		return Time;
	}

	public static int getMpByDoll(L1Character _master) { //TODO 魔法娃娃額外追加的MPR
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				if (doll.getMprTime() > 0 && doll.getAddMprByDoll() != 0) {
					s += doll.getAddMprByDoll();
				}
			}
		}
		return s;
	}

	public static int getDollMprTime(L1Character _master) { //TODO 魔法娃娃額外追加的MPR恢復間隔時間
		int Time = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				if (doll.getMprTime() > 0 && doll.getAddMprByDoll() != 0) {
					Time += doll.getMprTime();
				}
			}
		}
		return Time;
	}

	public static int getEffectByDoll(L1Character _master, byte type) { //TODO 效果
		int chance = _random.nextInt(100) + 1;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				if (doll.getEffect() == type) {
					if (chance <= 5) {
						return type;
					}
				}
			}
		}
		return 0;
	}

	public static int getStrByDoll(L1Character _master) {//TODO 力量增加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getStr();
			}
		}
		return s;
	}

	public static int getConByDoll(L1Character _master) {//TODO 體質增加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getCon();
			}
		}
		return s;
	}

	public static int getDexByDoll(L1Character _master) {//TODO 敏捷增加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getDex();
			}
		}
		return s;
	}

	public static int  getChaByDoll(L1Character _master) {//TODO 魅力增加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getcha();
			}
		}
		return s;
	}

	public static int getWisByDoll(L1Character _master) {//TODO 精神增加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getWis();
			}
		}
		return s;
	}

	public static int getIntByDoll(L1Character _master) {//TODO 智力增加
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getInt();
			}
		}
		return s;
	}

	public static int getWindByDoll(L1Character _master) {//TODO 風屬性防禦
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getWind();
			}
		}
		return s;
	}

	public static int getwaterByDoll(L1Character _master) {//TODO 水屬性防禦
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getwater();
			}
		}
		return s;
	}

	public static int getfireByDoll(L1Character _master) {//TODO 火屬性防禦
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getfire();
			}
		}
		return s;
	}

	public static int getearthByDoll(L1Character _master) {//TODO 地屬性防禦
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getearth();
			}
		}
		return s;
	}
	
	public static int getMrByDoll(L1Character _master) {//TODO 魔法防禦
		int s = 0;
		for (Object obj : _master.getDollList().values().toArray()) {
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(
					((L1DollInstance) obj).getItemId());
			if (doll != null) {
				s += doll.getMr();
			}
		}
		return s;
	}
	
	public static double getDoubleExpByDoll(L1Character _master) {//TODO 經驗加乘效果
		double DoubleExp = 1.0;  
		boolean getExpRate = false;
		int chance = _random.nextInt(100) + 1; 
		for (Object obj : _master.getDollList().values().toArray()) { 
			L1MagicDoll doll = MagicDollTable.getInstance().getTemplate(((L1DollInstance) obj).getItemId()); 
			if (doll != null) { 
				if(doll.getExpRateChance() > 0 && !getExpRate) { 
					if (doll.getExpRateChance() >= chance) { 
						DoubleExp = doll.getExpRate(); 
						if (_master instanceof L1PcInstance) { 
							L1PcInstance pc = (L1PcInstance) _master; 
							pc.sendPackets(new S_SystemMessage("經驗值上升 " + DoubleExp + " 倍！")); 
							pc.sendPackets(new S_SkillSound(_master.getId(),6319)); 
						} 
					} 
				} 
			} 
		} 
		return DoubleExp;
	}

	private int _itemId;
	private int _dollId;
	private int _ac;
	private int _hpr;//TODO 玩家體力回覆量
	private int _hprTime;//TODO 體力時間判斷可自行DB自行設定秒數
	private int _addHprByDoll;//TODO 魔法娃娃額外回血
	private int _mpr;//TODO 玩家魔力回覆量
	private int _mprTime;//TODO 魔力時間判斷可自行DB自行設定秒數
	private int _addMprByDoll; //TODO 魔法娃娃額外回魔
	private int _dmg;
	private int _bowDmg;
	private int _dmgChance;
	private int _hit;
	private int _bowHit;
	private int _dmgReduction;
	private int _dmgReductionChance;
	private int _dmgEvasionChance;
	private int _weightReduction;
	private int _registStun;
	private int _registStone;
	private int _registSleep;
	private int _registFreeze;
	private int _registSustain;
	private int _registBlind;
	private int _makeItemId;
	private byte _effect;
	private int _exprate_chance;//TODO 經驗機率發動by hot183
	private double _exprate;//TODO 經驗加乘效果by0968026609&原作者byhot183
	private int _Str;//TODO 魔法娃娃力量效果by0968026609
	private int _Con;//TODO 魔法娃娃體質效果by0968026609
	private int _Dex;//TODO 魔法娃娃敏捷效果by0968026609
	private int _cha;//TODO 魔法娃娃魅力效果by0968026609
	private int _Wis;//TODO 魔法娃娃精神效果by0968026609
	private int _Int;//TODO 魔法娃娃智力效果by0968026609
	private int _Wind;//TODO 魔法娃娃風屬性防禦by0968026609
	private int _water;//TODO 魔法娃娃水屬性防禦by0968026609
	private int _fire;//TODO 魔法娃娃火屬性防禦by0968026609
	private int _earth;//TODO 魔法娃娃地屬性防禦by0968026609
	private int _mr;//TODO 魔法娃娃魔法防禦

	public int getItemId() {
		return _itemId;
	}

	public void setItemId(int i) {
		_itemId = i;
	}

	public int getDollId() {
		return _dollId;
	}

	public void setDollId(int i) {
		_dollId = i;
	}

	public int getAc() {
		return _ac;
	}

	public void setAc(int i) {
		_ac = i;
	}
	
	/**
	 * 玩家體力回覆量
	 * @return 
	 */
	public int getHpr() {
		return _hpr;
	}
	
	/**
	 * 玩家體力回覆量
	 * @return 
	 */
	public void setHpr(int i) {
		_hpr = i;
	}
	
	/**
	 * 玩家魔力回覆量
	 * @return 
	 */
	public int getMpr() {
		return _mpr;
	}
	
	/**
	 * 玩家魔力回覆量
	 * @return 
	 */
	public void setMpr(int i) {
		_mpr = i;
	}
	
	/**
	* 體力時間判斷可自行DB自行設定秒數
    *@return
    */	
	public int getHprTime() {
		return _hprTime;
	}
	
	/**
	* 體力時間判斷可自行DB自行設定秒數
    *@return
    */
	public void setHprTime(int i) {
		_hprTime = i;
	}

	/**
	* 魔力時間判斷可自行DB自行設定秒數
    *@return
    */
	public int getMprTime() {
		return _mprTime;
	}

	/**
	* 魔力時間判斷可自行DB自行設定秒數
    *@return
    */
	public void setMprTime(int i) {
		_mprTime = i;
	}

	/**
	 * 魔法娃娃額外回血
	 * @return 
	 */
	public int getAddHprByDoll() { 
		return _addHprByDoll;
	}

	/**
	 * 魔法娃娃額外回血
	 * @return 
	 */

	public void setAddHprByDoll(int i) {
		_addHprByDoll = i;
	}

	/**
	 * 魔法娃娃額外回魔
	 * @return 
	 */
	public int getAddMprByDoll() {
		return _addMprByDoll;
	}

	/**
	 * 魔法娃娃額外回魔
	 * @return 
	 */
	public void setAddMprByDoll(int i) {
		_addMprByDoll = i;
	}

	public int getDmg() {
		return _dmg;
	}

	public void setDmg(int i) {
		_dmg = i;
	}

	public int getBowDmg() {
		return _bowDmg;
	}

	public void setBowDmg(int i) {
		_bowDmg = i;
	}

	public int getDmgChance() {
		return _dmgChance;
	}

	public void setDmgChance(int i) {
		_dmgChance = i;
	}

	public int getHit() {
		return _hit;
	}

	public void setHit(int i) {
		_hit = i;
	}

	public int getBowHit() {
		return _bowHit;
	}

	public void setBowHit(int i) {
		_bowHit = i;
	}

	public int getDmgReduction() {
		return _dmgReduction;
	}

	public void setDmgReduction(int i) {
		_dmgReduction = i;
	}

	public int getDmgReductionChance() {
		return _dmgReductionChance;
	}

	public void setDmgReductionChance(int i) {
		_dmgReductionChance = i;
	}

	public int getDmgEvasionChance() {
		return _dmgEvasionChance;
	}

	public void setDmgEvasionChance(int i) {
		_dmgEvasionChance = i;
	}

	public int getWeightReduction() {
		return _weightReduction;
	}

	public void setWeightReduction(int i) {
		_weightReduction = i;
	}

	public int getRegistStun() {
		return _registStun;
	}

	public void setRegistStun(int i) {
		_registStun = i;
	}

	public int getRegistStone() {
		return _registStone;
	}

	public void setRegistStone(int i) {
		_registStone = i;
	}

	public int getRegistSleep() {
		return _registSleep;
	}

	public void setRegistSleep(int i) {
		_registSleep = i;
	}

	public int getRegistFreeze() {
		return _registFreeze;
	}

	public void setRegistFreeze(int i) {
		_registFreeze = i;
	}

	public int getRegistSustain() {
		return _registSustain;
	}

	public void setRegistSustain(int i) {
		_registSustain = i;
	}

	public int getRegistBlind() {
		return _registBlind;
	}

	public void setRegistBlind(int i) {
		_registBlind = i;
	}

	public int getMakeItemId() {
		return _makeItemId;
	}

	public void setMakeItemId(int i) {
		_makeItemId = i;
	}

	public byte getEffect() {
		return _effect;
	}

	public void setEffect(byte i) {
		_effect = i;
	}

	/**
	 * 經驗機率發動
	 * @author by hot183
	 */
	public void setExpRateChance(int i) { 
		_exprate_chance = i; 
	}

	/**
	 * 經驗機率發動
	 * @author by hot183
	 */
	public int getExpRateChance() { 
		return _exprate_chance; 
	} 

	/**
	 * 經驗加乘效果
	 * @return byhot183
	 */
	public double getExpRate() { 
		return _exprate; 
	} 

	/**
	 * 經驗加乘效果
	 * @return byhot183
	 */
	public void setExpRate(double d) { 
		_exprate = d; 
	}

	/**
	 * 魔法娃娃力量效果
	 * @return 
	 */
	public int getStr() {
		return _Str;
	}

	/**
	 * 魔法娃娃力量效果
	 * @return 
	 */

	public void setStr(int i) {
		_Str = i;
	}

	/**
	 * 魔法娃娃體質效果
	 * @return 
	 */
	public int getCon() {
		return _Con;
	}

	/**
	 * 魔法娃娃體質效果
	 * @return 
	 */
	public void setCon(int i) {
		_Con = i;
	}

	/**
	 * 魔法娃娃敏捷效果
	 * @return 
	 */
	public int getDex() {
		return _Dex;
	}

	/**
	 * 魔法娃娃敏捷效果
	 * @return 
	 */

	public void setDex(int i) {
		_Dex = i;
	}

	/**
	 * 魔法娃娃魅力效果
	 * @return 
	 */
	public int getcha() {
		return _cha;
	}

	/**
	 * 魔法娃娃魅力效果
	 * @return 
	 */

	public void setcha(int i) {
		_cha = i;
	}

	/**
	 * 魔法娃娃精神效果
	 * @return 
	 */
	public int getWis() {
		return _Wis;
	}

	/**
	 * 魔法娃娃精神效果
	 * @return 
	 */
	public void setWis(int i) {
		_Wis = i;
	}

	/**
	 * 魔法娃娃智力效果
	 * @return 
	 */
	public int getInt() {
		return _Int;
	}

	/**
	 * 魔法娃娃智力效果
	 * @return 
	 */
	public void setInt(int i) {
		_Int = i;
	}

	/**
	 * 魔法娃娃風屬性防禦效果
	 * @return 
	 */
	public int getWind() {
		return _Wind;
	}

	/**
	 * 魔法娃娃風屬性防禦效果
	 * @return 
	 */
	public void getWind(int i) {
		_Wind = i;
	}

	/**
	 * 魔法娃娃水屬性防禦效果
	 * @return 
	 */
	public int getwater() {
		return _water;
	}

	/**
	 * 魔法娃娃水屬性防禦效果
	 * @return 
	 */
	public void getwater(int i) {
		_water = i;
	}

	/**
	 * 魔法娃娃火屬性防禦效果
	 * @return 
	 */
	public int getfire() {
		return _fire;
	}

	/**
	 * 魔法娃娃火屬性防禦效果
	 * @return 
	 */
	public void getfire(int i) {
		_fire = i;
	}

	/**
	 * 魔法娃娃地屬性防禦效果
	 * @return 
	 */
	public int getearth() {
		return _earth;
	}

	/**
	 * 魔法娃娃地屬性防禦效果
	 * @return 
	 */
	public void getearth(int i) {
		_earth = i;
	}
	
	/**
	 * 魔法娃娃魔法防禦
	 * @return 
	 */
	public int getMr() {
		return _mr;
	}

	/**
	 * 魔法娃娃魔法防禦
	 * @return 
	 */
	public void getMr(int i) {
		_mr = i;
	}
}
