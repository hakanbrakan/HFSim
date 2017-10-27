package se.frihak.hfsim.simobjects;

public class SpecGameObject {

	private ID id;
	private String namn;
	private String startzon;

	public SpecGameObject(ID id, String name, int x, int y, int w, int h) {
		this.id = id;
		this.namn = name;
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

}
