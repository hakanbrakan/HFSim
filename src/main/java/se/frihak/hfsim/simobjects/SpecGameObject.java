package se.frihak.hfsim.simobjects;

public class SpecGameObject {

	private ID id;
	private String namn;

	public SpecGameObject(ID id, String name, int x, int y, int w, int h) {
		this.id = id;
		this.namn = name;
	}

	public ID getId() {
		return id;
	}

	public String getNamn() {
		return namn;
	}

}
