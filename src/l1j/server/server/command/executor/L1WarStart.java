/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
* the Free Software Foundation; either version 2, or (at your option) 
* any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of .
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place - Suite 330, Boston,
* 02111-1307, USA.
*
* http://www.gnu.org/copyleft/gpl.html
 */
package l1j.server.server.command.executor;

import java.util.Calendar;
import java.util.logging.Logger;
import java.util.StringTokenizer;
import java.util.TimeZone;

import l1j.server.Config;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.L1World;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.templates.L1Castle;

//TODO 增加GM指令(修改攻城時間) 
 public class L1WarStart implements L1CommandExecutor{
	private static Logger _log = Logger.getLogger(L1WarStart.class.getName());
	private static L1Castle _l1castle;
	private L1WarStart() {
	}
	public static L1CommandExecutor getInstance() {
	return new L1WarStart();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
	StringBuilder AllCastleid = new StringBuilder();
	AllCastleid.append("[城堡ID]1:肯特,2:妖魔,3:風木,4:奇岩,5:海音,6:侏儒,7:亞丁,8:狄亞得要塞");
	try {
	StringTokenizer st = new StringTokenizer(arg);
	int time = 0;
	try {
	time = Integer.parseInt(st.nextToken());
	} catch (NumberFormatException e1) {
	pc.sendPackets(new S_SystemMessage(cmdName + " 幾分 ←請輸入數字。 "));
	return;
	} 
	int castleid = 0;
	try {
	if (st.hasMoreTokens()) {
	castleid = Integer.parseInt(st.nextToken());
	}
	} catch (NumberFormatException e2) {
	pc.sendPackets(new S_SystemMessage(cmdName + " 幾分 城堡ID ←請輸入數字。 "));
	pc.sendPackets(new S_SystemMessage(AllCastleid.toString()));
	return;
	}
	TimeZone _timezone = TimeZone.getTimeZone(Config.TIME_ZONE);
	Calendar getTime = Calendar.getInstance(_timezone);
	getTime.setTimeInMillis(getTime.getTimeInMillis() + time*60*1000);
	L1Castle[] _l1castle = new L1Castle[8];
	for (int j = 0; j < _l1castle.length; j++) {
	if (castleid == j + 1) {
	_l1castle[j] = CastleTable.getInstance().getCastleTable(j + 1);
	_l1castle[j].setWarTime(getTime);
	CastleTable.getInstance().updateCastle(_l1castle[j]);
	L1World.getInstance().broadcastPacketToAll(new S_SystemMessage(time + " 分鐘後:"));
	L1World.getInstance().broadcastPacketToAll(new S_PacketBox(S_PacketBox.MSG_WAR_BEGIN, j + 1));
	} else if (castleid < 1) { 
	_l1castle[j] = CastleTable.getInstance().getCastleTable(j + 1);
	_l1castle[j].setWarTime(getTime);
	CastleTable.getInstance().updateCastle(_l1castle[j]);
	}
	}
	if (castleid < 1) {
	L1World.getInstance().broadcastPacketToAll(new S_SystemMessage(time + " 分鐘後 所有的城堡 開始攻城戰！"));
	}
	} catch (Exception e3) {
	pc.sendPackets(new S_SystemMessage(cmdName + " 幾分 城堡ID ←正確輸入。 "));
	pc.sendPackets(new S_SystemMessage(AllCastleid.toString()));
		}
	}
}
