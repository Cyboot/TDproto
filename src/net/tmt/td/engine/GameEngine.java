package net.tmt.td.engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import net.tmt.td.game.Game;
import net.tmt.td.game.Map;
import net.tmt.td.game.Player;
import net.tmt.td.util.CountdownTimer;
import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.StringFormatter;

@SuppressWarnings("serial")
public class GameEngine extends Canvas {
	public static final int	DELTA_TARGET			= 15;

	private float			cpuWorkload;
	private String			cpuWorkloadText			= "";
	private CountdownTimer	timerCPUWorkloadText	= new CountdownTimer(1000);

	private Game			game;


	public GameEngine() {
		Dimension dim = new Dimension(Game.WIDTH - 10, Game.HEIGHT - 10);
		this.setPreferredSize(dim);
		this.setMinimumSize(dim);
		this.setMaximumSize(dim);

		addKeyListener(Controls.getInstance());
		setBackground(Color.black);
	}

	public void start() {
		ImageLoader.init();
		Game.init();
		Map.init();
		Player.init();
		game = Game.getInstance();

		final int DELTA_TARGET_NANOS = DELTA_TARGET * 1000 * 1000;

		while (true) {
			long timeStart = System.nanoTime();

			BufferStrategy bs = getBufferStrategy();
			if (bs == null) {
				createBufferStrategy(3);
				continue;
			}

			tick();

			render(bs.getDrawGraphics());

			if (bs != null)
				bs.show();

			long timePassed = System.nanoTime() - timeStart;
			if (timePassed < DELTA_TARGET_NANOS) {
				long sleepTime = DELTA_TARGET_NANOS - timePassed;

				long millis = sleepTime / (1000 * 1000);
				int nano = (int) (sleepTime % (1000 * 1000));

				try {
					Thread.sleep(millis, nano);
				} catch (InterruptedException e) {
				}
			}

			cpuWorkload = (float) timePassed / DELTA_TARGET_NANOS;
		}
	}

	private void tick() {
		if (timerCPUWorkloadText.isTimeleft())
			cpuWorkloadText = getCPUWorkload();

		game.tick();
	}

	private void render(final Graphics g) {
		g.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);

		game.render(g);

		g.setColor(Color.yellow);
		g.setFont(getFont());
		g.drawString(cpuWorkloadText, Game.WIDTH - 30, 15);

		if (!hasFocus())
			g.drawString("Click to focus!", Game.WIDTH / 2 - 30, 15);

		g.dispose();
		Toolkit.getDefaultToolkit().sync();
	}

	private String getCPUWorkload() {
		return StringFormatter.format(cpuWorkload);
	}
}
