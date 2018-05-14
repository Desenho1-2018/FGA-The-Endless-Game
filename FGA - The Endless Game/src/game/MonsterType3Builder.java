package game;

public class MonsterType3Builder implements NPCBuilder {

	private NPC npc;
	
	public MonsterType3Builder(){
		
		this.npc = new NPC(400, 400);
		
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
