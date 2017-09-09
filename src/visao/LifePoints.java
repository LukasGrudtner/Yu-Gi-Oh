package visao;

import java.awt.Component;

public class LifePoints extends Thread {

	static int K = -100;
	int LP = 0;
	Component component;

	public LifePoints(int LP, Component component) {
		this.LP = LP;
		this.component = component;
		start();
	}

	public void run() {
		try {sleep(800);} catch (Exception erro) {}
		while (true) {
			try {sleep(2);} catch (Exception erro) {}
			
			if(component.getY() == LP * K)
				break;
			if (component.getY() > LP * K)
				component.setLocation(component.getX(), component.getY() - 2);
			
			if (component.getY() < LP * K)
				component.setLocation(component.getX(), component.getY() + 2);
		}
	}

}
