package com.duongxo.bomberman.entities.tile.powerup;

import com.duongxo.bomberman.Game;
import com.duongxo.bomberman.entities.Entity;
import com.duongxo.bomberman.entities.mob.Player;
import com.duongxo.bomberman.graphics.Sprite;

public class PowerupSpeed extends Powerup {

	public PowerupSpeed(int x, int y, int level, Sprite sprite) {
		super(x, y, level, sprite);
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Player) {
			((Player) e).addPowerup(this);
			remove();
			return true;
		}
		
		return false;
	}
	
	@Override
	public void setValues() {
		_active = true;
		Game.addPlayerSpeed(0.1);
	}
	


}
