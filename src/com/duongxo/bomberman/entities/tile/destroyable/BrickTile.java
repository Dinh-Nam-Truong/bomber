package com.duongxo.bomberman.entities.tile.destroyable;


import com.duongxo.bomberman.entities.Entity;
import com.duongxo.bomberman.entities.bomb.DirectionalExplosion;
import com.duongxo.bomberman.entities.mob.enemy.Kondoria;
import com.duongxo.bomberman.graphics.Screen;
import com.duongxo.bomberman.graphics.Sprite;
import com.duongxo.bomberman.level.Coordinates;

public class BrickTile extends DestroyableTile {
	
	public BrickTile(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	@Override
	public void update() {
		super.update();
	}
	
	@Override
	public void render(Screen screen) {
		int x = Coordinates.tileToPixel(_x);
		int y = Coordinates.tileToPixel(_y);
		
		if(_destroyed) {
			_sprite = movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2);
			
			screen.renderEntityWithBelowSprite(x, y, this, _belowSprite);
		}
		else
			screen.renderEntity( x, y, this);
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof DirectionalExplosion)
			destroy();
		
		if(e instanceof Kondoria)
			return true;
			
		return false;
	}
	
	
}
