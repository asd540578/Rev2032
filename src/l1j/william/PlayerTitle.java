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

package l1j.william;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.william.L1WilliamPlayerTitle;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.utils.SQLUtil;

public class PlayerTitle {
	private static Logger _log = Logger.getLogger(PlayerTitle.class.getName());

	private static PlayerTitle _instance;

	private final HashMap<Integer, L1WilliamPlayerTitle> _levelIndex
	= new HashMap<Integer, L1WilliamPlayerTitle>();

	public static PlayerTitle getInstance() {
		if (_instance == null) {
			_instance = new PlayerTitle();
		}
		return _instance;
	}

	private PlayerTitle() {
		loadPlcyerTitle();
	}

	private void loadPlcyerTitle() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM william_player_title");
			rs = pstm.executeQuery();
			fillPlayerTitle(rs);
		} catch (SQLException e) {
			_log.log(Level.SEVERE, "error while creating william_player_title table",
					e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private void fillPlayerTitle (ResultSet rs) throws SQLException {
		while (rs.next()) {
			int level = rs.getInt("level");
			String title = rs.getString("title");

			L1WilliamPlayerTitle Title = new L1WilliamPlayerTitle(level, title);
			_levelIndex.put(level, Title);
		}
	}

	public L1WilliamPlayerTitle getTemplate(int Level) {
		return _levelIndex.get(Level);
	}


}