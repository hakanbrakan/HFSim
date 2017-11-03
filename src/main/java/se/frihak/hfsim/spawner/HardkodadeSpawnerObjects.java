package se.frihak.hfsim.spawner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import se.frihak.hfsim.simobjects.ID;
import se.frihak.hfsim.simobjects.SpecGameObject;

public class HardkodadeSpawnerObjects implements SpawnerObjects {

	@Override
	public Collection<SpecGameObject> getObjectsToSpawn() {
		List<SpecGameObject> dessaObjektSkallSpawnas = new ArrayList<>();
		
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Wall, "W", 50,	80, 60, 50));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.WalkingMan, "Kalle", "zonA"));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Wall, "W", 150, 80, 60, 50));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Zone, "zonA", 350, 200, 100, 60));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Wall, "W", 10,	200, 100, 60));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.WalkingMan, "Pelle", "zonB"));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.WalkingMan, "Stina", "zonA"));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Wall, "W", 130, 200, 100, 60));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Zone, "zonB", 250, 200, 100, 60));

		
		return dessaObjektSkallSpawnas;
	}

}