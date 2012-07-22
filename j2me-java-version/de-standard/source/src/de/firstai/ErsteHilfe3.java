//Erste.Hilfe.3.0.standard
package de.firstai;

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

import de.enough.polish.ui.UiAccess;


public class ErsteHilfe3 extends MIDlet implements CommandListener {

	boolean started = false;
	Form details;
	Display display;
	List menu;
	List telEmergency;

	// setup of the navigation buttons
	static final Command cmdBack = new Command("Zurück", Command.BACK, 2);
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
	
	public ErsteHilfe3() {

		this.menu = new List("Erste Hilfe 3.0", Choice.IMPLICIT);
		this.menu.append("Haftung + Hinweise", null); // 0
		this.menu.append("- Notrufe weltweit -", null); // 1 
		this.menu.append("Allgemeines", null); // 2
		this.menu.append("Allergische Reaktion", null); // 3
		this.menu.append("Amputation", null); // 4
		this.menu.append("Asthma / Atemnot", null); // 5
		this.menu.append("Atemstillstand", null); // 6 apnoea
		this.menu.append("Atmung prüfen", null); // 7
		this.menu.append("Augenverletzung", null); // 8
		this.menu.append("Augenverätzung", null); // 9
		this.menu.append("Beatmung", null); // 10
		this.menu.append("Bewusstlosigkeit mit Atmung", null); // 11
		this.menu.append("Bewusstlosigkeit ohne Atmung", null); // 12
		this.menu.append("Blutung Leicht", null); // 13 bleeding light
		this.menu.append("Blutung Schwer", null); // 14 bleeding severe
		this.menu.append("Diabetisches Koma", null); // 15
		this.menu.append("Durchfall", null); // 16
		this.menu.append("Eisunfall", null); // 17
		this.menu.append("Elektrounfall", null); // 18
		this.menu.append("Epileptischer Anfall", null); // 19
		this.menu.append("Erbrechen", null); // 20
		this.menu.append("Erfrierung leicht", null); // 21
		this.menu.append("Erfrierung stark", null); // 22
		this.menu.append("Ersticken", null); // 23
		this.menu.append("Ertrinken", null); // 24
		this.menu.append("Geburt", null); // 25 birth
		this.menu.append("Gefahrenzone (Retten)", null); // 26
		this.menu.append("Gehirnerschütterung", null); // 27 brain concussion
		this.menu.append("Herzdruckmassage", null); // 28
		this.menu.append("Herzinfarkt", null); // 29
		this.menu.append("Hitzschlag", null); // 30
		this.menu.append("Insektenstich", null); // 31
		this.menu.append("Knochenbruch", null); // 32
		this.menu.append("Nasenbluten", null); // 33
		this.menu.append("Notruf", null); // 34
		this.menu.append("Reanimation", null); // 35
		this.menu.append("Rückenverletzung", null); // 36 back injury
		this.menu.append("Schädelbasisbruch", null); // 37
		this.menu.append("Schlaganfall", null); // 38
		this.menu.append("Schlangenbiss", null); // 39
		this.menu.append("Schock", null); // 40
		this.menu.append("Sonnenbrand", null); // 41
		this.menu.append("Sonnenstich", null); // 42
		this.menu.append("SOS", null); // 43
		this.menu.append("Stabile Seitenlage", null); // 44
		this.menu.append("Tierbiss", null); // 45
		this.menu.append("Überhitzung", null); // 46
		this.menu.append("Überzuckerung", null); // 47
		this.menu.append("Unfallstelle sichern", null); // 48
		this.menu.append("Unterkühlung", null); // 49
		this.menu.append("Unterzuckerung", null); // 50
		this.menu.append("Verätzung", null); // 51
		this.menu.append("Verbrennung Leicht", null); // 52
		this.menu.append("Verbrennung Schwer", null); // 53
		this.menu.append("Vergiftung", null); // 54
		this.menu.append("Verkehrsunfall", null); // 55
		this.menu.append("Verschlucken", null); // 56
		this.menu.append("Verstauchung + Verrenkung", null); // 57
		this.menu.append("Wiederbelebung", null); // 58
		this.menu.append("Wirbelsäule", null); // 59
		this.menu.append("-------------", null); // 60
		this.menu.append("Notruf 112 wählen!", null); // 61
		
		// commands
		this.menu.addCommand(cmdExit);
		this.menu.setCommandListener(this);

		details = new Form ("Erste Hilfe auf dem Handy");

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
			telEmergency = new List ("Kontinent wählen", Choice.IMPLICIT);
			telEmergency.append("Afrika", null);
			telEmergency.append("Asien", null);
			telEmergency.append("Europa", null);
			telEmergency.append("Nord-/Zentralamerika", null);
			telEmergency.append("Ozeanien", null);
			telEmergency.append("Südamerika", null);
			telEmergency.addCommand(cmdBack);
			telEmergency.setCommandListener(this);
			stringAfrica = new StringItem("- Afrika -", "\n# Ägypten\nFeuer:180 | Pol:122 | Not:123\n\n# Algerien\nFeuer:14 | Pol:17 | Not:17\n\n# Angola\nFeuer:118 | Pol:110 | Not:118\n\n# Äquatorialguinea\nnur lokale Nummern\n\n# Äthiopien\nFeuer:93 | Pol:91 | Not:92\n\n# Benin\nFeuer:18 | Pol:17 | Not:301769\n\n# Botsuana\nFeuer:998 | Pol:999 | Not:997\n\n# Burkina Faso\nFeuer:18 | Pol:17 | Not:lokal\n\n# Burundi\nkein System\n\n# Dschibuti\nFeuer:18 | Pol:17 | Not:351351\n\n# Elfenbeinküste\nFeuer:180 | Pol:110 | Not:110\n\n# Eritrea\nnur lokale Nummern\n\n# Gabun\nFeuer:18 | Pol:1730 | Not:1300\n\n# Gambia\nFeuer:118 | Pol:117 | Not:116\n\n# Ghana\nFeuer:192 | Pol:191 | Not:193\n\n# Guinea\nnur lokale Nummern\n\n# Guinea-Bissau\nnur lokale Nummern\n\n# Kamerun\nFeuer:18 | Pol:17 | Not:lokal\n\n# Kap Verde\nFeuer:131 | Pol:132 | Not:130\n\n# Kenia\nFeuer:999 | Pol:999 | Not:999\n\n# Komoren\nnur Radiotelefon\n\n# Kongo (Demokrat. Republik)\nnur lokale Nummern\n\n# Kongo (Republik)\nnur lokale Nummern\n\n# Lesotho\nFeuer:122 | Pol:123 | Not:121\n\n# Liberia\nFeuer:911 | Pol:911 | Not:911\n\n# Libyen\nFeuer:193 | Pol:193 | Not:193\n\n# Madagaskar\nFeuer:18 | Pol:117 | Not:2262566\n\n# Malawi\nFeuer:199 | Pol:199 | Not:199\n\n# Mali\nFeuer:18 | Pol:17 | Not:15\n\n# Marokko\nFeuer:15 | Pol:19 | Not:15\n\n# Mauretanien\nFeuer:118 | Pol:117 | Not:lokal\n\n# Mauritius\nFeuer:999 | Pol:999 | Not:999\n\n# Mayotte\nFeuer:603054 | Pol:112 | Not:15\n\n# Mosambik\nFeuer:198 | Pol:119 | Not:117\n\n# Namibia\nFeuer:2032270 | Pol:1011 | Not:2032276\n\n# Niger\nFeuer:18 | Pol:17 | Not:723141\n\n# Nigeria\nFeuer:190 | Pol:119 | Not:199\n\n# Reunion\nFeuer:18 oder 112 mobil | Pol:17 oder 112 mobil | Not:15 oder 112 mobil\n\n# Ruanda\nFeuer:lokal | Pol:112 | Not:lokal\n\n# Sahara (Demokrat. Arab. Republik)\nunbekannt\n\n# Sambia\nFeuer | Pol | Not: 991 oder 112 mobil\n\n# Sao Tome und Principe\nunbekannt\n\n# Senegal\nFeuer:lokal | Pol:lokal | Not:8891515\n\n# Seychellen\nFeuer:999 | Pol:999 | Not:999\n\n# Sierra Leone\nFeuer:999 | Pol:999 | Not:999\n\n# Simbabwe\nFeuer:993 | Pol:995 | Not:994\n\n# Somalia\nnur lokale Nummern\n\n# Südafrika\nFeuer:10111 | Pol:10111 | Not:10177\n\n# Sudan\nFeuer:999 | Pol:999 | Not:lokal\n\n# Swasiland\nFeuer:lokal | Pol:999 | Not:6060911\n\n# Tansania\nFeuer:112 | Pol:112 | Not:112\n\n# Togo\nFeuer:118 | Pol:101 | Not:191\n\n# Tschad\nFeuer:18 | Pol:17 | Not:lokal\n\n# Tunesien\nFeuer:198 | Pol:197 | Not:190\n\n# Uganda\nFeuer | Pol | Not: 999 oder 111 mobil\n\n# Zentralafrikanische Republik\nFeuer:118 | Pol:611253 | Not:610600");
			stringAsia = new StringItem("- Asien -", "\n# Afghanistan\nFeuer:-- | Pol:-- | Not:112\n\n# Armenien\nFeuer:101 | Pol:102 | Not:103\n\n# Aserbaidschan\nFeuer:101 | Pol:102 | Not:103\n\n# Bahrain\nFeuer:999 | Pol:999 | Not:999\n\n# Bangladesch\nFeuer:9555555 | Pol:8665513 | Not:199\n\n# Bhutan\nFeuer:113 | Pol:110 | Not:112\n\n# Brunei\nFeuer:995 | Pol:993 | Not:991\n\n# China\nFeuer:119 | Pol:110 | Not:120\n\n# Georgien\nFeuer:022 | Pol:022 | Not:022\n\n# Hong Kong\nFeuer:999 | Pol:999 | Not:999\n\n# Indien\nFeuer:101 | Pol:100 | Not:102\n\n# Indonesien\nFeuer:113 | Pol:110 | Not:118\n\n# Irak\nkein System\n\n# Iran\nFeuer:125 oder 112 mobil | Pol:110 oder 112 mobil  | Not:115 oder 112 mobil\n\n# Israel\nFeuer:102 | Pol:100 | Not:101\n\n# Japan\nFeuer:119 | Pol:110 | Not:119\n\n# Jemen\nFeuer:199 | Pol:199 | Not:199\n\n# Jordanien\nFeuer:193 | Pol:192 | Not:193\n\n# Kambodscha\nFeuer:118 | Pol:117 | Not:199\n\n# Kasachstan\nFeuer:03 | Pol:03 | Not:03\n\n# Katar\nFeuer:999 | Pol:999 | Not:999\n\n# Kirgisistan\nFeuer:03 | Pol:133 | Not:03\n\n# Kurdistan\nFeuer:125 | Pol:129 | Not:115\n\n# Kuwait\nFeuer:777 | Pol:777 | Not:777\n\n# Laos\nFeuer:lokal | Pol:lokal | Not:03\n\n# Libanon\nFeuer:175 | Pol:112 | Not:140\n\n# Macao\nFeuer:999 | Pol:999 | Not:999\n\n# Malaysia\nFeuer | Pol | Not: 999 oder 112 mobil\n\n# Malediven\nFeuer:118 | Pol:119 | Not:102\n\n# Mongolei\nFeuer:101 | Pol:102 | Not:103\n\n# Myanmar\nFeuer:199 | Pol:199 | Not:199\n\n# Nepal\nFeuer:101 | Pol:100 | Not:228094\n\n# Nordkorea\nnur lokale Nummern\n\n# Oman\nFeuer:999 | Pol:999 | Not:999\n\n# Osttimor\nFeuer:-- | Pol:112 | Not:7233212\n\n# Pakistan\nFeuer:16 | Pol:15 | Not:115\n\n# Philippinen\nFeuer:117 | Pol:117 | Not:117\n\n# Saudi-Arabien\nFeuer:998 | Pol:999 | Not:997\n\n# Singapur\nFeuer:995 | Pol:999 | Not:995\n\n# Sri Lanka\nFeuer:111 | Pol:119 oder 112 mobil | Not:110\n\n# Südkorea\nFeuer:119 | Pol:112 | Not:119\n\n# Syrien\nFeuer:113 | Pol:112 | Not:110\n\n# Tadschikistan\nFeuer:lokal | Pol:02 | Not:03\n\n# Taiwan\nFeuer:119 | Pol:110 | Not:119\n\n# Thailand\nFeuer:199 | Pol:191 oder 1155 (Touristen) | Not:191\n\n# Turkmenistan\nFeuer:03 | Pol:03 | Not:03\n\n# Usbekistan\nFeuer:03 | Pol:03 | Not:03\n\n# Vereinigte Arabische Emirate\nFeuer:997 | Pol:999 | Not:998\n\n# Vietnam\nFeuer:114 | Pol:113 | Not:115");
			stringEurope = new StringItem("- Europa -", "\n# Albanien\nFeuer:18 | Pol:19 | Not:17\n\n# Andorra\nFeuer:118 | Pol:110 | Not:118\n\n# Belgien\nFeuer:112 | Pol:112 | Not:112\n\n# Bosnien und Herzegowina\nFeuer:123 | Pol:122 | Not:124\n\n# Bulgarien\nFeuer:112 | Pol:112 | Not:112\n\n# Dänemark\nFeuer:112 | Pol:112 | Not:112\n\n# Deutschland\nFeuer:112 | Pol:110 | Not:112\n\n# Estland\nFeuer:112 | Pol:112 | Not:112\n\n# Finnland\nFeuer:112 | Pol:112 | Not:112\n\n# Frankreich\nFeuer:18 oder 112 | Pol:17 oder 112 | Not:15 oder 112\n\n# Griechenland\nFeuer:112 | Pol:112 | Not:112\n\n# Großbritannien\nFeuer:112 | Pol:112 | Not:112\n\n# Irland\nFeuer:112 | Pol:112 | Not:112\n\n# Irland\nFeuer:112 | Pol:112 | Not:112\n\n# Island\nFeuer:112 | Pol:112 | Not:112\n\n# Italien\nFeuer:112 | Pol:112 | Not:112\n\n# Kosovo\nFeuer:911 | Pol:911 | Not:911\n\n# Kroatien\nFeuer:93 | Pol:92 | Not:94\n\n# Lettland\nFeuer:112 | Pol:112 | Not:112\n\n# Liechtenstein\nFeuer:112 | Pol:112 | Not:112\n\n# Litauen\nFeuer:112 | Pol:112 | Not:112\n\n# Luxemburg\nFeuer:112 | Pol:112 | Not:112\n\n# Malta\nFeuer:112 | Pol:112 | Not:112\n\n# Mazedonien\nFeuer:112 | Pol:112 | Not:112\n\n# Moldau (Moldawien)\nFeuer:901 | Pol:902 | Not:903\n\n# Monaco\nFeuer:112 | Pol:112 | Not:112\n\n# Montenegro\nFeuer:112 | Pol:112 | Not:112\n\n# Niederlande\nFeuer:112 | Pol:112 | Not:112\n\n# Norwegen\nFeuer:110 | Pol:112 | Not:113\n\n# Österreich\nFeuer:112 | Pol:112 | Not:112\n\n# Polen\nFeuer:112 | Pol:112 | Not:112\n\n# Portugal\nFeuer:112 | Pol:112 | Not:112\n\n# Rumänien\nFeuer:112 | Pol:112 | Not:112\n\n# Russland\nFeuer:01 | Pol:02 | Not:03\n\n# San Marino\nFeuer:116 | Pol:112 | Not:113\n\n# Schweden\nFeuer:112 | Pol:112 | Not:112\n\n# Schweiz\nFeuer:118 oder 112 | Pol:117 oder 112 | Not:144 oder 112\n\n# Serbien\nFeuer:112 | Pol:112 | Not:112\n\n# Slowakei\nFeuer:112 | Pol:112 | Not:112\n\n# Slowenien\nFeuer:112 | Pol:113 | Not:112\n\n# Spanien\nFeuer:112 | Pol:112 | Not:112\n\n# Tschechien\nFeuer:112 | Pol:112 | Not:112\n\n# Türkei\nFeuer:110 | Pol:155 | Not:112\n\n# Ukraine\nFeuer:112 | Pol:112 | Not:112\n\n# Ungarn\nFeuer:112 | Pol:112 | Not:112\n\n# Vatikanstadt\nFeuer:115 | Pol:112 | Not:113\n\n# Weißrussland\nFeuer:01 | Pol:02 | Not:03\n\n# Zypern\nFeuer:112 | Pol:112 | Not:112");
			stringNorthamerica = new StringItem("- Nord-/Zentralamerika -", "\n# USA\nFeuer:911 | Pol:911 | Not:911\n\n# Antigua und Barbuda\nFeuer:911 | Pol:911 | Not:911\n\n# Bahamas\nFeuer:911 | Pol:911 | Not:911\n\n# Barbados\nFeuer:113 | Pol:112 | Not:115\n\n# Belize\nFeuer:911 | Pol:911 | Not:911\n\n# Cayman Islands\nFeuer:911 | Pol:911 | Not:911\n\n# Costa Rica\nFeuer:911 | Pol:911 | Not:911\n\n# Dominica\nFeuer:999 | Pol:999 | Not:999\n\n# Dominikanische Republik\nFeuer:911 | Pol:911 | Not:911\n\n# El Salvador\nFeuer:911 | Pol:911 | Not:911\n\n# Grenada\nFeuer:911 | Pol:112 | Not:911\n\n# Grönland\nnur lokale Nummern\n\n# Guatemala\nFeuer:122 | Pol:110 | Not:123\n\n# Haiti\nFeuer:lokal | Pol:114 | Not:118\n\n# Honduras\nFeuer:198 | Pol:119 | Not:378654\n\n# Jamaika\nFeuer:110 | Pol:119 | Not:110\n\n# Kanada\nFeuer:911 | Pol:911 | Not:911\n\n# Kuba\nFeuer:26811 | Pol:26811 | Not:26811\n\n# Mexiko\nFeuer:060 | Pol:080 | Not:060\n\n# Nicaragua\nFeuer:2650162 | Pol:118 | Not:2651761\n\n# Panama\nFeuer:103 | Pol:104 | Not:2699778\n\n# Saint Kitts und Nevis\nFeuer:911 | Pol:911 | Not:911\n\n# Saint Lucia\nFeuer:911 | Pol:999 | Not:911\n\n# Saint Pierre und Miquelon\nFeuer:18 | Pol:17 | Not:15\n\n# Saint Vincent und Grenadinen\nFeuer:911 | Pol:911 | Not:911\n\n# Trinidad und Tobago\nFeuer:990 | Pol:999 | Not:990");
			stringOceania = new StringItem("- Ozeanien -", "\n# Australien\nFeuer | Pol | Not: 000 oder 112 mobil\n\n# Fidschi\nFeuer:9170 | Pol:911 | Not:911\n\n# Kiribati\nFeuer:lokal | Pol:lokal | Not:994\n\n# Marshallinseln\nFeuer:lokal | Pol:6258666 | Not:6254111 \n\n# Mikronesien\nnur lokale Nummern\n\n# Nauru\nnur lokale Nummern\n\n# Neuseeland\nFeuer:111 | Pol:111 | Not:111\n\n# Palau\nFeuer:911 | Pol:911 | Not:911\n\n# Papua-Neuguinea\nFeuer:110 | Pol:000 | Not:lokal\n\n# Salomonen\nFeuer:911 | Pol:911 | Not:911\n\n# Samoa\nFeuer:994 | Pol:995 | Not:996\n\n# Tonga\nFeuer:999 | Pol:922 | Not:933\n\n# Tuvalu\nFeuer:911 | Pol:911 | Not:911\n\n# Vanuatu\nFeuer:112 | Pol:112 | Not:112");
			stringSouthamerica = new StringItem("- Südamerika -", "\n# Argentinien\nFeuer:100 | Pol:101 | Not:107\n\n# Bolivien\nFeuer:911 | Pol:911 | Not:911\n\n# Brasilien\nFeuer:193 | Pol:190 | Not:192\n\n# Chile\nFeuer:132 | Pol:133 | Not:131\n\n# Ecuador\nFeuer:102 | Pol:101 | Not:131\n\n# Guyana\nFeuer:912 | Pol:911 | Not:913\n\n# Kolumbien\nFeuer:119 | Pol:119 | Not:119\n\n# Paraguay\nFeuer:911 | Pol:911 | Not:911\n\n# Peru\nFeuer:116 | Pol:105 | Not:116\n\n# Suriname\nFeuer:115 | Pol:115 | Not:115\n\n# Uruguay\nFeuer:911 | Pol:911 | Not:911\n\n# Venezuela\nFeuer:171 | Pol:171 | Not:171");
			
			// First-Aid-Text
			aid_disclaimer = new StringItem ("Haftung + Hinweise", "-- Software --\nErste Hilfe auf dem Handy\nVersion: j3.0\nRelease: 2008-12-24\nLizenz: Creative Commons BY-NC-ND 3.0\nCopyright: Kai Kajus Noack\n\nErste Hilfe Illustrationen © Med4Teens\n\nDieses Programm soll Informationen zur Ersten Hilfe geben. Es stellt jedoch in keiner Weise einen Ersatz für einen Erste-Hilfe-Kurs dar, sondern dient der Auffrischung des bereits erworbenen Wissens.\n\n-- Haftungsausschluss --\nBitte beachten Sie, dass ich keine Verantwortung für Konsequenzen, die aus der Nutzung entstehen, übernehme.\nJEGLICHE HAFTUNG IST AUSGESCHLOSSEN!\nVERWENDUNG AUF EIGENE GEFAHR!\n\nIn allen Notfällen suchen Sie bitte sofort professionelle Hilfe.\n\n-- Entwicklung des Projekts --\nDas Programm soll vielsprachig werden. Freiwillige Übersetzer gesucht!!\n\nWeitere Informationen erhalten Sie im Internet unter www.firstai.de oder schreiben Sie eine E-Mail an: info@firstai.de");
			aid_general = new StringItem ("Allgemeines", "1. Leisten Sie immer Erste Hilfe. Sie können keine Fehler machen.\n2. Achten Sie immer auf Ihre eigene Sicherheit.\n3. Machen Sie sich ein Bild von der Situation + Sichern Sie die Unfallstelle.\n4. Notruf + Sofortmaßnahmen!\n5. Bei mehreren Verletzten hat der am stärksten bedrohte Vorrang.\n6. Beruhigen Sie den Betroffenen. Und bleiben Sie selbst ruhig!\n7. Lagern Sie den Betroffenen falls möglich bequem. Grundsätzlich nie Alkohol, Nikotin oder Medikamente verabreichen.");
			aid_allergic = new StringItem ("Allergische Reaktion", "1. Notruf absetzen.\n2. Beruhigen des Betroffenen und bequem hinsetzen.\n3. Allergie-auslösenden Stoff (z. B. Insektenstachel) vorsichtig entfernen.\n4. Betroffene Hautstelle kühlen (feuchter Umschlag, Eis).\n5. Falls Betroffener ein Gegenmittel hat, sollte er dieses nutzen.\n6. Kontrolle des Zustands bis Notarzt eintrifft.\n7. Bei eintretender Bewusstlosigkeit oder Atemnot entsprechende Maßnahmen ergreifen!");
			aid_amputation = new StringItem ("Amputation", "Abgetrennter Körperteil kann wieder angenäht werden. Ziel: Amputat bis zum Eintreffen im Krankenhaus kühlen.\n\n1. Betroffenen beruhigen, hinlegen und zudecken.\n2. Blutung stoppen, siehe 'Blutung (schwer)' und 'Schock'.\n3. Abgetrennten Körperteil in ein sauberes trockenes Tuch wickeln und in eine wasserdichte Plastiktüte legen.\n4. Diese Plastiktüte verschließen und in eine zweite Plastiktüte legen, die kühles Wasser/Eis enthält.\n5. Keinen Alkohol, Zigaretten oder Essen geben (falls im Krankenhaus mit Narkose operiert wird).\n6. Das Amputat nicht einfrieren (nur kühlen).\n7. Notarzt rufen oder selbst zum Krankenhaus fahren.");
			aid_asthma = new StringItem ("Asthma/Atemnot", "Starke Atemnot. Pfeifendes Atemgeräusch. Angstgefühle.\n\n1. Beruhigen des Betroffenen. (Bleiben Sie selbst ruhig!)\n2. Kleidung lockern.\n3. Betroffenen bequem leicht nach vorne gebeugt hinsetzen und auffordern, langsam und tief ein- und auszuatmen.\n4. Falls der Betroffene einen Inhalator besitzt, sollte dieser benutzt werden (helfen Sie dabei). Nach 5-10 min sollte sich Wirkung zeigen.\n5. Sofern keine Besserung eintritt: Inhalator jede 5 min anwenden, solange bis Notarzt eintrifft.\n6. Notruf absetzen.\n7. Falls es zum Atemstillstand kommt, mit der Beatmung beginnen.");
			aid_apnoea = new StringItem ("Atemstillstand/Beatmen","Keine Geräusche oder Atembewegungen, auffallende Hautverfärbung.\n\n1. Notruf absetzen.\n2. Betroffenen auf Rücken legen.\n3. Entfernen von Fremdkörpern aus Mund und Rachen. Überstrecken des Kopfes in den Nacken.\n4. Nasenflügel zusammendrücken, damit Nase geschlossen ist.\n5. Tief einatmen und Mund auf Mund des Betroffenen aufsetzen, sodass keine Luft entweichen kann.\n6. Langsam und vollständig ausatmen.\n7. Falls ohne Erfolg: Atemspende fortsetzen bis Notarzt eintrifft.");
			aid_checkbreathing = new StringItem ("Atmung prüfen", "1. Atemgeräusche prüfen.\n2. Atmung am Oberbauch feststellen (Hand auflegen).\n3. Atmung an Nase/Mund fühlbar.");
			aid_eyeinjury = new StringItem ("Augenverletzung", "1. Fremdkörper im Auge belassen, nicht entfernen.\n2. Augen nicht bewegen, um weitere Verletzungen zu vermeiden. Auge nicht berühren.\n3. Bei Augen-Blutung mit Kompresse oder Verbandtuch bedecken.\n4. Auge mit kalter Auflage kühlen (verringert Schwellung, Blutung stoppt schneller).\n5. Notruf absetzen oder selbst zum Krankenhaus fahren.");
			aid_chemicalburneyes = new StringItem ("Augenverätzung", "1. Notarzt rufen, auf Ätz-Substanz hinweisen.\n2. Auge sofort mit viel Wasser spülen. Gesundes Auge während Spülung abdecken.\n3. Wasserstrahl vom inneren Augenwinkel zum äußeren Augenwinkel. Ca. 20 min reinigen.\n4. Beide Augen des Betroffenen schließen und mit angefeuchtetem Tuch verbinden.\n5. Zustand kontrollieren, bis Notarzt eintrifft.");
			aid_unconsciouswithbreath = new StringItem ("Bewusstlosigkeit mit Atmung","Keine Reaktion auf Ansprache und Schütteln. Atmung vorhanden.\n\n1. Falls Menschen in der Nähe sind, bitten Sie diese um Mithilfe.\n2. Stabile Seitenlage einnehmen. Mund öffnen und Kopf so positionieren, dass Erbrochenes ablaufen kann.\n3. Notruf absetzen.");
			aid_unconsciouswithoutbreath = new StringItem ("Bewusstlosigkeit ohne Atmung","Keine Reaktion vorhanden, Atmung nicht feststellbar.\n\nWiederbelebung einleiten:");
			aid_bleedinglight = new StringItem ("Leichte Blutung", "Ziel: Stoppen der Blutung.\n\n1. Wunde nicht berühren (Infektionsgefahr).\n2. Wunde nicht mit Puder, Salben, Sprays behandeln.\n3. Wundversorgung mittels keimfreier Wundauflage und Befestigungsmaterial (Pflaster, Binde).\n4. Bei kleiner Blutung reicht meist ein Pflasterstreifen.\n5. Bei großflächiger Verletzung Wundauflage und Verbandtuch benutzen. Verband nicht zu fest binden, da Stauung zu vermehrter Blutung führt.\n6. Hinweis: Tollwut-Wunden mit Seifenlösung auswaschen.");
			aid_bleedingsevere = new StringItem ("Schwere Blutung", "Spritzendes, in Stößen austretendes Blut. Gefahr: Schock durch Blutverlust, Infektionen, Tod. Ziel: Stoppen der Blutung.\n\n1. Kleidung entfernen (notfalls aufschneiden), Wunde freilegen.\n2. Binde oder notfalls Kleidungsstück mit Druck um Wunde wickeln.\n3. Für mind. 10 min Druck auf Wunde ausüben.\n4. Falls Binde mit Blut durchnässt, nicht die alte Binde entfernen! Eine andere Binde/Kleidungsstück darüber binden.\n5. Verletztes Glied (sofern nicht gebrochen) über Höhe des Herzens lagern, damit sich Blutung verlangsamt. Wenn möglich Betroffenen hinlegen.\n6. Falls Blutung nicht stoppt, Druck auf Wunde beibehalten und zusätzlich Druckpunkte über der Wunde setzen: Bei Blutung am Unterarm den Oberarm abdrücken (Ader auf Arm-Innenseite mittig zwischen Ellbogen und Achselhöhle, mit Fingern abdrücken). Bei Blutung des Beins, Druckpunkt in Leiste setzen (Ader in Leistenbeuge, wo Arterie über Beckenknochen verläuft, mit Handballen abdrücken).\n7. Sofort Notarzt anfordern.\n8. Sobald Blutung unter Kontrolle: Schockbekämpfung einleiten.");
			aid_diabeticcoma = new StringItem ("Diabetisches Koma/Überzuckerung","Blutzuckerspiegel zu hoch bzw. Insulinmangel.\nSymptome: Durst, häufiges Wasserlassen, Übelkeit, Erbrechen. Atem riecht nach Obst.\n\n1. Notruf absetzen.\n2. Unterstützung bei der Insulingabe, sofern sichergestellt, dass Diabetiker.\n3. Stabile Seitenlage. (Keine weiteren Möglichkeiten für den Ersthelfer.)\n4. Zustand des Betroffenen kontrollieren bis Notarzt eintrifft.");
			aid_diarrhoea = new StringItem("Durchfall", "Nahrungsmittel-Unverträglichkeit, Darm-Entzündung oder Erkrankung. Stuhlgang wässrig, schleimig oder blutig.\n\n1. Gefahr für Kreislauf aufgrund Flüssigkeits- und Salz-Verlustes!\n2. Flüssigkeit zuführen (Tee, Wasser).\n3. Bei starken Beschwerden Arzt aufsuchen oder Notruf absetzen.");
			aid_icerescue = new StringItem("Eisunfall", "Eigenschutz beachten! Gefahr: Ertrinken, Unterkühlung.\n\n1. Rettung erfolgt via Leiter, Brett, Stange. Gewicht muss großflächig verteilt werden.\n2. Andere Personen um Mithilfe auffordern. Notruf absetzen lassen.\n3. Auf Bauch (möglichst angeseilt) mit Hilfsmittel vorsichtig zur Einbruchstelle robben.\n4. Verunglücktem auf Distanz das Hilfsmittel reichen (nicht die Hand!) und herausziehen.\n5. Rückwärts bis zum Ufer zurückrobben.\n6. Erste-Hilfe-Maßnahmen.\n7. Eigenrettung möglich: Bei festem Eis Gewicht auf Eis verteilen und sich selbst herausziehen. Flach auf Bauch zum Ufer zurückrobben. Bei brüchigem Eis versuchen Eis bis zum Ufer Stück für Stück abzubrechen.");
			aid_electricityaccident = new StringItem ("Elektrounfall", "Zuerst Stromzuleitung unterbrechen!\n\nGefahr: Bewusstlosigkeit, Atemstillstand.");
			aid_epilepsy = new StringItem ("Epileptischer Anfall", "Starrer Körper, geballte Fäuste, gepresster Kiefer, Zucken in Beinen oder Gesicht. Rollende Augen. Speichelfluss. Bewusstlosigkeit möglich.\n\n1. Betroffenen nicht halten oder in Bewegung einschränken.\n2. Betroffenen auf weiche Unterlage (Kissen) legen, Objekte in direkter Nähe entfernen, somit Selbstverletzungen vorbeugen.\n3. Beruhigend zum Betroffenen reden. Kleidung lockern, für Atemfreiheit sorgen.\n4. Falls Betroffener erbricht, Kopf zur Seite drehen, damit Erbrochenes abfließen kann.\n5. Atemwege freihalten. Gefahr, dass Zunge verschluckt wird.\n6. Stabile Seitenlage + Notruf absetzen. Weiterhin Zustand des Betroffenen kontrollieren.\n7. Andere Leute auf Distanz halten.");
			aid_vomiting = new StringItem ("Erbrechen", "Folge von Übelkeit. Magen befreit sich. Ursachen: Infektion, Vergiftung, Geschwür, Medikamente, falsche Nahrung, Schwangerschaft.\n\n1. Gefahr für Kreislauf aufgrund Flüssigkeits- und Salz-Verlustes!\n2. Flüssigkeit zuführen (Tee, Wasser).\n3. Bei starken Beschwerden, blutigem oder anhaltendem Erbrechen Arzt aufsuchen.");
			aid_frostbitemild = new StringItem ("Leichte Erfrierung", "Blässe, Schwellen. Gefahr für Blutzufuhr.\n\n1. Warmen Bereich aufsuchen.\n2. Kälte beseitigen. Nasse Kleidung entfernen, abtrocknen.\n3. Aufwärmen mit lauwarmem Wasser und Körperwärme des Helfers.\n4. Warmes Getränk (Tee) geben. Keinen Alkohol!");
			aid_frostbitesevere = new StringItem ("Starke Erfrierung", "Kalte harte Haut, grau-weiß, Blasenbildung, Gewebe stirbt ab. Gefahr für Blutzufuhr!\n\n1. Warmen Bereich aufsuchen.\n2. Wunden versorgen/abdecken.\n3. Zuckerhaltiges Getränk verabreichen.\n4. Nicht warmreiben!\n5. Notruf absetzen.");
			aid_suffocation = new StringItem ("Ersticken/Verschlucken","Unzureichende Sauerstoffversorgung. Luftröhre verschlossen. Gefahr: Atemstillstand.\nSymptome: Pfeifendes Atemgeräusch, Hustenreiz, Atemnot, Hautverfärbung.\n\n1. Sofort handeln! Betroffenen kräftig Husten lassen.\n2. Mit flacher Hand auf Rücken zwischen Schulterblättern kräftig klopfen (Babys dabei auf Unterarm legen, Kopf nach unten halten).\n3. Wenn ohne Erfolg: Hinter Person stellen, Arme um Taille legen, leicht nach vorne beugen.\n4. Hand zur Faust ballen, auf Magen-Höhe des Betroffenen positionieren und mit anderer Hand umfassen.\n5. Beide Hände in Umklammerung mit hartem Stoß in Richtung Magen nach oben/innen ziehen (als ob Sie die Person hochheben wollen).\n6. Bis zu 5-mal wiederholen! Luftwege sollten vom Objekt befreit sein.\n7. Notruf absetzen.\n8. Falls Maßnahme nicht erfolgreich, trotzdem fortsetzen, bis Notarzt eintrifft.");
			aid_drowning = new StringItem ("Ertrinken", "1. Notruf absetzen. Personen in der Nähe um Hilfe bitten.\n2. Aus Wasser retten!\n3. Wenn Atmung vorhanden: Stabile Seitenlage. Betroffenen warm halten (Decke). Zustand kontrollieren, bis der Notarzt eintrifft.\n4. Bei Atemstillstand sofort mit Wiederbelebung beginnen! (Ausfließenlassen von Wasser aus Lungen ist nutzlos.)");
			aid_birth = new StringItem ("Geburt", "Abgang von Fruchtwasser. Presswehen treten ein. Unerwartete Geburt.\n\n1. Intimsphäre wahren und Ruhe bewahren! - Notruf absetzen.\n2. Die Schwangere breitbeinig, mit freigemachtem Unterkörper auf sterile Unterlage hinsetzen.\n3. Kniee anwinkeln. Beine etwas heranziehen. Becken leicht erhöht lagern. - Die Geburt ist ein natürlicher Prozess und läuft häufig ohne Komplikationen ab.\n4. Schwangere beruhigen und auf Atmung konzentrieren lassen: Durch Nase einatmen und Mund ausatmen (normales Atemtempo).\n5. Pressrhythmus: Tief Luft holen, anhalten und pressen. Sobald Kopf des Babys erscheint, mit beiden Händen unterstützend zugreifen.\n6. Nach der Geburt: Neugeborenes schräg nach unten hängen, um Fruchtwasser aus Atemwegen zu befreien. (Evtl. mit dem Mund das Fruchtwasser aus der Nase des Babys absaugen.) Kind muss atmen und schreien!\n7. Nabelschnur 30 cm vom Kind entfernt abbinden (kann auch im Krankenhaus erfolgen). Scheide der Mutter steril abdecken.\n8. Das Baby abtrocknen und warm halten. Uhrzeit notieren und zum Krankenhaus fahren.");  
			aid_dangerzone = new StringItem ("Retten aus Gefahrenzone", "1. Grifftechnik: Arm des Verletzten vor dessen Brust, hinter den Verletzten stellen.\n2. Mit beiden Händen den angewinkelten Arm des Verletzten durch dessen Achseln greifen.\n3. Person in Sicherheit bringen.");
			aid_brainconcussion = new StringItem ("Gehirnerschütterung", "Kopfschmerz, Übelkeit, Erbrechen. Sehstörung. Bewusstlosigkeit kann eintreten.\n\n1. Betroffenen hinlegen.\n2. Notruf absetzen.\n\n*Bei Blutung am Kopf:\n1. Betroffenen hinlegen, Kopf erhöht lagern (Kissen).\n2. Wundversorgung durchführen (Kopf-Verband anlegen).\n3. Notruf absetzen.");
			aid_heartattack = new StringItem ("Herzinfarkt", "Schwere mehr als 5 min anhaltende Schmerzen + Druck im Brustkorb, besonders in Arme/Schultern ausstrahlend. Angstgefühl, Blässe, kalter Schweiß. Eventuell Übelkeit, Kurzatmigkeit.\n\n1. Notruf absetzen! Hinweis auf vermuteten Herzinfarkt.\n2. Oberkörper erhöht lagern. Enge Kleidung lockern. Keine Medikamente oder Getränke geben.\n3. Beruhigend auf Betroffenen einreden.\n4. Bewusstsein und Atmung kontrollieren.\n5. Dem Betroffenen Aspirin verabreichen, falls verfügbar.\n6. Bei Bewusstlosigkeit die Wiederbelebung einleiten:");
			aid_hyperthermia = new StringItem ("Hitzschlag/Überhitzung","Durst, Schwäche, Desorientiertheit, Bewusstseinsstörung, starker Schweiß, heiße Haut.\n\n1. Notruf absetzen.\n2. Kühlen, schattigen Platz aufsuchen (Raum mit Klimaanlage sehr geeignet).\n3. Betroffenen hinlegen, Beine hochlagern. Kleidung lockern.\n4. Haut mit Wasser kühlen oder kalte Handtücher auflegen.\n5. Viel Wasser oder Säfte trinken.");
			aid_insectstings = new StringItem ("Insektenstich", "Schwellungen, Hautausschlag, brennendes Gefühl, Schwäche, Atemnot, Kreislaufprobleme, Herzrasen.\n\n1. Stachel vorsichtig entfernen (mit Pinzette). Nicht auf Stachel drücken, könnte noch mehr Gift injizieren.\n2. Kühlung der betroffenen Stelle (kalte Kompresse).\n3. Betroffene Stelle niedriger als Herz-Höhe halten, damit Gift langsamer zirkuliert.\n4. Bei Stich im Mund-Rachen-Raum: Eis lutschen lassen, kalte Umschläge um Hals.\n5. Bei ernsten Beschwerden Notruf absetzen.");
			aid_fracture = new StringItem ("Knochenbruch", "Anzeichen: Unnatürliche Lage und Beweglichkeit. Deformierung. Schmerzhafte Bewegung, berührungsempfindlich.\n\n1. Bewegungen vermeiden!\n2. Notruf absetzen.\n3. Bruch ruhig stellen, d.h. Umpolstern mit dichtem Material. Position des gebrochenen Knochens beibehalten.\n4. Bei offenem Bruch die Wunde keimfrei abdecken.");
			aid_nosebleeding = new StringItem ("Nasenbluten", "Kleine Ader in Nasenspitze geplatzt.\n\n1. Blutenden leicht nach vorne gelehnt hinsetzen. Kopf gerade halten.\n2. Nicht flach lagern, da Kopf über Herz-Höhe Bluten verlangsamt.\n3. Kalter Nackenumschlag.\n4. Nasenspitze bis zum Stopp der Blutung zudrücken (für 10 min).\n5. Anschließend Nase in keiner Weise anstrengen (kein Naseschnauben).\n6. Bei ernsten Beschwerden oder wenn Blutung anhält Notruf absetzen.");
			aid_emergencycall = new StringItem ("Notruf", "Wählen Sie mit dem nächst-verfügbaren Telefon 112. Immer möglich und kostenlos! Zögern Sie nie, den Notarzt zu rufen!\n\nAm Telefon Folgendes durchgeben: \n- Wo (Unfallort) \n- Was ist passiert \n- Wie viele Verletzte \n- Welche Verletzungen.\nDanach auf Rückfragen warten.");
			aid_skullfracture = new StringItem ("Schädelbasisbruch", "Leichte Blutungen aus Nase, Mund oder Ohr. Oft offene Wunde am Schädel.\n\n1. Atemwege freihalten.\n2. Bei Bewusstsein: Verletzten nach vorne gebeugt hinsetzen. Weitere Bewegungen vermeiden!\n3. Bei Bewusstlosigkeit: Stabile Seitenlage (keinen Druck auf Kopfwunde).\n4. Notruf absetzen.\n5. Kopfverband anlegen.\n6. Bei Atem- und Herz-Kreislauf-Störungen Wiederbelebung einleiten:");
			aid_stroke = new StringItem ("Schlaganfall", "Plötzliches Lähmungs- oder Taubheitsgefühl (Gesicht, Arm, Bein), gestörtes Sprachverständnis, Sehstörung, Bewusstseinstrübung, starke Kopfschmerzen. Probleme beim Atmen und Schlucken, Kontrollverlust über Blase und Darm.\n\n1. Notruf absetzen!\n2. Enge Kleidung lockern, keine Medikamente oder Getränke geben.\n3. Betroffenen bequem hinsetzen oder hinlegen. Beruhigen!\n4. Bewusstsein und Atmung kontrollieren.\n5. Bei Atem- und Herz-Kreislauf-Störungen Wiederbelebung einleiten:");
			aid_snakebite = new StringItem ("Schlangenbiss", "Punktförmige Wunde in Stecknadelgröße, heftige Schmerzen, Schwellung, blaurote Verfärbung. Kreislaufstörung, Schockgefahr.\n\n1. Verletzten Körperteil ruhigstellen\n2. Kalte Umschläge auf Bissstelle.\n3. Schockbekämpfung.\n4. Notruf absetzen.");
			aid_shock = new StringItem ("Schock", "Kreislauf-Störung durch mangelhafte Sauerstoffversorgung im Körper.\nUrsache: Verlust von Flüssigkeit, reduzierte Blutmenge.\nSymptome: Blässe, kalte Haut, kalter Schweiß, Unruhe.\n\n1. Schockursache beseitigen (z.B. Flüssigkeitsverlust stoppen, Wunde abbinden)!\n2. Betroffenen auf Decke legen, Beine hoch lagern. Beruhigen.\n3. Notruf absetzen.\n4. Bei Atem- und Herz-Kreislauf-Störungen Wiederbelebung einleiten:");
			aid_sunburn = new StringItem ("Sonnenbrand", "1. Betroffenen aus direkter Sonneneinstrahlung nehmen. Weitere Sonne meiden.\n2. Viel Wasser trinken, um Dehydration entgegenzuwirken.\n3. Bei ernsthaftem Sonnenbrand (Blasenbildung, Rötung, Schmerzen) unbedingt Arzt aufsuchen.\n4. Leichte Hautrötungen mit feuchten Umschlägen kühlen. After-Sun-Lotion oder Gel auftragen.");
			aid_sunstroke = new StringItem ("Sonnenstich", "Heißer roter Kopf, kühle Haut, Übelkeit, Kopfschmerz, Schwindelgefühl. Ursache: Reizung der Hirnhaut.\n\n1. Kühlen Ort aufsuchen (Schatten) und Oberkörper des Betroffenen erhöht lagern.\n2. Mit nassen Tüchern Kopf kühlen.\n3. Notruf absetzen, Atmung weiterhin kontrollieren.\n4. Bei Bewusstsein: Ggf. kühles Getränk geben.\n5. Bei Atemstillstand mit Beatmung beginnen:");
			aid_sos = new StringItem ("SOS", "Signal: 3x kurz, 3x lang, 3x kurz.\n\nOptisch (Blitzlicht, Taschenlampe) oder Akustisch (Signalpfeife, Klopfen).");
			aid_recoveryposition = new StringItem ("Stabile Seitenlage", "1. Betroffenen in Rückenlage, Beine ausstrecken. Daneben knien.\n2. Nahen Arm im rechten Winkel zum Körper positionieren.\n3. Fernen Arm über Brust des Verletzten ziehen und Handrücken auf Wange platzieren.\n4. Entferntes Knie fassen, zu sich ziehen und auf Boden legen. Bein etwa im rechten Winkel positionieren. Hand des Betroffenen bleibt auf dessen Wange.\n5. Sicherstellen, dass Atemwege frei sind.\n 6. Mund öffnen, Kinn leicht anheben und Kopf so positionieren, dass Erbrochenes ablaufen kann. Atmung kontrollieren.\n7. Bewusstsein und Atmung kontrollieren bis Notarzt eintrifft.");
			aid_animalbite = new StringItem ("Tierbiss", "Achtung, hohe Infektionsgefahr. Folgen wie Eiter, Tetanus, Tollwut.\n\n1. Wunde sofort mit heißem Seifenwasser auswaschen.\n2. Anschließend Wunddesinfektion auftragen.\n3. Bei starker Blutung den Oberkörper erhöht lagern.\n4. Keimfreien Verband anlegen.\n5. Krankenhaus aufsuchen oder Notruf absetzen.");
			aid_hypothermia = new StringItem ("Unterkühlung", "Kältezittern, Schläfrigkeit, Erschöpfung, bis hin zur Bewusstlosigkeit. Kalte, blasse Haut. Langsamer Puls, schwacher Herzschlag.\n\n1. Warmen Bereich aufsuchen.\n2. Notruf absetzen.\n3. Kälteeinwirkung beenden. Körpertemperatur erhöhen (Decke und Körper-zu-Körper-Kontakt).\n4. Nasse Kleidung entfernen und trockene warme Kleidung anziehen. In Decken packen. Kopf bedecken.\n5. Heißen Tee, Brühe oder heißes Wasser zu trinken geben. Keinen Alkohol! Betroffenen wachhalten.\n6. Zustand bis zum Eintreffen des Notarztes kontrollieren. Bei Verlust des Bewusstseins Wiederbelebung einleiten:");
			aid_hypoglycaemia = new StringItem ("Unterzuckerung", "Blutzuckerspiegel unter Mindestwert (aufgrund Überdosierung von Insulin oder ungenügender Nahrungsaufnahme).\nSymptome: Blässe, Nervosität, Hunger, Zittern, Schweiß.\n\n1. Zuerst klären, ob der Betroffene Diabetiker ist (siehe Diabetiker-Ausweis).\n2. Notruf absetzen.\n3. Dem Betroffenen gezuckerte Getränke und Traubenzucker geben (sofern keine Schluckschwierigkeiten).\n4. Bei Bewusstlosigkeit und vorhandener Atmung: Stabile Seitenlage einnehmen und Atmung kontrollieren. Falls Atemstillstand eintritt, den Betroffenen beatmen.\n5. Wenn Atmung vorhanden, dem Bewusstlosen ein Stück Zucker in die Backentasche legen und von außen gegendrücken.");
			aid_chemicalburn = new StringItem ("Verätzung", "Zerstörung von Gewebe.\n\n1. Eigenschutz beachten!\n2. Zügig handeln und verätzte Stellen abspülen.\n3. Notruf absetzen.\n4. Bei Verätzung des Verdauungsweges: Vermehrt Flüssigkeit trinken.\n5. Kein Erbrechen auslösen!");
			aid_burningslight = new StringItem ("Leichte Verbrennung", "Rötung der Haut. Leichte Schwellung. Schmerzen.\n\n1. Betroffene Stelle unter laufendem kalten Wasser kühlen.\n2. Feuchten Verband locker anlegen.");
			aid_burningsevere = new StringItem ("Schwere Verbrennung", "Gefleckte weiße rote Stellen, Blasenbildung. Flüssigkeitsaustritt aus Haut. Tiefe Gewebeschädigung. Starke Schmerzen oder keine Schmerzen (aufgrund verbrannter Nerven).\n\n1. Kleidung soweit wie möglich entfernen.\n2. Mit kaltem Wasser (ca. 15°C) bis zu 10 min kühlen, bis Schmerzlinderung eintritt.\n3. Falls Verbrennung großflächig, nur mit feuchten Tüchern kühlen.\n4. Notruf absetzen.\n5. Nach Kühlung die Wundversorgung durchführen. Sterile, trockene Wundauflage benutzen. Keine Flüssigkeiten aufbringen (keine Cremes, Öle, Salben etc.). Blasen nicht aufstechen.\n6. Atmung und Bewusstsein des Betroffenen kontrollieren, bis Notarzt eintrifft.");
			aid_poisining = new StringItem ("Vergiftung", "Verwirrung, Halluzination, große Pupillen, Fieber, Krämpfe. Bewusstlosigkeit.\n\n1. Gegenmittel nur verabreichen, wenn medizinisch ausgebildete Person vor Ort.\n2. Keine Getränke geben. Kein Erbrechen auslösen.\n3. Notruf absetzen + auf Vergiftung hinweisen!\n4. Giftreste und Erbrochenes sicherstellen!\n5. Sofern Betroffener bewusstlos ist und atmet: Stabile Seitenlage herstellen. Bewusstsein und Atmung kontrollieren bis Notarzt eintrifft.\n6. Sofern keine Atmung: Maßnahmen zur Wiederbelebung einleiten. Mund vorher von eventuell Erbrochenem befreien.");
			aid_safeguardaccident = new StringItem ("Unfallstelle sichern/Verkehrsunfall","1. Eigenen Pkw 50-100 m hinter Unfallstelle halten (falls Autobahn oder Landstraße). Danach Warnblinker anschalten und Warnweste anziehen.\n2. Warndreieck vor Unfallstelle aufstellen. Achtung: Bei einem Unfall in der Kurve, Warndreieck vor der Kurve platzieren!\n3. Andere Personen um Mithilfe auffordern.\n4. Tür des Unfall-Pkws öffnen (falls verklemmt, mittels Wagenheber aufstemmen). Zündung ausschalten.\n5. Unfallopfer bergen: Abschnallen, Sitz nach hinten schieben. Verletzten mit Rettungsgriff aus Wagen befreien.\n6. Notruf absetzen.\n7. Erste-Hilfe-Maßnahmen.");
			aid_sprain = new StringItem ("Verstauchung/Verrenkung", "Schmerzen, Schwellung (Bluterguss), Funktionsverlust, Verformung des Gliedes.\n\n1. Ruhigstellung des Gliedes ausschließlich in der für Betroffenen angenehmsten Position.\n2. Kühlen (mit Eisbeutel).\n3. Falls möglich Glied hoch lagern.\n4. Krankenhaus aufsuchen oder Notruf absetzen.");
			aid_resuscitation = new StringItem("Wiederbelebung", "-- Herzdruckmassage --\n1. Betroffenen in Rückenlage. Daneben hinknien.\n2. Brustkorb freimachen.\n3. In der Mitte des Brustkorbs (kurz über Brustbein) einen Handballen platzieren.\n4. Anderen Handballen auf Handrücken der bereits platzierten Hand.\n5. Arme, Ellbogen durchdrücken.\n6. Brustkorb des Betroffenen 5 cm senkrecht eindrücken (aus dem Oberkörper arbeiten) und wieder entlasten.\n7. 30-mal in Folge kurz und kräftig drücken.\n\n-- Beatmung --\n1. Entfernen von Fremdkörpern aus Mund und Rachen. Überstrecken des Kopfes in den Nacken.\n2. Nasenflügel zusammendrücken, damit Nase geschlossen ist.\n3. Tief einatmen und Mund auf Mund des Betroffenen aufsetzen, sodass keine Luft entweichen kann.\n4. Zweimal Mund zu Mund beatmen (langsam, vollständig ausatmen).\n5. Danach wieder Herzdruckmassage.\n\n*Herzdruckmassage + Beatmung fortführen bis Rettungsdienst kommt.");
			aid_backinjury = new StringItem ("Rücken-/Wirbelsäulen-Verletzung", "Schmerzen im Rücken, gefühllose Arme und Beine.\n\n1. Verletzten auf keinen Fall bewegen!!\n2. Kopf so halten, dass Betroffener stabil liegt.\n3. Verletzten nur mittels seitlicher Polsterung stabilisieren.\n4. Betroffenen beruhigen.\n5. Notruf absetzen, Hinweis auf Rückenverletzung.");
			separator = new StringItem ("Separator", "-");

			stringItemArray = new StringItem[] {aid_disclaimer, separator, aid_general, aid_allergic, aid_amputation, aid_asthma, aid_apnoea, aid_checkbreathing, 
					aid_eyeinjury, aid_chemicalburneyes, aid_apnoea, aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_bleedinglight, aid_bleedingsevere, 
					aid_diabeticcoma, aid_diarrhoea, aid_icerescue, aid_electricityaccident, aid_epilepsy, aid_vomiting, aid_frostbitemild, aid_frostbitesevere, aid_suffocation, aid_drowning, 
					aid_birth, aid_dangerzone, aid_brainconcussion, aid_resuscitation, aid_heartattack, aid_hyperthermia, aid_insectstings, aid_fracture, aid_nosebleeding, 
					aid_emergencycall, aid_resuscitation, aid_backinjury, aid_skullfracture, aid_stroke, aid_snakebite, aid_shock, aid_sunburn, aid_sunstroke, 
					aid_sos, aid_recoveryposition, aid_animalbite, aid_hyperthermia, aid_diabeticcoma, aid_safeguardaccident, aid_hypothermia, aid_hypoglycaemia, aid_chemicalburn, aid_burningslight, 
					aid_burningsevere, aid_poisining, aid_safeguardaccident, aid_suffocation, aid_sprain, aid_resuscitation, aid_backinjury, separator}; 

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
		else if (auswahl==6 || auswahl==10) { details.append(aid067);
						  details.append(""); details.append(aid010);
						  details.append(""); details.append(aid011); }
		// img:backinjury
		else if (auswahl==36 || auswahl==59) { details.append(aid065); }
		// img:birth
		else if (auswahl==25) { details.append(aid025);
								details.append(""); details.append(aid022); 
								details.append(""); details.append(aid023); }
		// img:chemicalburneyes
		else if (auswahl==9) { details.append(aid019); }
		// img:bleedinglight
		else if (auswahl==13) { details.append(aid084);
							    details.append(""); details.append(aid085); }
		// img:bleedingsevere
		else if (auswahl==14) { details.append(aid084);
							    details.append(""); details.append(aid085);
							    details.append(""); details.append(aid089);
							    details.append(""); details.append(aid092); }
		// img:brainconcussion
		else if (auswahl==27) { details.append(aid061); }
		// img:danger zone resuce
		else if (auswahl==26) { details.append(aid001); }
		// img:drowning
		else if (auswahl==24) { details.append(aid034); }
		// img:electricity accident
		else if (auswahl==18) { details.append(aid045); }
		// img:epilepsy
		else if (auswahl==19) { details.append(aid058); }
		// img:fracture
		else if (auswahl==32) { details.append(aid107); }
		// img:heart attack
		else if (auswahl==29) { details.append(aid061); }
		// img:ice rescue
		else if (auswahl==17) { details.append(aid041); }
		// img:recovery position
		else if (auswahl==44) { details.append(aid008); 
							  details.append(""); details.append(aid009); 
							  details.append("\nStabile Seitenlage (Baby):"); details.append(aid028); }
		// img:resuscitation
		else if (auswahl==28 || auswahl==35 || auswahl==58) { 
							  details.append(aid013);
							  details.append(""); details.append(aid003); 
							  details.append(""); details.append(aid067); 
							  details.append(""); details.append(aid010); 
							  details.append(""); details.append(aid011); 
							  details.append(""); details.append(aid012);
							  details.append("\n\n# Wiederbelebung (Baby)\n\nNur zwei Finger benutzen:"); details.append(aid029); 
							  details.append("\nNicht zu stark beatmen:"); details.append(aid030); }
		// img:safeguard accident
		else if (auswahl==48 || auswahl==55) { details.append(aid001); }
		// img:suffocation
		else if (auswahl==23 || auswahl==56) { details.append(aid031); 
							  details.append(""); details.append(aid069); }
		// img:sunstroke
		else if (auswahl==42) { details.append(aid061); }
		// img: unconscious with breathing
		else if (auswahl==11) { details.append(aid008); 
							  details.append(""); details.append(aid009); }
		
		// spacer below
		details.append("");

		// append Resuscitation measures!
		// for unconsciouswithoutbreath / drowning / heartattack / brainconcussion / stroke / shock / poisining
		if (auswahl==12 || auswahl==24 || auswahl==29 || auswahl==37 || auswahl==38 || auswahl==40 || auswahl==54) { 
			details.append(aid_resuscitation);
			  details.append(aid013);
			  details.append(""); details.append(aid003);  details.append(""); details.append(aid067); 
			  details.append(""); details.append(aid010);  details.append(""); details.append(aid011); 
			  details.append(""); details.append(aid012);
		} 
		// for electricity / hypothermia
		else if (auswahl==18 || auswahl==49) { 
			details.append(aid_unconsciouswithbreath); 
			details.append("");
			details.append(aid_unconsciouswithoutbreath); 
			details.append("");
			details.append(aid_resuscitation); 
			  details.append(""); details.append(aid003);   details.append(""); details.append(aid067); 
			  details.append(""); details.append(aid010);   details.append(""); details.append(aid011); 
		} // for sunstroke / asthma / hypoglycaemia
		else if (auswahl==42 || auswahl==5 || auswahl==50) { 
			details.append(aid_apnoea);
			details.append(""); details.append(aid010);	
			details.append(""); details.append(aid011); 
		}
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
			else if (telEmergency.getSelectedIndex() == 3) { details.append(stringNorthamerica); }
			else if (telEmergency.getSelectedIndex() == 4) { details.append(stringOceania); }
			else if (telEmergency.getSelectedIndex() == 5) { details.append(stringSouthamerica); }
			display.setCurrent(details);
		}
		// Main Menu
		else if (display.getCurrent().getTitle() == menu.getTitle()) {
			// emergency numbers
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
