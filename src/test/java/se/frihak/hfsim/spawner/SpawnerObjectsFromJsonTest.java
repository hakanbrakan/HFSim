package se.frihak.hfsim.spawner;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Before;
import org.junit.Test;

import se.frihak.hfsim.simobjects.SpecGameObject;

public class SpawnerObjectsFromJsonTest {
	
	@Before
	public void initiera() {
	}

	@Test
	public void enWall() {
		String enVagg = 
	            "{" +
	    	        " \"Simobjects\": [" +
	            "  {" +
	            "   \"ID\": \"Wall\", " +
	            "   \"Name\": \"W\", " +
	            "   \"x\" : 400, " +
	            "   \"y\" : 21, " +
	            "   \"Width\" : 50, " +
	            "   \"Height\" : 100, " +
	            "  }" +
	            "  ]" +
	            "}";
	         
		JSONObject obj = new JSONObject(enVagg);
	        
		SpawnerObjects objects = new SpawnerObjectsFromJson(obj);
		
		assertEquals(1, objects.getObjectsToSpawn().size());
		SpecGameObject enSpec = objects.getObjectsToSpawn().stream().findFirst().get();
		assertEquals("W", enSpec.getNamn());
		assertEquals(400, enSpec.getX());
		assertEquals(100, enSpec.getHeight());
	}
	
	@Test
	public void enZone() {
		String enZon = 
	            "{" +
	    	        " \"Simobjects\": [" +
	            "  {" +
	            "   \"ID\": \"Zone\", " +
	            "   \"Name\": \"ZonA\", " +
	            "   \"x\" : 400, " +
	            "   \"y\" : 21, " +
	            "   \"Width\" : 50, " +
	            "   \"Height\" : 100, " +
	            "  }" +
	            "  ]" +
	            "}";
	         
		JSONObject obj = new JSONObject(enZon);
	        
		SpawnerObjects objects = new SpawnerObjectsFromJson(obj);
		
		assertEquals(1, objects.getObjectsToSpawn().size());
		SpecGameObject enSpec = objects.getObjectsToSpawn().stream().findFirst().get();
		assertEquals("ZonA", enSpec.getNamn());
		assertEquals(400, enSpec.getX());
		assertEquals(21, enSpec.getY());
		assertEquals(100, enSpec.getHeight());
		assertEquals(50, enSpec.getWidth());
	}

	@Test
	public void enWalkingMan() {
		String enGubbe = 
	            "{" +
	    	        " \"Simobjects\": [" +
	            "  {" +
	            "   \"ID\": \"WalkingMan\", " +
	            "   \"Name\": \"Kalle\", " +
	            "   \"Start\" : \"ZonA\", " +
	            "   \"Goal\" : \"ZonB\", " +
	            "   \"Commands\": [{ \"ID\": \"Rest\", \"Time\": \"10\" },{ \"ID\": \"GoTo\", \"ZoneName\": \"ZonB\" }]" +
	            "  }" +
	            "  ]" +
	            "}";
	         
		JSONObject obj = new JSONObject(enGubbe);
	        
		SpawnerObjects objects = new SpawnerObjectsFromJson(obj);
		
		assertEquals(1, objects.getObjectsToSpawn().size());
		SpecGameObject enSpec = objects.getObjectsToSpawn().stream().findFirst().get();
		assertEquals("Kalle", enSpec.getNamn());
		assertEquals("ZonA", enSpec.getStartzon());
		assertEquals("ZonB", enSpec.getGoal());
	}

	@Test
	public void enAvVarje() {
		String alla = 
	            "{" +
	    	        " \"Simobjects\": [" +
	            "  {" +
	            "   \"ID\": \"Wall\", " +
	            "   \"Name\": \"W\", " +
	            "   \"x\" : 400, " +
	            "   \"y\" : 21, " +
	            "   \"Width\" : 50, " +
	            "   \"Height\" : 100, " +
	            "  }, " +
	            "  {" +
	            "   \"ID\": \"Zone\", " +
	            "   \"Name\": \"ZonA\", " +
	            "   \"x\" : 400, " +
	            "   \"y\" : 21, " +
	            "   \"Width\" : 50, " +
	            "   \"Height\" : 100, " +
	            "  }, " +
	            "  {" +
	            "   \"ID\": \"WalkingMan\", " +
	            "   \"Name\": \"Kalle\", " +
	            "   \"Start\" : \"ZonA\", " +
	            "   \"Goal\" : \"ZonB\", " +
	            "   \"Commands\": [{ \"ID\": \"Rest\", \"Time\": \"10\" },{ \"ID\": \"GoTo\", \"ZoneName\": \"ZonB\" }]" +
	            "  }" +
	            "  ]" +
	            "}";
	         
		JSONObject obj = new JSONObject(alla);
	        
		SpawnerObjects objects = new SpawnerObjectsFromJson(obj);
		
		List<SpecGameObject> listan = new ArrayList<>(objects.getObjectsToSpawn());
		assertEquals(3, listan.size());
		assertEquals("W", listan.get(0).getNamn());
		assertEquals("ZonA", listan.get(1).getNamn());
		assertEquals("Kalle", listan.get(2).getNamn());
	}

	@Test
	public void objectsFromJsonFile() throws IOException {
		JSONObject json = jsonFromFile("enVaggEnZonTvaGubbar.json");
	        
		SpawnerObjects objects = new SpawnerObjectsFromJson(json);
		
		List<SpecGameObject> listan = new ArrayList<>(objects.getObjectsToSpawn());
		assertEquals(4, listan.size());
	}

	private JSONObject jsonFromFile(String filnamn) throws IOException {
		InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream(filnamn);
		JSONTokener x = new JSONTokener(fis);
		JSONObject json = new JSONObject(x);
		fis.close();

		return json;
	}
}
