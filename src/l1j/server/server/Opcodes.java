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
 * http://TODO TODOwww.gnu.org/copyleft/gpl.html
 */

package l1j.server.server;

public class Opcodes {

	public Opcodes() {
	}
	/** 3.5C Client Packet */
	public static final int C_OPCODE_BANPARTY = 0;//TODO 請求驅逐隊伍
	public static final int C_OPCODE_SHIP = 1;//TODO 請求下船
	public static final int C_OPCODE_TELEPORTLOCK = 2;//TODO 玩家傳送鎖定(回溯檢測用)
	public static final int C_OPCODE_SKILLBUYOK = 4;//TODO 請求學習魔法
	public static final int C_OPCODE_ADDBUDDY = 5;//TODO 請求新增好友
	public static final int C_OPCODE_WAREHOUSELOCK = 8;//TODO 請求變更倉庫密碼 && 送出倉庫密碼
	public static final int C_OPCODE_DROPITEM = 9;//TODO 請求丟棄物品
	public static final int C_OPCODE_BOARDNEXT = 11;//TODO 請求查看下一頁佈告欄的訊息
	public static final int C_OPCODE_PETMENU = 12;//TODO 請求寵物回報選單
	public static final int C_OPCODE_JOINCLAN = 13;//TODO 請求加入血盟
	public static final int C_OPCODE_GIVEITEM = 14;//TODO 請求給予物品
	public static final int C_OPCODE_USESKILL = 16;//TODO 請求使用技能
	public static final int C_OPCODE_RESULT = 17;//TODO 請求取得列表中的項目
	public static final int C_OPCODE_DELETECHAR = 19;//TODO 請求刪除角色
	public static final int C_OPCODE_BOARD = 21;//TODO 請求瀏覽公佈欄
	public static final int C_OPCODE_TRADEADDCANCEL = 23;//TODO 請求取消交易
	public static final int C_OPCODE_USEITEM = 24;//TODO 請求使用物品
	public static final int C_OPCODE_PROPOSE = 25;//TODO 請求結婚
	public static final int C_OPCODE_BOARDDELETE = 26;//TODO 請求刪除公佈欄內容
	public static final int C_OPCODE_CHANGEHEADING = 27;//TODO 請求改變角色面向
	public static final int C_OPCODE_BOOKMARKDELETE = 28;//TODO 請求刪除記憶座標
	public static final int C_OPCODE_SELECTLIST = 29;//TODO 請求修理道具
	public static final int C_OPCODE_SELECTTARGET = 32;//TODO 請求攻擊指定物件(寵物&召喚)
	public static final int C_OPCODE_DELEXCLUDE = 33;//TODO 請求使用開啟名單(拒絕指定人物訊息)
	public static final int C_OPCODE_BUDDYLIST = 34;//TODO 請求查詢好友名單
	public static final int C_OPCODE_SENDLOCATION = 35;//TODO 請求傳送位置
	public static final int C_OPCODE_TITLE = 37;//TODO 請求賦予封號
	public static final int C_OPCODE_TRADEADDOK = 38;//TODO 請求完成交易
	public static final int C_OPCODE_EMBLEM = 39;//TODO 請求上傳盟徽
	public static final int C_OPCODE_MOVECHAR = 40;//TODO 請求移動角色
	public static final int C_OPCODE_CHECKPK = 41;//TODO 請求查詢PK次數
	public static final int C_OPCODE_COMMONCLICK = 42;//TODO 請求下一步 (伺服器公告)
	public static final int C_OPCODE_QUITGAME = 43;//TODO 請求離開遊戲
	public static final int C_OPCODE_DEPOSIT = 44;//TODO 請求將資金存入城堡寶庫
	public static final int C_OPCODE_BEANFUN_LOGIN = 45;//TODO 請求使用樂豆自動登錄伺服器 (未實裝)
	public static final int C_OPCODE_BOOKMARK = 46;//TODO 請求增加記憶座標
	public static final int C_OPCODE_SHOP = 47;//TODO 請求開設個人商店
	public static final int C_OPCODE_CHATWHISPER = 48;//TODO 請求使用密語聊天頻道
	public static final int C_OPCODE_PRIVATESHOPLIST = 49;//TODO 請求購買指定的個人商店商品
	public static final int C_OPCODE_EXTCOMMAND = 52;//TODO 請求角色表情動作
	public static final int C_OPCODE_CLIENTVERSION = 54;//TODO 請求驗證客戶端版本
	public static final int C_OPCODE_LOGINTOSERVER = 55;//TODO 請求登錄角色
	public static final int C_OPCODE_ATTR = 56;//TODO 請求點選項目的結果
	public static final int C_OPCODE_NPCTALK = 57;//TODO 請求對話視窗
	public static final int C_OPCODE_NEWCHAR = 58;//TODO 請求創造角色
	public static final int C_OPCODE_TRADE = 59;//TODO 請求交易
	public static final int C_OPCODE_DELBUDDY = 61;//TODO 請求刪除好友
	public static final int C_OPCODE_BANCLAN = 62;//TODO 請求驅逐血盟成員
	public static final int C_OPCODE_FISHCLICK = 63;//TODO 請求釣魚收竿
	public static final int C_OPCODE_LEAVECLANE = 65;//TODO 請求離開血盟
	public static final int C_OPCODE_TAXRATE = 66;//TODO 請求配置稅收
	public static final int C_OPCODE_RESTART = 70;//TODO 請求重新開始
	public static final int C_OPCODE_ENTERPORTAL = 71;//TODO 請求傳送 (進入地監)
	public static final int C_OPCODE_SKILLBUY = 72;//TODO 請求查詢可以學習的魔法清單
	public static final int C_OPCODE_TELEPORT = 73;//TODO 請求解除傳送鎖定
	public static final int C_OPCODE_DELETEINVENTORYITEM = 74;//TODO 請求刪除物品
	public static final int C_OPCODE_CHAT = 75;//TODO 請求使用一般聊天頻道
	public static final int C_OPCODE_ARROWATTACK = 77;//TODO 請求使用遠距攻擊
	public static final int C_OPCODE_USEPETITEM = 78;//TODO 請求使用寵物裝備
	public static final int C_OPCODE_EXCLUDE = 79;//TODO 請求使用拒絕名單(開啟指定人物訊息)
	public static final int C_OPCODE_FIX_WEAPON_LIST = 80;//TODO 請求查詢損壞的道具
	public static final int C_OPCODE_PLEDGE = 84;//TODO 請求查詢血盟成員
	public static final int C_OPCODE_NPCACTION = 87;//TODO 請求執行對話視窗的動作
	public static final int C_OPCODE_EXIT_GHOST = 90;//TODO 請求退出觀看模式
	public static final int C_OPCODE_CALL = 91;//TODO 請求傳送至指定的外掛使用者身旁
	public static final int C_OPCODE_MAIL = 92;//TODO 請求打開郵箱
	public static final int C_OPCODE_WHO = 93;//TODO 請求查詢遊戲人數
	public static final int C_OPCODE_PICKUPITEM = 94;//TODO 請求拾取物品
	public static final int C_OPCODE_CHARRESET = 95;//TODO 要求重置人物點數
	public static final int C_OPCODE_AMOUNT = 96;//TODO 請求傳回選取的數量
	public static final int C_OPCODE_RANK = 103;//TODO 請求給予角色血盟階級
	public static final int C_OPCODE_FIGHT = 104;//TODO 請求決鬥
	public static final int C_OPCODE_DRAWAL = 105;//TODO 請求領取城堡寶庫資金
	public static final int C_OPCODE_KEEPALIVE = 106;//TODO 請求更新連線狀態
	public static final int C_OPCODE_CHARACTERCONFIG = 108;//TODO 請求紀錄快速鍵
	public static final int C_OPCODE_CHATGLOBAL = 109;//TODO 請求使用廣播聊天頻道
	public static final int C_OPCODE_WAR = 110;//TODO 請求宣戰
	public static final int C_OPCODE_CREATECLAN = 112;//TODO 請求創立血盟
	public static final int C_OPCODE_LOGINTOSERVEROK = 114;//TODO 請求配置角色設定
	public static final int C_OPCODE_LOGINPACKET = 115;//TODO 請求登錄伺服器
	public static final int C_OPCODE_DOOR = 116;//TODO 請求開門或關門
	public static final int C_OPCODE_ATTACK = 117;//TODO 請求攻擊對象
	public static final int C_OPCODE_TRADEADDITEM = 119;//TODO 請求交易(添加物品)
	public static final int C_OPCODE_SMS = 121;//TODO 請求傳送簡訊
	public static final int C_OPCODE_LEAVEPARTY = 123;//TODO 請求退出隊伍
	public static final int C_OPCODE_CASTLESECURITY = 124;//TODO 請求管理城內治安
	public static final int C_OPCODE_BOARDREAD = 125;//TODO 請求閱讀佈告單個欄訊息
	public static final int C_OPCODE_CHANGECHAR = 126;//TODO 請求切換角色
	public static final int C_OPCODE_PARTYLIST = 127;//TODO 請求查詢隊伍成員
	public static final int C_OPCODE_BOARDWRITE = 129;//TODO 請求撰寫新的佈告欄訊息
	public static final int C_OPCODE_CREATEPARTY = 130;//TODO 請求邀請加入隊伍或建立隊伍
	public static final int C_OPCODE_CAHTPARTY = 131;//TODO 請求聊天隊伍

	/** 3.5C Server Packet */
	public static final int S_OPCODE_PUTSOLDIER = 0;//TODO 配置已的僱用傭兵
	public static final int S_OPCODE_SKILLBUY_2 = 1;//TODO 學習魔法 (何侖)
	public static final int S_OPCODE_SHOWSHOPSELLLIST = 2;//TODO 商店收購清單
	public static final int S_OPCODE_PINGTIME = 3;//TODO Ping Time
	public static final int S_OPCODE_DETELECHAROK = 4;//TODO 角色移除 (立即或非立即)
	public static final int S_OPCODE_CHANGEHEADING = 5;//TODO 物件面向
	public static final int S_OPCODE_SKILLICONSHIELD = 6;//TODO 魔法效果 : 防禦纇
	public static final int S_OPCODE_RANGESKILLS = 7;//TODO 範圍魔法
	public static final int S_OPCODE_INPUTAMOUNT = 8;//TODO 輸入數量要產生的數量
	public static final int S_OPCODE_DELSKILL = 9;//TODO 移除指定的魔法
	public static final int S_OPCODE_PUTHIRESOLDIER = 10;//TODO 配置傭兵
	public static final int S_OPCODE_SKILLHASTE = 11;//TODO 魔法或物品產生的加速效果
	public static final int S_OPCODE_CHARAMOUNT = 12;//TODO 角色列表
	public static final int S_OPCODE_BOOKMARKS = 13;//TODO 插入記憶座標
	public static final int S_OPCODE_EXCEPTION_3 = 14;//TODO 例外事件_3
	public static final int S_OPCODE_MPUPDATE = 15;//TODO 魔力與最大魔力更新
	public static final int S_OPCODE_EXCEPTION_2 = 16;//TODO 例外事件_2
	public static final int S_OPCODE_SERVERVERSION = 17;//TODO 伺服器版本
	public static final int S_OPCODE_CHARVISUALUPDATE = 18;//TODO 切換物件外觀動作
	public static final int S_OPCODE_PARALYSIS = 19;//TODO 魔法效果 : 麻痺類
	public static final int S_OPCODE_MOVELOCK = 20;//TODO 移動鎖定封包(疑似開加速器則會用這個封包將玩家鎖定)
	public static final int S_OPCODE_DELETEINVENTORYITEM = 21;//TODO 刪除物品
	public static final int S_OPCODE_NEW1 = 22;//TODO 不明封包 (會變更頭銜)
	//TODO 23 彷彿是伺服器選單
	public static final int S_OPCODE_HIRESOLDIER = 24;//TODO 僱用傭兵
	public static final int S_OPCODE_PINKNAME = 25;//TODO 角色名稱變紫色
	public static final int S_OPCODE_TELEPORT = 26;//TODO 傳送術或瞬間移動卷軸-傳送鎖定
	public static final int S_OPCODE_INITPACKET = 27;//TODO 初始化演算法
	public static final int S_OPCODE_CHANGENAME = 28;//TODO 改變物件名稱
	public static final int S_OPCODE_NEWCHARWRONG = 29;//TODO 角色創造例外
	public static final int S_OPCODE_DRAWAL = 30;//TODO 領取城堡寶庫資金
	public static final int S_OPCODE_MAPID = 32;//TODO 更新現在的地圖
	public static final int S_OPCODE_UNDERWATER = 32;//TODO 更新現在的地圖 （水中）
	public static final int S_OPCODE_TRADEADDITEM = 33;//TODO 增加交易物品封包
	public static final int S_OPCODE_OWNCHARSTATUS = 34;//TODO 角色屬性與能力值
	public static final int S_OPCODE_EXCEPTION_1 = 35;//TODO 例外事件_1
	public static final int S_OPCODE_COMMONNEWS = 36;//TODO 公告視窗
	public static final int S_OPCODE_TRUETARGET = 37;//TODO 法術效果-精準目標
	public static final int S_OPCODE_HPUPDATE = 38;//TODO 體力與最大體力更新
	public static final int S_OPCODE_TRADESTATUS = 39;//TODO 交易是否成功
	public static final int S_OPCODE_SHOWSHOPBUYLIST = 40;//TODO 商店販售清單
	public static final int S_OPCODE_LOGINTOGAME = 41;//TODO 進入遊戲
	public static final int S_OPCODE_INVIS = 42;//TODO 物件隱形或現形
	public static final int S_OPCODE_CHARRESET = 43;//TODO 角色重置
	public static final int S_OPCODE_PETCTRL = 43;//TODO 寵物控制介面移除
	public static final int S_OPCODE_WARTIME = 44;//TODO 設定圍成時間
	public static final int S_OPCODE_IDENTIFYDESC = 45;//TODO 物品資訊訊息
	public static final int S_OPCODE_BLUEMESSAGE = 46;//TODO 紅色訊息
	public static final int S_OPCODE_POISON = 47;//TODO 魔法效果:中毒
	public static final int S_OPCODE_GAMETIME = 48;//TODO 更新目前遊戲時間
	public static final int S_OPCODE_SKILLBUY = 50;//TODO 魔法購買 (金幣)
	public static final int S_OPCODE_TRADE = 51;//TODO 交易封包
	public static final int S_OPCODE_WAR = 52;//TODO 血盟戰爭
	public static final int S_OPCODE_NPCSHOUT = 53;//TODO 一般聊天或大喊聊天頻道
	public static final int S_OPCODE_COMMONNEWS2 = 54;//TODO 系統訊息視窗
	public static final int S_OPCODE_CHARPACK = 55;//TODO 物件封包
	public static final int S_OPCODE_DROPITEM = 55;//TODO 物件封包 (道具)
	public static final int S_OPCODE_NORMALCHAT = 56;//TODO 一般聊天或大喊聊天頻道
	public static final int S_OPCODE_MAIL = 57;//TODO 郵件封包
	public static final int S_OPCODE_STRUP = 58;//TODO 力量提升封包
	public static final int S_OPCODE_CURSEBLIND = 59;//TODO 法術效果-暗盲咒術
	public static final int S_OPCODE_ITEMCOLOR = 60;//TODO 物品屬性狀態
	public static final int S_OPCODE_USECOUNT = 61;//TODO 魔杖的使用次數
	public static final int S_OPCODE_MOVEOBJECT = 62;//TODO 移動物件
	public static final int S_OPCODE_BOARD = 63;//TODO 佈告欄 (對話視窗)
	public static final int S_OPCODE_ADDITEM = 64;//TODO 物品增加封包
	public static final int S_OPCODE_SHOWRETRIEVELIST = 65;//TODO 倉庫物品名單
	public static final int S_OPCODE_RESTART = 66;//TODO 強制重新選擇角色
	public static final int S_OPCODE_YES_NO = 68;//TODO 確認視窗
	public static final int S_OPCODE_INVLIST = 69;//TODO 插入批次道具
	public static final int S_OPCODE_OWNCHARSTATUS2 = 70;//TODO 角色能力值
	public static final int S_OPCODE_NEW3 = 71;//TODO 不明封包 (商店)
	public static final int S_OPCODE_HPMETER = 72;//TODO 物件血條
	public static final int S_OPCODE_FIX_WEAPON_MENU = 73;//TODO 修理武器清單
	public static final int S_OPCODE_SELECTLIST = 73;//TODO 損壞武器名單
	public static final int S_OPCODE_TELEPORTLOCK = 74;//TODO 進入傳送點-傳送鎖定
	public static final int S_OPCODE_PRIVATESHOPLIST = 75;//TODO 個人商店販賣或購買
	public static final int S_OPCODE_GLOBALCHAT = 76;//TODO 廣播聊天頻道
	public static final int S_OPCODE_SYSMSG = 76;//TODO 伺服器訊息
	public static final int S_OPCODE_ADDSKILL = 77;//TODO 增加魔法進魔法名單
	public static final int S_OPCODE_SKILLBRAVE = 78;//TODO 魔法或物品效果圖示-勇氣藥水類
	public static final int S_OPCODE_WEATHER = 79;//TODO 遊戲天氣
	public static final int S_OPCODE_CHARLIST = 80;//TODO 角色資訊
	public static final int S_OPCODE_OWNCHARATTRDEF = 81;//TODO 角色屬性值
	public static final int S_OPCODE_EFFECTLOCATION = 82;//TODO 產生動畫 [座標]
	public static final int S_OPCODE_SPMR = 83;//TODO 魔法攻擊力與魔法防禦力
	public static final int S_OPCODE_SELECTTARGET = 84;//TODO 選擇一個目標
	public static final int S_OPCODE_BOARDREAD = 85;//TODO 佈告欄(訊息閱讀)
	public static final int S_OPCODE_SKILLSOUNDGFX = 86;//TODO 產生動畫 [自身]
	public static final int S_OPCODE_DISCONNECT = 88;//TODO 立即中斷連線
	public static final int S_OPCODE_SPECIALATTACK = 89;//TODO 特殊攻擊
	public static final int S_OPCODE_SPOLY = 90;//TODO 特別變身封包
	public static final int S_OPCODE_SHOWHTML = 91;//TODO 產生對話視窗
	public static final int S_OPCODE_ABILITY = 92;//TODO 配置封包
	public static final int S_OPCODE_DEPOSIT = 93;//TODO 存入資金城堡寶庫
	public static final int S_OPCODE_ATTACKPACKET = 94;//TODO 物件攻擊
	public static final int S_OPCODE_ITEMSTATUS = 95;//TODO 物品狀態更新
	public static final int S_OPCODE_ITEMAMOUNT = 95;//TODO 物品可用次數
	public static final int S_OPCODE_NEW2 = 97;//TODO 不明封包 (會將頭銜變更為空白)
	public static final int S_OPCODE_NEWCHARPACK = 98;//TODO 角色創造成功
	public static final int S_OPCODE_PACKETBOX = 100;//TODO 多功能封包
	public static final int S_OPCODE_ACTIVESPELLS = 100;//TODO 多功能封包
	public static final int S_OPCODE_SKILLICONGFX = 100;//TODO 多功能封包
	public static final int S_OPCODE_UNKNOWN2 = 100;//TODO 多功能封包
	public static final int S_OPCODE_DEXUP = 101;//TODO 敏捷提升封包
	public static final int S_OPCODE_LIGHT = 102;//TODO 物件亮度
	public static final int S_OPCODE_POLY = 103;//TODO 改變外型
	public static final int S_OPCODE_SOUND = 104;//TODO 撥放音效
	public static final int S_OPCODE_BLESSOFEVA = 106;//TODO 效果圖示 (水底呼吸)
	public static final int S_OPCODE_CHARTITLE = 108;//TODO 角色封號
	public static final int S_OPCODE_TAXRATE = 109;//TODO 設定稅收封包
	public static final int S_OPCODE_ITEMNAME = 110;//TODO 物品名稱
	public static final int S_OPCODE_MATERIAL = 111;//TODO 魔法學習-材料不足
	public static final int S_OPCODE_WHISPERCHAT = 113;//TODO 密語聊天頻道
	public static final int S_OPCODE_REDMESSAGE = 114;//TODO 畫面正中出現紅色/新增未使用
	public static final int S_OPCODE_ATTRIBUTE = 115;//TODO 物件屬性
	public static final int S_OPCODE_EXP = 116;//TODO 經驗值更新
	public static final int S_OPCODE_LAWFUL = 117;//TODO 正義值更新
	public static final int S_OPCODE_LOGINRESULT = 118;//TODO 登入狀態
	public static final int S_OPCODE_CASTLEMASTER = 119;//TODO 角色皇冠
	public static final int S_OPCODE_SERVERMSG = 120;//TODO 系統訊息
	public static final int S_OPCODE_HOUSEMAP = 121;//TODO 血盟小屋地圖 [地點]
	public static final int S_OPCODE_RESURRECTION = 122;//TODO 將死亡的對象復活
	public static final int S_OPCODE_DOACTIONGFX = 123;//TODO 執行物件外觀動作
	public static final int S_OPCODE_REMOVE_OBJECT = 124;//TODO 物件刪除
	public static final int S_OPCODE_EMBLEM = 125;//TODO 下載血盟徽章
	public static final int S_OPCODE_LIQUOR = 126;//TODO 海浪波浪
	public static final int S_OPCODE_HOUSELIST = 127;//TODO 血盟小屋名單

	/** 3.2C ServerPacket (3.5C 未抓取) id非正確 */
	public static final int S_OPCODE_USEMAP = 130;
	public static final int S_LETTER = 131;

	/** 3.3C Client Packet (3.5C 未抓取) id非正確 */
	public static final int C_OPCODE_RETURNTOLOGIN = 30;//TODO 要求回到選人畫面
	public static final int C_OPCODE_HIRESOLDIER = 141;//TODO 要求僱傭傭兵列表(購買)
	public static final int C_OPCODE_CLAN = 142;//TODO//TODO 要求血盟數據(例如盟標)**[未抓取]
	public static final int C_OPCODE_CHANGEWARTIME = 144;//TODO 修正城堡總管全部功能
	public static final int C_OPCODE_PUTSOLDIER = 145;//TODO 要求配置已僱用士兵
	public static final int C_OPCODE_SELECTWARTIME = 146;//TODO 要求選擇 變更攻城時間(but3.3C無使用)
	public static final int C_OPCODE_PUTBOWSOLDIER = 147;//TODO 要求配置城牆上弓手

}