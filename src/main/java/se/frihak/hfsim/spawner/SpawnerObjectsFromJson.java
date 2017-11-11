package se.frihak.hfsim.spawner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONObject;

import se.frihak.hfsim.simobjects.ID;
import se.frihak.hfsim.simobjects.SpecGameObject;

public class SpawnerObjectsFromJson implements SpawnerObjects {

	private JSONObject json;

	public SpawnerObjectsFromJson(JSONObject json) {
		this.json = json;
	}

	@Override
	public Collection<SpecGameObject> getObjectsToSpawn() {
		List<SpecGameObject> dessaObjektSkallSpawnas = new ArrayList<>();
		
		for (Object o : json.getJSONArray("Simobjects")) {
		    if (o instanceof JSONObject ) {
		    		parse((JSONObject)o, dessaObjektSkallSpawnas);
		    }
		}
		
		return dessaObjektSkallSpawnas;
	}
	
	private void parse(JSONObject jsonObj, List<SpecGameObject> dessaObjektSkallSpawnas) {
		if (jsonObj.getString("ID").equals(ID.Wall.toString())) {
			dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Wall, jsonObj.getString("Name"), jsonObj.getInt("x"),	jsonObj.getInt("y"), jsonObj.getInt("Width"), jsonObj.getInt("Height")));
		} else if (jsonObj.getString("ID").equals(ID.Zone.toString())) {
			dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Zone, jsonObj.getString("Name"), jsonObj.getInt("x"),	jsonObj.getInt("y"), jsonObj.getInt("Width"), jsonObj.getInt("Height")));
		} else 		if (jsonObj.getString("ID").equals(ID.WalkingMan.toString())) {
			dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Wall, jsonObj.getString("Name"), jsonObj.getString("Start"),	jsonObj.getString("Goal")));
		}
	}
}
