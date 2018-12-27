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

import l1j.server.server.model.Instance.L1PcInstance;

public class L1WilliamPlayerTitle {

	private int _level;
	private String _title;

	public L1WilliamPlayerTitle(int Level, String Title) {
		_level = Level;
		_title = Title;
	}

	public int getLevel() {
		return _level;
	}

	public String getTitle() {
		return _title;
	}

	public static int CheckLevel(int Level) {
		L1WilliamPlayerTitle Title = PlayerTitle.getInstance().getTemplate(Level);

		if (Title == null) {
			return 0;
		}

		int level = Title.getLevel();

		return level;
	}

	public static String getTitle(L1PcInstance pc, int Level) {
		L1WilliamPlayerTitle title = PlayerTitle.getInstance().getTemplate(Level);

		String Title = "";

		if (title == null) {
			return "";
		}

		int getLevel = title.getLevel();
		int PcLevel = pc.getLevel();

		if (PcLevel >= getLevel) {
			Title = title.getTitle();
		}

		return Title;
	}

}