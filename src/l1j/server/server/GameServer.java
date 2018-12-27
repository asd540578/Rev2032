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
package l1j.server.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.logging.Logger;
import l1j.server.AinTimeController;
import l1j.server.Config;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.ChatLogTable;
import l1j.server.server.datatables.ClanTable;
import l1j.server.server.datatables.DoorSpawnTable;
import l1j.server.server.datatables.DropItemTable;
import l1j.server.server.datatables.DropTable;
import l1j.server.server.datatables.FurnitureSpawnTable;
import l1j.server.server.datatables.GetBackRestartTable;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.MailTable;
import l1j.server.server.datatables.MapsTable;
import l1j.server.server.datatables.MobGroupTable;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.datatables.NpcActionTable;
import l1j.server.server.datatables.NpcChatTable;
import l1j.server.server.datatables.NpcSpawnTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.datatables.PetTypeTable;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.datatables.ResolventTable;
import l1j.server.server.datatables.ShopTable;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.datatables.SpawnTable;
import l1j.server.server.datatables.SprTable;
import l1j.server.server.datatables.UBSpawnTable;
import l1j.server.server.datatables.WeaponSkillTable;
import l1j.server.server.model.Dungeon;
import l1j.server.server.model.ElementalStoneGenerator;
import l1j.server.server.model.Getback;
import l1j.server.server.model.L1BossCycle;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1DeleteItemOnGround;
import l1j.server.server.model.L1NpcRegenerationTimer;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.model.item.L1TreasureBox;
import l1j.server.server.model.map.L1WorldMap;
import l1j.server.server.model.trap.L1WorldTraps;
import l1j.server.server.utils.SystemUtil;
import l1j.server.server.datatables.MonsterEnhanceTable;//TODO 怪物強化系統by missu0524
import l1j.eric.RandomMobTable;//TODO 新增怪物隨機地圖產生 by eric1300460
import l1j.eric.StartCheckWarTime;//TODO 修正攻城時間如果不是比現在時間久無法更新錯誤 by eric1300460
import l1j.william.L1GameReStart;//TODO 伺服器自動重啟 by 阿傑
import l1j.server.server.datatables.MagicDollTable;//TODO 魔法娃娃DB化

public class GameServer extends Thread {
	private ServerSocket _serverSocket;
	private static Logger _log = Logger.getLogger(GameServer.class.getName());
	private static int YesNoCount = 0;//TODO 3.51C封包還需要在測試
	private int _port;
	private LoginController _loginController;
	private int chatlvl;

	@Override
	public void run() {
		//TODO 血盟房屋治療功能 by williamchen
		(new l1j.william.CureArea(32892,32649,32879,32655,4,15,10,20,0,2231)).start(); //A部分(│)邪惡神殿
		(new l1j.william.CureArea(32879,32649,32892,32655,4,15,10,20,0,2231)).start(); //B部分(─)

		(new l1j.william.CureArea(33128,32933,33118,32940,4,15,10,20,0,2231)).start(); //A部分(│)正義神殿
		(new l1j.william.CureArea(33118,32933,33128,32940,4,15,10,20,0,2231)).start(); //B部分(─)
		//TODO A部分(│) 上點座標(xxxxx,yyyyy)，下點座標(xxxxx,yyyyy)，地圖代號  4 (大陸地圖)
		//TODO B部分(─) 左點座標(xxxxx,yyyyy)，右點座標(xxxxx,yyyyy)，地圖代號  4 (大陸地圖) 
		//TODO A部分(│) + B部分 (─) =一個區域 (┼) 所以不可以分開
		//TODO 其他資料↓
		//TODO 第一個 200 是回一次HP
		//TODO 第二個 200 是回一次MP
		//TODO 第三個 10 是幾秒回一次
		//TODO 第四個 0 治療幾回合, 0代表無限
		//TODO 第五個 2231 是魔法圖案
		//TODO 可以自由增加多個
		System.out.println("使用記憶體： " + SystemUtil.getUsedMemoryMB() + "MB");
		System.out.println("等待玩家連線中...");
		while (true) {
			try {
				Socket socket = _serverSocket.accept();
				System.out.println("嘗試連線的IP " + socket.getInetAddress());
				String host = socket.getInetAddress().getHostAddress();
				if (IpTable.getInstance().isBannedIp(host)) {
					_log.info("banned IP(" + host + ")");
				} else {
					ClientThread client = new ClientThread(socket);
					GeneralThreadPool.getInstance().execute(client);
				}
			} catch (IOException ioexception) {
			}
		}
	}

	private static GameServer _instance;

	private GameServer() {
		super("GameServer");
	}

	public static GameServer getInstance() {
		if (_instance == null) {
			_instance = new GameServer();
		}
		return _instance;
	}

	/** 0.US 3.Twin 4.Japan 5.Chin */
	private String clentLanguage() {
		String[] clentLanguage = new String[] { "US", "", "", "Taiwan","Janpan", "China" };
		return clentLanguage[Config.CLIENT_LANGUAGE];
	}

	public void initialize() throws Exception {
		String s = Config.GAME_SERVER_HOST_NAME;
		double rateXp = Config.RATE_XP;
		double LA = Config.RATE_LA;
		double rateKarma = Config.RATE_KARMA;
		double rateDropItems = Config.RATE_DROP_ITEMS;
		double rateDropAdena = Config.RATE_DROP_ADENA;
		int l = Config.ENCHANT_CHANCE_WEAPON;
		int m = Config.ENCHANT_CHANCE_ARMOR;
		String slang = Config.CLIENT_LANGUAGE_CODE;

		chatlvl = Config.GLOBAL_CHAT_LEVEL;
		_port = Config.GAME_SERVER_PORT;
		if (!"*".equals(s)) {
			InetAddress inetaddress = InetAddress.getByName(s);
			inetaddress.getHostAddress();
			_serverSocket = new ServerSocket(_port, 50, inetaddress);
			System.out.println("伺服器狀態 >> 伺服器啟動");
		} else {
			_serverSocket = new ServerSocket(_port);
			System.out.println("伺服器狀態 >> 伺服器啟動");
		}
		System.out.println("伺服器輸出語言: " + (slang));
		System.out.println("伺服器介面【" + clentLanguage() + "】");
		System.out.println("經驗值: " + (rateXp) + "倍");
		System.out.println("正義值: " + (LA) + "倍 ");
		System.out.println("友好度: " + (rateKarma) + "倍 ");
		System.out.println("掉寶率: " + (rateDropItems) + "倍 ");
		System.out.println("取得金幣: " + (rateDropAdena) + "倍");
		System.out.println("全體頻道可使用等級 Lv." + (chatlvl));
		System.out.println("衝武器 / 防具機率: " + (l) + "% / " + (m) + "%");
		if (Config.ALT_NONPVP) { // Non-PvP設定
			System.out.println("殺人設定：【可以】【全體聊天】： LV " + (chatlvl));
		} else {
			System.out.println("殺人設定： 【無法】【全體聊天】：LV " + (chatlvl));
		}
		// TODO 轉生藥水是否開啟或關閉
		if (Config.ALT_REVIVAL_POTION) {
			System.out.println("轉生藥水取得：開啟");
		} else {
			System.out.println("轉生藥水取得：關閉");
			// TODO 轉生藥水是否開啟或關閉
		}
		//TODO 轉生血魔保留
		if (Config.REVIVAL_POTION == 1) {
			System.out.println("轉生血魔保留：10%");
		} else if (Config.REVIVAL_POTION == 2) {
			System.out.println("轉生血魔保留：20%");
		} else if (Config.REVIVAL_POTION == 3) {
			System.out.println("轉生血魔保留：30%");
		} else if (Config.REVIVAL_POTION == 4) {
			System.out.println("轉生血魔保留：40%");
		} else if (Config.REVIVAL_POTION == 5) {
			System.out.println("轉生血魔保留：50%");
		} else if (Config.REVIVAL_POTION == 6) {
			System.out.println("轉生血魔保留：60%");
		} else if (Config.REVIVAL_POTION == 7) {
			System.out.println("轉生血魔保留：70%");
		} else if (Config.REVIVAL_POTION == 8) {
			System.out.println("轉生血魔保留：80%");
		} else if (Config.REVIVAL_POTION == 9) {
			System.out.println("轉生血魔保留：90%");
		} else if (Config.REVIVAL_POTION == 10) {
			System.out.println("轉生血魔保留：100%");
		}
		//TODO 轉生血魔保留
		System.out.println("★===========================================================★");
		System.out.println("模 擬 器 版 本3.51C㊣ Rev2032 ㊣ ");	
		System.out.println("繁 體 中 文 化 + 整 合 By0968026609 僅 供 個 人 學 習 之 用");		
		System.out.println("感 謝 很 多 團 對 釋 出 源 碼 和 還 有 各 位 大 大 的 源 碼 和 教 學");		
		System.out.println("沒 有 他 們 今 天 也 不 會 有 這 一 版 出 現 在 此 感 謝 分享(^▽^)");
		int maxOnlineUsers = Config.MAX_ONLINE_USERS;
		System.out.println("連線人數限制： 最多" + (maxOnlineUsers) + "人");
		System.out.println("★===========================================================★");
		IdFactory.getInstance();
		L1WorldMap.getInstance();
		_loginController = LoginController.getInstance();
		_loginController.setMaxAllowedOnlinePlayers(maxOnlineUsers);

		// 全キャラクターネームロード
		CharacterTable.getInstance().loadAllCharName();

		// オンライン状態リセット
		CharacterTable.clearOnlineStatus();

		// ゲーム時間時計
		L1GameTimeClock.init();

		//TODO 伺服器自動重啟 by阿傑
		if (Config.REST_TIME > 0) {
			L1GameReStart.init();
		}

		// UBタイムコントローラー
		UbTimeController ubTimeContoroller = UbTimeController.getInstance();
		GeneralThreadPool.getInstance().execute(ubTimeContoroller);

		// 戦争タイムコントローラー
		WarTimeController warTimeController = WarTimeController.getInstance();
		GeneralThreadPool.getInstance().execute(warTimeController);

		// 精霊の石生成
		if (Config.ELEMENTAL_STONE_AMOUNT > 0) {
			ElementalStoneGenerator elementalStoneGenerator = ElementalStoneGenerator
					.getInstance();
			GeneralThreadPool.getInstance().execute(elementalStoneGenerator);
		}

		// ホームタウン
		HomeTownTimeController.getInstance();

		// アジト競売タイムコントローラー
		AuctionTimeController auctionTimeController = AuctionTimeController
				.getInstance();
		GeneralThreadPool.getInstance().execute(auctionTimeController);

		// アジト税金タイムコントローラー
		HouseTaxTimeController houseTaxTimeController = HouseTaxTimeController
				.getInstance();
		GeneralThreadPool.getInstance().execute(houseTaxTimeController);

		// 釣りタイムコントローラー
		FishingTimeController fishingTimeController = FishingTimeController
				.getInstance();
		GeneralThreadPool.getInstance().execute(fishingTimeController);

		// NPCチャットタイムコントローラー
		NpcChatTimeController npcChatTimeController = NpcChatTimeController
				.getInstance();
		GeneralThreadPool.getInstance().execute(npcChatTimeController);

		// ライトタイムコントローラー
		LightTimeController lightTimeController = LightTimeController
				.getInstance();
		GeneralThreadPool.getInstance().execute(lightTimeController);

		// TODO 殷海薩的祝福
		AinTimeController ainTimeController = AinTimeController.getInstance();
		GeneralThreadPool.getInstance().execute(ainTimeController);

		Announcements.getInstance();
		// 循環公告 by阿傑
		if (Config.Use_Show_Announcecycle) {
			Announcecycle.getInstance();
		}
		NpcTable.getInstance();
		//TODO 怪物強化系統
		MonsterEnhanceTable.getInstance();
		//TODO 怪物強化系統
		L1DeleteItemOnGround deleteitem = new L1DeleteItemOnGround();
		deleteitem.initialize();

		if (!NpcTable.getInstance().isInitialized()) {
			throw new Exception("Could not initialize the npc table");
		}
		SpawnTable.getInstance();
		MobGroupTable.getInstance();
		SkillsTable.getInstance();
		PolyTable.getInstance();
		ItemTable.getInstance();
		DropTable.getInstance();
		DropItemTable.getInstance();
		ShopTable.getInstance();
		NPCTalkDataTable.getInstance();
		L1World.getInstance();
		L1WorldTraps.getInstance();
		Dungeon.getInstance();
		NpcSpawnTable.getInstance();
		IpTable.getInstance();
		MapsTable.getInstance();
		UBSpawnTable.getInstance();
		PetTable.getInstance();
		ClanTable.getInstance();
		StartCheckWarTime.getInstance();//TODO 修正攻城時間如果不是比現在時間久無法更新錯誤 by eric1300460
		CastleTable.getInstance();
		L1CastleLocation.setCastleTaxRate(); // これはCastleTable初期化後でなければいけない
		GetBackRestartTable.getInstance();
		DoorSpawnTable.getInstance();
		GeneralThreadPool.getInstance();
		L1NpcRegenerationTimer.getInstance();
		ChatLogTable.getInstance();
		WeaponSkillTable.getInstance();
		NpcActionTable.load();
		GMCommandsConfig.load();
		Getback.loadGetBack();
		PetTypeTable.load();
		L1BossCycle.load();
		L1TreasureBox.load();
		SprTable.getInstance();
		ResolventTable.getInstance();
		FurnitureSpawnTable.getInstance();
		NpcChatTable.getInstance();
		MailTable.getInstance();
		MagicDollTable.getInstance();//TODO 魔法娃娃DB化
		//TODO 開始怪物隨機出生點
		RandomMobTable.getInstance().startRandomMob();
		System.out
		.println("★===========================================================★");
		System.out.println("	《模擬器啟動完畢》");
		System.out
		.println("★===========================================================★");
		Runtime.getRuntime().addShutdownHook(Shutdown.getInstance());
		this.start();
	}

	/**
	 * オンライン中のプレイヤー全てに対してkick、キャラクター情報の保存をする。
	 */
	public void disconnectAllCharacters() {
		Collection<L1PcInstance> players = L1World.getInstance()
				.getAllPlayers();
		for (L1PcInstance pc : players) {
			pc.getNetConnection().setActiveChar(null);
			pc.getNetConnection().kick();
		}
		// 全員Kickした後に保存処理をする
		for (L1PcInstance pc : players) {
			ClientThread.quitGame(pc);
			L1World.getInstance().removeObject(pc);
		}
	}

	private class ServerShutdownThread extends Thread {
		private final int _secondsCount;

		public ServerShutdownThread(int secondsCount) {
			_secondsCount = secondsCount;
		}

		@Override
		public void run() {
			L1World world = L1World.getInstance();
			try {
				int secondsCount = _secondsCount;
				world.broadcastServerMessage("伺服器即將關閉。");
				world.broadcastServerMessage("請玩家移動到安全區域先行登出");
				while (0 < secondsCount) {
					if (secondsCount <= 30) {
						world.broadcastServerMessage("伺服器將在" + secondsCount+ "秒後關閉，請玩家移動到安全區域先行登出。");
					} else {
						if (secondsCount % 60 == 0) {
							world.broadcastServerMessage("伺服器將在" + secondsCount/ 60 + "分鐘後關閉。");
						}
					}
					Thread.sleep(1000);
					secondsCount--;
				}
				shutdown();
			} catch (InterruptedException e) {
				world.broadcastServerMessage("已取消伺服器關機。伺服器將會正常運作。");
				return;
			}
		}
	}

	private ServerShutdownThread _shutdownThread = null;

	public synchronized void shutdownWithCountdown(int secondsCount) {
		if (_shutdownThread != null) {
			// 既にシャットダウン要求が行われている
			// TODO エラー通知が必要かもしれない
			return;
		}
		_shutdownThread = new ServerShutdownThread(secondsCount);
		GeneralThreadPool.getInstance().execute(_shutdownThread);
	}

	public void shutdown() {
		disconnectAllCharacters();
		System.exit(0);
	}

	public synchronized void abortShutdown() {
		if (_shutdownThread == null) {
			// シャットダウン要求が行われていない
			// TODO エラー通知が必要かもしれない
			return;
		}

		_shutdownThread.interrupt();
		_shutdownThread = null;
	}

	/**
	 *3.51C封包還需要在測試
	 *@return
	 */
	public static int getYesNoCount() {
		YesNoCount += 1;
		return YesNoCount;
	}
}
