package se.frihak.hfsim.simobjects;

public class SpecGameObject {

	private ID id;
	private String namn;
	private String startzon;
	private int x;
	private int y;
	private int w;
	private int h;

	public SpecGameObject(ID id, String name, int x, int y, int w, int h) {
		this.id = id;
		this.namn = name;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public SpecGameObject(ID id, String name, String startzon) {
		this(id, name, 0,0,0,0);
		this.startzon = startzon;
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

}
