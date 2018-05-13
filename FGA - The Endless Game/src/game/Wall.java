package game;

import java.util.ArrayList;

public class Wall  extends GameObject{
	private Wall parede1;
	private Wall parede2;
	private Wall parede3;
	private Wall parede4;
	private Wall parede5;
	private final int playerwidth=82;
	private final int playerheight=82;
	ArrayList <GameObject> paredes =new ArrayList<GameObject>();
	public void Parede2() {
		
	}
	public Wall(String filename, int x, int y, int width, int height) {
		super(x,y, filename,1,GameObjectType.WALL);
		//this.width=width;
		this.setwidth(width);
		this.height=height;
		// TODO Auto-generated constructor stub
	}
	
	public void 	paredeesquerda(int x,int y, int width, int height){
			Wall parede7;
			parede7=new Wall("src//recursos//sprite//paredeesquerda.png",x,y,10,height);
		    this.drawing(parede7);
	}
	public void paredecima(int x,int y, int width) {
	    	Wall parede8;
	    	parede8=new Wall("src//recursos//sprite//parededebaixo3.png",x,y,width,10);
	        this.drawing(parede8);
	    	
	}
	public int sizeparedes() {
		return paredes.size();
	}
	public GameObject getparede(int i) {
		 return paredes.get(i);
		
	}
	public ArrayList<GameObject> getparedes() {
		return paredes;
	}
	public int calcwidth(int y) {
        return y+playerwidth;
    }
    public int calcheight(int x) {
        return x+playerheight;
    } 
    public void drawing(Wall parede1) {
		paredes.add((GameObject)parede1);
	}
    public void paredesdraw() {
    	int i,i2;
    	GameObject parede;
    	i2=this.sizeparedes();
    	for(i=0;i<i2;i++) {
    	  parede=this.getparede(i);	
    	  parede.draw();
    	}
    }
    
	public void draw(String filename, int x, int y, int width,int height) {
		Wall parede11;
		parede11=new Wall(filename,x,y,width,height);
	    drawing(parede11);
	}
	
	public void paredeslateraislabirinto1() {
		draw("src//recursos//sprite//parededebaixo3.png",playerwidth,1,10000,10);
		int wallcoordenatey=590;
		int c=800-playerwidth; 
		draw("src//recursos//sprite//parededebaixo3.png",1,300,200,10);
		draw("src//recursos//sprite//parededadireita.png",1,playerwidth,10,10000);
		draw("src//recursos//sprite//parededadireita.png",790,10,10,c);
		
	}
	public void paredeslaterais() {
		draw("src//recursos//sprite//parededebaixo3.png",1,1,10000,10);
		int wallcoordenatey=590;
		draw("src//recursos//sprite//parededebaixo2.png",1,wallcoordenatey,10000,10);
		draw("src//recursos//sprite//paredeesquerda.png",1,10,10,10000);
		draw("src//recursos//sprite//parededadireita.png",790,10,10,1000);
		
	}
	public void paredeslateraislabirinto2(){
	 int wallcoordenatey=590;
	 draw("src//recursos//sprite//parededebaixo3.png",1,1,1000,10);
	 draw("src//recursos//sprite//parededebaixo3.png",1,580,1000,10);
	 draw("src//recursos//sprite//paredeesquerda.png",1,playermultiplymore(10,1),10,10000);
	 draw("src//recursos//sprite//paredeesquerda.png",1,100,10,10000);
	 draw("src//recursos//sprite//paredeesquerda.png",1,400,10,120);
	 this.paredeesquerda(790,1,1000,1000);
	 this.paredeesquerda(790, 500,10,100);
	
	
    }
	public void paredeslateraislabirinto() {
		draw();
		int wallcoordenatey=590;
		draw("src//recursos//sprite//parededebaixo3.png",1,1,1000,10);
		draw("src//recursos//sprite//parededebaixo3.png",1,580,1000,10);
		draw("src//recursos//sprite//paredeesquerda.png",1,playermultiplymore(10,1),10,10000);
		draw("src//recursos//sprite//paredeesquerda.png",1,100,10,10000);
		draw("src//recursos//sprite//paredeesquerda.png",1,400,10,120);
		this.paredeesquerda(790,1,1000,1000);
		//this.paredeesquerda(790, 200,10,1000);
		this.paredeesquerda(790, 500,10,100);
		
		
	}
	public int playermultiplymenus(int value,int quantity) {
		return value-quantity*playerwidth;
	}
	public int playermultiplymore(int value,int quantity) {
		return value+quantity*playerwidth;
	}
	public void mirrorhorizontal(int x,int y, int width) {
		paredecima(x,y,width);
		paredecima(x,playermultiplymore(y,1),width);
	}
	public void mirrorhvertical(int x,int y, int width, int height) {
       paredeesquerda(x,y,width,height);
       paredeesquerda(playermultiplymore(x,1),y,width,height);
	}   
    public void quinavertical(int x, int y,int width,int height) {
    	paredecima(x,y,width);
    	int value=x+width;
    	paredeesquerda(value,y,width,height);
    }
   
	public void labirinto() {
	    int firstwall=50; 
	    int firstwallw=firstwall+playerwidth;
	    int firstwallw2=firstwall+2*playerwidth;
	    int firstwallw3=270+playerwidth+10;
	  //  paredecima(calcheight(10),firstwall,firstwallw3);
	   paredeesquerda(90,10,10,playerwidth);
	   // paredeesquerda(calcheight(10),firstwall,30,playerwidth);// x, y, width,height
	    //paredecima(calcwidth(10),firstwallw,90);
	    paredecima(calcwidth(10),firstwallw2,140);//x,y,width horizontal wall ends in the thirdwall
    	int firstcurve=190;
	    int firstcurvew=10;
	    paredecima(10,200,65);
	    paredeesquerda(65,firstwallw2,55,playerwidth);
	    int thirdwall=firstwallw;
	    int thirdwallw=235;
	    int thirdwallw2=thirdwallw+playerwidth;
	    int playerwidth2=playerwidth+7;
	    paredeesquerda(200,thirdwall,60,playerwidth2);
	    paredecima(210,thirdwall,30);
	    paredeesquerda(thirdwallw,thirdwall,60,92);
	    paredecima(230,calcheight(130),120);
	    int fourthwall=340;
	    int fourthwallw=fourthwall+playerwidth;
	    int fourthwally=192;
	    int fourthwally2=192+playerwidth;
	    paredeesquerda(fourthwall,192,60,playerwidth);
	    paredeesquerda(thirdwallw2,32,60,90);	
	    paredeesquerda(330,firstwall,60,70);
	    paredeesquerda(fourthwallw,firstwall,60,200);
	    int newwidth=thirdwallw+playerwidth;
	    int fourthwallw2=fourthwall+playerwidth;
	    int fourthwallx=fourthwall-playerwidth+10;
	    paredecima(fourthwallw2,fourthwally2,playerwidth);
        paredecima(newwidth,109,50);
	    int fourthwallx3=fourthwallx-playerwidth;
	    paredecima(fourthwallx3,fourthwally2,2*playerwidth);
	    int fivethwally=fourthwally2+playerwidth;
	    int fivethwallx=fourthwally2+4*playerwidth-10;
        paredeesquerda(fivethwallx,fourthwally2,20,playermultiplymore(1,2));
        int fivethwally3=fivethwally+playerwidth;
	    int fivethwallx2=fourthwally2+playerwidth;
	    paredecima(fivethwallx2,fivethwally,160);
	    paredeesquerda(playermultiplymenus(fivethwallx,4),fourthwally2,20,2*playerwidth);
	    int mirrorwallx=fourthwallx3-15;
	    int mirrorwallx2=mirrorwallx+2*playerwidth;
	    int seventhwall=mirrorwallx2+playerwidth;
	    paredecima(mirrorwallx,playermultiplymore(fourthwally2,2),2*playerwidth);
        paredeesquerda(mirrorwallx2,playermultiplymore(fourthwally2,2),20,playermultiplymore(1,2));
	    paredeesquerda(seventhwall,playermultiplymore(fourthwally2,2),20,playerwidth);
	    paredecima(seventhwall,playermultiplymore(fourthwally2,2),playermultiplymore(20,1));
	    paredecima(seventhwall,playermultiplymore(fourthwally2,3),playermultiplymore(-30,3));
	    int z=5*playerwidth+22;
	    paredecima(mirrorwallx2,playermultiplymore(fourthwally2,4),z);
	    int twoaftermirrorwall=playermultiplymore(mirrorwallx2,5)-40;
	    paredeesquerda(twoaftermirrorwall,playermultiplymore(fourthwally2,1),playerwidth,3*playerwidth);
	    paredeesquerda(playermultiplymenus(twoaftermirrorwall,1),playermultiplymore(fourthwally2,1),playerwidth,2*playerwidth);
	    //paredecima(playermultiplymenus(twoaftermirrorwall,2),fourthwally2,3*playerwidth); 
	    paredeesquerda(playermultiplymore(twoaftermirrorwall,1),fourthwally2, playerwidth,2*playerwidth);
	    int  treeaftermirrory=playermultiplymore(fourthwally2,3);
	    int  treeaftermirrorx=playermultiplymore(twoaftermirrorwall,1);
	    paredecima(treeaftermirrorx,treeaftermirrory,playerwidth);
	    paredeesquerda(treeaftermirrorx,treeaftermirrory,playerwidth,playermultiplymore(10,1));
	    paredecima(treeaftermirrorx,playermultiplymenus(treeaftermirrory,1),playerwidth);
	    paredeesquerda(playermultiplymore(treeaftermirrorx,2),playermultiplymenus(treeaftermirrory,4),playerwidth,playermultiplymore(10,4));
	    int antimirror=playermultiplymore(mirrorwallx, 4)+10;
	    paredecima(antimirror,playermultiplymenus(treeaftermirrory,4),playermultiplymore(1,10));
	    paredeesquerda(antimirror,10,20,playermultiplymore(-15,4));
	    mirrorhvertical(playermultiplymore(treeaftermirrorx,1),treeaftermirrory,20,playerwidth);
	    paredeesquerda(playermultiplymore(treeaftermirrorx,1),treeaftermirrory,20,2*playerwidth);
	    int d=playermultiplymore(treeaftermirrorx,1);
	    quinavertical(d,playermultiplymore(treeaftermirrory,2),playermultiplymore(30,1),playermultiplymore(40,1));
	    paredecima(playermultiplymore(d,1),playermultiplymore(treeaftermirrory,1),40);
	}
	
	
}