package se.frihak.hfsim.spawner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.frihak.hfsim.simobjects.ID;
import se.frihak.hfsim.simobjects.SpecGameObject;
import se.frihak.hfsim.simobjects.commands.CommandID;

public class EnAnnanHardkodadSpelplan implements SpawnerObjects {

	@Override
	public Collection<SpecGameObject> getObjectsToSpawn() {
		List<SpecGameObject> dessaObjektSkallSpawnas = new ArrayList<>();
		
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Wall, "W", 0,	0, 500, 20));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Wall, "W", 0, 300, 500, 20));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Zone, "zonA", 0, 21, 50, 100));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Zone, "zonB", 400, 21, 50, 100));
		dessaObjektSkallSpawnas.add(createKalle());
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.WalkingMan, "Pelle", "zonB", "zonA"));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Zone, "zonC", 200, 150, 50, 100));
		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.WalkingMan, "Stina", "zonA", "zonC"));
		dessaObjektSkallSpawnas.add(createLisa());
//		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Wall, "W", 10,	200, 100, 60));
//		dessaObjektSkallSpawnas.add(new SpecGameObject(ID.Wall, "W", 130, 200, 100, 60));

		
		return dessaObjektSkallSpawnas;
	}

	private SpecGameObject createLisa() {
		SpecGameObject lisa = new SpecGameObject(ID.WalkingMan, "Lisa", "zonC", "zonB");
		
		Map<String, Object> a = new HashMap<String, Object>();
		a.put("ID", "GoTo");
		a.put("ZoneName", "zonB");
		lisa.add(a);

		return lisa;
	}

	private SpecGameObject createKalle() {
		SpecGameObject kalle = new SpecGameObject(ID.WalkingMan, "Kalle", "zonA", "zonB");

		Map<String, Object> a = new HashMap<String, Object>();
		a.put("ID", CommandID.GoTo.toString());
		a.put("ZoneName", "zonB");
		kalle.add(a);

		Map<String, Object> b = new HashMap<String, Object>();
		b.put("ID", CommandID.GoTo.toString());
		b.put("ZoneName", "zonC");
		kalle.add(b);
		
		Map<String, Object> d = new HashMap<String, Object>();
		d.put("ID", CommandID.Rest.toString());
		d.put("Time", 100);
		kalle.add(d);
		
		Map<String, Object> c = new HashMap<String, Object>();
		c.put("ID", "GoTo");
		c.put("ZoneName", "zonA");
		kalle.add(c); 
		
		return kalle;
	}

}
