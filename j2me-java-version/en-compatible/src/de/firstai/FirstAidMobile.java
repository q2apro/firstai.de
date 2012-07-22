// First.Aid.3.0.compatible
package de.firstai;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class FirstAidMobile extends MIDlet implements CommandListener {

	boolean started = false;
	Form formTextHolder;
	Display display;
	List menu;
	List telEmergency;

	// Setup of the navigation buttons:
	// static final Command cmdChose = new Command("Wähle", Command.OK, 2);
	static final Command cmdBack = new Command("Back", Command.BACK, 2);
	static final Command cmdExit = new Command("Exit", Command.EXIT, 2);

	StringItem aid_disclaimer, aid_general, aid_allergic, aid_asthma, aid_amputation, aid_apnoea, aid_checkbreathing, aid_eyeinjury, aid_chemicalburneyes, 
	aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_bleedinglight, aid_bleedingsevere, aid_diabeticcoma, aid_diarrhoea, aid_icerescue, aid_electricityaccident, aid_epilepsy, 
	aid_vomiting, aid_frostbitemild, aid_frostbitesevere, aid_suffocation, aid_drowning, aid_birth, aid_dangerzone, aid_brainconcussion, aid_resuscitation, aid_heartattack, aid_hyperthermia, 
	aid_insectstings, aid_fracture, aid_nosebleeding, aid_emergencycall, aid_backinjury, aid_skullfracture, aid_stroke, aid_snakebite, aid_shock, aid_sunburn, aid_sunstroke, 
	aid_sos, aid_recoveryposition, aid_animalbite, aid_safeguardaccident, aid_hypothermia, aid_hypoglycaemia, aid_chemicalburn, aid_burningslight, aid_burningsevere, aid_poisining, 
	aid_sprain;
	
	StringItem stringAfrica;
	StringItem stringAsia;
	StringItem stringEurope;
	StringItem stringNorthamerica;
	StringItem stringOceania;
	StringItem stringSouthamerica;
	
	public FirstAidMobile() {
		formTextHolder = new Form ("First Aid Mobile");
	}

	public void startApp() {

		if (!started) {
			telEmergency = new List ("Chose Continent", Choice.IMPLICIT);
			telEmergency.append("Africa", null);
			telEmergency.append("Asia", null);
			telEmergency.append("Europe", null);
			telEmergency.append("North-/Central America", null);
			telEmergency.append("Oceania", null);
			telEmergency.append("South America", null);
			telEmergency.addCommand(cmdBack);
			telEmergency.setCommandListener(this);
			
			stringAfrica = new StringItem("Africa", "\n\n# Algeria\nFire:14 | Pol:17 | Med:17\n\n# Angola\nFire:118 | Pol:110 | Med:118\n\n# Benin\nFire:18 | Pol:17 | Med:301769\n\n# Botswana\nFire:998 | Pol:999 | Med:997\n\n# Burkina Faso\nFire:18 | Pol:17 | Med:local numbers\n\n# Burundi\nFire:no system | Pol:no system | Med:no system\n\n# Cameroon\nFire:18 | Pol:17 | Med:local numbers\n\n# Cape Verde\nFire:131 | Pol:132 | Med:130\n\n# Central African Republic\nFire:118 | Pol:611253 | Med:610600\n\n# Chad\nFire:18 | Pol:17 | Med:local numbers\n\n# Comoros\nFire:only radio telephones | Pol:only radio telephones | Med:only radio telephones\n\n# Congo (Democratic Republic)\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Congo (Republic)\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Djibouti\nFire:18 | Pol:17 | Med:351351\n\n# Egypt\nFire:180 | Pol:122 | Med:123\n\n# Equatorial Guinea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Eritrea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Ethiopia\nFire:93 | Pol:91 | Med:92\n\n# Gabon\nFire:18 | Pol:1730 | Med:1300\n\n# Gambia\nFire:118 | Pol:117 | Med:116\n\n# Ghana\nFire:192 | Pol:191 | Med:193\n\n# Guinea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Guinea-Bissau\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Ivory Coast\nFire:180 | Pol:110 | Med:110\n\n# Kenya\nFire:999 | Pol:999 | Med:999\n\n# Lesotho\nFire:122 | Pol:123 | Med:121\n\n# Liberia\nFire:911 | Pol:911 | Med:911\n\n# Libya\nFire:193 | Pol:193 | Med:193\n\n# Madagascar\nFire:18 | Pol:117 | Med:2262566\n\n# Malawi\nFire:199 | Pol:199 | Med:199\n\n# Mali\nFire:18 | Pol:17 | Med:15\n\n# Mauritania\nFire:118 | Pol:117 | Med:local numbers\n\n# Mauritius\nFire:999 | Pol:999 | Med:999\n\n# Mayotte\nFire:603054 | Pol:112 | Med:15\n\n# Morocco\nFire:15 | Pol:19 | Med:15\n\n# Mozambique\nFire:198 | Pol:119 | Med:117\n\n# Namibia\nFire:2032270 | Pol:1011 | Med:2032276\n\n# Niger\nFire:18 | Pol:17 | Med:723141\n\n# Nigeria\nFire:190 | Pol:119 | Med:199\n\n# Réunion\nFire:18 or 112 mobile | Pol:17 or 112 mobile | Med:15 or 112 mobile\n\n# Rwanda\nFire:local numbers | Pol:112 | Med:local numbers\n\n# Sahrawi Arab Democratic Republic\nFire:-- | Pol:-- | Med:--\n\n# Sao Tomé and Principe\nFire:-- | Pol:-- | Med:--\n\n# Senegal\nFire:local numbers | Pol:local numbers | Med:8891515\n\n# Seychelles\nFire:999 | Pol:999 | Med:999\n\n# Sierra Leone\nFire:999 | Pol:999 | Med:999\n\n# Somalia\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# South Africa\nFire:10111 | Pol:10111 | Med:10177\n\n# Sudan\nFire:999 | Pol:999 | Med:local numbers\n\n# Swaziland\nFire:local numbers | Pol:999 | Med:6060911\n\n# Tanzania\nFire:112 | Pol:112 | Med:112\n\n# Togo\nFire:118 | Pol:101 | Med:191\n\n# Tunisia\nFire:198 | Pol:197 | Med:190\n\n# Uganda\nFire:999 or 111 mobile | Pol:999 or 111 mobile | Med:999 or 111 mobile\n\n# Zambia\nFire:993 or 112 mobile | Pol:999 or 112 mobile | Med:991 or 112 mobile\n\n# Zimbabwe\nFire:993 | Pol:995 | Med:994");
			stringAsia = new StringItem("Asia", "\n\n# Afghanistan\nFire:-- | Pol:-- | Med:112\n\n# Armenia\nFire:101 | Pol:102 | Med:103\n\n# Azerbaijan\nFire:101 | Pol:102 | Med:103\n\n# Bahrain\nFire:999 | Pol:999 | Med:999\n\n# Bangladesh\nFire:9555555 | Pol:8665513 | Med:199\n\n# Bhutan\nFire:113 | Pol:110 | Med:112\n\n# Brunei\nFire:995 | Pol:993 | Med:991\n\n# Cambodia\nFire:118 | Pol:117 | Med:199\n\n# China\nFire:119 | Pol:110 | Med:120\n\n# East Timor\nFire:-- | Pol:112 | Med:7233212\n\n# Georgia\nFire:022 | Pol:022 | Med:022\n\n# Hong Kong\nFire:999 | Pol:999 | Med:999\n\n# India\nFire:101 | Pol:100 | Med:102\n\n# Indonesia\nFire:113 | Pol:110 | Med:118\n\n# Iran\nFire:125 or 112 mobile | Pol:110 or 112 mobile  | Med:115 or 112 mobile\n\n# Iraq\nFire:no system | Pol:no system | Med:no system\n\n# Israel\nFire:102 | Pol:100 | Med:101\n\n# Japan\nFire:119 | Pol:110 | Med:119\n\n# Jordan\nFire:193 | Pol:192 | Med:193\n\n# Kazakhstan\nFire:03 | Pol:03 | Med:03\n\n# Kurdistan\nFire:125 | Pol:129 | Med:115\n\n# Kuwait\nFire:777 | Pol:777 | Med:777\n\n# Kyrgyzstan\nFire:03 | Pol:133 | Med:03\n\n# Laos\nFire:local numbers | Pol:local numbers | Med:03\n\n# Lebanon\nFire:175 | Pol:112 | Med:140\n\n# Macau\nFire:999 | Pol:999 | Med:999\n\n# Malaysia\nFire:999 or 112 mobile | Pol:999 or 112 mobile | Med:999 or 112 mobile\n\n# Maldives\nFire:118 | Pol:119 | Med:102\n\n# Mongolia\nFire:101 | Pol:102 | Med:103\n\n# Myanmar\nFire:199 | Pol:199 | Med:199\n\n# Nepal\nFire:101 | Pol:100 | Med:228094\n\n# North Korea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Oman\nFire:999 | Pol:999 | Med:999\n\n# Pakistan\nFire:16 | Pol:15 | Med:115\n\n# Philippines\nFire:117 | Pol:117 | Med:117\n\n# Qatar\nFire:999 | Pol:999 | Med:999\n\n# Saudi Arabia\nFire:998 | Pol:999 | Med:997\n\n# Singapore\nFire:995 | Pol:999 | Med:995\n\n# South Korea (Republic Korea)\nFire:119 | Pol:112 | Med:119\n\n# Sri Lanka\nFire:111 | Pol:119 or 112 mobile | Med:110\n\n# Syria\nFire:113 | Pol:112 | Med:110\n\n# Taiwan\nFire:119 | Pol:110 | Med:119\n\n# Tajikistan\nFire:local numbers | Pol:02 | Med:03\n\n# Thailand\nFire:199 | Pol:191 or 1155 (tourists) | Med:191\n\n# Turkmenistan\nFire:03 | Pol:03 | Med:03\n\n# United Arab Emirates\nFire:997 | Pol:999 | Med:998\n\n# Uzbekistan\nFire:03 | Pol:03 | Med:03\n\n# Vietnam\nFire:114 | Pol:113 | Med:115\n\n# Yemen\nFire:199 | Pol:199 | Med:199");
			stringEurope = new StringItem("Europe", "\n\n# Albania\nFire:18 | Pol:19 | Med:17\n\n# Andorra\nFire:118 | Pol:110 | Med:118\n\n# Austria\nFire:112 | Pol:112 | Med:112\n\n# Belarus\nFire:01 | Pol:02 | Med:03\n\n# Belgium\nFire:112 | Pol:112 | Med:112\n\n# Bosnia and Herzegovina\nFire:123 | Pol:122 | Med:124\n\n# Bulgaria\nFire:112 | Pol:112 | Med:112\n\n# Croatia\nFire:93 | Pol:92 | Med:94\n\n# Cyprus\nFire:112 | Pol:112 | Med:112\n\n# Czech Republic\nFire:112 | Pol:112 | Med:112\n\n# Denmark\nFire:112 | Pol:112 | Med:112\n\n# Estonia\nFire:112 | Pol:112 | Med:112\n\n# Finland\nFire:112 | Pol:112 | Med:112\n\n# France\nFire:18 or 112 | Pol:17 or 112 | Med:15 or 112\n\n# Germany\nFire:112 | Pol:110 | Med:112\n\n# Greece\nFire:112 | Pol:112 | Med:112\n\n# Hungary\nFire:112 | Pol:112 | Med:112\n\n# Iceland\nFire:112 | Pol:112 | Med:112\n\n# Ireland\nFire:112 | Pol:112 | Med:112\n\n# Italy\nFire:112 | Pol:112 | Med:112\n\n# Kosovo\nFire:911 | Pol:911 | Med:911\n\n# Latvia\nFire:112 | Pol:112 | Med:112\n\n# Liechtenstein\nFire:112 | Pol:112 | Med:112\n\n# Lithuania\nFire:112 | Pol:112 | Med:112\n\n# Luxembourg\nFire:112 | Pol:112 | Med:112\n\n# Macedonia\nFire:112 | Pol:112 | Med:112\n\n# Malta\nFire:112 | Pol:112 | Med:112\n\n# Moldova\nFire:901 | Pol:902 | Med:903\n\n# Monaco\nFire:112 | Pol:112 | Med:112\n\n# Montenegro\nFire:112 | Pol:112 | Med:112\n\n# Netherlands\nFire:112 | Pol:112 | Med:112\n\n# Norway\nFire:110 | Pol:112 | Med:113\n\n# Poland\nFire:112 | Pol:112 | Med:112\n\n# Portugal\nFire:112 | Pol:112 | Med:112\n\n# RepublicofIreland\nFire:112 | Pol:112 | Med:112\n\n# Romania\nFire:112 | Pol:112 | Med:112\n\n# Russia\nFire:01 | Pol:02 | Med:03\n\n# San Marino\nFire:116 | Pol:112 | Med:113\n\n# Serbia\nFire:112 | Pol:112 | Med:112\n\n# Slovakia\nFire:112 | Pol:112 | Med:112\n\n# Slovenia\nFire:112 | Pol:113 | Med:112\n\n# Spain\nFire:112 | Pol:112 | Med:112\n\n# Sweden\nFire:112 | Pol:112 | Med:112\n\n# Switzerland\nFire:118 or 112 | Pol:117 or 112 | Med:144 or 112\n\n# Turkey\nFire:110 | Pol:155 | Med:112\n\n# Ukraine\nFire:112 | Pol:112 | Med:112\n\n# United Kingdom\nFire:112 | Pol:112 | Med:112\n\n# Vatican City\nFire:115 | Pol:112 | Med:113");
			stringNorthamerica = new StringItem("North-/Central America", "\n\n# United States of America\nFire:911 | Pol:911 | Med:911\n\n# Antigua and Barbuda\nFire:911 | Pol:911 | Med:911\n\n# Bahamas\nFire:911 | Pol:911 | Med:911\n\n# Barbados\nFire:113 | Pol:112 | Med:115\n\n# Belize\nFire:911 | Pol:911 | Med:911\n\n# Canada\nFire:911 | Pol:911 | Med:911\n\n# Cayman Islands\nFire:911 | Pol:911 | Med:911\n\n# Costa Rica\nFire:911 | Pol:911 | Med:911\n\n# Cuba\nFire:26811 | Pol:26811 | Med:26811\n\n# Dominica\nFire:999 | Pol:999 | Med:999\n\n# Dominican Republic\nFire:911 | Pol:911 | Med:911\n\n# El Salvador\nFire:911 | Pol:911 | Med:911\n\n# Greenland\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Grenada\nFire:911 | Pol:112 | Med:911\n\n# Guatemala\nFire:122 | Pol:110 | Med:123\n\n# Haiti\nFire:local numbers | Pol:114 | Med:118\n\n# Honduras\nFire:198 | Pol:119 | Med:378654\n\n# Jamaica\nFire:110 | Pol:119 | Med:110\n\n# Mexico\nFire:060 | Pol:080 | Med:060\n\n# Nicaragua\nFire:2650162 | Pol:118 | Med:2651761\n\n# Panama\nFire:103 | Pol:104 | Med:2699778\n\n# Saint Kitts and Nevis\nFire:911 | Pol:911 | Med:911\n\n# Saint Lucia\nFire:911 | Pol:999 | Med:911\n\n# Saint Pierre and Miquelon\nFire:18 | Pol:17 | Med:15\n\n# Saint Vincent and Grenadines\nFire:911 | Pol:911 | Med:911\n\n# Trinidad and Tobago\nFire:990 | Pol:999 | Med:990");
			stringOceania = new StringItem("Oceania", "\n\n# Australia\nFire:000 or 112 mobile | Pol:000 or 112 mobile | Med:000 or 112 mobile\n\n# Fiji\nFire:9170 | Pol:911 | Med:911\n\n# Kiribati\nFire:local numbers | Pol:local numbers | Med:994\n\n# Marshall Islands\nFire:local numbers | Pol:6258666 | Med:6254111 \n\n# Micronesia\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Nauru\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# New Zealand\nFire:111 | Pol:111 | Med:111\n\n# Palau\nFire:911 | Pol:911 | Med:911\n\n# Papua New Guinea\nFire:110 | Pol:000 | Med:local numbers\n\n# Samoa\nFire:994 | Pol:995 | Med:996\n\n# Solomon Islands\nFire:911 | Pol:911 | Med:911\n\n# Tonga\nFire:999 | Pol:922 | Med:933\n\n# Tuvalu\nFire:911 | Pol:911 | Med:911\n\n# Vanuatu\nFire:112 | Pol:112 | Med:112");
			stringSouthamerica = new StringItem("South America", "\n\n# Argentina\nFire:100 | Pol:101 | Med:107\n\n# Bolivia\nFire:911 | Pol:911 | Med:911\n\n# Brazil\nFire:193 | Pol:190 | Med:192\n\n# Chile\nFire:132 | Pol:133 | Med:131\n\n# Colombia\nFire:119 | Pol:119 | Med:119\n\n# Ecuador\nFire:102 | Pol:101 | Med:131\n\n# Guyana\nFire:912 | Pol:911 | Med:913\n\n# Paraguay\nFire:911 | Pol:911 | Med:911\n\n# Peru\nFire:116 | Pol:105 | Med:116\n\n# Suriname\nFire:115 | Pol:115 | Med:115\n\n# Uruguay\nFire:911 | Pol:911 | Med:911\n\n# Venezuela\nFire:171 | Pol:171 | Med:171");
			
			this.menu = new List("First Aid 3.0", Choice.IMPLICIT);
			this.menu.append("- Disclaimer + Info -", null); // 0
			this.menu.append("- Emergency Calls -", null); // 1 
			this.menu.append("- General Conduct -", null); // 2
			this.menu.append("Allergic Reaction", null); // 3
			this.menu.append("Amputation", null); // 4
			this.menu.append("Animal bite", null); // 
			this.menu.append("Apnoea", null); // 
			this.menu.append("Asthma", null); // 
			this.menu.append("Back Injury", null); // 
			this.menu.append("Birth", null); // ,,,
			this.menu.append("Bleeding (light)", null); // 
			this.menu.append("Bleeding (severe)", null); // 
			this.menu.append("Brain Concussion", null); // 11
			this.menu.append("Breathing", null); // 12
			//Breathlessness
			this.menu.append("Burning (slight)", null); // 13
			this.menu.append("Burning (severe)", null); // 14
			this.menu.append("Check Breathing", null); // 15
			this.menu.append("Chemical Burn (Eyes)", null); // 16
			this.menu.append("Chemical Burn", null); // 17
			this.menu.append("Chest Compression", null); // 18
			this.menu.append("Danger Zone", null); // 19
			this.menu.append("Diabetic Coma", null); // 20
			this.menu.append("Diarrhoea", null); // 21
			this.menu.append("Drowning", null); // 22
			this.menu.append("Electricity Accident", null); // 23
			this.menu.append("Emergency Call", null); // 24
			this.menu.append("Epilepsy", null); // 25
			this.menu.append("Eye Injury", null); // 26
			this.menu.append("Fracture", null); // 27
			this.menu.append("Frostbite (mild)", null); // 28
			this.menu.append("Frostbite (severe)", null); // 29
			this.menu.append("Heart Attack", null); // 30
			this.menu.append("Hyperglycaemia (sugar)", null); // 31
			this.menu.append("Hypoglycaemia (low sugar)", null); // 32
			this.menu.append("Hyperthermia (hot body)", null); // 33
			this.menu.append("Hypothermia (cool body)", null); // 34
			this.menu.append("Ice Rescue", null); // 35
			this.menu.append("Insect stings", null); // 36
			this.menu.append("Nosebleeding", null); // 37
			this.menu.append("Poisoning", null); // 38
			this.menu.append("Reanimation", null); // 39
			this.menu.append("Recovery Position", null); // 40 
			this.menu.append("Resuscitation", null); // 41
			this.menu.append("Safeguard Accident", null); // 42 
			this.menu.append("Shock", null); // 43
			this.menu.append("Skull fracture", null); // 44 
			this.menu.append("Snakebite", null); // 45
			this.menu.append("SOS", null); // 46
			this.menu.append("Spinal fracture", null); // 47 
			this.menu.append("Sprain + Strain", null); // 48
			this.menu.append("Stroke", null); // 49
			this.menu.append("Suffocation (Choking)", null); // 50 
			this.menu.append("Sunburn", null); // 51
			this.menu.append("Sunstroke", null); // 52
			this.menu.append("Swallow/Choking", null); // 53
			this.menu.append("Traffic Accident", null); // 54
			this.menu.append("Unconsciousness with breathing", null); // 55
			this.menu.append("Unconsciousness without breathing", null); // 56
			this.menu.append("Vomiting", null); // 57
			this.menu.append("-------------", null); // 58

			menu.addCommand(cmdExit);
			menu.setCommandListener(this);

			// First-Aid-Text
			aid_disclaimer = new StringItem ("Disclaimer + Info", "\n\n1. Software\nFirst Aid on your Mobile\nVersion: j3.0\nRelease: 2008-12-24\nCopyright: Kai Kajus Noack\nLicence: Creative Commons BY-NC-ND\n\nFirst Aid Illustrations © Med4Teens\n\nThis program is supposed to give information on first aid. However, it does not represent a substitute to a first aid course. It rather serves you refreshing your already acquired knowledge.\n\n2. Disclaimer\nPlease note that I take no responsibility for consequences resulting from the use of the software.\nANY LIABILITY IS EXCLUDED!\nUSE AT YOUR OWN RISK!\n\nIn all emergencies, please seek professional help immediately.\n\n3. Project Development\nThe program is supposed to become multilingual. Voluntary Translators needed!!\n\nFurther information is available on the Internet www.firstai.de or write an email to: info@firstai.de\n\nTo save one life is to have saved the world.");aid_general = new StringItem ("General Conduct", "\n\n1. Always perform first aid. You cannot make any mistakes.\n2. Always pay attention to your own safety.\n3. Examine the situation and secure the accident place.\n4. Emergency call + First Aid measures!\n5. If there are several casualties, the treatment of the most harmed has priority.\n6. Always try to calm down the person concerned. Stay calm yourself!\n7. If possible lay her/him down comfortably. Never give alcohol, nicotine or drugs to a person who is the victim of an accident.");aid_allergic = new StringItem ("Allergic Reaction", "\n\n1. Phone for an ambulance immediately.\n2. Try to calm down the casualty and let him sit comfortable.\n3. Remove allergic causing matter (e.g. sting of a bee) carefully.\n4. Cool affected skin (wet compress, ice).\n5. If casualty has an antidote, he should use it (help him).\n6. Monitor casualty's condition until ambulance arrives.\n7. If casualty loses consciousness or breathing stops, follow appropriate instructions!");aid_animalbite = new StringItem ("Animal bite", "\n\nAttention: High danger of infection. Result could be infection, tetanus, rabies.\n1. Wash wound with hot soapy water.\n2. Afterwards disinfect the wound.\n3. If there is severe bleeding, elevate the person's upper body.\n4. Apply an aseptic bandage.\n5. Go to a hospital or call emergency doctor.");aid_apnoea = new StringItem ("Apnoea", "\n\nNo breathing sounds or breath movements, noticeable discolouration of the skin.\n1. Emergency call.\n2. Lay casualty on his/her back.\n3. Remove any substances from the mouth and throat. Stretch head backwards.\n4. Pinch the nose, so that nose is closed.\n5. Take a deep breath and put your mouth onto the mouth of the casualty, that no air can leak.\n6. Breath out slowly and fully.\n7. If without success: Do breathing as long as ambulance arrives.");aid_asthma = new StringItem ("Asthma", "\n\nHeavy breathlessness. Wheezing respiratory noise. Anxieties.\n1. Calm the person. Stay calm yourself!\n2. Loosen clothing.\n3. Let casualty sit and lean forward, encourage him/her to breath slowly and deeply.\n4. If casualty has an inhalator, he should use it (help him). After 5-10 min it should take effect.\n5. If there is no improvement: Use inhalator every 5 min until ambulance arrives.\n6. Emergency call.\n7. If apnoea (cessation of breathing) occurs, follow instructions given for apnoea.");aid_backinjury = new StringItem ("Back Injury", "\n\nPain in the back, numb arms and legs.\n1. Do not move the casualty!!\n2. Hold the head so that the person lies still (keep their head stationary)\n3. Stabilize the casualty with bolsters on either side.\n4. Calm the person.\n5. Emergency call, point out the back injury.");aid_birth = new StringItem ("Birth", "\n\nOutflow of amniotic fluid. Contraction pains occur. Unexpected birth.\n1. Pay attention to privacy and keep calm! - Emergency call.\n2. Let the pregnant woman bare the lower part of her body, and sit down on a sterile underlay with spread legs.\n3. Angle the knees. Pull up the legs. Position the basin slightly upward. - Birth is a natural process and runs mostly without complications.\n4. Calm the woman, let her concentrate on her breathing: Breathe in through nose, breathe out through mouth (in normal speed).\n5. Rhythm of pressing: Take a deep breath, hold breath, and press. As soon as the baby's head appears, support by taking hold of it with both of your hands.\n6. After the childbirth: Hold the baby on a slant with head down to liberate the airways from amniotic fluid. (You may have to suck out the fluid from the baby's nose by mouth.) The baby must breathe and cry!\n7. Bind off the umbilical cord 30 cm away from the child (can also be done in hospital). Keep the vagina of the mother sterile.\n8. Dry the baby and keep it warm. Note the time and drive to the hospital.");aid_bleedinglight = new StringItem ("Bleeding (light)", "\n\nGoal: Stop the bleeding.\n1. Do not touch the wound (danger of infection).\n2. Do not treat wound with powder, salves or sprays.\n3. Wound treatment: cover with sterile material and a bandage.\n4. For slight bleeding a plaster is often sufficient.\n5. If wound is large-scale, use a wound cover and a bandage. Do not apply bandage too tight, as a stasis can lead to increased bleeding.\n6. Note: Wounds as a result of the bite from a rabid animal have to be washed with soapy solution.");aid_bleedingsevere = new StringItem ("Bleeding (severe)", "\n\nSplashing, pulsating blood. Danger: Choking because of blood loss, infections, death. Goal: Stop the bleeding.\n1. Remove clothes (cut if necessary) and reveal wound.\n2. Wrap a bandage or, if necessary, a garment with pressure around the wound.\n3. Exert pressure for at least 10 min.\n4. If bandage is soaked with blood, do not remove it. Instead wrap another bandage/garment around it.\n5. Place the affected limb (if not broken) higher than the heart to reduce amount of blood pressure. If possible lay down casualty.\n6. If bleeding does not stop, keep pressure on wound, and set additional pressure point on wound: For a bleeding of the forearm compress the upper arm (press vein at inner side of arm, in the middle of elbow and arm-pit, using your fingers). For bleeding of leg, set pressure point in groin (press vein at crook of groin, where artery leads over pelvic bone, using the ball of your hand).\n7. Call emergency doctor immediately.\n8. As soon as bleeding is under control: Initiate anti-shocking measures.");aid_brainconcussion = new StringItem ("Brain Concussion", "\n\nHeadache, nausea, vomiting. Impaired vision. Unconsciousness can occur.\n1. Lay down person concerned.\n2. Emergency call.\n\nIf bleeding from head:\n1. Lay down casualty, with the head elevated (on pillow).\n2. Do wound-treatment (use head-bandage).\n3. Emergency call.");aid_burningslight = new StringItem ("Burning (slight)", "\n\nRedness of skin. Mild swellings. Pain.\n1. Hold area involved under cool water.\n2. Apply wet bandage loosely.");aid_burningsevere = new StringItem ("Burning (severe)", "\n\nSpotted white-red areas, blistering. Skin loses fluid. Deep damage of tissue. Strong pain or no pain (because of burned nerves).\n1. Remove clothes as much as possible.\n2. Cool burned body parts with water (about 15°C, 59°F) up to 10 min, until pain reduces.\n3. If burning is extensive, just use wet cloths to cool.\n4. Emergency call.\n5. After cooling, do the wound treatment: Use a sterile dressing. Do not apply fluids (no creams, oils, ointments etc.). Do not pierce the blisters.\n6. Control breathing and consciousness of the person until emergency doctor arrives.");aid_checkbreathing = new StringItem ("Check Breathing", "\n\n1. Check breathing sounds.\n2. Diagnose breathing in the upper abdomen (lay your hand on it).\n3. Sense breathing at nose and mouth.");aid_chemicalburneyes = new StringItem ("Chemical Burn (Eyes)", "\n\n1. Emergency call, point out chemicals.\n2. Flush eye with much water. Cover healthy eye during flushing.\n3. Lead the water jet from inner angle of eye to outer angle of eye. Clean for at least 20 min under clear water.\n4. Close both eyes of the casualty and bind with wet cloth.\n5. Monitor condition until ambulance arrives.");aid_chemicalburn = new StringItem ("Chemical Burn", "\n\nInjury of tissue.\n1. Mind self-protection!\n2. Act quickly and wash the burned locations.\n3. Emergency call.\n4. If there is a chemical burn of the digestive tract, particularly the mouth and throat, drink a lot of water.\n5. Do not cause vomiting!");aid_dangerzone = new StringItem ("Danger Zone (Rescue)", "\n\n1. Grip execution: Position one arm of the injured in front of his/her chest, and get behind him/her.\n2. Put your hands under the shoulders of the wounded, grabbing the angled arm.\n3. Pull back and carry the person into safety.");aid_diabeticcoma = new StringItem ("Diabetic Coma", "\n\nBlood sugar level is too high (resp. lack of insulin).\nSymptoms: Thirst, frequent urination, nausea, vomit. Breath smells of fruits/wine.\n1. Call emergency.\n2. Support casualty (if confirmed as diabetic) taking insulin.\n3. Recovery position. (No further possibilities for the first aider.)\n4. Monitor the condition of the casualty until emergency doctor arrives.");aid_diarrhoea = new StringItem ("Diarrhoea", "\n\nReaction to contaminated food, infection of intestine or disorder. Stool is diluted, slimy or bloody.\n1. Danger for the circulation because of dehydration and loss of salt!\n2. Give liquids (tea, water).\n3. If there are strong disorders call the emergency doctor.");aid_drowning = new StringItem ("Drowning", "\n\n1. Call emergency. Ask people next to you for help.\n2. Rescue person out of water!\n3. If casualty is breathing: Recovery position. Keep him/her warm (cover). Monitor condition until emergency doctor arrives.\n4. If casualty is not breathing: Immediately start with resuscitation! (Ejecting water from the lungs is useless.)");aid_electricityaccident = new StringItem ("Electricity Accident", "\n\n1. Firstly interrupt the electricity supply!\nDanger: Unconsciousness, apnoea.\n2. A - Unconsciousness with breathing\n3. B - Unconsciousness without breathing");aid_emergencycall = new StringItem ("Emergency Call", "\n\nDial 112 with the next available phone (USA: 911). Always possible and for free! Do not hesitate to call for an ambulance!\nOn the phone you must provide the following information: \n- What has happened \n- Where (accident place) \n- How many casualties \n- What kind of injuries.\nAfterwards wait for further instructions or queries.");aid_epilepsy = new StringItem ("Epilepsy", "\n\nRigid body, clenched fists, pressed jaw, twitching in limbs or face. Rolling eyes. Salivation. Unconsciousness possible.\n1. Do not hold the casualty or restrain their movement.\n2. Lay the casualty on a soft base (cushion), remove close objects to prevent self-injury.\n3. Calm down the casualty. Loosen clothing, provide freedom to breath.\n4. If casualty vomits, turn their head to the side so that vomit can drain.\n5. Keep airways clear. Danger of swallowing the tongue.\n6. Recovery Position + Emergency call. Continue monitoring the casualty's condition.\n7. Keep other people at distance.");aid_eyeinjury = new StringItem ("Eye Injury", "\n\n1. Leave object in the eye of casualty, do not remove it.\n2. Keep eyes motionless to avoid further injuries. Do not touch the eye.\n3. If eye is bleeding, cover it with a compress or a sterile gauze.\n4. Cool the eye with a cold pad (reduces swelling, bleeding stops quicker).\n5. Emergency call or drive casualty to hospital yourself.");aid_fracture = new StringItem ("Fracture", "\n\nSymptoms: Unnatural position and movability of bone. Deformation. Painful movement, touch-sensitive.\n1. Avoid movements!\n2. Emergency call.\n3. Immobilize the fractured bone, i.e. bolster material around bone tightly. Keep position of the bone.\n4. If fracture is open, cover the wound with sterile material.");aid_frostbitemild = new StringItem ("Frostbite (mild)", "\n\nPaleness, swellings. Danger for blood supply.\n1. Move casualty into a warm area.\n2. Get away from cold, remove cold clothes, dry person.\n3. Warm up with lukewarm water and with body heat of the helper.\n4. Give warm drink (tea). No alcohol!");aid_frostbitesevere = new StringItem ("Frostbite (severe)", "\n\nCold hard skin, grey-white, blistering, tissue dies off. Danger for blood supply!\n1. Go to warm area.\n2. Wound treatment/covering.\n3. Give a sugary drink.\n4. Do not rub the casualty to warm them!\n5. Emergency call.");aid_heartattack = new StringItem ("Heart Attack", "\n\nHeavy, more than 5 min lasting pressure and pain in the chest, particularly radiating in the arms/shoulders. Anxiety, paleness, cold sweat. Possibly nausea, shortness of breath.\n1. Emergency call! Point out the supposed heart attack.\n2. Position with the upper body elevated. Loosen tight clothing. Do not give drugs or drinks.\n3. Talk calmly to the person concerned.\n4. Control consciousness and breathing.\n5. Give aspirin if available.\n6. If person becomes unconscious, start resuscitation.");aid_hypoglycaemia = new StringItem ("Hypoglycaemia (low sugar)", "\n\nBlood sugar level is below minimum value (because of overdose of insulin or insufficient intake of food).\nSymptoms: Paleness, nervousness, hunger, shivering, sweating.\n1. Make sure that the person is a diabetic (look for a diabetic badge).\n2. Emergency call.\n3. Give a sugary drink and dextrose/glucose (if there are no problems in swallowing).\n4. If person is conscious and breathing: Recovery position. Monitor breathing of the person. If apnoea appears, start with breath giving.\n5. If there is breathing, you can put a lump of sugar into the cheek pouch, push from outside against it.");aid_hyperthermia = new StringItem ("Hyperthermia (hot body)", "\n\nThirst, weakness, disorientation, nausea, confusion, strong sweating, hot skin.\n1. Emergency call.\n2. Find a cool shady place (room with air conditioning preferable).\n3. Lay down person, elevate legs. Loosen clothing.\n4. Cool skin with cold water or lay on cold towels.\n5. Give plenty of water or juices to drink.");aid_hypothermia = new StringItem ("Hypothermia (cool body)", "\n\nCold shiver, drowsiness, exhaustion up to unconsciousness. Cold pale skin. Slow pulse, weak heartbeat.\n1. Go to a warm area/room.\n2. Call emergency.\n3. Increase body temperature (cover and body-to-body-contact).\n4. Remove wet clothes and put on warm clothes. Cover with blankets or other covers. Cover the head.\n5. Give hot tea, soup or hot water to drink. No alcohol! Keep person awake.\n6. Monitor casualty's condition until emergency doctor arrives. If person becomes unconscious, initiate resuscitation:\n7. A - Unconsciousness with breathing\n8. B - Unconsciousness without breathing");aid_icerescue = new StringItem ("Ice Rescue", "\n\nPay attention to your own safety. Danger: Drowning, Hypothermia.\n1. Ask other people for help. Call for an emergency ambulance.\n2. Rescue via ladder, board or bar. Weight must be distributed evenly.\n3. Crawl carefully on your front along the support (if possible roped to a stable point) with a pole or similar tool.\n4. Reach to the person with the pole or other tool (not your hand!), encourage him/her to take hold of it and pull him/her out.\n5. Crawl backwards back to the edge.\n6. First-Aid measures.\n7. Self-rescue possible: If ice is solid, you can distribute your weight on the ice and pull yourself out. Crawl flat on your front to the edge. If ice is fragile, try to break the ice piece by piece up to the edge.");aid_insectstings = new StringItem ("Insect stings", "\n\nSwelling, skin rash, burning feeling, weakness, difficult breathing, decreased consciousness, tachycardia.\n1. Remove sting carefully (with a tweezer). Do not squeeze the sting as this could inject more venom.\n2. Cool concerned spot (apply a cold compress).\n3. Concerned area should be kept lower than the heart to slow circulation of the venom.\n4. If stung in mouth/jaw area: Suck ice-cream, and apply a cold compress around throat.\n5. If severe problems, notably difficulty in breathing or decreased consciousness, occur, call an ambulance immediately.");aid_nosebleeding = new StringItem ("Nosebleeding", "\n\nBurst small artery in the nose.\n1. Sit the person down, leaning slightly forward. Keep head straight.\n2. Do not position the person flat, as head over height of heart slows down bleeding.\n3. Place cooling material round neck (wet cloth).\n4. Pinch nostrils together until bleeding stops (for 10 min).\n5. Afterwards do not strain the nose (no snorting).\n6. If severe problems occur or bleeding cannot be stopped, call emergency doctor.");aid_poisining = new StringItem ("Poisoning", "\n\nConfusion, hallucinations, enlarged pupils, fever, cramps. Unconsciousness.\n1. Only give antidotes if you are accompanied by a trained medic.\n2. Do not give drinks. Do not cause vomiting.\n3. Emergency call + point out the poisoning!\n4. Safeguard rest of poison and the vomit!\n5. If casualty is conscious and breathing: Recovery position. Monitor condition until emergency doctor arrives.\n6. If casualty is not breathing: Immediately start with resuscitation! Free mouth from vomit beforehand.");aid_recoveryposition = new StringItem ("Recovery Position", "\n\n1. Lay casualty on her/his back, straighten legs. Knee beside him/her.\n2. Place arm nearest to you at a right angle to the body.\n3. Pull arm furthest from you across the chest and place the back of the hand against cheek.\n4. Get the far knee, pull it to your side, and lay it on the ground. Position the leg at a right angle. Keep casualty's hand under the cheek of the person.\n5. Make sure the airways are free.\n6. Open mouth slightly, and position the head to the side so that vomit can drain. Check breathing.\n7. Control the casualty's condition until the emergency doctor arrives.");aid_resuscitation = new StringItem ("Resuscitation", "\n\n# Heart Massage\n1. Lay casualty on his/her back. Kneel beside person.\n2. Bare the chest.\n3. Place the heel of the hand in the middle of the chest (just over sternum).\n4. Place other hand on the back of the hand which is already in position.\n5. Extend your arms and elbows.\n6. Press 5 cm deep into the person's chest (power comes from upper part of the body) and release.\n7. Push 30 times in a row shortly and strongly!\n\n# Breathing\n1. Remove any substances out of mouth and throat. Stretch head backwards.\n2. Pinch the nose together, so that nose is closed.\n3. Take a deep breath and put your mouth onto the mouth of the casualty, that no air can leak.\n4. Do mouth-to-mouth breathing two times (breath out slowly and fully).\n5. Afterwards do heart massage again.\n\nRepeat heart massage + mouth-breathing until the emergency doctor arrives.");aid_safeguardaccident = new StringItem ("Safeguard Accident", "\n\n1. Stop your own car 50-100 m behind the accident site (if you are on a highway or country road). Switch on warning lights. Put on high visibility vest.\n2. Position the warning triangle before the accident site. Attention: If accident is on a curve position the warning triangle before the curve!\n3. Ask other people for their help.\n4. Open the door of the accident car (if jammed, prise it open using a car jack). Turn off ignition.\n5. Rescue the accident victim: Unstrap seat-belt, move seat backwards. Free the casualty out of the car by rescue grip.\n6. Emergency call.\n7. Proceed with first aid measures.");aid_shock = new StringItem ("Shock", "\n\nCirculatory disorder by poor oxygen supply in the body.\nCause: Loss of fluid, reduced blood volume.\nSymptoms: Paleness, cold skin, cold sweat, anxiety.\n1. Eliminate the cause of the shock (e.g. stop the fluid loss, bind the wound)!\n2. Lay the wounded person on a blanket, raising the legs. Calm the person.\n3. Emergency call.\n4. If difficulties in breathing or consciousness, initiate resuscitation.");aid_skullfracture = new StringItem ("Skull fracture", "\n\nLight bleeding from nose, mouth or ear. Often open wounds on skull.\n1. Keep the airways free.\n2. If conscious: Let the injured sit with head bowed forwards. Avoid further movements!\n3. If unconscious: Recovery position (no pressure on wound of head).\n4. Emergency call.\n5. Apply head bandage.\n6. If difficulties in breathing or consciousness, initiate resuscitation.");aid_snakebite = new StringItem ("Snakebite", "\n\nPuncture wound the size of a pin, severe pains, swelling, purple colour. Circulatory disturbance, danger of shock.\n1. Steady the wounded part of the body.\n2. Apply cold material around bite wound.\n3. Take measures against shock.\n4. Emergency call.");aid_sos = new StringItem ("SOS", "\n\n1. Signal: 3x short, 3x long, 3x short.\n2. Optically (strobe light, flashlight), or acoustically (signal whistle, knocking).");aid_sprain = new StringItem ("Sprain + Strain", "\n\nPain, swelling (bruise), loss of function, deformation of the limb.\n1. Place the injured part of the body in the position most comfortable for the casualty.\n2. Cool (using ice packs).\n3. If possible, position the injured part elevated.\n4. Go to hospital or call emergency doctor.");aid_stroke = new StringItem ("Stroke", "\n\nSudden feeling of paralysis or numbness (face, arm, leg), disturbances in language understanding, vision problems, disturbed consciousness, severe headache. Problems in breathing and swallowing, loss of control over bladder and intestine.\n1. Emergency call!\n2. Loosen tight clothing. Do not give drugs or drinks.\n3. Sit or lay down person concerned comfortably. Calm him/her!\n4. Control consciousness and breathing.\n5. If difficulties in breathing or consciousness, initiate resuscitation.");aid_suffocation = new StringItem ("Suffocation (Choking)", "\n\nInsufficient oxygen supply. Trachea closed. Danger: Apnoea.\nSymptoms: Wheezing respiratory noise, cough stimulus, shortness of breath, skin discolouration.\n1. Immediate action! Let the person concerned cough very strongly.\n2. Strike strongly with a flat hand on the back between the shoulder blades (lay babies on your forearm, with head down).\n3. If without success: Stand behind person, arms around waist, bow slightly forward.\n4. Clench your fist, position it at height of person's stomach, and take it with your other hand.\n5. In embrace use both hands to give a hard blow upwards towards stomach (as if you would try to lift the person).\n6. Repeat this up to 5 times! Airways should get free from object.\n7. Emergency call.\n8. If first aid measure is unsuccessful at first, keep on doing it until emergency doctor arrives.");aid_sunburn = new StringItem ("Sunburn", "\n\n1. Remove affected person from direct sunlight. Avoid further sun.\n2. Drink much water to stop dehydration.\n3. If there is a serious sunburn (blisters, redness, pain), seek medical advice.\n4. If the skin is just lightly red, it can be cooled with wet compresses. Use after-sun lotion or gel.");aid_sunstroke = new StringItem ("Sunstroke", "\n\nHot red head, cool skin, sickness, headache, dizziness. Cause: Irritation of the cerebral membrane.\n1. Go to a cool place (shadow) and position the upper body of the person up.\n2. Cool the head with wet blankets.\n3. Emergency call, keep controlling the breathing.\n4. If conscious: Give cool drink if applicable.\n5. If apnoea appears, start with breathing:\n6. Go on with Breath Giving!");aid_unconsciouswithbreath = new StringItem ("Unconsciousness with breathing", "\n\nNo reaction on loudly asking, no response on shaking. Breathing does exist.\n1. If there are people next to you ask for help.\n2. Recovery position. Open mouth and position head this way that vomit can drain.\n3. Emergency call.");aid_unconsciouswithoutbreath = new StringItem ("Unconsciousness without breathing", "\n\n1. No reaction of casualty, no breathing.\n\nInitiate Resuscitation.");aid_vomiting = new StringItem ("Vomiting", "\n\nArises from nausea. Stomach empties itself. Causes: Infection, poisoning, ulcer, drugs, bad food, pregnancy.\n1. Danger for the circulation because of dehydration and loss of salt!\n2. Give liquids (tea, water).\n3. If there are strong disorders, bloody or continuous vomiting, call the emergency doctor. ");
			aid_amputation = new StringItem ("Amputation", "\n\nAmputated body part can be reattached again. Goal: Keep amputated part cool until you arrive at hospital. \n1. Calm the person, lay him/her down, and cover with blanket.\n2. Stop the bleeding, see 'Bleeding (severe)' and 'Shock'.\n3. Wrap amputated part in a clean and dry cloth, and put it into a waterproof plastic bag. \n4. Close this plastic bag and put it into another plastic bag, that contains cool water/ice.\n5. Do not give alcohol, cigarettes or food to casualty (in case of a surgery with anaesthesia in hospital).\n6. Do not freeze the amputated part (just keep it cool).\n7. Call emergency or drive casualty to hospital yourself.");
		
			
			// set display, show menu:
			display = Display.getDisplay(this);
			display.setCurrent(menu);
			
			// set command + listener for form:
			formTextHolder.addCommand(cmdBack);
			formTextHolder.setCommandListener(this);

			// application has started
			started = true;
		}
	}

	public void applyText(int auswahl) {
		// clear form
		formTextHolder.deleteAll();
		
		if (auswahl == 0) { formTextHolder.append(aid_disclaimer); }
		else if (auswahl == 2) { formTextHolder.append(aid_general); }
		else if (auswahl == 3) { formTextHolder.append(aid_allergic); }
		else if (auswahl == 4) { formTextHolder.append(aid_amputation); }
		else if (auswahl == 5) { formTextHolder.append(aid_animalbite); } 
		else if (auswahl == 6) { formTextHolder.append(aid_apnoea); } 
		else if (auswahl == 7) { formTextHolder.append(aid_asthma); }
		else if (auswahl == 8) { formTextHolder.append(aid_backinjury); }
		else if (auswahl == 9) { formTextHolder.append(aid_birth); }
		else if (auswahl == 10) { formTextHolder.append(aid_bleedinglight); } 
		else if (auswahl == 11) { formTextHolder.append(aid_bleedingsevere); }
		else if (auswahl == 12) { formTextHolder.append(aid_brainconcussion); } 
		else if (auswahl == 13) { formTextHolder.append(aid_apnoea); }
		else if (auswahl == 14) { formTextHolder.append(aid_burningslight); }
		else if (auswahl == 15) { formTextHolder.append(aid_burningsevere); }
		else if (auswahl == 16) { formTextHolder.append(aid_checkbreathing); }
		else if (auswahl == 17) { formTextHolder.append(aid_chemicalburneyes); }
		else if (auswahl == 18) { formTextHolder.append(aid_chemicalburn); } 
		else if (auswahl == 19) { formTextHolder.append(aid_resuscitation); }
		else if (auswahl == 20) { formTextHolder.append(aid_dangerzone); }
		else if (auswahl == 21) { formTextHolder.append(aid_diabeticcoma); }
		else if (auswahl == 22) { formTextHolder.append(aid_diarrhoea); }
		else if (auswahl == 23) { formTextHolder.append(aid_drowning); formTextHolder.append(aid_resuscitation); } 
		else if (auswahl == 24) { formTextHolder.append(aid_electricityaccident); formTextHolder.append(aid_unconsciouswithbreath); formTextHolder.append(aid_unconsciouswithoutbreath); formTextHolder.append(aid_resuscitation); }
		else if (auswahl == 25) { formTextHolder.append(aid_emergencycall); }
		else if (auswahl == 26) { formTextHolder.append(aid_epilepsy); }
		else if (auswahl == 27) { formTextHolder.append(aid_eyeinjury); }
		else if (auswahl == 28) { formTextHolder.append(aid_fracture); } 
		else if (auswahl == 29) { formTextHolder.append(aid_frostbitemild); } 
		else if (auswahl == 30) { formTextHolder.append(aid_frostbitesevere); } 
		else if (auswahl == 31) { formTextHolder.append(aid_heartattack); formTextHolder.append(aid_resuscitation); }
		else if (auswahl == 32) { formTextHolder.append(aid_diabeticcoma); }
		else if (auswahl == 33) { formTextHolder.append(aid_hypoglycaemia); }
		else if (auswahl == 34) { formTextHolder.append(aid_hyperthermia); }
		else if (auswahl == 35) { formTextHolder.append(aid_hypothermia); } 
		else if (auswahl == 36) { formTextHolder.append(aid_icerescue); } 
		else if (auswahl == 37) { formTextHolder.append(aid_insectstings); }
		else if (auswahl == 38) { formTextHolder.append(aid_nosebleeding); }
		else if (auswahl == 39) { formTextHolder.append(aid_poisining); formTextHolder.append(aid_resuscitation); }
		else if (auswahl == 40) { formTextHolder.append(aid_resuscitation); }
		else if (auswahl == 41) { formTextHolder.append(aid_recoveryposition); }
		else if (auswahl == 42) { formTextHolder.append(aid_resuscitation); }
		else if (auswahl == 43) { formTextHolder.append(aid_safeguardaccident); }
		else if (auswahl == 44) { formTextHolder.append(aid_shock); formTextHolder.append(aid_resuscitation); }
		else if (auswahl == 45) { formTextHolder.append(aid_skullfracture); formTextHolder.append(aid_resuscitation); }
		else if (auswahl == 46) { formTextHolder.append(aid_snakebite); } 
		else if (auswahl == 47) { formTextHolder.append(aid_sos); } 
		else if (auswahl == 48) { formTextHolder.append(aid_backinjury); } 
		else if (auswahl == 49) { formTextHolder.append(aid_sprain); } 
		// formTextHolder.append(bwlosMitAtmung); formTextHolder.append(bwlosOhneAtmung); formTextHolder.append(herzReaniWiederbel); }
		else if (auswahl == 50) { formTextHolder.append(aid_stroke); formTextHolder.append(aid_resuscitation); }
		else if (auswahl == 51) { formTextHolder.append(aid_suffocation); }
		else if (auswahl == 52) { formTextHolder.append(aid_sunburn); }
		else if (auswahl == 53) { formTextHolder.append(aid_sunstroke); formTextHolder.append(aid_apnoea); }
		else if (auswahl == 54) { formTextHolder.append(aid_suffocation); }
		else if (auswahl == 55) { formTextHolder.append(aid_safeguardaccident); }
		else if (auswahl == 56) { formTextHolder.append(aid_unconsciouswithbreath); }
		else if (auswahl == 57) { formTextHolder.append(aid_unconsciouswithoutbreath); formTextHolder.append(aid_resuscitation); }
		else if (auswahl == 58) { formTextHolder.append(aid_vomiting); } 
	}

	public void pauseApp() {
		//display = null;
		//menu = null;
	}

	public void destroyApp(boolean unconditional) {
		notifyDestroyed();
	}

	public void commandAction(Command c, Displayable d) {
		//	String label = c.getLabel();
		if(c.getCommandType() == Command.BACK) {
			display.setCurrent(menu);
		}
		else if (c.getCommandType() == Command.EXIT) {
			notifyDestroyed();
		}
		// Country Emergency Menu
		else if (display.getCurrent().getTitle() == telEmergency.getTitle()) {
			formTextHolder.deleteAll();
			if (telEmergency.getSelectedIndex() == 0) { formTextHolder.append(stringAfrica); } 
			else if (telEmergency.getSelectedIndex() == 1) { formTextHolder.append(stringAsia); }
			else if (telEmergency.getSelectedIndex() == 2) { formTextHolder.append(stringEurope); }
			else if (telEmergency.getSelectedIndex() == 3) { formTextHolder.append(stringNorthamerica); }
			else if (telEmergency.getSelectedIndex() == 4) { formTextHolder.append(stringOceania); }
			else if (telEmergency.getSelectedIndex() == 5) { formTextHolder.append(stringSouthamerica); }
			display.setCurrent(formTextHolder);
		}
		// Main Menu
		else if (display.getCurrent().getTitle() == menu.getTitle()) {
			if (menu.getSelectedIndex() == 1) { 
				display = Display.getDisplay(this);
				display.setCurrent(telEmergency);
			}
			// catch divider
			else if (menu.getSelectedIndex() == 59) { }
			else {
				// apply text to form and show it
				applyText(menu.getSelectedIndex());
				display = Display.getDisplay(this);
				display.setCurrent(formTextHolder);
			}
		}
	}
}
