package net.tmt.td.util;

import net.tmt.td.engine.GameEngine;

public class CountdownTimer {
	private int	timeleftIntervall;

	private int	timer;

	public CountdownTimer(int timeleftIntervall, int starttimeleft) {
		this.timeleftIntervall = timeleftIntervall;
		this.timer = starttimeleft;
	}

	public CountdownTimer(int timeleftIntervall) {
		this(timeleftIntervall, timeleftIntervall);
	}

	public boolean isTimeleft() {
		timer -= GameEngine.DELTA_TARGET;

		if (timer <= 0) {
			timer += timeleftIntervall;
			return true;
		}

		return false;
	}
}
