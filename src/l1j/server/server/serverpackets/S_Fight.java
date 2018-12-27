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

package l1j.server.server.serverpackets;
import l1j.server.server.Opcodes;
public class S_Fight extends ServerBasePacket {
	private static final String S_FIGHT = "[S] S_Fight";

	private byte[] _byte = null;

	//TODO 開啟
	public static final int FLAG_ON = 1;

	//TODO 關閉
	public static final int FLAG_OFF = 0;

	//TODO 正義第一階段(10000 ~ 19999)
	public static final int TYPE_JUSTICE_LEVEL1 = 0;

	//TODO 正義第二階段(20000 ~ 29999)
	public static final int TYPE_JUSTICE_LEVEL2 = 1;

	//TODO 正義第三階段(30000 ~ 32767)
	public static final int TYPE_JUSTICE_LEVEL3 = 2;

	//TODO 邪惡第一階段(-10000 ~ -19999)
	public static final int TYPE_EVIL_LEVEL1 = 3;

	//TODO 邪惡第二階段(-20000 ~ -29999)
	public static final int TYPE_EVIL_LEVEL2 = 4;

	//TODO 邪惡第三階段(-30000 ~ -32768)
	public static final int TYPE_EVIL_LEVEL3 = 5;

	//TODO 遭遇的守護(新手保護)
	public static final int TYPE_ENCOUNTER = 6;

	public S_Fight(int type, int flag) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(0x72);
		writeD(type);
		writeD((flag == FLAG_OFF) ? FLAG_OFF : FLAG_ON);
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	@Override
	public String getType() {
		return S_FIGHT;
	}
}
