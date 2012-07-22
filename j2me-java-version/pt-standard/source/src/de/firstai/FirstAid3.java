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
	static final Command cmdBack = new Command("Voltar", Command.BACK, 2);
	static final Command cmdExit = new Command("Fechar", Command.EXIT, 2);

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

		this.menu = new List("Primeiros Socorros 3.0", Choice.IMPLICIT);
		this.menu.append("# Aviso Legal", null);
		this.menu.append("# Chamadas de emergência", null);
		this.menu.append("# Conduta Geral", null);
		this.menu.append("A compressão do tórax", null);
		this.menu.append("A hiperglicemia (açúcar)", null);
		this.menu.append("A hipoglicemia (níveis baixos de açúcar)", null);
		this.menu.append("A hipotermia (corpo frio)", null);
		this.menu.append("Acidente com Electricidade", null);
		this.menu.append("Acidente de Tráfego", null);
		this.menu.append("Acidente ofídico", null);
		this.menu.append("Afogamento", null);
		this.menu.append("Amputação", null);
		this.menu.append("Apnéia", null);
		this.menu.append("Asfixia", null);
		this.menu.append("Asma", null);
		this.menu.append("Ataque do coração", null);
		this.menu.append("Ataque Súbito", null);
		this.menu.append("Checar Respiração", null);
		this.menu.append("Choque", null);
		this.menu.append("Coma diabético", null);
		this.menu.append("Concussão no cerébro", null);
		this.menu.append("Diarreia", null);
		this.menu.append("Dispnéia", null);
		this.menu.append("Engasgado", null);
		this.menu.append("Envenenamento", null);
		this.menu.append("Epilepsia", null);
		this.menu.append("Esforços + distenção", null);
		this.menu.append("Fratura", null);
		this.menu.append("Fratura Craniana", null);
		this.menu.append("Fratura Espinhal", null);
		this.menu.append("Hipertermia (calor corporal)", null);
		this.menu.append("Inconsciência com respiração", null);
		this.menu.append("Inconsciência sem respirar", null);
		this.menu.append("Insolação", null);
		this.menu.append("Lesões nas Costas", null);
		this.menu.append("Lesões oculares", null);
		this.menu.append("Ligar para emergência", null);
		this.menu.append("Mordida de Animal", null);
		this.menu.append("Nascimento", null);
		this.menu.append("Picadas de Insetos", null);
		this.menu.append("Posição de Recuperação", null);
		this.menu.append("Queimadura por frio grave", null);
		this.menu.append("Queimadura por frio leve", null);
		this.menu.append("Queimadura Quimica", null);
		this.menu.append("Queimadura Quimica (Olhos)", null);
		this.menu.append("Queimadura solar", null);
		this.menu.append("Queimaduras Graves", null);
		this.menu.append("Queimaduras Ligeiras", null);
		this.menu.append("Reação alérgica", null);
		this.menu.append("Reanimação", null);
		this.menu.append("Resgate no gelo", null);
		this.menu.append("Respiração", null);
		this.menu.append("Sangramento grave", null);
		this.menu.append("Sangramento leve", null);
		this.menu.append("Sangramento no Nariz", null);
		this.menu.append("Segurança em Acidente", null);
		this.menu.append("SOS", null);
		this.menu.append("Vômito", null);
		this.menu.append("Zona de Perigo (Resgate)", null);
		this.menu.append("-------------", null);
		this.menu.append("Ligue para emergência 192", null);
 
		// commands
		this.menu.addCommand(cmdExit);
		this.menu.setCommandListener(this);

		details = new Form ("Primeiros Socorros no seu celular");

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
			telEmergency.append("África", null);
			telEmergency.append("América do Norte/Central", null);
			telEmergency.append("América do Sul", null);
			telEmergency.append("Ásia", null);
			telEmergency.append("Europa", null);
			telEmergency.append("Oceania", null);
			telEmergency.addCommand(cmdBack);
			telEmergency.setCommandListener(this);
			stringAfrica = new StringItem("- África -", "\n# África do Sul\nPol:10111 | Méd:10177 | Bom:10111\n\n# Angola\nPol:110 | Méd:118 | Bom:118\n\n# Argélia\nPol:17 | Méd:17 | Bom:14\n\n# Benin\nPol:17 | Méd:301769 | Bom:18\n\n# Botsuana\nPol:999 | Méd:997 | Bom:998\n\n# Burkina Faso\nPol:17 | Méd:local números | Bom:18\n\n# Burundi\nPol:não obrigatórias | Méd:não obrigatórias | Bom:não obrigatórias\n\n# Cabo Verde\nPol:132 | Méd:130 | Bom:131\n\n# Camarões\nPol:17 | Méd:local números | Bom:18\n\n# Central Africano República\nPol:611253 | Méd:610600 | Bom:118\n\n# Chade\nPol:17 | Méd:local números | Bom:18\n\n# Comoros\nPol:apenas telefones de rádio | Méd:apenas telefones de rádio | Bom:apenas telefones de rádio\n\n# Congo (República Democrática)\nPol:local números | Méd:local números | Bom:local números\n\n# Congo (República)\nPol:local números | Méd:local números | Bom:local números\n\n# Costa do Marfim\nPol:110 | Méd:110 | Bom:180\n\n# Djibuti\nPol:17 | Méd:351351 | Bom:18\n\n# Egito\nPol:122 | Méd:123 | Bom:180\n\n# Eritréia\nPol:local números | Méd:local números | Bom:local números\n\n# Etiópia\nPol:91 | Méd:92 | Bom:93\n\n# Gabão\nPol:1730 | Méd:1300 | Bom:18\n\n# Gâmbia\nPol:117 | Méd:116 | Bom:118\n\n# Gana\nPol:191 | Méd:193 | Bom:192\n\n# Guiné\nPol:local números | Méd:local números | Bom:local números\n\n# Guiné Equatorial\nPol:local números | Méd:local números | Bom:local números\n\n# Guiné-Bissau\nPol:local números | Méd:local números | Bom:local números\n\n# Lesoto\nPol:123 | Méd:121 | Bom:122\n\n# Libéria\nPol:911 | Méd:911 | Bom:911\n\n# Líbia\nPol:193 | Méd:193 | Bom:193\n\n# Madagascar\nPol:117 | Méd:2262566 | Bom:18\n\n# Malauí\nPol:199 | Méd:199 | Bom:199\n\n# Mali\nPol:17 | Méd:15 | Bom:18\n\n# Marrocos\nPol:19 | Méd:15 | Bom:15\n\n# Maurício\nPol:999 | Méd:999 | Bom:999\n\n# Mauritânia\nPol:117 | Méd:local números | Bom:118\n\n# Mayotte\nPol:112 | Méd:15 | Bom:603054\n\n# Moçambique\nPol:119 | Méd:117 | Bom:198\n\n# Namíbia\nPol:1011 | Méd:2032276 | Bom:2032270\n\n# Níger\nPol:17 | Méd:723141 | Bom:18\n\n# Nigéria\nPol:119 | Méd:199 | Bom:190\n\n# Quênia\nPol:999 | Méd:999 | Bom:999\n\n# República Árabe Saaraui Democrática\nPol:-- | Méd:-- | Bom:--\n\n# Reunião\nPol:17 or 112  | Méd:15 or 112  | Bom:18 or 112 \n\n# Ruanda\nPol:112 | Méd:local números | Bom:local números\n\n# São Tomé e Príncipe\nPol:-- | Méd:-- | Bom:--\n\n# Senegal\nPol:local números | Méd:8891515 | Bom:local números\n\n# Serra Leoa\nPol:999 | Méd:999 | Bom:999\n\n# Seychelles\nPol:999 | Méd:999 | Bom:999\n\n# Somália\nPol:local números | Méd:local números | Bom:local números\n\n# Suazilândia\nPol:999 | Méd:6060911 | Bom:local números\n\n# Sudão\nPol:999 | Méd:local números | Bom:999\n\n# Tanzânia\nPol:112 | Méd:112 | Bom:112\n\n# Togo\nPol:101 | Méd:191 | Bom:118\n\n# Tunísia\nPol:197 | Méd:190 | Bom:198\n\n# Uganda\nPol:999 or 111 móvel | Méd:999 or 111 móvel | Bom:999 or 111 móvel\n\n# Zâmbia\nPol:999 or 112 móvel | Méd:991 or 112 móvel | Bom:993 or 112 móvel\n\n# Zimbabué\nPol:995 | Méd:994 | Bom:993");
			stringAsia = new StringItem("- Asia -", "\n# Afeganistão\nPol:-- | Méd:112 | Bom:--\n\n# Arábia Saudita\nPol:999 | Méd:997 | Bom:998\n\n# Armênia\nPol:102 | Méd:103 | Bom:101\n\n# Azerbaijão\nPol:102 | Méd:103 | Bom:101\n\n# Bangladesh\nPol:8665513 | Méd:199 | Bom:9555555\n\n# Barém\nPol:999 | Méd:999 | Bom:999\n\n# Brunei\nPol:993 | Méd:991 | Bom:995\n\n# Butão\nPol:110 | Méd:112 | Bom:113\n\n# Camboja\nPol:117 | Méd:199 | Bom:118\n\n# Catar\nPol:999 | Méd:999 | Bom:999\n\n# Cazaquistão\nPol:03 | Méd:03 | Bom:03\n\n# China\nPol:110 | Méd:120 | Bom:119\n\n# Cingapura\nPol:999 | Méd:995 | Bom:995\n\n# Coréia do Norte\nPol:local números | Méd:local números | Bom:local números\n\n# Coréia do Sul (República da Coreia)\nPol:112 | Méd:119 | Bom:119\n\n# Curdistão\nPol:129 | Méd:115 | Bom:125\n\n# Emirados Árabes Unidos\nPol:999 | Méd:998 | Bom:997\n\n# Filipinas\nPol:117 | Méd:117 | Bom:117\n\n# Geórgia\nPol:022 | Méd:022 | Bom:022\n\n# Hong Kong\nPol:999 | Méd:999 | Bom:999\n\n# Iêmen\nPol:199 | Méd:199 | Bom:199\n\n# Índia\nPol:100 | Méd:102 | Bom:101\n\n# Indonésia\nPol:110 | Méd:118 | Bom:113\n\n# Irão\nPol:110 or 112  | Méd:115 or 112  | Bom:125 or 112 \n\n# Iraque\nPol:não obrigatórias | Méd:não obrigatórias | Bom:não obrigatórias\n\n# Israel\nPol:100 | Méd:101 | Bom:102\n\n# Japão\nPol:110 | Méd:119 | Bom:119\n\n# Jordânia\nPol:192 | Méd:193 | Bom:193\n\n# Kuwait\nPol:777 | Méd:777 | Bom:777\n\n# Laos\nPol:local números | Méd:03 | Bom:local números\n\n# Líbano\nPol:112 | Méd:140 | Bom:175\n\n# Macau\nPol:999 | Méd:999 | Bom:999\n\n# Malásia\nPol:999 or 112  | Méd:999 or 112  | Bom:999 or 112 \n\n# Maldivas\nPol:119 | Méd:102 | Bom:118\n\n# Mongólia\nPol:102 | Méd:103 | Bom:101\n\n# Myanmar\nPol:199 | Méd:199 | Bom:199\n\n# Nepal\nPol:100 | Méd:228094 | Bom:101\n\n# O Sri Lanka\nPol:119 or 112 não obrigatórias | Méd:110 | Bom:111\n\n# Omã\nPol:999 | Méd:999 | Bom:999\n\n# Paquistão\nPol:15 | Méd:115 | Bom:16\n\n# Quirguistão\nPol:133 | Méd:03 | Bom:03\n\n# Síria\nPol:112 | Méd:110 | Bom:113\n\n# Tailândia\nPol:191 móvel | Méd:191 | Bom:199\n\n# Taiwan\nPol:110 | Méd:119 | Bom:119\n\n# Tajiquistão\nPol:02 | Méd:03 | Bom:local números\n\n# Timor Leste\nPol:112 | Méd:7233212 | Bom:--\n\n# Turquemenistão\nPol:03 | Méd:03 | Bom:03\n\n# Uzbequistão\nPol:03 | Méd:03 | Bom:03\n\n# Vietnã\nPol:113 | Méd:115 | Bom:114");
			stringEurope = new StringItem("- Europa -", "\n# A Bósnia e Herzegovina\nPol:122 | Méd:124 | Bom:123\n\n# A Croácia\nPol:92 | Méd:94 | Bom:93\n\n# Albânia\nPol:19 | Méd:17 | Bom:18\n\n# Alemanha\nPol:110 | Méd:112 | Bom:112\n\n# Andorra\nPol:110 | Méd:118 | Bom:118\n\n# Áustria\nPol:112 | Méd:112 | Bom:112\n\n# Bélgica\nPol:112 | Méd:112 | Bom:112\n\n# Bielorrússia\nPol:02 | Méd:03 | Bom:01\n\n# Bulgária\nPol:112 | Méd:112 | Bom:112\n\n# Chipre\nPol:112 | Méd:112 | Bom:112\n\n# Cidade do Vaticano\nPol:112 | Méd:113 | Bom:115\n\n# Dinamarca\nPol:112 | Méd:112 | Bom:112\n\n# Eslováquia\nPol:112 | Méd:112 | Bom:112\n\n# Eslovénia\nPol:113 | Méd:112 | Bom:112\n\n# Espanha\nPol:112 | Méd:112 | Bom:112\n\n# Estónia\nPol:112 | Méd:112 | Bom:112\n\n# Finlândia\nPol:112 | Méd:112 | Bom:112\n\n# França\nPol:17 or 112 | Méd:15 or 112 | Bom:18 or 112\n\n# Grécia\nPol:112 | Méd:112 | Bom:112\n\n# Holanda\nPol:112 | Méd:112 | Bom:112\n\n# Hungria\nPol:112 | Méd:112 | Bom:112\n\n# Irlanda\nPol:112 | Méd:112 | Bom:112\n\n# Islândia\nPol:112 | Méd:112 | Bom:112\n\n# Itália\nPol:112 | Méd:112 | Bom:112\n\n# Kosovo\nPol:911 | Méd:911 | Bom:911\n\n# Letónia\nPol:112 | Méd:112 | Bom:112\n\n# Liechtenstein\nPol:112 | Méd:112 | Bom:112\n\n# Lituânia\nPol:112 | Méd:112 | Bom:112\n\n# Luxemburgo\nPol:112 | Méd:112 | Bom:112\n\n# Macedónia\nPol:112 | Méd:112 | Bom:112\n\n# Malta\nPol:112 | Méd:112 | Bom:112\n\n# Moldávia\nPol:902 | Méd:903 | Bom:901\n\n# Mônaco\nPol:112 | Méd:112 | Bom:112\n\n# Montenegro\nPol:112 | Méd:112 | Bom:112\n\n# Noruega\nPol:112 | Méd:113 | Bom:110\n\n# Polônia\nPol:112 | Méd:112 | Bom:112\n\n# Portugal\nPol:112 | Méd:112 | Bom:112\n\n# Reino Unido\nPol:112 | Méd:112 | Bom:112\n\n# República Checa\nPol:112 | Méd:112 | Bom:112\n\n# Romênia\nPol:112 | Méd:112 | Bom:112\n\n# Rússia\nPol:02 | Méd:03 | Bom:01\n\n# San Marino\nPol:112 | Méd:113 | Bom:116\n\n# Sérvia\nPol:112 | Méd:112 | Bom:112\n\n# Suécia\nPol:112 | Méd:112 | Bom:112\n\n# Suíça\nPol:117 or 112 | Méd: 144 or 112 | Bom:118 or 112\n\n# Turquia\nPol:155 | Méd:112 | Bom:110\n\n# Ucrânia\nPol:112 | Méd:112 | Bom:112");
			stringNorthamerica = new StringItem("- América do Norte/Central -", "\n# Antígua e Barbuda\nPol:911 | Méd:911 | Bom:911\n\n# Bahamas\nPol:911 | Méd:911 | Bom:911\n\n# Barbados\nPol:112 | Méd:115 | Bom:113\n\n# Belize\nPol:911 | Méd:911 | Bom:911\n\n# Canadá\nPol:911 | Méd:911 | Bom:911\n\n# Costa Rica\nPol:911 | Méd:911 | Bom:911\n\n# Cuba\nPol:26811 | Méd:26811 | Bom:26811\n\n# Dominica\nPol:999 | Méd:999 | Bom:999\n\n# El Salvador\nPol:911 | Méd:911 | Bom:911\n\n# Estados Unidos da América \nPol:911 | Méd:911 | Bom:911\n\n# Granada\nPol:112 | Méd:911 | Bom:911\n\n# Gronelândia\nPol:local números | Méd:local números | Bom:local números\n\n# Guatemala\nPol:110 | Méd:123 | Bom:122\n\n# Haiti\nPol:114 | Méd:118 | Bom:local números\n\n# Honduras\nPol:119 | Méd:378654 | Bom:198\n\n# Ilhas Cayman\nPol:911 | Méd:911 | Bom:911\n\n# Jamaica\nPol:119 | Méd:110 | Bom:110\n\n# México\nPol:080 | Méd:060 | Bom:060\n\n# Nicarágua\nPol:118 | Méd:2651761 | Bom:2650162\n\n# Panamá\nPol:104 | Méd:2699778 | Bom:103\n\n# República Dominicana\nPol:911 | Méd:911 | Bom:911\n\n# Saint Pierre e Miquelon\nPol:999 | Méd:911 | Bom:911\n\n# Santa Lúcia\nPol:911 | Méd:911 | Bom:911\n\n# São Cristóvão e Nevis\nPol:17 | Méd:15 | Bom:18\n\n# São Vicente e Granadinas\nPol:911 | Méd:911 | Bom:911\n\n# Trinidad e Tobago\nPol:999 | Méd:990 | Bom:990");
			stringOceania = new StringItem("- Oceania -", "\n# Austrália\nPol:000 or 112 móvel | Méd:000 or 112 móvel | Bom:000 or 112 móvel\n\n# Fiji\nPol:911 | Méd:911 | Bom:9170\n\n# Ilhas Marshall\nPol:6258666 | Méd:6254111  | Bom:local números\n\n# Ilhas Salomão\nPol:911 | Méd:911 | Bom:911\n\n# Kiribati\nPol:local números | Méd:994 | Bom:local números\n\n# Micronésia\nPol:local números | Méd:local números | Bom:local números\n\n# Nauru\nPol:local números | Méd:local números | Bom:local números\n\n# Nova Zelândia\nPol:111 | Méd:111 | Bom:111\n\n# Palau\nPol:911 | Méd:911 | Bom:911\n\n# Papua Nova Guiné\nPol:000 | Méd:local números | Bom:110\n\n# Samoa\nPol:995 | Méd:996 | Bom:994\n\n# Tonga\nPol:922 | Méd:933 | Bom:999\n\n# Tuvalu\nPol:911 | Méd:911 | Bom:911\n\n# Vanuatu\nPol:112 | Méd:112 | Bom:112");
			stringSouthamerica = new StringItem("- América do Sul -", "\n# Argentina\nPol:101 | Méd:107 | Bom:100\n\n# Bolívia\nPol:911 | Méd:911 | Bom:911\n\n# Brasil\nPol:190 | Méd:192 | Bom:193\n\n# Chile\nPol:133 | Méd:131 | Bom:132\n\n# Colômbia\nPol:119 | Méd:119 | Bom:119\n\n# Equador\nPol:101 | Méd:131 | Bom:102\n\n# Guiana\nPol:911 | Méd:913 | Bom:912\n\n# Paraguai\nPol:911 | Méd:911 | Bom:911\n\n# Peru\nPol:105 | Méd:116 | Bom:116\n\n# Suriname\nPol:115 | Méd:115 | Bom:115\n\n# Uruguai\nPol:911 | Méd:911 | Bom:911\n\n# Venezuela \nPol:171 | Méd:171 | Bom:171");

			// First-Aid-Text
			aid_disclaimer = new StringItem ("Aviso Legal", "1. Software \nPrimeiros Socorros no seu celular\nVersão: j3.0\nRelease: 2009-08-18\n\nCopyright: Kai Kajus Noack\nTradutor: Lucas Daniel Souza de Medeiros\nLicença: Creative Commons BY NC ND\n\nFiguras © Med4Teens\n\nEste programa tem o propósito de dar informações sobre primeiros socorros. No entanto, elas não substituem nenhum curso. É algo que serve para atualizar o conhecimento já adquirido.\n\n2. Disclaimer \nPor favor note que eu não me responsabilizo pelas consequências resultantes da utilização do software.\nQualquer responsabilidade é excluída!\nUtilização por sua conta e risco!\n\nEm todas as situações de emergência, por favor procurar ajuda profissional imediatamente.\n\n3. Projeto de Desenvolvimento \nO programa pretende tornar-se multilingue. Tradutores Voluntários são bem vindos!\n\nMais informações estão disponíveis na Internet www.firstai.de ou escreva um e-mail para: info@firstai.de\n\nSalvar uma vida, é ter salvado o mundo.");aid_general = new StringItem ("Conduta Geral", "1. Realizar sempre os primeiros socorros. Você não pode cometer erros.\n2. Prestar sempre atenção à sua própria segurança.\n3. Analisar a situação e garantir segurança no lugar do acidente.\n4. Chamada de emergência + Primeiros Socorros!\n5. Se existirem várias vítimas, o tratamento dos mais prejudicados tem prioridade.\n6. Tente acalmar a vítima. Fique calmo você também!\n7. Se possível deitá-lo(a) confortavelmente. Nunca dê álcool, nicotina ou drogas para uma pessoa.");aid_allergic = new StringItem ("Reação alérgica", "1. Telefone para uma ambulância imediatamente.\n2. Tente acalmar a vítima e deixá-lo sentar-se confortavelmente.\n3. Remover a causa da alergia (por exemplo um férrão de abelha) cuidadosamente.\n4. Esfrie a pele afetada (compressa úmida, gelo).\n5. Se tiver um antídoto, ele deve usá-lo (ajude-o).\n6. Monitore a condição da vítima até a ambulância chegar.\n7. Se o acidentado perder a consciência ou a respiração parar, siga instruções apropriadas!");aid_amputation = new StringItem ("Amputação", "A parte do corpo amputada pode ser recolocada. Objetivo: Manter a parte amputada arrefecida até chegar ao hospital.\n1. Acalmar a pessoa, deitá-lo(a) para baixo, e cobrir com cobertor.\n2. Parar o sangramento, consulte 'Hemorragia (grave)' e 'Choque'.\n3. Embrulhe a parte amputada em um pano limpo e seco, e colocá-la em um saco plástico impermeável.\n4. Fechar este saco plástico e colocá-lo em outro saco plástico, que contenha água fria/gelo.\n5. Não dê álcool, cigarros ou alimentos à vítima (no caso de uma cirurgia com anestesia no hospital).\n6. Não congele a parte amputada, (apenas mantenha fria).\n7. Ligue para emergência ou por ultimo leve-a ao hospital sozinho.");aid_animalbite = new StringItem ("Mordida de Animal", "Atenção: alto risco de infecção. Resultado poderia dar infecção, tétano, ou raiva.\n1. Lavar ferida com água quente sabão.\n2. Depois desinfecte a ferida.\n3. Se houver hemorragia grave, elevar a parte superior do corpo da pessoa.\n4. Aplicar um curativo asséptico.\n5. Vá a um hospital ou ligue para emergência.");aid_apnoea = new StringItem ("Apnéia", "Sem sons ou movimentos respiratórios, perceptível descoloração da pele.\n1. Chamada de emergência.\n2. Deite o acidentado de costas.\n3. Estique a cabeça pra trás. Remover objetos da boca e da garganta.\n4. Puxe o nariz e verifique se está fechado.\n5. Respire fundo e encaixe a boca na boca do acidentado, de forma que não possa vazar ar.\n6. Respire fora devagar e completamente.\n7. Senão tiver sucesso: Faça respiração até a ambulância chegar.");aid_asthma = new StringItem ("Asma", "Grande dificuldade em respirar. Chiado ruído respiratório. Ansiedades.\n1. Acalme à pessoa. Fique calmo você também!\n2. Afrouxar roupas.\n3. Deixe o acidentado sentar inclinado para frente, mande-o respirar devagar e profundamente.\n4. Se ocasionalmente tiver um inalador, ele deve usá-lo (ajude-o). 5-10 min após a utilização deverá fazer efeito.\n5. Caso não haja melhora: Use o inalador a cada 5 min até ambulância chegar.\n6. Chamada de emergência.\n7. Se houver apnéia, comece com a respiração.");aid_backinjury = new StringItem ("Lesões nas Costas", "Dor nas costas, braços e pernas dormentes.\n1. Não mova o acidentado!!\n2. Segure a cabeça do jeito que estiver, mantendo a pessoa estável (manter a sua cabeça parado)\n3. Estabilizar o acidentado com travesseiros na lateral.\n4. Acalme à vitima.\n5. Ligue para emergência, lembre-se de salientar o tipo de lesão.");aid_birth = new StringItem ("Nascimento", "Saída de líquido amniótico. Contração, ocorrerá dores. Nascimento inesperado.\n1. Preste atenção à privacidade e mantenha a calma! - Ligue para a emergência.\n2. Deixar a mulher grávida nua apenas parte inferior do seu corpo, e sente-se em local estéril sobre um calço com as pernas dobradas.\n3. Dobre os joelhos. Suba as pernas. Posição da bacia ligeiramente ascendente. - O parto é um processo natural e ocorrerá sem complicações.\n4. Mantenha a mulher calma, deixe-a concentrar-se na propria respiração: inspire através do nariz, e expire da boca para fora (em velocidade normal).\n5. Ritmo de pressionamento: Respire fundo, mantenha respiração, e pressione. Logo que a cabeça do bebê aparecer, apoie-o, segurando-o com ambas as mãos.\n6. Após o parto: Segure o bebê cuidadosamente com cabeça para baixo para liberar as vias aéreas e saida de líquido amniótico. (Talvez você tenha que sugar para fora o fluido a partir da boca do bebê pelo nariz.) O bebê deve respirar e chorar!\n7. Amarrar o cordão umbilical 30 centímetros de distância da criança (também pode ser feito no hospital). Mantenha a vagina da mãe estéril.\n8. Seque o bebê e o mantenha aquecido. Anote a hora e leve-a para o hospital.");aid_bleedinglight = new StringItem ("Sangramento leve", "Objetivo: Parar o sangramento.\n1. Não toque na ferida (risco de infecção).\n2. Não se trata ferida com pó ou sprays.\n3. Rratamento da ferida: utilize material estéril e uma bandagem.\n4. Para pequenas hemorragias é freqüentemente suficiente um tamponamento.\n5. Se for uma grande hemorragia usar uma atadura e cobrir com uma bandagem. Não se aplica à bandagem apertado como uma imobilização, pode levar ao aumento das hemorragias.\n6. Nota: Ferimentos de raiva têm que ser lavadas com solução de sabão.");aid_bleedingsevere = new StringItem ("Sangramento grave", "Salpicos, sangue pulsante. Perigo: Pode engasgar por causa da perda de sangue, infecções, a morte. Objetivo: Parar o sangramento.\n1. Remover roupas (cortar se necessário) e amostrar ferida.\n2. Enrole uma gaze ou se necessário, uma peça com a pressão em torno da ferida.\n3. Exercer pressão por pelo menos 10 min.\n4. Se for as bandagens ficarem encharcadas com sangue, não remova-as. Em vez disso, enrole outra bandagem / vestuário em torno do ferimento.\n5. Conservar o membro afetado (caso não esteja quebrado) mais elevado do que o coração para reduzir a quantidade de pressão arterial. Se possível deitar à viima.\n6. Se não parar de sangrar, manter a pressão sobre a ferida, e defina mais um ponto de pressão na ferida: Para uma hemorragia do antebraço comprima o braço (Pressione na face interna da veia do braço, no meio do cotovelo e na dobra do braço, utilizando seus dedos). Sangramento na perna deve-se fazer pressão de ponto no inguinal (pressione na veia da virilha trafulha, artéria onde leva mais de osso ilíaco, utilizando a sua palma da mão).\n7. Ligue para emergência médico imediatamente.\n8. Assim que o sangramento estiver sob controle: Iniciar medidas anti-asfixiante.");aid_brainconcussion = new StringItem ("Concussão no cerébro", "Dores de cabeça, náuseas, vômitos. Visão deficiente. Inconsciência pode ocorrer.\n1. Olhar desinteressado ou vago (ao infinito).\n2. Chame a emergência.\n\nSe sangrar a cabeça:\n1. Posicione a vítima, em uma posição de cabeça elevada (no travesseiro).\n2. Faça tratamento de ferida (utilize bandagem estéril).\n3. Ligue para emergência.");aid_burningslight = new StringItem ("Queimaduras Ligeiras", "Vermelhidão da pele. Leve inchaço. Dor.\n1. Mantenha a área queimada sob água fria.\n2. Aplicar curativo molhado folgadamente.");aid_burningsevere = new StringItem ("Queimaduras Graves", "Manchas de vermelho-branco e areas com formação de bolhas. A pele perde fluido. Danos profundos de tecido. Forte dor ou sem dor (por causa dos nervos queimados).\n1. Remover as roupas tanto quanto possível.\n2. Refrigere as partes do corpo queimado com água (cerca de 15 ° C, 59 ° F) por até 10 minutos, até a dor diminuir.\n3. Em casos em que a queimadura for extensa, utilize toalhas molhadas para esfriar.\n4. Ligue para emergência.\n5. Após o resfriamento da ferida: Use um curativo estéril. Não aplique qualquer fluido (sem cremes, óleos, pomadas, etc.) Não furar as bolhas.\n6. Controle a respiração e consciência da pessoa até a chegada da emergência.");aid_checkbreathing = new StringItem ("Checar Respiração", "1. Verifique sons respiratórios.\n2. Diagnosticar a respiração na parte superior do abdómen (leigos a sua mão sobre ela).\n3. No sentido respiração boca e nariz.");aid_chemicalburneyes = new StringItem ("Queimadura Quimica (Olhos)", "1. Ligue para emergência, leve a embalagem do produto químico, 'pois o mesmo tem telefone especifico para casos de acidentes.'\n2. Lave os olhos com muita água. Cubra algum olho saudável durante a lavagem.\n3. Conduzir o jato de água do ângulo interior do olho ao ângulo exterior do olho. Limpe durante pelo menos 20 minutos sob água.\n4. Fechar os dois olhos da vitima e cobri-lo com pano úmido.\n5. Monitore as condições até a ambulância chegar.");aid_chemicalburn = new StringItem ("Queimadura Quimica", "Lesões de tecido.\n1. Mente auto-defesa!\n2. Agir rapidamente e lavar os locais queimados.\n3. Ligar para emergência.\n4. Se há uma queimadura química no sistema digestivo uma das maneiras é beber muita água.\n5. Não provocar vômitos!");aid_dangerzone = new StringItem ("Zona de Perigo (Resgate)", "1. Realização: Posicione os braços da vitima na frente de seu peito, e ficar por trás dele / dela.\n2. Coloque as mãos sob os ombros dos feridos, agarrando o braço de forma angular.\n3. Puxar para trás e levar a pessoa em segurança.");aid_diabeticcoma = new StringItem ("Coma diabético", "Nível de açúcar no sangue for demasiado elevado (falta de insulina).\nSintomas: Sede, freqüência urinária, náuseas, vômitos. Respiração com cheiro de frutas / vinho.\n1. Ligue para emergência.\n2. Ajude a vitima (se for assegurada diabéticos) a tomar insulina.\n3. Posição de recuperação. (Não existem posições para os primeiros socorros.)\n4. Monitorar a condição da vitima até que chegue médico de emergência.");aid_diarrhoea = new StringItem ("Diarreia", "Reação para alimentos contaminados, a infecção do intestino ou distúrbio. Fezes é diluído, viscosas ou sanguinolenta.\n1. Perigo para a circulação devido à desidratação e perda de sal!\n2. Dê líquidos (chá, água).\n3. Se houver fortes perturbações levar ao médico de emergência.");aid_drowning = new StringItem ("Afogamento", "1. Chamada de emergência. Pergunte as pessoas próximas a você para ajudar.\n2. Resgate a pessoa para fora da água!\n3. Se a vitima estiver respirando: Posição de recuperação. Mantenha-o quente (cubra-o). Monitore seu estado até a chegada da ambulancia.\n4. Se a vitima não estiver respirando: Comece imediatamente com a reanimação! (Remover a água dos pulmões é inútil.)");aid_electricityaccident = new StringItem ("Acidente com Electricidade", "1. Em primeiro lugar interromper o fornecimento de electricidade!\nPerigo: inconsciência, apneia.\n2. A - inconsciência com a respiração\n3. B - inconsciência sem respirar");aid_emergencycall = new StringItem ("Ligar para emergência", "1. Disque 193 (bombeiros) 192 (SAMU). Sempre que possível, é de graça! Não hesite em ligar para uma ambulância! Ao telefonar você deve fornecer as seguintes informações:\n\n- O que tem acontecido\n- Onde (lugar do acidente)\n- Quantas vitimas\n- Que tipo de lesões.\n\nPosteriormente espere para novas investigações.");aid_epilepsy = new StringItem ("Epilepsia", "Corpo rígido, punhos fechados , mandíbula pressionada, contração muscular nos membros ou face. Olhos revirando. Salivação. possível inconsciência .\n1. Não segure a vitima ou o seu movimento.\n2. Coloque a vitima em uma base suave (almofadas), remover objetos proximos para evitar auto-lesão.\n3. Acalme a vitima. Afrouxar roupas, dar liberdade de respiração.\n4. Se a vitima vômitar, vire a cabeça para o lado que o vômito possa escorrer.\n5. Manter vias aéreas claro. Risco de engolir a língua.\n6. Posição recuperação: chame a emergência. Continuar a monitorar o estado da vítima.\n7. Mantenha os curiosos à distância.");aid_eyeinjury = new StringItem ("Lesões oculares", "1. Deixe objeto no olho da vitima, não remova-o!\n2. Mantenha os olhos sem se mexer para evitar novas lesões. Não toque no olho.\n3. Se olho está sangrando, cubra-o com uma compressa ou uma gaze estéril.\n4. Mantenha o olho com uma almofada fria (reduz edema, estanca a hemorragia mais rápido).\n5. Ligue para emergência ou leve-o por si mesmo.");aid_fracture = new StringItem ("Fratura", "Sintomas: Posição deslocada e mobilidade do osso. Deformação. Movimento doloroso, sensível ao toque.\n1. Evite movimentos!\n2. Ligar para emergencia.\n3. Imobilizar o osso fraturado, ou seja, imobilizar o local apoiado-o firmemente. Manter a posição do osso.\n4. Se for fratura aberta, cobrir a ferida com material estéril.");aid_frostbitemild = new StringItem ("Queimadura por frio leve", "Palidez, inchaços. Perigo para a irrigação sanguínea.\n1. Leve à vitima para uma zona quente.\n2. Afaste-se de frio, retire roupas frio, seque a pessoa.\n3. Aquecer com água morna e com o calor do corpo do ajudante.\n4. Dar bebida quente (chá). Nenhum álcool!");aid_frostbitesevere = new StringItem ("Queimadura por frio grave", "Pele extremamente fria, cinza-branca, bolhas, tecido morto. Perigo para o fornecimento de sangue!\n1. Ir para a área quente.\n2. Tratamento ferida / cobertura.\n3. Dê uma bebida açucarada.\n4. Não esfregue a vitima com material quente!\n5. Chame a emergência.");aid_heartattack = new StringItem ("Ataque do coração", "Pesados, com duração superior a 5 min de pressão e dor no peito, especialmente irradiando nos braços/ombros. Ansiedade, palidez, sudorese fria. Eventualmente, náuseas, falta de ar.\n1. Chame a emergência e peça o 'DEA'(desfribilador externo automatico)! Avise sobre o suposto ataque cardíaco.\n2. Posicione a parte superior do corpo elevada. Afrouxar roupas apertadas. Não dê drogas ou bebidas.\n3. Calmamente conversar com a pessoa em causa.\n4. Controle a consciência e respiração.\n5. Dê a aspirina se disponível.\n6. Se pessoa estiver inconsciente iniciar a reanimação.");aid_hypoglycaemia = new StringItem ("A hipoglicemia (níveis baixos de açúcar)", "Nível de açúcar no sangue está abaixo valor mínimo (porcausa de overdose de insulina suficiente ou não ingestão de alimentos).\nSintomas: Palidez, nervosismo, a fome, arrepios, suores.\n1. Certifique-se de que a pessoa é diabética (procure por um crachá de diabético).\n2. Chame a emergência.\n3. Dê uma bebida açucarada e dextrose/glicose (se não houver problemas de deglutição).\n4. Se pessoa está consciente e respira: Posição de recuperação. Monitore a respiração da pessoa. Se houver apneia, dê início com a respiração.\n5. Se não houver respiração, você pode colocar um pouco de açúcar na bochecha, empurre a partir de fora contra ele.");aid_hyperthermia = new StringItem ("Hipertermia (calor corporal)", "Sede, fraqueza, desorientação, náuseas, confusão, forte sudorese, pele quente.\n1. Chame a emergência.\n2. Encontre um lugar fresco (sala com ar condicionado preferível).\n3. Fixar pessoa, elevar as pernas. Afrouxar roupas.\n4. Arrefecer a pele com muita água ou passar toalha umida.\n5. Dê muita água ou sucos para beber.");aid_hypothermia = new StringItem ("A hipotermia (corpo frio)", "Arrepio frio, sonolência, cansaço, até inconsciência. Cor de pele pálida. Pulso lento, batimento cardíaco fraco.\n1. Vá a uma área quente/sala.\n2. Chamar a emergência.\n3. Pare de impacto do frio. Aumente da temperatura corporal (cubra e faça contato corpo-a-corpo).\n4. Remover roupas molhadas e colocar roupas quentes. Cobrir a cabeça.\n5. Dá chá quente, sopa quente ou água para beber. Nenhum álcool! Manter a pessoa acordada.\n6. Monitore a condição da vitima até que a emergencia chegue. Se pessoa ficar inconsciente, inicie a reanimação:\n7. A - inconsciência com a respiração\n8. B - inconsciência sem respirar");aid_icerescue = new StringItem ("Resgate no gelo", "Preste atenção à sua própria segurança. Perigo: Afogamento, hipotermia.\n1. Resgate via escada de bordo ou corda. O peso deve ser distribuído amplamente.\n2. Chame outras pessoas para ajudar. Deixe uma pessoa responsavel por chamar a ambulância.\n3. Rastejar cuidadosamente sobre sua barriga (se possível até um ponto estável) com a ferramenta para a violação.\n4. Manuseie sobre a vitima a distância da ferramenta, (não é a sua mão!) E puxe-a para fora.\n5. Rastejar para trás de volta para a beira.\n6. Primeiros socorros.\n7. Possível auto-salvamento: Se o gelo é sólido pode-se distribuir o seu peso sobre o gelo e puxe-se. Rastejar em sua barriga para a beira. Se gelo for frágil, pode tentar quebrar o gelo pedaço por pedaço até a beira.");aid_insectstings = new StringItem ("Picadas de Insetos", "Inchaço, vermelhidão, sensação de queimor, fraqueza, dificuldade respiratória, diminuição da consciência, taquicardia.\n1. Retire com cuidado o ferrão (com uma pinça). Não aperte o ferrão pois assim poderia injetar mais veneno.\n2. Refrigerar o local da causa (aplicar uma compressa fria).\n3. Área em questão deve ser mantida mais baixo do que o coração a fim de diminuir a circulação do veneno.\n4. Se a picada for na area boca-queixo: Abuse de gelados, e aplique uma compressa fria em torno da garganta.\n5. Se ocorrerem problemas graves chamar uma ambulância.");aid_nosebleeding = new StringItem ("Sangramento no Nariz", "Rompeu uma pequena artéria na ponta do nariz.\n1. Sente a pessoa com o sangramento, um pouco virada pra frente. Manter a cabeça reta.\n2. Não coloque a pessoa deitada, mantenha a cabeça acima do nivel do coração, para assim cessar o sangramento lentamente.\n3. Enrole o pescoço com pano frio.\n4. Pressione as narinas juntas até que estanque a hemorragia (por 10 min).\n5. Depois não assoe o nariz (sem sopros violentos).\n6. Se ocorrerem problemas graves ou sangramento não puder ser parado, chame a emergência médica.");aid_poisining = new StringItem ("Envenenamento", "Confusão, alucinações, pupilas dilatadas, febre, cãinbras. Inconsciência.\n1. Só dar antídotos, se forem acompanhados por um médico treinado.\n2. Não dê bebidas. Não provocar vômitos.\n3. Chame a emergência anotar o tipo do envenenamento!\n4. Guardar os restos do veneno e vomitar!\n5. Se vítima está consciente e respira: Manter em posição de recuperação . Monitore o estado da vitima ate a chegada da ambulância.\n6. Se a vítima não estiver respirando: Começar imediatamente com reanimação! Limpe a boca de vômito de antemão.");aid_recoveryposition = new StringItem ("Posição de Recuperação", "1. Coloque a vitima sobre as suas costas, posiciona as pernas. Joelho para baixo ao lado.\n2. Coloque o braço mais próximo a você em um ângulo reto com o corpo.\n3. Puxar braço mais afastado do peito e coloque as costas da mão contra a bochecha.\n4. Pegue o joelho longe, puxe-o para seu lado, e estabelecem-lo no chão. Posição da perna direita em um ângulo. Manter a mão sobre a bochecha da vitima.\n5. Certifique-se as vias aéreas estão livres.\n6. Boca ligeiramente aberta, e a posição da cabeça de forma que o vômito possa escorrer. Confira a respiração.\n7. Controle o estado da vitima até que a emergência chegue.");aid_resuscitation = new StringItem ("Reanimação", "# Massagem no Coração\n1. Deite a vitima de frente. Ajoelhe-se ao lado.\n2. Retire qualquer roupa que cubra o peito(regiao do coracao).\n3. Coloque uma mão aberta no meio do peito (um pouco acima do esterno).\n4. Colocar a outra mão sobre as costas da mão, que já está na posição correta.\n5. Estique os seus braços e cotovelos.\n6. Pressione 5 cm de profundidade no tórax da vitima (a força vem da parte superior do corpo) e solte.\n7. Pressione 30 vezes em uma linha em breve e forte!\n\n# Respiração\n1. Estique a cabeça para trás do pescoço. Remover substâncias para fora da boca e da garganta.\n2. Empurre as abas do nariz em conjunto, de forma que nariz fique fechado.\n3. Respire fundo e coloque a boca na boca da vitima, de forma que não pode vazar ar.\n4. Fazer a respiração boca-a-boca duas vezes (respiração lenta e totalmente fora).\n5. Depois fazer massagem cardíaca novamente.\n\nRepita a massagem cardíaca, respiração boca até a chegada da ambulância.");aid_safeguardaccident = new StringItem ("Segurança em Acidente", "1. Pare com seu próprio carro 50-100m atrás do local do acidente, (se você estiver em uma rodovia). Ligue os alertas. Ponha colentede visibilidade.\n2. Posicione o triângulo de aviso antes do local do acidente. Atenção: Se o acidente é uma curva posicione o triângulo de aviso antes da curva!\n3. Peça ajuda à outras pessoas.\n4. Abrir a porta do carro da vitima. Desligue ignição.\n5. Socorro às vítimas do acidente: soltar o cinto de segurança, mova o assento para trás. Deixe a remoção da vitima de dentro do carro pelo pessoal de resgate.\n6. Chame a emergência.\n7. Prossiga com os primeiros socorros.");aid_shock = new StringItem ("Choque", "Distúrbio circulatório pela fraca oferta de oxigênio no organismo.\nCausa: Perda de líquido, reduzido volume sanguíneo.\nSintomas: Palidez, pele fria, suor frio, ansiedade.\n1. Eliminar a causa do choque (por exemplo, parar a perda de fluido, vincular a ferida)!\n2. Estabelecer os feridos em um cobertor, a posição das pernas para cima. Manter a vitima calma.\n3. Chame a emergência.\n4. Se notar dificuldades em respirar ou consciência, iniciar reanimação.");aid_skullfracture = new StringItem ("Fratura Craniana", "Aspectos: sangramentos fora do nariz, boca ou ouvido. Muitas vezes existem feridas abertas no crânio.\n1. Mantenha as vias aéreas livres.\n2. Se consciente: Sente com os feridos curvando a cabeça para frente. Evitar maiores movimentos!\n3. Se inconsciente: Posição de Recuperação (sem pressão sobre a ferida da cabeça).\n4. Chame a emergência.\n5. Aplicar curativo na cabeça.\n6. Se as dificuldades em respirar ou consciência, iniciar reanimação.");aid_snakebite = new StringItem ("Acidente ofídico", "Ferimento no tamanho de um alfinete, dor severa, edema, cor púrpura. Distúrbio circulatório, perigo de choque.\n1. Estabilize a parte do corpo ferida.\n2. Aplicar compressa fria ao redor da ferida.\n3. Utilize medidas contra choque.\n4. Chame a emergência.");aid_sos = new StringItem ("SOS", "1. Sinal: 3x curto, longas 3x, 3x curto.\n2. Visualmente (luz estrobo, lanterna), ou acusticamente (sinal de apito, bater).");aid_sprain = new StringItem ("Esforços + distenção", "Dor, inchaço (contusão), perda da função, deformação do membro.\n1. Imobilize a parte lesada do corpo apenas na posição mais confortável para a vitima.\n2. Resfriar (utilizando bolsa de gelo).\n3. Se possível, elevar a parte lesada.\n4. Ir para o hospital ou chamar a emergência médica.");aid_stroke = new StringItem ("Ataque Súbito", "Súbita sensação de dormência ou paralisia (face, braços, pernas), perturbações da linguagem compreensão, a visão problemas de consciência perturbada, uma forte dor de cabeça. Problemas na respiração e deglutição, perda de controle sobre a bexiga e intestino.\n1. Chame a emergência!\n2. Afrouxar roupas apertadas, não dê drogas ou bebidas.\n3. Sentar ou deita-lo confortavelmente. Acalme-o!\n4. Controle consciência e respiração.\n5. Se sentir dificuldades em respirar ou consciência, iniciar reanimação.");aid_suffocation = new StringItem ("Asfixia", "A insuficiência de oxigénio. Traquéia fechou. Perigo: apneia.\nSintomas: ofegante ruído respiratório, tosse constante, falta de ar, descoloração da pele.\n1. Ação imediata! Deixa a pessoa aflita com tosse muito forte.\n2. Bata firmemente com uma mão nas costas plana entre as escápulas.\n3. Se sem sucesso: Fique atrás da vitima, braços em volta da cintura, curvar ligeiramente para frente.\n4. Firmar o seu punho, posição que tinha à altura do estômago da pessoa, e levá-la com a outra mão.\n5. Ao abraçar usar as duas mãos para dar um duro golpe para cima em direção O estômago (seria como tentar levantar a pessoa).\n6. Repita até 5-vezes! Vias respiratórias devem ficar isentas do objeto.\n7. Chamada de emergência.\n8. Se os primeiros socorros não for bem-sucedido, continue à fazê-lo até que chegue a emergência.");aid_sunburn = new StringItem ("Queimadura solar", "1. Retire a pessoa afectada a partir de luz solar direta. Evitar maiores exposições.\n2. Beba muita água para reparar a desidratação.\n3. Se existir uma grave queimadura solar (bolhas, vermelhidão, dor), procurar um médico.\n4. Se a pele tiver um leve vermelho, ela pode ser arrefecida com toalha molhada. Usar gel ou loção após o a exposição.");aid_sunstroke = new StringItem ("Insolação", "Cabeça quente vermelho, pele fria, de doença, de cabeça, tontura. Causa: irritação da membrana cerebral.\n1. Vá para um lugar frio (sombra) e colocar a parte superior do corpo da pessoa para cima.\n2. Esfriar a cabeça com cobertores molhados.\n3. Chame a emergência, mantenha o controle da respiração.\n4. Se consciente: Ministre bebida fresca, se aplicável.\n5. Se aparecer apneia, inicie a respiração:\n6. Vá em frente dê-lhe respiração!");aid_unconsciouswithbreath = new StringItem ("Inconsciência com respiração", "Nenhuma reação em voz alta a perguntas, sem resposta sobre agitação. Existe apenas respiração.\n1. Se há pessoas próximas a você peça ajuda.\n2. Posição de recuperação. Boca aberta de maneira que o vômito possa escorrer.\n3. Chame a emergência.");aid_unconsciouswithoutbreath = new StringItem ("Inconsciência sem respirar", "1. Nenhuma reação da vítima, sem respirar.\n\nInicie Reanimação.");aid_vomiting = new StringItem ("Vômito", "Surge a partir de náuseas. Estômago esvazia por si mesmo. Causas: Infecção, intoxicação, úlcera, drogas, comida ruim, ou gravidez.\n1. Perigo para a circulação devido à desidratação e perda de sal!\n2. Dê líquidos (chá, água).\n3. Se houver fortes perturbações, com sangue ou vômitos contínuos chame a emergência médica.");separator = new StringItem ("Separator", "-");			separator = new StringItem ("Separator", "-");
			stringItemArray = new StringItem[] {
					aid_disclaimer, separator, aid_general, aid_resuscitation, aid_diabeticcoma, aid_hypoglycaemia, aid_hypothermia, aid_electricityaccident, aid_safeguardaccident, aid_snakebite, aid_drowning, aid_amputation, aid_apnoea, aid_suffocation, aid_asthma, aid_heartattack, aid_stroke, aid_checkbreathing, aid_shock, aid_diabeticcoma, aid_brainconcussion, aid_diarrhoea, aid_asthma, aid_suffocation, aid_poisining, aid_epilepsy, aid_sprain, aid_fracture, aid_skullfracture, aid_backinjury, aid_hyperthermia, aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_sunstroke, aid_backinjury, aid_eyeinjury, aid_emergencycall, aid_animalbite, aid_birth, aid_insectstings, aid_recoveryposition, aid_frostbitesevere, aid_frostbitemild, aid_chemicalburn, aid_chemicalburneyes, aid_sunburn, aid_burningsevere, aid_burningslight, aid_allergic, aid_resuscitation, aid_icerescue, aid_apnoea, aid_bleedingsevere, aid_bleedinglight, aid_nosebleeding, aid_safeguardaccident, aid_sos, aid_vomiting, aid_dangerzone, separator}; 

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
		else if (auswahl==12 || auswahl==51) { details.append(aid067);        details.append(""); details.append(aid010);        details.append(""); details.append(aid011); }
		  // img:backinjury
		  else if (auswahl==34 || auswahl==29) { details.append(aid065); }
		  // img:birth
		  else if (auswahl==38) { details.append(aid025);        details.append(""); details.append(aid022);         details.append(""); details.append(aid023); }
		  // img:chemicalburneyes
		  else if (auswahl==44) { details.append(aid019); }
		  // img:bleedinglight
		  else if (auswahl==53) { details.append(aid084);           details.append(""); details.append(aid085); }
		  // img:bleedingsevere
		  else if (auswahl==52) { details.append(aid084);           details.append(""); details.append(aid085);           details.append(""); details.append(aid089);           details.append(""); details.append(aid092); }
		  // img:brainconcussion
		  else if (auswahl==20) { details.append(aid061); }
		  // img:dangerzone
		  else if (auswahl==58) { details.append(aid001); }
		  // img:drowning
		  else if (auswahl==10) { details.append(aid034); }
		  // img:electricityaccident
		  else if (auswahl==7) { details.append(aid045); }
		  // img:epilepsy
		  else if (auswahl==25) { details.append(aid058); }
		  // img:fracture
		  else if (auswahl==27) { details.append(aid107); }
		  // img:heartattack
		  else if (auswahl==15) { details.append(aid061); }
		  // img:icerescue
		  else if (auswahl==50) { details.append(aid041); }
		  // img:recoveryposition
		  else if (auswahl==40) { details.append(aid008);          details.append(""); details.append(aid009);          details.append("\nPosição de recuperação para bebês:"); details.append(aid028); }
		  // img:resuscitation
		  else if (auswahl==3 || auswahl==49) {          details.append(aid013);
		details.append(""); details.append(aid003);          details.append(""); details.append(aid067);          details.append(""); details.append(aid010);
		         details.append(""); details.append(aid011);          details.append(""); details.append(aid012);
		details.append("\n\n# Ressuscitação (Bebê)\n\nUse apenas dois dedos:"); details.append(aid029);          details.append("\nNão respire muito forte:"); details.append(aid030); }
		  // img:safeguardaccident
		  else if (auswahl==55 || auswahl==8) { details.append(aid001); }
		  // img:suffocation
		  else if (auswahl==13 || auswahl==23) { details.append(aid031);          details.append(""); details.append(aid069); }
		  // img:sunstroke
		  else if (auswahl==33) { details.append(aid061); }
		  // img: unconsciouswithbreath
		  else if (auswahl==31) { details.append(aid008);          details.append(""); details.append(aid009); }
		  // spacer below
		  details.append("");

		  // append Resuscitation measures! for unconsciouswithoutbreath / drowning / heartattack / brainconcussion / stroke / shock / poisining
		  if (auswahl==32 || auswahl==10 || auswahl==15 || auswahl==20 || auswahl==16 || auswahl==18 || auswahl==24) { 
		   details.append(aid_resuscitation);     details.append(aid013);     details.append(""); details.append(aid003);  details.append(""); details.append(aid067);      details.append(""); details.append(aid010);  details.append(""); details.append(aid011);      details.append(""); details.append(aid012);  }
		  // for electricity / hypothermia
		  else if (auswahl==7 || auswahl==6) {    details.append(aid_unconsciouswithbreath);    details.append("");   details.append(aid_unconsciouswithoutbreath); 
		   details.append("");   details.append(aid_resuscitation);      details.append(""); details.append(aid003);   details.append(""); details.append(aid067);     details.append(""); details.append(aid010);  details.append(""); details.append(aid011);   }
		 // for sunstroke / asthma / hypoglycaemia
		  else if (auswahl==33 || auswahl==14 || auswahl==5) {    details.append(aid_apnoea);  details.append(""); details.append(aid010);    details.append(""); details.append(aid011);   }
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
			else if (telEmergency.getSelectedIndex() == 1) { details.append(stringNorthamerica); }
			else if (telEmergency.getSelectedIndex() == 2) { details.append(stringSouthamerica); }
			else if (telEmergency.getSelectedIndex() == 3) { details.append(stringAsia); }
			else if (telEmergency.getSelectedIndex() == 4) { details.append(stringEurope); }
			else if (telEmergency.getSelectedIndex() == 5) { details.append(stringOceania); }
			display.setCurrent(details);
		}
		// Main Menu
		else if (display.getCurrent().getTitle() == menu.getTitle()) {
			if (menu.getSelectedIndex() == 1) { 
				display = Display.getDisplay(this);
				display.setCurrent(telEmergency);
			}
			// catch divider
			else if (menu.getSelectedIndex() == 59) { }
			// notruf
			else if (menu.getSelectedIndex() == 60) {
				try {
					platformRequest("tel:192");
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
