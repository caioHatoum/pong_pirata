package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	public double x,y;
	public int w,h;
	public Enemy(int x, int y) {
		this.x=x;
		this.y=y;
		this.w=40;
		this.h=10;
	}
	public void tick() {
		x+=Game.ball.x-x-6 *0.6;
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, w, h);
	}
}
