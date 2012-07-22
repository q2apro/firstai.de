/* 
 * Project: www.Firstai.de
 * 
 * File: FirstAid3.java
 * Version: j3.0 Audio
 * Download: http://www.firstai.de/english/download-j2me.html
 * 
 * Language: Java Platform Micro Edition (J2ME)
 * 
 * Author: Kai Kajus Noack
 * Date: 2008-12-24
 * 
 * License Source Code: GNU General Public License (GPL)
 * http://www.gnu.org/licenses/gpl.html
 * 
 * License First Aid Texts (Strings): Creative Commons 3.0 BY_NC_ND
 * http://creativecommons.org/licenses/by-nc-nd/3.0/de/deed.en
 * 
 */

package de.firstai;

// imports
import java.io.*;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
// import j2me polish (GPL)
import de.enough.polish.ui.UiAccess;


public class FirstAid3 extends MIDlet implements CommandListener {

	boolean started = false;
	Form details;
	Display display;
	List menu;
	List telEmergency;
	int globalchoice=0;

	static Player myPlayer;
	// spec: http://java.sun.com/javame/reference/apis/jsr135/javax/microedition/media/Player.html

	// setup of the navigation buttons
	static final Command cmdBack = new Command("Back", Command.BACK, 2);
	static final Command cmdExit = new Command("Exit", Command.EXIT, 2);
	static final Command cmdPlay = new Command("Play", Command.ITEM, 2); // 2 - priority to other elements

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

		this.menu = new List("First Aid 3.0", Choice.IMPLICIT);
		this.menu.append("# Disclaimer + Info", null);
		this.menu.append("# Emergency Calls", null);
		this.menu.append("# General Conduct", null);
		this.menu.append("Allergic Reaction", null);
		this.menu.append("Amputation", null);
		this.menu.append("Animal bite", null);
		this.menu.append("Apnoea", null);
		this.menu.append("Asthma", null);
		this.menu.append("Back Injury", null);
		this.menu.append("Birth", null);
		this.menu.append("Bleeding (light)", null);
		this.menu.append("Bleeding (severe)", null);
		this.menu.append("Brain Concussion", null);
		this.menu.append("Breathing", null);
		this.menu.append("Breathlessness", null);
		this.menu.append("Burning (slight)", null);
		this.menu.append("Burning (severe)", null);
		this.menu.append("Check Breathing", null);
		this.menu.append("Chemical Burn (Eyes)", null);
		this.menu.append("Chemical Burn", null);
		this.menu.append("Chest Compression", null);
		this.menu.append("Danger Zone (Rescue)", null);
		this.menu.append("Diabetic Coma", null);
		this.menu.append("Diarrhoea", null);
		this.menu.append("Drowning", null);
		this.menu.append("Electricity Accident", null);
		this.menu.append("Emergency Call", null);
		this.menu.append("Epilepsy", null);
		this.menu.append("Eye Injury", null);
		this.menu.append("Fracture", null);
		this.menu.append("Frostbite (mild)", null);
		this.menu.append("Frostbite (severe)", null);
		this.menu.append("Heart Attack", null);
		this.menu.append("Hyperglycaemia (sugar)", null);
		this.menu.append("Hypoglycaemia (low sugar)", null);
		this.menu.append("Hyperthermia (hot body)", null);
		this.menu.append("Hypothermia (cool body)", null);
		this.menu.append("Ice Rescue", null);
		this.menu.append("Insect stings", null);
		this.menu.append("Nosebleeding", null);
		this.menu.append("Poisoning", null);
		this.menu.append("Reanimation", null);
		this.menu.append("Recovery Position", null);
		this.menu.append("Resuscitation", null);
		this.menu.append("Safeguard Accident", null);
		this.menu.append("Shock", null);
		this.menu.append("Skull fracture", null);
		this.menu.append("Snakebite", null);
		this.menu.append("SOS", null);
		this.menu.append("Spinal fracture", null);
		this.menu.append("Sprain + Strain", null);
		this.menu.append("Stroke", null);
		this.menu.append("Suffocation (Choking)", null);
		this.menu.append("Sunburn", null);
		this.menu.append("Sunstroke", null);
		this.menu.append("Swallow/Choking", null);
		this.menu.append("Traffic Accident", null);
		this.menu.append("Unconsciousness with breathing", null);
		this.menu.append("Unconsciousness without breathing", null);
		this.menu.append("Vomiting", null);
		this.menu.append("-------------", null); // 60
		this.menu.append("Call Emergency 112", null); // 61

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
			stringAfrica = new StringItem("- Africa -", "\n# Algeria\nFire:14 | Pol:17 | Med:17\n\n# Angola\nFire:118 | Pol:110 | Med:118\n\n# Benin\nFire:18 | Pol:17 | Med:301769\n\n# Botswana\nFire:998 | Pol:999 | Med:997\n\n# Burkina Faso\nFire:18 | Pol:17 | Med:local numbers\n\n# Burundi\nFire:no system | Pol:no system | Med:no system\n\n# Cameroon\nFire:18 | Pol:17 | Med:local numbers\n\n# Cape Verde\nFire:131 | Pol:132 | Med:130\n\n# Central African Republic\nFire:118 | Pol:611253 | Med:610600\n\n# Chad\nFire:18 | Pol:17 | Med:local numbers\n\n# Comoros\nFire:only radio telephones | Pol:only radio telephones | Med:only radio telephones\n\n# Congo (Democratic Republic)\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Congo (Republic)\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Djibouti\nFire:18 | Pol:17 | Med:351351\n\n# Egypt\nFire:180 | Pol:122 | Med:123\n\n# Equatorial Guinea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Eritrea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Ethiopia\nFire:93 | Pol:91 | Med:92\n\n# Gabon\nFire:18 | Pol:1730 | Med:1300\n\n# Gambia\nFire:118 | Pol:117 | Med:116\n\n# Ghana\nFire:192 | Pol:191 | Med:193\n\n# Guinea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Guinea-Bissau\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Ivory Coast\nFire:180 | Pol:110 | Med:110\n\n# Kenya\nFire:999 | Pol:999 | Med:999\n\n# Lesotho\nFire:122 | Pol:123 | Med:121\n\n# Liberia\nFire:911 | Pol:911 | Med:911\n\n# Libya\nFire:193 | Pol:193 | Med:193\n\n# Madagascar\nFire:18 | Pol:117 | Med:2262566\n\n# Malawi\nFire:199 | Pol:199 | Med:199\n\n# Mali\nFire:18 | Pol:17 | Med:15\n\n# Mauritania\nFire:118 | Pol:117 | Med:local numbers\n\n# Mauritius\nFire:999 | Pol:999 | Med:999\n\n# Mayotte\nFire:603054 | Pol:112 | Med:15\n\n# Morocco\nFire:15 | Pol:19 | Med:15\n\n# Mozambique\nFire:198 | Pol:119 | Med:117\n\n# Namibia\nFire:2032270 | Pol:1011 | Med:2032276\n\n# Niger\nFire:18 | Pol:17 | Med:723141\n\n# Nigeria\nFire:190 | Pol:119 | Med:199\n\n# Rï¿½union\nFire:18 or 112 mobile | Pol:17 or 112 mobile | Med:15 or 112 mobile\n\n# Rwanda\nFire:local numbers | Pol:112 | Med:local numbers\n\n# Sahrawi Arab Democratic Republic\nFire:-- | Pol:-- | Med:--\n\n# Sao Tomï¿½ and Principe\nFire:-- | Pol:-- | Med:--\n\n# Senegal\nFire:local numbers | Pol:local numbers | Med:8891515\n\n# Seychelles\nFire:999 | Pol:999 | Med:999\n\n# Sierra Leone\nFire:999 | Pol:999 | Med:999\n\n# Somalia\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# South Africa\nFire:10111 | Pol:10111 | Med:10177\n\n# Sudan\nFire:999 | Pol:999 | Med:local numbers\n\n# Swaziland\nFire:local numbers | Pol:999 | Med:6060911\n\n# Tanzania\nFire:112 | Pol:112 | Med:112\n\n# Togo\nFire:118 | Pol:101 | Med:191\n\n# Tunisia\nFire:198 | Pol:197 | Med:190\n\n# Uganda\nFire:999 or 111 mobile | Pol:999 or 111 mobile | Med:999 or 111 mobile\n\n# Zambia\nFire:993 or 112 mobile | Pol:999 or 112 mobile | Med:991 or 112 mobile\n\n# Zimbabwe\nFire:993 | Pol:995 | Med:994");
			stringAsia = new StringItem("- Asia -", "\n# Afghanistan\nFire:-- | Pol:-- | Med:112\n\n# Armenia\nFire:101 | Pol:102 | Med:103\n\n# Azerbaijan\nFire:101 | Pol:102 | Med:103\n\n# Bahrain\nFire:999 | Pol:999 | Med:999\n\n# Bangladesh\nFire:9555555 | Pol:8665513 | Med:199\n\n# Bhutan\nFire:113 | Pol:110 | Med:112\n\n# Brunei\nFire:995 | Pol:993 | Med:991\n\n# Cambodia\nFire:118 | Pol:117 | Med:199\n\n# China\nFire:119 | Pol:110 | Med:120\n\n# East Timor\nFire:-- | Pol:112 | Med:7233212\n\n# Georgia\nFire:022 | Pol:022 | Med:022\n\n# Hong Kong\nFire:999 | Pol:999 | Med:999\n\n# India\nFire:101 | Pol:100 | Med:102\n\n# Indonesia\nFire:113 | Pol:110 | Med:118\n\n# Iran\nFire:125 or 112 mobile | Pol:110 or 112 mobile | Med:115 or 112 mobile\n\n# Iraq\nFire:no system | Pol:no system | Med:no system\n\n# Israel\nFire:102 | Pol:100 | Med:101\n\n# Japan\nFire:119 | Pol:110 | Med:119\n\n# Jordan\nFire:193 | Pol:192 | Med:193\n\n# Kazakhstan\nFire:03 | Pol:03 | Med:03\n\n# Kurdistan\nFire:125 | Pol:129 | Med:115\n\n# Kuwait\nFire:777 | Pol:777 | Med:777\n\n# Kyrgyzstan\nFire:03 | Pol:133 | Med:03\n\n# Laos\nFire:local numbers | Pol:local numbers | Med:03\n\n# Lebanon\nFire:175 | Pol:112 | Med:140\n\n# Macau\nFire:999 | Pol:999 | Med:999\n\n# Malaysia\nFire:999 or 112 mobile | Pol:999 or 112 mobile | Med:999 or 112 mobile\n\n# Maldives\nFire:118 | Pol:119 | Med:102\n\n# Mongolia\nFire:101 | Pol:102 | Med:103\n\n# Myanmar\nFire:199 | Pol:199 | Med:199\n\n# Nepal\nFire:101 | Pol:100 | Med:228094\n\n# North Korea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Oman\nFire:999 | Pol:999 | Med:999\n\n# Pakistan\nFire:16 | Pol:15 | Med:115\n\n# Philippines\nFire:117 | Pol:117 | Med:117\n\n# Qatar\nFire:999 | Pol:999 | Med:999\n\n# Saudi Arabia\nFire:998 | Pol:999 | Med:997\n\n# Singapore\nFire:995 | Pol:999 | Med:995\n\n# South Korea (Republic Korea)\nFire:119 | Pol:112 | Med:119\n\n# Sri Lanka\nFire:111 | Pol:119 or 112 mobile | Med:110\n\n# Syria\nFire:113 | Pol:112 | Med:110\n\n# Taiwan\nFire:119 | Pol:110 | Med:119\n\n# Tajikistan\nFire:local numbers | Pol:02 | Med:03\n\n# Thailand\nFire:199 | Pol:191 or 1155 (tourists) | Med:191\n\n# Turkmenistan\nFire:03 | Pol:03 | Med:03\n\n# United Arab Emirates\nFire:997 | Pol:999 | Med:998\n\n# Uzbekistan\nFire:03 | Pol:03 | Med:03\n\n# Vietnam\nFire:114 | Pol:113 | Med:115\n\n# Yemen\nFire:199 | Pol:199 | Med:199");
			stringEurope = new StringItem("- Europe -", "\n# Albania\nFire:18 | Pol:19 | Med:17\n\n# Andorra\nFire:118 | Pol:110 | Med:118\n\n# Austria\nFire:112 | Pol:112 | Med:112\n\n# Belarus\nFire:01 | Pol:02 | Med:03\n\n# Belgium\nFire:112 | Pol:112 | Med:112\n\n# Bosnia and Herzegovina\nFire:123 | Pol:122 | Med:124\n\n# Bulgaria\nFire:112 | Pol:112 | Med:112\n\n# Croatia\nFire:93 | Pol:92 | Med:94\n\n# Cyprus\nFire:112 | Pol:112 | Med:112\n\n# Czech Republic\nFire:112 | Pol:112 | Med:112\n\n# Denmark\nFire:112 | Pol:112 | Med:112\n\n# Estonia\nFire:112 | Pol:112 | Med:112\n\n# Finland\nFire:112 | Pol:112 | Med:112\n\n# France\nFire:18 or 112 | Pol:17 or 112 | Med:15 or 112\n\n# Germany\nFire:112 | Pol:110 | Med:112\n\n# Greece\nFire:112 | Pol:112 | Med:112\n\n# Hungary\nFire:112 | Pol:112 | Med:112\n\n# Iceland\nFire:112 | Pol:112 | Med:112\n\n# Ireland\nFire:112 | Pol:112 | Med:112\n\n# Italy\nFire:112 | Pol:112 | Med:112\n\n# Kosovo\nFire:911 | Pol:911 | Med:911\n\n# Latvia\nFire:112 | Pol:112 | Med:112\n\n# Liechtenstein\nFire:112 | Pol:112 | Med:112\n\n# Lithuania\nFire:112 | Pol:112 | Med:112\n\n# Luxembourg\nFire:112 | Pol:112 | Med:112\n\n# Macedonia\nFire:112 | Pol:112 | Med:112\n\n# Malta\nFire:112 | Pol:112 | Med:112\n\n# Moldova\nFire:901 | Pol:902 | Med:903\n\n# Monaco\nFire:112 | Pol:112 | Med:112\n\n# Montenegro\nFire:112 | Pol:112 | Med:112\n\n# Netherlands\nFire:112 | Pol:112 | Med:112\n\n# Norway\nFire:110 | Pol:112 | Med:113\n\n# Poland\nFire:112 | Pol:112 | Med:112\n\n# Portugal\nFire:112 | Pol:112 | Med:112\n\n# RepublicofIreland\nFire:112 | Pol:112 | Med:112\n\n# Romania\nFire:112 | Pol:112 | Med:112\n\n# Russia\nFire:01 | Pol:02 | Med:03\n\n# San Marino\nFire:116 | Pol:112 | Med:113\n\n# Serbia\nFire:112 | Pol:112 | Med:112\n\n# Slovakia\nFire:112 | Pol:112 | Med:112\n\n# Slovenia\nFire:112 | Pol:113 | Med:112\n\n# Spain\nFire:112 | Pol:112 | Med:112\n\n# Sweden\nFire:112 | Pol:112 | Med:112\n\n# Switzerland\nFire:118 or 112 | Pol:117 or 112 | Med:144 or 112\n\n# Turkey\nFire:110 | Pol:155 | Med:112\n\n# Ukraine\nFire:112 | Pol:112 | Med:112\n\n# United Kingdom\nFire:112 | Pol:112 | Med:112\n\n# Vatican City\nFire:115 | Pol:112 | Med:113");
			stringNorthamerica = new StringItem("- North-/Central America -", "\n# United States of America\nFire:911 | Pol:911 | Med:911\n\n# Antigua and Barbuda\nFire:911 | Pol:911 | Med:911\n\n# Bahamas\nFire:911 | Pol:911 | Med:911\n\n# Barbados\nFire:113 | Pol:112 | Med:115\n\n# Belize\nFire:911 | Pol:911 | Med:911\n\n# Canada\nFire:911 | Pol:911 | Med:911\n\n# Cayman Islands\nFire:911 | Pol:911 | Med:911\n\n# Costa Rica\nFire:911 | Pol:911 | Med:911\n\n# Cuba\nFire:26811 | Pol:26811 | Med:26811\n\n# Dominica\nFire:999 | Pol:999 | Med:999\n\n# Dominican Republic\nFire:911 | Pol:911 | Med:911\n\n# El Salvador\nFire:911 | Pol:911 | Med:911\n\n# Greenland\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Grenada\nFire:911 | Pol:112 | Med:911\n\n# Guatemala\nFire:122 | Pol:110 | Med:123\n\n# Haiti\nFire:local numbers | Pol:114 | Med:118\n\n# Honduras\nFire:198 | Pol:119 | Med:378654\n\n# Jamaica\nFire:110 | Pol:119 | Med:110\n\n# Mexico\nFire:060 | Pol:080 | Med:060\n\n# Nicaragua\nFire:2650162 | Pol:118 | Med:2651761\n\n# Panama\nFire:103 | Pol:104 | Med:2699778\n\n# Saint Kitts and Nevis\nFire:911 | Pol:911 | Med:911\n\n# Saint Lucia\nFire:911 | Pol:999 | Med:911\n\n# Saint Pierre and Miquelon\nFire:18 | Pol:17 | Med:15\n\n# Saint Vincent and Grenadines\nFire:911 | Pol:911 | Med:911\n\n# Trinidad and Tobago\nFire:990 | Pol:999 | Med:990");
			stringOceania = new StringItem("- Oceania -", "\n# Australia\nFire:000 or 112 mobile | Pol:000 or 112 mobile | Med:000 or 112 mobile\n\n# Fiji\nFire:9170 | Pol:911 | Med:911\n\n# Kiribati\nFire:local numbers | Pol:local numbers | Med:994\n\n# Marshall Islands\nFire:local numbers | Pol:6258666 | Med:6254111 \n\n# Micronesia\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Nauru\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# New Zealand\nFire:111 | Pol:111 | Med:111\n\n# Palau\nFire:911 | Pol:911 | Med:911\n\n# Papua New Guinea\nFire:110 | Pol:000 | Med:local numbers\n\n# Samoa\nFire:994 | Pol:995 | Med:996\n\n# Solomon Islands\nFire:911 | Pol:911 | Med:911\n\n# Tonga\nFire:999 | Pol:922 | Med:933\n\n# Tuvalu\nFire:911 | Pol:911 | Med:911\n\n# Vanuatu\nFire:112 | Pol:112 | Med:112");
			stringSouthamerica = new StringItem("- South America -", "\n# Argentina\nFire:100 | Pol:101 | Med:107\n\n# Bolivia\nFire:911 | Pol:911 | Med:911\n\n# Brazil\nFire:193 | Pol:190 | Med:192\n\n# Chile\nFire:132 | Pol:133 | Med:131\n\n# Colombia\nFire:119 | Pol:119 | Med:119\n\n# Ecuador\nFire:102 | Pol:101 | Med:131\n\n# Guyana\nFire:912 | Pol:911 | Med:913\n\n# Paraguay\nFire:911 | Pol:911 | Med:911\n\n# Peru\nFire:116 | Pol:105 | Med:116\n\n# Suriname\nFire:115 | Pol:115 | Med:115\n\n# Uruguay\nFire:911 | Pol:911 | Med:911\n\n# Venezuela\nFire:171 | Pol:171 | Med:171");

			// First-Aid-Text
			aid_disclaimer = new StringItem ("Disclaimer + Info", "1. Software\nFirst Aid on your Mobile\nVersion: j3.0\nRelease: 2008-12-24\nCopyright: Kai Kajus Noack\nLicence: Creative Commons BY-NC-ND\n\nFirst Aid Illustrations © Med4Teens\n\nThis program is supposed to give information on first aid. However, it does not represent a substitute to a first aid course. It rather serves you refreshing your already acquired knowledge.\n\n2. Disclaimer\nPlease note that I take no responsibility for consequences resulting from the use of the software.\nANY LIABILITY IS EXCLUDED!\nUSE AT YOUR OWN RISK!\n\nIn all emergencies, please seek professional help immediately.\n\n3. Project Development\nThe program is supposed to become multilingual. Voluntary Translators needed!!\n\nFurther information is available on the Internet www.firstai.de or write an email to: info AT firstai.de\n\nTo save one life is to have saved the world.");aid_general = new StringItem ("General Conduct", "1. Always perform first aid. You cannot make any mistakes.\n2. Always pay attention to your own safety.\n3. Examine the situation and secure the accident place.\n4. Emergency call + First Aid measures!\n5. If there are several casualties, the treatment of the most harmed has priority.\n6. Always try to calm down the person concerned. Stay calm yourself!\n7. If possible lay her/him down comfortably. Never give alcohol, nicotine or drugs to a person who is the victim of an accident.");aid_allergic = new StringItem ("Allergic Reaction", "1. Phone for an ambulance immediately.\n2. Try to calm down the casualty and let him sit comfortable.\n3. Remove allergic causing matter (e.g. sting of a bee) carefully.\n4. Cool affected skin (wet compress, ice).\n5. If casualty has an antidote, he should use it (help him).\n6. Monitor casualty's condition until ambulance arrives.\n7. If casualty loses consciousness or breathing stops, follow appropriate instructions!");aid_animalbite = new StringItem ("Animal bite", "Attention: High danger of infection. Result could be infection, tetanus, rabies.\n1. Wash wound with hot soapy water.\n2. Afterwards disinfect the wound.\n3. If there is severe bleeding, elevate the person's upper body.\n4. Apply an aseptic bandage.\n5. Go to a hospital or call emergency doctor.");aid_apnoea = new StringItem ("Apnoea", "No breathing sounds or breath movements, noticeable discolouration of the skin.\n1. Emergency call.\n2. Lay casualty on his/her back.\n3. Remove any substances from the mouth and throat. Stretch head backwards.\n4. Pinch the nose, so that nose is closed.\n5. Take a deep breath and put your mouth onto the mouth of the casualty, that no air can leak.\n6. Breath out slowly and fully.\n7. If without success: Do breathing as long as ambulance arrives.");aid_asthma = new StringItem ("Asthma", "Heavy breathlessness. Wheezing respiratory noise. Anxieties.\n1. Calm the person. Stay calm yourself!\n2. Loosen clothing.\n3. Let casualty sit and lean forward, encourage him/her to breath slowly and deeply.\n4. If casualty has an inhalator, he should use it (help him). After 5-10 min it should take effect.\n5. If there is no improvement: Use inhalator every 5 min until ambulance arrives.\n6. Emergency call.\n7. If apnoea (cessation of breathing) occurs, follow instructions given for apnoea.");aid_backinjury = new StringItem ("Back Injury", "Pain in the back, numb arms and legs.\n1. Do not move the casualty!!\n2. Hold the head so that the person lies still (keep their head stationary)\n3. Stabilize the casualty with bolsters on either side.\n4. Calm the person.\n5. Emergency call, point out the back injury.");aid_birth = new StringItem ("Birth", "Outflow of amniotic fluid. Contraction pains occur. Unexpected birth.\n1. Pay attention to privacy and keep calm! - Emergency call.\n2. Let the pregnant woman bare the lower part of her body, and sit down on a sterile underlay with spread legs.\n3. Angle the knees. Pull up the legs. Position the basin slightly upward. - Birth is a natural process and runs mostly without complications.\n4. Calm the woman, let her concentrate on her breathing: Breathe in through nose, breathe out through mouth (in normal speed).\n5. Rhythm of pressing: Take a deep breath, hold breath, and press. As soon as the baby's head appears, support by taking hold of it with both of your hands.\n6. After the childbirth: Hold the baby on a slant with head down to liberate the airways from amniotic fluid. (You may have to suck out the fluid from the baby's nose by mouth.) The baby must breathe and cry!\n7. Bind off the umbilical cord 30 cm away from the child (can also be done in hospital). Keep the vagina of the mother sterile.\n8. Dry the baby and keep it warm. Note the time and drive to the hospital.");aid_bleedinglight = new StringItem ("Bleeding (light)", "Goal: Stop the bleeding.\n1. Do not touch the wound (danger of infection).\n2. Do not treat wound with powder, salves or sprays.\n3. Wound treatment: cover with sterile material and a bandage.\n4. For slight bleeding a plaster is often sufficient.\n5. If wound is large-scale, use a wound cover and a bandage. Do not apply bandage too tight, as a stasis can lead to increased bleeding.\n6. Note: Wounds as a result of the bite from a rabid animal have to be washed with soapy solution.");aid_bleedingsevere = new StringItem ("Bleeding (severe)", "Splashing, pulsating blood. Danger: Choking because of blood loss, infections, death. Goal: Stop the bleeding.\n1. Remove clothes (cut if necessary) and reveal wound.\n2. Wrap a bandage or, if necessary, a garment with pressure around the wound.\n3. Exert pressure for at least 10 min.\n4. If bandage is soaked with blood, do not remove it. Instead wrap another bandage/garment around it.\n5. Place the affected limb (if not broken) higher than the heart to reduce amount of blood pressure. If possible lay down casualty.\n6. If bleeding does not stop, keep pressure on wound, and set additional pressure point on wound: For a bleeding of the forearm compress the upper arm (press vein at inner side of arm, in the middle of elbow and arm-pit, using your fingers). For bleeding of leg, set pressure point in groin (press vein at crook of groin, where artery leads over pelvic bone, using the ball of your hand).\n7. Call emergency doctor immediately.\n8. As soon as bleeding is under control: Initiate anti-shocking measures.");aid_brainconcussion = new StringItem ("Brain Concussion", "Headache, nausea, vomiting. Impaired vision. Unconsciousness can occur.\n1. Lay down person concerned.\n2. Emergency call.\n\nIf bleeding from head:\n1. Lay down casualty, with the head elevated (on pillow).\n2. Do wound-treatment (use head-bandage).\n3. Emergency call.");aid_burningslight = new StringItem ("Burning (slight)", "Redness of skin. Mild swellings. Pain.\n1. Hold area involved under cool water.\n2. Apply wet bandage loosely.");aid_burningsevere = new StringItem ("Burning (severe)", "Spotted white-red areas, blistering. Skin loses fluid. Deep damage of tissue. Strong pain or no pain (because of burned nerves).\n1. Remove clothes as much as possible.\n2. Cool burned body parts with water (about 15°C, 59°F) up to 10 min, until pain reduces.\n3. If burning is extensive, just use wet cloths to cool.\n4. Emergency call.\n5. After cooling, do the wound treatment: Use a sterile dressing. Do not apply fluids (no creams, oils, ointments etc.). Do not pierce the blisters.\n6. Control breathing and consciousness of the person until emergency doctor arrives.");aid_checkbreathing = new StringItem ("Check Breathing", "1. Check breathing sounds.\n2. Diagnose breathing in the upper abdomen (lay your hand on it).\n3. Sense breathing at nose and mouth.");aid_chemicalburneyes = new StringItem ("Chemical Burn (Eyes)", "1. Emergency call, point out chemicals.\n2. Flush eye with much water. Cover healthy eye during flushing.\n3. Lead the water jet from inner angle of eye to outer angle of eye. Clean for at least 20 min under clear water.\n4. Close both eyes of the casualty and bind with wet cloth.\n5. Monitor condition until ambulance arrives.");aid_chemicalburn = new StringItem ("Chemical Burn", "Injury of tissue.\n1. Mind self-protection!\n2. Act quickly and wash the burned locations.\n3. Emergency call.\n4. If there is a chemical burn of the digestive tract, particularly the mouth and throat, drink a lot of water.\n5. Do not cause vomiting!");aid_dangerzone = new StringItem ("Danger Zone (Rescue)", "1. Grip execution: Position one arm of the injured in front of his/her chest, and get behind him/her.\n2. Put your hands under the shoulders of the wounded, grabbing the angled arm.\n3. Pull back and carry the person into safety.");aid_diabeticcoma = new StringItem ("Diabetic Coma", "Blood sugar level is too high (resp. lack of insulin).\nSymptoms: Thirst, frequent urination, nausea, vomit. Breath smells of fruits/wine.\n1. Call emergency.\n2. Support casualty (if confirmed as diabetic) taking insulin.\n3. Recovery position. (No further possibilities for the first aider.)\n4. Monitor the condition of the casualty until emergency doctor arrives.");aid_diarrhoea = new StringItem ("Diarrhoea", "Reaction to contaminated food, infection of intestine or disorder. Stool is diluted, slimy or bloody.\n1. Danger for the circulation because of dehydration and loss of salt!\n2. Give liquids (tea, water).\n3. If there are strong disorders call the emergency doctor.");aid_drowning = new StringItem ("Drowning", "1. Call emergency. Ask people next to you for help.\n2. Rescue person out of water!\n3. If casualty is breathing: Recovery position. Keep him/her warm (cover). Monitor condition until emergency doctor arrives.\n4. If casualty is not breathing: Immediately start with resuscitation! (Ejecting water from the lungs is useless.)");aid_electricityaccident = new StringItem ("Electricity Accident", "1. Firstly interrupt the electricity supply!\nDanger: Unconsciousness, apnoea.\n2. A - Unconsciousness with breathing\n3. B - Unconsciousness without breathing");aid_emergencycall = new StringItem ("Emergency Call", "Dial 112 with the next available phone (USA: 911). Always possible and for free! Do not hesitate to call for an ambulance!\nOn the phone you must provide the following information: \n- What has happened \n- Where (accident place) \n- How many casualties \n- What kind of injuries.\nAfterwards wait for further instructions or queries.");aid_epilepsy = new StringItem ("Epilepsy", "Rigid body, clenched fists, pressed jaw, twitching in limbs or face. Rolling eyes. Salivation. Unconsciousness possible.\n1. Do not hold the casualty or restrain their movement.\n2. Lay the casualty on a soft base (cushion), remove close objects to prevent self-injury.\n3. Calm down the casualty. Loosen clothing, provide freedom to breath.\n4. If casualty vomits, turn their head to the side so that vomit can drain.\n5. Keep airways clear. Danger of swallowing the tongue.\n6. Recovery Position + Emergency call. Continue monitoring the casualty's condition.\n7. Keep other people at distance.");aid_eyeinjury = new StringItem ("Eye Injury", "1. Leave object in the eye of casualty, do not remove it.\n2. Keep eyes motionless to avoid further injuries. Do not touch the eye.\n3. If eye is bleeding, cover it with a compress or a sterile gauze.\n4. Cool the eye with a cold pad (reduces swelling, bleeding stops quicker).\n5. Emergency call or drive casualty to hospital yourself.");aid_fracture = new StringItem ("Fracture", "Symptoms: Unnatural position and movability of bone. Deformation. Painful movement, touch-sensitive.\n1. Avoid movements!\n2. Emergency call.\n3. Immobilize the fractured bone, i.e. bolster material around bone tightly. Keep position of the bone.\n4. If fracture is open, cover the wound with sterile material.");aid_frostbitemild = new StringItem ("Frostbite (mild)", "Paleness, swellings. Danger for blood supply.\n1. Move casualty into a warm area.\n2. Get away from cold, remove cold clothes, dry person.\n3. Warm up with lukewarm water and with body heat of the helper.\n4. Give warm drink (tea). No alcohol!");aid_frostbitesevere = new StringItem ("Frostbite (severe)", "Cold hard skin, grey-white, blistering, tissue dies off. Danger for blood supply!\n1. Go to warm area.\n2. Wound treatment/covering.\n3. Give a sugary drink.\n4. Do not rub the casualty to warm them!\n5. Emergency call.");aid_heartattack = new StringItem ("Heart Attack", "Heavy, more than 5 min lasting pressure and pain in the chest, particularly radiating in the arms/shoulders. Anxiety, paleness, cold sweat. Possibly nausea, shortness of breath.\n1. Emergency call! Point out the supposed heart attack.\n2. Position with the upper body elevated. Loosen tight clothing. Do not give drugs or drinks.\n3. Talk calmly to the person concerned.\n4. Control consciousness and breathing.\n5. Give aspirin if available.\n6. If person becomes unconscious, start resuscitation.");aid_hypoglycaemia = new StringItem ("Hypoglycaemia (low sugar)", "Blood sugar level is below minimum value (because of overdose of insulin or insufficient intake of food).\nSymptoms: Paleness, nervousness, hunger, shivering, sweating.\n1. Make sure that the person is a diabetic (look for a diabetic badge).\n2. Emergency call.\n3. Give a sugary drink and dextrose/glucose (if there are no problems in swallowing).\n4. If person is conscious and breathing: Recovery position. Monitor breathing of the person. If apnoea appears, start with breath giving.\n5. If there is breathing, you can put a lump of sugar into the cheek pouch, push from outside against it.");aid_hyperthermia = new StringItem ("Hyperthermia (hot body)", "Thirst, weakness, disorientation, nausea, confusion, strong sweating, hot skin.\n1. Emergency call.\n2. Find a cool shady place (room with air conditioning preferable).\n3. Lay down person, elevate legs. Loosen clothing.\n4. Cool skin with cold water or lay on cold towels.\n5. Give plenty of water or juices to drink.");aid_hypothermia = new StringItem ("Hypothermia (cool body)", "Cold shiver, drowsiness, exhaustion up to unconsciousness. Cold pale skin. Slow pulse, weak heartbeat.\n1. Go to a warm area/room.\n2. Call emergency.\n3. Increase body temperature (cover and body-to-body-contact).\n4. Remove wet clothes and put on warm clothes. Cover with blankets or other covers. Cover the head.\n5. Give hot tea, soup or hot water to drink. No alcohol! Keep person awake.\n6. Monitor casualty's condition until emergency doctor arrives. If person becomes unconscious, initiate resuscitation:\n7. A - Unconsciousness with breathing\n8. B - Unconsciousness without breathing");aid_icerescue = new StringItem ("Ice Rescue", "Pay attention to your own safety. Danger: Drowning, Hypothermia.\n1. Ask other people for help. Call for an emergency ambulance.\n2. Rescue via ladder, board or bar. Weight must be distributed evenly.\n3. Crawl carefully on your front along the support (if possible roped to a stable point) with a pole or similar tool.\n4. Reach to the person with the pole or other tool (not your hand!), encourage him/her to take hold of it and pull him/her out.\n5. Crawl backwards back to the edge.\n6. First-Aid measures.\n7. Self-rescue possible: If ice is solid, you can distribute your weight on the ice and pull yourself out. Crawl flat on your front to the edge. If ice is fragile, try to break the ice piece by piece up to the edge.");aid_insectstings = new StringItem ("Insect stings", "Swelling, skin rash, burning feeling, weakness, difficult breathing, decreased consciousness, tachycardia.\n1. Remove sting carefully (with a tweezer). Do not squeeze the sting as this could inject more venom.\n2. Cool concerned spot (apply a cold compress).\n3. Concerned area should be kept lower than the heart to slow circulation of the venom.\n4. If stung in mouth/jaw area: Suck ice-cream, and apply a cold compress around throat.\n5. If severe problems, notably difficulty in breathing or decreased consciousness, occur, call an ambulance immediately.");aid_nosebleeding = new StringItem ("Nosebleeding", "Burst small artery in the nose.\n1. Sit the person down, leaning slightly forward. Keep head straight.\n2. Do not position the person flat, as head over height of heart slows down bleeding.\n3. Place cooling material round neck (wet cloth).\n4. Pinch nostrils together until bleeding stops (for 10 min).\n5. Afterwards do not strain the nose (no snorting).\n6. If severe problems occur or bleeding cannot be stopped, call emergency doctor.");aid_poisining = new StringItem ("Poisoning", "Confusion, hallucinations, enlarged pupils, fever, cramps. Unconsciousness.\n1. Only give antidotes if you are accompanied by a trained medic.\n2. Do not give drinks. Do not cause vomiting.\n3. Emergency call + point out the poisoning!\n4. Safeguard rest of poison and the vomit!\n5. If casualty is conscious and breathing: Recovery position. Monitor condition until emergency doctor arrives.\n6. If casualty is not breathing: Immediately start with resuscitation! Free mouth from vomit beforehand.");aid_recoveryposition = new StringItem ("Recovery Position", "1. Lay casualty on her/his back, straighten legs. Knee beside him/her.\n2. Place arm nearest to you at a right angle to the body.\n3. Pull arm furthest from you across the chest and place the back of the hand against cheek.\n4. Get the far knee, pull it to your side, and lay it on the ground. Position the leg at a right angle. Keep casualty's hand under the cheek of the person.\n5. Make sure the airways are free.\n6. Open mouth slightly, and position the head to the side so that vomit can drain. Check breathing.\n7. Control the casualty's condition until the emergency doctor arrives.");aid_resuscitation = new StringItem ("Resuscitation", "# Heart Massage\n1. Lay casualty on his/her back. Kneel beside person.\n2. Bare the chest.\n3. Place the heel of the hand in the middle of the chest (just over sternum).\n4. Place other hand on the back of the hand which is already in position.\n5. Extend your arms and elbows.\n6. Press 5 cm deep into the person's chest (power comes from upper part of the body) and release.\n7. Push 30 times in a row shortly and strongly!\n\n# Breathing\n1. Remove any substances out of mouth and throat. Stretch head backwards.\n2. Pinch the nose together, so that nose is closed.\n3. Take a deep breath and put your mouth onto the mouth of the casualty, that no air can leak.\n4. Do mouth-to-mouth breathing two times (breath out slowly and fully).\n5. Afterwards do heart massage again.\n\nRepeat heart massage + mouth-breathing until the emergency doctor arrives.");aid_safeguardaccident = new StringItem ("Safeguard Accident", "1. Stop your own car 50-100 m behind the accident site (if you are on a highway or country road). Switch on warning lights. Put on high visibility vest.\n2. Position the warning triangle before the accident site. Attention: If accident is on a curve position the warning triangle before the curve!\n3. Ask other people for their help.\n4. Open the door of the accident car (if jammed, prise it open using a car jack). Turn off ignition.\n5. Rescue the accident victim: Unstrap seat-belt, move seat backwards. Free the casualty out of the car by rescue grip.\n6. Emergency call.\n7. Proceed with first aid measures.");aid_shock = new StringItem ("Shock", "Circulatory disorder by poor oxygen supply in the body.\nCause: Loss of fluid, reduced blood volume.\nSymptoms: Paleness, cold skin, cold sweat, anxiety.\n1. Eliminate the cause of the shock (e.g. stop the fluid loss, bind the wound)!\n2. Lay the wounded person on a blanket, raising the legs. Calm the person.\n3. Emergency call.\n4. If difficulties in breathing or consciousness, initiate resuscitation.");aid_skullfracture = new StringItem ("Skull fracture", "Light bleeding from nose, mouth or ear. Often open wounds on skull.\n1. Keep the airways free.\n2. If conscious: Let the injured sit with head bowed forwards. Avoid further movements!\n3. If unconscious: Recovery position (no pressure on wound of head).\n4. Emergency call.\n5. Apply head bandage.\n6. If difficulties in breathing or consciousness, initiate resuscitation.");aid_snakebite = new StringItem ("Snakebite", "Puncture wound the size of a pin, severe pains, swelling, purple colour. Circulatory disturbance, danger of shock.\n1. Steady the wounded part of the body.\n2. Apply cold material around bite wound.\n3. Take measures against shock.\n4. Emergency call.");aid_sos = new StringItem ("SOS", "1. Signal: 3x short, 3x long, 3x short.\n2. Optically (strobe light, flashlight), or acoustically (signal whistle, knocking).");aid_sprain = new StringItem ("Sprain + Strain", "Pain, swelling (bruise), loss of function, deformation of the limb.\n1. Place the injured part of the body in the position most comfortable for the casualty.\n2. Cool (using ice packs).\n3. If possible, position the injured part elevated.\n4. Go to hospital or call emergency doctor.");aid_stroke = new StringItem ("Stroke", "Sudden feeling of paralysis or numbness (face, arm, leg), disturbances in language understanding, vision problems, disturbed consciousness, severe headache. Problems in breathing and swallowing, loss of control over bladder and intestine.\n1. Emergency call!\n2. Loosen tight clothing. Do not give drugs or drinks.\n3. Sit or lay down person concerned comfortably. Calm him/her!\n4. Control consciousness and breathing.\n5. If difficulties in breathing or consciousness, initiate resuscitation.");aid_suffocation = new StringItem ("Suffocation (Choking)", "Insufficient oxygen supply. Trachea closed. Danger: Apnoea.\nSymptoms: Wheezing respiratory noise, cough stimulus, shortness of breath, skin discolouration.\n1. Immediate action! Let the person concerned cough very strongly.\n2. Strike strongly with a flat hand on the back between the shoulder blades (lay babies on your forearm, with head down).\n3. If without success: Stand behind person, arms around waist, bow slightly forward.\n4. Clench your fist, position it at height of person's stomach, and take it with your other hand.\n5. In embrace use both hands to give a hard blow upwards towards stomach (as if you would try to lift the person).\n6. Repeat this up to 5 times! Airways should get free from object.\n7. Emergency call.\n8. If first aid measure is unsuccessful at first, keep on doing it until emergency doctor arrives.");aid_sunburn = new StringItem ("Sunburn", "1. Remove affected person from direct sunlight. Avoid further sun.\n2. Drink much water to stop dehydration.\n3. If there is a serious sunburn (blisters, redness, pain), seek medical advice.\n4. If the skin is just lightly red, it can be cooled with wet compresses. Use after-sun lotion or gel.");aid_sunstroke = new StringItem ("Sunstroke", "Hot red head, cool skin, sickness, headache, dizziness. Cause: Irritation of the cerebral membrane.\n1. Go to a cool place (shadow) and position the upper body of the person up.\n2. Cool the head with wet blankets.\n3. Emergency call, keep controlling the breathing.\n4. If conscious: Give cool drink if applicable.\n5. If apnoea appears, start with breathing:\n6. Go on with Breath Giving!");aid_unconsciouswithbreath = new StringItem ("Unconsciousness with breathing", "No reaction on loudly asking, no response on shaking. Breathing does exist.\n1. If there are people next to you ask for help.\n2. Recovery position. Open mouth and position head this way that vomit can drain.\n3. Emergency call.");aid_unconsciouswithoutbreath = new StringItem ("Unconsciousness without breathing", "1. No reaction of casualty, no breathing.\n\nInitiate Resuscitation.");aid_vomiting = new StringItem ("Vomiting", "Arises from nausea. Stomach empties itself. Causes: Infection, poisoning, ulcer, drugs, bad food, pregnancy.\n1. Danger for the circulation because of dehydration and loss of salt!\n2. Give liquids (tea, water).\n3. If there are strong disorders, bloody or continuous vomiting, call the emergency doctor. ");
			aid_amputation = new StringItem ("Amputation", "Amputated body part can be reattached again. Goal: Keep amputated part cool until you arrive at hospital. \n1. Calm the person, lay him/her down, and cover with blanket.\n2. Stop the bleeding, see 'Bleeding (severe)' and 'Shock'.\n3. Wrap amputated part in a clean and dry cloth, and put it into a waterproof plastic bag. \n4. Close this plastic bag and put it into another plastic bag, that contains cool water/ice.\n5. Do not give alcohol, cigarettes or food to casualty (in case of a surgery with anaesthesia in hospital).\n6. Do not freeze the amputated part (just keep it cool).\n7. Call emergency or drive casualty to hospital yourself.");
			separator = new StringItem ("Separator", "-");  
					// connection between MENU + NRs 
					stringItemArray = new StringItem[] {
									aid_disclaimer, separator, aid_general, aid_allergic, aid_amputation, aid_animalbite, aid_apnoea, aid_asthma, aid_backinjury, aid_birth, aid_bleedinglight, aid_bleedingsevere, aid_brainconcussion, aid_apnoea, aid_asthma, aid_burningslight, aid_burningsevere, aid_checkbreathing, aid_chemicalburneyes, aid_chemicalburn, aid_resuscitation, aid_dangerzone, aid_diabeticcoma, aid_diarrhoea, aid_drowning, aid_electricityaccident, aid_emergencycall, aid_epilepsy, aid_eyeinjury, aid_fracture, aid_frostbitemild, aid_frostbitesevere, aid_heartattack, aid_diabeticcoma, aid_hypoglycaemia, aid_hyperthermia, aid_hypothermia, aid_icerescue, aid_insectstings, aid_nosebleeding, aid_poisining, aid_resuscitation, aid_recoveryposition, aid_resuscitation, aid_safeguardaccident, aid_shock, aid_skullfracture, aid_snakebite, aid_sos, aid_backinjury, aid_sprain, aid_stroke, aid_suffocation, aid_sunburn, aid_sunstroke, aid_suffocation, aid_safeguardaccident, aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_vomiting, separator}; 

			display = Display.getDisplay(this);
			display.setCurrent(this.menu);

			// sets the focus to the given index of the specified list.
			UiAccess.setCurrentListIndex(display, this.menu, 0);

			// set commands and listener to form
			details.addCommand(cmdBack);
			details.addCommand(cmdPlay);
			details.setCommandListener(this);

			// application has started
			started = true;
		}
	}


	public void applyText(int auswahl) {
		// assign to global variable, to connect to Command.ITEM (play mp3)
		globalchoice = auswahl;

		// connect double content (for mp3)
		if (auswahl==13) globalchoice = 6;   // breathing -> apnoea
		else if (auswahl==14) globalchoice = 7; // breathlessness -> Asthma
		else if (auswahl==20) globalchoice = 43; // chest compression -> resuscitation
		else if (auswahl==33) globalchoice = 22; // hyperglycamaemia -> diabetic coma
		else if (auswahl==41) globalchoice = 43; // reanimation -> resuscitation
		else if (auswahl==49) globalchoice = 8; // spinal fracture -> back injury
		else if (auswahl==55) globalchoice = 52; // swallowing -> suffocation
		else if (auswahl==56) globalchoice = 44; // traffic accident -> safeguard accident site
			
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

	private void playMP3Sound(int auswahlSnd) {
		System.out.println("now playing: " + auswahlSnd+".mp3");
		try
		{
			if (myPlayer == null) {
				// read in mp3-file (j2me polish: path up!
				InputStream is = getClass().getResourceAsStream("../../"+auswahlSnd+".mp3"); //"../"+auswahlSnd+".mp3"
				// set up media player
				myPlayer = Manager.createPlayer(is,"audio/mpeg");
				myPlayer.realize();
				// get volume control for player and set volume to max
				VolumeControl vc = (VolumeControl) myPlayer.getControl("VolumeControl");
				if(vc != null)
				{
					vc.setLevel(100);
				}
				// the player can start with the smallest latency
				myPlayer.prefetch();
				// non-blocking start
				myPlayer.start();
			}
		}
		catch(MediaException pe){
			System.out.println("Error in media: " + pe.toString());
		}
		catch (IOException ioe) {
			System.out.println("No File found: " + ioe.toString());
		}
	}

	
	public void pauseApp() {
	}

	public void destroyApp(boolean unconditional) {
		notifyDestroyed();
	}

	boolean playCommandVisible = true;
	public void commandAction(Command c, Displayable d) {
		// System.out.println(c.getLabel());
		
		if(c.getCommandType() == Command.BACK) {
			if (myPlayer != null) {
				try {
					myPlayer.stop();
					// deallocate();
					myPlayer.close();
					myPlayer = null;
				}
				catch(Exception e){
					System.out.println("Error: " + e.toString());
				}
			}
			display.setCurrent(menu);
		}
		else if (c.getCommandType() == Command.EXIT) {
			notifyDestroyed();
		}
		// play audio file (start)
		else if (c.getLabel() == "Play") {
			playMP3Sound(globalchoice);
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
			details.removeCommand(cmdPlay);
			playCommandVisible = false;
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
				// if playCommand has been removed, add it again 
				if (playCommandVisible==false) {
					details.addCommand(cmdPlay);
					playCommandVisible = true;
				}
				// show the chosen information 
				display = Display.getDisplay(this);
				display.setCurrent(details);
			}
		}
	}
}
