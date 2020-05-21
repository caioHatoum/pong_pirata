package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	public boolean right,left;
	public int x,y,w,h;
	
	
	public Player(int x,int y) {
		this.y=y;
		this.x=x;
		this.w=40;
		this.h=10;
	}
	
	public void render(Graphics g){	
		g.setColor(Color.blue);
		g.fillRect(x, y, w, h);
	}	
	public void tick(){		
		if(right) {
			x+=2;
		}else if(left) {
			x-=2;
		}
		if(x+w> Game.WIDTH) {
			x=Game.WIDTH -w;
		}else if(x<0) {
			x=0;
		}
	}

}
