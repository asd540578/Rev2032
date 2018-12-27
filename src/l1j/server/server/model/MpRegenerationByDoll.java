package l1j.server.server.model;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SkillSound;//TODO MPR效果
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1MagicDoll;//TODO 魔法娃娃DB化

public class MpRegenerationByDoll extends TimerTask {
	private static Logger _log = Logger.getLogger(MpRegenerationByDoll.class
			.getName());

	private final L1PcInstance _pc;

	public MpRegenerationByDoll(L1PcInstance pc) {
		_pc = pc;
	}

	@Override
	public void run() {
		try {
			if (_pc.isDead()) {
				return;
			}
			regenMp();
		} catch (Throwable e) {
			_log.log(Level.WARNING, e.getLocalizedMessage(), e);
		}
	}

	// TODO 魔法娃娃DB化魔法娃娃額外追加的MPR
	public void regenMp() {
		int newMp = _pc.getCurrentMp() + L1MagicDoll.getMpByDoll(_pc);
		if (newMp < 0) {
			newMp = 0;
		}
	// TODO 魔法娃娃DB化魔法娃娃額外追加的MPR
		_pc.sendPackets(new S_SkillSound(_pc.getId(), 6321));
		_pc.broadcastPacket(new S_SkillSound(_pc.getId(), 6321));
		_pc.setCurrentMp(newMp);
	}
}