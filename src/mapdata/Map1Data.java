package mapdata;

import java.util.ArrayList;
import java.util.Random;

import mobs.BasicMob;
import mobs.FireImmuneMob;
import mobs.FrostImmuneMob;
import mobs.GiantPumpkinMob;
import mobs.LightningImmuneMob;
import mobs.Mob;
import mobs.SpeedyMob;
import mobs.TankMob;
import mobs.WitchMob;
import models.DriverModel;


import utilities.Position;

/**
 * stores the data for a map including
 * the mob motions on the map, the mobs
 * that will spawn
 * 
 * @author Scorpion
 *
 */

public class Map1Data extends MapData {
	
	private final double X_START = 460;
	private final double Y_START = -50;
	
	private final DriverModel model;
	private final int difficulty;
	
	/**
	 * sets the model and the difficulty fields
	 * 
	 * @param model
	 * @param difficulty
	 */
	
	public Map1Data(final DriverModel model, final int difficulty) {
		this.model = model;
		this.difficulty = difficulty;
	}

	/**
	 * compiles a list of mobs to 
	 * run based on the current level
	 * and returns it
	 * 
	 * @param level
	 * 
	 * @return mobs
	 */
	
	public ArrayList<Mob> getMobs(final int level) {
		Random random = new Random();
		final ArrayList<Mob> mobs = new ArrayList<Mob>();
		int mobCount = 0;
		int mobLevel;
		
		if (level < 5) {
			mobLevel = 10;
		} else if (level < 10) {
			mobLevel = 12;
		} else if (level < 15) {
			mobLevel = 16;
		} else {
			mobLevel = 17;
		}
		
		while (mobCount < (6 + (level / 2))) {
			switch (random.nextInt(mobLevel)) {
			case 0: mobs.add(new BasicMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 1: mobs.add(new BasicMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 2: mobs.add(new BasicMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 3: mobs.add(new BasicMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 4: mobs.add(new TankMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 5: mobs.add(new TankMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 6: mobs.add(new TankMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 7: mobs.add(new SpeedyMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 8: mobs.add(new SpeedyMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 9: mobs.add(new SpeedyMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 10: mobs.add(new FireImmuneMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 11: mobs.add(new FireImmuneMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 12: mobs.add(new LightningImmuneMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 13: mobs.add(new LightningImmuneMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 14: mobs.add(new FrostImmuneMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 15: mobs.add(new FrostImmuneMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 16: mobs.add(new GiantPumpkinMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			case 17: mobs.add(new WitchMob(level, difficulty, new Position(X_START, Y_START)));
				break;
			}
			
			mobCount++;
		}
		
		return mobs;
	}

	/**
	 * updates the position of the mobs
	 * and changes their direction if needed
	 * 
	 * @return position
	 */
	
	public Position travelDistance(final Mob mob) {
		double xCord = mob.getPosition().getXCord();
		double yCord = mob.getPosition().getYCord();
		
		for (int i = 0; i < mob.getSpeed(); i++) 
		{
			if (mob.getDistanceTraveled() < 173) {
				yCord++;
				mob.setDirection('d');
			} else if (mob.getDistanceTraveled() < 337) {
				xCord++;
				mob.setDirection('r');
				mob.movingRight();
			} else if (mob.getDistanceTraveled() < 738) {
				yCord++;
				mob.setDirection('d');
			} else if (mob.getDistanceTraveled() < 1283) {
				xCord--;
				mob.setDirection('l');
				mob.movingLeft();
			} else if (mob.getDistanceTraveled() < 1427) {
				yCord--;
				mob.setDirection('u');
			} else if (mob.getDistanceTraveled() < 1830) {
				xCord++;
				mob.setDirection('r');
				mob.movingRight();
			} else if (mob.getDistanceTraveled() < 1960) {
				yCord--;
				mob.setDirection('u');
			} else if (mob.getDistanceTraveled() < 2365) {
				xCord--;
				mob.setDirection('l');
				mob.movingLeft();
			} else if (mob.getDistanceTraveled() < 2515) {
				yCord--;
				mob.setDirection('u');
			} else if (mob.getDistanceTraveled() < 2715) {
				xCord++;
				mob.setDirection('r');
				mob.movingRight();
			} else if (mob.getDistanceTraveled() < 2865) {
				yCord--;
				mob.setDirection('u');
			} else {
				if (mob.isVisible()) {
					model.lifeLost();
				}
				mob.vanishMob();
			}
			mob.traveledDistance();
		}
		
		return new Position(xCord, yCord);
	}
}
