package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public double x,y;
	public int w,h;
	//abaixo dire��o da baolinha
	public double dx,dy;
	public double speed = 1.3;
	
	public Ball(int x,int y) {
		this.x=x;
		this.y=y;
		this.w=4;
		this.h=4;
		
		
		int angle =- new Random().nextInt(30)+45;
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
	public void tick() {
		if(x+(dx*speed)+w>=Game.WIDTH) {
			dx*=-1;
		}
			
		else if(x+(dx*speed)<0) {
			dx*=-1;
		}
			
		
		
		x+=dx*speed;
		y+=dy*speed;
		
		if(y>=Game.HEIGHT) {
			//ponto inimigo
			new Game();
			return;
		}
			
		else if(y<0) {
			//ponto jogador
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int) (x+(dx*speed)), (int) (y+(dy*speed)),w,h);
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y ,Game.player.w,Game.player.h);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x,(int)Game.enemy.y ,Game.enemy.w,Game.enemy.h);
		
		if(bounds.intersects(boundsPlayer)) {
			int angle =- new Random().nextInt(30)+45;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy>0)
				dy*=-1;
		}
		if(bounds.intersects(boundsEnemy)) {
			int angle =- new Random().nextInt(30)+45;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy<0)
				dy*=-1;
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x,(int) y, w, h);
	}
}
