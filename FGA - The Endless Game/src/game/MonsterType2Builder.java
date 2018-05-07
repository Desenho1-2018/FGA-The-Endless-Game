package game;

public class MonsterType2Builder implements NPCBuilder {
	
	private NPC npc;
	
	public MonsterType2Builder(){
		
		this.npc = new NPC(0, 0);
		
	}

	public void buildNPCPontosVida() {
		
		npc.setInimigoPontosVida(200);
	
	}

	public void buildNPCDanoCausado() {
		
		npc.setInimigoDanoCausado(25);
		
	}

	public NPC getNPC() {
		
		return this.npc;
	
	}

}
