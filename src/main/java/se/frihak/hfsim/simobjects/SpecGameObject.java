package se.frihak.hfsim.simobjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpecGameObject {

	private ID id;
	private String namn;
	private String startzon;
	private int x;
	private int y;
	private int w;
	private int h;
	private String goal;
	private List<Map<String, Object>> commands;

	public SpecGameObject(ID id, String name, int x, int y, int w, int h) {
		this.id = id;
		this.namn = name;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		commands = new LinkedList<>();
	}

	public SpecGameObject(ID id, String name, String startzon, String goalZone) {
		this(id, name, 0,0,0,0);
		this.startzon = startzon;
		this.goal = goalZone;
	}

	public ID getId() {
		return id;
	}

	public String getNamn() {
		return namn;
	}

	public Object getStartzon() {
		return startzon;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public String getGoal() {
		return goal;
	}

	public void add(Map<String, Object> cmdMap) {
		commands.add(cmdMap);
	}

	public List<Map<String, Object>> getCommands() {
		return commands;
	}

}
