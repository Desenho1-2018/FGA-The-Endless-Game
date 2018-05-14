package game;

public class MonsterGenerator {
	
	private NPCBuilder npcBuilder;
	
	public MonsterGenerator(NPCBuilder npcBuilder){
		this.npcBuilder = npcBuilder;
	}
	
	public NPC getNPC(){
		return this.npcBuilder.getNPC();
	}
	
	public void generateMonster() {
		this.npcBuilder.buildNPCDanoCausado();
		this.npcBuilder.buildNPCPontosVida();
	}

}
