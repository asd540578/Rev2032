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

public class S_Unknown1 extends ServerBasePacket {
	public S_Unknown1() {
		writeC(Opcodes.S_OPCODE_LOGINTOGAME);
		writeC(0x03);
		writeC(0x00);
		writeC(0xac);//TODO 3.5封包變更 by99團隊
		writeC(0xc2);//TODO 3.5封包變更by99團隊
		writeC(0x7c);//TODO 3.5封包變更by99團隊
		writeC(0x00);
		writeC(0xc1);//TODO 3.5封包變更by99團隊
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}
}
