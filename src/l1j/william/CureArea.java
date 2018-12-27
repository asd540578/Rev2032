package l1j.william;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillSound;
import java.util.Collection;
import l1j.server.server.model.L1Object;

public class CureArea extends Thread{
	private int iMinX,iMinY,iMaxX,iMaxY,iMapID,iCureHp,iCureMp,iCurePeriod,iTimes,iGfxid;
    private l1j.server.server.model.Instance.L1PcInstance pc;
	private CureArea(){}
	
	public CureArea(int minx,int miny,int maxx,int maxy,int mapid,int mp,int hp,int cure_period,int times,int gfxid){
	   iMinX = minx; //TODO 最小x
	   iMinY = miny; //TODO 最小y
	   iMaxX = maxx; //TODO 最大x
	   iMaxY = maxy; //TODO 最大y
	   iMapID = mapid; //TODO 地圖號碼
	   iCureHp = hp;//TODO 每回合治療點數 hp
	   iCureMp = mp;//TODO 每回合治療點數 mp
	   iTimes = times;//TODO 治療幾回合, 0代表無限
	   iGfxid = gfxid;//TODO 魔法技能
	   iCurePeriod = cure_period;//TODO 每回合要等幾秒
	}	
	//@Override
	@Override
	public void run() {
		if( iTimes!=0){
		  for( int i=0;i<iTimes;i++){
			try{
				sleep(iCurePeriod*1000);
				Collection<L1PcInstance> al1object = L1World.getInstance().getAllPlayers();
				for (L1Object object : al1object){
					if (object instanceof L1PcInstance) {
						pc = (l1j.server.server.model.Instance.L1PcInstance)object;
						if( pc.getX()>=iMinX &&pc.getX()<=iMaxX && pc.getY()>=iMinY && pc.getY()<=iMaxY && pc.getMapId()==iMapID ) {
							if( !pc.isDead() ){
								  if( pc.getCurrentHp()<pc.getBaseMaxHp()|| pc.getCurrentMp()<pc.getBaseMaxMp() ){
									pc.sendPackets(new S_SkillSound(pc.getId(), iGfxid));
									pc.broadcastPacket(new S_SkillSound(pc.getId(), iGfxid));
									pc.sendPackets(new S_ServerMessage(77, "")); // \f1気分が良くなりました。
									pc.setCurrentHp(pc.getCurrentHp() + iCureHp);
									pc.setCurrentMp(pc.getCurrentMp() + iCureMp);
								  }  
							  }
						}  
					}				
				}
				}catch(Exception ex){}
		  }	
		}
		else{	
		  do{
			try{
			sleep(iCurePeriod*1000);
			Collection<L1PcInstance> al1object = L1World.getInstance().getAllPlayers();
			for (L1Object object : al1object){
				if (object instanceof L1PcInstance) {
					pc = (l1j.server.server.model.Instance.L1PcInstance)object;
					if( pc.getX()>=iMinX &&pc.getX()<=iMaxX && pc.getY()>=iMinY && pc.getY()<=iMaxY && pc.getMapId()==iMapID ) {
						if( !pc.isDead() ){
							  if( pc.getCurrentHp()<pc.getBaseMaxHp()|| pc.getCurrentMp()<pc.getBaseMaxMp() ){
									pc.sendPackets(new S_SkillSound(pc.getId(), iGfxid));
									pc.broadcastPacket(new S_SkillSound(pc.getId(), iGfxid));
									pc.sendPackets(new S_ServerMessage(77, "")); // \f1気分が良くなりました。
									pc.setCurrentHp(pc.getCurrentHp() + iCureHp);
									pc.setCurrentMp(pc.getCurrentMp() + iCureMp);
							  }  
						  }
					}  
				}				
			}
			}catch(Exception ex){}
		  }while(true);
		}
	}	
}