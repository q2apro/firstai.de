// First.Aid.3.0.standard
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
	static final Command cmdBack = new Command("Back", Command.BACK, 2);
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

		this.menu = new List("Primo Soccorso 3.0", Choice.IMPLICIT);this.menu.append("# WE NEED TRANSLATORS!", null);this.menu.append("# Chiamate di emergenza", null);this.menu.append("# Condotta generale", null);this.menu.append("Reazione allergica", null);this.menu.append("Amputazione", null);this.menu.append("Morso degli animali", null);this.menu.append("Apnea", null);this.menu.append("Asma", null);this.menu.append("Dorso-lombari", null);this.menu.append("Nascita", null);this.menu.append("Bleeding luce", null);this.menu.append("Sanguinamento grave", null);this.menu.append("Brain commozione cerebrale", null);this.menu.append("Di respirazione", null);this.menu.append("Affanno", null);this.menu.append("Burning luce", null);this.menu.append("Grave che brucia", null);this.menu.append("Controllare respirazione", null);this.menu.append("Chemical Burn (Occhi)", null);this.menu.append("Burn chimica", null);this.menu.append("Toracico di compressione", null);this.menu.append("Zona pericolosa", null);this.menu.append("Coma diabetico", null);this.menu.append("Diarrea", null);this.menu.append("Drowning", null);this.menu.append("Energia elettrica di incidenti", null);this.menu.append("Chiamata d\'emergenza", null);this.menu.append("Epilessia", null);this.menu.append("Lesione", null);this.menu.append("Frattura", null);this.menu.append("Assideramento mite", null);this.menu.append("Grave assideramento", null);this.menu.append("Heart Attack", null);this.menu.append("Iperglicemia (zucchero)", null);this.menu.append("Ipoglicemia (basso zucchero)", null);this.menu.append("Ipertermia (caldo corpo)", null);this.menu.append("Ipotermia (aria fresca corpo)", null);this.menu.append("Ice salvataggio", null);this.menu.append("Morsi di insetto", null);this.menu.append("Nosebleeding", null);this.menu.append("Avvelenamento", null);this.menu.append("Rianimazione", null);this.menu.append("Di recupero posizione", null);this.menu.append("Rianimazione", null);this.menu.append("Di salvaguardia degli incidenti", null);this.menu.append("Shock", null);this.menu.append("La frattura Cranio\'", null);this.menu.append("Snakebite", null);this.menu.append("SOS", null);this.menu.append("Frattura spinale", null);this.menu.append("Distorsione di tensione", null);this.menu.append("Corsa", null);this.menu.append("Soffocamento", null);this.menu.append("Eritema solare", null);this.menu.append("Sunstroke", null);this.menu.append("Swallow / Soffocamento", null);this.menu.append("Incidente stradale", null);this.menu.append("Incoscienza con la respirazione", null);this.menu.append("Incoscienza senza respiro", null);this.menu.append("Vomito", null);this.menu.append("-------------", null); this.menu.append("Call Emergency 112", null);
		// commands
		this.menu.addCommand(cmdExit);
		this.menu.setCommandListener(this);

		details = new Form ("First Aid on your Mobile");

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
			telEmergency = new List ("Continent", Choice.IMPLICIT);
			telEmergency.append("Africa", null);
			telEmergency.append("Asia", null);
			telEmergency.append("Europe", null);
			telEmergency.append("North-/Central America", null);
			telEmergency.append("Oceania", null);
			telEmergency.append("South America", null);
			telEmergency.addCommand(cmdBack);
			telEmergency.setCommandListener(this);
			stringAfrica = new StringItem("- Africa -", "\n# Algeria\nFire:14 | Pol:17 | Med:17\n\n# Angola\nFire:118 | Pol:110 | Med:118\n\n# Benin\nFire:18 | Pol:17 | Med:301769\n\n# Botswana\nFire:998 | Pol:999 | Med:997\n\n# Burkina Faso\nFire:18 | Pol:17 | Med:local numbers\n\n# Burundi\nFire:no system | Pol:no system | Med:no system\n\n# Cameroon\nFire:18 | Pol:17 | Med:local numbers\n\n# Cape Verde\nFire:131 | Pol:132 | Med:130\n\n# Central African Republic\nFire:118 | Pol:611253 | Med:610600\n\n# Chad\nFire:18 | Pol:17 | Med:local numbers\n\n# Comoros\nFire:only radio telephones | Pol:only radio telephones | Med:only radio telephones\n\n# Congo (Democratic Republic)\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Congo (Republic)\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Djibouti\nFire:18 | Pol:17 | Med:351351\n\n# Egypt\nFire:180 | Pol:122 | Med:123\n\n# Equatorial Guinea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Eritrea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Ethiopia\nFire:93 | Pol:91 | Med:92\n\n# Gabon\nFire:18 | Pol:1730 | Med:1300\n\n# Gambia\nFire:118 | Pol:117 | Med:116\n\n# Ghana\nFire:192 | Pol:191 | Med:193\n\n# Guinea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Guinea-Bissau\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Ivory Coast\nFire:180 | Pol:110 | Med:110\n\n# Kenya\nFire:999 | Pol:999 | Med:999\n\n# Lesotho\nFire:122 | Pol:123 | Med:121\n\n# Liberia\nFire:911 | Pol:911 | Med:911\n\n# Libya\nFire:193 | Pol:193 | Med:193\n\n# Madagascar\nFire:18 | Pol:117 | Med:2262566\n\n# Malawi\nFire:199 | Pol:199 | Med:199\n\n# Mali\nFire:18 | Pol:17 | Med:15\n\n# Mauritania\nFire:118 | Pol:117 | Med:local numbers\n\n# Mauritius\nFire:999 | Pol:999 | Med:999\n\n# Mayotte\nFire:603054 | Pol:112 | Med:15\n\n# Morocco\nFire:15 | Pol:19 | Med:15\n\n# Mozambique\nFire:198 | Pol:119 | Med:117\n\n# Namibia\nFire:2032270 | Pol:1011 | Med:2032276\n\n# Niger\nFire:18 | Pol:17 | Med:723141\n\n# Nigeria\nFire:190 | Pol:119 | Med:199\n\n# R�union\nFire:18 or 112 mobile | Pol:17 or 112 mobile | Med:15 or 112 mobile\n\n# Rwanda\nFire:local numbers | Pol:112 | Med:local numbers\n\n# Sahrawi Arab Democratic Republic\nFire:-- | Pol:-- | Med:--\n\n# Sao Tom� and Principe\nFire:-- | Pol:-- | Med:--\n\n# Senegal\nFire:local numbers | Pol:local numbers | Med:8891515\n\n# Seychelles\nFire:999 | Pol:999 | Med:999\n\n# Sierra Leone\nFire:999 | Pol:999 | Med:999\n\n# Somalia\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# South Africa\nFire:10111 | Pol:10111 | Med:10177\n\n# Sudan\nFire:999 | Pol:999 | Med:local numbers\n\n# Swaziland\nFire:local numbers | Pol:999 | Med:6060911\n\n# Tanzania\nFire:112 | Pol:112 | Med:112\n\n# Togo\nFire:118 | Pol:101 | Med:191\n\n# Tunisia\nFire:198 | Pol:197 | Med:190\n\n# Uganda\nFire:999 or 111 mobile | Pol:999 or 111 mobile | Med:999 or 111 mobile\n\n# Zambia\nFire:993 or 112 mobile | Pol:999 or 112 mobile | Med:991 or 112 mobile\n\n# Zimbabwe\nFire:993 | Pol:995 | Med:994");
			stringAsia = new StringItem("- Asia -", "\n# Afghanistan\nFire:-- | Pol:-- | Med:112\n\n# Armenia\nFire:101 | Pol:102 | Med:103\n\n# Azerbaijan\nFire:101 | Pol:102 | Med:103\n\n# Bahrain\nFire:999 | Pol:999 | Med:999\n\n# Bangladesh\nFire:9555555 | Pol:8665513 | Med:199\n\n# Bhutan\nFire:113 | Pol:110 | Med:112\n\n# Brunei\nFire:995 | Pol:993 | Med:991\n\n# Cambodia\nFire:118 | Pol:117 | Med:199\n\n# China\nFire:119 | Pol:110 | Med:120\n\n# East Timor\nFire:-- | Pol:112 | Med:7233212\n\n# Georgia\nFire:022 | Pol:022 | Med:022\n\n# Hong Kong\nFire:999 | Pol:999 | Med:999\n\n# India\nFire:101 | Pol:100 | Med:102\n\n# Indonesia\nFire:113 | Pol:110 | Med:118\n\n# Iran\nFire:125 or 112 mobile | Pol:110 or 112 mobile | Med:115 or 112 mobile\n\n# Iraq\nFire:no system | Pol:no system | Med:no system\n\n# Israel\nFire:102 | Pol:100 | Med:101\n\n# Japan\nFire:119 | Pol:110 | Med:119\n\n# Jordan\nFire:193 | Pol:192 | Med:193\n\n# Kazakhstan\nFire:03 | Pol:03 | Med:03\n\n# Kurdistan\nFire:125 | Pol:129 | Med:115\n\n# Kuwait\nFire:777 | Pol:777 | Med:777\n\n# Kyrgyzstan\nFire:03 | Pol:133 | Med:03\n\n# Laos\nFire:local numbers | Pol:local numbers | Med:03\n\n# Lebanon\nFire:175 | Pol:112 | Med:140\n\n# Macau\nFire:999 | Pol:999 | Med:999\n\n# Malaysia\nFire:999 or 112 mobile | Pol:999 or 112 mobile | Med:999 or 112 mobile\n\n# Maldives\nFire:118 | Pol:119 | Med:102\n\n# Mongolia\nFire:101 | Pol:102 | Med:103\n\n# Myanmar\nFire:199 | Pol:199 | Med:199\n\n# Nepal\nFire:101 | Pol:100 | Med:228094\n\n# North Korea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Oman\nFire:999 | Pol:999 | Med:999\n\n# Pakistan\nFire:16 | Pol:15 | Med:115\n\n# Philippines\nFire:117 | Pol:117 | Med:117\n\n# Qatar\nFire:999 | Pol:999 | Med:999\n\n# Saudi Arabia\nFire:998 | Pol:999 | Med:997\n\n# Singapore\nFire:995 | Pol:999 | Med:995\n\n# South Korea (Republic Korea)\nFire:119 | Pol:112 | Med:119\n\n# Sri Lanka\nFire:111 | Pol:119 or 112 mobile | Med:110\n\n# Syria\nFire:113 | Pol:112 | Med:110\n\n# Taiwan\nFire:119 | Pol:110 | Med:119\n\n# Tajikistan\nFire:local numbers | Pol:02 | Med:03\n\n# Thailand\nFire:199 | Pol:191 or 1155 (tourists) | Med:191\n\n# Turkmenistan\nFire:03 | Pol:03 | Med:03\n\n# United Arab Emirates\nFire:997 | Pol:999 | Med:998\n\n# Uzbekistan\nFire:03 | Pol:03 | Med:03\n\n# Vietnam\nFire:114 | Pol:113 | Med:115\n\n# Yemen\nFire:199 | Pol:199 | Med:199");
			stringEurope = new StringItem("- Europe -", "\n# Albania\nFire:18 | Pol:19 | Med:17\n\n# Andorra\nFire:118 | Pol:110 | Med:118\n\n# Austria\nFire:112 | Pol:112 | Med:112\n\n# Belarus\nFire:01 | Pol:02 | Med:03\n\n# Belgium\nFire:112 | Pol:112 | Med:112\n\n# Bosnia and Herzegovina\nFire:123 | Pol:122 | Med:124\n\n# Bulgaria\nFire:112 | Pol:112 | Med:112\n\n# Croatia\nFire:93 | Pol:92 | Med:94\n\n# Cyprus\nFire:112 | Pol:112 | Med:112\n\n# Czech Republic\nFire:112 | Pol:112 | Med:112\n\n# Denmark\nFire:112 | Pol:112 | Med:112\n\n# Estonia\nFire:112 | Pol:112 | Med:112\n\n# Finland\nFire:112 | Pol:112 | Med:112\n\n# France\nFire:18 or 112 | Pol:17 or 112 | Med:15 or 112\n\n# Germany\nFire:112 | Pol:110 | Med:112\n\n# Greece\nFire:112 | Pol:112 | Med:112\n\n# Hungary\nFire:112 | Pol:112 | Med:112\n\n# Iceland\nFire:112 | Pol:112 | Med:112\n\n# Ireland\nFire:112 | Pol:112 | Med:112\n\n# Italy\nFire:112 | Pol:112 | Med:112\n\n# Kosovo\nFire:911 | Pol:911 | Med:911\n\n# Latvia\nFire:112 | Pol:112 | Med:112\n\n# Liechtenstein\nFire:112 | Pol:112 | Med:112\n\n# Lithuania\nFire:112 | Pol:112 | Med:112\n\n# Luxembourg\nFire:112 | Pol:112 | Med:112\n\n# Macedonia\nFire:112 | Pol:112 | Med:112\n\n# Malta\nFire:112 | Pol:112 | Med:112\n\n# Moldova\nFire:901 | Pol:902 | Med:903\n\n# Monaco\nFire:112 | Pol:112 | Med:112\n\n# Montenegro\nFire:112 | Pol:112 | Med:112\n\n# Netherlands\nFire:112 | Pol:112 | Med:112\n\n# Norway\nFire:110 | Pol:112 | Med:113\n\n# Poland\nFire:112 | Pol:112 | Med:112\n\n# Portugal\nFire:112 | Pol:112 | Med:112\n\n# RepublicofIreland\nFire:112 | Pol:112 | Med:112\n\n# Romania\nFire:112 | Pol:112 | Med:112\n\n# Russia\nFire:01 | Pol:02 | Med:03\n\n# San Marino\nFire:116 | Pol:112 | Med:113\n\n# Serbia\nFire:112 | Pol:112 | Med:112\n\n# Slovakia\nFire:112 | Pol:112 | Med:112\n\n# Slovenia\nFire:112 | Pol:113 | Med:112\n\n# Spain\nFire:112 | Pol:112 | Med:112\n\n# Sweden\nFire:112 | Pol:112 | Med:112\n\n# Switzerland\nFire:118 or 112 | Pol:117 or 112 | Med:144 or 112\n\n# Turkey\nFire:110 | Pol:155 | Med:112\n\n# Ukraine\nFire:112 | Pol:112 | Med:112\n\n# United Kingdom\nFire:112 | Pol:112 | Med:112\n\n# Vatican City\nFire:115 | Pol:112 | Med:113");
			stringNorthamerica = new StringItem("- North-/Central America -", "\n# United States of America\nFire:911 | Pol:911 | Med:911\n\n# Antigua and Barbuda\nFire:911 | Pol:911 | Med:911\n\n# Bahamas\nFire:911 | Pol:911 | Med:911\n\n# Barbados\nFire:113 | Pol:112 | Med:115\n\n# Belize\nFire:911 | Pol:911 | Med:911\n\n# Canada\nFire:911 | Pol:911 | Med:911\n\n# Cayman Islands\nFire:911 | Pol:911 | Med:911\n\n# Costa Rica\nFire:911 | Pol:911 | Med:911\n\n# Cuba\nFire:26811 | Pol:26811 | Med:26811\n\n# Dominica\nFire:999 | Pol:999 | Med:999\n\n# Dominican Republic\nFire:911 | Pol:911 | Med:911\n\n# El Salvador\nFire:911 | Pol:911 | Med:911\n\n# Greenland\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Grenada\nFire:911 | Pol:112 | Med:911\n\n# Guatemala\nFire:122 | Pol:110 | Med:123\n\n# Haiti\nFire:local numbers | Pol:114 | Med:118\n\n# Honduras\nFire:198 | Pol:119 | Med:378654\n\n# Jamaica\nFire:110 | Pol:119 | Med:110\n\n# Mexico\nFire:060 | Pol:080 | Med:060\n\n# Nicaragua\nFire:2650162 | Pol:118 | Med:2651761\n\n# Panama\nFire:103 | Pol:104 | Med:2699778\n\n# Saint Kitts and Nevis\nFire:911 | Pol:911 | Med:911\n\n# Saint Lucia\nFire:911 | Pol:999 | Med:911\n\n# Saint Pierre and Miquelon\nFire:18 | Pol:17 | Med:15\n\n# Saint Vincent and Grenadines\nFire:911 | Pol:911 | Med:911\n\n# Trinidad and Tobago\nFire:990 | Pol:999 | Med:990");
			stringOceania = new StringItem("- Oceania -", "\n# Australia\nFire:000 or 112 mobile | Pol:000 or 112 mobile | Med:000 or 112 mobile\n\n# Fiji\nFire:9170 | Pol:911 | Med:911\n\n# Kiribati\nFire:local numbers | Pol:local numbers | Med:994\n\n# Marshall Islands\nFire:local numbers | Pol:6258666 | Med:6254111 \n\n# Micronesia\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Nauru\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# New Zealand\nFire:111 | Pol:111 | Med:111\n\n# Palau\nFire:911 | Pol:911 | Med:911\n\n# Papua New Guinea\nFire:110 | Pol:000 | Med:local numbers\n\n# Samoa\nFire:994 | Pol:995 | Med:996\n\n# Solomon Islands\nFire:911 | Pol:911 | Med:911\n\n# Tonga\nFire:999 | Pol:922 | Med:933\n\n# Tuvalu\nFire:911 | Pol:911 | Med:911\n\n# Vanuatu\nFire:112 | Pol:112 | Med:112");
			stringSouthamerica = new StringItem("- South America -", "\n# Argentina\nFire:100 | Pol:101 | Med:107\n\n# Bolivia\nFire:911 | Pol:911 | Med:911\n\n# Brazil\nFire:193 | Pol:190 | Med:192\n\n# Chile\nFire:132 | Pol:133 | Med:131\n\n# Colombia\nFire:119 | Pol:119 | Med:119\n\n# Ecuador\nFire:102 | Pol:101 | Med:131\n\n# Guyana\nFire:912 | Pol:911 | Med:913\n\n# Paraguay\nFire:911 | Pol:911 | Med:911\n\n# Peru\nFire:116 | Pol:105 | Med:116\n\n# Suriname\nFire:115 | Pol:115 | Med:115\n\n# Uruguay\nFire:911 | Pol:911 | Med:911\n\n# Venezuela\nFire:171 | Pol:171 | Med:171");

			// First-Aid-Text
			aid_disclaimer = new StringItem ("Informazioni legali", "1. Software\nDi primo soccorso sul tuo telefonino\nVersione: 3.0\nRelease: 2009-07\nCopyright: Kai Kajus Noack\n\nTranslators: \u2026\nLicenza: Creative Commons\n\nFirst Aid Illustrations \u00A9 Med4Teens\n\nQuesto programma \u00E8 supposto di dare informazioni sul pronto soccorso. Tuttavia, esso non rappresenta un sostituto a un corso di primo soccorso. E \'invece vi serve il tuo rinfrescante gi\u00E0 acquisito conoscenze.\n\n2. Disclaimer\nSi prega di notare che io non assume alcuna responsabilit\u00E0 per le conseguenze derivanti dall\'uso di software.\nOgni responsabilit\u00E0 \u00E8 esclusa!\nUtilizzare a proprio rischio e pericolo!\n\nIn tutti i casi di emergenza, si prega di cercare un aiuto professionale immediatamente.\n\n3. Sviluppo del progetto \nIl programma si suppone a imparare le lingue. I traduttori volontari necessari!\nUlteriori informazioni sono disponibili su Internet www.firstai.de o scrivere una e-mail a: info@firstai.de\n\nPer salvare una vita \u00E8 di aver salvato il mondo.");aid_general = new StringItem ("Condotta generale", "1. Semper eseguire pronto soccorso. Non \u00E8 possibile effettuare eventuali errori.\n2. Tutto l\'attenzione alla propria sicurezza.\n3. Esaminare la situazione e garantire l\'incidente posto.\n4. Chiamata di emergenza, le misure di primo soccorso!\n5. Se ci sono diverse vittime, il trattamento della maggior parte lesa ha la priorit\u00E0.\n6. Semper cercare di calmare la persona in questione. Rimanere calma te!\n7. Se possibile stabilire la sua / lui comodamente. Mai dare alcol, nicotina o uso di sostanze stupefacenti ad una persona.");aid_allergic = new StringItem ("Reazione allergica", "1. Telefono per un\'ambulanza immediatamente.\n2. Provare a calmare il sinistro e lasciarlo stare comodo.\n3. Rimuovere questione provocando reazioni allergiche (ad esempio, di un bastone ape) attentamente.\n4. Cool colpiti pelle (comprimere bagnato, ghiaccio).\n5. Se il sinistro ha un antidoto, egli dovrebbe utilizzare (aiuto lui).\n6. Monitorare il numero delle vittime fino a condizione ambulanza arriva.\n7. Se sinistro perde coscienza o smette di respirare, seguire le istruzioni del caso!");aid_amputation = new StringItem ("Amputazione", "Amputata parte del corpo pu\u00F2 essere RICOSTITUIRLO nuovamente. Obiettivo: Tenere amputata parte raffreddare fino ad arrivare a un ospedale.\n1. Calma la persona, laici lui / lei, e coprire con una coperta.\n2. Arrestare il sanguinamento, si veda \'Bleeding (grave)\' e \'Shock\'.\n3. Avvolgere amputata parte in un ambiente pulito e asciutto, e metterla in un sacchetto di plastica impermeabile.\n4. Chiudi questa borsa di plastica e metterla in un sacchetto di plastica, che contiene acqua fresca / ghiaccio.\n5. Non dare alcool, sigarette o cibo per sinistro (nel caso di un intervento chirurgico con anestesia in ospedale).\n6. Non congelare la amputata parte (solo tenerlo fresco).\n7. Chiamata di emergenza o di unit\u00E0 di pronto soccorso ospedale te.");aid_animalbite = new StringItem ("Morso degli animali", "Attenzione: pericolo di alta di infezione. Risultato potrebbe essere pus, il tetano, la rabbia.\n1. Lavare ferita con acqua calda sapone.\n2. Successivamente l\'uso di disinfezione della ferita.\n3. Se si ha una forte emorragia, elevare la persona della parte superiore del corpo.\n4. Applicare un bendaggio asettico.\n5. Andare a un ospedale o chiamare il medico di emergenza.");aid_apnoea = new StringItem ("Apnea", "N. respirazione respiro suoni o movimenti, evidente scolorimento della pelle.\n1. Chiamata di emergenza.\n2. Lay sinistro sulla schiena.\n3. Tratto in testa al collo. Rimuovere le sostanze di bocca e della gola.\n4. Ala di spingere il naso insieme, in modo che il naso \u00E8 chiuso.\n5. Fai un respiro profondo e metti la tua bocca sulla bocca del sinistro, che non pu\u00F2 perdite d\'aria.\n6. Soffio fuori lentamente e completamente.\n7. Se senza successo: Non respirare finch\u00E9 arriva ambulanza.");aid_asthma = new StringItem ("Asma", "Pesante affanno. Sibilo respiratorio rumore. Ansie.\n1. Calma la persona. Rimanere calma te!\n2. Allentare indumenti.\n3. Consentitemi di sinistro e sedersi magra avanti, chiedere a respirare lentamente e profondamente.\n4. Se ha un sinistro inhalator, egli dovrebbe utilizzare (aiuto lui). Dopo 5-10 minuti si deve entrare in vigore.\n5. Se non vi \u00E8 alcun miglioramento: Usa inhalator ogni 5 minuti fino a quando arriva in ambulanza.\n6. Chiamata di emergenza.\n7. Se appare apnea, inizia con la respirazione.");aid_backinjury = new StringItem ("Dorso-lombari", "Dolore alla schiena, intirizzito braccia e gambe.\n1. Non spostare il sinistro!\n2. Tenere la testa il modo in cui la persona si trova stabile (mantenere il loro capo fermo)\n3. Stabilizzare il sinistro con rafforza sul lato.\n4. Calma la persona.\n5. Chiamata di emergenza, segnalare il dorso-lombari.");aid_birth = new StringItem ("Nascita", "Deflusso di liquido amniotico. Contrazione dolori verificarsi. Nascita inaspettata.\n1. Prestare attenzione al rispetto della vita privata e mantenere la calma! - Chiamata di emergenza.\n2. Lasciate che la donna incinta nudo la parte inferiore del suo corpo, e sedersi su una sterile underlay con diffusione gambe.\n3. Angolo le ginocchia. Tirare verso l\'alto il gambe. Posizionare il bacino leggermente verso l\'alto. - La nascita \u00E8 un processo naturale e gestisce la maggior parte senza complicazioni.\n4. Calma la donna, sia il suo concentrarsi sulla sua respirazione: Respira attraverso il naso, respirare attraverso la bocca (a velocit\u00E0 normale).\n5. Ritmo delle pressanti: Fai un respiro profondo, essere in possesso di respiro, e premere. Non appena il bambino la testa sembra, il sostegno con il mouse con entrambe le mani.\n6. Dopo il parto: Tenere il bambino slantly con la testa verso il basso per liberare le vie aeree dal liquido amniotico. (Forse si deve aspirare il liquido fuori dal naso del bambino con la bocca.) Il bambino deve respirare e piangere!\n7. Impegnare il cordone ombelicale 30 cm di distanza dal bambino (pu\u00F2 anche essere fatto in ospedale). Coprire la vagina della madre sterile.\n8. Asciutto il bambino e lo tiene caldo. Nota il tempo e guida in ospedale.");aid_bleedinglight = new StringItem ("Bleeding luce", "Obiettivo: Arrestare il sanguinamento.\n1. Non toccare la ferita (pericolo di infezione).\n2. Non trattare con ferita in polvere, salves o spray.\n3. Ferita trattamento con materiale sterile e un bendaggio.\n4. Per po \'di sanguinamento un cerotto \u00E8 spesso sufficiente.\n5. Se ferita \u00E8 larga scala l\'uso coprire una ferita e una benda. Non si applicano al bendaggio stretto, come una stasi pu\u00F2 portare ad un aumento di sanguinamento.\n6. Nota: Le ferite della rabbia devono essere lavati con la soluzione di sapone.");aid_bleedingsevere = new StringItem ("Sanguinamento grave", "Spruzzi, e la vivacit\u00E0 di sangue. Pericolo: Starter a causa della perdita di sangue, infezioni, la morte. Obiettivo: Arrestare il sanguinamento.\n1. Rimuovere i vestiti (taglio se necessario) e rivelano ferita.\n2. Avvolgere un bendaggio o, se necessario, un indumento con pressione intorno alla ferita.\n3. Esercitare pressioni per almeno 10 min.\n4. Se bendaggio \u00E8 intrisa di sangue, non rimuoverlo. Invece avvolgere un altro bendaggio / indumento intorno ad esso.\n5. Conservare la parte colpita (se non rotto) superiore al cuore per ridurre le quantit\u00E0 di pressione sanguigna. Se possibile stabilire sinistro.\n6. Se l\'emorragia non si ferma, mantenere la pressione sulla ferita, e ha fissato inoltre il punto di pressione sulla ferita: Per un sanguinamento del avambraccio comprimere la parte superiore del braccio (premere vena a lato interno del braccio, a met\u00E0 del gomito e braccio-buca, utilizzando il dita). Per il dissanguamento della gamba impostare la pressione nel punto inguine (stampa in vena di truffatore inguine, dove conduce su arteria pelvico, utilizzando la tua sfera della mano).\n7. Chiamata di emergenza medico immediatamente.\n8. Non appena l\'emorragia \u00E8 sotto controllo: Avviare il soffocamento misure.");aid_brainconcussion = new StringItem ("Brain commozione cerebrale", "Mal di testa, nausea, vomito. Visivo. Perdita di coscienza pu\u00F2 verificarsi.\n1. Stabilire persona interessata.\n2. Chiamata di emergenza.\n\nSe l\'emorragia a testa:\n1. Stabilire sinistro, posizione elevata la testa (sul cuscino).\n2. Fare ferita-trattamento (uso testa-bendaggio).\n3. Chiamata di emergenza.");aid_burningslight = new StringItem ("Burning luce", "Arrossamento della pelle. Lieve gonfiore. Dolore.\n1. Tenere interessato l\'area sotto acqua fredda.\n2. Applica bagnato bendaggio liberamente.");aid_burningsevere = new StringItem ("Grave che brucia", "Spotted bianco-rosso settori, vesciche. La pelle perde liquido. Deep danni di tessuto. Forte dolore o non dolore (a causa di bruciato nervi).\n1. Rimuovere i vestiti, per quanto possibile.\n2. Cool bruciato parti del corpo con acqua (circa 15 \u00B0 C, 59 \u00B0 F) fino a 10 minuti, fino a quando il dolore diminuisce.\n3. Se la combustione \u00E8 ampia, basta usare panni umidi raffreddare.\n4. Chiamata di emergenza.\n5. Dopo il raffreddamento fare la ferita trattamento: Utilizzare una medicazione sterile. Non applicare fluidi (senza creme, oli, pomate, ecc.) Non perforare il blister.\n6. Controllo la respirazione e della coscienza della persona fino a quando arriva medico di emergenza.");aid_checkbreathing = new StringItem ("Controllare respirazione", "1. Controllare la respirazione suoni.\n2. Diagnosticare la respirazione in addome superiore (laici tua mano su di esso).\n3. Senso a respirare il naso e la bocca.");aid_chemicalburneyes = new StringItem ("Chemical Burn (Occhi)", "1. Chiamata di emergenza, punto di sostanze chimiche.\n2. Lavare gli occhi con molta acqua. Copertina occhio sano durante vampate di calore.\n3. Portare il getto d\'acqua dal punto di vista interiore di vista esterno angolo di occhio. Pulito per almeno 20 minuti sotto acqua.\n4. Chiudere entrambi gli occhi del sinistro e si legano con un panno umido.\n5. Monitor condizione fino a quando arriva ambulanza.");aid_chemicalburn = new StringItem ("Burn chimica", "Lesioni dei tessuti.\n1. Mente auto-protezione!\n2. Agire rapidamente e di lavaggio fino alla localit\u00E0 bruciato.\n3. Chiamata di emergenza.\n4. Se vi \u00E8 una sostanza chimica di bruciare la digestione modi bere molta acqua.\n5. Non provocare il vomito!");aid_dangerzone = new StringItem ("Zona pericolosa", "1. Grip esecuzione: Posizione braccio uno dei feriti di fronte il suo petto, e avere dietro di lui / lei.\n2. Metti le mani sotto le spalle dei feriti, prendendola per il braccio angolato.\n3. Tirare indietro e portare la persona in sicurezza.");aid_diabeticcoma = new StringItem ("Coma diabetico", "Livello di zucchero nel sangue \u00E8 troppo alto (risp. mancanza di insulina).\nSintomi: sete, minzione frequente, nausea, vomito. Respiro odori di frutta / vino.\n1. Chiamata di emergenza.\n2. Supporto sinistro (se assicurato diabetica) del trattamento insulinico.\n3. Recupero posizione. (N. ulteriori possibilit\u00E0 per la prima aiutare.)\n4. Monitorare la condizione del sinistro fino a quando arriva medico di emergenza.");aid_diarrhoea = new StringItem ("Diarrea", "Sickliness di cibo, di infezione o malattia intestinale. Sgabello \u00E8 diluito, viscido o sanguinoso.\n1. Pericolo per la circolazione a causa della disidratazione e perdita di sale!\n2. Dare liquidi (t\u00E8, acqua).\n3. Se vi sono forti disturbi di emergenza chiamare il medico.");aid_drowning = new StringItem ("Drowning", "1. Chiamata di emergenza. Chiedere alle persone accanto a voi per aiutarvi.\n2. Soccorso persona di acqua!\n3. Se il sinistro \u00E8 di respirazione: Recupero posizione. Tenere lui / lei caldo (copertina). Monitor condizione di emergenza fino a quando arriva medico.\n4. Se il sinistro non \u00E8 la respirazione: iniziare immediatamente con la rianimazione! (Emit di acqua dal polmone \u00E8 inutile.)");aid_electricityaccident = new StringItem ("Energia elettrica di incidenti", "1. In primo luogo interrompere la fornitura di energia elettrica!\nPericolo: L\'incoscienza, apnea.\n2. A - L\'incoscienza con la respirazione\n3. B - L\'incoscienza senza respiro");aid_emergencycall = new StringItem ("Chiamata d\'emergenza", "1. 112 con il prossimo disponibili telefono (Stati Uniti d\'America: 911). Semper possibile e gratuitamente! Non esitate a chiamare un\'ambulanza! Il telefono \u00E8 necessario fornire le seguenti informazioni: Che cosa \u00E8 accaduto - Dove (luogo incidente) - Come molte vittime - Che tipo di lesioni. Successivamente attendere per ulteriori indagini.");aid_epilepsy = new StringItem ("Epilessia", "Del corpo rigido, stretto pugni, pressati mandibola, spasmi nelle arti o del viso. Rolling occhi. Salivazione. Possibile perdita di coscienza.\n1. Non tenere il sinistro o danno al loro movimento.\n2. Lay \u00E8 verificato il sinistro su un morbido base (cuscino), rimuovere gli oggetti vicino a prevenire auto-lesioni.\n3. Calmati \u00E8 verificato il sinistro. Allentare abbigliamento, la libert\u00E0 di fornire respiro.\n4. Se vomits sinistro, girare la testa al lato vomito che possono esaurire.\n5. Tenere Airways chiaro. Pericolo di inghiottire la lingua.\n6. Posizione di ripristino di chiamata di emergenza. Continuare a monitorare la condizione del sinistro.\n7. Tenere altre persone a distanza.");aid_eyeinjury = new StringItem ("Lesione", "1. Lascia oggetto negli occhi di sinistro, non rimuoverlo.\n2. Tenere gli occhi immobile al fine di evitare ulteriori danni. Non toccare l\'occhio.\n3. Se occhio \u00E8 il sanguinamento, coprire con un comprimere o una garza sterile.\n4. Raffreddare l\'occhio con un tampone imbevuto di freddo (riduce il gonfiore, sanguinamento si arresta pi\u00F9 veloce).\n5. Chiamata di emergenza o di guidare in ospedale da lei.");aid_fracture = new StringItem ("Frattura", "Sintomi: Innaturale movability posizione e di ossa. Deformazione. Doloroso movimento, sensibile al tocco.\n1. Evitare movimenti!\n2. Chiamata di emergenza.\n3. Immobilizzare l\'osso fratturato, vale a dire rafforzare il materiale osseo intorno ermeticamente. Tenere la posizione del tessuto osseo.\n4. Se la frattura \u00E8 aperta, coprire la ferita sterili.");aid_frostbitemild = new StringItem ("Assideramento mite", "Pallore, gonfiore. Pericolo per la fornitura di sangue.\n1. Portare sinistro in una zona calda.\n2. Uscire dal freddo, togliere i vestiti a freddo, secco persona.\n3. Warm up con acqua tiepida e con il calore del corpo del soccorritore.\n4. Lascia la bevanda calda (t\u00E8). Niente alcool!");aid_frostbitesevere = new StringItem ("Grave assideramento", "Freddo rigido della pelle, grigio-bianco, vesciche, tessuto muore fuori. Pericolo per la fornitura di sangue!\n1. Vai alla zona calda.\n2. Ferita trattamento / copertura.\n3. Dare una bevanda zuccherata.\n4. Non strofinare caldo \u00E8 verificato il sinistro!\n5. Chiamata di emergenza.");aid_heartattack = new StringItem ("Heart Attack", "Pesante, pi\u00F9 di 5 minuti della durata di pressione e il dolore nel petto, in particolare irradia tra le braccia / spalle. Ansia, pallore, sudorazione fredda. Eventualmente, nausea, mancanza di respiro.\n1. Chiamata di emergenza! Sottolineare il presunto attacco di cuore.\n2. Posizionare la parte superiore del corpo elevata. Allentare indumenti stretti. Non somministrare farmaci o bevande.\n3. Talk calmingly alla persona interessata.\n4. Controllo della coscienza e la respirazione.\n5. Dare l\'aspirina, se disponibile.\n6. Se il soggetto si inconscio iniziare con la rianimazione.");aid_hypoglycaemia = new StringItem ("Ipoglicemia (basso zucchero)", "Livello di zucchero nel sangue \u00E8 inferiore al valore minimo (a causa di un sovradosaggio di insulina o non sufficiente assunzione di cibo).\nSintomi: pallore, nervosismo, la fame, brividi, sudore.\n1. Assicurarsi che la persona \u00E8 un diabetico (guardare per un diabetico badge).\n2. Chiamata di emergenza.\n3. Dare una bevanda zuccherata e destrosio / glucosio (se non ci sono problemi nella deglutizione).\n4. Se il soggetto \u00E8 cosciente e la respirazione: Recupero posizione. Monitorare la respirazione della persona. Se appare apnea, con inizio dando respiro.\n5. Se non vi \u00E8 respirazione, \u00E8 possibile mettere un grumo di zucchero in un sacchetto la guancia, spingere al di fuori contro di essa.");aid_hyperthermia = new StringItem ("Ipertermia (caldo corpo)", "Sete, debolezza, disorientamento, nausea, confusione, forte sudorazione, pelle calda.\n1. Chiamata di emergenza.\n2. Trova un luogo fresco ombreggiato (camera con aria condizionata preferibile).\n3. Stabilire persona, elevare il livello delle gambe. Allentare indumenti.\n4. Raffreddare la pelle con molta acqua o laici a freddo asciugamani.\n5. Dare molta acqua o succhi di frutta da bere.");aid_hypothermia = new StringItem ("Ipotermia (aria fresca corpo)", "Brivido freddo, sonnolenza, stanchezza, fino alla perdita di coscienza. Cole pallido pelle. Polso lento, debole battito cardiaco.\n1. Vai a uno spazio caldo / stanza.\n2. Chiamata di emergenza.\n3. Stop impatto del freddo. Aumento della temperatura corporea (copertina e del corpo a corpo a contatto).\n4. Rimuovere i vestiti bagnati e messo in vestiti caldi. Metti nel copre. Coprire la testa.\n5. Dare il t\u00E8 caldo, minestra o acqua calda da bere. Niente alcool! Tenere persona sveglio.\n6. Monitorare il numero delle vittime condizione di emergenza fino a quando arriva medico. Se il soggetto si incoscienza, avviare la rianimazione:\n7. A - L\'incoscienza con la respirazione\n8. B - L\'incoscienza senza respiro");aid_icerescue = new StringItem ("Ice salvataggio", "Prestare attenzione alla propria sicurezza. Pericolo: Drowning, ipotermia.\n1. Salvataggio tramite scala a pioli, bordo o bar. Peso deve essere distribuito diffusa.\n2. Chiedere ad altri per aiutare le persone. Consentitemi di chiamare un ambulanza d\'emergenza.\n3. Scansione attentamente sul tuo ventre (se possibile cordata up) con lo strumento per la violazione.\n4. Mano \u00E8 verificato il sinistro a distanza lo strumento (non la tua mano!) E tirare fuori lui.\n5. Scansione indietro Torna alla Brink.\n6. Misure di pronto soccorso.\n7. Auto-salvataggio possibile: se il ghiaccio \u00E8 solido si pu\u00F2 distribuire il suo peso sul ghiaccio e tirare fuori te. Scansione piatto sul tuo ventre al baratro. Se il ghiaccio \u00E8 fragile, provare a rompere il ghiaccio pezzo per pezzo fino al baratro.");aid_insectstings = new StringItem ("Morsi di insetto", "Gonfiore, rash cutaneo, sensazione di bruciore, debolezza, difficolt\u00E0 respiratoria, riduzione della coscienza, tachicardia.\n1. Rimuovere attentamente Stringer (con un tweezer). Non strizzare la stinger in quanto ci\u00F2 potrebbe iniettare pi\u00F9 veleno.\n2. Cool posto in questione (si applica a freddo comprimere).\n3. Zona in questione dovrebbero essere tenuti inferiore al cuore di rallentare la circolazione del veleno.\n4. Se cucire in bocca-mascella-zona: Suck gelati, e applicare un freddo comprimere nei pressi di gola.\n5. Se si verificano gravi problemi chiamare un\'ambulanza.");aid_nosebleeding = new StringItem ("Nosebleeding", "Bursted piccola arteria di punta del naso.\n1. Siediti sanguinamento persona, magra leggermente in avanti. Tenere testa diritta.\n2. Non posizionare la persona piatta, in qualit\u00E0 di capo oltre l\'altezza del cuore rallenta il sanguinamento.\n3. Fredda collo busta.\n4. Pizzico narici insieme fino a quando si arresta il sanguinamento (per 10 min).\n5. Successivamente non ceppo il naso (non snorting).\n6. Se si verificano gravi problemi di sanguinamento o non pu\u00F2 essere arrestato, chiamata di emergenza medico.");aid_poisining = new StringItem ("Avvelenamento", "Confusione, allucinazioni, grandi allievi, febbre, crampi. Incoscienza.\n1. Antidoti solo se sono accompagnati da un medico addestrato.\n2. Non somministrare bevande. Non provocare il vomito.\n3. Chiamata di emergenza sottolineare l\'avvelenamento!\n4. Salvaguardia resti di veleno e il vomito!\n5. Se il sinistro \u00E8 cosciente e la respirazione: Recupero posizione. Monitor condizione di emergenza fino a quando arriva medico.\n6. Se il sinistro non \u00E8 la respirazione: iniziare immediatamente con la rianimazione! Libera bocca da vomitare prima.");aid_recoveryposition = new StringItem ("Di recupero posizione", "1. Lay sinistro per il suo / la sua schiena, raddrizzare le gambe. Ginocchio in gi\u00F9 accanto.\n2. Luogo braccio pi\u00F9 vicino a voi in un angolo destro al corpo.\n3. Tirare il braccio pi\u00F9 lontano da te in tutto il torace e il luogo del dorso della mano contro la guancia.\n4. Aggiudicati la misura ginocchio, tirare al vostro fianco, e laici che sul terreno. Posizione la gamba destra in un angolo. Tenere sinistro la mano sulla guancia della persona.\n5. Assicurarsi che le vie aeree sono libere.\n6. Aprire leggermente la bocca, e la posizione della testa in questo modo che pu\u00F2 esaurire vomito. Controllare la respirazione.\n7. Controllo sinistro della condizione di emergenza fino a quando il medico arriva.");aid_resuscitation = new StringItem ("Rianimazione", "# Cuore Massaggi\n1. Lay sinistro sulla schiena. Inginocchiarsi accanto a persona.\n2. Nudo il petto.\n3. Luogo balla una mano al centro del torace (poco pi\u00F9 di sterno).\n4. Luogo altro canto balla sul dorso della mano che \u00E8 gi\u00E0 in posizione.\n5. Estrusione le braccia e gomiti.\n6. Premere 5 cm di profondit\u00E0 nella persona del torace (potenza proviene da parte superiore del corpo) e liberazione.\n7. Push-30 volte in una riga breve e fortemente!\n\n# Di respirazione\n1. Tratto in testa al collo. Rimuovere le sostanze di bocca e della gola.\n2. Spingere le ali del naso insieme, in modo che il naso \u00E8 chiuso.\n3. Fai un respiro profondo e metti la tua bocca sulla bocca del sinistro, che non pu\u00F2 perdite d\'aria.\n4. Non bocca-a-bocca-respirazione due volte (soffio fuori lentamente e completamente).\n5. Successivamente, fare di nuovo centro massaggi.\n\nRipetere il cuore massaggio respirazione bocca-emergenza fino a quando il medico arriva.");aid_safeguardaccident = new StringItem ("Di salvaguardia degli incidenti", "1. Stop tua auto 50-100 m dietro l\'incidente sito (se siete su una strada o di un paese su strada). Accendere le luci di avvertimento. Immessi sul giubbotto ad alta visibilit\u00E0.\n2. Posizionare il triangolo di avvertimento prima che l\'incidente sito. Attenzione: Se incidente si trova in una posizione curva triangolo di avvertimento prima della curva!\n3. Chiedete altre persone per il loro aiuto.\n4. Apri la porta di incidente auto (se uptight, prize aperta utilizzando una macchina jack). Spegnere accensione.\n5. Soccorso alle vittime di un sinistro: Unstrap cintura di sicurezza, spostare indietro sedile. Libera il sinistro fuori dalla macchina da presa di salvataggio.\n6. Chiamata di emergenza.\n7. Procedere con misure di pronto soccorso.");aid_shock = new StringItem ("Shock", "Disturbi circolatori da poveri di ossigeno nel corpo.\nCausa: perdita di liquido, ridotto volume di sangue.\nSintomi: pallore, pelle fredda, sudorazione fredda, ansia.\n1. Eliminare la causa di shock (ad esempio, interrompere la perdita di liquidi, impegnare la ferita)!\n2. Lay i feriti su una coperta, la posizione delle gambe fino. Calma la persona.\n3. Chiamata di emergenza.\n4. Se difficolt\u00E0 nella respirazione o coscienza, avviare la rianimazione.");aid_skullfracture = new StringItem ("La frattura Cranio\'", "Luce di sanguinamenti del naso, della bocca o orecchio. Spesso ferite aperte al cranio.\n1. Mantenere le vie aeree libera.\n2. Se cosciente: Lasciate che i feriti sedersi con testa piegato in avanti. Evitare ulteriori movimenti!\n3. Se inconscio: Recupero posizione (nessuna pressione sulla ferita di testa).\n4. Chiamata di emergenza.\n5. Applica testa bendaggio.\n6. Se difficolt\u00E0 nella respirazione o coscienza, avviare la rianimazione.");aid_snakebite = new StringItem ("Snakebite", "Punctuate ferita nella dimensione di un pin, gravi dolori, gonfiore, colore viola. Disturbo circolatorio, il pericolo di scossa.\n1. Costante i feriti parte del corpo.\n2. Applica freddo buste circa morso ferita.\n3. Misure contro la folgorazione.\n4. Chiamata di emergenza.");aid_sos = new StringItem ("SOS", "1. Signal: 3x breve, 3x lungo, 3x breve.\n2. Otticamente (luce strobo, torcia elettrica), o acusticamente (segnale di fischietto, bussare).");aid_sprain = new StringItem ("Distorsione di tensione", "Dolore, gonfiore (lividi), perdita di funzione, la deformazione della parte.\n1. Costante la parte lesa del corpo solo nella posizione pi\u00F9 comoda per il sinistro.\n2. Cool (con ghiaccio).\n3. Se possibile, la posizione di parte lesa elevata.\n4. Andare in ospedale o chiamare il medico di emergenza.");aid_stroke = new StringItem ("Corsa", "Improvvisa sensazione di intorpidimento o paralisi (viso, braccia, gambe), disordini in lingua comprensione, la visione dei problemi, turbato la coscienza, forte mal di testa. Problemi di respirazione e la deglutizione, perdita di controllo su di vescica e intestino.\n1. Chiamata di emergenza!\n2. Allentare indumenti stretti, non danno farmaci o bevande.\n3. Sit o fissare comodamente persona interessata. Calma lui / lei!\n4. Controllo della coscienza e la respirazione.\n5. Se difficolt\u00E0 nella respirazione o coscienza, avviare la rianimazione.");aid_suffocation = new StringItem ("Soffocamento", "Insufficiente di ossigeno. Trachea chiusa. Pericolo: apnea.\nSintomi: sibilo respiratorio rumore, stimolo della tosse, mancanza di respiro, macchie sulla pelle.\n1. Un\'azione immediata! Lasciate che la persona interessata tosse molto forte.\n2. Strike fortemente con un piatto a mano sul retro tra le scapole (laici neonati sul tuo avambraccio, con testa in gi\u00F9).\n3. Se senza successo: Stand dietro persona, di armi nei pressi di vita, inchinarsi leggermente in avanti.\n4. Stringere il tuo pugno, in posizione di altezza della persona stomaco, e portarlo con l\'altra mano.\n5. In abbraccio utilizzare entrambe le mani per dare un duro colpo allo stomaco direzione verso l\'alto (come si tenta di sollevare la persona).\n6. Ripetere questa operazione fino a 5 volte! Airways dovrebbe ottenere gratuitamente da oggetto.\n7. Chiamata di emergenza.\n8. Se la prima misura di aiuto non riesce a mantenere farlo fino a quando arriva medico di emergenza.");aid_sunburn = new StringItem ("Eritema solare", "1. Rimuovere la persona interessata dalla luce diretta del sole. Evitare ulteriori sole.\n2. Bere molta acqua per impedire la disidratazione.\n3. Se vi \u00E8 un grave bruciare domenica (blister, arrossamento, dolore), consultare un medico.\n4. Se la pelle \u00E8 solo leggermente rosso, pu\u00F2 essere raffreddato con buste umido. Utilizzare dopo domenica lozione o gel.");aid_sunstroke = new StringItem ("Sunstroke", "Rosso testa calda, raffreddare la pelle, la malattia, mal di testa, vertigini. Causa: irritazione della membrana cerebrale.\n1. Vai a un luogo fresco (ombra) e la posizione della parte superiore del corpo della persona.\n2. Cool con la testa bagnata coperte.\n3. Chiamata di emergenza, a mantenere il controllo della respirazione.\n4. Se cosciente: bere Lascia raffreddare, se applicabili.\n5. Se appare apnea, inizia con la respirazione:\n6. Vai con Breath Dare!");aid_unconsciouswithbreath = new StringItem ("Incoscienza con la respirazione", "Nessuna reazione a chiedere a gran voce, nessuna risposta a scuotimento. Respirazione non esiste.\n1. Se ci sono persone accanto a voi per chiedere aiuto.\n2. Recupero posizione. Apri la bocca e la posizione di testa in questo modo che pu\u00F2 esaurire vomito.\n3. Chiamata di emergenza.");aid_unconsciouswithoutbreath = new StringItem ("Incoscienza senza respiro", "1. Nessuna reazione di sinistro, non respira.\n\nAvviare la rianimazione.");aid_vomiting = new StringItem ("Vomito", "Nasce dalla nausea. Stomaco si svuota. Cause: infezione, avvelenamento, ulcera, la droga, la cattiva alimentazione, la gravidanza.\n1. Pericolo per la circolazione a causa della disidratazione e perdita di sale!\n2. Dare liquidi (t\u00E8, acqua).\n3. Se vi sono forti disturbi, sanguinosa continuo vomito o chiamare il medico di emergenza.");
			separator = new StringItem ("Separator", "-");					stringItemArray = new StringItem[] {
							aid_disclaimer, separator, aid_general, aid_allergic, aid_amputation, aid_animalbite, aid_apnoea, aid_asthma, aid_backinjury, aid_birth, aid_bleedinglight, aid_bleedingsevere, aid_brainconcussion, aid_apnoea, aid_asthma, aid_burningslight, aid_burningsevere, aid_checkbreathing, aid_chemicalburneyes, aid_chemicalburn, aid_resuscitation, aid_dangerzone, aid_diabeticcoma, aid_diarrhoea, aid_drowning, aid_electricityaccident, aid_emergencycall, aid_epilepsy, aid_eyeinjury, aid_fracture, aid_frostbitemild, aid_frostbitesevere, aid_heartattack, aid_diabeticcoma, aid_hypoglycaemia, aid_hyperthermia, aid_hypothermia, aid_icerescue, aid_insectstings, aid_nosebleeding, aid_poisining, aid_resuscitation, aid_recoveryposition, aid_resuscitation, aid_safeguardaccident, aid_shock, aid_skullfracture, aid_snakebite, aid_sos, aid_backinjury, aid_sprain, aid_stroke, aid_suffocation, aid_sunburn, aid_sunstroke, aid_suffocation, aid_safeguardaccident, aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_vomiting, separator}; 

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
		else if (auswahl==6 || auswahl==13) { details.append(aid067);
						  details.append(""); details.append(aid010);
						  details.append(""); details.append(aid011); }
		// img:backinjury
		else if (auswahl==8 || auswahl==49) { details.append(aid065); }
		// img:birth
		else if (auswahl==9) { details.append(aid025);
								details.append(""); details.append(aid022); 
								details.append(""); details.append(aid023); }
		// img:chemicalburneyes
		else if (auswahl==18) { details.append(aid019); }
		// img:bleedinglight
		else if (auswahl==10) { details.append(aid084);
							    details.append(""); details.append(aid085); }
		// img:bleedingsevere
		else if (auswahl==11) { details.append(aid084);
							    details.append(""); details.append(aid085);
							    details.append(""); details.append(aid089);
							    details.append(""); details.append(aid092); }
		// img:brainconcussion
		else if (auswahl==12) { details.append(aid061); }
		// img:dangerzone
		else if (auswahl==21) { details.append(aid001); }
		// img:drowning
		else if (auswahl==24) { details.append(aid034); }
		// img:electricityaccident
		else if (auswahl==25) { details.append(aid045); }
		// img:epilepsy
		else if (auswahl==27) { details.append(aid058); }
		// img:fracture
		else if (auswahl==29) { details.append(aid107); }
		// img:heartattack
		else if (auswahl==32) { details.append(aid061); }
		// img:icerescue
		else if (auswahl==37) { details.append(aid041); }
		// img:recoveryposition
		else if (auswahl==42) { details.append(aid008); 
							  details.append(""); details.append(aid009); 
							  details.append("\nRecovery position for babies:"); details.append(aid028); }
		// img:resuscitation
		else if (auswahl==20 || auswahl==41 || auswahl==43) { 
							  details.append(aid013);
							  details.append(""); details.append(aid003); 
							  details.append(""); details.append(aid067); 
							  details.append(""); details.append(aid010); 
							  details.append(""); details.append(aid011); 
							  details.append(""); details.append(aid012);
							  details.append("\n\n# Resuscitation (Baby)\n\nOnly use two fingers:"); details.append(aid029); 
							  details.append("\nDo not breath too strong:"); details.append(aid030); }
		// img:safeguardaccident
		else if (auswahl==44 || auswahl==56) { details.append(aid001); }
		// img:suffocation
		else if (auswahl==52 || auswahl==55) { details.append(aid031); 
							  details.append(""); details.append(aid069); }
		// img:sunstroke
		else if (auswahl==54) { details.append(aid061); }
		// img: unconsciouswithbreath
		else if (auswahl==57) { details.append(aid008); 
							  details.append(""); details.append(aid009); }
		
		// spacer below
		details.append("");

		// append Resuscitation measures!
		// for unconsciouswithoutbreath / drowning / heartattack / brainconcussion / stroke / shock / poisining
		if (auswahl==58 || auswahl==24 || auswahl==32 || auswahl==12 || auswahl==51 || auswahl==45 || auswahl==40) { 
			details.append(aid_resuscitation);
			  details.append(aid013);
			  details.append(""); details.append(aid003);  details.append(""); details.append(aid067); 
			  details.append(""); details.append(aid010);  details.append(""); details.append(aid011); 
			  details.append(""); details.append(aid012);
		}
		// for electricity / hypothermia
		else if (auswahl==25 || auswahl==36) { 
			details.append(aid_unconsciouswithbreath); 
			details.append("");
			details.append(aid_unconsciouswithoutbreath); 
			details.append("");
			details.append(aid_resuscitation); 
			  details.append(""); details.append(aid003);   details.append(""); details.append(aid067); 
			  details.append(""); details.append(aid010);   details.append(""); details.append(aid011); 
		} // for sunstroke / asthma / hypoglycaemia
		else if (auswahl==54 || auswahl==7 || auswahl==34) { 
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
