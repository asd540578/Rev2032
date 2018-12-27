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
 * http://TODOwww.gnu.org/copyleft/gpl.html
 */

package l1j.server.server.clientpackets;

import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;

public class C_Rank extends ClientBasePacket {

	private static final String C_RANK = "[C] C_Rank";
	private static Logger _log = Logger.getLogger(C_Rank.class.getName());

	public C_Rank(byte abyte0[], ClientThread clientthread)
			throws Exception {
		super(abyte0);

		int data = readC();
		int rank = readC();
		String name = readS();

		L1PcInstance pc = clientthread.getActiveChar();
		L1PcInstance targetPc = L1World.getInstance().getPlayer(name);
		
		if (pc == null) {
			return;
		}
		
		switch (data) {
		case 1:
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan == null) {
				return;
			}

			if ((rank < 1) && (3 < rank)) {
				//TODO 請輸入想要變更階級的人的名稱與階級。[階級 = 守護騎士、一般、見習]
				pc.sendPackets(new S_ServerMessage(781));
				return;
			}

			if (pc.isCrown()) { //TODO 君主
				if (pc.getId() != clan.getLeaderId()) { //TODO 血盟主
					pc.sendPackets(new S_ServerMessage(785)); //TODO 你不再是君主了
					return;
				}
			} else {
				pc.sendPackets(new S_ServerMessage(518)); //TODO 血盟君主才可使用此命令。
				return;
			}

			if (targetPc != null) {
				if (pc.getClanid() == targetPc.getClanid()) {
					try {
						targetPc.setClanRank(rank);
						targetPc.save();
						targetPc.sendPackets(new S_PacketBox(S_PacketBox.MSG_RANK_CHANGED, rank));
				}
				catch (Exception e) {
					_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			} else {
				pc.sendPackets(new S_ServerMessage(201, name)); //TODO %0 不是你的血盟成員
				return;
			}
		} else {
			L1PcInstance restorePc = CharacterTable.getInstance().restoreCharacter(name);
			if ((restorePc != null) && (restorePc.getClanid() == pc.getClanid())) {
				try {
					restorePc.setClanRank(rank);
					restorePc.save();
				} 
				catch (Exception e) {
					_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			} else {
					pc.sendPackets(new S_ServerMessage(109, name));//TODO 沒有叫%0的人。
					return;
				}
			}
			break;
		case 2:
		case 3:
		case 4:
			break;
			
		case 5://生存吶喊(CTRL+E)
			if (pc.getWeapon() == null) {
				pc.sendPackets(new S_ServerMessage(1973));
				return;
			}
			if (pc.getCurrentHp() >= pc.getMaxHp()) {
				pc.sendPackets(new S_ServerMessage(1974));//TODO 還無法使用生存的吶喊。 
				return;
			}
			if (pc.get_food() >= 225 && pc.getWeapon() != null) {
				final Random random = new Random();
				long time = pc.get_h_time();
				final Calendar cal = Calendar.getInstance();
				long h_time = cal.getTimeInMillis() / 1000;//TODO 換算為秒
				int n = (int) ((h_time - time) / 60);//TODO 換算為分
				int Gfxid_1 = 0;
				int Gfxid_2 = 0;
				int addhp = 0;
				if (n <= 0) {
					pc.sendPackets(new S_ServerMessage(1974));//TODO 還無法使用生存的吶喊。 
					return;
				} else if (n >= 1 && n <= 29) {
					Gfxid_1 = 8907;
					Gfxid_2 = 8683;
					addhp = (int) (pc.getMaxHp() * (double)(n / 100.0D));
					
				} else if (n >= 30) {
					int lv = pc.getWeapon().getEnchantLevel();
					if (lv <= 0 || (lv >= 1 && lv <= 6)) {
						Gfxid_1 = 8907;
						Gfxid_2 = 8684;
						addhp = (int) (pc.getMaxHp() * (double)((random.nextInt(20) + 20) / 100.0D));
					} else if (lv == 7 || lv == 8){
						Gfxid_1 = 8909;
						Gfxid_2 = 8685;
						addhp = (int) (pc.getMaxHp() * (double)((random.nextInt(20) + 30) / 100.0D));
					} else if (lv == 9 || lv == 10) {
						Gfxid_1 = 8910;
						Gfxid_2 = 8773;
						addhp = (int) (pc.getMaxHp() * (double)((random.nextInt(10) + 50) / 100.0D));
					} else if (lv  >= 11) {
						Gfxid_1 = 8908;
						Gfxid_2 = 8686;
						addhp = (int) (pc.getMaxHp() * (double)(0.7));
					}
					
					S_SkillSound spr1 = new S_SkillSound(pc.getId(), Gfxid_1);
					S_SkillSound spr2 = new S_SkillSound(pc.getId(), Gfxid_2);
					pc.sendPackets(spr1);
					pc.broadcastPacket(spr1);
					pc.sendPackets(spr2);
					pc.broadcastPacket(spr2);
				}
				
				if (addhp != 0) {
					pc.set_food((short) 0);
					pc.sendPackets(new S_PacketBox(S_PacketBox.FOOD, (short) 0));
					pc.setCurrentHp(pc.getCurrentHp() + addhp);
				}
			}
			break;
			
		case 6://生存吶喊(Alt+0)
			if (pc.getWeapon() == null) {
				pc.sendPackets(new S_ServerMessage(1973));//TODO 必須裝備上武器才可使用。  
				return;
			}
			int lv = pc.getWeapon().getEnchantLevel();
			int gfx = 8684;
			if (lv <= 0 || (lv >= 1 && lv <= 6)) {
				gfx = 8684;
			} else if (lv == 7 || lv == 8){
				gfx = 8685;
			} else if (lv == 9 || lv == 10) {
				gfx = 8773;
			} else if (lv  >= 11) {
				gfx = 8686;
			}
			S_SkillSound spr = new S_SkillSound(pc.getId(), gfx);
			pc.sendPackets(spr);
			pc.broadcastPacket(spr);
			break;
		}
	}

	@Override
	public String getType() {
		return C_RANK;
	}
}
