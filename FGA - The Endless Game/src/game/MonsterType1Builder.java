package game;

public class MonsterType1Builder implements NPCBuilder {
	
	private NPC npc;
	
	public MonsterType1Builder(){
		
		this.npc = new NPC(0, 0);
		
	}

	public void buildNPCPontosVida() {
		
		npc.setInimigoPontosVida(100);
	
	}

	public void buildNPCDanoCausado() {
		
		npc.setInimigoDanoCausado(12);
		
	}

	public NPC getNPC() {
		// TODO Auto-generated method stub
		return null;
	}

}
