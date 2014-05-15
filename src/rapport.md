Super Bullet Hell

\* Programbeskrivning. Beskriv detaljerat vad programmet gör.

**A)**
Programmet kommer att vara ett bullet hell spel. Det vill säga ett spel där användaren styr en figur som visas på skärmen och ska där akta sig för diverse objekt som flyger omkring på skärmen då dessa annars kommer att döda honom vid kontakt. Spelet utspelar sig i en 1280x720 pixlar stor ruta och spelarens karaktär styrs med tangentbordet. Användarens uppgift är endast att överleva så lång tid som möjligt. Spelet tar aldrig slut och man kan därför inte “vinna” utan istället sparas spelarens high score för den nuvarande sessionen och kommer att visas uppe i hörnet hela tiden. Spelarens score är lika med antalet sekunder denna har överlevt.

Om vi får tid kan eventuellt mer avancerade kulor implementeras. Det kan t.ex. finnas exploderande kulor eller kulor som skjuter ut fler kulor.

**B)**
Vi valde en större upplösning på 1600x900. Spelet kan aldrig ta slut, men vi valde att sätta in en “dödsgräns” vid en viss svårighetsgrad där helt enkelt alldeles för många fiender kommer på samma gång. Vi valde detta för presentationens skull. Spelarens score beräknas ej med antalet sekunder utan ökar istället baserat på antalet “tick” som har gått i spelet.

**C)**
Vi valde en större upplösning av den anledning att vi kände att 1280x720 var för litet. Det fanns egentligen teknisk anledning utan helt enkelt det som kändes bäst.
Att öka spelarens score baserat på antal ticks istället för sekunder baserade sig på att en spelare som laggar (färre ticks/sekund) inte skall kunna få större score tack vare detta lagg.

\* Användarbeskrivning. Vem kommer att använda ert program? Vilka antaganden gör ni om användarna? Är de vana datoranvändare, är de specialister, nybörjare, små barn, etc.

**A**)
Programmet kommer att användas av datorspelare, vi gör därför antagandet att de är erfarna att använda datorn genom det grafiska användarsnittet och har mindre erfarenhet att använda terminalen (terminalen är ingenting användaren kommer att behöva använda sig av för att använda vårt program).

**B)**
Ingen ändring, vi paketerade upp en .jar-fil för användaren.

**C)**
Ingen ändring.

\* Användarscenarier. Ge minst två exempel på scenarier där en av era tänkta användare använder programmet. Beskriv i detalj vad de ser, vilken typ av input de måste ge, hur de ger sin input och hur programmets output ser ut.

**A)**
Scenario 1: Kalle bor i jakobsberg och är 15 år gammal. Han tycker att nya spel är för lätta och att de har alldeles för många funktioner. Har blir tipsad av en kompis om hur bra Super Bullet Blast är och prövar på spelet. Han tycker det är lagom utmanande och precis vad han vill ha.

Scenario 2: Jan och John är bröder och tävlar i allt. När de får nys om Super Bullet Hell bestämmer de sig för att tävla även i detta. Eftersom spelet har en inbyggd high score funktion råder inga tvivel om vem som är den regerande mästaren i spelet av de två bröderna.

**B)**
Vi antar att detta relaterar till användartester.
Vi har testat på Johans lillebror och Andrés kompis. De förstod spelet, men gillade det inte.

**C)**
I våra användarscenarior gillade personerna spelet.

\* Testplan. Beskriv hur ni tänker testa programmet. I den här uppgiften ska ni lägga extra vikt vid användartestning. Beskriv vilka uppgifter som testanvändaren ska utföra. De två användarscenarierna ska ingå i användartestningen.

**A)**
Testning kommer främst utföras genom skrivning av testfall och att köra programmet och se ifall fel kan hittas. Att låta testanvändaren helt enkelt spela spelet om och om igen är nog det mest praktiska alternativet vi har med tanke på den tid vi har på oss. För att relatera till scenario 2 kommer vi även att låta två användare tävla mot varandra för att testa den funktionen.

**B)**
I praktiken skedde noll skrivning av tester. Vi spelade spelet väldigt mycket däremot och löste främst våra buggar på det sättet. Vi hade en förvånansvärt buggfri design som var lätt att använda och utöka.

**C)**
I A skrev vi att vi skulle testa genom testfall men också köra programmet. Vi nämnde att det senare skulle vara det mer praktiska alternativet och det var också det vi valde i B. En stor anledning till att vi inte skrev tester var att programmet fungerade. Vi skapade väldigt få buggar och de vi skapade var väldigt lätta att lösa. Tester är viktiga att ha i en kodbas som kommer att utvecklas och användas under en lång tid men eftersom detta är ett “skriv och släng iväg” projekt som inte kommer att användas mer kändes bristen på tester som ett helt acceptabelt val.

\* Programdesign. Beskriv de grundläggande klasserna som ni avser att implementera och ge en beskrivning av de viktigaste metoderna i varje klass.

**A)**
- Entity
Entity är ett interface där dessa följande metoder är det viktigaste:
```
    /**
    * Is the object collideable/solid?
    **/
    boolean isIntersectable();

    /**
     * Called at each draw, lets the object draw to the canvas g.
     **/
    void draw(Graphics g);

    /**
     * Called for each game tick, used for book keeping and other things
     **/
    void tick();
```

Alla objekt på skärmen implementerar detta interface

Player är en klass som implementerar entity. Denna ska hålla koll på all data gällande spelaren. 

Bullet är en klass som implementerar entity. Denna ska hålla koll på all data gällande bullets. En instans av denne motsvarar en bullet.

Mainklassen håller koll på gamestate. Den äger t.ex. en lista av entities och denna klass innehåller vår gameloop.

**B)**
Vi hade ett ScreenEntity-interface som alla saker på skärmen implementerade. Vi hade två huvudklasser, EnemyEntity och PlayerEntity för de saker som var på skärmen (spelaren var en PlayerEntity, allt annat EnemyEntity). Vi hade ingen Bullet-klass, istället är alla kulor EnemyEntity:s. Game-klassen höll koll på gamestate och sådant.

**C)**
Vi hade inga större skillnader mellan det planerade och det utförda. Den största skillnaden var att vi inte någon Bullet-klass och detta skedde främst då vi märkte att EnemyEntity hade all funktionalitet som krävdes av en hypotetisk Bullet-klass.

\* Tekniska frågor. En lista av tekniska frågor som ni måste hantera när ni bygger ert system. Var så detaljerad som möjligt. Ett viktigt steg mot en god design är att få ner så många frågor som möjligt på papper på ett organiserat sätt med så många förslag till lösningar som möjligt.

**A)**
Kollisionsberäkning: Ett sätt att kolla detta är att helt enkelt loopa över liatan med entity. Eftersom endast spelaren kan kollidera med skotten går detta på linjär tid. Väljer vi dock att låta allt kollidera blir detta kvadratiskt.

**B)**
Vi löste det som vi beskrev i A, med linjär tid.

**C)**
Ingen skillnad.


\* Arbetsplan. Beskriv hur arbetet kommer att delas upp mellan personerna i projektet. Gör en tidsplan som visar när olika delmoment i projektet ska vara klara.

**A)**
Vi använder Github tillsammans med git för att koordinera och sammanställa kod.

Vi har satt upp ett antal milestones.
Milestones:
- Grundläggande interfacet (andre) (1:a maj)
- huvudansvar för mainklassen (Johan) (11:e maj)
- Få spelaren att röra på sig och ritas ut på skärmen (andre) (5:e maj)
- Ladda in bilder (johan) (3:e maj)
- Avfyra den första kulan (johan) (10:e maj)
- Ladda in bakgrund (johan) (8:e maj)
- Låt bakgrunden röra på sig (andre) (10:e maj)
- spelet klart (13:e maj)

**B)**
Vi började med att bry oss om milestones men detta ändrades så snart spelet blev körbart och vi gick över till att diskutera vad vi bör implementera härnäst via Skype. Vi hade dessa Skype-möten ungefär var tredje dag. Vi använde Github för att sammanställa kod men inte för att koordinera. Vi struntade i att ha bilder och en bakgrund som rörde på sig, vi skrev dock en ImageLoader-klass.

**C)**
Med tanke på att vi endast var två personer kändes det onödigt att koordinera via Github, att göra det via Skype var mer effektivt. Tyvärr tappar vi då en logg över hur utvecklingen såg ut, vi har dock kvar commit-loggen vilket ger något hum om vad som hände.
Milestones var bra att ha i början för att ha något att gå efter men när de milestones vi skrev i rapporten var uppfyllda valde vi att skrota konceptet och använda oss av Skype-samtal istället. Detta främst för att det var lätt att hålla i huvudet vad som behövde göras och vad som kom härnäst.
Vi skrotade bilder och en bakgrund i rörelse av den helt och hållet konstnärliga anledningen att fyrkanter på en svart bakgrund såg coolare ut.