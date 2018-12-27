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

package l1j.server.server.model.Instance;

import java.util.Arrays;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Logger;
import java.util.Random;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.IdFactory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_DollPack;
import l1j.server.server.serverpackets.S_MoveCharPacket;
import l1j.server.server.serverpackets.S_SPMR;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.ActionCodes; 
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_OwnCharStatus;//TODO 魔法娃娃DB化
import l1j.server.server.serverpackets.S_SkillIconGFX;//TODO 魔法娃娃DB化
import l1j.server.server.templates.L1MagicDoll;//TODO 魔法娃娃DB化
public class L1DollInstance extends L1NpcInstance {
	private static final long serialVersionUID = 1L;

	public static final int DOLL_TIME = 1800000;

	private static Logger _log = Logger.getLogger(L1DollInstance.class.getName());
	private ScheduledFuture<?> _dollFuture;
	private static Random _random = new Random();
	private int _itemId;//TODO 魔法娃娃DB化
	private int _itemObjId;
	private boolean _isDelete = false;//TODO 魔法娃娃DB化
	// ターゲットがいない場合の処理
	@Override
	public boolean noTarget() { // TODO 魔法娃娃動作Ｃ版本 by 夜小空
		if (_master.isDead()) {
			deleteDoll();
			_isDelete = true;//TODO 魔法娃娃DB化
			return true;
		} else if (_master != null && _master.getMapId() == getMapId()) {
			int dir = moveDirection(_master.getX(), _master.getY());
			if (getLocation().getTileLineDistance(_master.getLocation()) < 3) {
				for (int a = 1; a > 0; a--) {
					try {
						Thread.sleep(600);
						switch (new Random().nextInt(20)) {
						case 5:
							broadcastPacket(new S_DoActionGFX(getId(),
									ActionCodes.ACTION_Think));
							Thread.sleep(2000);
							break;
						case 15:
							broadcastPacket(new S_DoActionGFX(getId(),
									ActionCodes.ACTION_Aggress));
							Thread.sleep(2200);
							break;
						}
					} catch (Exception exception) {
						break;
					}
				}
			} else if (getLocation().getTileLineDistance(_master.getLocation()) > 9) {
				setDirectionMoveDoll(dir);
			} else {
				setDirectionMove(dir);
				setSleepTime(calcSleepTime(getPassispeed(), dir));
			}
		} else {
			deleteDoll();
			_isDelete = true;//TODO 魔法娃娃DB化
			return true;
		}
		return false;
	} 

	// ■■■■■■■■■■■■■ 移動関連 ■■■■■■■■■■■

	// 指定された方向に移動させる
	public void setDirectionMoveDoll(int dir) {
		if (dir >= 0) {
			int nx = 0;
			int ny = 0;

			switch (dir) {
			case 1:
				nx = 1;
				ny = -1;
				setHeading(1);
				break;

			case 2:
				nx = 1;
				ny = 0;
				setHeading(2);
				break;

			case 3:
				nx = 1;
				ny = 1;
				setHeading(3);
				break;

			case 4:
				nx = 0;
				ny = 1;
				setHeading(4);
				break;

			case 5:
				nx = -1;
				ny = 1;
				setHeading(5);
				break;

			case 6:
				nx = -1;
				ny = 0;
				setHeading(6);
				break;

			case 7:
				nx = -1;
				ny = -1;
				setHeading(7);
				break;

			case 0:
				nx = 0;
				ny = -1;
				setHeading(0);
				break;

			default:
				break;

			}

			getMap().setPassable(getLocation(), true);

			int nnx = _master.getX() + nx;
			int nny = _master.getY() + ny;
			setX(nnx);
			setY(nny);

			getMap().setPassable(getLocation(), false);


			broadcastPacket(new S_MoveCharPacket(this));
		}
	}

	// 時間計測用
	class DollTimer implements Runnable {
		@Override
		public void run() {
			if (_destroyed) { // 既に破棄されていないかチェック
				return;
			}
			deleteDoll();
		}
	}

	public L1DollInstance(L1Npc template, L1PcInstance pc, int itemId,//TODO 魔法娃娃DB化
			int itemObjId) {
		super(template);
		setId(IdFactory.getInstance().nextId());

		setItemId(itemId);//TODO 魔法娃娃DB化
		setItemObjId(itemObjId);
		_dollFuture = GeneralThreadPool.getInstance().schedule(new DollTimer(), DOLL_TIME);

		setMaster(pc);
		setX((_random.nextInt(5) + pc.getX() - 2));
		setY((_random.nextInt(5) + pc.getY() - 2));
		setMap(pc.getMapId());
		setHeading(5);
		setLightSize(template.getLightSize());

		L1World.getInstance().storeObject(this);
		L1World.getInstance().addVisibleObject(this);
		for (L1PcInstance _pc : L1World.getInstance().getRecognizePlayer(this)) {
			onPerceive(_pc);
		}
		pc.addDoll(this);
		if (!isAiRunning()) {
			startAI();
		}
		//TODO 魔法娃娃DB化
		if (L1MagicDoll.getDollHprTime(_master) > 0) {//TODO 魔法娃娃額外追加的HPR恢復間隔時間
			pc.startHpRegenerationByDoll();
		}
		if (L1MagicDoll.getDollMprTime(_master) > 0) {//TODO 魔法娃娃額外追加的MPR恢復間隔時間
			pc.startMpRegenerationByDoll();
		}
		if (L1MagicDoll.isItemMake(_master)) {
			pc.startItemMakeByDoll();
		}
		if (L1MagicDoll.getStrByDoll(_master) != 0) {//TODO 力量增加
			pc.addStr(L1MagicDoll.getStrByDoll(_master));
		}
		if (L1MagicDoll.getConByDoll(_master) != 0) {//TODO 體質增加
			pc.addCon(L1MagicDoll.getConByDoll(_master));
		}
		if (L1MagicDoll.getDexByDoll(_master) != 0) {//TODO 敏捷增加
			pc.addDex(L1MagicDoll.getDexByDoll(_master));
		}
		if (L1MagicDoll.getChaByDoll(_master) != 0) {//TODO 魅力增加
			pc.addCha(L1MagicDoll.getChaByDoll(_master));
		}
		if (L1MagicDoll.getWisByDoll(_master) != 0) {//TODO 精神增加
			pc.addWis(L1MagicDoll.getWisByDoll(_master));
		}
		if (L1MagicDoll.getIntByDoll(_master) != 0) {//TODO 智力增加
			pc.addInt(L1MagicDoll.getIntByDoll(_master));
		}		
		if (L1MagicDoll.getWindByDoll(_master) != 0) {//TODO 風屬性防禦
			pc.addWind(L1MagicDoll.getWindByDoll(_master));
		}
		if (L1MagicDoll.getwaterByDoll(_master) != 0) {//TODO 水屬性防禦
			pc.addWater(L1MagicDoll.getwaterByDoll(_master));
		}
		if (L1MagicDoll.getfireByDoll(_master) != 0) {//TODO 火屬性防禦
			pc.addFire(L1MagicDoll.getfireByDoll(_master));
		}
		if (L1MagicDoll.getearthByDoll(_master) != 0) {//TODO 地屬性防禦
			pc.addEarth(L1MagicDoll.getearthByDoll(_master));
		}
		if (L1MagicDoll.getMrByDoll(_master) != 0) {//TODO 魔法防禦
			pc.addMr(L1MagicDoll.getMrByDoll(_master));
			pc.sendPackets(new S_SPMR(pc));
		}
	}

	public void deleteDoll() {
		broadcastPacket(new S_SkillSound(getId(), 5936));
		L1PcInstance pc = (L1PcInstance) _master;
		if (_master != null && _isDelete) {
			pc.sendPackets(new S_SkillIconGFX(56, 0));
		}
		if (L1MagicDoll.getDollHprTime(_master) > 0) {//TODO 魔法娃娃額外追加的HPR恢復間隔時間
			pc.stopHpRegenerationByDoll();
		}
		if (L1MagicDoll.getDollMprTime(_master) > 0) {//TODO 魔法娃娃額外追加的MPR恢復間隔時間
			pc.stopMpRegenerationByDoll();
		}
		if (L1MagicDoll.isItemMake(_master)) {
			pc.stopItemMakeByDoll();
		}
		if (L1MagicDoll.getStrByDoll(_master) != 0) {//TODO 力量增加
			pc.addStr(-L1MagicDoll.getStrByDoll(_master));
		}
		if (L1MagicDoll.getConByDoll(_master) != 0) {//TODO 體質增加
			pc.addCon(-L1MagicDoll.getConByDoll(_master));
		}
		if (L1MagicDoll.getDexByDoll(_master) != 0) {//TODO 敏捷增加
			pc.addDex(-L1MagicDoll.getDexByDoll(_master));
		}
		if (L1MagicDoll.getChaByDoll(_master) != 0) {//TODO 魅力增加
			pc.addCha(-L1MagicDoll.getChaByDoll(_master));
		}
		if (L1MagicDoll.getWisByDoll(_master) != 0) {//TODO 精神增加
			pc.addWis(-L1MagicDoll.getWisByDoll(_master));
		}
		if (L1MagicDoll.getIntByDoll(_master) != 0) {//TODO 智力增加
			pc.addInt(-L1MagicDoll.getIntByDoll(_master));
		}
		if (L1MagicDoll.getWindByDoll(_master) != 0) {//TODO 風屬性防禦
			pc.addWind(-L1MagicDoll.getWindByDoll(_master));
		}
		if (L1MagicDoll.getwaterByDoll(_master) != 0) {//TODO 水屬性防禦
			pc.addWater(-L1MagicDoll.getwaterByDoll(_master));
		}
		if (L1MagicDoll.getfireByDoll(_master) != 0) {//TODO 火屬性防禦
			pc.addFire(-L1MagicDoll.getfireByDoll(_master));
		}
		if (L1MagicDoll.getearthByDoll(_master) != 0) {//TODO 地屬性防禦
			pc.addEarth(-L1MagicDoll.getearthByDoll(_master));
		}
		if (L1MagicDoll.getMrByDoll(_master) != 0) {//TODO 魔法防禦
			pc.addMr(-L1MagicDoll.getMrByDoll(_master));
			pc.sendPackets(new S_SPMR(pc));
		}
		pc.sendPackets(new S_OwnCharStatus(pc));
		_master.getDollList().remove(getId());deleteMe();
	}

	@Override
	public void onPerceive(L1PcInstance perceivedFrom) {
		perceivedFrom.addKnownObject(this);
		perceivedFrom.sendPackets(new S_DollPack(this, perceivedFrom));
	}

	@Override
	public void onItemUse() {
		if (!isActived()) {
			// １００％の確率でヘイストポーション使用
			useItem(USEITEM_HASTE, 100);
		}
	}

	@Override
	public void onGetItem(L1ItemInstance item) {
		if (getNpcTemplate().get_digestitem() > 0) {
			setDigestItem(item);
		}
		if (Arrays.binarySearch(haestPotions, item.getItem().getItemId()) >= 0) {
			useItem(USEITEM_HASTE, 100);
		}
	}

	public int getItemObjId() {
		return _itemObjId;
	}


	public void setItemObjId(int i) {
		_itemObjId = i;
	}

	//TODO 魔法娃娃DB化
	public int getItemId() {
		return _itemId;
	}

	public void setItemId(int i) {
		_itemId = i;
		//TODO 魔法娃娃DB化
	}

}
