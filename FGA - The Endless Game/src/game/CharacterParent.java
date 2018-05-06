package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class CharacterParent extends Sprite{
	

	protected int direcao = 3;
	protected double velocidade = 1;
	protected boolean movendo = false;
	CollisionControl controle  = new CollisionControl();
	
	public CharacterParent(String fileName, int numFrames) {
		super(fileName, numFrames);
		// TODO Auto-generated constructor stub
	}
		

	/**
	 * Colisões com cenario tiles
	 * @param cena
	 */
	public void caminho(Scenario cena, GameObject parede){
		Point min = new Point((int)this.x,(int)this.y); 
		Point max = new Point((int)this.x + this.width,(int)this.y + this.height); 
		
		//retornar as imagens que estiverem no msm lugar do personagem
		
		
		
			if(controle.colisao(this,parede) == true){
				if(colisaoVertical(this, parede )){
					if(parede.y + parede.height -2 < this.y ){ // 2 margem de segurança 
						this.y = parede.y + parede.height; //reposicionando o personagem fora do tile
					}
					else if(parede.y > this.y+ this.height -2){ // 2 margem de segurança 
							this.y = parede.y - this.height;
						}
					}
					if(colisaoHorizontal(this, parede) == true){
						if(parede.x > this.x + this.width -2 ){
							this.x = parede.x - this.width;
						}else{
							this.x = parede.x + parede.width;
						}
				
				}
			}
		//}
	}
	private boolean colisaoVertical(GameObject obj, GameObject obj2){
		if(obj2.x + obj2.width <= obj.x){ //verificando se o ponto x é maior ou igual ao ponto x do personagme
			return false;		
		}
		
		if(obj.x + obj.width <= obj2.x){
			return false;
		}
		return true; // se retornar isso tem colisao
	}
	
	private boolean colisaoHorizontal(GameObject obj, GameObject obj2){
		if(obj2.y + obj2.height <= obj.y){
			return false;
		}
		
		if(obj.y +obj.height <= obj2.y){
			return false;
		}
		return true;
	}

}


