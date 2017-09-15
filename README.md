# HFSim
Simulate

Försök till simulering av resandeströmmar

Kvar att göra:

Klart:




Noteringar från landet:
HFSimulate


KLAR - skapa githubkonto
KLAR - Göra helloworld på Github
Koppla lokalt gitrepo till github
Testa checka in fil på github 
	jobba mkt m brancher. git

Börja fundera på filformat för simuleringsfilerna
	json?
	struktur på objekt
		namn
		x1,y1,x2,y2
		zoner
		typer
			solid
			gåtillzon

skapa workspace i eclipse kopplat till github
	ws ska vara mavenproj o ha mvnstd på kataloger. 
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