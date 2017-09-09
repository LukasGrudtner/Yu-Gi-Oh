package visao;

import java.awt.Component;

public class Movimento extends Thread {
		int x = 0;
		int y = 0;
		Component component;
		
		public Movimento(int x, int y, Component component) {
			this.x = x;
			this.y = y;
			this.component = component;
			start();
		}
		
		public void run() {
			while(true) {
				try{sleep(2);}catch(Exception erro){}
				if(component.getX() == x && component.getY() == y)
					break;
				if(component.getX() > x)
					component.setBounds(component.getX() - 1, component.getY(), component.getWidth(), component.getHeight());
				if(component.getX() < x)
					component.setBounds(component.getX() + 1, component.getY(), component.getWidth(), component.getHeight());
				if(component.getY() > y)
					component.setBounds(component.getX(), component.getY() - 1, component.getWidth(), component.getHeight());
				if(component.getY() < y)
					component.setBounds(component.getX(), component.getY() + 1, component.getWidth(), component.getHeight());
			}
		}
		
	}
