// current: LOAD PNG image
// project - properties - addresources - png Image

// http://msdn.microsoft.com/en-us/library/aa918637.aspx
// http://social.msdn.microsoft.com/forums/en-US/vssmartdevicesnative/thread/9cea3ea8-77de-4c0c-827e-c20a68a7d9a7
// http://stackoverflow.com/questions/809946/jpeg-loading-on-windows-mobile
// http://www.eggheadcafe.com/conversation.aspx?messageid=33814328&threadid=33814325
// http://expression.microsoft.com/en-us/dd279543.aspx (bmp)


using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Imaging;
using System.Text;
using System.Windows.Forms;

using System.Diagnostics;
using System.Runtime.InteropServices;

using System.Reflection; // for assembly, stream http://msdn.microsoft.com/de-de/library/xc4235zt.aspx
using System.IO; // for STREAM


namespace FirstAid3 {


    public partial class Form1 : Form
    {
        [DllImport("coredll.dll")]  // [DllImport("coredll.dll", CharSet = CharSet.Auto)]
        static extern int DrawText(IntPtr hdc, string lpStr, int nCount, ref Rectangle lpRect, int wFormat);

        //[DllImport("Microsoft.WindowsMobile.Status.dll")]        // Microsoft.WindowsMobile.Status.dll
        //static void showPhoneNumber();

        // FIRST AID TEXTS
        string aid_disclaimer = "1. Software\nErste Hilfe auf dem Handy\nVersion: w0.1pre\nRelease: 2009-09-17\nCopyright: Kai Kajus Noack\nLizenz: Creative Commons\n\nIllustrationen © Med4Teens\n\nDieses Programm soll Informationen zur Ersten Hilfe geben. Es stellt jedoch in keiner Weise einen Ersatz für einen Erste-Hilfe-Kurs dar, sondern dient der Auffrischung des bereits erworbenen Wissens.\n\n2. Haftungsausschluss\nBitte beachten Sie, dass ich keine Verantwortung für Konsequenzen, die aus der Nutzung entstehen, übernehme.\nJEGLICHE HAFTUNG IST AUSGESCHLOSSEN!\nVERWENDUNG AUF EIGENE GEFAHR!\n\nIn allen Notfällen suchen Sie bitte sofort professionelle Hilfe.\n\n3. Entwicklung des Projekts\nDas Programm soll vielsprachig werden. Freiwillige Übersetzer gesucht!!\n\nWeitere Informationen erhaltet ihr im Internet unter www.firstai.de oder schreibt eine E-Mail an: info@firstai.de\n\nRette einen Menschen und du rettest die ganze Welt.";
        string aid_general = "1. Leisten Sie immer Erste Hilfe. Sie können keine Fehler machen.\n\n2. Achten Sie immer auf Ihre eigene Sicherheit.\n\n3. Machen Sie sich ein Bild von der Situation + Sichern Sie die Unfallstelle.\n\n4. Notruf + Sofortmaßnahmen!\n\n5. Bei mehreren Verletzten hat der am stärksten bedrohte Vorrang.\n\n6. Beruhigen Sie den Betroffenen. Und bleiben Sie selbst ruhig!\n\n7. Lagern Sie den Betroffenen falls möglich bequem. Grundsätzlich nie Alkohol, Nikotin oder Medikamente verabreichen.";
        string aid_allergic = "1. Notruf absetzen.\n\n2. Beruhigen des Betroffenen und bequem hinsetzen.\n\n3. Allergie-auslösenden Stoff (z. B. Insektenstachel) vorsichtig entfernen.\n\n4. Betroffene Hautstelle kühlen (feuchter Umschlag, Eis).\n\n5. Falls Betroffener ein Gegenmittel hat, sollte er dieses nutzen.\n\n6. Kontrolle des Zustands bis Notarzt eintrifft.\n\n7. Bei eintretender Bewusstlosigkeit oder Atemnot entsprechende Maßnahmen ergreifen!";
        string aid_amputation = "Abgetrennter Körperteil kann wieder angenäht werden. Ziel: Amputat bis zum Eintreffen im Krankenhaus kühlen. \n\n1. Betroffenen beruhigen, hinlegen und zudecken.\n\n2. Blutung stoppen, siehe 'Blutung (schwer)' und 'Schock'.\n\n3. Abgetrennten Körperteil in ein sauberes trockenes Tuch wickeln und in eine wasserdichte Plastiktüte legen. \n\n4. Diese Plastiktüte verschließen und in eine zweite Plastiktüte legen, die kühles Wasser/Eis enthält. \n\n5. Keinen Alkohol, Zigaretten oder Essen geben (falls im Krankenhaus mit Narkose operiert wird). \n\n6. Das Amputat nicht einfrieren (nur kühlen). \n\n7. Notarzt rufen oder selbst zum Krankenhaus fahren. ";
        string aid_animalbite = "Achtung, hohe Infektionsgefahr. Folgen wie Eiter, Tetanus, Tollwut.\n\n1. Wunde sofort mit heißem Seifenwasser auswaschen.\n\n2. Anschließend Wunddesinfektion auftragen.\n\n3. Bei starker Blutung den Oberkörper erhöht lagern.\n\n4. Keimfreien Verband anlegen.\n\n5. Krankenhaus aufsuchen oder Notruf absetzen.";
        string aid_apnoea = "Keine Geräusche oder Atembewegungen, auffallende Hautverfärbung.\n\n1. Notruf absetzen.\n\n2. Betroffenen auf Rücken legen.\n\n3. Entfernen von Fremdkörpern aus Mund und Rachen. Überstrecken des Kopfes in den Nacken.\n\n4. Nasenflügel zusammendrücken, damit Nase geschlossen ist.\n\n5. Tief einatmen und Mund auf Mund des Betroffenen aufsetzen, sodass keine Luft entweichen kann.\n\n6. Langsam und vollständig ausatmen.\n\n7. Falls ohne Erfolg: Atemspende fortsetzen bis Notarzt eintrifft.";
        string aid_asthma = "Starke Atemnot. Pfeifendes Atemgeräusch. Angstgefühle.\n\n1. Beruhigen des Betroffenen. (Bleiben Sie selbst ruhig!)\n\n2. Kleidung lockern.\n\n3. Betroffenen bequem leicht nach vorne gebeugt hinsetzen und auffordern, langsam und tief ein- und auszuatmen.\n\n4. Falls der Betroffene einen Inhalator besitzt, sollte dieser benutzt werden (helfen Sie dabei). Nach 5-10 min sollte sich Wirkung zeigen.\n\n5. Sofern keine Besserung eintritt: Inhalator jede 5 min anwenden, solange bis Notarzt eintrifft.\n\n6. Notruf absetzen.\n\n7. Falls es zum Atemstillstand kommt, mit der Beatmung beginnen.";
        string aid_backinjury = "Schmerzen im Rücken, gefühllose Arme und Beine.\n\n1. Verletzten auf keinen Fall bewegen!\n\n2. Kopf so halten, dass Betroffener stabil liegt.\n\n3. Verletzten nur mittels seitlicher Polsterung stabilisieren.\n\n4. Betroffenen beruhigen.\n\n5. Notruf absetzen, Hinweis auf Rückenverletzung.";
        string aid_birth = "Abgang von Fruchtwasser. Presswehen treten ein. Unerwartete Geburt.\n\n1. Intimsphäre wahren und Ruhe bewahren! - Notruf absetzen.\n\n2. Die Schwangere breitbeinig, mit freigemachtem Unterkörper auf sterile Unterlage hinsetzen.\n\n3. Kniee anwinkeln. Beine etwas heranziehen. Becken leicht erhöht lagern. - Die Geburt ist ein natürlicher Prozess und läuft häufig ohne Komplikationen ab.\n\n4. Schwangere beruhigen und auf Atmung konzentrieren lassen: Durch Nase einatmen und Mund ausatmen (normales Atemtempo).\n\n5. Pressrhythmus: Tief Luft holen, anhalten und pressen. Sobald Kopf des Babys erscheint, mit beiden Händen unterstützend zugreifen.\n\n6. Nach der Geburt: Neugeborenes schräg nach unten hängen, um Fruchtwasser aus Atemwegen zu befreien. (Evtl. mit dem Mund das Fruchtwasser aus der Nase des Babys absaugen.) Kind muss atmen und schreien!\n\n7. Nabelschnur 30 cm vom Kind entfernt abbinden (kann auch im Krankenhaus erfolgen). Scheide der Mutter steril abdecken.\n\n8. Das Baby abtrocknen und warm halten. Uhrzeit notieren und zum Krankenhaus fahren.";
        string aid_bleedinglight = "Ziel: Stoppen der Blutung.\n\n1. Wunde nicht berühren (Infektionsgefahr).\n\n2. Wunde nicht mit Puder, Salben, Sprays behandeln.\n\n3. Wundversorgung mittels keimfreier Wundauflage und Befestigungsmaterial (Pflaster, Binde).\n\n4. Bei kleiner Blutung reicht meist ein Pflasterstreifen.\n\n5. Bei großflächiger Verletzung Wundauflage und Verbandtuch benutzen. Verband nicht zu fest binden, da Stauung zu vermehrter Blutung führt.\n\n6. Hinweis: Tollwut-Wunden mit Seifenlösung auswaschen.";
        string aid_bleedingsevere = "Spritzendes, in Stößen austretendes Blut. Gefahr: Schock durch Blutverlust, Infektionen, Tod. Ziel: Stoppen der Blutung.\n\n1. Kleidung entfernen (notfalls aufschneiden), Wunde freilegen.\n\n2. Binde oder notfalls Kleidungsstück mit Druck um Wunde wickeln.\n\n3. Für mind. 10 min Druck auf Wunde ausüben.\n\n4. Falls Binde mit Blut durchnässt, nicht die alte Binde entfernen! Eine andere Binde/Kleidungsstück darüber binden.\n\n5. Verletztes Glied (sofern nicht gebrochen) über Höhe des Herzens lagern, damit sich Blutung verlangsamt. Wenn möglich Betroffenen hinlegen.\n\n6. Falls Blutung nicht stoppt, Druck auf Wunde beibehalten und zusätzlich Druckpunkte über der Wunde setzen: Bei Blutung am Unterarm den Oberarm abdrücken (Ader auf Arm-Innenseite mittig zwischen Ellbogen und Achselhöhle, mit Fingern abdrücken). Bei Blutung des Beins, Druckpunkt in Leiste setzen (Ader in Leistenbeuge, wo Arterie über Beckenknochen verläuft, mit Handballen abdrücken).\n\n7. Sofort Notarzt anfordern.\n\n8. Sobald Blutung unter Kontrolle: Schockbekämpfung einleiten.";
        string aid_brainconcussion = "Kopfschmerz, Übelkeit, Erbrechen. Sehstörung. Bewusstlosigkeit kann eintreten.\n\n1. Betroffenen hinlegen.\n\n2. Notruf absetzen.\n\nBei Blutung am Kopf:\n\n1. Betroffenen hinlegen, Kopf erhöht lagern (Kissen).\n\n2. Wundversorgung durchführen (Kopf-Verband anlegen).\n\n3. Notruf absetzen.";
        string aid_burningslight = "Rötung der Haut. Leichte Schwellung. Schmerzen.\n\n1. Betroffene Stelle unter laufendem kalten Wasser kühlen.\n\n2. Feuchten Verband locker anlegen.";
        string aid_burningsevere = "Gefleckte weiße rote Stellen, Blasenbildung. Flüssigkeitsaustritt aus Haut. Tiefe Gewebeschädigung. Starke Schmerzen oder keine Schmerzen (aufgrund verbrannter Nerven).\n\n1. Kleidung soweit wie möglich entfernen.\n\n2. Mit kaltem Wasser (ca. 15°C) bis zu 10 min kühlen, bis Schmerzlinderung eintritt.\n\n3. Falls Verbrennung großflächig, nur mit feuchten Tüchern kühlen.\n\n4. Notruf absetzen.\n\n5. Nach Kühlung die Wundversorgung durchführen. Sterile, trockene Wundauflage benutzen. Keine Flüssigkeiten aufbringen (keine Cremes, Öle, Salben etc.). Blasen nicht aufstechen.\n\n6. Atmung und Bewusstsein des Betroffenen kontrollieren, bis Notarzt eintrifft.";
        string aid_checkbreathing = "1. Atemgeräusche prüfen.\n\n2. Atmung am Oberbauch feststellen (Hand auflegen).\n\n3. Atmung an Nase/Mund fühlbar.";
        string aid_chemicalburneyes = "1. Notarzt rufen, auf Ätz-Substanz hinweisen.\n\n2. Auge sofort mit viel Wasser spülen. Gesundes Auge während Spülung abdecken.\n\n3. Wasserstrahl vom inneren Augenwinkel zum äußeren Augenwinkel. Ca. 20 min reinigen.\n\n4. Beide Augen des Betroffenen schließen und mit angefeuchtetem Tuch verbinden.\n\n5. Zustand kontrollieren, bis Notarzt eintrifft.";
        string aid_chemicalburn = "Zerstörung von Gewebe.\n\n1. Eigenschutz beachten!\n\n2. Zügig handeln und verätzte Stellen abspülen.\n\n3. Notruf absetzen.\n\n4. Bei Verätzung des Verdauungsweges: Vermehrt Flüssigkeit trinken.\n\n5. Kein Erbrechen auslösen!";
        string aid_dangerzone = "1. Grifftechnik: Arm des Verletzten vor dessen Brust, hinter den Verletzten stellen.\n\n2. Mit beiden Händen den angewinkelten Arm des Verletzten durch dessen Achseln greifen.\n\n3. Person in Sicherheit bringen.";
        string aid_diabeticcoma = "Blutzuckerspiegel zu hoch bzw. Insulinmangel.\nSymptome: Durst, häufiges Wasserlassen, Übelkeit, Erbrechen. Atem riecht nach Obst.\n\n1. Notruf absetzen.\n\n2. Unterstützung bei der Insulingabe, sofern sichergestellt, dass Diabetiker.\n\n3. Stabile Seitenlage. (Keine weiteren Möglichkeiten für den Ersthelfer.)\n\n4. Zustand des Betroffenen kontrollieren bis Notarzt eintrifft.";
        string aid_diarrhoea = "Nahrungsmittel-Unverträglichkeit, Darm-Entzündung oder Erkrankung. Stuhlgang wässrig, schleimig oder blutig.\n\n1. Gefahr für Kreislauf aufgrund Flüssigkeits- und Salz-Verlustes!\n\n2. Flüssigkeit zuführen (Tee, Wasser).\n\n3. Bei starken Beschwerden Arzt aufsuchen oder Notruf absetzen.";
        string aid_drowning = "1. Notruf absetzen. Personen in der Nähe um Hilfe bitten.\n\n2. Aus Wasser retten!\n\n3. Wenn Atmung vorhanden: Stabile Seitenlage. Betroffenen warm halten (Decke). Zustand kontrollieren, bis der Notarzt eintrifft.\n\n4. Bei Atemstillstand sofort mit Wiederbelebung beginnen! (Ausfließenlassen von Wasser aus Lungen ist nutzlos.)";
        string aid_electricityaccident = "1. Zuerst Stromzuleitung unterbrechen!\nGefahr: Bewusstlosigkeit, Atemstillstand.\n\n2. A - Bewusstlosigkeit mit Atmung\n\n3. B - Bewusstlosigkeit ohne Atmung";
        string aid_emergencycall = "1. Wählen Sie mit dem nächst-verfügbaren Telefon 112. Immer möglich und kostenlos! Zögern Sie nie, den Notarzt zu rufen!\n\n2. Am Telefon Folgendes durchgeben:\n\n- Wo (Unfallort).\n\n- Was ist passiert.\n\n- Wie viele Verletzte.\n\n- Welche Verletzungen.\n\nDanach auf Rückfragen warten.";
        string aid_epilepsy = "Starrer Körper, geballte Fäuste, gepresster Kiefer, Zucken in Beinen oder Gesicht. Rollende Augen. Speichelfluss. Bewusstlosigkeit möglich.\n\n1. Betroffenen nicht halten oder in Bewegung einschränken.\n\n2. Betroffenen auf weiche Unterlage (Kissen) legen, Objekte in direkter Nähe entfernen, somit Selbstverletzungen vorbeugen.\n\n3. Beruhigend zum Betroffenen reden. Kleidung lockern, für Atemfreiheit sorgen.\n\n4. Falls Betroffener erbricht, Kopf zur Seite drehen, damit Erbrochenes abfließen kann.\n\n5. Atemwege freihalten. Gefahr, dass Zunge verschluckt wird.\n\n6. Stabile Seitenlage + Notruf absetzen. Weiterhin Zustand des Betroffenen kontrollieren.\n\n7. Andere Leute auf Distanz halten.";
        string aid_eyeinjury = "1. Fremdkörper im Auge belassen, nicht entfernen.\n\n2. Augen nicht bewegen, um weitere Verletzungen zu vermeiden. Auge nicht berühren.\n\n3. Bei Augen-Blutung mit Kompresse oder Verbandtuch bedecken.\n\n4. Auge mit kalter Auflage kühlen (verringert Schwellung, Blutung stoppt schneller).\n\n5. Notruf absetzen oder selbst zum Krankenhaus fahren.";
        string aid_fracture = "Anzeichen: Unnatürliche Lage und Beweglichkeit. Deformierung. Schmerzhafte Bewegung, berührungsempfindlich.\n\n1. Bewegungen vermeiden!\n\n2. Notruf absetzen.\n\n3. Bruch ruhig stellen, d.h. Umpolstern mit dichtem Material. Position des gebrochenen Knochens beibehalten.\n\n4. Bei offenem Bruch die Wunde keimfrei abdecken.";
        string aid_frostbitemild = "Blässe, Schwellen. Gefahr für Blutzufuhr.\n\n1. Warmen Bereich aufsuchen.\n\n2. Kälte beseitigen. Nasse Kleidung entfernen, abtrocknen.\n\n3. Aufwärmen mit lauwarmem Wasser und Körperwärme des Helfers.\n\n4. Warmes Getränk (Tee) geben. Keinen Alkohol!";
        string aid_frostbitesevere = "Kalte harte Haut, grau-weiß, Blasenbildung, Gewebe stirbt ab. Gefahr für Blutzufuhr!\n\n1. Warmen Bereich aufsuchen.\n\n2. Wunden versorgen/abdecken.\n\n3. Zuckerhaltiges Getränk verabreichen.\n\n4. Nicht warmreiben!\n\n5. Notruf absetzen.";
        string aid_heartattack = "Schwere mehr als 5 min anhaltende Schmerzen + Druck im Brustkorb, besonders in Arme/Schultern ausstrahlend. Angstgefühl, Blässe, kalter Schweiß. Eventuell Übelkeit, Kurzatmigkeit.\n\n1. Notruf absetzen! Hinweis auf vermuteten Herzinfarkt.\n\n2. Oberkörper erhöht lagern. Enge Kleidung lockern. Keine Medikamente oder Getränke geben.\n\n3. Beruhigend auf Betroffenen einreden.\n\n4. Bewusstsein und Atmung kontrollieren.\n\n5. Dem Betroffenen Aspirin verabreichen, falls verfügbar.\n\n6. Bei Bewusstlosigkeit die Wiederbelebung einleiten.";
        string aid_hypoglycaemia = "Blutzuckerspiegel unter Mindestwert (aufgrund Überdosierung von Insulin oder ungenügender Nahrungsaufnahme).\nSymptome: Blässe, Nervosität, Hunger, Zittern, Schweiß.\n\n1. Zuerst klären, ob der Betroffene Diabetiker ist (siehe Diabetiker-Ausweis).\n\n2. Notruf absetzen.\n\n3. Dem Betroffenen gezuckerte Getränke und Traubenzucker geben (sofern keine Schluckschwierigkeiten).\n\n4. Bei Bewusstlosigkeit und vorhandener Atmung: Stabile Seitenlage einnehmen und Atmung kontrollieren. Falls Atemstillstand eintritt, den Betroffenen beatmen.\n\n5. Wenn Atmung vorhanden, dem Bewusstlosen ein Stück Zucker in die Backentasche legen und von außen gegendrücken.";
        string aid_hyperthermia = "Durst, Schwäche, Desorientiertheit, Bewusstseinsstörung, starker Schweiß, heiße Haut.\n\n1. Notruf absetzen.\n\n2. Kühlen, schattigen Platz aufsuchen (Raum mit Klimaanlage sehr geeignet).\n\n3. Betroffenen hinlegen, Beine hochlagern. Kleidung lockern.\n\n4. Haut mit Wasser kühlen oder kalte Handtücher auflegen.\n\n5. Viel Wasser oder Säfte trinken.";
        string aid_hypothermia = "Kältezittern, Schläfrigkeit, Erschöpfung, bis hin zur Bewusstlosigkeit. Kalte, blasse Haut. Langsamer Puls, schwacher Herzschlag.\n\n1. Warmen Bereich aufsuchen.\n\n2. Notruf absetzen.\n\n3. Kälteeinwirkung beenden. Körpertemperatur erhöhen (Decke und Körper-zu-Körper-Kontakt).\n\n4. Nasse Kleidung entfernen und trockene warme Kleidung anziehen. In Decken packen. Kopf bedecken.\n\n5. Heißen Tee, Brühe oder heißes Wasser zu trinken geben. Keinen Alkohol! Betroffenen wachhalten.\n\n6. Zustand bis zum Eintreffen des Notarztes kontrollieren. Bei Verlust des Bewusstseins Wiederbelebung einleiten.\n\n7. A - Bewusstlosigkeit mit Atmung\n\n8. B - Bewusstlosigkeit ohne Atmung";
        string aid_icerescue = "Eigenschutz beachten! Gefahr: Ertrinken, Unterkühlung.\n\n1. Rettung erfolgt via Leiter, Brett, Stange. Gewicht muss großflächig verteilt werden.\n\n2. Andere Personen um Mithilfe auffordern. Notruf absetzen lassen.\n\n3. Auf Bauch (möglichst angeseilt) mit Hilfsmittel vorsichtig zur Einbruchstelle robben.\n\n4. Verunglücktem auf Distanz das Hilfsmittel reichen (nicht die Hand!) und herausziehen.\n\n5. Rückwärts bis zum Ufer zurückrobben.\n\n6. Erste-Hilfe-Maßnahmen.\n\n7. Eigenrettung möglich: Bei festem Eis Gewicht auf Eis verteilen und sich selbst herausziehen. Flach auf Bauch zum Ufer zurückrobben. Bei brüchigem Eis versuchen Eis bis zum Ufer Stück für Stück abzubrechen.";
        string aid_insectstings = "Schwellungen, Hautausschlag, brennendes Gefühl, Schwäche, Atemnot, Kreislaufprobleme, Herzrasen.\n\n1. Stachel vorsichtig entfernen (mit Pinzette). Nicht auf Stachel drücken, könnte noch mehr Gift injizieren.\n\n2. Kühlung der betroffenen Stelle (kalte Kompresse).\n\n3. Betroffene Stelle niedriger als Herz-Höhe halten, damit Gift langsamer zirkuliert.\n\n4. Bei Stich im Mund-Rachen-Raum: Eis lutschen lassen, kalte Umschläge um Hals.\n\n5. Bei ernsten Beschwerden Notruf absetzen.";
        string aid_nosebleeding = "Kleine Ader in Nasenspitze geplatzt.\n\n1. Blutenden leicht nach vorne gelehnt hinsetzen. Kopf gerade halten.\n\n2. Nicht flach lagern, da Kopf über Herz-Höhe Bluten verlangsamt.\n\n3. Kalter Nackenumschlag.\n\n4. Nasenspitze bis zum Stopp der Blutung zudrücken (für 10 min).\n\n5. Anschließend Nase in keiner Weise anstrengen (kein Naseschnauben).\n\n6. Bei ernsten Beschwerden oder wenn Blutung anhält Notruf absetzen.";
        string aid_poisining = "Verwirrung, Halluzination, große Pupillen, Fieber, Krämpfe. Bewusstlosigkeit.\n\n1. Gegenmittel nur verabreichen, wenn medizinisch ausgebildete Person vor Ort.\n\n2. Keine Getränke geben. Kein Erbrechen auslösen.\n\n3. Notruf absetzen + auf Vergiftung hinweisen!\n\n4. Giftreste und Erbrochenes sicherstellen!\n\n5. Sofern Betroffener bewusstlos ist und atmet: Stabile Seitenlage herstellen. Bewusstsein und Atmung kontrollieren bis Notarzt eintrifft.\n\n6. Sofern keine Atmung: Maßnahmen zur Wiederbelebung einleiten. Mund vorher von eventuell Erbrochenem befreien.";
        string aid_recoveryposition = "1. Betroffenen in Rückenlage, Beine ausstrecken. Daneben knien.\n\n2. Nahen Arm im rechten Winkel zum Körper positionieren.\n\n3. Fernen Arm über Brust des Verletzten ziehen und Handrücken auf Wange platzieren.\n\n4. Entferntes Knie fassen, zu sich ziehen und auf Boden legen. Bein etwa im rechten Winkel positionieren. Hand des Betroffenen bleibt auf dessen Wange.\n\n5. Sicherstellen, dass Atemwege frei sind.\n\n6. Kopf in Nacken beugen, Kinn anheben. Mund leicht öffnen. Atmung kontrollieren.\n\n7. Bewusstsein und Atmung kontrollieren bis Notarzt eintrifft.";
        string aid_resuscitation = "# Herzdruckmassage\n\n1. Betroffenen in Rückenlage. Daneben hinknien.\n\n2. Brustkorb freimachen.\n\n3. In der Mitte des Brustkorbs (kurz über Brustbein) einen Handballen platzieren.\n\n4. Anderen Handballen auf Handrücken der bereits platzierten Hand.\n\n5. Arme, Ellbogen durchdrücken.\n\n6. Brustkorb des Betroffenen 5 cm senkrecht eindrücken (aus dem Oberkörper arbeiten) und wieder entlasten.\n\n7. 30-mal in Folge kurz und kräftig drücken.\n\n# Beatmung\n\n1. Entfernen von Fremdkörpern aus Mund und Rachen. Überstrecken des Kopfes in den Nacken. \n\n2. Nasenflügel zusammendrücken, damit Nase geschlossen ist.\n\n3. Tief einatmen und Mund auf Mund des Betroffenen aufsetzen, sodass keine Luft entweichen kann.\n\n4. Zweimal Mund zu Mund beatmen (langsam, vollständig ausatmen).\n\n5. Danach wieder Herzdruckmassage.\n\nHerzdruckmassage + Beatmung fortführen bis Rettungsdienst kommt.\n\nAchtung: Bei Babys nur zwei Finger benutzen und nicht zu stark beatmen!";
        string aid_safeguardaccident = "1. Eigenen Pkw 50-100 m hinter Unfallstelle halten (falls Autobahn oder Landstraße). Danach Warnblinker anschalten und Warnweste anziehen.\n\n2. Warndreieck vor Unfallstelle aufstellen. Achtung: Bei einem Unfall in der Kurve, Warndreieck vor der Kurve platzieren!\n\n3. Andere Personen um Mithilfe auffordern.\n\n4. Tür des Unfall-Pkws öffnen (falls verklemmt, mittels Wagenheber aufstemmen). Zündung ausschalten.\n\n5. Unfallopfer bergen: Abschnallen, Sitz nach hinten schieben. Verletzten mit Rettungsgriff aus Wagen befreien.\n\n6. Notruf absetzen.\n\n7. Erste-Hilfe-Maßnahmen.";
        string aid_shock = "Kreislauf-Störung durch mangelhafte Sauerstoffversorgung im Körper.\nUrsache: Verlust von Flüssigkeit, reduzierte Blutmenge.\nSymptome: Blässe, kalte Haut, kalter Schweiß, Unruhe.\n\n1. Schockursache beseitigen (z.B. Flüssigkeitsverlust stoppen, Wunde abbinden)!\n\n2. Betroffenen auf Decke legen, Beine hoch lagern. Beruhigen.\n\n3. Notruf absetzen.\n\n4. Bei Atem- und Herz-Kreislauf-Störungen Wiederbelebung einleiten:";
        string aid_skullfracture = "Leichte Blutungen aus Nase, Mund oder Ohr. Oft offene Wunde am Schädel.\n\n1. Atemwege freihalten.\n\n2. Bei Bewusstsein: Verletzten nach vorne gebeugt hinsetzen. Weitere Bewegungen vermeiden!\n\n3. Bei Bewusstlosigkeit: Stabile Seitenlage (keinen Druck auf Kopfwunde).\n\n4. Notruf absetzen.\n\n5. Kopfverband anlegen.\n\n6. Bei Atem- und Herz-Kreislauf-Störungen Wiederbelebung einleiten:";
        string aid_snakebite = "Punktförmige Wunde in Stecknadelgröße, heftige Schmerzen, Schwellung, blaurote Verfärbung. Kreislaufstörung, Schockgefahr.\n\n1. Verletzten Körperteil ruhigstellen\n\n2. Kalte Umschläge auf Bissstelle.\n\n3. Schockbekämpfung.\n\n4. Notruf absetzen.";
        string aid_sos = "1. Signal: 3x kurz, 3x lang, 3x kurz.\n\n2. Optisch (Blitzlicht, Taschenlampe) oder Akustisch (Signalpfeife, Klopfen).";
        string aid_sprain = "Schmerzen, Schwellung (Bluterguss), Funktionsverlust, Verformung des Gliedes.\n\n1. Ruhigstellung des Gliedes ausschließlich in der für Betroffenen angenehmsten Position.\n\n2. Kühlen (mit Eisbeutel).\n\n3. Falls möglich Glied hoch lagern.\n\n4. Krankenhaus aufsuchen oder Notruf absetzen.";
        string aid_stroke = "Plötzliches Lähmungs- oder Taubheitsgefühl (Gesicht, Arm, Bein), gestörtes Sprachverständnis, Sehstörung, Bewusstseinstrübung, starke Kopfschmerzen. Probleme beim Atmen und Schlucken, Kontrollverlust über Blase und Darm.\n\n1. Notruf absetzen!\n\n2. Enge Kleidung lockern, keine Medikamente oder Getränke geben.\n\n3. Betroffenen bequem hinsetzen oder hinlegen. Beruhigen!\n\n4. Bewusstsein und Atmung kontrollieren.\n\n5. Bei Atem- und Herz-Kreislauf-Störungen Wiederbelebung einleiten:";
        string aid_suffocation = "Unzureichende Sauerstoffversorgung. Luftröhre verschlossen. Gefahr: Atemstillstand.\nSymptome: Pfeifendes Atemgeräusch, Hustenreiz, Atemnot, Hautverfärbung.\n\n1. Sofort handeln! Betroffenen kräftig Husten lassen.\n\n2. Mit flacher Hand auf Rücken zwischen Schulterblättern kräftig klopfen (Babys dabei auf Unterarm legen, Kopf nach unten halten).\n\n3. Wenn ohne Erfolg: Hinter Person stellen, Arme um Taille legen, leicht nach vorne beugen.\n\n4. Hand zur Faust ballen, auf Magen-Höhe des Betroffenen positionieren und mit anderer Hand umfassen.\n\n5. Beide Hände in Umklammerung mit hartem Stoß in Richtung Magen nach oben/innen ziehen (als ob Sie die Person hochheben wollen).\n\n6. Bis zu 5-mal wiederholen! Luftwege sollten vom Objekt befreit sein.\n\n7. Notruf absetzen.\n\n8. Falls Maßnahme nicht erfolgreich, trotzdem fortsetzen, bis Notarzt eintrifft.";
        string aid_sunburn = "1. Betroffenen aus direkter Sonneneinstrahlung nehmen. Weitere Sonne meiden.\n\n2. Viel Wasser trinken, um Dehydration entgegenzuwirken.\n\n3. Bei ernsthaftem Sonnenbrand (Blasenbildung, Rötung, Schmerzen) unbedingt Arzt aufsuchen.\n\n4. Leichte Hautrötungen mit feuchten Umschlägen kühlen. After-Sun-Lotion oder Gel auftragen.";
        string aid_sunstroke = "Heißer roter Kopf, kühle Haut, Übelkeit, Kopfschmerz, Schwindelgefühl. Ursache: Reizung der Hirnhaut.\n\n1. Kühlen Ort aufsuchen (Schatten) und Oberkörper des Betroffenen erhöht lagern.\n\n2. Mit nassen Tüchern Kopf kühlen.\n\n3. Notruf absetzen, Atmung weiterhin kontrollieren.\n\n4. Bei Bewusstsein: Ggf. kühles Getränk geben.\n\n5. Bei Atemstillstand mit Beatmung beginnen:\n\n6. Weiter mit Beatmung!";
        string aid_unconsciouswithbreath = "Keine Reaktion auf Ansprache und Schütteln. Atmung vorhanden.\n\n1. Falls Menschen in der Nähe, diese um Mithilfe bitten.\n\n2. Stabile Seitenlage. Kopf nach hinten ziehen, Mund öffnen, damit bei Erbrechen dieses ablaufen kann.\n\n3. Notruf absetzen.";
        string aid_unconsciouswithoutbreath = "1. Keine Reaktion vorhanden, Atmung nicht feststellbar.\n\n2. Wiederbelebung einleiten!";
        string aid_vomiting = "Folge von Übelkeit. Magen befreit sich. Ursachen: Infektion, Vergiftung, Geschwür, Medikamente, falsche Nahrung, Schwangerschaft.\n\n1. Gefahr für Kreislauf aufgrund Flüssigkeits- und Salz-Verlustes!\n\n2. Flüssigkeit zuführen (Tee, Wasser).\n\n3. Bei starken Beschwerden, blutigem oder anhaltendem Erbrechen Arzt aufsuchen.";
        string separator = "-";
        string aid_donate = "Wenn Du möchtest, dass diese Software weiterentwickelt wird, so spende einen Betrag Deiner Wahl an unsere Entwickler unter www.FirstAi.de\n\nGeplante Features:\n- Touchscreen-Unterstützung\n- weitere Abbildungen\n- besseres Interface\n- Audio-Version\n- Direktwahl Notrufnummern";

/* ************************************ */

        // XML LOADING
      //  string xmlFilename = "XmlDocument.xml";
      //  DataSet newDataSet = new DataSet("New DataSet");
      //  newDataSet.ReadXml(xmlFilename);

        // GLOBALS
        // size of the screen
        Size sz = new Size();

        // menu
        ListView ourMenu = new ListView();

        // text field (holds aidInfo)
        Panel detailsPanel = new Panel();
        Panel menuPanel = new Panel();
        Panel telEmergenciesPanel = new Panel();
        Panel telCountriesPanel = new Panel();

        Label detailsText = new Label();

        Label telCountryText = new Label();

        // String Array holds all FirstAidMeasures
        string[] stringItemArray;
        // String Array holds all telEmergencies
        string[] stringTelItemArray;

        // menu titles
        ListViewItem item00, item01, item02, item03, item04, item05, item06, item07, item08, item09, item10, item11, item12, item13, item14, item15, item16, item17, item18, item19, item20, item21, item22, item23, item24, item25, item26, item27, item28, item29, item30, item31, item32, item33, item34, item35, item36, item37, item38, item39, item40, item41, item42, item43, item44, item45, item46, item47, item48, item49, item50, item51, item52, item53, item54, item55, item56, item57, item58, item59, item60, item61;

        // LIST OF EMERGENCY NUMBERS
        ListView telEmergency = new ListView();
        
        // menu emergency numbers
        ListViewItem itemAfrica, itemAsia, itemEurope, itemNorthamerica, itemOceania, itemSouthamerica;

        
        string stringAfrica = "\n# Ägypten\nFeuer:180 | Pol:122 | Not:123\n\n# Algerien\nFeuer:14 | Pol:17 | Not:17\n\n# Angola\nFeuer:118 | Pol:110 | Not:118\n\n# Äquatorialguinea\nnur lokale Nummern\n\n# Äthiopien\nFeuer:93 | Pol:91 | Not:92\n\n# Benin\nFeuer:18 | Pol:17 | Not:301769\n\n# Botsuana\nFeuer:998 | Pol:999 | Not:997\n\n# Burkina Faso\nFeuer:18 | Pol:17 | Not:lokal\n\n# Burundi\nkein System\n\n# Dschibuti\nFeuer:18 | Pol:17 | Not:351351\n\n# Elfenbeinküste\nFeuer:180 | Pol:110 | Not:110\n\n# Eritrea\nnur lokale Nummern\n\n# Gabun\nFeuer:18 | Pol:1730 | Not:1300\n\n# Gambia\nFeuer:118 | Pol:117 | Not:116\n\n# Ghana\nFeuer:192 | Pol:191 | Not:193\n\n# Guinea\nnur lokale Nummern\n\n# Guinea-Bissau\nnur lokale Nummern\n\n# Kamerun\nFeuer:18 | Pol:17 | Not:lokal\n\n# Kap Verde\nFeuer:131 | Pol:132 | Not:130\n\n# Kenia\nFeuer:999 | Pol:999 | Not:999\n\n# Komoren\nnur Radiotelefon\n\n# Kongo (Demokrat. Republik)\nnur lokale Nummern\n\n# Kongo (Republik)\nnur lokale Nummern\n\n# Lesotho\nFeuer:122 | Pol:123 | Not:121\n\n# Liberia\nFeuer:911 | Pol:911 | Not:911\n\n# Libyen\nFeuer:193 | Pol:193 | Not:193\n\n# Madagaskar\nFeuer:18 | Pol:117 | Not:2262566\n\n# Malawi\nFeuer:199 | Pol:199 | Not:199\n\n# Mali\nFeuer:18 | Pol:17 | Not:15\n\n# Marokko\nFeuer:15 | Pol:19 | Not:15\n\n# Mauretanien\nFeuer:118 | Pol:117 | Not:lokal\n\n# Mauritius\nFeuer:999 | Pol:999 | Not:999\n\n# Mayotte\nFeuer:603054 | Pol:112 | Not:15\n\n# Mosambik\nFeuer:198 | Pol:119 | Not:117\n\n# Namibia\nFeuer:2032270 | Pol:1011 | Not:2032276\n\n# Niger\nFeuer:18 | Pol:17 | Not:723141\n\n# Nigeria\nFeuer:190 | Pol:119 | Not:199\n\n# Reunion\nFeuer:18 oder 112 mobil | Pol:17 oder 112 mobil | Not:15 oder 112 mobil\n\n# Ruanda\nFeuer:lokal | Pol:112 | Not:lokal\n\n# Sahara (Demokrat. Arab. Republik)\nunbekannt\n\n# Sambia\nFeuer | Pol | Not: 991 oder 112 mobil\n\n# Sao Tome und Principe\nunbekannt\n\n# Senegal\nFeuer:lokal | Pol:lokal | Not:8891515\n\n# Seychellen\nFeuer:999 | Pol:999 | Not:999\n\n# Sierra Leone\nFeuer:999 | Pol:999 | Not:999\n\n# Simbabwe\nFeuer:993 | Pol:995 | Not:994\n\n# Somalia\nnur lokale Nummern\n\n# Südafrika\nFeuer:10111 | Pol:10111 | Not:10177\n\n# Sudan\nFeuer:999 | Pol:999 | Not:lokal\n\n# Swasiland\nFeuer:lokal | Pol:999 | Not:6060911\n\n# Tansania\nFeuer:112 | Pol:112 | Not:112\n\n# Togo\nFeuer:118 | Pol:101 | Not:191\n\n# Tschad\nFeuer:18 | Pol:17 | Not:lokal\n\n# Tunesien\nFeuer:198 | Pol:197 | Not:190\n\n# Uganda\nFeuer | Pol | Not: 999 oder 111 mobil\n\n# Zentralafrikanische Republik\nFeuer:118 | Pol:611253 | Not:610600";
		string stringAsia = "\n# Afghanistan\nFeuer:-- | Pol:-- | Not:112\n\n# Armenien\nFeuer:101 | Pol:102 | Not:103\n\n# Aserbaidschan\nFeuer:101 | Pol:102 | Not:103\n\n# Bahrain\nFeuer:999 | Pol:999 | Not:999\n\n# Bangladesch\nFeuer:9555555 | Pol:8665513 | Not:199\n\n# Bhutan\nFeuer:113 | Pol:110 | Not:112\n\n# Brunei\nFeuer:995 | Pol:993 | Not:991\n\n# China\nFeuer:119 | Pol:110 | Not:120\n\n# Georgien\nFeuer:022 | Pol:022 | Not:022\n\n# Hong Kong\nFeuer:999 | Pol:999 | Not:999\n\n# Indien\nFeuer:101 | Pol:100 | Not:102\n\n# Indonesien\nFeuer:113 | Pol:110 | Not:118\n\n# Irak\nkein System\n\n# Iran\nFeuer:125 oder 112 mobil | Pol:110 oder 112 mobil  | Not:115 oder 112 mobil\n\n# Israel\nFeuer:102 | Pol:100 | Not:101\n\n# Japan\nFeuer:119 | Pol:110 | Not:119\n\n# Jemen\nFeuer:199 | Pol:199 | Not:199\n\n# Jordanien\nFeuer:193 | Pol:192 | Not:193\n\n# Kambodscha\nFeuer:118 | Pol:117 | Not:199\n\n# Kasachstan\nFeuer:03 | Pol:03 | Not:03\n\n# Katar\nFeuer:999 | Pol:999 | Not:999\n\n# Kirgisistan\nFeuer:03 | Pol:133 | Not:03\n\n# Kurdistan\nFeuer:125 | Pol:129 | Not:115\n\n# Kuwait\nFeuer:777 | Pol:777 | Not:777\n\n# Laos\nFeuer:lokal | Pol:lokal | Not:03\n\n# Libanon\nFeuer:175 | Pol:112 | Not:140\n\n# Macao\nFeuer:999 | Pol:999 | Not:999\n\n# Malaysia\nFeuer | Pol | Not: 999 oder 112 mobil\n\n# Malediven\nFeuer:118 | Pol:119 | Not:102\n\n# Mongolei\nFeuer:101 | Pol:102 | Not:103\n\n# Myanmar\nFeuer:199 | Pol:199 | Not:199\n\n# Nepal\nFeuer:101 | Pol:100 | Not:228094\n\n# Nordkorea\nnur lokale Nummern\n\n# Oman\nFeuer:999 | Pol:999 | Not:999\n\n# Osttimor\nFeuer:-- | Pol:112 | Not:7233212\n\n# Pakistan\nFeuer:16 | Pol:15 | Not:115\n\n# Philippinen\nFeuer:117 | Pol:117 | Not:117\n\n# Saudi-Arabien\nFeuer:998 | Pol:999 | Not:997\n\n# Singapur\nFeuer:995 | Pol:999 | Not:995\n\n# Sri Lanka\nFeuer:111 | Pol:119 oder 112 mobil | Not:110\n\n# Südkorea\nFeuer:119 | Pol:112 | Not:119\n\n# Syrien\nFeuer:113 | Pol:112 | Not:110\n\n# Tadschikistan\nFeuer:lokal | Pol:02 | Not:03\n\n# Taiwan\nFeuer:119 | Pol:110 | Not:119\n\n# Thailand\nFeuer:199 | Pol:191 oder 1155 (Touristen) | Not:191\n\n# Turkmenistan\nFeuer:03 | Pol:03 | Not:03\n\n# Usbekistan\nFeuer:03 | Pol:03 | Not:03\n\n# Vereinigte Arabische Emirate\nFeuer:997 | Pol:999 | Not:998\n\n# Vietnam\nFeuer:114 | Pol:113 | Not:115";
        string stringEurope = "\n# Albanien\nFeuer:18 | Pol:19 | Not:17\n\n# Andorra\nFeuer:118 | Pol:110 | Not:118\n\n# Belgien\nFeuer:112 | Pol:112 | Not:112\n\n# Bosnien und Herzegowina\nFeuer:123 | Pol:122 | Not:124\n\n# Bulgarien\nFeuer:112 | Pol:112 | Not:112\n\n# Dänemark\nFeuer:112 | Pol:112 | Not:112\n\n# Deutschland\nFeuer:112 | Pol:110 | Not:112\n\n# Estland\nFeuer:112 | Pol:112 | Not:112\n\n# Finnland\nFeuer:112 | Pol:112 | Not:112\n\n# Frankreich\nFeuer:18 oder 112 | Pol:17 oder 112 | Not:15 oder 112\n\n# Griechenland\nFeuer:112 | Pol:112 | Not:112\n\n# Großbritannien\nFeuer:112 | Pol:112 | Not:112\n\n# Irland\nFeuer:112 | Pol:112 | Not:112\n\n# Irland\nFeuer:112 | Pol:112 | Not:112\n\n# Island\nFeuer:112 | Pol:112 | Not:112\n\n# Italien\nFeuer:112 | Pol:112 | Not:112\n\n# Kosovo\nFeuer:911 | Pol:911 | Not:911\n\n# Kroatien\nFeuer:93 | Pol:92 | Not:94\n\n# Lettland\nFeuer:112 | Pol:112 | Not:112\n\n# Liechtenstein\nFeuer:112 | Pol:112 | Not:112\n\n# Litauen\nFeuer:112 | Pol:112 | Not:112\n\n# Luxemburg\nFeuer:112 | Pol:112 | Not:112\n\n# Malta\nFeuer:112 | Pol:112 | Not:112\n\n# Mazedonien\nFeuer:112 | Pol:112 | Not:112\n\n# Moldau (Moldawien)\nFeuer:901 | Pol:902 | Not:903\n\n# Monaco\nFeuer:112 | Pol:112 | Not:112\n\n# Montenegro\nFeuer:112 | Pol:112 | Not:112\n\n# Niederlande\nFeuer:112 | Pol:112 | Not:112\n\n# Norwegen\nFeuer:110 | Pol:112 | Not:113\n\n# Österreich\nFeuer:112 | Pol:112 | Not:112\n\n# Polen\nFeuer:112 | Pol:112 | Not:112\n\n# Portugal\nFeuer:112 | Pol:112 | Not:112\n\n# Rumänien\nFeuer:112 | Pol:112 | Not:112\n\n# Russland\nFeuer:01 | Pol:02 | Not:03\n\n# San Marino\nFeuer:116 | Pol:112 | Not:113\n\n# Schweden\nFeuer:112 | Pol:112 | Not:112\n\n# Schweiz\nFeuer:118 oder 112 | Pol:117 oder 112 | Not:144 oder 112\n\n# Serbien\nFeuer:112 | Pol:112 | Not:112\n\n# Slowakei\nFeuer:112 | Pol:112 | Not:112\n\n# Slowenien\nFeuer:112 | Pol:113 | Not:112\n\n# Spanien\nFeuer:112 | Pol:112 | Not:112\n\n# Tschechien\nFeuer:112 | Pol:112 | Not:112\n\n# Türkei\nFeuer:110 | Pol:155 | Not:112\n\n# Ukraine\nFeuer:112 | Pol:112 | Not:112\n\n# Ungarn\nFeuer:112 | Pol:112 | Not:112\n\n# Vatikanstadt\nFeuer:115 | Pol:112 | Not:113\n\n# Weißrussland\nFeuer:01 | Pol:02 | Not:03\n\n# Zypern\nFeuer:112 | Pol:112 | Not:112";
		string stringNorthamerica = "\n# USA\nFeuer:911 | Pol:911 | Not:911\n\n# Antigua und Barbuda\nFeuer:911 | Pol:911 | Not:911\n\n# Bahamas\nFeuer:911 | Pol:911 | Not:911\n\n# Barbados\nFeuer:113 | Pol:112 | Not:115\n\n# Belize\nFeuer:911 | Pol:911 | Not:911\n\n# Cayman Islands\nFeuer:911 | Pol:911 | Not:911\n\n# Costa Rica\nFeuer:911 | Pol:911 | Not:911\n\n# Dominica\nFeuer:999 | Pol:999 | Not:999\n\n# Dominikanische Republik\nFeuer:911 | Pol:911 | Not:911\n\n# El Salvador\nFeuer:911 | Pol:911 | Not:911\n\n# Grenada\nFeuer:911 | Pol:112 | Not:911\n\n# Grönland\nnur lokale Nummern\n\n# Guatemala\nFeuer:122 | Pol:110 | Not:123\n\n# Haiti\nFeuer:lokal | Pol:114 | Not:118\n\n# Honduras\nFeuer:198 | Pol:119 | Not:378654\n\n# Jamaika\nFeuer:110 | Pol:119 | Not:110\n\n# Kanada\nFeuer:911 | Pol:911 | Not:911\n\n# Kuba\nFeuer:26811 | Pol:26811 | Not:26811\n\n# Mexiko\nFeuer:060 | Pol:080 | Not:060\n\n# Nicaragua\nFeuer:2650162 | Pol:118 | Not:2651761\n\n# Panama\nFeuer:103 | Pol:104 | Not:2699778\n\n# Saint Kitts und Nevis\nFeuer:911 | Pol:911 | Not:911\n\n# Saint Lucia\nFeuer:911 | Pol:999 | Not:911\n\n# Saint Pierre und Miquelon\nFeuer:18 | Pol:17 | Not:15\n\n# Saint Vincent und Grenadinen\nFeuer:911 | Pol:911 | Not:911\n\n# Trinidad und Tobago\nFeuer:990 | Pol:999 | Not:990";
        string stringOceania = "\n# Australien\nFeuer | Pol | Not: 000 oder 112 mobil\n\n# Fidschi\nFeuer:9170 | Pol:911 | Not:911\n\n# Kiribati\nFeuer:lokal | Pol:lokal | Not:994\n\n# Marshallinseln\nFeuer:lokal | Pol:6258666 | Not:6254111 \n\n# Mikronesien\nnur lokale Nummern\n\n# Nauru\nnur lokale Nummern\n\n# Neuseeland\nFeuer:111 | Pol:111 | Not:111\n\n# Palau\nFeuer:911 | Pol:911 | Not:911\n\n# Papua-Neuguinea\nFeuer:110 | Pol:000 | Not:lokal\n\n# Salomonen\nFeuer:911 | Pol:911 | Not:911\n\n# Samoa\nFeuer:994 | Pol:995 | Not:996\n\n# Tonga\nFeuer:999 | Pol:922 | Not:933\n\n# Tuvalu\nFeuer:911 | Pol:911 | Not:911\n\n# Vanuatu\nFeuer:112 | Pol:112 | Not:112";
        string stringSouthamerica = "\n# Argentinien\nFeuer:100 | Pol:101 | Not:107\n\n# Bolivien\nFeuer:911 | Pol:911 | Not:911\n\n# Brasilien\nFeuer:193 | Pol:190 | Not:192\n\n# Chile\nFeuer:132 | Pol:133 | Not:131\n\n# Ecuador\nFeuer:102 | Pol:101 | Not:131\n\n# Guyana\nFeuer:912 | Pol:911 | Not:913\n\n# Kolumbien\nFeuer:119 | Pol:119 | Not:119\n\n# Paraguay\nFeuer:911 | Pol:911 | Not:911\n\n# Peru\nFeuer:116 | Pol:105 | Not:116\n\n# Suriname\nFeuer:115 | Pol:115 | Not:115\n\n# Uruguay\nFeuer:911 | Pol:911 | Not:911\n\n# Venezuela\nFeuer:171 | Pol:171 | Not:171";
        

        public Form1() {
            // initialization
            InitializeComponent();
            this.Text = "Erste Hilfe 0.1 pre";
            
            Debug.WriteLine("Device Screen: " + System.Windows.Forms.Screen.PrimaryScreen.Bounds.Width + "x" + System.Windows.Forms.Screen.PrimaryScreen.Bounds.Height + "\nWorking Area: " + System.Windows.Forms.Screen.PrimaryScreen.WorkingArea.Width + "x" + System.Windows.Forms.Screen.PrimaryScreen.WorkingArea.Height);

            // new Sizes of Screen
            sz.Width = System.Windows.Forms.Screen.PrimaryScreen.WorkingArea.Width; // this.ClientSize.Width;
            sz.Height = System.Windows.Forms.Screen.PrimaryScreen.WorkingArea.Height; //  this.ClientSize.Height;
            this.Size = sz;
            Debug.WriteLine("Form Size: " + this.Size.Width + "x" + this.Size.Height);

            // inits for scrolling in form (obsolete!)
            // this.KeyDown += new KeyEventHandler(scrollNow);
            // autoscroll for form
            this.AutoScroll = false;
            // passing of events up to form
            // this.KeyPreview = true;


            // prepare picture box
            picBoxes = new PictureBox[] { picBox0, picBox1, picBox2, picBox3, picBox4, picBox5, picBox6, picBox7 };
            /// load images
            /// LoadOurImages("FirstAid3.Resources.aid001.png");
            /// LoadOurImages("FirstAid3.Resources.aid089.png");
            // create my list view (menu list)
            CreateMyListView();

            // create emergency list menu
            CreateEmergencyMenu();

            // assign event handler to form (menu)
            this.KeyPress += new KeyPressEventHandler(keyWasPressed);
            // detailsPanel.KeyDown += new KeyEventHandler(scrollNow);
            // detailsPanel.KeyUp += new KeyEventHandler(scrollNow);

            // panel autoscroll reacts on key pressed
            detailsPanel.KeyDown += new KeyEventHandler(scrollNow);
            // scroll for emergency numbers countries
            telCountriesPanel.KeyDown += new KeyEventHandler(scrollNow2);

            // ?? detailsPanel.Dock = DockStyle.Fill;

            //detailsPanel.AutoScroll = true;
            //this.pTextPanel.SuspendLayout();

            // hide text panels at start up
            detailsPanel.Visible = false;
            detailsPanel.Enabled = false;
            telCountriesPanel.Visible = false;
            telCountriesPanel.Enabled = false;
            // hide telEmergency panel at start up
            telEmergenciesPanel.Visible = false;
            telEmergenciesPanel.Enabled = false;
            
            // finish
            Debug.WriteLine("initialization done");

            // text in array is showing up when menu item is chosen
            stringItemArray = new string[] { 
                aid_disclaimer, separator, aid_general, aid_allergic, aid_amputation, aid_asthma, aid_apnoea, aid_checkbreathing, aid_eyeinjury, aid_chemicalburneyes, aid_apnoea, 
                aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_bleedinglight, aid_bleedingsevere, aid_diabeticcoma, aid_diarrhoea, aid_icerescue, aid_electricityaccident, aid_epilepsy, aid_vomiting, 
                aid_frostbitemild, aid_frostbitesevere, aid_suffocation, aid_drowning, aid_birth, aid_dangerzone, aid_brainconcussion, aid_resuscitation, aid_heartattack, aid_hyperthermia, aid_insectstings, aid_fracture, 
                aid_nosebleeding, aid_emergencycall, aid_resuscitation, aid_backinjury, aid_skullfracture, aid_stroke, aid_snakebite, aid_shock, aid_sunburn, aid_sunstroke, aid_sos, 
                aid_recoveryposition, aid_animalbite, aid_hyperthermia, aid_diabeticcoma, aid_safeguardaccident, aid_hypothermia, aid_hypoglycaemia, aid_chemicalburn, aid_burningslight, aid_burningsevere, aid_poisining, 
                aid_safeguardaccident, aid_suffocation, aid_sprain, aid_resuscitation, aid_backinjury, separator, aid_donate };
            stringTelItemArray = new string[] { stringAfrica, stringAsia, stringEurope, stringNorthamerica, stringOceania, stringSouthamerica };
            
            // create 2nd form to hold 1stAidInfos
            initiateDetailPanel();
            initiatetelCountriesPanel();
        }



        int scrollbarVertWidth = 10;

        int scrollDistance = 32;

        // event handler for detailsPanel
        public void scrollNow(object sender, KeyEventArgs e) {
            /// Debug.WriteLine("KEY CODE: " + e.KeyCode + " / Panel-Pos-Y: "+this.AutoScrollPosition.Y);
            
            if ((e.KeyCode == Keys.Down) ) { // && (detailsPanel.Bottom != 0)) {
                //this.AutoScrollPosition = new Point(0, -this.AutoScrollPosition.Y + 16);
                detailsPanel.AutoScrollPosition = new Point(0, -detailsPanel.AutoScrollPosition.Y + scrollDistance);
                ///Debug.WriteLine("RUNTER: " + detailsPanel.Height + " " + detailsPanel.AutoScrollPosition.Y);
                //detailsPanel.Top -= 20;
            }
            else if ((e.KeyCode == Keys.Up) ) {// && (detailsPanel.Top != 0)){
                //this.AutoScrollPosition = new Point(0, -this.AutoScrollPosition.Y - 16);
                detailsPanel.AutoScrollPosition = new Point(0, -detailsPanel.AutoScrollPosition.Y - scrollDistance);
                ///Debug.WriteLine("HOCH: " + detailsPanel.Height + " " + detailsPanel.AutoScrollPosition.Y);
                //detailsPanel.Top += 20;
            }
            // Debug.WriteLine("TOP: " + detailsPanel.Top + " btm: " + detailsPanel.Bottom);
            // SetPos(detailsText, textBoxTest);
        }

        // event handler for telEmergenciey countries
        public void scrollNow2(object sender, KeyEventArgs e) {
            /// Debug.WriteLine("KEY CODE II: " + e.KeyCode + " / Panel-Pos-Y: " + this.AutoScrollPosition.Y);

            if ((e.KeyCode == Keys.Down)) {
                telCountriesPanel.AutoScrollPosition = new Point(0, -telCountriesPanel.AutoScrollPosition.Y + scrollDistance);
                ///Debug.WriteLine("RUNTER II: " + telCountriesPanel.Height + " " + telCountriesPanel.AutoScrollPosition.Y);
            }
            else if ((e.KeyCode == Keys.Up)) {
                telCountriesPanel.AutoScrollPosition = new Point(0, -telCountriesPanel.AutoScrollPosition.Y - scrollDistance);
                ///Debug.WriteLine("HOCH II: " + telCountriesPanel.Height + " " + telCountriesPanel.AutoScrollPosition.Y);
            }
        }

        private void initiatetelCountriesPanel() {
            // SIZE MUST BE DYNAMIC! according to height of label (and this according the text!)
            telCountriesPanel.Size = new Size(sz.Width, sz.Height);
            telCountriesPanel.Location = new Point(0, 0);
            telCountriesPanel.AutoScroll = true;

            telCountryText.Location = new Point(0, 0);
            telCountryText.Size = new Size(sz.Width - 10, sz.Height);

            // add label telCountryText to panel
            telCountriesPanel.Controls.Add(telCountryText);
            // add panel itself to Form
            this.Controls.Add(telCountriesPanel);
        }
        private void initiateDetailPanel() {
            // SIZE MUST BE DYNAMIC! according to height of label (and this according the text!)
            detailsPanel.Size = new Size(sz.Width, sz.Height);
            detailsPanel.Location = new Point(0, 0);
            //detailsPanel.Anchor = AnchorStyles.Left;            //detailsPanel.Anchor = AnchorStyles.Right;            //detailsPanel.Anchor = AnchorStyles.Top;
            detailsPanel.AutoScroll = true;

            detailsText.Location = new Point(0, 0);
            detailsText.Size = new Size(sz.Width - scrollbarVertWidth, sz.Height);

            //Specifiy Fonts
            //this.Font = new Font(FontFamily.GenericSansSerif, 10.0F, FontStyle.Bold);
            //ourMenu.Font = new Font(FontFamily.GenericSansSerif, 10.0F, FontStyle.Bold);
            //detailsText.Font = new Font(FontFamily.GenericSansSerif, 10.0F, FontStyle.Bold);

            //detailsText.Anchor = AnchorStyles.Left;             detailsText.Anchor = AnchorStyles.Right;            detailsText.Anchor = AnchorStyles.Top;
            // add label detailsText to panel
            detailsPanel.Controls.Add(detailsText);

            // add panel itself to Form
            this.Controls.Add(detailsPanel);
            /*            detailsText.Multiline = true;
                        detailsText.Text = "";
                        // prevent Editing - disable textfield modes
                        detailsText.AcceptsReturn = false;
                        // detailsText.SelectionLength = 0; detailsText.SelectionStart = 0;
                        // read only, no editing by user
                        detailsText.ReadOnly = true;
                        // add textbox to Form
              */
            // this.Controls.Add(detailsText);
        //    Debug.WriteLine("PANEL: " + detailsPanel.Size.Width + " Height: " + detailsPanel.Size.Height);
        //    Debug.WriteLine("PANELTEXT: " + detailsText.Size.Width + " Height: " + detailsText.Size.Height);
        }


        private void showPhoneNumber() {
            // shows phone number of the device
            // Debug.WriteLine(Microsoft.WindowsMobile.Status.SystemProperty.OwnerPhoneNumber);
        }
        private void CreateEmergencyMenu() {
            telEmergency.Size = new Size(sz.Width, sz.Height);
            telEmergency.View = View.List;

            telEmergency.Name = "Kontinent wählen";
		    telEmergency.Items.Add(itemAfrica = new ListViewItem("Afrika"));
            telEmergency.Items.Add(itemAsia = new ListViewItem("Asien"));
            telEmergency.Items.Add(itemEurope = new ListViewItem("Europa"));
            telEmergency.Items.Add(itemNorthamerica = new ListViewItem("Nord-/Zentralamerika"));
            telEmergency.Items.Add(itemOceania = new ListViewItem("Ozeanien"));
            telEmergency.Items.Add(itemSouthamerica = new ListViewItem("Südamerika"));

            // setup telEmergenciesPanel
            telEmergenciesPanel.Location = new Point(0, 0);
            telEmergenciesPanel.Size = sz;
            telEmergenciesPanel.Anchor = AnchorStyles.Left;
            telEmergenciesPanel.Anchor = AnchorStyles.Right;
            telEmergenciesPanel.Anchor = AnchorStyles.Top;
            telEmergenciesPanel.AutoScroll = true;
            telEmergency.Anchor = AnchorStyles.Left;
            telEmergenciesPanel.Controls.Add(telEmergency);
            this.Controls.Add(telEmergenciesPanel);
            
            // telEmergency.addCommand(cmdBack);
			// telEmergency.setCommandListener(this);

        }

        
        private void CreateMyListView() {

            // listView1.Bounds = new Rectangle(10, 10, 300, 200);
            // Set the view to a list style
            ourMenu.View = View.Details; // List
            ColumnHeader chead = new ColumnHeader();
            chead.Text = "Erste Hilfe 0.1 pre";
            ourMenu.Columns.Add(chead);
            
            // Select the item and subitems when selection is made: ourMenu.FullRowSelect = true;
            // resize to 320x240
            ourMenu.Size = new Size(sz.Width, sz.Height-20);
            // new:
            ourMenu.Dock = DockStyle.Fill; // affect?
            // ourMenu.ForeColor = Color.DarkGreen;

            // necessary for scrollbar 
            ourMenu.Anchor = AnchorStyles.Left;
            ourMenu.Anchor = AnchorStyles.Right;
            ourMenu.Anchor = AnchorStyles.Top;

            // Create menu items
            ourMenu.Items.Add(item00 = new ListViewItem("# Haftung + Hinweise"));
            ourMenu.Items.Add(item01 = new ListViewItem("# Notrufe weltweit"));
            ourMenu.Items.Add(item02 = new ListViewItem("# Allgemeines"));
            ourMenu.Items.Add(item03 = new ListViewItem("Allergische Reaktion"));
            ourMenu.Items.Add(item04 = new ListViewItem("Amputation"));
            ourMenu.Items.Add(item05 = new ListViewItem("Asthma / Atemnot"));
            ourMenu.Items.Add(item06 = new ListViewItem("Atemstillstand"));
            ourMenu.Items.Add(item07 = new ListViewItem("Atmung prüfen"));
            ourMenu.Items.Add(item08 = new ListViewItem("Augenverletzung"));
            ourMenu.Items.Add(item51 = new ListViewItem("Augenverätzung"));
            ourMenu.Items.Add(item09 = new ListViewItem("Beatmung"));
            ourMenu.Items.Add(item10 = new ListViewItem("Bewusstlosigkeit mit Atmung"));
            ourMenu.Items.Add(item11 = new ListViewItem("Bewusstlosigkeit ohne Atmung"));
            ourMenu.Items.Add(item12 = new ListViewItem("Blutung (leicht)"));
            ourMenu.Items.Add(item13 = new ListViewItem("Blutung (schwer)"));
            ourMenu.Items.Add(item14 = new ListViewItem("Diabetisches Koma"));
            ourMenu.Items.Add(item15 = new ListViewItem("Durchfall"));
            ourMenu.Items.Add(item16 = new ListViewItem("Eisunfall"));
            ourMenu.Items.Add(item17 = new ListViewItem("Elektrounfall"));
            ourMenu.Items.Add(item18 = new ListViewItem("Epileptischer Anfall"));
            ourMenu.Items.Add(item19 = new ListViewItem("Erbrechen"));
            ourMenu.Items.Add(item20 = new ListViewItem("Erfrierung (leicht)"));
            ourMenu.Items.Add(item21 = new ListViewItem("Erfrierung (stark)"));
            ourMenu.Items.Add(item22 = new ListViewItem("Ersticken"));
            ourMenu.Items.Add(item23 = new ListViewItem("Ertrinken"));
            ourMenu.Items.Add(item24 = new ListViewItem("Geburt"));
            ourMenu.Items.Add(item25 = new ListViewItem("Gefahrenzone (Retten)"));
            ourMenu.Items.Add(item26 = new ListViewItem("Gehirnerschütterung"));
            ourMenu.Items.Add(item27 = new ListViewItem("Herzdruckmassage"));
            ourMenu.Items.Add(item28 = new ListViewItem("Herzinfarkt"));
            ourMenu.Items.Add(item29 = new ListViewItem("Hitzschlag"));
            ourMenu.Items.Add(item30 = new ListViewItem("Insektenstich"));
            ourMenu.Items.Add(item31 = new ListViewItem("Knochenbruch"));
            ourMenu.Items.Add(item32 = new ListViewItem("Nasenbluten"));
            ourMenu.Items.Add(item33 = new ListViewItem("Notruf"));
            ourMenu.Items.Add(item34 = new ListViewItem("Reanimation"));
            ourMenu.Items.Add(item35 = new ListViewItem("Rückenverletzung"));
            ourMenu.Items.Add(item36 = new ListViewItem("Schädelbasisbruch"));
            ourMenu.Items.Add(item37 = new ListViewItem("Schlaganfall"));
            ourMenu.Items.Add(item38 = new ListViewItem("Schlangenbiss"));
            ourMenu.Items.Add(item39 = new ListViewItem("Schock"));
            ourMenu.Items.Add(item40 = new ListViewItem("Sonnenbrand"));
            ourMenu.Items.Add(item41 = new ListViewItem("Sonnenstich"));
            ourMenu.Items.Add(item42 = new ListViewItem("SOS"));
            ourMenu.Items.Add(item43 = new ListViewItem("Stabile Seitenlage"));
            ourMenu.Items.Add(item44 = new ListViewItem("Tierbiss"));
            ourMenu.Items.Add(item45 = new ListViewItem("Überhitzung"));
            ourMenu.Items.Add(item46 = new ListViewItem("Überzuckerung"));
            ourMenu.Items.Add(item47 = new ListViewItem("Unfallstelle sichern"));
            ourMenu.Items.Add(item48 = new ListViewItem("Unterkühlung"));
            ourMenu.Items.Add(item49 = new ListViewItem("Unterzuckerung"));
            ourMenu.Items.Add(item50 = new ListViewItem("Verätzung"));
            ourMenu.Items.Add(item52 = new ListViewItem("Verbrennung (leicht)"));
            ourMenu.Items.Add(item53 = new ListViewItem("Verbrennung (schwer)"));
            ourMenu.Items.Add(item54 = new ListViewItem("Vergiftung"));
            ourMenu.Items.Add(item55 = new ListViewItem("Verkehrsunfall"));
            ourMenu.Items.Add(item56 = new ListViewItem("Verschlucken"));
            ourMenu.Items.Add(item57 = new ListViewItem("Verstauchung + Verrenkung"));
            ourMenu.Items.Add(item58 = new ListViewItem("Wiederbelebung"));
            ourMenu.Items.Add(item59 = new ListViewItem("Wirbelsäule"));
            ourMenu.Items.Add(item60 = new ListViewItem("-------------"));
            ourMenu.Items.Add(item61 = new ListViewItem("# Software verbessern"));


            /*            // Place a check mark next to the item.
                        item1.Checked = true;
                        item1.SubItems.Add("1");
                        item1.SubItems.Add("2");
                        item1.SubItems.Add("3");
                        // Create columns for the items and subitems.
                        listView1.Columns.Add("Item Column", -2, HorizontalAlignment.Left);
                        listView1.Columns.Add("Column 2", -2, HorizontalAlignment.Left);
                        listView1.Columns.Add("Column 3", -2, HorizontalAlignment.Left);
                        listView1.Columns.Add("Column 4", -2, HorizontalAlignment.Center);
                        //Add the items to the ListView.
                        listView1.Items.Add(item1); //
                        listView1.Items.Add(item2); //
                        listView1.Items.Add(item3); //
            
                        // Create two ImageList objects.
                        ImageList imageListSmall = new ImageList();
                        ImageList imageListLarge = new ImageList();

                        // Initialize the ImageList objects with bitmaps.
                        imageListSmall.Images.Add(Bitmap.FromFile("C:\\MySmallImage1.bmp"));
                        imageListSmall.Images.Add(Bitmap.FromFile("C:\\MySmallImage2.bmp"));
                        imageListLarge.Images.Add(Bitmap.FromFile("C:\\MyLargeImage1.bmp"));
                        imageListLarge.Images.Add(Bitmap.FromFile("C:\\MyLargeImage2.bmp"));

                        //Assign the ImageList objects to the ListView.
                        listView1.LargeImageList = imageListLarge;
                        listView1.SmallImageList = imageListSmall;*/


            // setup menuPanel
            menuPanel.Location = new Point(0, 0);
            // http://stackoverflow.com/questions/31242/net-compact-framework-scrollbars-horizontal-always-show-when-vertical-shows
            menuPanel.Size = sz;
            menuPanel.Anchor = AnchorStyles.Left;
            menuPanel.Anchor = AnchorStyles.Right;
            menuPanel.Anchor = AnchorStyles.Top;
            menuPanel.AutoScroll = true;

            // set anchor point
            ourMenu.Anchor = AnchorStyles.Left;
            // Add the menu panel to the form
            this.Controls.Add(menuPanel);
            // Add the ListView to the control collection
            menuPanel.Controls.Add(ourMenu);

            //Debug.WriteLine("## MENU PANEL IS: " + menuPanel.ClientRectangle.Size);
            //Debug.WriteLine("## MENU LIST IS: " + ourMenu.ClientRectangle.Size);

        }

        private void showEmergenciesList() {
            menuPanel.Visible = false;
            menuPanel.Enabled = false;
            telEmergenciesPanel.Visible = true;
            telEmergenciesPanel.Enabled = true;
            menuExit.Text = "Zurück";
            menuExit.Enabled = true;
            // focus - detailsText.Focus();
            telEmergenciesPanel.Focus();
            telEmergShown = true;
            telCountriesShown = false;
            // reposition scrolled telCountriesPanel
            telCountriesPanel.AutoScrollPosition = new Point(0, 0);
        }


        private void menuExit_Click_1(object sender, EventArgs e) {
            // if user is NOT within telEmergency and Exit Button is Exit Button (by label)
            if ( (telEmergShown == false)&&(telCountriesShown == false) && (menuExit.Text == "Exit")) {
                Debug.WriteLine("closing");
                Application.Exit();
            }
        //    else if (menuExit.Text == "Weiter") {
        //        Debug.WriteLine("JOOOO");
        //    }
            // else Exit Button is a back-button currently
            else {
                if (menuExit.Text == "Weiter")
                {
                    pressedWeiter = true;
                    // show further first aid measures:
                    //if ( (recentItem==18) || (recentItem==49) || (recentItem==12) || (recentItem==24) || (recentItem==29) || (recentItem==37) || (recentItem==38) || (recentItem==40) || (recentItem==54) )
                    //    { recentItem = 12; }
                    Debug.WriteLine("Show further measures");
                }
                else
                {
                    Debug.WriteLine("Zurück zum Menu");
                }
                telEmergShown = false;
                telCountriesShown = false;
                swapToDetails(null, null);
            }
        }

        bool detailsShown = false;
        bool telEmergShown = false;
        bool telCountriesShown = false;
        bool pressedWeiter = false;

        // click on select
        private void menuSelect_Click_1(object sender, EventArgs e) {
            pressedWeiter = false;
            Debug.WriteLine("ZURÜCK pressed");
            Debug.WriteLine("::"+detailsShown);
            swapToDetails(e,null);
        }

        // event handler
        public void keyWasPressed(object sender, KeyPressEventArgs f) {
            swapToDetails(null,f);
        }
        
        int recentItem;
        private void swapToDetails(EventArgs e, KeyPressEventArgs f) {

            // number 0...9 has been pressed
            if ((f != null) && (f.KeyChar <= 9) && (f.KeyChar >= 0)) {
                // do nothing
                // Debug.WriteLine("pressed: " + (char)f.KeyChar);
                // (f.KeyChar == (char)Keys.Return))
            }

            // some controls have been pressed
            else {
                // catch menu item chosen
                recentItem = ourMenu.SelectedIndices[0];

                // if details of telCountries is visible now
                if (telCountriesShown == true)
                {   
                    // back to telCountry list
                    showEmergenciesList();
                    menuSelect.Text = "Select";
                }
                // prevent no value of menu
                else if (this.ourMenu.SelectedIndices.Count <= 0)
                {
                    return;
                }
                else if (telEmergShown == true)
                {
                    // prevent no value of menu
                    if (this.telEmergency.SelectedIndices.Count <= 0)
                    {
                        return;
                    }
                    else
                    {
                        // show em number of chosen country
                        telCountryText.Text = stringTelItemArray[telEmergency.SelectedIndices[0]];
                        // resize
                        telCountryText.Height = CFMeasureString.MeasureString(CreateGraphics(), telCountryText.Text, telCountryText.ClientRectangle, false).Height+20;
                        telEmergenciesPanel.Visible = false;
                        telEmergenciesPanel.Enabled = false;
                        telCountriesPanel.Visible = true;
                        telCountriesPanel.Enabled = true;
                        telEmergShown = false;

                        // details of telCountries are shown now
                        telCountriesShown = true;
                        menuExit.Text = "";
                        menuExit.Enabled = false;
                        menuSelect.Text = "Zurück";
                        // set focus to telCountrieList for scrolling
                        telCountriesPanel.Focus();
                    }
                }

                // telEmergency has been chosen
                else if ((detailsShown == false) && (recentItem == 1))
                {
                    // Debug.WriteLine(recentItem);
                    showEmergenciesList();
                }

                // user clicked on separator -----
                else if ((detailsShown == false) && (recentItem == 60))
                {
                    // actually do nothing 
                    // or later: showPhoneNumber();
                }
                // user has clicked for further descriptions
                else if ((menuExit.Text == "Weiter") && (pressedWeiter==true))
                {
                    Debug.WriteLine("# Weiter was pressed");
                    if ( (recentItem==18) || (recentItem==49) || (recentItem==12) || (recentItem==24) || (recentItem==29) || (recentItem==37) || (recentItem==38) || (recentItem==40) || (recentItem==54) ){
                        recentItem = 28; // resuscitation
                    }
                    disposeImages();
                    assignTextAndImages();
                    detailsShown = false;
                }
                // another menu item has been chosen, show detail description page
                else if (detailsShown == false)
                {

                    Debug.WriteLine("User has pressed item:" + recentItem); //+ ": " +ourMenu.Items[recentItem].Text);
                    menuPanel.Visible = false;
                    menuPanel.Enabled = false;
                    telEmergenciesPanel.Visible = false;
                    telEmergenciesPanel.Enabled = false;
                    detailsPanel.Visible = true;
                    detailsPanel.Enabled = true;

                    assignTextAndImages();

                }
                // go back to main menu
                else
                {
                    menuPanel.Visible = true;
                    menuPanel.Enabled = true;
                    detailsPanel.Visible = false;
                    detailsPanel.Enabled = false;
                    telEmergenciesPanel.Visible = false;
                    telEmergenciesPanel.Enabled = false;
                    // change of menu commands...
                    menuSelect.Text = "Select";
                    menuExit.Text = "Exit";
                    menuExit.Enabled = true;
                    // reposition scrolled panel
                    detailsPanel.AutoScrollPosition = new Point(0, 0);
                    // focus the menu again
                    menuPanel.Focus();


                    disposeImages();
                }
                // indicate state change
                detailsShown = !detailsShown;


                // autoscroll
                // SetAutoScrollMargins(); ::
                /* if (detailsText.Location.X > detailsPanel.Location.X || detailsText.Location.Y > detailsPanel.Location.Y) {
                // If the AutoScrollMargin is set to less than (5,5), set it to 5,5.
                if (detailsPanel.AutoScrollMargin.Width < 5 ||
                   detailsPanel.AutoScrollMargin.Height < 5) {
                       detailsPanel.AutoScrollMargin = new Size(5,5);// SetAutoScrollMargin(5, 5);
                }
                }*/
            }
        }

        PictureBox picBox0 = new PictureBox();
        PictureBox picBox1 = new PictureBox();
        PictureBox picBox2 = new PictureBox();
        PictureBox picBox3 = new PictureBox();
        PictureBox picBox4 = new PictureBox();
        PictureBox picBox5 = new PictureBox();
        PictureBox picBox6 = new PictureBox();
        PictureBox picBox7 = new PictureBox();
        
        /*
        PictureBox aid001 = new PictureBox();
        PictureBox aid003 = new PictureBox();
        PictureBox aid008 = new PictureBox();
        PictureBox aid009 = new PictureBox();
        PictureBox aid010 = new PictureBox();
        PictureBox aid011 = new PictureBox();
        PictureBox aid012 = new PictureBox();
        PictureBox aid013 = new PictureBox();
        PictureBox aid019 = new PictureBox();
        PictureBox aid022 = new PictureBox();
        PictureBox aid023 = new PictureBox();
        PictureBox aid025 = new PictureBox();
        PictureBox aid028 = new PictureBox();
        PictureBox aid029 = new PictureBox();
        PictureBox aid030 = new PictureBox();
        PictureBox aid031 = new PictureBox();
        PictureBox aid034 = new PictureBox();
        PictureBox aid041 = new PictureBox();
        PictureBox aid045 = new PictureBox();
        PictureBox aid058 = new PictureBox();
        PictureBox aid061 = new PictureBox();
        PictureBox aid065 = new PictureBox();
        PictureBox aid067 = new PictureBox();
        PictureBox aid069 = new PictureBox();
        PictureBox aid084 = new PictureBox();
        PictureBox aid085 = new PictureBox();
        PictureBox aid089 = new PictureBox();
        PictureBox aid092 = new PictureBox();
        PictureBox aid107 = new PictureBox();
        PictureBox imageCC = new PictureBox();
        */


        PictureBox[] picBoxes; 
        int picCount = 0;

        Assembly _assembly;
        Stream _imageStream;

        // http://www.developmentnow.com/g/18_2003_9_0_0_92705/background-image-in-a-form.htm
        /* protected override void OnPaint(PaintEventArgs e) {
            //paint the splash screen bitmap
            Graphics g = e.Graphics;
            g.DrawImage(new Bitmap(System.Reflection.Assembly.GetExecutingAssembly().GetManifestResourceStream("aid001.png")),0, 0);
            base.OnPaint (e);
        }*/


        private void disposeImages()
        {
            // remove picBoxes from DetailsPanel + delete/clear all images from memory
            // Debug.WriteLine("Nr of Pics: " + (picCount-1) );
            for (int i = 0; i < picCount; i++)
            {
                detailsPanel.Controls.Remove(picBoxes[i]);
                picBoxes[i].Image.Dispose(); //Debug.WriteLine("##check## " + picBox0.Image.Width);
            }
            // set picCount to zero
            picCount = 0;

        }

        private void assignTextAndImages()
        {

            // Assign Text
            detailsText.Text = stringItemArray[recentItem];

            // change of menu commands...
            menuSelect.Text = "Zurück";
            menuExit.Text = ""; // clear
            menuExit.Enabled = false;
            // focus - detailsText.Focus();
            detailsPanel.Focus();

            // RESIZE LABEL, METHOD: http://www.mobilepractices.com/2007/12/multi-line-graphicsmeasurestring.html
            detailsText.Height = CFMeasureString.MeasureString(CreateGraphics(), detailsText.Text, detailsText.ClientRectangle, false).Height + 20;


            // Title of form
            // this.Text = stringItemTitleArray[recentItem];

            // Debug.WriteLine("RCT HEIGHT: " + detailsText.Size.Height);


            // ASSIGN IMAGES

            //if (recentItem == 1) {
            //    LoadOurImages("FirstAid3.Resources.aid001.png");
            //    LoadOurImages("FirstAid3.Resources.aid089.png");
            //}

            // img: CC licence
            // img: CC licence
            if (recentItem == 0) { LoadOurImages("FirstAid3.Resources.cc88x31.png"); }
            // img:apnoea
            else if (recentItem == 6 || recentItem == 10) { LoadOurImages("FirstAid3.Resources.aid067.png"); LoadOurImages("FirstAid3.Resources.aid010.png"); LoadOurImages("FirstAid3.Resources.aid011.png"); }
            // img:backinjury
            else if (recentItem == 36 || recentItem == 59) { LoadOurImages("FirstAid3.Resources.aid065.png"); }
            // img:birth
            else if (recentItem == 25) { LoadOurImages("FirstAid3.Resources.aid025.png"); LoadOurImages("FirstAid3.Resources.aid022.png"); LoadOurImages("FirstAid3.Resources.aid023.png"); }
            // img:chemicalburneyes
            else if (recentItem == 9) { LoadOurImages("FirstAid3.Resources.aid019.png"); }
            // img:bleedinglight
            else if (recentItem == 13) { LoadOurImages("FirstAid3.Resources.aid084.png"); LoadOurImages("FirstAid3.Resources.aid085.png"); }
            // img:bleedingsevere
            else if (recentItem == 14) { LoadOurImages("FirstAid3.Resources.aid084.png"); LoadOurImages("FirstAid3.Resources.aid085.png"); LoadOurImages("FirstAid3.Resources.aid089.png"); LoadOurImages("FirstAid3.Resources.aid092.png"); }
            // img:brainconcussion
            else if (recentItem == 27) { LoadOurImages("FirstAid3.Resources.aid061.png"); }
            // img:dangerzone
            else if (recentItem == 26) { LoadOurImages("FirstAid3.Resources.aid001.png"); }
            // img:drowning
            else if (recentItem == 24) { LoadOurImages("FirstAid3.Resources.aid034.png"); }
            // img:electricityaccident
            else if (recentItem == 18) { LoadOurImages("FirstAid3.Resources.aid045plug.png"); }
            // img:epilepsy
            else if (recentItem == 19) { LoadOurImages("FirstAid3.Resources.aid058.png"); }
            // img:fracture
            else if (recentItem == 32) { LoadOurImages("FirstAid3.Resources.aid107.png"); }
            // img:heartattack
            else if (recentItem == 29) { LoadOurImages("FirstAid3.Resources.aid061.png"); }
            // img:icerescue
            else if (recentItem == 17) { LoadOurImages("FirstAid3.Resources.aid041.png"); }
            // img:recoveryposition
            else if (recentItem == 44) { LoadOurImages("FirstAid3.Resources.aid008.png"); LoadOurImages("FirstAid3.Resources.aid009.png"); LoadOurImages("FirstAid3.Resources.aid028.png"); }
            // img:resuscitation
            else if (recentItem == 28 || recentItem == 35 || recentItem == 58)
            {
                LoadOurImages("FirstAid3.Resources.aid013.png");
                LoadOurImages("FirstAid3.Resources.aid003.png");
                LoadOurImages("FirstAid3.Resources.aid067.png");
                LoadOurImages("FirstAid3.Resources.aid010.png");
                LoadOurImages("FirstAid3.Resources.aid011.png");
                LoadOurImages("FirstAid3.Resources.aid012.png");
                LoadOurImages("FirstAid3.Resources.aid029.png");
                LoadOurImages("FirstAid3.Resources.aid030.png");
            }
            // img:safeguardaccident
            else if (recentItem == 48 || recentItem == 55) { LoadOurImages("FirstAid3.Resources.aid001.png"); }
            // img:suffocation
            else if (recentItem == 23 || recentItem == 56) { LoadOurImages("FirstAid3.Resources.aid031.png"); LoadOurImages("FirstAid3.Resources.aid069.png"); }
            // img:sunstroke
            else if (recentItem == 42) { LoadOurImages("FirstAid3.Resources.aid061.png"); }
            // img: unconsciouswithbreath
            else if (recentItem == 11) { LoadOurImages("FirstAid3.Resources.aid008.png"); LoadOurImages("FirstAid3.Resources.aid009.png"); }



            // append Resuscitation measures! for unconsciouswithoutbreath / drowning / heartattack / brainconcussion / stroke / shock / poisining
            if (recentItem == 12 || recentItem == 24 || recentItem == 29 || recentItem == 37 || recentItem == 38 || recentItem == 40 || recentItem == 54)
            {
                menuExit.Text = "Weiter";
                menuExit.Enabled = true;
                // recentItem == 28 (for resuscitation)
                // LoadOurImages("FirstAid3.Resources.aid_resuscitation.png"); 
                // LoadOurImages("FirstAid3.Resources.aid013.png");
                // LoadOurImages("FirstAid3.Resources.aid003.png"); LoadOurImages("FirstAid3.Resources.aid067.png"); LoadOurImages("FirstAid3.Resources.aid010.png"); LoadOurImages("FirstAid3.Resources.aid011.png"); LoadOurImages("FirstAid3.Resources.aid012.png");
            }
            // for electricity / hypothermia
            else if (recentItem == 18 || recentItem == 49)
            {
                menuExit.Text = "Weiter";
                menuExit.Enabled = true;
                // recentItem == 28 (for resuscitation)
                // LoadOurImages("FirstAid3.Resources.aid_unconsciouswithbreath.png"); 
                // LoadOurImages("FirstAid3.Resources.aid_unconsciouswithoutbreath.png");
                // LoadOurImages("FirstAid3.Resources.aid_resuscitation.png"); 
                /*LoadOurImages("FirstAid3.Resources.aid003.png");
                LoadOurImages("FirstAid3.Resources.aid067.png");
                LoadOurImages("FirstAid3.Resources.aid010.png");
                LoadOurImages("FirstAid3.Resources.aid011.png");*/
            }
            // for sunstroke / asthma / hypoglycaemia
            else if (recentItem == 42 || recentItem == 5 || recentItem == 50)
            {
                LoadOurImages("FirstAid3.Resources.aid010.png");
                LoadOurImages("FirstAid3.Resources.aid011.png");
            }

        }
        private void LoadOurImages(String imageName) {
            // LOAD IMAGE TESTING #############################
            // Replace "filename" below with the actual filename for the JPG file you added as a resource; the name is case-sensitive.
            // Also make sure that "WindowsApplication1" is replaced with the name of your project, if different.
            // http://support.microsoft.com/kb/324567/de
            
            /// Stream s = null;

            try
            {
                Debug.WriteLine("TRY TO GET IMAGE stream");
                //// s = this.GetType().Assembly.GetManifestResourceStream("FirstAid3.aid089");
                _assembly = Assembly.GetExecutingAssembly();
                _imageStream = _assembly.GetManifestResourceStream(imageName);
                Debug.WriteLine(_imageStream);
            }
            catch (IOException e)
            {
                //Debug.WriteLine("{0} First exception caught.", e);
                Debug.WriteLine("COULD NOT LOAD IMAGE RESOURCE!"+e);
            }
            ///picBox1 = new PictureBox();
            ///picBox1.Name = imageName;
            try
            {
                // obsolete line: picBoxes[picCount] = new PictureBox();

                ///picBox1.Image = new Bitmap(_imageStream);
                ///picBox1.Size = new System.Drawing.Size(picBox1.Image.Size.Width, picBox1.Image.Size.Height); // maximal dimensions of our images: (234, 264)
                // picBox1.SizeMode = PictureBoxSizeMode.CenterImage;
                ///menuPanel.Controls.Add(picBox1); // ### TESTING ADD LOADED IMAGE ###   //original code: (ourMenu);
                
                picBoxes[picCount].Image = new Bitmap(_imageStream);
                // maximal dimensions of our images: (234, 264)
                picBoxes[picCount].Size = new System.Drawing.Size(sz.Width-scrollbarVertWidth, picBoxes[picCount].Image.Size.Height + 40); // +20 Offset below as spacer 
                // center image in screen
                picBoxes[picCount].SizeMode = PictureBoxSizeMode.CenterImage;
                // picBoxes[picCount].Image.Size.Width

                if (picCount == 0) {
                    picBoxes[picCount].Location = new System.Drawing.Point(0, detailsText.Height);
                }
                // all following pics orientate their position on the first one set
                else {
                    picBoxes[picCount].Location = new System.Drawing.Point(0, picBoxes[picCount - 1].Location.Y + picBoxes[picCount - 1].Height + 10); // +10 is offset
                }
                // menuPanel.Controls.Add(picBoxes[picCount]); 
                detailsPanel.Controls.Add(picBoxes[picCount]);
            }
            catch
            {
                MessageBox.Show("Error creating image!");
            }
            picCount++;


            // from http://support.microsoft.com/kb/319292

            // if stream s is not empty 
            /** if (_imageStream != null)
            {
                // http://www.pda-dev.de/post.asp?method=ReplyQuote&REPLY_ID=1407&TOPIC_ID=574&FORUM_ID=6
                Debug.WriteLine("Loading:" + s);
                Bitmap bmp = new Bitmap(s);
                s.Close();
                Graphics g = CreateGraphics();
                g.DrawImage(bmp, 0, 0);
                bmp.Dispose();
                g.Dispose();
                picBox1 = new PictureBox();
                picBox1.Image = (Image)bmp;
                picBox1.Size = sz; // test
                picBox1.SizeMode = PictureBoxSizeMode.StretchImage; // test
	        }
            else
            {
                Debug.WriteLine("## Stream Is Empty!");
            }**/




            // ourImage.Image = new Bitmap("\res\aid089.png");
            /** 
             * Bitmap bitmap = null;
            using (IplImage ipl = new IplImage("\res\aid089.png", LoadMode.Color)) {
                bitmap = ipl.ToBitmap();
            }
            Form form = new Form();
            form.Text = "Display IplImage in PictureBox";
            form.ClientSize = bitmap.Size;
            PictureBox pictureBox = new PictureBox();
            pictureBox.Dock = DockStyle.Fill;
            pictureBox.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox.Image = bitmap;
            form.Controls.Add(pictureBox);
            form.ShowDialog();
             * *
             */


            /*
             * http://stackoverflow.com/questions/809946/jpeg-loading-on-windows-mobile
            int size = (int)new FileInfo(files[i]).Length;
            FileStream fs = new FileStream(files[i], FileMode.Open);
            sw.Reset();
            sw.Start();
            Bitmap b2 = new Bitmap(fs);
            sw.Stop();
            Debug.WriteLine(files[i] + "\n\t" + 
                sw.ElapsedMilliseconds.ToString());
            fs.Close();
            */

//##
            // HBITMAP hbmp = SHLoadImageFile(L"\res\aid089.png");

            // http://www.codeguru.com/forum/showthread.php?t=428287

            // http://code.google.com/p/pfeopenplug/wiki/DecodageImageWindowsMobile

            // important after use: DeleteObject()
            // http://www.1-script.com/forums/shall-I-release-HBITMAP-returned-from-SHLoadImageFile-article3683--15.htm

            // MSN Lib: http://msdn.microsoft.com/en-us/library/aa918637.aspx



            //##//

            /*** Image List ***/
            // http://msdn.microsoft.com/de-de/library/system.windows.forms.imagelist%28VS.80%29.aspx
            // ImageList test = new ImageList();


            // ? http://social.msdn.microsoft.com/Forums/en-US/vssmartdevicesvbcs/thread/2eeac284-309b-49f6-9d88-47f4bef2cc6c

            // streamreader http://msdn.microsoft.com/en-us/library/system.io.streamreader.aspx
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

    }
}


/* DOCUMENTATION

 * #1 KeyPreview
 * When this property is set to true, the form will receive all KeyPress, KeyDown, and KeyUp events. 
 * After the form's event handlers have completed processing the keystroke, the keystroke is then assigned to the control with focus. 
 * For example, if the KeyPreview property is set to true and the currently selected control is a TextBox, 
 * after the keystroke is handled by the event handlers of the form the TextBox control will receive the key that was pressed. 
 * To handle keyboard events only at the form level and not allow controls to receive keyboard events, set the KeyPressEventArgs. 
 * Handled property in your form's KeyPress event handler to true.
 * 
 * You can use this property to process most keystrokes in your application and 
 * either handle the keystroke or call the appropriate control to handle the keystroke. 
 * For example, when an application uses function keys, you might want to process the 
 * keystrokes at the form level rather than writing code for each control that might receive keystroke events.
 * 
 */


/* MEMOS:

http://msdn.microsoft.com/library/default.asp?url=/library/en-us/cpref/html/frlrfSystemWindowsFormsFormClassKeyPreviewTopic.asp

Form.KeyPreview sets whether or not the form gets key events before they are passed to the control in focus

  
Pocket-PC - Automatische Höhe für Labels
http://oliana.de/blog/2008/05/27/automatische-hohe-fur-labels-im-compact-framework-auf-dem-pocket-pc/
*/


/*
        VScrollBar vScrollBar1 = new VScrollBar();

            // this.vScrollBar1.Scroll += new System.Windows.Forms.ScrollEventHandler(this.vScrollBar1_Scroll);
            // scrollbar
            // initiateScrollbar();
            // assign scroll event handler when focussed
            // this.detailsPanel.GotFocus += new System.EventHandler(scrollNow);

        private void initiateScrollbar() {
                    //Set the initial size, position, and value of VScrollbar1
                    this.vScrollBar1.Height = this.ClientSize.Height;
                    this.vScrollBar1.Left = this.Width - vScrollBar1.Width;
                    this.vScrollBar1.Minimum = 0;
                    this.vScrollBar1.Maximum = this.detailsPanel.Height + this.ClientSize.Height + 5;
                    this.vScrollBar1.Value = 0;
                    //this.Controls.Add(vScrollBar1); // zur form?
                    // oder besser direkt aufs Panel, siehe unten
        }

 
        // vScrollBar1.Focus(); 
        //vScrollBar1.Value += 20;
        
            // add scrollbar
            // detailsPanel.Controls.Add(vScrollBar1);
*/



/**
 * 
 * how to deploy your app: 
 * http://www.devx.com/wireless/Article/31198/0/page/1
 * 
**/