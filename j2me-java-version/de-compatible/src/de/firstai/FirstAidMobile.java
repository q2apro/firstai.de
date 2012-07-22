// Erste.Hilfe.3.0.compatible
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
		static final Command cmdBack = new Command("Zurück", Command.BACK, 2);
		static final Command cmdExit = new Command("Exit", Command.EXIT, 2);

		StringItem softwareha;
		StringItem allgemeines;
		StringItem allergreakt;
		StringItem amputation; 
		StringItem asthma; 
		StringItem atemstillstand;
		StringItem atmungpruefen;
		StringItem augenverletzung;
		StringItem augenveraetzung;
		StringItem bwlosOhneAtmung;
		StringItem bwlosMitAtmung;
		StringItem blutungleicht;
		StringItem blutungschwer;
		StringItem diabetkoma;
		StringItem durchfall;
		StringItem eisunfall;
		StringItem elektrounfall;
		StringItem epileptanfall;
		StringItem erbrechen;
		StringItem erfrierleicht;
		StringItem erfrierstark;
		StringItem ersticken;
		StringItem ertrinken;
		StringItem geburt;
		StringItem gefahrenzone;
		StringItem gehirnerschuett;
		StringItem herzinfarkt;
		StringItem hitzschlag;
		StringItem insektenstich;
		StringItem knochenbruch;
		StringItem nasenbluten;
		StringItem notruf;
		StringItem schaedelbruch;
		StringItem schlaganfall;
		StringItem schlangenbiss;
		StringItem schock;
		StringItem sonnenbrand;
		StringItem sonnenstich;
		StringItem sos;
		StringItem stabileseitenlage;
		StringItem tierbiss;
		StringItem unterkuehlung;
		StringItem unterzuckerung;
		StringItem veraetzung;
		StringItem verbrennungLeicht;
		StringItem verbrennungSchwer;
		StringItem vergiftung;
		StringItem verkehrsunfall;
		StringItem verstauchung;
		StringItem wiederbelebung;
		StringItem wirbelsaeule;
		
		StringItem stringAfrica;
		StringItem stringAsia;
		StringItem stringEurope;
		StringItem stringNorthamerica;
		StringItem stringOceania;
		StringItem stringSouthamerica;
		
		public FirstAidMobile() {
			formTextHolder = new Form ("Erste Hilfe");
		}

		public void startApp() {
			
			if (!started) {
				telEmergency = new List ("Kontinent wählen", Choice.IMPLICIT);
				telEmergency.append("Afrika", null);
				telEmergency.append("Asien", null);
				telEmergency.append("Europa", null);
				telEmergency.append("Nord-/Zentralamerika", null);
				telEmergency.append("Ozeanien", null);
				telEmergency.append("Südamerika", null);
				telEmergency.addCommand(cmdBack);
				telEmergency.setCommandListener(this);
				
				stringAfrica = new StringItem("Afrika", "\n\n# Ägypten\nFeuer:180 | Pol:122 | Not:123\n\n# Algerien\nFeuer:14 | Pol:17 | Not:17\n\n# Angola\nFeuer:118 | Pol:110 | Not:118\n\n# Äquatorialguinea\nnur lokale Nummern\n\n# Äthiopien\nFeuer:93 | Pol:91 | Not:92\n\n# Benin\nFeuer:18 | Pol:17 | Not:301769\n\n# Botsuana\nFeuer:998 | Pol:999 | Not:997\n\n# Burkina Faso\nFeuer:18 | Pol:17 | Not:lokal\n\n# Burundi\nkein System\n\n# Dschibuti\nFeuer:18 | Pol:17 | Not:351351\n\n# Elfenbeinküste\nFeuer:180 | Pol:110 | Not:110\n\n# Eritrea\nnur lokale Nummern\n\n# Gabun\nFeuer:18 | Pol:1730 | Not:1300\n\n# Gambia\nFeuer:118 | Pol:117 | Not:116\n\n# Ghana\nFeuer:192 | Pol:191 | Not:193\n\n# Guinea\nnur lokale Nummern\n\n# Guinea-Bissau\nnur lokale Nummern\n\n# Kamerun\nFeuer:18 | Pol:17 | Not:lokal\n\n# Kap Verde\nFeuer:131 | Pol:132 | Not:130\n\n# Kenia\nFeuer:999 | Pol:999 | Not:999\n\n# Komoren\nnur Radiotelefon\n\n# Kongo (Demokrat. Republik)\nnur lokale Nummern\n\n# Kongo (Republik)\nnur lokale Nummern\n\n# Lesotho\nFeuer:122 | Pol:123 | Not:121\n\n# Liberia\nFeuer:911 | Pol:911 | Not:911\n\n# Libyen\nFeuer:193 | Pol:193 | Not:193\n\n# Madagaskar\nFeuer:18 | Pol:117 | Not:2262566\n\n# Malawi\nFeuer:199 | Pol:199 | Not:199\n\n# Mali\nFeuer:18 | Pol:17 | Not:15\n\n# Marokko\nFeuer:15 | Pol:19 | Not:15\n\n# Mauretanien\nFeuer:118 | Pol:117 | Not:lokal\n\n# Mauritius\nFeuer:999 | Pol:999 | Not:999\n\n# Mayotte\nFeuer:603054 | Pol:112 | Not:15\n\n# Mosambik\nFeuer:198 | Pol:119 | Not:117\n\n# Namibia\nFeuer:2032270 | Pol:1011 | Not:2032276\n\n# Niger\nFeuer:18 | Pol:17 | Not:723141\n\n# Nigeria\nFeuer:190 | Pol:119 | Not:199\n\n# Reunion\nFeuer:18 oder 112 mobil | Pol:17 oder 112 mobil | Not:15 oder 112 mobil\n\n# Ruanda\nFeuer:lokal | Pol:112 | Not:lokal\n\n# Sahara (Demokrat. Arab. Republik)\nunbekannt\n\n# Sambia\nFeuer | Pol | Not: 991 oder 112 mobil\n\n# Sao Tome und Principe\nunbekannt\n\n# Senegal\nFeuer:lokal | Pol:lokal | Not:8891515\n\n# Seychellen\nFeuer:999 | Pol:999 | Not:999\n\n# Sierra Leone\nFeuer:999 | Pol:999 | Not:999\n\n# Simbabwe\nFeuer:993 | Pol:995 | Not:994\n\n# Somalia\nnur lokale Nummern\n\n# Südafrika\nFeuer:10111 | Pol:10111 | Not:10177\n\n# Sudan\nFeuer:999 | Pol:999 | Not:lokal\n\n# Swasiland\nFeuer:lokal | Pol:999 | Not:6060911\n\n# Tansania\nFeuer:112 | Pol:112 | Not:112\n\n# Togo\nFeuer:118 | Pol:101 | Not:191\n\n# Tschad\nFeuer:18 | Pol:17 | Not:lokal\n\n# Tunesien\nFeuer:198 | Pol:197 | Not:190\n\n# Uganda\nFeuer | Pol | Not: 999 oder 111 mobil\n\n# Zentralafrikanische Republik\nFeuer:118 | Pol:611253 | Not:610600");
				stringAsia = new StringItem("Asien", "\n\n# Afghanistan\nFeuer:-- | Pol:-- | Not:112\n\n# Armenien\nFeuer:101 | Pol:102 | Not:103\n\n# Aserbaidschan\nFeuer:101 | Pol:102 | Not:103\n\n# Bahrain\nFeuer:999 | Pol:999 | Not:999\n\n# Bangladesch\nFeuer:9555555 | Pol:8665513 | Not:199\n\n# Bhutan\nFeuer:113 | Pol:110 | Not:112\n\n# Brunei\nFeuer:995 | Pol:993 | Not:991\n\n# China\nFeuer:119 | Pol:110 | Not:120\n\n# Georgien\nFeuer:022 | Pol:022 | Not:022\n\n# Hong Kong\nFeuer:999 | Pol:999 | Not:999\n\n# Indien\nFeuer:101 | Pol:100 | Not:102\n\n# Indonesien\nFeuer:113 | Pol:110 | Not:118\n\n# Irak\nkein System\n\n# Iran\nFeuer:125 oder 112 mobil | Pol:110 oder 112 mobil  | Not:115 oder 112 mobil\n\n# Israel\nFeuer:102 | Pol:100 | Not:101\n\n# Japan\nFeuer:119 | Pol:110 | Not:119\n\n# Jemen\nFeuer:199 | Pol:199 | Not:199\n\n# Jordanien\nFeuer:193 | Pol:192 | Not:193\n\n# Kambodscha\nFeuer:118 | Pol:117 | Not:199\n\n# Kasachstan\nFeuer:03 | Pol:03 | Not:03\n\n# Katar\nFeuer:999 | Pol:999 | Not:999\n\n# Kirgisistan\nFeuer:03 | Pol:133 | Not:03\n\n# Kurdistan\nFeuer:125 | Pol:129 | Not:115\n\n# Kuwait\nFeuer:777 | Pol:777 | Not:777\n\n# Laos\nFeuer:lokal | Pol:lokal | Not:03\n\n# Libanon\nFeuer:175 | Pol:112 | Not:140\n\n# Macao\nFeuer:999 | Pol:999 | Not:999\n\n# Malaysia\nFeuer | Pol | Not: 999 oder 112 mobil\n\n# Malediven\nFeuer:118 | Pol:119 | Not:102\n\n# Mongolei\nFeuer:101 | Pol:102 | Not:103\n\n# Myanmar\nFeuer:199 | Pol:199 | Not:199\n\n# Nepal\nFeuer:101 | Pol:100 | Not:228094\n\n# Nordkorea\nnur lokale Nummern\n\n# Oman\nFeuer:999 | Pol:999 | Not:999\n\n# Osttimor\nFeuer:-- | Pol:112 | Not:7233212\n\n# Pakistan\nFeuer:16 | Pol:15 | Not:115\n\n# Philippinen\nFeuer:117 | Pol:117 | Not:117\n\n# Saudi-Arabien\nFeuer:998 | Pol:999 | Not:997\n\n# Singapur\nFeuer:995 | Pol:999 | Not:995\n\n# Sri Lanka\nFeuer:111 | Pol:119 oder 112 mobil | Not:110\n\n# Südkorea\nFeuer:119 | Pol:112 | Not:119\n\n# Syrien\nFeuer:113 | Pol:112 | Not:110\n\n# Tadschikistan\nFeuer:lokal | Pol:02 | Not:03\n\n# Taiwan\nFeuer:119 | Pol:110 | Not:119\n\n# Thailand\nFeuer:199 | Pol:191 oder 1155 (Touristen) | Not:191\n\n# Turkmenistan\nFeuer:03 | Pol:03 | Not:03\n\n# Usbekistan\nFeuer:03 | Pol:03 | Not:03\n\n# Vereinigte Arabische Emirate\nFeuer:997 | Pol:999 | Not:998\n\n# Vietnam\nFeuer:114 | Pol:113 | Not:115");
				stringEurope = new StringItem("Europa", "\n\n# Albanien\nFeuer:18 | Pol:19 | Not:17\n\n# Andorra\nFeuer:118 | Pol:110 | Not:118\n\n# Belgien\nFeuer:112 | Pol:112 | Not:112\n\n# Bosnien und Herzegowina\nFeuer:123 | Pol:122 | Not:124\n\n# Bulgarien\nFeuer:112 | Pol:112 | Not:112\n\n# Dänemark\nFeuer:112 | Pol:112 | Not:112\n\n# Deutschland\nFeuer:112 | Pol:110 | Not:112\n\n# Estland\nFeuer:112 | Pol:112 | Not:112\n\n# Finnland\nFeuer:112 | Pol:112 | Not:112\n\n# Frankreich\nFeuer:18 oder 112 | Pol:17 oder 112 | Not:15 oder 112\n\n# Griechenland\nFeuer:112 | Pol:112 | Not:112\n\n# Großbritannien\nFeuer:112 | Pol:112 | Not:112\n\n# Irland\nFeuer:112 | Pol:112 | Not:112\n\n# Irland\nFeuer:112 | Pol:112 | Not:112\n\n# Island\nFeuer:112 | Pol:112 | Not:112\n\n# Italien\nFeuer:112 | Pol:112 | Not:112\n\n# Kosovo\nFeuer:911 | Pol:911 | Not:911\n\n# Kroatien\nFeuer:93 | Pol:92 | Not:94\n\n# Lettland\nFeuer:112 | Pol:112 | Not:112\n\n# Liechtenstein\nFeuer:112 | Pol:112 | Not:112\n\n# Litauen\nFeuer:112 | Pol:112 | Not:112\n\n# Luxemburg\nFeuer:112 | Pol:112 | Not:112\n\n# Malta\nFeuer:112 | Pol:112 | Not:112\n\n# Mazedonien\nFeuer:112 | Pol:112 | Not:112\n\n# Moldau (Moldawien)\nFeuer:901 | Pol:902 | Not:903\n\n# Monaco\nFeuer:112 | Pol:112 | Not:112\n\n# Montenegro\nFeuer:112 | Pol:112 | Not:112\n\n# Niederlande\nFeuer:112 | Pol:112 | Not:112\n\n# Norwegen\nFeuer:110 | Pol:112 | Not:113\n\n# Österreich\nFeuer:112 | Pol:112 | Not:112\n\n# Polen\nFeuer:112 | Pol:112 | Not:112\n\n# Portugal\nFeuer:112 | Pol:112 | Not:112\n\n# Rumänien\nFeuer:112 | Pol:112 | Not:112\n\n# Russland\nFeuer:01 | Pol:02 | Not:03\n\n# San Marino\nFeuer:116 | Pol:112 | Not:113\n\n# Schweden\nFeuer:112 | Pol:112 | Not:112\n\n# Schweiz\nFeuer:118 oder 112 | Pol:117 oder 112 | Not:144 oder 112\n\n# Serbien\nFeuer:112 | Pol:112 | Not:112\n\n# Slowakei\nFeuer:112 | Pol:112 | Not:112\n\n# Slowenien\nFeuer:112 | Pol:113 | Not:112\n\n# Spanien\nFeuer:112 | Pol:112 | Not:112\n\n# Tschechien\nFeuer:112 | Pol:112 | Not:112\n\n# Türkei\nFeuer:110 | Pol:155 | Not:112\n\n# Ukraine\nFeuer:112 | Pol:112 | Not:112\n\n# Ungarn\nFeuer:112 | Pol:112 | Not:112\n\n# Vatikanstadt\nFeuer:115 | Pol:112 | Not:113\n\n# Weißrussland\nFeuer:01 | Pol:02 | Not:03\n\n# Zypern\nFeuer:112 | Pol:112 | Not:112");
				stringNorthamerica = new StringItem("Nord-/Zentralamerika", "\n\n# USA\nFeuer:911 | Pol:911 | Not:911\n\n# Antigua und Barbuda\nFeuer:911 | Pol:911 | Not:911\n\n# Bahamas\nFeuer:911 | Pol:911 | Not:911\n\n# Barbados\nFeuer:113 | Pol:112 | Not:115\n\n# Belize\nFeuer:911 | Pol:911 | Not:911\n\n# Cayman Islands\nFeuer:911 | Pol:911 | Not:911\n\n# Costa Rica\nFeuer:911 | Pol:911 | Not:911\n\n# Dominica\nFeuer:999 | Pol:999 | Not:999\n\n# Dominikanische Republik\nFeuer:911 | Pol:911 | Not:911\n\n# El Salvador\nFeuer:911 | Pol:911 | Not:911\n\n# Grenada\nFeuer:911 | Pol:112 | Not:911\n\n# Grönland\nnur lokale Nummern\n\n# Guatemala\nFeuer:122 | Pol:110 | Not:123\n\n# Haiti\nFeuer:lokal | Pol:114 | Not:118\n\n# Honduras\nFeuer:198 | Pol:119 | Not:378654\n\n# Jamaika\nFeuer:110 | Pol:119 | Not:110\n\n# Kanada\nFeuer:911 | Pol:911 | Not:911\n\n# Kuba\nFeuer:26811 | Pol:26811 | Not:26811\n\n# Mexiko\nFeuer:060 | Pol:080 | Not:060\n\n# Nicaragua\nFeuer:2650162 | Pol:118 | Not:2651761\n\n# Panama\nFeuer:103 | Pol:104 | Not:2699778\n\n# Saint Kitts und Nevis\nFeuer:911 | Pol:911 | Not:911\n\n# Saint Lucia\nFeuer:911 | Pol:999 | Not:911\n\n# Saint Pierre und Miquelon\nFeuer:18 | Pol:17 | Not:15\n\n# Saint Vincent und Grenadinen\nFeuer:911 | Pol:911 | Not:911\n\n# Trinidad und Tobago\nFeuer:990 | Pol:999 | Not:990");
				stringOceania = new StringItem("Ozeanien", "\n\n# Australien\nFeuer | Pol: | Not: 000 oder 112 mobil\n\n# Fidschi\nFeuer:9170 | Pol:911 | Not:911\n\n# Kiribati\nFeuer:lokal | Pol:lokal | Not:994\n\n# Marshallinseln\nFeuer:lokal | Pol:6258666 | Not:6254111 \n\n# Mikronesien\nnur lokale Nummern\n\n# Nauru\nnur lokale Nummern\n\n# Neuseeland\nFeuer:111 | Pol:111 | Not:111\n\n# Palau\nFeuer:911 | Pol:911 | Not:911\n\n# Papua-Neuguinea\nFeuer:110 | Pol:000 | Not:lokal\n\n# Salomonen\nFeuer:911 | Pol:911 | Not:911\n\n# Samoa\nFeuer:994 | Pol:995 | Not:996\n\n# Tonga\nFeuer:999 | Pol:922 | Not:933\n\n# Tuvalu\nFeuer:911 | Pol:911 | Not:911\n\n# Vanuatu\nFeuer:112 | Pol:112 | Not:112");
				stringSouthamerica = new StringItem("Südamerika", "\n\n# Argentinien\nFeuer:100 | Pol:101 | Not:107\n\n# Bolivien\nFeuer:911 | Pol:911 | Not:911\n\n# Brasilien\nFeuer:193 | Pol:190 | Not:192\n\n# Chile\nFeuer:132 | Pol:133 | Not:131\n\n# Ecuador\nFeuer:102 | Pol:101 | Not:131\n\n# Guyana\nFeuer:912 | Pol:911 | Not:913\n\n# Kolumbien\nFeuer:119 | Pol:119 | Not:119\n\n# Paraguay\nFeuer:911 | Pol:911 | Not:911\n\n# Peru\nFeuer:116 | Pol:105 | Not:116\n\n# Suriname\nFeuer:115 | Pol:115 | Not:115\n\n# Uruguay\nFeuer:911 | Pol:911 | Not:911\n\n# Venezuela\nFeuer:171 | Pol:171 | Not:171");
				
				menu = new List("Erste Hilfe 3.0", Choice.IMPLICIT);
				menu.append("- Haftung+Hinweise -", null); // 0
				menu.append("- Notrufe weltweit -", null); // 1 
				menu.append("Allgemeines", null); // 2
				menu.append("Allergische Reaktion", null); // 3
				menu.append("Amputation", null); // 4
				menu.append("Asthma / Atemnot", null); // 4
				menu.append("Atemstillstand", null); // 5
				menu.append("Atmung prüfen", null); // 6
				menu.append("Augenverletzung", null); // 7
				menu.append("Augenverätzung", null); // 8
				menu.append("Beatmung", null); // 9
				menu.append("Bewusstlosigkeit mit Atmung", null); // 10
				menu.append("Bewusstlosigkeit ohne Atmung", null); // 11
				menu.append("Blutung Leicht", null); // 12
				menu.append("Blutung Schwer", null); // 13
				menu.append("Diabetisches Koma", null); // 14
				menu.append("Durchfall", null); // 15
				menu.append("Eisunfall", null); // 16
				menu.append("Elektrounfall", null); // 17
				menu.append("Epileptischer Anfall", null); // 18
				menu.append("Erbrechen", null); // 19
				menu.append("Erfrierung leicht", null); // 20
				menu.append("Erfrierung stark", null); // 21
				menu.append("Ersticken", null); // 22
				menu.append("Ertrinken", null); // 23
				menu.append("Geburt", null); // 24
				menu.append("Gefahrenzone", null); // 25
				menu.append("Gehirnerschütterung", null); // 26
				menu.append("Herzdruckmassage", null); // 27
				menu.append("Herzinfarkt", null); // 28
				menu.append("Hitzschlag", null); // 29
				menu.append("Insektenstich", null); // 30
				menu.append("Knochenbruch", null); // 31
				menu.append("Nasenbluten", null); // 32
				menu.append("Notruf", null); // 33
				menu.append("Reanimation", null); // 34
				menu.append("Rückenverletzung", null); // 35
				menu.append("Schädelbasisbruch", null); // 36
				menu.append("Schlaganfall", null); // 37
				menu.append("Schlangenbiss", null); // 38
				menu.append("Schock", null); // 39
				menu.append("Sonnenbrand", null); // 40
				menu.append("Sonnenstich", null); // 41
				menu.append("SOS", null); // 42
				menu.append("Stabile Seitenlage", null); // 43
				menu.append("Tierbiss", null); // 44
				menu.append("Überhitzung", null); // 45
				menu.append("Überzuckerung", null); // 46
				menu.append("Unfallstelle sichern", null); // 47
				menu.append("Unterkühlung", null); // 48
				menu.append("Unterzuckerung", null); // 49
				menu.append("Verätzung", null); // 50
				menu.append("Verbrennung Leicht", null); // 51
				menu.append("Verbrennung Schwer", null); // 52
				menu.append("Vergiftung", null); // 53
				menu.append("Verkehrsunfall", null); // 54
				menu.append("Verschlucken", null); // 55
				menu.append("Verstauchung/Verrenkung", null); // 56
				menu.append("Wiederbelebung", null); // 57
				menu.append("Wirbelsäulen-Verletzung", null); // 58
				menu.append("-------------", null); // 59
				// Navigation
				// menu.addCommand(cmdChose);
				menu.addCommand(cmdExit);
				menu.setCommandListener(this);

				// First-Aid-Text
				softwareha = new StringItem ("Haftung + Hinweise", "\n\n-- Software --\nErste Hilfe auf dem Handy\nVersion: j3.0\nRelease: 2008-12-24\nLizenz: Creative Commons BY-NC-ND 3.0\nCopyright: Kai Kajus Noack\n\nDieses Programm soll Informationen zur Ersten Hilfe geben. Es stellt jedoch in keiner Weise einen Ersatz für einen Erste-Hilfe-Kurs dar, sondern dient der Auffrischung des bereits erworbenen Wissens.\n\n-- Haftungsausschluss --\nBitte beachten Sie, dass ich keine Verantwortung für Konsequenzen, die aus der Nutzung entstehen, übernehme.\nJEGLICHE HAFTUNG IST AUSGESCHLOSSEN!\nVERWENDUNG AUF EIGENE GEFAHR!\n\nIn allen Notfällen suchen Sie bitte sofort professionelle Hilfe.\n\n-- Entwicklung des Projekts --\nDas Programm soll vielsprachig werden. Freiwillige Übersetzer gesucht!!\n\nWeitere Informationen erhalten Sie im Internet unter www.firstai.de oder schreiben Sie eine E-Mail an: info@firstai.de");
				allgemeines = new StringItem ("Allgemeines", "\n\n1. Leisten Sie immer Erste Hilfe. Sie können keine Fehler machen.\n2. Achten Sie immer auf Ihre eigene Sicherheit.\n3. Machen Sie sich ein Bild von der Situation + Sichern Sie die Unfallstelle.\n4. Notruf + Sofortmaßnahmen!\n5. Bei mehreren Verletzten hat der am stärksten bedrohte Vorrang.\n6. Beruhigen Sie den Betroffenen. Und bleiben Sie selbst ruhig!\n7. Lagern Sie den Betroffenen falls möglich bequem. Grundsätzlich nie Alkohol, Nikotin oder Medikamente verabreichen.");
				allergreakt = new StringItem ("Allergische Reaktion", "\n\n1. Notruf absetzen.\n2. Beruhigen des Betroffenen und bequem hinsetzen.\n3. Allergie-auslösenden Stoff (z. B. Insektenstachel) vorsichtig entfernen.\n4. Betroffene Hautstelle kühlen (feuchter Umschlag, Eis).\n5. Falls Betroffener ein Gegenmittel hat, sollte er dieses nutzen.\n6. Kontrolle des Zustands bis Notarzt eintrifft.\n7. Bei eintretender Bewusstlosigkeit oder Atemnot entsprechende Maßnahmen ergreifen!");
				amputation = new StringItem ("Amputation", "\n\nAbgetrennter Körperteil kann wieder angenäht werden. Ziel: Amputat bis zum Eintreffen im Krankenhaus kühlen.\n\n1. Betroffenen beruhigen, hinlegen und zudecken.\n2. Blutung stoppen, siehe 'Blutung (schwer)' und 'Schock'.\n3. Abgetrennten Körperteil in ein sauberes trockenes Tuch wickeln und in eine wasserdichte Plastiktüte legen.\n4. Diese Plastiktüte verschließen und in eine zweite Plastiktüte legen, die kühles Wasser/Eis enthält.\n5. Keinen Alkohol, Zigaretten oder Essen geben (falls im Krankenhaus mit Narkose operiert wird).\n6. Das Amputat nicht einfrieren (nur kühlen).\n7. Notarzt rufen oder selbst zum Krankenhaus fahren.");
				asthma = new StringItem ("Asthma/Atemnot", "\n\nStarke Atemnot. Pfeifendes Atemgeräusch. Angstgefühle.\n\n1. Beruhigen des Betroffenen. (Bleiben Sie selbst ruhig!)\n2. Kleidung lockern.\n3. Betroffenen bequem leicht nach vorne gebeugt hinsetzen und auffordern, langsam und tief ein- und auszuatmen.\n4. Falls der Betroffene einen Inhalator besitzt, sollte dieser benutzt werden (helfen Sie dabei). Nach 5-10 min sollte sich Wirkung zeigen.\n5. Sofern keine Besserung eintritt: Inhalator jede 5 min anwenden, solange bis Notarzt eintrifft.\n6. Notruf absetzen.\n7. Falls es zum Atemstillstand kommt, mit der Beatmung beginnen.");
				atemstillstand = new StringItem ("Atemstillstand/Beatmen","\n\nKeine Geräusche oder Atembewegungen, auffallende Hautverfärbung.\n\n1. Notruf absetzen.\n2. Betroffenen auf Rücken legen.\n3. Entfernen von Fremdkörpern aus Mund und Rachen. Überstrecken des Kopfes in den Nacken.\n4. Nasenflügel zusammendrücken, damit Nase geschlossen ist.\n5. Tief einatmen und Mund auf Mund des Betroffenen aufsetzen, sodass keine Luft entweichen kann.\n6. Langsam und vollständig ausatmen.\n7. Falls ohne Erfolg: Atemspende fortsetzen bis Notarzt eintrifft.");
				atmungpruefen = new StringItem ("Atmung prüfen", "\n\n1. Atemgeräusche prüfen.\n2. Atmung am Oberbauch feststellen (Hand auflegen).\n3. Atmung an Nase/Mund fühlbar.");
				augenverletzung = new StringItem ("Augenverletzung", "\n\n1. Fremdkörper im Auge belassen, nicht entfernen.\n2. Augen nicht bewegen, um weitere Verletzungen zu vermeiden. Auge nicht berühren.\n3. Bei Augen-Blutung mit Kompresse oder Verbandtuch bedecken.\n4. Auge mit kalter Auflage kühlen (verringert Schwellung, Blutung stoppt schneller).\n5. Notruf absetzen oder selbst zum Krankenhaus fahren.");
				augenveraetzung = new StringItem ("Augenverätzung", "\n\n1. Notarzt rufen, auf Ätz-Substanz hinweisen.\n2. Auge sofort mit viel Wasser spülen. Gesundes Auge während Spülung abdecken.\n3. Wasserstrahl vom inneren Augenwinkel zum äußeren Augenwinkel. Ca. 20 min reinigen.\n4. Beide Augen des Betroffenen schließen und mit angefeuchtetem Tuch verbinden.\n5. Zustand kontrollieren, bis Notarzt eintrifft.");
				bwlosMitAtmung = new StringItem ("Bewusstlosigkeit mit Atmung","\n\nKeine Reaktion auf Ansprache und Schütteln. Atmung vorhanden.\n\n1. Falls Menschen in der Nähe sind, bitten Sie diese um Mithilfe.\n2. Stabile Seitenlage einnehmen. Mund öffnen und Kopf so positionieren, dass Erbrochenes ablaufen kann.\n3. Notruf absetzen.");
				bwlosOhneAtmung = new StringItem ("Bewusstlosigkeit ohne Atmung","\n\nKeine Reaktion vorhanden, Atmung nicht feststellbar.\n\nWiederbelebung einleiten:\n\n");
				blutungleicht = new StringItem ("Leichte Blutung", "\n\nZiel: Stoppen der Blutung.\n\n1. Wunde nicht berühren (Infektionsgefahr).\n2. Wunde nicht mit Puder, Salben, Sprays behandeln.\n3. Wundversorgung mittels keimfreier Wundauflage und Befestigungsmaterial (Pflaster, Binde).\n4. Bei kleiner Blutung reicht meist ein Pflasterstreifen.\n5. Bei großflächiger Verletzung Wundauflage und Verbandtuch benutzen. Verband nicht zu fest binden, da Stauung zu vermehrter Blutung führt.\n6. Hinweis: Tollwut-Wunden mit Seifenlösung auswaschen.");
				blutungschwer = new StringItem ("Schwere Blutung", "\n\nSpritzendes, in Stößen austretendes Blut. Gefahr: Schock durch Blutverlust, Infektionen, Tod. Ziel: Stoppen der Blutung.\n\n1. Kleidung entfernen (notfalls aufschneiden), Wunde freilegen.\n2. Binde oder notfalls Kleidungsstück mit Druck um Wunde wickeln.\n3. Für mind. 10 min Druck auf Wunde ausüben.\n4. Falls Binde mit Blut durchnässt, nicht die alte Binde entfernen! Eine andere Binde/Kleidungsstück darüber binden.\n5. Verletztes Glied (sofern nicht gebrochen) über Höhe des Herzens lagern, damit sich Blutung verlangsamt. Wenn möglich Betroffenen hinlegen.\n6. Falls Blutung nicht stoppt, Druck auf Wunde beibehalten und zusätzlich Druckpunkte über der Wunde setzen: Bei Blutung am Unterarm den Oberarm abdrücken (Ader auf Arm-Innenseite mittig zwischen Ellbogen und Achselhöhle, mit Fingern abdrücken). Bei Blutung des Beins, Druckpunkt in Leiste setzen (Ader in Leistenbeuge, wo Arterie über Beckenknochen verläuft, mit Handballen abdrücken).\n7. Sofort Notarzt anfordern.\n8. Sobald Blutung unter Kontrolle: Schockbekämpfung einleiten.");
				diabetkoma = new StringItem ("Diabetisches Koma/Überzuckerung","\n\nBlutzuckerspiegel zu hoch bzw. Insulinmangel.\nSymptome: Durst, häufiges Wasserlassen, Übelkeit, Erbrechen. Atem riecht nach Obst.\n\n1. Notruf absetzen.\n2. Unterstützung bei der Insulingabe, sofern sichergestellt, dass Diabetiker.\n3. Stabile Seitenlage. (Keine weiteren Möglichkeiten für den Ersthelfer.)\n4. Zustand des Betroffenen kontrollieren bis Notarzt eintrifft.");
				durchfall = new StringItem("Durchfall", "\n\nNahrungsmittel-Unverträglichkeit, Darm-Entzündung oder Erkrankung. Stuhlgang wässrig, schleimig oder blutig.\n\n1. Gefahr für Kreislauf aufgrund Flüssigkeits- und Salz-Verlustes!\n2. Flüssigkeit zuführen (Tee, Wasser).\n3. Bei starken Beschwerden Arzt aufsuchen oder Notruf absetzen.");
				eisunfall = new StringItem("Eisunfall", "\n\nEigenschutz beachten! Gefahr: Ertrinken, Unterkühlung.\n\n1. Rettung erfolgt via Leiter, Brett, Stange. Gewicht muss großflächig verteilt werden.\n2. Andere Personen um Mithilfe auffordern. Notruf absetzen lassen.\n3. Auf Bauch (möglichst angeseilt) mit Hilfsmittel vorsichtig zur Einbruchstelle robben.\n4. Verunglücktem auf Distanz das Hilfsmittel reichen (nicht die Hand!) und herausziehen.\n5. Rückwärts bis zum Ufer zurückrobben.\n6. Erste-Hilfe-Maßnahmen.\n7. Eigenrettung möglich: Bei festem Eis Gewicht auf Eis verteilen und sich selbst herausziehen. Flach auf Bauch zum Ufer zurückrobben. Bei brüchigem Eis versuchen Eis bis zum Ufer Stück für Stück abzubrechen.");
				elektrounfall = new StringItem ("Elektrounfall", "\n\nZuerst Stromzuleitung unterbrechen!\n\nGefahr: Bewusstlosigkeit, Atemstillstand.\n\n");
				epileptanfall = new StringItem ("Epileptischer Anfall", "\n\nStarrer Körper, geballte Fäuste, gepresster Kiefer, Zucken in Beinen oder Gesicht. Rollende Augen. Speichelfluss. Bewusstlosigkeit möglich.\n\n1. Betroffenen nicht halten oder in Bewegung einschränken.\n2. Betroffenen auf weiche Unterlage (Kissen) legen, Objekte in direkter Nähe entfernen, somit Selbstverletzungen vorbeugen.\n3. Beruhigend zum Betroffenen reden. Kleidung lockern, für Atemfreiheit sorgen.\n4. Falls Betroffener erbricht, Kopf zur Seite drehen, damit Erbrochenes abfließen kann.\n5. Atemwege freihalten. Gefahr, dass Zunge verschluckt wird.\n6. Stabile Seitenlage + Notruf absetzen. Weiterhin Zustand des Betroffenen kontrollieren.\n7. Andere Leute auf Distanz halten.");
				erbrechen = new StringItem ("Erbrechen", "\n\nFolge von Übelkeit. Magen befreit sich. Ursachen: Infektion, Vergiftung, Geschwür, Medikamente, falsche Nahrung, Schwangerschaft.\n\n1. Gefahr für Kreislauf aufgrund Flüssigkeits- und Salz-Verlustes!\n2. Flüssigkeit zuführen (Tee, Wasser).\n3. Bei starken Beschwerden, blutigem oder anhaltendem Erbrechen Arzt aufsuchen.");
				erfrierleicht = new StringItem ("Leichte Erfrierung", "\n\nBlässe, Schwellen. Gefahr für Blutzufuhr.\n\n1. Warmen Bereich aufsuchen.\n2. Kälte beseitigen. Nasse Kleidung entfernen, abtrocknen.\n3. Aufwärmen mit lauwarmem Wasser und Körperwärme des Helfers.\n4. Warmes Getränk (Tee) geben. Keinen Alkohol!");
				erfrierstark = new StringItem ("Starke Erfrierung", "\n\nKalte harte Haut, grau-weiß, Blasenbildung, Gewebe stirbt ab. Gefahr für Blutzufuhr!\n\n1. Warmen Bereich aufsuchen.\n2. Wunden versorgen/abdecken.\n3. Zuckerhaltiges Getränk verabreichen.\n4. Nicht warmreiben!\n5. Notruf absetzen.");
				ersticken = new StringItem ("Ersticken/Verschlucken","\n\nUnzureichende Sauerstoffversorgung. Luftröhre verschlossen. Gefahr: Atemstillstand.\nSymptome: Pfeifendes Atemgeräusch, Hustenreiz, Atemnot, Hautverfärbung.\n\n1. Sofort handeln! Betroffenen kräftig Husten lassen.\n2. Mit flacher Hand auf Rücken zwischen Schulterblättern kräftig klopfen (Babys dabei auf Unterarm legen, Kopf nach unten halten).\n3. Wenn ohne Erfolg: Hinter Person stellen, Arme um Taille legen, leicht nach vorne beugen.\n4. Hand zur Faust ballen, auf Magen-Höhe des Betroffenen positionieren und mit anderer Hand umfassen.\n5. Beide Hände in Umklammerung mit hartem Stoß in Richtung Magen nach oben/innen ziehen (als ob Sie die Person hochheben wollen).\n6. Bis zu 5-mal wiederholen! Luftwege sollten vom Objekt befreit sein.\n7. Notruf absetzen.\n8. Falls Maßnahme nicht erfolgreich, trotzdem fortsetzen, bis Notarzt eintrifft.");
				ertrinken = new StringItem ("Ertrinken", "\n\n1. Notruf absetzen. Personen in der Nähe um Hilfe bitten.\n2. Aus Wasser retten!\n3. Wenn Atmung vorhanden: Stabile Seitenlage. Betroffenen warm halten (Decke). Zustand kontrollieren, bis der Notarzt eintrifft.\n4. Bei Atemstillstand sofort mit Wiederbelebung beginnen! (Ausfließenlassen von Wasser aus Lungen ist nutzlos.)\n\n");
				geburt = new StringItem ("Geburt", "\n\nAbgang von Fruchtwasser. Presswehen treten ein. Unerwartete Geburt.\n\n1. Intimsphäre wahren und Ruhe bewahren! - Notruf absetzen.\n2. Die Schwangere breitbeinig, mit freigemachtem Unterkörper auf sterile Unterlage hinsetzen.\n3. Kniee anwinkeln. Beine etwas heranziehen. Becken leicht erhöht lagern. - Die Geburt ist ein natürlicher Prozess und läuft häufig ohne Komplikationen ab.\n4. Schwangere beruhigen und auf Atmung konzentrieren lassen: Durch Nase einatmen und Mund ausatmen (normales Atemtempo).\n5. Pressrhythmus: Tief Luft holen, anhalten und pressen. Sobald Kopf des Babys erscheint, mit beiden Händen unterstützend zugreifen.\n6. Nach der Geburt: Neugeborenes schräg nach unten hängen, um Fruchtwasser aus Atemwegen zu befreien. (Evtl. mit dem Mund das Fruchtwasser aus der Nase des Babys absaugen.) Kind muss atmen und schreien!\n7. Nabelschnur 30 cm vom Kind entfernt abbinden (kann auch im Krankenhaus erfolgen). Scheide der Mutter steril abdecken.\n8. Das Baby abtrocknen und warm halten. Uhrzeit notieren und zum Krankenhaus fahren.");  
				gefahrenzone = new StringItem ("Retten aus Gefahrenzone", "\n\n1. Grifftechnik: Arm des Verletzten vor dessen Brust, hinter den Verletzten stellen.\n2. Mit beiden Händen den angewinkelten Arm des Verletzten durch dessen Achseln greifen.\n3. Person in Sicherheit bringen.");
				gehirnerschuett = new StringItem ("Gehirnerschütterung", "\n\nKopfschmerz, Übelkeit, Erbrechen. Sehstörung. Bewusstlosigkeit kann eintreten.\n\n1. Betroffenen hinlegen.\n2. Notruf absetzen.\n\n*Bei Blutung am Kopf:\n1. Betroffenen hinlegen, Kopf erhöht lagern (Kissen).\n2. Wundversorgung durchführen (Kopf-Verband anlegen).\n3. Notruf absetzen.");
				herzinfarkt = new StringItem ("Herzinfarkt", "\n\nSchwere mehr als 5 min anhaltende Schmerzen + Druck im Brustkorb, besonders in Arme/Schultern ausstrahlend. Angstgefühl, Blässe, kalter Schweiß. Eventuell Übelkeit, Kurzatmigkeit.\n\n1. Notruf absetzen! Hinweis auf vermuteten Herzinfarkt.\n2. Oberkörper erhöht lagern. Enge Kleidung lockern. Keine Medikamente oder Getränke geben.\n3. Beruhigend auf Betroffenen einreden.\n4. Bewusstsein und Atmung kontrollieren.\n5. Dem Betroffenen Aspirin verabreichen, falls verfügbar.\n6. Bei Bewusstlosigkeit die Wiederbelebung einleiten:\n\n");
				hitzschlag = new StringItem ("Hitzschlag/Überhitzung","\n\nDurst, Schwäche, Desorientiertheit, Bewusstseinsstörung, starker Schweiß, heiße Haut.\n\n1. Notruf absetzen.\n2. Kühlen, schattigen Platz aufsuchen (Raum mit Klimaanlage sehr geeignet).\n3. Betroffenen hinlegen, Beine hochlagern. Kleidung lockern.\n4. Haut mit Wasser kühlen oder kalte Handtücher auflegen.\n5. Viel Wasser oder Säfte trinken.");
				insektenstich = new StringItem ("Insektenstich", "\n\nSchwellungen, Hautausschlag, brennendes Gefühl, Schwäche, Atemnot, Kreislaufprobleme, Herzrasen.\n\n1. Stachel vorsichtig entfernen (mit Pinzette). Nicht auf Stachel drücken, könnte noch mehr Gift injizieren.\n2. Kühlung der betroffenen Stelle (kalte Kompresse).\n3. Betroffene Stelle niedriger als Herz-Höhe halten, damit Gift langsamer zirkuliert.\n4. Bei Stich im Mund-Rachen-Raum: Eis lutschen lassen, kalte Umschläge um Hals.\n5. Bei ernsten Beschwerden Notruf absetzen.");
				knochenbruch = new StringItem ("Knochenbruch", "\n\nAnzeichen: Unnatürliche Lage und Beweglichkeit. Deformierung. Schmerzhafte Bewegung, berührungsempfindlich.\n\n1. Bewegungen vermeiden!\n2. Notruf absetzen.\n3. Bruch ruhig stellen, d.h. Umpolstern mit dichtem Material. Position des gebrochenen Knochens beibehalten.\n4. Bei offenem Bruch die Wunde keimfrei abdecken.");
				nasenbluten = new StringItem ("Nasenbluten", "\n\nKleine Ader in Nasenspitze geplatzt.\n\n1. Blutenden leicht nach vorne gelehnt hinsetzen. Kopf gerade halten.\n2. Nicht flach lagern, da Kopf über Herz-Höhe Bluten verlangsamt.\n3. Kalter Nackenumschlag.\n4. Nasenspitze bis zum Stopp der Blutung zudrücken (für 10 min).\n5. Anschließend Nase in keiner Weise anstrengen (kein Naseschnauben).\n6. Bei ernsten Beschwerden oder wenn Blutung anhält Notruf absetzen.");
				notruf = new StringItem ("Notruf", "\n\nWählen Sie mit dem nächst-verfügbaren Telefon 112. Immer möglich und kostenlos! Zögern Sie nie, den Notarzt zu rufen!\n\nAm Telefon Folgendes durchgeben: Wo (Unfallort) - Was ist passiert - Wie viele Verletzte - Welche Verletzungen. Danach auf Rückfragen warten.");
				schaedelbruch = new StringItem ("Schädelbasisbruch", "\n\nLeichte Blutungen aus Nase, Mund oder Ohr. Oft offene Wunde am Schädel.\n\n1. Atemwege freihalten.\n2. Bei Bewusstsein: Verletzten nach vorne gebeugt hinsetzen. Weitere Bewegungen vermeiden!\n3. Bei Bewusstlosigkeit: Stabile Seitenlage (keinen Druck auf Kopfwunde).\n4. Notruf absetzen.\n5. Kopfverband anlegen.\n6. Bei Atem- und Herz-Kreislauf-Störungen Wiederbelebung einleiten:\n\n");
				schlaganfall = new StringItem ("Schlaganfall", "\n\nPlötzliches Lähmungs- oder Taubheitsgefühl (Gesicht, Arm, Bein), gestörtes Sprachverständnis, Sehstörung, Bewusstseinstrübung, starke Kopfschmerzen. Probleme beim Atmen und Schlucken, Kontrollverlust über Blase und Darm.\n\n1. Notruf absetzen!\n2. Enge Kleidung lockern, keine Medikamente oder Getränke geben.\n3. Betroffenen bequem hinsetzen oder hinlegen. Beruhigen!\n4. Bewusstsein und Atmung kontrollieren.\n5. Bei Atem- und Herz-Kreislauf-Störungen Wiederbelebung einleiten:\n\n");
				schlangenbiss = new StringItem ("Schlangenbiss", "\n\nPunktförmige Wunde in Stecknadelgröße, heftige Schmerzen, Schwellung, blaurote Verfärbung. Kreislaufstörung, Schockgefahr.\n\n1. Verletzten Körperteil ruhigstellen\n2. Kalte Umschläge auf Bissstelle.\n3. Schockbekämpfung.\n4. Notruf absetzen.");
				schock = new StringItem ("Schock", "\n\nKreislauf-Störung durch mangelhafte Sauerstoffversorgung im Körper.\nUrsache: Verlust von Flüssigkeit, reduzierte Blutmenge.\nSymptome: Blässe, kalte Haut, kalter Schweiß, Unruhe.\n\n1. Schockursache beseitigen (z.B. Flüssigkeitsverlust stoppen, Wunde abbinden)!\n2. Betroffenen auf Decke legen, Beine hoch lagern. Beruhigen.\n3. Notruf absetzen.\n4. Bei Atem- und Herz-Kreislauf-Störungen Wiederbelebung einleiten:\n\n");
				sonnenbrand = new StringItem ("Sonnenbrand", "\n\n1. Betroffenen aus direkter Sonneneinstrahlung nehmen. Weitere Sonne meiden.\n2. Viel Wasser trinken, um Dehydration entgegenzuwirken.\n3. Bei ernsthaftem Sonnenbrand (Blasenbildung, Rötung, Schmerzen) unbedingt Arzt aufsuchen.\n4. Leichte Hautrötungen mit feuchten Umschlägen kühlen. After-Sun-Lotion oder Gel auftragen.");
				sonnenstich = new StringItem ("Sonnenstich", "\n\nHeißer roter Kopf, kühle Haut, Übelkeit, Kopfschmerz, Schwindelgefühl. Ursache: Reizung der Hirnhaut.\n\n1. Kühlen Ort aufsuchen (Schatten) und Oberkörper des Betroffenen erhöht lagern.\n2. Mit nassen Tüchern Kopf kühlen.\n3. Notruf absetzen, Atmung weiterhin kontrollieren.\n4. Bei Bewusstsein: Ggf. kühles Getränk geben.\n5. Bei Atemstillstand mit Beatmung beginnen:\n\n");
				sos = new StringItem ("SOS", "\n\nSignal: 3x kurz, 3x lang, 3x kurz.\n\nOptisch (Blitzlicht, Taschenlampe) oder Akustisch (Signalpfeife, Klopfen).");
				stabileseitenlage = new StringItem ("Stabile Seitenlage", "\n\n1. Betroffenen in Rückenlage, Beine ausstrecken. Daneben knien.\n2. Nahen Arm im rechten Winkel zum Körper positionieren.\n3. Fernen Arm über Brust des Verletzten ziehen und Handrücken auf Wange platzieren.\n4. Entferntes Knie fassen, zu sich ziehen und auf Boden legen. Bein etwa im rechten Winkel positionieren. Hand des Betroffenen bleibt auf dessen Wange.\n5. Sicherstellen, dass Atemwege frei sind.\n 6. Mund öffnen, Kinn anheben und Kopf so positionieren, dass Erbrochenes ablaufen kann. Atmung kontrollieren.\n7. Bewusstsein und Atmung kontrollieren bis Notarzt eintrifft.");
				tierbiss = new StringItem ("Tierbiss", "\n\nAchtung, hohe Infektionsgefahr. Folgen wie Eiter, Tetanus, Tollwut.\n\n1. Wunde sofort mit heißem Seifenwasser auswaschen.\n2. Anschließend Wunddesinfektion auftragen.\n3. Bei starker Blutung den Oberkörper erhöht lagern.\n4. Keimfreien Verband anlegen.\n5. Krankenhaus aufsuchen oder Notruf absetzen.");
				unterkuehlung = new StringItem ("Unterkühlung", "\n\nKältezittern, Schläfrigkeit, Erschöpfung, bis hin zur Bewusstlosigkeit. Kalte, blasse Haut. Langsamer Puls, schwacher Herzschlag.\n\n1. Warmen Bereich aufsuchen.\n2. Notruf absetzen.\n3. Kälteeinwirkung beenden. Körpertemperatur erhöhen (Decke und Körper-zu-Körper-Kontakt).\n4. Nasse Kleidung entfernen und trockene warme Kleidung anziehen. In Decken packen. Kopf bedecken.\n5. Heißen Tee, Brühe oder heißes Wasser zu trinken geben. Keinen Alkohol! Betroffenen wachhalten.\n6. Zustand bis zum Eintreffen des Notarztes kontrollieren. Bei Verlust des Bewusstseins Wiederbelebung einleiten:\n\n");
				unterzuckerung = new StringItem ("Unterzuckerung", "\n\nBlutzuckerspiegel unter Mindestwert (aufgrund Überdosierung von Insulin oder ungenügender Nahrungsaufnahme).\nSymptome: Blässe, Nervosität, Hunger, Zittern, Schweiß.\n\n1. Zuerst klären, ob der Betroffene Diabetiker ist (siehe Diabetiker-Ausweis).\n2. Notruf absetzen.\n3. Dem Betroffenen gezuckerte Getränke und Traubenzucker geben (sofern keine Schluckschwierigkeiten).\n4. Bei Bewusstlosigkeit und vorhandener Atmung: Stabile Seitenlage einnehmen und Atmung kontrollieren. Falls Atemstillstand eintritt, den Betroffenen beatmen.\n5. Wenn Atmung vorhanden, dem Bewusstlosen ein Stück Zucker in die Backentasche legen und von außen gegendrücken.");
				veraetzung = new StringItem ("Verätzung", "\n\nZerstörung von Gewebe.\n\n1. Eigenschutz beachten!\n2. Zügig handeln und verätzte Stellen abspülen.\n3. Notruf absetzen.\n4. Bei Verätzung des Verdauungsweges: Vermehrt Flüssigkeit trinken.\n5. Kein Erbrechen auslösen!");
				verbrennungLeicht = new StringItem ("Leichte Verbrennung", "\n\nRötung der Haut. Leichte Schwellung. Schmerzen.\n\n1. Betroffene Stelle unter laufendem kalten Wasser kühlen.\n2. Feuchten Verband locker anlegen.");
				verbrennungSchwer = new StringItem ("Schwere Verbrennung", "\n\nGefleckte weiße rote Stellen, Blasenbildung. Flüssigkeitsaustritt aus Haut. Tiefe Gewebeschädigung. Starke Schmerzen oder keine Schmerzen (aufgrund verbrannter Nerven).\n\n1. Kleidung soweit wie möglich entfernen.\n2. Mit kaltem Wasser (ca. 15°C) bis zu 10 min kühlen, bis Schmerzlinderung eintritt.\n3. Falls Verbrennung großflächig, nur mit feuchten Tüchern kühlen.\n4. Notruf absetzen.\n5. Nach Kühlung die Wundversorgung durchführen. Sterile, trockene Wundauflage benutzen. Keine Flüssigkeiten aufbringen (keine Cremes, Öle, Salben etc.). Blasen nicht aufstechen.\n6. Atmung und Bewusstsein des Betroffenen kontrollieren, bis Notarzt eintrifft.");
				vergiftung = new StringItem ("Vergiftung", "\n\nVerwirrung, Halluzination, große Pupillen, Fieber, Krämpfe. Bewusstlosigkeit.\n\n1. Gegenmittel nur verabreichen, wenn medizinisch ausgebildete Person vor Ort.\n2. Keine Getränke geben. Kein Erbrechen auslösen.\n3. Notruf absetzen + auf Vergiftung hinweisen!\n4. Giftreste und Erbrochenes sicherstellen!\n5. Sofern Betroffener bewusstlos ist und atmet: Stabile Seitenlage herstellen. Bewusstsein und Atmung kontrollieren bis Notarzt eintrifft.\n6. Sofern keine Atmung: Maßnahmen zur Wiederbelebung einleiten. Mund vorher von eventuell Erbrochenem befreien.\n\n");
				verkehrsunfall = new StringItem ("Unfallstelle sichern/Verkehrsunfall","\n\n1. Eigenen Pkw 50-100 m hinter Unfallstelle halten (falls Autobahn oder Landstraße). Danach Warnblinker anschalten und Warnweste anziehen.\n2. Warndreieck vor Unfallstelle aufstellen. Achtung: Bei einem Unfall in der Kurve, Warndreieck vor der Kurve platzieren!\n3. Andere Personen um Mithilfe auffordern.\n4. Tür des Unfall-Pkws öffnen (falls verklemmt, mittels Wagenheber aufstemmen). Zündung ausschalten.\n5. Unfallopfer bergen: Abschnallen, Sitz nach hinten schieben. Verletzten mit Rettungsgriff aus Wagen befreien.\n6. Notruf absetzen.\n7. Erste-Hilfe-Maßnahmen.");
				verstauchung = new StringItem ("Verstauchung/Verrenkung", "\n\nSchmerzen, Schwellung (Bluterguss), Funktionsverlust, Verformung des Gliedes.\n\n1. Ruhigstellung des Gliedes ausschließlich in der für Betroffenen angenehmsten Position.\n2. Kühlen (mit Eisbeutel).\n3. Falls möglich Glied hoch lagern.\n4. Krankenhaus aufsuchen oder Notruf absetzen.");
				wiederbelebung = new StringItem("Wiederbelebung", "\n\n-- Herzdruckmassage --\n1. Betroffenen in Rückenlage. Daneben hinknien.\n2. Brustkorb freimachen.\n3. In der Mitte des Brustkorbs (kurz über Brustbein) einen Handballen platzieren.\n4. Anderen Handballen auf Handrücken der bereits platzierten Hand.\n5. Arme, Ellbogen durchdrücken.\n6. Brustkorb des Betroffenen 5 cm senkrecht eindrücken (aus dem Oberkörper arbeiten) und wieder entlasten.\n7. 30-mal in Folge kurz und kräftig drücken.\n\n-- Beatmung --\n1. Entfernen von Fremdkörpern aus Mund und Rachen. Überstrecken des Kopfes in den Nacken.\n2. Nasenflügel zusammendrücken, damit Nase geschlossen ist.\n3. Tief einatmen und Mund auf Mund des Betroffenen aufsetzen, sodass keine Luft entweichen kann.\n4. Zweimal Mund zu Mund beatmen (langsam, vollständig ausatmen).\n5. Danach wieder Herzdruckmassage.\n\n*Herzdruckmassage + Beatmung fortführen bis Rettungsdienst kommt.");
				wirbelsaeule = new StringItem ("Rücken-/Wirbelsäulen-Verletzung", "\n\nSchmerzen im Rücken, gefühllose Arme und Beine.\n\n1. Verletzten auf keinen Fall bewegen!!\n2. Kopf so halten, dass Betroffener stabil liegt.\n3. Verletzten nur mittels seitlicher Polsterung stabilisieren.\n4. Betroffenen beruhigen.\n5. Notruf absetzen, Hinweis auf Rückenverletzung.");
				
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
			
			if (auswahl == 0) { formTextHolder.append(softwareha); }
			else if (auswahl == 2) { formTextHolder.append(allgemeines); }
			else if (auswahl == 3) { formTextHolder.append(allergreakt); }
			else if (auswahl == 4) { formTextHolder.append(amputation); }
			else if (auswahl == 5) { formTextHolder.append(asthma); formTextHolder.append(atemstillstand); } 
			else if (auswahl == 6) { formTextHolder.append(atemstillstand); } // Atemstillstand
			else if (auswahl == 7) { formTextHolder.append(atmungpruefen); }
			else if (auswahl == 8) { formTextHolder.append(augenverletzung); }
			else if (auswahl == 9) { formTextHolder.append(augenveraetzung); }
			else if (auswahl == 10) { formTextHolder.append(atemstillstand); } // Beatmung
			else if (auswahl == 11) { formTextHolder.append(bwlosMitAtmung); }
			else if (auswahl == 12) { formTextHolder.append(bwlosOhneAtmung); formTextHolder.append(wiederbelebung); } 
			else if (auswahl == 13) { formTextHolder.append(blutungleicht); }
			else if (auswahl == 14) { formTextHolder.append(blutungschwer); }
			else if (auswahl == 15) { formTextHolder.append(diabetkoma); }
			else if (auswahl == 16) { formTextHolder.append(durchfall); }
			else if (auswahl == 17) { formTextHolder.append(eisunfall); }
			else if (auswahl == 18) { formTextHolder.append(elektrounfall); formTextHolder.append(bwlosMitAtmung); formTextHolder.append(bwlosOhneAtmung); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 19) { formTextHolder.append(epileptanfall); }
			else if (auswahl == 20) { formTextHolder.append(erbrechen); }
			else if (auswahl == 21) { formTextHolder.append(erfrierleicht); }
			else if (auswahl == 22) { formTextHolder.append(erfrierstark); }
			else if (auswahl == 23) { formTextHolder.append(ersticken); } // Ersticken
			else if (auswahl == 24) { formTextHolder.append(ertrinken); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 25) { formTextHolder.append(geburt); }
			else if (auswahl == 26) { formTextHolder.append(gefahrenzone); }
			else if (auswahl == 27) { formTextHolder.append(gehirnerschuett); }
			else if (auswahl == 28) { formTextHolder.append(wiederbelebung); } // Herzdruckmassage
			else if (auswahl == 29) { formTextHolder.append(herzinfarkt); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 30) { formTextHolder.append(hitzschlag); } // Hitzschlag
			else if (auswahl == 31) { formTextHolder.append(insektenstich); }
			else if (auswahl == 32) { formTextHolder.append(knochenbruch); }
			else if (auswahl == 33) { formTextHolder.append(nasenbluten); }
			else if (auswahl == 34) { formTextHolder.append(notruf); }
			else if (auswahl == 35) { formTextHolder.append(wiederbelebung); } // Reanimation
			else if (auswahl == 36) { formTextHolder.append(wirbelsaeule); } // Rückenverletzung
			else if (auswahl == 37) { formTextHolder.append(schaedelbruch); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 38) { formTextHolder.append(schlaganfall); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 39) { formTextHolder.append(schlangenbiss); }
			else if (auswahl == 40) { formTextHolder.append(schock); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 41) { formTextHolder.append(sonnenbrand); }
			else if (auswahl == 42) { formTextHolder.append(sonnenstich); formTextHolder.append(atemstillstand); }
			else if (auswahl == 43) { formTextHolder.append(sos); }
			else if (auswahl == 44) { formTextHolder.append(stabileseitenlage); }
			else if (auswahl == 45) { formTextHolder.append(tierbiss); }
			else if (auswahl == 46) { formTextHolder.append(hitzschlag); } // Überhitzung
			else if (auswahl == 47) { formTextHolder.append(diabetkoma); } // Überzuckerung
			else if (auswahl == 48) { formTextHolder.append(verkehrsunfall); } // Unfallstelle Sichern
			else if (auswahl == 49) { formTextHolder.append(unterkuehlung); formTextHolder.append(bwlosMitAtmung); formTextHolder.append(bwlosOhneAtmung); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 50) { formTextHolder.append(unterzuckerung); formTextHolder.append(atemstillstand); }
			else if (auswahl == 51) { formTextHolder.append(veraetzung); }
			else if (auswahl == 52) { formTextHolder.append(verbrennungLeicht); }
			else if (auswahl == 53) { formTextHolder.append(verbrennungSchwer); }
			else if (auswahl == 54) { formTextHolder.append(vergiftung); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 55) { formTextHolder.append(verkehrsunfall); }
			else if (auswahl == 56) { formTextHolder.append(ersticken);} // Verschlucken
			else if (auswahl == 57) { formTextHolder.append(verstauchung); }
			else if (auswahl == 58) { formTextHolder.append(wiederbelebung); } // Wiederbelebung
			else if (auswahl == 59) { formTextHolder.append(wirbelsaeule); } // Wirbelsäulen-Verletzung
		}

		public void pauseApp() {
			//display = null;
			//menu = null;
		}

		public void destroyApp(boolean unconditional) {
			notifyDestroyed();
		}

		public void commandAction(Command c, Displayable d) {
			// String label = c.getLabel();
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
				else if (menu.getSelectedIndex() == 60) { }
				else {
					// apply text to form and show it
					applyText(menu.getSelectedIndex());
					display = Display.getDisplay(this);
					display.setCurrent(formTextHolder);
				}
			}
		}
	}


//	 load data here!? ... record store -- http://www.areamobile.de/specials/J2ME2/teil_II.php
//	 dort auch Fehler-Nennung 'Aufgrund von Problemen bei einigen Handys beim Aktualisieren von Record Stores...'

