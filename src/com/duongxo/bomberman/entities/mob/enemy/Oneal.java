package com.duongxo.bomberman.entities.mob.enemy;


import com.duongxo.bomberman.Board;
import com.duongxo.bomberman.Game;
import com.duongxo.bomberman.entities.mob.enemy.ai.AIMedium;
import com.duongxo.bomberman.graphics.Sprite;

public class Oneal extends Enemy {
	
	public Oneal(int x, int y, Board board) {
		super(x, y, board, Sprite.oneal_dead, Game.getPlayerSpeed(), 200);
		
		_sprite = Sprite.oneal_left1;
		
		_ai = new AIMedium(_board.getPlayer(), this);
		_direction  = _ai.calculateDirection();
	}
	
	/*
	|--------------------------------------------------------------------------
	| Mob Sprite
	|--------------------------------------------------------------------------
	 */
	@Override
	protected void chooseSprite() {
		switch(_direction) {
			case 0:
			case 1:
				if(_moving)
					_sprite = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, _animate, 60);
				else
					_sprite = Sprite.oneal_left1;
				break;
			case 2:
			case 3:
				if(_moving)
					_sprite = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, _animate, 60);
				else
					_sprite = Sprite.oneal_left1;
				break;
		}
	}
}
