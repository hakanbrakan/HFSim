# HFSim
Simulate

Försök till simulering av resandeströmmar

Kvar att göra:
Skapa ny sida för todo	
merga loggning till master
ta bort loggning branch
Länkar att läsa
http://gameprogrammingpatterns.com/game-loop.html
http://gameprogrammingpatterns.com/contents.html
https://lwjglgamedev.gitbooks.io/3d-game-development-with-lwjgl/content/chapter2/chapter2.html
http://web.archive.org/web/20140402204854/http://www.altdevblogaday.com/2011/02/24/introduction-to-behavior-trees/
http://alumni.media.mit.edu/~jorkin/goap.html
Zoner
Escape ska ta fram menyn där man kan välja att avsluta
En gubbe som går från zon a till zonC och då avslutas simuleringen
Skapa spawner från fil

Avstånd i meter - Converterklass
Tid i minuter o sekunder
När tar simuleringen slut? 
	Alla movingobjects borta?
	Alla mål uppfullda?
Rutt eller möjligen kommands är delmål
	tex zon a, c, ståstill 3min , d e
	stanna, move, spring, vänta, removeobj, goalreached
Spawna många till en zon - startsituation


Klart:
<br>Skapa githubkonto
<br>Göra helloworld på Github
<br>Koppla lokalt gitrepo till github
<br>Testa checka in fil på github 
<br>Skapa workspace i eclipse kopplat till github
<br>Workspace ska vara mavenproj o ha mvnstd på kataloger. 
<br>Checka in när en bra status
<br>Få igång loggning




http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
https://stackoverflow.com/questions/194765/how-do-i-get-java-logging-output-to-appear-on-a-single-line
https://github.com/GoogleCloudPlatform/getting-started-java/blob/master/bookshelf-standard/5-logging/src/main/webapp/WEB-INF/logging.properties
http://docs.oracle.com/javase/7/docs/api/index.html?java/util/logging/SimpleFormatter.html
https://stackoverflow.com/questions/9457976/java-logging-where-is-my-log-file


Noteringar från landet:

Börja fundera på filformat för simuleringsfilerna
	json?
	struktur på objekt
		namn
		x1,y1,x2,y2
		zoner
		typer
			solid
			gåtillzon

klasser ska ha testklasser
I Git checka in enkel htmlsida m mina länkar för detta proj, tex för component pattern


Man kanske ska dela upp simuleringsfilen i två. en för kartan med zoner man ska gå till och en med
genererade gubbar.
säg att man specar 100 gubbar av den sorten med det målet som kommer var x:e sekund samt två stillastående
gubbar, då kan en generator skapa alla dessa gubbar med starttider och platser så kan man sedan utifrån 
samma resandeström se hur det blir med olika hinder på vägen tex i form av en ny vägg helt plötsligt
eller med en stillastående gubbe mitt i osv.

Nya tankar 20170805
En fil som specar 100 gubbar av den sorten
simulering startar m att initiera alla gubbar. Skapa dessa 100 o lägg dem i en kö i rätt ordning som de ska 
placeras ut på plan om de får plats. En apperancequeue. Varje gubbe har ett startnr som de får i initfasen
Skapa ett transformerobjekt från "100 gubbar" till dessa 100 i rätt ordning. - Klar

Skapa gui som öppnar simuleringsfil o kör simuleringen, kanske i annat fönster
	för att öht taget komma igång o göra något så börjar vi enkelt m steg 1
	skapa en app m menyval
		javafx? swing?
	öppna o läsa in fil (json?)
		file open - simuleringsfil
		jackson el dyl, kanske java8 förstår json
	skapa simuleringsfil
		två väggar, startzon, slutzon, två gubbar
	starta sim m animerade gubbar
		första försöket är busenkel AI. Två gubbar som går spikrakt åt motsatt håll
			kanske den ena startar lite senare än den andra
		game loop i egen tråd?
			ta bästa exemplet på game loop från http:....
		Bygg gubbarna enl component pattern


Köra repris på en simulering - kräver att simuleringen loggade alla rörelser

Gui som skapar fil o kanske genererar upp alla gubbar
