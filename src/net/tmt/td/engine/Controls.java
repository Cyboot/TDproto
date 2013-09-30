package net.tmt.td.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Controls implements KeyListener {
	private static Controls			instance		= new Controls();

	private Map<Integer, Boolean>	keymap			= new HashMap<Integer, Boolean>();
	private Set<Integer>			oncepressedSet	= new HashSet<>();

	@Override
	public void keyPressed(final KeyEvent ke) {
		keymap.put(ke.getKeyCode(), true);
	}

	@Override
	public void keyReleased(final KeyEvent ke) {
		keymap.put(ke.getKeyCode(), false);
		oncepressedSet.remove(ke.getKeyCode());
	}

	@Override
	public void keyTyped(final KeyEvent ke) {
	}

	public boolean pressed(final int keycode) {
		return keymap.get(keycode) == null ? false : keymap.get(keycode);
	}

	public boolean pressedOnce(final int keycode) {
		boolean isPressed = pressed(keycode);

		boolean wasCheckedBefore = oncepressedSet.contains(keycode);
		if (isPressed)
			oncepressedSet.add(keycode);

		return isPressed && !wasCheckedBefore;
	}

	public static Controls getInstance() {
		return instance;
	}
}
