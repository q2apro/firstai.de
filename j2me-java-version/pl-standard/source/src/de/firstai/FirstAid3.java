// POLISH 2012-07-31
package de.firstai;

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

import de.enough.polish.ui.UiAccess;


public class FirstAid3 extends MIDlet implements CommandListener {

	boolean started = false;
	Form details;
	Display display;
	List menu;
	List telEmergency;

	// setup of the navigation buttons
	static final Command cmdBack = new Command("Z powrotem", Command.BACK, 2);
	static final Command cmdExit = new Command("Exit", Command.EXIT, 2);

	StringItem aid_disclaimer, aid_general, aid_allergic, aid_asthma, aid_amputation, aid_apnoea, aid_checkbreathing, aid_eyeinjury, aid_chemicalburneyes, 
	aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_bleedinglight, aid_bleedingsevere, aid_diabeticcoma, aid_diarrhoea, aid_icerescue, aid_electricityaccident, aid_epilepsy, 
	aid_vomiting, aid_frostbitemild, aid_frostbitesevere, aid_suffocation, aid_drowning, aid_birth, aid_dangerzone, aid_brainconcussion, aid_resuscitation, aid_heartattack, aid_hyperthermia, 
	aid_insectstings, aid_fracture, aid_nosebleeding, aid_emergencycall, aid_backinjury, aid_skullfracture, aid_stroke, aid_snakebite, aid_shock, aid_sunburn, aid_sunstroke, 
	aid_sos, aid_recoveryposition, aid_animalbite, aid_safeguardaccident, aid_hypothermia, aid_hypoglycaemia, aid_chemicalburn, aid_burningslight, aid_burningsevere, aid_poisining, 
	aid_sprain, separator;

	StringItem[] stringItemArray;
	Image aid001, aid003, aid008, aid009, aid010, aid011, aid012, aid013, aid019, aid022;
	Image aid023, aid025, aid028, aid029, aid030, aid031, aid034, aid041, aid045, aid058;
	Image aid061, aid065, aid067, aid069, aid084, aid085, aid089, aid092, aid107;
	Image imageCC;

	StringItem stringAfrica;
	StringItem stringAsia;
	StringItem stringEurope;
	StringItem stringNorthamerica;
	StringItem stringOceania;
	StringItem stringSouthamerica;
	
	public FirstAid3() {

		this.menu = new List("Pierwsza pomoc w twoim telefonie", Choice.IMPLICIT);
		this.menu.append("# Odpowiedzialność i informacje", null);
		this.menu.append("# Numery alarmowe", null);
		this.menu.append("# Ogólne postępowania", null);
		this.menu.append("Amputacja", null);
		this.menu.append("Astma", null);
		this.menu.append("Atak", null);
		this.menu.append("Atak serca", null);
		this.menu.append("Bezdech", null);
		this.menu.append("Biegunka", null);
		this.menu.append("Duszenie", null);
		this.menu.append("Duszności", null);
		this.menu.append("Grozny obszar (Ratowanie)", null);
		this.menu.append("Hiperglikemia (cukier)", null);
		this.menu.append("Hipertermia (gorące ciało)", null);
		this.menu.append("Hipoglikemia (niski poziom cukru)", null);
		this.menu.append("Hipotermia (schłodzenia ciała)", null);
		this.menu.append("Kompresja klatki piersiowej", null);
		this.menu.append("Krwawienie ciężkie", null);
		this.menu.append("Krwawienie słabe", null);
		this.menu.append("Krwawienie z nosa", null);
		this.menu.append("Narodziny", null);
		this.menu.append("Nieświadomości z oddychaniem", null);
		this.menu.append("Numer alarmowy", null);
		this.menu.append("Oddychanie", null);
		this.menu.append("Odmrożenie ciężką", null);
		this.menu.append("Odmrożenie łagodne", null);
		this.menu.append("Padaczka", null);
		this.menu.append("Połknięcie/Zadławienie", null);
		this.menu.append("Poparzenie  słabe", null);
		this.menu.append("Poparzenie chemikaliami", null);
		this.menu.append("Poparzenie ciężkie", null);
		this.menu.append("Poparzenie oczu chemikaliami", null);
		this.menu.append("Poparzenie słoneczne", null);
		this.menu.append("Porażenie słoneczne", null);
		this.menu.append("Pozycja bezpieczna", null);
		this.menu.append("Ratowanie z lodu", null);
		this.menu.append("Ratowanie z lodu", null);
		this.menu.append("Reakcje alergiczne", null);
		this.menu.append("Reanimacja", null);
		this.menu.append("SOS", null);
		this.menu.append("Śpiączką cukrzycową", null);
		this.menu.append("Sprawdź Oddech", null);
		this.menu.append("Świadomości bez oddychania", null);
		this.menu.append("Szok", null);
		this.menu.append("Tonięcie", null);
		this.menu.append("Ugryzienia owadów", null);
		this.menu.append("Ugryzienie zwierzęcia", null);
		this.menu.append("Ukąszenie wężą", null);
		this.menu.append("Urazy kręgosłupa", null);
		this.menu.append("Uszkodzenie oka", null);
		this.menu.append("Wstrząs mózgu", null);
		this.menu.append("Wymioty", null);
		this.menu.append("Wypadek drogowy", null);
		this.menu.append("Wypadek elektryczny", null);
		this.menu.append("Wypadek samochodowy", null);
		this.menu.append("Zatrucie", null);
		this.menu.append("Złamania kręgu rdzeniowego", null);
		this.menu.append("Złamanie", null);
		this.menu.append("Złamanie czaszki", null);
		this.menu.append("Zwichnięcia i nadwyrężenia", null);
		this.menu.append("-------------", null);
		this.menu.append("Volejte záchrannou službu 112", null);

		
		// commands
		this.menu.addCommand(cmdExit);
		this.menu.setCommandListener(this);

		details = new Form ("Pierwsza pomoc w twoim telefonie");

		/**** Init the Images ****/
		try { aid001 = Image.createImage ("/aid001.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid003 = Image.createImage ("/aid003.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid008 = Image.createImage ("/aid008.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid009 = Image.createImage ("/aid009.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid010 = Image.createImage ("/aid010.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid011 = Image.createImage ("/aid011.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid012 = Image.createImage ("/aid012.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid013 = Image.createImage ("/aid013.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid019 = Image.createImage ("/aid019.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid022 = Image.createImage ("/aid022.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }

		try { aid023 = Image.createImage ("/aid023.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid025 = Image.createImage ("/aid025.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid028 = Image.createImage ("/aid028.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid029 = Image.createImage ("/aid029.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid030 = Image.createImage ("/aid030.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid031 = Image.createImage ("/aid031.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid034 = Image.createImage ("/aid034.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid041 = Image.createImage ("/aid041.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid045 = Image.createImage ("/aid045plug.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid058 = Image.createImage ("/aid058.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }

		try { aid061 = Image.createImage ("/aid061.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid065 = Image.createImage ("/aid065.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid067 = Image.createImage ("/aid067.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid069 = Image.createImage ("/aid069.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid084 = Image.createImage ("/aid084.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid085 = Image.createImage ("/aid085.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid089 = Image.createImage ("/aid089.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid092 = Image.createImage ("/aid092.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid107 = Image.createImage ("/aid107.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		
		try { imageCC = Image.createImage ("/cc88x31.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
	}

	public void startApp() {
		if (!started) {
			// emergency numbers list
			telEmergency = new List ("Kontynent", Choice.IMPLICIT);
			telEmergency.append("Afryka", null);
			telEmergency.append("Azja", null);
			telEmergency.append("Europa", null);
			telEmergency.append("Północna i centralna ameryka", null);
			telEmergency.append("Oceania", null);
			telEmergency.append("Południowa ameryka", null);
			telEmergency.addCommand(cmdBack);
			telEmergency.setCommandListener(this);
			stringAfrica = new StringItem("- Afryka - ", "\n\n# Algieria\nPol:17 | Med:17 | Ogień:14\n\n# Angola\nPol:110 | Med:118 | Ogień:118\n\n# Benin\nPol:17 | Med:301769 | Ogień:18\n\n# Botswana\nPol:999 | Med:997 | Ogień:998\n\n# Burkina Faso\nPol:17 | Med:* (Lokalne numery) | Ogień:18\n\n# Burundi\nPol:* (Bez systemu) | Med:* (Bez systemu) | Ogień:* (Bez systemu)\n\n# Kamerun\nPol:17 | Med:* (Lokalne numery) | Ogień:18\n\n# Wyspy Zielonego Przylądka\nPol:132 | Med:130 | Ogień:131\n\n# Republika Środkowoafrykańska\nPol:611253 | Med:610600 | Ogień:118\n\n# Czadzie\nPol:17 | Med:* (Lokalne numery) | Ogień:18\n\n# Komory\nPol:* (Tylko telefony radiowe) | Med:* (Tylko telefony radiowe) | Ogień:* (Tylko telefony radiowe)\n\n# Kongo (Republika Demokratyczna)\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Kongo (Republika)\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Dżibuti\nPol:17 | Med:351351 | Ogień:18\n\n# Egipt\nPol:122 | Med:123 | Ogień:180\n\n# Gwinea Równikowa\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Erytreę\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Etiopia\nPol:91 | Med:92 | Ogień:93\n\n# Gabon\nPol:1730 | Med:1300 | Ogień:18\n\n# Gambia\nPol:117 | Med:116 | Ogień:118\n\n# Ghana\nPol:191 | Med:193 | Ogień:192\n\n# Gwinei\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Gwinei Bissau\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Wybrzeże Kości Słoniowej\nPol:110 | Med:110 | Ogień:180\n\n# Kenia\nPol:999 | Med:999 | Ogień:999\n\n# Lesoto\nPol:123 | Med:121 | Ogień:122\n\n# Liberii\nPol:911 | Med:911 | Ogień:911\n\n# Libia\nPol:193 | Med:193 | Ogień:193\n\n# Madagaskar\nPol:117 | Med:2262566 | Ogień:18\n\n# Malawi\nPol:199 | Med:199 | Ogień:199\n\n# Mali\nPol:17 | Med:15 | Ogień:18\n\n# Mauretania *\nPol:117 | Med:* (Lokalne numery) | Ogień:118\n\n# Mauritius *\nPol:999 | Med:999 | Ogień:999\n\n# Majotta\nPol:112 | Med:15 | Ogień:603054\n\n# Maroko\nPol:19 | Med:15 | Ogień:15\n\n# Mozambik\nPol:119 | Med:117 | Ogień:198\n\n# Namibii\nPol:1011 | Med:2032276 | Ogień:2032270\n\n# Nigru\nPol:17 | Med:723141 | Ogień:18\n\n# Nigerii\nPol:119 | Med:199 | Ogień:190\n\n# Reunion\nPol:17 or 112 * (112 komórkowy) | Med:15 or 112 * (112 komórkowy) | Ogień:18 or 112 * (112 komórkowy)\n\n# Ruanda\nPol:112 | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Saharyjskich Arabskiej Republiki Demokratycznej\nPol:-- | Med:-- | Ogień:--\n\n# Wysp Świętego Tomasza i Książęcej\nPol:-- | Med:-- | Ogień:--\n\n# Senegalu\nPol:* (Lokalne numery) | Med:8891515 | Ogień:* (Lokalne numery)\n\n# Seszele\nPol:999 | Med:999 | Ogień:999\n\n# Sierra Leone\nPol:999 | Med:999 | Ogień:999\n\n# Somalii\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Republika Południowej Afryki\nPol:10111 | Med:10177 | Ogień:10111\n\n# Sudanie\nPol:999 | Med:* (Lokalne numery) | Ogień:999\n\n# Suazi\nPol:999 | Med:6060911 | Ogień:* (Lokalne numery)\n\n# Tanzanii\nPol:112 | Med:112 | Ogień:112\n\n# Togo\nPol:101 | Med:191 | Ogień:118\n\n# Tunezja\nPol:197 | Med:190 | Ogień:198\n\n# Uganda\nPol:999 or 111 * (112 komórkowy) | Med:999 or 111 * (112 komórkowy) | Ogień:999 or 111 * (112 komórkowy)\n\n# Zambii\nPol:999 or 112 * (112 komórkowy) | Med:991 or 112 * (112 komórkowy) | Ogień:993 or 112 * (112 komórkowy)\n\n# Zimbabwe\nPol:995 | Med:994 | Ogień:993");
			
			stringAsia = new StringItem("- Azja - ", "\n\n# Afganistan\nPol:-- | Med:112 | Ogień:--\n\n# Armenia\nPol:102 | Med:103 | Ogień:101\n\n# Azerbejdżan\nPol:102 | Med:103 | Ogień:101\n\n# Bahrajn\nPol:999 | Med:999 | Ogień:999\n\n# Bangladeszu\nPol:8665513 | Med:199 | Ogień:9555555\n\n# Bhutan\nPol:110 | Med:112 | Ogień:113\n\n# Brunei\nPol:993 | Med:991 | Ogień:995\n\n# Kambodża\nPol:117 | Med:199 | Ogień:118\n\n# Chiny\nPol:110 | Med:120 | Ogień:119\n\n# Timoru Wschodniego\nPol:112 | Med:7233212 | Ogień:--\n\n# Gruzja\nPol:022 | Med:022 | Ogień:022\n\n# Hong Kong\nPol:999 | Med:999 | Ogień:999\n\n# Indie\nPol:100 | Med:102 | Ogień:101\n\n# Indonezja\nPol:110 | Med:118 | Ogień:113\n\n# Iran\nPol:110 or 112 * (112 komórkowy) | Med:115 or 112 * (112 komórkowy) | Ogień:125 or 112 * (112 komórkowy)\n\n# Iraku\nPol:* (Bez systemu) | Med:* (Bez systemu) | Ogień:* (Bez systemu)\n\n# Izrael\nPol:100 | Med:101 | Ogień:102\n\n# Japonia\nPol:110 | Med:119 | Ogień:119\n\n# Jordan\nPol:192 | Med:193 | Ogień:193\n\n# Kazachstan\nPol:03 | Med:03 | Ogień:03\n\n# Kurdystan\nPol:129 | Med:115 | Ogień:125\n\n# Kuwejt\nPol:777 | Med:777 | Ogień:777\n\n# Kirgistan\nPol:133 | Med:03 | Ogień:03\n\n# Laos\nPol:* (Lokalne numery) | Med:03 | Ogień:* (Lokalne numery)\n\n# Liban\nPol:112 | Med:140 | Ogień:175\n\n# Makau\nPol:999 | Med:999 | Ogień:999\n\n# Malezja\nPol:999 or 112 * (112 komórkowy) | Med:999 or 112 * (112 komórkowy) | Ogień:999 or 112 * (112 komórkowy)\n\n# Malediwy\nPol:119 | Med:102 | Ogień:118\n\n# Mongolii\nPol:102 | Med:103 | Ogień:101\n\n# Myanmar\nPol:199 | Med:199 | Ogień:199\n\n# Nepalu\nPol:100 | Med:228094 | Ogień:101\n\n# Korea Północna\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Oman\nPol:999 | Med:999 | Ogień:999\n\n# Pakistan\nPol:15 | Med:115 | Ogień:16\n\n# Filipiny\nPol:117 | Med:117 | Ogień:117\n\n# Katar\nPol:999 | Med:999 | Ogień:999\n\n# Arabia Saudyjska\nPol:999 | Med:997 | Ogień:998\n\n# Singapur\nPol:999 | Med:995 | Ogień:995\n\n# Korea Południowa (Republika Korei)\nPol:112 | Med:119 | Ogień:119\n\n# Sri Lanka\nPol:119 or 112 * (112 komórkowy) | Med:110 | Ogień:111\n\n# Syrii\nPol:112 | Med:110 | Ogień:113\n\n# Tajwan\nPol:110 | Med:119 | Ogień:119\n\n# Tadżykistan\nPol:02 | Med:03 | Ogień:* (Lokalne numery)\n\n# Tajlandia\nPol:191 * Lub (1155 turystów) | Med:191 | Ogień:199\n\n# Turkmenistan\nPol:03 | Med:03 | Ogień:03\n\n# Zjednoczone Emiraty Arabskie\nPol:999 | Med:998 | Ogień:997\n\n# Uzbekistan\nPol:03 | Med:03 | Ogień:03\n\n# Wietnam\nPol:113 | Med:115 | Ogień:114\n\n# Jemen\nPol:199 | Med:199 | Ogień:199");

			stringEurope = new StringItem("- Europa - ", "\n\n# Albania\nPol:19 | Med:17 | Ogień:18\n\n# Andora\nPol:110 | Med:118 | Ogień:118\n\n# Austria\nPol:112 | Med:112 | Ogień:112\n\n# Białoruś\nPol:02 | Med:03 | Ogień:01\n\n# Belgia\nPol:112 | Med:112 | Ogień:112\n\n# Bośnia i Hercegowina\nPol:122 | Med:124 | Ogień:123\n\n# Bułgaria\nPol:112 | Med:112 | Ogień:112\n\n# Chorwacja\nPol:92 | Med:94 | Ogień:93\n\n# Cypr\nPol:112 | Med:112 | Ogień:112\n\n# Republika Czeska\nPol:112 | Med:112 | Ogień:112\n\n# Dania\nPol:112 | Med:112 | Ogień:112\n\n# Estonia\nPol:112 | Med:112 | Ogień:112\n\n# Finlandia\nPol:112 | Med:112 | Ogień:112\n\n# Francja\nPol:17 or 112 | Med:15 or 112 | Ogień:18 or 112\n\n# Niemcy\nPol:110 | Med:112 | Ogień:112\n\n# Grecja\nPol:112 | Med:112 | Ogień:112\n\n# Węgry\nPol:112 | Med:112 | Ogień:112\n\n# Islandia\nPol:112 | Med:112 | Ogień:112\n\n# Irlandia\nPol:112 | Med:112 | Ogień:112\n\n# Włochy\nPol:112 | Med:112 | Ogień:112\n\n# Kosowo\nPol:911 | Med:911 | Ogień:911\n\n# Łotwa\nPol:112 | Med:112 | Ogień:112\n\n# Liechtenstein\nPol:112 | Med:112 | Ogień:112\n\n# Litwa\nPol:112 | Med:112 | Ogień:112\n\n# Luksemburg\nPol:112 | Med:112 | Ogień:112\n\n# Macedonii\nPol:112 | Med:112 | Ogień:112\n\n# Malta\nPol:112 | Med:112 | Ogień:112\n\n# Mołdowa\nPol:902 | Med:903 | Ogień:901\n\n# Monako\nPol:112 | Med:112 | Ogień:112\n\n# Czarnogóra\nPol:112 | Med:112 | Ogień:112\n\n# Holandia\nPol:112 | Med:112 | Ogień:112\n\n# Norwegia\nPol:112 | Med:113 | Ogień:110\n\n# Polska\nPol:112 | Med:112 | Ogień:112\n\n# Portugalia\nPol:112 | Med:112 | Ogień:112\n\n# Rumunia\nPol:112 | Med:112 | Ogień:112\n\n# Rosja\nPol:02 | Med:03 | Ogień:01\n\n# San Marino\nPol:112 | Med:113 | Ogień:116\n\n# Serbia\nPol:112 | Med:112 | Ogień:112\n\n# Słowacja\nPol:112 | Med:112 | Ogień:112\n\n# Słowenia\nPol:113 | Med:112 | Ogień:112\n\n# Hiszpania\nPol:112 | Med:112 | Ogień:112\n\n# Szwecja\nPol:112 | Med:112 | Ogień:112\n\n# Szwajcaria\nPol:117 or 112 | Med: 144 or 112 | Ogień:118 or 112\n\n# Turcja\nPol:155 | Med:112 | Ogień:110\n\n# Ukraina\nPol:112 | Med:112 | Ogień:112\n\n# Wielka Brytania\nPol:112 | Med:112 | Ogień:112\n\n# Watykan\nPol:112 | Med:113 | Ogień:115");
			
			stringNorthamerica = new StringItem("- Północna i centralna ameryka - ", "\n\n# Antigua i Barbuda\nPol:911 | Med:911 | Ogień:911\n\n# Bahamy\nPol:911 | Med:911 | Ogień:911\n\n# Barbados\nPol:112 | Med:115 | Ogień:113\n\n# Belize\nPol:911 | Med:911 | Ogień:911\n\n# Kanada\nPol:911 | Med:911 | Ogień:911\n\n# Kajmany\nPol:911 | Med:911 | Ogień:911\n\n# Kostaryka\nPol:911 | Med:911 | Ogień:911\n\n# Kuba\nPol:26811 | Med:26811 | Ogień:26811\n\n# Dominika\nPol:999 | Med:999 | Ogień:999\n\n# Republika Dominikany\nPol:911 | Med:911 | Ogień:911\n\n# Salwador\nPol:911 | Med:911 | Ogień:911\n\n# Grenlandia\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Grenady\nPol:112 | Med:911 | Ogień:911\n\n# Gwatemala\nPol:110 | Med:123 | Ogień:122\n\n# Haiti\nPol:114 | Med:118 | Ogień:* (Lokalne numery)\n\n# Hondurasu\nPol:119 | Med:378654 | Ogień:198\n\n# Jamajka\nPol:119 | Med:110 | Ogień:110\n\n# Meksyk\nPol:080 | Med:060 | Ogień:060\n\n# Nikaragua\nPol:118 | Med:2651761 | Ogień:2650162\n\n# Panama\nPol:104 | Med:2699778 | Ogień:103\n\n# Saint Kitts i Nevis\nPol:17 | Med:15 | Ogień:18\n\n# Saint Lucia\nPol:911 | Med:911 | Ogień:911\n\n# Saint-Pierre i Miquelon\nPol:999 | Med:911 | Ogień:911\n\n# Saint Vincent i Grenadyny\nPol:911 | Med:911 | Ogień:911\n\n# Trynidad i Tobago\nPol:999 | Med:990 | Ogień:990\n\n# Stany Zjednoczone Ameryki\nPol:911 | Med:911 | Ogień:911");
			
			stringOceania = new StringItem("- Oceania - ", "\n\n# Australia\nPol:000 or 112 * (112 komórkowy) | Med:000 or 112 * (112 komórkowy) | Ogień:000 or 112 * (112 komórkowy)\n\n# Fidżi\nPol:911 | Med:911 | Ogień:9170\n\n# Kiribati\nPol:* (Lokalne numery) | Med:994 | Ogień:* (Lokalne numery)\n\n# Wyspy Marshalla\nPol:6258666 | Med:6254111  | Ogień:* (Lokalne numery)\n\n# Mikronezji\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Nauru\nPol:* (Lokalne numery) | Med:* (Lokalne numery) | Ogień:* (Lokalne numery)\n\n# Nowa Zelandia\nPol:111 | Med:111 | Ogień:111\n\n# Palau\nPol:911 | Med:911 | Ogień:911\n\n# Papua-Nowa Gwinea\nPol:000 | Med:* (Lokalne numery) | Ogień:110\n\n# Samoa\nPol:995 | Med:996 | Ogień:994\n\n# Wyspy Salomona\nPol:911 | Med:911 | Ogień:911\n\n# Tonga\nPol:922 | Med:933 | Ogień:999\n\n# Tuvalu\nPol:911 | Med:911 | Ogień:911\n\n# Vanuatu\nPol:112 | Med:112 | Ogień:112");
			
			stringSouthamerica = new StringItem("- Południowa ameryka - ", "\n\n# Argentyna\nPol:101 | Med:107 | Ogień:100\n\n# Boliwia\nPol:911 | Med:911 | Ogień:911\n\n# Brazylia\nPol:190 | Med:192 | Ogień:193\n\n# Chile\nPol:133 | Med:131 | Ogień:132\n\n# Kolumbia\nPol:119 | Med:119 | Ogień:119\n\n# Ekwador\nPol:101 | Med:131 | Ogień:102\n\n# Gujana\nPol:911 | Med:913 | Ogień:912\n\n# Paragwaj\nPol:911 | Med:911 | Ogień:911\n\n# Peru\nPol:105 | Med:116 | Ogień:116\n\n# Surinam\nPol:115 | Med:115 | Ogień:115\n\n# Urugwaj\nPol:911 | Med:911 | Ogień:911\n\n# Wenezuela\nPol:171 | Med:171 | Ogień:171");

			// First-Aid-Text
aid_disclaimer = new StringItem ("Odpowiedzialność i informacje", "1. Oprogramowanie \nPierwsza pomoc w twoim telefonie\nWersja: 3.0\nWydanie: x\nPrawa autorskie: Kai Kajus Noack\nTranslator: Robert Moleda\nLicencja: Creative Commons\n\nIlustracje  © Med4Teens\n\nTen program ma udzielić informacji na temat pierwszej pomocy. Jednakże, nie stanowi on  substytutu dla kursu pierwszej pomocy. Służy on raczej do odświeżenia już zdobytej wiedzy.\n\n2. Odpowiedzialność\nNależy pamiętać, że nie biorę żadnej odpowiedzialności za konsekwencje wynikające z korzystania z oprogramowania.\nJakakolwiek odpowiedzialności jest wyłączona!\nKorzstanie na własne ryzyko!\n\nWe wszystkich sytuacjach kryzysowych należy natychmiast szukać profesjonalnej pomocy.\n\n3. Rozwój projektu \nProgram ma stać się wielojęzyczny. Dobrowolni tłumacze potrzebni!\n\nWięcej informacji jest dostępnych w Internecie na www.firstai.de lub napisz e-maila na adres: @ firstai.de\n\nUratuj człowieka a uratujesz świat.");aid_general = new StringItem ("Ogólne postępowania", "1. Zawsze udzielaj pierwszej pomocy. Nie można popełnić żadnych błędów.\n2. Zawsze zwracaj uwagę na własne bezpieczeństwo.\n3. Zbadaj sytuacje i zabezpiecz miejsce wypadku.\n4. Dzwoń po pomoc i udzielaj pierwszej pomocy! \n5. Jeśli istnieje kilku poszkodowanych,  najbardziej poszkodowany ma pierwszeństwo.\n6. Staraj się zawsze uciszyć osoby poszkodowane i zachowaj sam spokój !\n7. Jeśli to możliwe ułożyć poszkodowanego wygodnie. Nigdy nie dawać alkoholu, nikotyny lub narkotyków osobie poszkodowanej");aid_allergic = new StringItem ("Reakcje alergiczne", "1. Zadzwoinić natychmiast po pogotowie.\n2. Staraj się uspokoić poszkodowanego i niech usiądzie wygodnie.\n3. Usuń powody uczulenia (np. żądło pszczoły) starannie.\n4. Chłodz dotkniętą skórę (mokre kompresy, lód).\n5. Jeśli poszkodowany ma antidotum, powinien go użyć (pomóż).\n6. Monitoruj stan ofiary aż przyjedzie ambulans.\n7. Jeśli poszkodowany utracił przytomności lub przestał oddychać, wykonaj następujące instrukcje!");aid_amputation = new StringItem ("Amputacja", "Amputowana część ciała może zostać przyszyta ponownie. Celem jest chłodzenie części amputowanej do dostarczenia do szpitala\n1.Uspokuj osobę, połóż ją i osłoń kocem\n2.Zatamuj krwawienie. Zobacz w programie pod krwawienie i szok\n3. Owiń amputowaną część suchą i czystą tkaniną i włóż część do wodoszczelnego worka plastikowego. \n4.Zamknij plastikową torbę i włóż ją do kolejnej plastikowej torby zawierającej zimną wodę lub lód \n5.Nie dawaj alkoholu, papierosów lub jedzenia poszkodowanemu, gdy w szpitalu będzie operacja w narkozie \n6.Nie zamrażaj części tylko ją chłodz\n7.Zadzwoń po karetkę lub zawiez sam do szpitala.");aid_animalbite = new StringItem ("Ugryzienie zwierzęcia", "UWAGA: Wysokie zagrożenie zakażenia. Wynikiem może być ropa, tężec, wścieklizna.\n1. Umyć ranę mydłem z ciepłą wodą.\n2. Następnie dezynfekować ranę.\n3. Jeśli nie ma silnego krwawienia, unieść tułów osoby .\n4. Stosować aseptyczny bandaż.\n5. Przyjedź do szpitala lub wezwij lekarza pogotowia.");aid_apnoea = new StringItem ("Bezdech", "Brak dźwięków oddechu lub ruchów, zauważalne przebarwienia na skórze.\n1. Dzwonić po pomoc.\n2. Połóż osobę na plecy.\n3. Usuń rzeczy z jamy ustnej i gardła. Wyciągnij głowę i szyie.\n4. Zaciśnij nos.\n5. Weź głęboki wdech i rób usta usta , tak że nie może uciec powietrze.\n6. Oddychaj powoli i pełnie.\n7. Jeśli bez powodzenia: kontynuuj tak długo, aż przyjedzie ambulans.");aid_asthma = new StringItem ("Astma", "Ciężkie duszności. Świszczący oddech . Niepokojenie się.\n1. Uspokój osobę. Zachowaj sam spokój!\n2. Poluzuj ubranie.\n3. Niech osoba siedzi i pochyla się do przodu, poproś o  powolny i głęboki oddech.\n4. Jeśli osoba posiada inhalator, powinna go użyć (pomagać jej). Po 5-10 min staje się on skuteczne.\n5. Jeżeli nie ma poprawy: Użyj inhalator co 5 min, aż przybędzie karetka.\n6. Dzwoń po pomoc..\n7. Jeśli pojawi się bezdech, zacznij z instrukcjami dla bezdechu.");aid_backinjury = new StringItem ("Urazy kręgosłupa", "Bóle pleców, zdrętwiałe ręce i nogi.\n1. Nie poruszaj poszkodowanego!\n2. Trzymaj głowę w sposób, aby osoba była stabilna (trzymać głowę miejscowo)\n3. Stabilizację wypadku z wzmacnia na stronie.\n4. Spokojna osoba.\n5. Dzwonić po pomoc , zwracać uwagę na urazy kręgosłupa.");aid_birth = new StringItem ("Narodziny", "Wypływ płynów .Bóle kontrakcyjne . Nieoczekiwane narodziny.\n1. Zwróć uwagę, aby zachować prywatność i spokój! - Dzwonienie po pomoc.\n2. Niech  kobieta w ciąży odsłoni dolną część swojego ciała usiądzie na sterylnym podkładzie z  rozłożonymi nogami.\n3.Zgiąć kolana. Wyciągnąć nogi. Biodra lekko w górę. - Narodziny są naturalnym procesem i działają głównie bez komplikacji.\n4. Uspokoić kobietę, pozwolic jej skoncentrować się na oddychaniu: wdychać przez nos, wydychać przez usta (w normalnej prędkości).\n5. Rytm naciskania: Weź głęboki oddech, oddech przytrzymaj i naciśnij. Jak tylko pojawi się głowa dziecka, wspierać chwytając je z obydwoma dłoniami.\n6. Po urodzeniu dziecka: Trzymaj dziecko skosem z głową w dół, aby wyzwolić z dróg oddechowych płynz. (Być może należy wyssać płynu z nosa dziecka przez usta.) Dziecko musi  krzyczeć i oddychać!\n7. Zawiąż  pępowinę 30 cm od dziecka (może być również zrobione w szpitalu). Dbaj o sterylność pochwy matki.\n8. Wysusz dziecko i dbaj o jego ciepło. Zwróć uwagę na czas i jedz do szpitala.");aid_bleedinglight = new StringItem ("Krwawienie słabe", "Cel: Zatrzymaj krwawienie.\n1. Nie należy dotykać rany (niebezpieczeństwo zakażenia).\n2. Nie należy traktować  rany proszkiem, maścią lub sprejem.\n3.Osłoń ranę przy pomocy sterylnych materiałów i bandaży.\n4. Na niewielkie krwawienie plaster jest często wystarczający.\n5. Jeśli rana jest duża użyj bandaż. Nie zaciskaj  za mocno, bo może to doprowadzić do zwiększonego krwawienia.\n6. Uwaga: rany wścieklizny muszą być myte w roztworze mydła.");aid_bleedingsevere = new StringItem ("Krwawienie ciężkie", "Rzylewanie, pulsująca krew. Niebezpieczeństwo: gardzieli z powodu utraty krwi, zakażenia, śmierć. Cel: Zatrzymaj krwawienie.\n1. Usuń ubrania (cięcie, jeśli to konieczne) i odsłoń rany.\n2. Przykleić plaster lub w razie konieczności, gazę z ciśnieniem wokół rany.\n3. Wywieraj nacisk przez co najmniej 10 min.\n4. Jeśli bandaż jest nasączony  krwią, nie należy go usunąć. Zamiast tego owinąć kolejnym bandażem.\n5. Umieścić dotknięte kończyny (jeśli nie są złamane) wyżej niż serce w celu zmniejszenia ciśnienia tętniczego krwi. Jeśli to możliwe położyć poszkodowanego.\n6. Jeżeli krwawienie nie ustaje, utrzymać presję na ranę, a dodatkowo uciskać w innych miejscach: W przypadku krwawienia  ramienia uciskać górną część (naciśnij żyły na wewnętrznej stronie ramienia, w środku łokcia i dołu ramienia używając swojego palca). W przypadku krwawienia nogi uciskać pachwinę (naciśnij na żyły w pachwinie, gdzie tętnica prowadzi przez kości miednicy, używając swojego nadgarstka).\n7. Zadzwoń po lekarza pogotowia natychmiast.\n8. Jeżeli krwawienie jest pod kontrolą uruchom środki przeciw krztuszeniu  się");aid_brainconcussion = new StringItem ("Wstrząs mózgu", "Bóle głowy, nudności, wymioty. Zaburzenia widzenia. Może wystąpić utrata przytomności .\n1. Położyć poszkodowanego.\n2. Zadzwonic po pomoc.\n\nJeśli krwawi głowa:\n1. Połóż poszkodowanego z podwyższoną głową (na poduszce).\n2. Lecz ranę, użyj bandażu.\n3. Dzwoń po pomoc");aid_burningslight = new StringItem ("Poparzenie  słabe", "Zaczerwienienie skóry. Łagodne obrzęki. Ból.\n1. Trzymaj skórę pod zimną wodą.\n2. Stosuj mokre i luźne bandaże.");aid_burningsevere = new StringItem ("Poparzenie ciężkie", "Biało-czerwone obszary, powstawanie pęcherzy. Skóra traci płyn. Głębokie uszkodzenia tkanek. Silny ból lub bez bólu (ze względu na spalone nerwy).\n1. Usuń jak najwięcej ubrań.\n2.Chłodz spalone części ciała wodą (około 15 ° C, 59 ° F) do 10 min, aż bólu się zmniejszy.\n3. Jeżeli spalanie jest rozległe, wystarczy użyć mokrej ścierki do ostygnięcia.\n4. Dzwoń po pomoc.\n5. Po schłodzeniu nie rany leczenia: Za pomocą sterylnego opatrunku. Nie stosować płynów (nie kremy, oliwki, maści itp.). \n6. Kontroluj oddech i świadomości osoby, aż przybędzie lekarz pogotowia.");aid_checkbreathing = new StringItem ("Sprawdź Oddech", "1. Sprawdź dzwięk oddechu.\n2. Diagnozuj oddychanie w górnej części brzucha (połóż na nim rękę).\n3. Poczucie oddech z nosa i ust.");aid_chemicalburneyes = new StringItem ("Poparzenie oczu chemikaliami", "1. Zadzwonic po pomoc, zwrócić uwagę na chemikalia.\n2. Wypłucz oko  dużo ilością wody. Osłoń zdrowe oko podczas płukania.\n3. Kieruj strumień wody z wewnętrznego kąta oka do zewnętrznego kąta oka. Trzymaj na co najmniej 20 min pod czystą wodą.\n4. Zamknij oczy poszkodowanemu i owiń mokrą szmatką.\n5. Monitor stan, aż przyjedzie ambulans.");aid_chemicalburn = new StringItem ("Poparzenie chemikaliami", "Szkody tkanki.\n1. Pamiętaj o  ochronie osobistej!\n2. Działaj szybko i myj spalone miejsca.\n3. Dzwoń po pomoc.\n4. Jeśli jest spalony układ trawienny prubój pić dużo wody.\n5. Nie powoduj  wymiotów!");aid_dangerzone = new StringItem ("Grozny obszar (Ratowanie)", "1. Wykonanie uchwytu: połóż jedno z ramion pokrzywdzonego na klatce piersiowej i idz za niego.\n2. Połóż dłonie na barkach rannego  biorąc ugięte ramię.\n3. Odwróć i przenieś osobę do bezpieczeństwa.");aid_diabeticcoma = new StringItem ("Śpiączką cukrzycową", "Poziom cukru we krwi jest zbyt wysoki (powód brak insuliny).\nSymptomy: pragnienie, częste oddawanie moczu, nudności, wymioty. Oddech zapachów owoców / wina.\n1. Wezwanie pogotowia.\n2. Pomóc pokrzywdzonemu (o ile potwierdzona cukrzyca), biorąc insulinę.\n3. Odzyskiwanie stanowiska. (Brak dalszych możliwości dla pomagającego.)\n4. Monitorować stan poszkodowanego aż dotrze lekarz.");aid_diarrhoea = new StringItem ("Biegunka", "Ckliwość żywności, infekcja jelita lub zaburzenia. Stolec jest rozcieńczony, grząski lub krwawy.\n1. Niebezpieczeństwo cyrkulacji z powodu odwodnienia i utraty soli!\n2. Podać płyny (herbata, woda).\n3. Jeśli istnieją silne zaburzenia zadzwonić po lekarza pogotowia.");aid_drowning = new StringItem ("Tonięcie", "1. Wezwanie pogotowia. Zapytaj ludzi obok Ciebie o pomoc.\n2. Ratowanie osoby z wody!\n3. Jeśli poszkodowany oddycha: pozycja ratownicza. Trzymaj go ciepłym. Monitoruj stan, aż przyjedzie lekarz pogotowia.\n4. Jeśli poszkodowany oddycha: Natychmiast rozpocząć z reanimacją! (Wypuszczanie wody z płuc jest bezużyteczne.)");aid_electricityaccident = new StringItem ("Wypadek elektryczny", "1. Po pierwsze przerwać dostawę energii elektrycznej!\nNiebezpieczeństwo: utrata przytomności, bezdech.\n2. A - Oddychający nieprzytomny\n3. B - Nieoddychający nieprzytomny");aid_emergencycall = new StringItem ("Numer alarmowy", "1. Zadzwoń pod 112 z najbliższego telefonu (USA: 911). Zawsze jest to możliwe i za darmo! Nie wahaj się zadzwonić po pogotowie! W rozmowie należy podać następujące informacje: Co się wydarzyło - Gdzie (miejsce wypadku) - Ile ofiar - Jakiego rodzaju urazy. Potem czekać na dalsze postępowanie.");aid_epilepsy = new StringItem ("Padaczka", "Sztywne ciało,zaciśnięte pięści,zaciskane szczęki, drganie kończyn lub twarzy. krążące oczy. Ślinienie. Utrata przytomnośći  możliwa.\n1. Nie trzymaj ofiary i nie zatrzymuj jej ruchów.\n2.Połóż ofiarę na miękkiej podstawie (poduszka), usunąć rzeczy aby zapobiec własnej szkodzie.\n3. Ucisz ofiarę. Rozluźnij odzież, zapewnij swobodę oddechu.\n4. Jeśli ofiara wymiotuje, przekręć głowę na bok by mogła wymiotować.\n5. Trzymaj drogi oddechowe wolne. Niebezpieczeństwo połknięcia języka.\n6. Zadzwoń po pomoc. Kontynuuj monitorowanie stanu ofiary.\n7. Trzymaj  innych ludzi na odległość.");aid_eyeinjury = new StringItem ("Uszkodzenie oka", "1. Zostawić objekt w oku, nie należy go usunąć.\n2. Unieruchomić oczy, aby uniknąć dalszych urazów. Nie wolno dotykać oczu.\n3. Jeżeli oko krwawi, okładaj kompresem lub sterylnym gazikiem.\n4. Chłodz oko  zimnym okładem (zmniejsza obrzęki, krwawienia przestaje szybciej).\n5. Zadzwonić po pomoc lub zawieść samemu do szpitala.");aid_fracture = new StringItem ("Złamanie", "Objawy: nienaturalne pozycje kości i ruchy. Deformacja. Bolesny ruch,ból przy dotyku.\n1. Unikaj ruchów!\n2. Zadzwoń po pomoc.\n3. Unieruchamiaj złamaną kość, n.p. owiń materiał szczelnie wokół kości. Zachować pozycję kości.\n4. Jeśli złamanie jest otwarte, pokryj ranę sterylnie.");aid_frostbitemild = new StringItem ("Odmrożenie łagodne", "Bladość, obrzęki. Zagrożenie dla dostawy krwi.\n1. Położyć ofiarę w ciepłym obszarze.\n2. Odejdź od zimna, usuń zimne ubrania, osusz osobę.\n3.Ocieplaj  za pomocą letniej wody i ciepła z ciała o pomocnika.\n4. Daj ciepły napój (herbata). Zakaz spożywania alkoholu!");aid_frostbitesevere = new StringItem ("Odmrożenie ciężką", "Twarda skóra zimna, szaro-biała, pęcherze, tkanka wymiera . Zagrożenie dla dostawy krwi!\n1. Przejdź do ciepłego obszaru.\n2. Lecz rany .\n3. Daj słodki napój.\n4. Nie trzeć ofiary!\n5. Zadzwonić po pomoc.");aid_heartattack = new StringItem ("Atak serca", "Ciężki, więcej niż 5 min trwałe ciśnienie i ból w klatce piersiowej, szczególnie promieniujące w ramionach / barkich. Niepokój, bladość, zimne poty. Ewentualnie nudności, duszność.\n1. Zadzwonić po pomoc! Zwrócić uwagę na domniemany atak serca.\n2. Podwyższyć górną część ciała . Odzież rozluźnić. Nie dać narkotyków lub napojów.\n3.Uspokój osobę.\n4. Kontroluj świadomość i oddychanie.\n5. Dać aspirynę, jeśli jest dostępna.\n6. Jeżeli osoba staje się nieprzytomna, ratować.");aid_hypoglycaemia = new StringItem ("Hipoglikemia (niski poziom cukru)", "Poziom cukru we krwi jest poniżej wartości minimalnej (z powodu przedawkowania insuliny lub nie wystarczającego spożycia żywności).\nObjawy: bladość, nerwowość, głód, dreszcze, poty.\n1. Upewnij się, że dana osoba ma cukrzycę (spójrz na znaczek cukrzycowy).\n2. Dzwoń po pomoc.\n3. Daj słodki napój i dekstrozę / glukozę (jeśli nie ma problemów z połykaniem).\n4. Jeśli osoba jest przytomna i oddycha: Odzyskanie pozycji. Monitorować oddech danej osoby. Jeśli pojawi się bezdech,ratować.\n5. Jeśli osoba oddycha, możesz umieścić woreczek cukru w ustach i naciskać  z zewnątrz przeciwko niemu.");aid_hyperthermia = new StringItem ("Hipertermia (gorące ciało)", "Pragnienie, osłabienie, dezorientacja, nudności, dezorientacja, silne pocenie się, gorąca skóra.\n1. Dzwoń po pomoc.\n2. Znajdź chłodne i zaciemnione miejsce (pokój z klimatyzacja zalecany).\n3. Połóż osobę, podciągać nogi. Poluzuj ubranie.\n4. Chłodz skórę dużą ilością wody lub zimnymi ręczniki.\n5. Daj dużo wody lub soków do picia.");aid_hypothermia = new StringItem ("Hipotermia (schłodzenia ciała)", "Zimne dreszcze, senność, wyczerpanie aż do utraty przytomności. Zimna i blada skóra. Powolny puls, słabe tętno.\n1. Przejdź do ciepłego obszaru / pokoju.\n2. Wezwij pogotowie.\n3. Zatrzymaj dopływ zimna. Celem jest wzrost temperatury ciała (n.p ciepły okład lub kontakt ciało-ciało).\n4. Zdejmij mokre ubranie i daj ciepłe ubrania. Osłon kołdrą i osłaniaj głowę.\n5. Daj gorącej herbaty, zupy lub ciepłej wody do picia. Zakaz spożywania alkoholu! Nie daj zasnąć osobie.\n6. Monitor stan ofiary, aż przyjedzie lekarz pogotowia. Jeśli osoba traci przytomność, ratować:\n7. A - Oddychający nieświadomy\n8. B - Nieoddychający nieświadomy");aid_icerescue = new StringItem ("Ratowanie z lodu", "Zwracać uwagę na własne bezpieczeństwo. Niebezpieczeństwo: Tonięcie, Hipotermia.\n1. Poprosić o pomoc innych ludzi. Niech wezwą karetkę.\n2. .Ratowanie przy użyciu drabiny, deski lub listwy. Waga musi być rozłożona szeroko powszchni.\n3. Czołgać się do przodu leżąc na brzuchu(jeśli to możliwe być przywiązanym liną do słupa).\n4. Podać ofierze  na odległość narzędzie (nie rękę!) I wyciągnąć ją.\n5. Czołgać się do tyłu .\n6. Środki pierwszej pomocy.\n7. Ratowanie samemu możliwe: Jeśli lód jest stały można rozłożyć swoją masę i się wyciągnąć. Jeśli lód jest kruchy, spróbuj przełamać kawałek lodu.");aid_insectstings = new StringItem ("Ugryzienia owadów", "Obrzęk, wysypka, uczucie pieczenia, osłabienie, trudności w oddychaniu, zmniejszenie świadomości, tachykardia.\n1. Usuń żądło starannie (pęsetą). Nie wyciskać z żądła, jak mogłoby to wstrzyknąć więcej jadem.\n2. Cool zainteresowanych miejscu (stosowanie zimna kompresji).\n3. Zainteresowanych dziedzinie powinny być przechowywane niższe niż serce powoli do obrotu na jad.\n4. Jeśli ściegu w ustach-szczęka strefy: Suck lodów, a także zastosowanie kompresji zimno wokół gardła.\n5. Jeśli wystąpić poważne problemy wezwać karetkę.");aid_nosebleeding = new StringItem ("Krwawienie z nosa", "Pęknięta żyła.\n1. Usiądz i pochyl się nieco do przodu. Trzymaj głowę prosto.\n2. Głowa trzymana nad sercem spowalnia krwawienie.\n3. Chłodzić szyję.\n4. Zaciśnij nozdrza aż zatrzyma się krwawienie (10 min).\n5. Potem nie ruszaj nosa (nie chrapać).\n6. Jeśli występują problemy lub ciężkie krwawienie które nie można zatrzymać, wezwij lekarza pogotowia.");aid_poisining = new StringItem ("Zatrucie", "Omamy, gorączka, skurcze. Nieprzytomności.\n1. Tylko dać antidotum, jeśli towarzyszy wyszkolony lekarz.\n2. Nie dawać napojów. Nie powodować wymiów.\n3. Zdwoniąc po pomoc zwrócić uwagę na zatrucie!\n4. Zachować trucizny i wymioty!\n5. Jeśli ofiara jest przytomna i oddycha: Odzyskanie pozycji. Monitorować stan, aż przyjedzie lekarz pogotowia.\n6. Jeśli ofiara nie oddycha: Natychmiast rozpocząć z reanimacją! Opróżnić usta z wymiocin..");aid_recoveryposition = new StringItem ("Pozycja bezpieczna", "1. Położyć ofiarę na plecach, wyprostować nogi. Kolana obok.\n2. Położyć ramię  pod kątem prostym do ciała.\n3. Wyciągnij ramię najdalej od ciebie i od klatki piersiowej i umieść z powrotem pod policzek.\n4. Wyciągnij kolana i połóż je na ziemi.Nogi pod kątem prostym. Trzymać ręce ofiary  pod policzkiem danej osoby.\n5. Upewnij się, że drogi oddechowe są wolne.\n6. Otwórz usta lekko i przekręć głowę tak, aby ofiara mogła wymiotować . Sprawdź oddech.\n7. Kontroluj  stan ofiary aż przyjedzie  lekarz pogotowia.");aid_resuscitation = new StringItem ("Reanimacja", "# Masaż serca\n1. Położyć ofiarę na plecach. Klęczeć obok osoby.\n2. Uwolnij klatkę pierśiową.\n3. Połóż dłoń na środku klatki piersiowej (nieco ponad mostkiem).\n4. Połóż drugą na pierwszą dłoń.\n5. Wyciągnąć ramiona i nogi.\n6. Naciśnij 5 cm w głąb klatki piersiowej (moc pochodzi z górnej części ciała) i puść.\n7. Naciśnij 30 razy z rzędu krótko i zdecydowanie!\n\n# Oddychanie\n1. Usuń substancje z jamy ustnej i gardła. Wyciągnij głowę do szyi.\n2.Zaciśnij  nos.\n3. Weź głęboki wdech i połóż usta na ustach ofiary aby nie było szczelin .\n4. Rób usta-usta dwa razy (oddech powoli iw pełni).\n5. Następnie wykonaj ponownie masaż serca.\n\nPowtórz masaż serca oddychanie i usta-usta do przyjazdu lekarza pogotowia .");aid_safeguardaccident = new StringItem ("Wypadek samochodowy", "1. Zatrzymaj swój samochód 50-100 m za miejscem wypadku (jeśli jesteś na autostradzie lub drodze krajowej). Włącz światła awaryjne. Włóż kamizelkę odblaskową. \n2. Postaw trójkąt ostrzegawczy przed wypadkiem . Uwaga: Jeżeli  wypadek jest na zakręcie to postaw trójkąt przed zakrętem!\n3. Poproś innych ludzi o pomoc.\n4. Otwórz drzwi od samochodu (jeśli zaklinowane to otworzyć za pomocą łomu). Wyłącz zapłon.\n5. Ratowanie ofiary wypadku: Odepnij pasy bezpieczeństwa, siedzenia przesunąć do tyłu. Wyciągnij za pomocą ratowniczego uchwytu.\n6. Dzwoń po pomoc.\n7. Postępować z pierwszą pomocy.");aid_shock = new StringItem ("Szok", "Zaburzenia krążenia przez słabą dostawę tlenu w organizmie.\nPrzyczyna: Utrata płynów, zmniejszona objętość krwi.\nObjawy: bladość, zimna skór, zimne poty, niepokój.\n1. Wyeliminować przyczyny tego wstrząsu (np. zatrzymanie utraty płynu, wiązania rany!)\n2. Połóż rannego na kocu, do góry nogami. Uspokój osobę.\n3. Dzwoń po pomoc\n4. Jeżeli są trudności w oddychaniu lub utrata świadomości, inicjować reanimację.");aid_skullfracture = new StringItem ("Złamanie czaszki", "Lekkie krwawienia z nosa, jamy ustnej lub ucha. Często otwarte rany na czaszce.\n1. Trzymaj drogi oddechowe otwarte.\n2. Jeśli poszkodowany świadomy: Niech  siedzi z głową do ugiętą do przodu. Uniknąć dalszych ruchów!\n3. Jeśli nieprzytomny: Odzyskanie pozycji (bez nacisku na  rany głowy).\n4. Dzwoń po pomoc\n5. Załóż bandaż na głowę.\n6. Jeżeli trudności w oddychaniu lub świadomości, inicjować reanimacje.");aid_snakebite = new StringItem ("Ukąszenie wężą", "Miejscowa rana o wielkości szpilki, ciężkie bóle, obrzęk, kolor purpurowy. Zaburzenia krążenia, zagrożenie napadu eliptycznego.\n1. Usztywnij ranną część ciała.\n2. Zastosuj zimny okład wokół rany .\n3. Podać środki przeciwko wstrząsowi\n4. Dzwoń po pomoc.");aid_sos = new StringItem ("SOS", "1. Sygnał: 3x krótkie, długie 3x, 3x krótkie.\n2. Optycznie (sygnał światła, latarki) lub akustycznie (gwizdnięcie, pukanie).");aid_sprain = new StringItem ("Zwichnięcia i nadwyrężenia", "Ból, obrzęk (siniec), utrata funkcji uginania kończyny.\n1.Ułożyć część ciała w najwygodniejszy sposób dla poszkodowanego.\n2. Chodzić (za pomocą lodu).\n3. Jeśli to możliwe, unieść część ranną trochę.\n4. Przyjedź do szpitala lub zadzwoń po lekarza pogotowia.");aid_stroke = new StringItem ("Atak", "Nagłe uczucie drętwienia lub paraliż (twarzy, ramion, nóg), zaburzenia zrozumienia,  problemy wzroku, zakłócenie świadomości, silne bóle głowy. Problemy  z oddychaniem i połykaniem, utrata kontroli nad pęcherzem moczowym i jelitami.\n1. Dzwonić po pomoc !\n2. Rozluźnić napiętą Odzież, nie dawać narkotyków lub napojów.\n3. Położyć lub posadzić osobę komfortowo. Uspokoić!\n4. Kontroluj świadomość i oddychanie.\n5. Jeżeli występują trudności w oddychaniu lub świadomości, inicjować reanimację.");aid_suffocation = new StringItem ("Duszenie", "Niedostateczna dostawa tlenu. Tchawica zamknięta. Niebezpieczeństwo: bezdech.\nObjawy: świszczący oddech , kaszel bodźca, duszność, przebarwienia skóry.\n1. Natychmiastowe działania! Niech dana osoba kaszle bardzo mocno.\n2. Uderzyć  silnie płaską ręką pomiędzy łopatki (Położyć niemowlę na przedramieniu, z głową do dółu).\n3. Jeśli bez powodzenia: Stań za osobą, obejmij wokół pasa, uginaj lekko do przodu.\n4. Zamknąć pięść, położyć na wysokość żołądka osoby i wziąć drugą ręką  .\n5. Mocno nacisnąć na brzuch tak jakby się próbowało podnieść osobę\n6. Powtórz tę czynność aż  5 razy! Drogi oddechowe powinny stać się wolne .\n7. Dzwoń po pomoc .\n8. Jeżeli się nie powiedzie za pierwszym razie to kontynuować  aż przybędzie lekarz pogotowia.");aid_sunburn = new StringItem ("Poparzenie słoneczne", "1. Odciągnąć osobę od słońca i unikać je w przyszłości.i  \n2. Pić dużo wody aby zatrzymać odwodnienie.\n3. Jeśli istnieje poważne poparzenie słoneczne (pęcherze, zaczerwienienie, ból), zasięgnąć porady lekarza.\n4. Jeśli skóra jest tylko lekko czerwona, może być chłodzona mokrym okładem. Użyj balsam lub żel.");aid_sunstroke = new StringItem ("Porażenie słoneczne", "gorąca i czerwona głowa, zimna skóra, zawrót głowy, ból głowy, . Przyczyna: Podrażnienie  membrany mózgowej.\n1. Przejdź w chłodne miejsce (cień) i unieś górną część ciała.\n2. Schłodzić głowę mokrymi okładami.\n3. Dzwoń po pomoc i kontroluj oddychanie.\n4. Jeśli świadomy: Daj chłodny napój gdy możliwe .\n5. Jeśli pojawi się bezdech, zacznij z oddychaniem:\n6. Przejdź na Usta-Usta!");aid_unconsciouswithbreath = new StringItem ("Nieświadomości z oddychaniem", "Bez reakcji na głośne pytania , nie ma odpowiedzi na wstrząsanie. Nie ma oddychania.\n1. Jeżeli są ludzie obok Ciebie poproś o pomoc.\n2. Pozycja bezpieczna. Otwórz usta i ustaw głową w ten sposób, żeby osoba mogła wymiotować .\n3. Dzwoń po pomoc.");aid_unconsciouswithoutbreath = new StringItem ("Świadomości bez oddychania", "1. Ofiara nie reaguje, nie  oddycha.\n\nWszczęcie renimacjii.");aid_vomiting = new StringItem ("Wymioty", "Wynika z nudności. Żołądek opróżnia się. Przyczyny: Infekcja, zatrucie, owrzodzenia, narkotyki, złe jedzenie, ciąża.\n1. Niebezpieczeństwo dla krwiobiegu z powodu odwodnienia i utraty soli!\n2. Podać płyny (herbata, woda).\n3. Jeśli istnieją silne zaburzenia, krwawe wymioty lub ciągłe to wezwij  lekarza pogotowia.");separator = new StringItem ("Separator", "-");
			
			stringItemArray = new StringItem[] {
					aid_disclaimer, separator, aid_general, aid_allergic, aid_amputation, aid_asthma, aid_unconsciouswithoutbreath, aid_unconsciouswithbreath, aid_diabeticcoma, aid_safeguardaccident, aid_apnoea, aid_epilepsy, aid_snakebite, aid_diabeticcoma, aid_hypoglycaemia, aid_checkbreathing, aid_bleedinglight, aid_bleedingsevere, aid_nosebleeding, aid_stroke, aid_dangerzone, aid_frostbitemild, aid_frostbitesevere, aid_poisining, aid_brainconcussion, aid_resuscitation, aid_insectstings, aid_hypothermia, aid_animalbite, aid_chemicalburn, aid_chemicalburneyes, aid_backinjury, aid_eyeinjury, aid_backinjury, aid_birth, aid_diarrhoea, aid_resuscitation, aid_shock, aid_sos, aid_burningslight, aid_burningsevere, aid_sunburn, aid_suffocation, aid_heartattack, aid_recoveryposition, aid_resuscitation, aid_sunstroke, aid_emergencycall, aid_drowning, aid_suffocation, aid_electricityaccident, aid_hyperthermia, aid_sprain, aid_safeguardaccident, aid_icerescue, aid_apnoea, aid_fracture, aid_skullfracture, aid_asthma, aid_vomiting, separator }; 

			display = Display.getDisplay(this);
			display.setCurrent(this.menu);

			// sets the focus to the given index of the specified list.
			UiAccess.setCurrentListIndex(display, this.menu, 0);

			// set commands and listener to form
			details.addCommand(cmdBack);
			details.setCommandListener(this);

			// application has started
			started = true;
		}
	}


	public void applyText(int auswahl) {
		// clear form
		details.deleteAll();
		// assign title according title of menuItem 
		details.setTitle(UiAccess.getListItem(menu, menu.getSelectedIndex()).getText());
		// assign text according to int 'auswahl' 
		details.append(stringItemArray[auswahl].getText());

		// img:IMAGES
		
		  // spacer
		  details.append(""); 

		  // img: CC licence
		  if (auswahl==0) { details.append(imageCC); }
		  // img:apnoea
		else if (auswahl==26 || auswahl==20) { details.append(aid067);        details.append(""); details.append(aid010);        details.append(""); details.append(aid011); }
		  // img:backinjury
		  else if (auswahl==7 || auswahl==14) { details.append(aid065); }
		  // img:birth
		  else if (auswahl==39) { details.append(aid025);        details.append(""); details.append(aid022);         details.append(""); details.append(aid023); }
		  // img:chemicalburneyes
		  else if (auswahl==32) { details.append(aid019); }
		  // img:bleedinglight
		  else if (auswahl==45) { details.append(aid084);           details.append(""); details.append(aid085); }
		  // img:bleedingsevere
		  else if (auswahl==44) { details.append(aid084);           details.append(""); details.append(aid085);           details.append(""); details.append(aid089);           details.append(""); details.append(aid092); }
		  // img:brainconcussion
		  else if (auswahl==6) { details.append(aid061); }
		  // img:dangerzone
		  else if (auswahl==24) { details.append(aid001); }
		  // img:drowning
		  else if (auswahl==9) { details.append(aid034); }
		  // img:electricityaccident
		  else if (auswahl==51) { details.append(aid045); }
		  // img:epilepsy
		  else if (auswahl==5) { details.append(aid058); }
		  // img:fracture
		  else if (auswahl==13) { details.append(aid107); }
		  // img:heartattack
		  else if (auswahl==12) { details.append(aid061); }
		  // img:icerescue
		  else if (auswahl==15) { details.append(aid041); }
		  // img:recoveryposition
		  else if (auswahl==36) { details.append(aid008);          details.append(""); details.append(aid009);          details.append("Pozycja bezpieczna dla niemowląt"); details.append(aid028); }
		  // img:resuscitation
		  else if (auswahl==59 || auswahl==38 || auswahl==19) {          details.append(aid013);
		details.append(""); details.append(aid003);          details.append(""); details.append(aid067);          details.append(""); details.append(aid010);
				 details.append(""); details.append(aid011);          details.append(""); details.append(aid012);
		details.append("Reanimacja (niemowlę)Użyj tylko dwóch palców "); details.append(aid029);          details.append("Nie oddychaj za mocno"); details.append(aid030); }
		  // img:safeguardaccident
		  else if (auswahl==3 || auswahl==50) { details.append(aid001); }
		  // img:suffocation
		  else if (auswahl==43 || auswahl==27) { details.append(aid031);          details.append(""); details.append(aid069); }
		  // img:sunstroke
		  else if (auswahl==40) { details.append(aid061); }
		  // img: unconsciouswithbreath
		  else if (auswahl==56) { details.append(aid008);          details.append(""); details.append(aid009); }
		  // spacer below
		  details.append("");

		  // append Resuscitation measures! for unconsciouswithoutbreath / drowning / heartattack / brainconcussion / stroke / shock / poisining
		  if (auswahl==55 || auswahl==9 || auswahl==12 || auswahl==6 || auswahl==49 || auswahl==42 || auswahl==58) { 
		   details.append(aid_resuscitation);     details.append(aid013);     details.append(""); details.append(aid003);  details.append(""); details.append(aid067);      details.append(""); details.append(aid010);  details.append(""); details.append(aid011);      details.append(""); details.append(aid012);  }
		  // for electricity / hypothermia
		  else if (auswahl==51 || auswahl==17) {    details.append(aid_unconsciouswithbreath);    details.append("");   details.append(aid_unconsciouswithoutbreath); 
		   details.append("");   details.append(aid_resuscitation);      details.append(""); details.append(aid003);   details.append(""); details.append(aid067);     details.append(""); details.append(aid010);  details.append(""); details.append(aid011);   }
		 // for sunstroke / asthma / hypoglycaemia
		  else if (auswahl==40 || auswahl==48 || auswahl==23) {    details.append(aid_apnoea);  details.append(""); details.append(aid010);    details.append(""); details.append(aid011);   }
		  
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean unconditional) {
		notifyDestroyed();
	}

	public void commandAction(Command c, Displayable d) {
		// System.out.println(c.getLabel());
		if(c.getCommandType() == Command.BACK) {
			display.setCurrent(menu);
		}
		else if (c.getCommandType() == Command.EXIT) {
			notifyDestroyed();
		}
		// Country Emergency Menu
		else if (display.getCurrent().getTitle() == telEmergency.getTitle()) {
			details.deleteAll();
			details.setTitle(UiAccess.getListItem(telEmergency, telEmergency.getSelectedIndex()).getText());
			if (telEmergency.getSelectedIndex() == 0) { details.append(stringAfrica); } 
			else if (telEmergency.getSelectedIndex() == 1) { details.append(stringAsia); }
			else if (telEmergency.getSelectedIndex() == 2) { details.append(stringEurope); }
			else if (telEmergency.getSelectedIndex() == 3) { details.append(stringSouthamerica); }
			else if (telEmergency.getSelectedIndex() == 4) { details.append(stringOceania); }
			else if (telEmergency.getSelectedIndex() == 5) { details.append(stringNorthamerica); }
			display.setCurrent(details);
		}
		// Main Menu
		else if (display.getCurrent().getTitle() == menu.getTitle()) {
			if (menu.getSelectedIndex() == 1) { 
				display = Display.getDisplay(this);
				display.setCurrent(telEmergency);
			}
			// catch divider
			else if (menu.getSelectedIndex() == 60) { }
			// notruf
			else if (menu.getSelectedIndex() == 61) {
				try {
					platformRequest("tel:112");
					// platformRequest("http://www.yahoo.com");
					// http://developers.sun.com/mobility/midp/ttips/platformRequest/index.html
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			else {
				// apply text to form and show it
				applyText(menu.getSelectedIndex());
				display = Display.getDisplay(this);
				display.setCurrent(details);
			}
		}
	}
}
