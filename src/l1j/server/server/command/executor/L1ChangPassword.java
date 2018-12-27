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
package l1j.server.server.command.executor;

import java.util.StringTokenizer;
import java.util.logging.Logger;
import l1j.server.server.model.L1World;
import l1j.server.server.Account;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import l1j.server.Base64;


public class L1ChangPassword implements L1CommandExecutor {
	private static Logger _log = Logger.getLogger(L1ChangPassword.class.getName());

	private L1ChangPassword() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1ChangPassword();
	}

	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			StringTokenizer st = new StringTokenizer(arg);
			String name = st.nextToken();
			String password = st.nextToken();

			L1PcInstance target = L1World.getInstance().getPlayer(name);

			String newPassword = "";
			try {
				newPassword = encodePassword(password);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (target != null) {
				Account.changpassword(target.getAccountName(), newPassword);
				pc.sendPackets(new S_SystemMessage("玩家【"+ target.getName() +"】的密碼以被修改為【"+ password +"】"));
				target.sendPackets(new S_SystemMessage("你的密碼以被修改GM為【"+ password +"】"));
			} else {
				pc.sendPackets(new S_SystemMessage(name + "不在線上。"));
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(cmdName + " 請輸入玩家名稱 密碼 ←請輸入。"));
		}
	}

	private static String encodePassword(final String rawPassword)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] buf = rawPassword.getBytes("UTF-8");
		buf = MessageDigest.getInstance("SHA").digest(buf);
		return Base64.encodeBytes(buf);
	}

}