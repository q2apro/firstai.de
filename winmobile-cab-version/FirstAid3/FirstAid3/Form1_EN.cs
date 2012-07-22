/* 
 * Project: www.Firstai.de
 * 
 * File: Form1_EN.cs
 * Version: w0.1 pre
 * Download: http://www.firstai.de/english/download-winmobile.html
 * 
 * Language: C# (.NET Compact Framework)
 * Target: Windows Mobile 6.0
 * Devices: SmartPhone, PDA, PocketPC
 * 
 * Author: Kai Kajus Noack
 * Date: 2009-11-09
 * 
 * License Source Code: GNU General Public License (GPL)
 * http://www.gnu.org/licenses/gpl.html
 * 
 * License First Aid Texts (Strings): Creative Commons 3.0 BY_NC_ND
 * http://creativecommons.org/licenses/by-nc-nd/3.0/de/deed.en
 * 
 */

// imports
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
using System.Reflection; // for assembly
using System.IO; // for stream


namespace FirstAid3 {

    public partial class Form1 : Form {

        // for automatically adjusting height of textfield
        [DllImport("coredll.dll")]  
        static extern int DrawText(IntPtr hdc, string lpStr, int nCount, ref Rectangle lpRect, int wFormat);

        /*************** FIRST AID TEXTS ***************/
        string aid_disclaimer = "1. Software\nFirst Aid on your Mobile\nVersion: w0.1pre\nRelease: 2009-11-09\nCopyright: Kai Kajus Noack\n\nLicence: Creative Commons\n\nIllustrations © Med4Teens\n\nThis program is supposed to give information on first aid. However, it does not represent a substitute to a first aid course. It rather serves you refreshing your already acquired knowledge.\n\n\n2. Disclaimer\nPlease note that we take no responsibility for consequences resulting from the use of the software.\n\nANY LIABILITY IS EXCLUDED!\nUSE AT YOUR OWN RISK!\n\nIn all emergencies, please seek professional help immediately.\n\n\n3. Project Development\nThe program is supposed to become multilingual. Voluntary Translators needed!!\n\nFurther information is available on the Internet www.firstai.de or write an email to: info@firstai.de\n\nTo save one life is to have saved the world.";
        string aid_general = "1. Always perform first aid. You cannot make any mistakes.\n\n2. Always pay attention to your own safety.\n\n3. Examine the situation and secure the accident place.\n\n4. Emergency call + First Aid measures!\n\n5. If there are several casualties, the treatment of the most harmed has priority.\n\n6. Always try to calm down the person concerned. Stay calm yourself!\n\n7. If possible lay her/him down comfortably. Never give alcohol, nicotine or drugs to a person who is the victim of an accident.";
        string aid_allergic = "1. Phone for an ambulance immediately.\n\n2. Try to calm down the casualty and let him sit comfortable.\n\n3. Remove allergic causing matter (e.g. sting of a bee) carefully.\n\n4. Cool affected skin (wet compress, ice).\n\n5. If casualty has an antidote, he should use it (help him).\n\n6. Monitor casualty's condition until ambulance arrives.\n\n7. If casualty loses consciousness or breathing stops, follow appropriate instructions!";
        string aid_amputation = "Amputated body part can be reattached again. Goal: Keep amputated part cool until you arrive at hospital.\n\n1. Calm the person, lay him/her down, and cover with blanket.\n\n2. Stop the bleeding, see 'Bleeding (severe)' and 'Shock'.\n\n3. Wrap amputated part in a clean and dry cloth, and put it into a waterproof plastic bag.\n\n4. Close this plastic bag and put it into another plastic bag, that contains cool water/ice.\n\n5. Do not give alcohol, cigarettes or food to casualty (in case of a surgery with anaesthesia in hospital).\n\n6. Do not freeze the amputated part (just keep it cool).\n\n7. Call emergency or drive casualty to hospital yourself.";
        string aid_animalbite = "Attention: High danger of infection. Result could be infection, tetanus, rabies.\n\n1. Wash wound with hot soapy water.\n\n2. Afterwards disinfect the wound.\n\n3. If there is severe bleeding, elevate the person's upper body.\n\n4. Apply an aseptic bandage.\n\n5. Go to a hospital or call emergency doctor.";
        string aid_apnoea = "No breathing sounds or breath movements, noticeable discolouration of the skin.\n\n1. Emergency call.\n\n2. Lay casualty on his/her back.\n\n3. Remove any substances from the mouth and throat. Stretch head backwards.\n\n4. Pinch the nose, so that nose is closed.\n\n5. Take a deep breath and put your mouth onto the mouth of the casualty, that no air can leak.\n\n6. Breath out slowly and fully.\n\n7. If without success: Do breathing as long as ambulance arrives.";
        string aid_asthma = "Heavy breathlessness. Wheezing respiratory noise. Anxieties.\n\n1. Calm the person. Stay calm yourself!\n\n2. Loosen clothing.\n\n3. Let casualty sit and lean forward, encourage him/her to breath slowly and deeply.\n\n4. If casualty has an inhalator, he should use it (help him). After 5-10 min it should take effect.\n\n5. If there is no improvement: Use inhalator every 5 min until ambulance arrives.\n\n6. Emergency call.\n\n7. If apnoea (cessation of breathing) occurs, follow instructions given for apnoea.";
        string aid_backinjury = "Pain in the back, numb arms and legs.\n\n1. Do not move the casualty!!\n\n2. Hold the head so that the person lies still (keep their head stationary)\n\n3. Stabilize the casualty with bolsters on either side.\n\n4. Calm the person.\n\n5. Emergency call, point out the back injury.";
        string aid_birth = "Outflow of amniotic fluid. Contraction pains occur. Unexpected birth.\n\n1. Pay attention to privacy and keep calm! - Emergency call.\n\n2. Let the pregnant woman bare the lower part of her body, and sit down on a sterile underlay with spread legs.\n\n3. Angle the knees. Pull up the legs. Position the basin slightly upward. - Birth is a natural process and runs mostly without complications.\n\n4. Calm the woman, let her concentrate on her breathing: Breathe in through nose, breathe out through mouth (in normal speed).\n\n5. Rhythm of pressing: Take a deep breath, hold breath, and press. As soon as the baby's head appears, support by taking hold of it with both of your hands.\n\n6. After the childbirth: Hold the baby on a slant with head down to liberate the airways from amniotic fluid. (You may have to suck out the fluid from the baby's nose by mouth.) The baby must breathe and cry!\n\n7. Bind off the umbilical cord 30 cm away from the child (can also be done in hospital). Keep the vagina of the mother sterile.\n\n8. Dry the baby and keep it warm. Note the time and drive to the hospital.";
        string aid_bleedinglight = "Goal: Stop the bleeding.\n\n1. Do not touch the wound (danger of infection).\n\n2. Do not treat wound with powder, salves or sprays.\n\n3. Wound treatment: cover with sterile material and a bandage.\n\n4. For slight bleeding a plaster is often sufficient.\n\n5. If wound is large-scale, use a wound cover and a bandage. Do not apply bandage too tight, as a stasis can lead to increased bleeding.\n\n6. Note: Wounds as a result of the bite from a rabid animal have to be washed with soapy solution.";
        string aid_bleedingsevere = "Splashing, pulsating blood. Danger: Choking because of blood loss, infections, death. Goal: Stop the bleeding.\n\n1. Remove clothes (cut if necessary) and reveal wound.\n\n2. Wrap a bandage or, if necessary, a garment with pressure around the wound.\n\n3. Exert pressure for at least 10 min.\n\n4. If bandage is soaked with blood, do not remove it. Instead wrap another bandage/garment around it.\n\n5. Place the affected limb (if not broken) higher than the heart to reduce amount of blood pressure. If possible lay down casualty.\n\n6. If bleeding does not stop, keep pressure on wound, and set additional pressure point on wound: For a bleeding of the forearm compress the upper arm (press vein at inner side of arm, in the middle of elbow and arm-pit, using your fingers). For bleeding of leg, set pressure point in groin (press vein at crook of groin, where artery leads over pelvic bone, using the ball of your hand).\n\n7. Call emergency doctor immediately.\n\n8. As soon as bleeding is under control: Initiate anti-choking measures.";
        string aid_brainconcussion = "Headache, nausea, vomiting. Impaired vision. Unconsciousness can occur.\n\n1. Lay down person concerned.\n\n2. Emergency call.\n\nIf bleeding from head:\n\n1. Lay down casualty, with the head elevated (on pillow).\n\n2. Do wound-treatment (use head-bandage).\n\n3. Emergency call.";
        string aid_burningslight = "Redness of skin. Mild swellings. Pain.\n\n1. Hold area involved under cool water.\n\n2. Apply wet bandage loosely.";
        string aid_burningsevere = "Spotted white-red areas, blistering. Skin loses fluid. Deep damage of tissue. Strong pain or no pain (because of burned nerves).\n\n1. Remove clothes as much as possible.\n\n2. Cool burned body parts with water (about 15°C, 59°F) up to 10 min, until pain reduces.\n\n3. If burning is extensive, just use wet cloths to cool.\n\n4. Emergency call.\n\n5. After cooling, do the wound treatment: Use a sterile dressing. Do not apply fluids (no creams, oils, ointments etc.). Do not pierce the blisters.\n\n6. Control breathing and consciousness of the person until emergency doctor arrives.";
        string aid_checkbreathing = "1. Check breathing sounds.\n\n2. Diagnose breathing in the upper abdomen (lay your hand on it).\n\n3. Sense breathing at nose and mouth.";
        string aid_chemicalburneyes = "1. Emergency call, point out chemicals.\n\n2. Flush eye with much water. Cover healthy eye during flushing.\n\n3. Lead the water jet from inner angle of eye to outer angle of eye. Clean for at least 20 min under clear water.\n\n4. Close both eyes of the casualty and bind with wet cloth.\n\n5. Monitor condition until ambulance arrives.";
        string aid_chemicalburn = "Injury of tissue.\n\n1. Mind self-protection!\n\n2. Act quickly and wash the burned locations.\n\n3. Emergency call.\n\n4. If there is a chemical burn of the digestive tract, particularly the mouth and throat, drink a lot of water.\n\n5. Do not cause vomiting!";
        string aid_dangerzone = "1. Grip execution: Position one arm of the injured in front of his/her chest, and get behind him/her.\n\n2. Put your hands under the shoulders of the wounded, grabbing the angled arm.\n\n3. Pull back and carry the person into safety.";
        string aid_diabeticcoma = "Blood sugar level is too high (resp. lack of insulin).\nSymptoms: Thirst, frequent urination, nausea, vomit. Breath smells of fruits/wine.\n\n1. Call emergency.\n\n2. Support casualty (if confirmed as diabetic) taking insulin.\n\n3. Recovery position. (No further possibilities for the first aider.)\n\n4. Monitor the condition of the casualty until emergency doctor arrives.";
        string aid_diarrhoea = "Reaction to contaminated food, infection of intestine or disorder. Stool is diluted, slimy or bloody.\n\n1. Danger for the circulation because of dehydration and loss of salt!\n\n2. Give liquids (tea, water).\n\n3. If there are strong disorders call the emergency doctor.";
        string aid_drowning = "1. Call emergency. Ask people next to you for help.\n\n2. Rescue person out of water!\n\n3. If casualty is breathing: Recovery position. Keep him/her warm (cover). Monitor condition until emergency doctor arrives.\n\n4. If casualty is not breathing: Immediately start with resuscitation! (Ejecting water from the lungs is useless.)";
        string aid_electricityaccident = "1. Firstly interrupt the electricity supply!\nDanger: Unconsciousness, apnoea.\n\n2. A - Unconsciousness with breathing\n\n3. B - Unconsciousness without breathing";
        string aid_emergencycall = "1. Dial 112 with the next available phone (USA: 911). Always possible and for free! Do not hesitate to call for an ambulance!\n\n2. On the phone you must provide the following information:\n\n- What has happened\n\n- Where (accident place)\n\n- How many casualties\n\n- What kind of injuries.\n\nAfterwards wait for further instructions or queries.";
        string aid_epilepsy = "Rigid body, clenched fists, pressed jaw, twitching in limbs or face. Rolling eyes. Salivation. Unconsciousness possible.\n\n1. Do not hold the casualty or restrain their movement.\n\n2. Lay the casualty on a soft base (cushion), remove close objects to prevent self-injury.\n\n3. Calm down the casualty. Loosen clothing, provide freedom to breath.\n\n4. If casualty vomits, turn their head to the side so that vomit can drain.\n\n5. Keep airways clear. Danger of swallowing the tongue.\n\n6. Recovery Position + Emergency call. Continue monitoring the casualty's condition.\n\n7. Keep other people at distance.";
        string aid_eyeinjury = "1. Leave object in the eye of casualty, do not remove it.\n\n2. Keep eyes motionless to avoid further injuries. Do not touch the eye.\n\n3. If eye is bleeding, cover it with a compress or a sterile gauze.\n\n4. Cool the eye with a cold pad (reduces swelling, bleeding stops quicker).\n\n5. Emergency call or drive casualty to hospital yourself.";
        string aid_fracture = "Symptoms: Unnatural position and movability of bone. Deformation. Painful movement, touch-sensitive.\n\n1. Avoid movements!\n\n2. Emergency call.\n\n3. Immobilize the fractured bone, i.e. bolster material around bone tightly. Keep position of the bone.\n\n4. If fracture is open, cover the wound with sterile material.";
        string aid_frostbitemild = "Paleness, swellings. Danger for blood supply.\n\n1. Move casualty into a warm area.\n\n2. Get away from cold, remove cold clothes, dry person.\n\n3. Warm up with lukewarm water and with body heat of the helper.\n\n4. Give warm drink (tea). No alcohol!";
        string aid_frostbitesevere = "Cold hard skin, grey-white, blistering, tissue dies off. Danger for blood supply!\n\n1. Go to warm area.\n\n2. Wound treatment/covering.\n\n3. Give a sugary drink.\n\n4. Do not rub the casualty to warm them!\n\n5. Emergency call.";
        string aid_heartattack = "Heavy, more than 5 min lasting pressure and pain in the chest, particularly radiating in the arms/shoulders. Anxiety, paleness, cold sweat. Possibly nausea, shortness of breath.\n\n1. Emergency call! Point out the supposed heart attack.\n\n2. Position with the upper body elevated. Loosen tight clothing. Do not give drugs or drinks.\n\n3. Talk calmly to the person concerned.\n\n4. Control consciousness and breathing.\n\n5. Give aspirin if available.\n\n6. If person becomes unconscious, start resuscitation.";
        string aid_hypoglycaemia = "Blood sugar level is below minimum value (because of overdose of insulin or insufficient intake of food).\nSymptoms: Paleness, nervousness, hunger, shivering, sweating.\n\n1. Make sure that the person is a diabetic (look for a diabetic badge).\n\n2. Emergency call.\n\n3. Give a sugary drink and dextrose/glucose (if there are no problems in swallowing).\n\n4. If person is conscious and breathing: Recovery position. Monitor breathing of the person. If apnoea appears, start with breath giving.\n\n5. If there is breathing, you can put a lump of sugar into the cheek pouch, push from outside against it.";
        string aid_hyperthermia = "Thirst, weakness, disorientation, nausea, confusion, strong sweating, hot skin.\n\n1. Emergency call.\n\n2. Find a cool shady place (room with air conditioning preferable).\n\n3. Lay down person, elevate legs. Loosen clothing.\n\n4. Cool skin with cold water or lay on cold towels.\n\n5. Give plenty of water or juices to drink.";
        string aid_hypothermia = "Cold shiver, drowsiness, exhaustion up to unconsciousness. Cold pale skin. Slow pulse, weak heartbeat.\n\n1. Go to a warm area/room.\n\n2. Call emergency.\n\n3. Increase body temperature (cover and body-to-body-contact).\n\n4. Remove wet clothes and put on warm clothes. Cover with blankets or other covers. Cover the head.\n\n5. Give hot tea, soup or hot water to drink. No alcohol! Keep person awake.\n\n6. Monitor casualty's condition until emergency doctor arrives. If person becomes unconscious, initiate resuscitation:\n\n7. A - Unconsciousness with breathing\n\n8. B - Unconsciousness without breathing";
        string aid_icerescue = "Pay attention to your own safety. Danger: Drowning, Hypothermia.\n\n1. Ask other people for help. Call for an emergency ambulance.\n\n2. Rescue via ladder, board or bar. Weight must be distributed evenly.\n\n3. Crawl carefully on your front along the support (if possible roped to a stable point) with a pole or similar tool.\n\n4. Reach to the person with the pole or other tool (not your hand!), encourage him/her to take hold of it and pull him/her out.\n\n5. Crawl backwards back to the edge.\n\n6. First-Aid measures.\n\n7. Self-rescue possible: If ice is solid, you can distribute your weight on the ice and pull yourself out. Crawl flat on your front to the edge. If ice is fragile, try to break the ice piece by piece up to the edge.";
        string aid_insectstings = "Swelling, skin rash, burning feeling, weakness, difficult breathing, decreased consciousness, tachycardia.\n\n1. Remove sting carefully (with a tweezer). Do not squeeze the sting as this could inject more venom.\n\n2. Cool concerned spot (apply a cold compress).\n\n3. Concerned area should be kept lower than the heart to slow circulation of the venom.\n\n4. If stung in mouth/jaw area: Suck ice-cream, and apply a cold compress around throat.\n\n5. If severe problems, notably difficulty in breathing or decreased consciousness, occur, call an ambulance immediately.";
        string aid_nosebleeding = "Burst small artery in the nose.\n\n1. Sit the person down, leaning slightly forward. Keep head straight.\n\n2. Do not position the person flat, as head over height of heart slows down bleeding.\n\n3. Place cooling material round neck (wet cloth).\n\n4. Pinch nostrils together until bleeding stops (for 10 min).\n\n5. Afterwards do not strain the nose (no snorting).\n\n6. If severe problems occur or bleeding cannot be stopped, call emergency doctor.";
        string aid_poisining = "Confusion, hallucinations, enlarged pupils, fever, cramps. Unconsciousness.\n\n1. Only give antidotes if you are accompanied by a trained medic.\n\n2. Do not give drinks. Do not cause vomiting.\n\n3. Emergency call + point out the poisoning!\n\n4. Safeguard rest of poison and the vomit!\n\n5. If casualty is conscious and breathing: Recovery position. Monitor condition until emergency doctor arrives.\n\n6. If casualty is not breathing: Immediately start with resuscitation! Free mouth from vomit beforehand.";
        string aid_recoveryposition = "1. Lay casualty on her/his back, straighten legs. Knee beside him/her.\n\n2. Place arm nearest to you at a right angle to the body.\n\n3. Pull arm furthest from you across the chest and place the back of the hand against cheek.\n\n4. Get the far knee, pull it to your side, and lay it on the ground. Position the leg at a right angle. Keep casualty's hand under the cheek of the person.\n\n5. Make sure the airways are free.\n\n6. Open mouth slightly, and position the head to the side so that vomit can drain. Check breathing.\n\n7. Control the casualty's condition until the emergency doctor arrives.";
        string aid_resuscitation = "# Heart Massage\n\n1. Lay casualty on his/her back. Kneel beside person.\n\n2. Bare the chest.\n\n3. Place the heel of the hand in the middle of the chest (just over sternum).\n\n4. Place other hand on the back of the hand which is already in position.\n\n5. Extend your arms and elbows.\n\n6. Press 5 cm deep into the person's chest (power comes from upper part of the body) and release.\n\n7. Push 30 times in a row shortly and strongly!\n\n# Breathing\n\n1. Remove any substances out of mouth and throat. Stretch head backwards.\n\n2. Pinch the nose together, so that nose is closed.\n\n3. Take a deep breath and put your mouth onto the mouth of the casualty, that no air can leak.\n\n4. Do mouth-to-mouth breathing two times (breath out slowly and fully).\n\n5. Afterwards do heart massage again.\n\nRepeat heart massage + mouth-breathing until the emergency doctor arrives. " +
            "Attention: Only use two fingers for the resuscitation of babies and do not breath too strong!";
        string aid_safeguardaccident = "1. Stop your own car 50-100 m behind the accident site (if you are on a highway or country road). Switch on warning lights. Put on high visibility vest.\n\n2. Position the warning triangle before the accident site. Attention: If accident is on a curve position the warning triangle before the curve!\n\n3. Ask other people for their help.\n\n4. Open the door of the accident car (if jammed, prise it open using a car jack). Turn off ignition.\n\n5. Rescue the accident victim: Unstrap seat-belt, move seat backwards. Free the casualty out of the car by rescue grip.\n\n6. Emergency call.\n\n7. Proceed with first aid measures.";
        string aid_shock = "Circulatory disorder by poor oxygen supply in the body.\nCause: Loss of fluid, reduced blood volume.\nSymptoms: Paleness, cold skin, cold sweat, anxiety.\n\n1. Eliminate the cause of the shock (e.g. stop the fluid loss, bind the wound)!\n\n2. Lay the wounded person on a blanket, raising the legs. Calm the person.\n\n3. Emergency call.\n\n4. If difficulties in breathing or consciousness, initiate resuscitation.";
        string aid_skullfracture = "Light bleeding from nose, mouth or ear. Often open wounds on skull.\n\n1. Keep the airways free.\n\n2. If conscious: Let the injured sit with head bowed forwards. Avoid further movements!\n\n3. If unconscious: Recovery position (no pressure on wound of head).\n\n4. Emergency call.\n\n5. Apply head bandage.\n\n6. If difficulties in breathing or consciousness, initiate resuscitation.";
        string aid_snakebite = "Puncture wound the size of a pin, severe pains, swelling, purple colour. Circulatory disturbance, danger of shock.\n\n1. Steady the wounded part of the body.\n\n2. Apply cold material around bite wound.\n\n3. Take measures against shock.\n\n4. Emergency call.";
        string aid_sos = "1. Signal: 3x short, 3x long, 3x short.\n\n2. Optically (strobe light, flashlight), or acoustically (signal whistle, knocking).";
        string aid_sprain = "Pain, swelling (bruise), loss of function, deformation of the limb.\n\n1. Place the injured part of the body in the position most comfortable for the casualty.\n\n2. Cool (using ice packs).\n\n3. If possible, position the injured part elevated.\n\n4. Go to hospital or call emergency doctor.";
        string aid_stroke = "Sudden feeling of paralysis or numbness (face, arm, leg), disturbances in language understanding, vision problems, disturbed consciousness, severe headache. Problems in breathing and swallowing, loss of control over bladder and intestine.\n\n1. Emergency call!\n\n2. Loosen tight clothing. Do not give drugs or drinks.\n\n3. Sit or lay down person concerned comfortably. Calm him/her!\n\n4. Control consciousness and breathing.\n\n5. If difficulties in breathing or consciousness, initiate resuscitation.";
        string aid_suffocation = "Insufficient oxygen supply. Trachea closed. Danger: Apnoea.\nSymptoms: Wheezing respiratory noise, cough stimulus, shortness of breath, skin discolouration.\n\n1. Immediate action! Let the person concerned cough very strongly.\n\n2. Strike strongly with a flat hand on the back between the shoulder blades (lay babies on your forearm, with head down).\n\n3. If without success: Stand behind person, arms around waist, bow slightly forward.\n\n4. Clench your fist, position it at height of person's stomach, and take it with your other hand.\n\n5. In embrace use both hands to give a hard blow upwards towards stomach (as if you would try to lift the person).\n\n6. Repeat this up to 5 times! Airways should get free from object.\n\n7. Emergency call.\n\n8. If first aid measure is unsuccessful at first, keep on doing it until emergency doctor arrives.";
        string aid_sunburn = "1. Remove affected person from direct sunlight. Avoid further sun.\n\n2. Drink much water to stop dehydration.\n\n3. If there is a serious sunburn (blisters, redness, pain), seek medical advice.\n\n4. If the skin is just lightly red, it can be cooled with wet compresses. Use after-sun lotion or gel.";
        string aid_sunstroke = "Hot red head, cool skin, sickness, headache, dizziness. Cause: Irritation of the cerebral membrane.\n\n1. Go to a cool place (shadow) and position the upper body of the person up.\n\n2. Cool the head with wet blankets.\n\n3. Emergency call, keep controlling the breathing.\n\n4. If conscious: Give cool drink if applicable.\n\n5. If apnoea appears, start with breathing:\n\n6. Go on with Breath Giving!";
        string aid_unconsciouswithbreath = "No reaction on loudly asking, no response on shaking. Breathing does exist.\n\n1. If there are people next to you ask for help.\n\n2. Recovery position. Open mouth and position head this way that vomit can drain.\n\n3. Emergency call.";
        string aid_unconsciouswithoutbreath = "1. No reaction of casualty, no breathing.\n\nInitiate Resuscitation.";
        string aid_vomiting = "Arises from nausea. Stomach empties itself. Causes: Infection, poisoning, ulcer, drugs, bad food, pregnancy.\n\n1. Danger for the circulation because of dehydration and loss of salt!\n\n2. Give liquids (tea, water).\n\n3. If there are strong disorders, bloody or continuous vomiting, call the emergency doctor.";
        string separator = "-";
        string aid_donate = "If you want that the software development continues, please donate to our developers at www.FirstAi.de\n\nPlanned Features:\n- Touchscreen-Support\n- more Illustrations\n- better Interface\n- Audio-Version\n- Direct Dialling of Emergency Numbers";
        
        /**************************************/

        // GLOBALS
        Size sz = new Size();
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

        string stringAfrica = "\n# Algeria\nFire:14 | Pol:17 | Med:17\n\n# Angola\nFire:118 | Pol:110 | Med:118\n\n# Benin\nFire:18 | Pol:17 | Med:301769\n\n# Botswana\nFire:998 | Pol:999 | Med:997\n\n# Burkina Faso\nFire:18 | Pol:17 | Med:local numbers\n\n# Burundi\nFire:no system | Pol:no system | Med:no system\n\n# Cameroon\nFire:18 | Pol:17 | Med:local numbers\n\n# Cape Verde\nFire:131 | Pol:132 | Med:130\n\n# Central African Republic\nFire:118 | Pol:611253 | Med:610600\n\n# Chad\nFire:18 | Pol:17 | Med:local numbers\n\n# Comoros\nFire:only radio telephones | Pol:only radio telephones | Med:only radio telephones\n\n# Congo (Democratic Republic)\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Congo (Republic)\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Djibouti\nFire:18 | Pol:17 | Med:351351\n\n# Egypt\nFire:180 | Pol:122 | Med:123\n\n# Equatorial Guinea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Eritrea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Ethiopia\nFire:93 | Pol:91 | Med:92\n\n# Gabon\nFire:18 | Pol:1730 | Med:1300\n\n# Gambia\nFire:118 | Pol:117 | Med:116\n\n# Ghana\nFire:192 | Pol:191 | Med:193\n\n# Guinea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Guinea-Bissau\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Ivory Coast\nFire:180 | Pol:110 | Med:110\n\n# Kenya\nFire:999 | Pol:999 | Med:999\n\n# Lesotho\nFire:122 | Pol:123 | Med:121\n\n# Liberia\nFire:911 | Pol:911 | Med:911\n\n# Libya\nFire:193 | Pol:193 | Med:193\n\n# Madagascar\nFire:18 | Pol:117 | Med:2262566\n\n# Malawi\nFire:199 | Pol:199 | Med:199\n\n# Mali\nFire:18 | Pol:17 | Med:15\n\n# Mauritania\nFire:118 | Pol:117 | Med:local numbers\n\n# Mauritius\nFire:999 | Pol:999 | Med:999\n\n# Mayotte\nFire:603054 | Pol:112 | Med:15\n\n# Morocco\nFire:15 | Pol:19 | Med:15\n\n# Mozambique\nFire:198 | Pol:119 | Med:117\n\n# Namibia\nFire:2032270 | Pol:1011 | Med:2032276\n\n# Niger\nFire:18 | Pol:17 | Med:723141\n\n# Nigeria\nFire:190 | Pol:119 | Med:199\n\n# Réunion\nFire:18 or 112 mobile | Pol:17 or 112 mobile | Med:15 or 112 mobile\n\n# Rwanda\nFire:local numbers | Pol:112 | Med:local numbers\n\n# Sahrawi Arab Democratic Republic\nFire:-- | Pol:-- | Med:--\n\n# Sao Tomé and Principe\nFire:-- | Pol:-- | Med:--\n\n# Senegal\nFire:local numbers | Pol:local numbers | Med:8891515\n\n# Seychelles\nFire:999 | Pol:999 | Med:999\n\n# Sierra Leone\nFire:999 | Pol:999 | Med:999\n\n# Somalia\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# South Africa\nFire:10111 | Pol:10111 | Med:10177\n\n# Sudan\nFire:999 | Pol:999 | Med:local numbers\n\n# Swaziland\nFire:local numbers | Pol:999 | Med:6060911\n\n# Tanzania\nFire:112 | Pol:112 | Med:112\n\n# Togo\nFire:118 | Pol:101 | Med:191\n\n# Tunisia\nFire:198 | Pol:197 | Med:190\n\n# Uganda\nFire:999 or 111 mobile | Pol:999 or 111 mobile | Med:999 or 111 mobile\n\n# Zambia\nFire:993 or 112 mobile | Pol:999 or 112 mobile | Med:991 or 112 mobile\n\n# Zimbabwe\nFire:993 | Pol:995 | Med:994";
        string stringAsia = "\n# Afghanistan\nFire:-- | Pol:-- | Med:112\n\n# Armenia\nFire:101 | Pol:102 | Med:103\n\n# Azerbaijan\nFire:101 | Pol:102 | Med:103\n\n# Bahrain\nFire:999 | Pol:999 | Med:999\n\n# Bangladesh\nFire:9555555 | Pol:8665513 | Med:199\n\n# Bhutan\nFire:113 | Pol:110 | Med:112\n\n# Brunei\nFire:995 | Pol:993 | Med:991\n\n# Cambodia\nFire:118 | Pol:117 | Med:199\n\n# China\nFire:119 | Pol:110 | Med:120\n\n# East Timor\nFire:-- | Pol:112 | Med:7233212\n\n# Georgia\nFire:022 | Pol:022 | Med:022\n\n# Hong Kong\nFire:999 | Pol:999 | Med:999\n\n# India\nFire:101 | Pol:100 | Med:102\n\n# Indonesia\nFire:113 | Pol:110 | Med:118\n\n# Iran\nFire:125 or 112 mobile | Pol:110 or 112 mobile | Med:115 or 112 mobile\n\n# Iraq\nFire:no system | Pol:no system | Med:no system\n\n# Israel\nFire:102 | Pol:100 | Med:101\n\n# Japan\nFire:119 | Pol:110 | Med:119\n\n# Jordan\nFire:193 | Pol:192 | Med:193\n\n# Kazakhstan\nFire:03 | Pol:03 | Med:03\n\n# Kurdistan\nFire:125 | Pol:129 | Med:115\n\n# Kuwait\nFire:777 | Pol:777 | Med:777\n\n# Kyrgyzstan\nFire:03 | Pol:133 | Med:03\n\n# Laos\nFire:local numbers | Pol:local numbers | Med:03\n\n# Lebanon\nFire:175 | Pol:112 | Med:140\n\n# Macau\nFire:999 | Pol:999 | Med:999\n\n# Malaysia\nFire:999 or 112 mobile | Pol:999 or 112 mobile | Med:999 or 112 mobile\n\n# Maldives\nFire:118 | Pol:119 | Med:102\n\n# Mongolia\nFire:101 | Pol:102 | Med:103\n\n# Myanmar\nFire:199 | Pol:199 | Med:199\n\n# Nepal\nFire:101 | Pol:100 | Med:228094\n\n# North Korea\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Oman\nFire:999 | Pol:999 | Med:999\n\n# Pakistan\nFire:16 | Pol:15 | Med:115\n\n# Philippines\nFire:117 | Pol:117 | Med:117\n\n# Qatar\nFire:999 | Pol:999 | Med:999\n\n# Saudi Arabia\nFire:998 | Pol:999 | Med:997\n\n# Singapore\nFire:995 | Pol:999 | Med:995\n\n# South Korea (Republic Korea)\nFire:119 | Pol:112 | Med:119\n\n# Sri Lanka\nFire:111 | Pol:119 or 112 mobile | Med:110\n\n# Syria\nFire:113 | Pol:112 | Med:110\n\n# Taiwan\nFire:119 | Pol:110 | Med:119\n\n# Tajikistan\nFire:local numbers | Pol:02 | Med:03\n\n# Thailand\nFire:199 | Pol:191 or 1155 (tourists) | Med:191\n\n# Turkmenistan\nFire:03 | Pol:03 | Med:03\n\n# United Arab Emirates\nFire:997 | Pol:999 | Med:998\n\n# Uzbekistan\nFire:03 | Pol:03 | Med:03\n\n# Vietnam\nFire:114 | Pol:113 | Med:115\n\n# Yemen\nFire:199 | Pol:199 | Med:199";
        string stringEurope = "\n# Albania\nFire:18 | Pol:19 | Med:17\n\n# Andorra\nFire:118 | Pol:110 | Med:118\n\n# Austria\nFire:112 | Pol:112 | Med:112\n\n# Belarus\nFire:01 | Pol:02 | Med:03\n\n# Belgium\nFire:112 | Pol:112 | Med:112\n\n# Bosnia and Herzegovina\nFire:123 | Pol:122 | Med:124\n\n# Bulgaria\nFire:112 | Pol:112 | Med:112\n\n# Croatia\nFire:93 | Pol:92 | Med:94\n\n# Cyprus\nFire:112 | Pol:112 | Med:112\n\n# Czech Republic\nFire:112 | Pol:112 | Med:112\n\n# Denmark\nFire:112 | Pol:112 | Med:112\n\n# Estonia\nFire:112 | Pol:112 | Med:112\n\n# Finland\nFire:112 | Pol:112 | Med:112\n\n# France\nFire:18 or 112 | Pol:17 or 112 | Med:15 or 112\n\n# Germany\nFire:112 | Pol:110 | Med:112\n\n# Greece\nFire:112 | Pol:112 | Med:112\n\n# Hungary\nFire:112 | Pol:112 | Med:112\n\n# Iceland\nFire:112 | Pol:112 | Med:112\n\n# Ireland\nFire:112 | Pol:112 | Med:112\n\n# Italy\nFire:112 | Pol:112 | Med:112\n\n# Kosovo\nFire:911 | Pol:911 | Med:911\n\n# Latvia\nFire:112 | Pol:112 | Med:112\n\n# Liechtenstein\nFire:112 | Pol:112 | Med:112\n\n# Lithuania\nFire:112 | Pol:112 | Med:112\n\n# Luxembourg\nFire:112 | Pol:112 | Med:112\n\n# Macedonia\nFire:112 | Pol:112 | Med:112\n\n# Malta\nFire:112 | Pol:112 | Med:112\n\n# Moldova\nFire:901 | Pol:902 | Med:903\n\n# Monaco\nFire:112 | Pol:112 | Med:112\n\n# Montenegro\nFire:112 | Pol:112 | Med:112\n\n# Netherlands\nFire:112 | Pol:112 | Med:112\n\n# Norway\nFire:110 | Pol:112 | Med:113\n\n# Poland\nFire:112 | Pol:112 | Med:112\n\n# Portugal\nFire:112 | Pol:112 | Med:112\n\n# RepublicofIreland\nFire:112 | Pol:112 | Med:112\n\n# Romania\nFire:112 | Pol:112 | Med:112\n\n# Russia\nFire:01 | Pol:02 | Med:03\n\n# San Marino\nFire:116 | Pol:112 | Med:113\n\n# Serbia\nFire:112 | Pol:112 | Med:112\n\n# Slovakia\nFire:112 | Pol:112 | Med:112\n\n# Slovenia\nFire:112 | Pol:113 | Med:112\n\n# Spain\nFire:112 | Pol:112 | Med:112\n\n# Sweden\nFire:112 | Pol:112 | Med:112\n\n# Switzerland\nFire:118 or 112 | Pol:117 or 112 | Med:144 or 112\n\n# Turkey\nFire:110 | Pol:155 | Med:112\n\n# Ukraine\nFire:112 | Pol:112 | Med:112\n\n# United Kingdom\nFire:112 | Pol:112 | Med:112\n\n# Vatican City\nFire:115 | Pol:112 | Med:113";
        string stringNorthamerica = "\n# United States of America\nFire:911 | Pol:911 | Med:911\n\n# Antigua and Barbuda\nFire:911 | Pol:911 | Med:911\n\n# Bahamas\nFire:911 | Pol:911 | Med:911\n\n# Barbados\nFire:113 | Pol:112 | Med:115\n\n# Belize\nFire:911 | Pol:911 | Med:911\n\n# Canada\nFire:911 | Pol:911 | Med:911\n\n# Cayman Islands\nFire:911 | Pol:911 | Med:911\n\n# Costa Rica\nFire:911 | Pol:911 | Med:911\n\n# Cuba\nFire:26811 | Pol:26811 | Med:26811\n\n# Dominica\nFire:999 | Pol:999 | Med:999\n\n# Dominican Republic\nFire:911 | Pol:911 | Med:911\n\n# El Salvador\nFire:911 | Pol:911 | Med:911\n\n# Greenland\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Grenada\nFire:911 | Pol:112 | Med:911\n\n# Guatemala\nFire:122 | Pol:110 | Med:123\n\n# Haiti\nFire:local numbers | Pol:114 | Med:118\n\n# Honduras\nFire:198 | Pol:119 | Med:378654\n\n# Jamaica\nFire:110 | Pol:119 | Med:110\n\n# Mexico\nFire:060 | Pol:080 | Med:060\n\n# Nicaragua\nFire:2650162 | Pol:118 | Med:2651761\n\n# Panama\nFire:103 | Pol:104 | Med:2699778\n\n# Saint Kitts and Nevis\nFire:911 | Pol:911 | Med:911\n\n# Saint Lucia\nFire:911 | Pol:999 | Med:911\n\n# Saint Pierre and Miquelon\nFire:18 | Pol:17 | Med:15\n\n# Saint Vincent and Grenadines\nFire:911 | Pol:911 | Med:911\n\n# Trinidad and Tobago\nFire:990 | Pol:999 | Med:990";
        string stringOceania = "\n# Australia\nFire:000 or 112 mobile | Pol:000 or 112 mobile | Med:000 or 112 mobile\n\n# Fiji\nFire:9170 | Pol:911 | Med:911\n\n# Kiribati\nFire:local numbers | Pol:local numbers | Med:994\n\n# Marshall Islands\nFire:local numbers | Pol:6258666 | Med:6254111 \n\n# Micronesia\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# Nauru\nFire:local numbers | Pol:local numbers | Med:local numbers\n\n# New Zealand\nFire:111 | Pol:111 | Med:111\n\n# Palau\nFire:911 | Pol:911 | Med:911\n\n# Papua New Guinea\nFire:110 | Pol:000 | Med:local numbers\n\n# Samoa\nFire:994 | Pol:995 | Med:996\n\n# Solomon Islands\nFire:911 | Pol:911 | Med:911\n\n# Tonga\nFire:999 | Pol:922 | Med:933\n\n# Tuvalu\nFire:911 | Pol:911 | Med:911\n\n# Vanuatu\nFire:112 | Pol:112 | Med:112";
        string stringSouthamerica = "\n# Argentina\nFire:100 | Pol:101 | Med:107\n\n# Bolivia\nFire:911 | Pol:911 | Med:911\n\n# Brazil\nFire:193 | Pol:190 | Med:192\n\n# Chile\nFire:132 | Pol:133 | Med:131\n\n# Colombia\nFire:119 | Pol:119 | Med:119\n\n# Ecuador\nFire:102 | Pol:101 | Med:131\n\n# Guyana\nFire:912 | Pol:911 | Med:913\n\n# Paraguay\nFire:911 | Pol:911 | Med:911\n\n# Peru\nFire:116 | Pol:105 | Med:116\n\n# Suriname\nFire:115 | Pol:115 | Med:115\n\n# Uruguay\nFire:911 | Pol:911 | Med:911\n\n# Venezuela\nFire:171 | Pol:171 | Med:171";


        public Form1() {
            // initialization
            InitializeComponent();
            this.Text = "First Aid 0.1 pre";
            Debug.WriteLine("Device Screen: " + System.Windows.Forms.Screen.PrimaryScreen.Bounds.Width + "x" + System.Windows.Forms.Screen.PrimaryScreen.Bounds.Height + "\nWorking Area: " + System.Windows.Forms.Screen.PrimaryScreen.WorkingArea.Width + "x" + System.Windows.Forms.Screen.PrimaryScreen.WorkingArea.Height);

            // new Sizes of Screen
            sz.Width = System.Windows.Forms.Screen.PrimaryScreen.WorkingArea.Width; // this.ClientSize.Width;
            sz.Height = System.Windows.Forms.Screen.PrimaryScreen.WorkingArea.Height; //  this.ClientSize.Height;
            this.Size = sz;
            Debug.WriteLine("Form Size: " + this.Size.Width + "x" + this.Size.Height);

            // autoscroll for form
            this.AutoScroll = false;

            // prepare picture box
            picBoxes = new PictureBox[] { picBox0, picBox1, picBox2, picBox3, picBox4, picBox5, picBox6, picBox7 };

            // create my list view (menu list)
            CreateMyListView();

            // create emergency list menu
            CreateEmergencyMenu();

            // assign event handler to form (menu)
            this.KeyPress += new KeyPressEventHandler(keyWasPressed);

            // panel autoscroll reacts on key pressed
            detailsPanel.KeyDown += new KeyEventHandler(scrollNow);

            // scroll for emergency numbers countries
            telCountriesPanel.KeyDown += new KeyEventHandler(scrollNow2);

            // hide text panels at start up
            detailsPanel.Visible = false;
            detailsPanel.Enabled = false;
            telCountriesPanel.Visible = false;
            telCountriesPanel.Enabled = false;

            // hide telEmergency panel at start up
            telEmergenciesPanel.Visible = false;
            telEmergenciesPanel.Enabled = false;

            // text in array is showing up when menu item is chosen
            stringItemArray = new string[] { aid_disclaimer, separator, aid_general, aid_allergic, aid_amputation, aid_animalbite, aid_apnoea, aid_asthma, aid_backinjury, aid_birth, aid_bleedinglight, aid_bleedingsevere, aid_brainconcussion, aid_apnoea, aid_asthma, aid_burningslight, aid_burningsevere, aid_checkbreathing, aid_chemicalburneyes, aid_chemicalburn, aid_resuscitation, aid_dangerzone, aid_diabeticcoma, aid_diarrhoea, aid_drowning, aid_electricityaccident, aid_emergencycall, aid_epilepsy, aid_eyeinjury, aid_fracture, aid_frostbitemild, aid_frostbitesevere, aid_heartattack, aid_diabeticcoma, aid_hypoglycaemia, aid_hyperthermia, aid_hypothermia, aid_icerescue, aid_insectstings, aid_nosebleeding, aid_poisining, aid_resuscitation, aid_recoveryposition, aid_resuscitation, aid_safeguardaccident, aid_shock, aid_skullfracture, aid_snakebite, aid_sos, aid_backinjury, aid_sprain, aid_stroke, aid_suffocation, aid_sunburn, aid_sunstroke, aid_suffocation, aid_safeguardaccident, aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_vomiting, separator, aid_donate };
            stringTelItemArray = new string[] { stringAfrica, stringAsia, stringEurope, stringNorthamerica, stringOceania, stringSouthamerica };
            
            // create 2nd form to hold First Aid Infos
            initiateDetailPanel();
            initiatetelCountriesPanel();

            // finish
            Debug.WriteLine("initialization done");
        }

        // scroll values
        int scrollbarVertWidth = 10;
        int scrollDistance = 32;

        // event handler for detailsPanel
        public void scrollNow(object sender, KeyEventArgs e) {
            /// Debug.WriteLine("KEY CODE: " + e.KeyCode + " / Panel-Pos-Y: "+this.AutoScrollPosition.Y);
            if ((e.KeyCode == Keys.Down) ) { 
                detailsPanel.AutoScrollPosition = new Point(0, -detailsPanel.AutoScrollPosition.Y + scrollDistance);
            }
            else if ((e.KeyCode == Keys.Up) ) { 
                detailsPanel.AutoScrollPosition = new Point(0, -detailsPanel.AutoScrollPosition.Y - scrollDistance);
            }
        }

        // event handler for telEmergenciey countries
        public void scrollNow2(object sender, KeyEventArgs e) {
            /// Debug.WriteLine("KEY CODE II: " + e.KeyCode + " / Panel-Pos-Y: " + this.AutoScrollPosition.Y);
            if ((e.KeyCode == Keys.Down)) {
                telCountriesPanel.AutoScrollPosition = new Point(0, -telCountriesPanel.AutoScrollPosition.Y + scrollDistance);
            }
            else if ((e.KeyCode == Keys.Up)) {
                telCountriesPanel.AutoScrollPosition = new Point(0, -telCountriesPanel.AutoScrollPosition.Y - scrollDistance);
            }
        }

        private void initiatetelCountriesPanel() {
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
            detailsPanel.Size = new Size(sz.Width, sz.Height);
            detailsPanel.Location = new Point(0, 0);
            detailsPanel.AutoScroll = true;
            detailsText.Location = new Point(0, 0);
            detailsText.Size = new Size(sz.Width - scrollbarVertWidth, sz.Height);

            // add label detailsPanel to panel
            detailsPanel.Controls.Add(detailsText);

            // add panel itself to Form
            this.Controls.Add(detailsPanel);
        }

        private void CreateEmergencyMenu() {
            telEmergency.Size = new Size(sz.Width, sz.Height);
            telEmergency.View = View.List;

            telEmergency.Name = "Choose Continent";
		    telEmergency.Items.Add(itemAfrica = new ListViewItem("Africa"));
            telEmergency.Items.Add(itemAsia = new ListViewItem("Asia"));
            telEmergency.Items.Add(itemEurope = new ListViewItem("Europe"));
            telEmergency.Items.Add(itemNorthamerica = new ListViewItem("North-/Central America"));
            telEmergency.Items.Add(itemOceania = new ListViewItem("Oceania"));
            telEmergency.Items.Add(itemSouthamerica = new ListViewItem("South America"));

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
        }

        private void CreateMyListView() {
            // Set the view to a list style
            ourMenu.View = View.Details; // List
            ColumnHeader chead = new ColumnHeader();
            chead.Text = "First Aid 0.1 pre";
            ourMenu.Columns.Add(chead);

            // resize to 320x240
            ourMenu.Size = new Size(sz.Width, sz.Height - 20);
            ourMenu.Dock = DockStyle.Fill; 

            // necessary for scrollbar 
            ourMenu.Anchor = AnchorStyles.Left;
            ourMenu.Anchor = AnchorStyles.Right;
            ourMenu.Anchor = AnchorStyles.Top;

            // Create menu items
            ourMenu.Items.Add(item00 = new ListViewItem("# Disclaimer + Info"));
            ourMenu.Items.Add(item01 = new ListViewItem("# Emergency Calls"));
            ourMenu.Items.Add(item02 = new ListViewItem("# General Conduct"));
            ourMenu.Items.Add(item03 = new ListViewItem("Allergic Reaction"));
            ourMenu.Items.Add(item04 = new ListViewItem("Amputation"));
            ourMenu.Items.Add(item05 = new ListViewItem("Animal bite"));
            ourMenu.Items.Add(item06 = new ListViewItem("Apnoea"));
            ourMenu.Items.Add(item07 = new ListViewItem("Asthma"));
            ourMenu.Items.Add(item08 = new ListViewItem("Back Injury"));
            ourMenu.Items.Add(item09 = new ListViewItem("Birth"));
            ourMenu.Items.Add(item10 = new ListViewItem("Bleeding (light)"));
            ourMenu.Items.Add(item11 = new ListViewItem("Bleeding (severe)"));
            ourMenu.Items.Add(item12 = new ListViewItem("Brain Concussion"));
            ourMenu.Items.Add(item13 = new ListViewItem("Breathing"));
            ourMenu.Items.Add(item14 = new ListViewItem("Breathlessness"));
            ourMenu.Items.Add(item15 = new ListViewItem("Burning (slight)"));
            ourMenu.Items.Add(item16 = new ListViewItem("Burning (severe)"));
            ourMenu.Items.Add(item17 = new ListViewItem("Check Breathing"));
            ourMenu.Items.Add(item18 = new ListViewItem("Chemical Burn (Eyes)"));
            ourMenu.Items.Add(item19 = new ListViewItem("Chemical Burn"));
            ourMenu.Items.Add(item20 = new ListViewItem("Chest Compression"));
            ourMenu.Items.Add(item21 = new ListViewItem("Danger Zone (Rescue)"));
            ourMenu.Items.Add(item22 = new ListViewItem("Diabetic Coma"));
            ourMenu.Items.Add(item23 = new ListViewItem("Diarrhoea"));
            ourMenu.Items.Add(item24 = new ListViewItem("Drowning"));
            ourMenu.Items.Add(item25 = new ListViewItem("Electricity Accident"));
            ourMenu.Items.Add(item26 = new ListViewItem("Emergency Call"));
            ourMenu.Items.Add(item27 = new ListViewItem("Epilepsy"));
            ourMenu.Items.Add(item28 = new ListViewItem("Eye Injury"));
            ourMenu.Items.Add(item29 = new ListViewItem("Fracture"));
            ourMenu.Items.Add(item30 = new ListViewItem("Frostbite (mild)"));
            ourMenu.Items.Add(item31 = new ListViewItem("Frostbite (severe)"));
            ourMenu.Items.Add(item32 = new ListViewItem("Heart Attack"));
            ourMenu.Items.Add(item33 = new ListViewItem("Hyperglycaemia (sugar)"));
            ourMenu.Items.Add(item34 = new ListViewItem("Hypoglycaemia (low sugar)"));
            ourMenu.Items.Add(item35 = new ListViewItem("Hyperthermia (hot body)"));
            ourMenu.Items.Add(item36 = new ListViewItem("Hypothermia (cool body)"));
            ourMenu.Items.Add(item37 = new ListViewItem("Ice Rescue"));
            ourMenu.Items.Add(item38 = new ListViewItem("Insect stings"));
            ourMenu.Items.Add(item39 = new ListViewItem("Nosebleeding"));
            ourMenu.Items.Add(item40 = new ListViewItem("Poisoning"));
            ourMenu.Items.Add(item41 = new ListViewItem("Reanimation"));
            ourMenu.Items.Add(item42 = new ListViewItem("Recovery Position"));
            ourMenu.Items.Add(item43 = new ListViewItem("Resuscitation"));
            ourMenu.Items.Add(item44 = new ListViewItem("Safeguard Accident"));
            ourMenu.Items.Add(item45 = new ListViewItem("Shock"));
            ourMenu.Items.Add(item46 = new ListViewItem("Skull fracture"));
            ourMenu.Items.Add(item47 = new ListViewItem("Snakebite"));
            ourMenu.Items.Add(item48 = new ListViewItem("SOS"));
            ourMenu.Items.Add(item49 = new ListViewItem("Spinal fracture"));
            ourMenu.Items.Add(item50 = new ListViewItem("Sprain + Strain"));
            ourMenu.Items.Add(item51 = new ListViewItem("Stroke"));
            ourMenu.Items.Add(item52 = new ListViewItem("Suffocation (Choking)"));
            ourMenu.Items.Add(item53 = new ListViewItem("Sunburn"));
            ourMenu.Items.Add(item54 = new ListViewItem("Sunstroke"));
            ourMenu.Items.Add(item55 = new ListViewItem("Swallow/Choking"));
            ourMenu.Items.Add(item56 = new ListViewItem("Traffic Accident"));
            ourMenu.Items.Add(item57 = new ListViewItem("Unconsciousness with breathing"));
            ourMenu.Items.Add(item58 = new ListViewItem("Unconsciousness without breathing"));
            ourMenu.Items.Add(item59 = new ListViewItem("Vomiting"));
            ourMenu.Items.Add(item60 = new ListViewItem("-------------"));
            ourMenu.Items.Add(item61 = new ListViewItem("#Call Emergency 112"));

            // setup menuPanel
            menuPanel.Location = new Point(0, 0);
            menuPanel.Size = sz;
            menuPanel.Anchor = AnchorStyles.Left;
            menuPanel.Anchor = AnchorStyles.Right;
            menuPanel.Anchor = AnchorStyles.Top;
            menuPanel.AutoScroll = true;

            // set anchor point
            ourMenu.Anchor = AnchorStyles.Left;

            // add the menu panel to the form
            this.Controls.Add(menuPanel);

            // add the ListView to the control collection
            menuPanel.Controls.Add(ourMenu);
        }

        private void showEmergenciesList() {
            menuPanel.Visible = false;
            menuPanel.Enabled = false;
            telEmergenciesPanel.Visible = true;
            telEmergenciesPanel.Enabled = true;
            menuExit.Text = "Back";
            menuExit.Enabled = true;
            // focus
            telEmergenciesPanel.Focus();
            telEmergShown = true;
            telCountriesShown = false;
            // reposition scrolled telCountriesPanel
            telCountriesPanel.AutoScrollPosition = new Point(0, 0);
        }


        private void menuExit_Click_1(object sender, EventArgs e) {
            // if user is NOT within telEmergency and Exit Button is Exit Button (by label)
            if ((telEmergShown == false) && (telCountriesShown == false) && (menuExit.Text == "Exit")) {
                // Debug.WriteLine("exit");
                Application.Exit();
            }
            else {
                if (menuExit.Text == "Proceed") {
                    pressedProceed = true;
                    // Debug.WriteLine("Show further measures");
                }
                else {
                    Debug.WriteLine("Back to Menu");
                }
                telEmergShown = false;
                telCountriesShown = false;
                swapToDetails(null, null);
            }
        }

        bool detailsShown = false;
        bool telEmergShown = false;
        bool telCountriesShown = false;
        bool pressedProceed = false;

        // click on select
        private void menuSelect_Click_1(object sender, EventArgs e) {
            pressedProceed = false;
            // Debug.WriteLine("Back pressed");
            // Debug.WriteLine("::" + detailsShown);
            swapToDetails(e, null);
        }

        // event handler
        public void keyWasPressed(object sender, KeyPressEventArgs f) {
            swapToDetails(null, f);
        }
        
        int recentItem;

        private void swapToDetails(EventArgs e, KeyPressEventArgs f) {
            // number 0...9 has been pressed
            if ((f != null) && (f.KeyChar <= 9) && (f.KeyChar >= 0)) {
                // do nothing
                // Debug.WriteLine("pressed: " + (char)f.KeyChar);
            }
            // something else has been pressed
            else {
                // catch menu item chosen
                recentItem = ourMenu.SelectedIndices[0];

                // if details of telCountries is visible now
                if (telCountriesShown == true) {
                    // back to telCountry list
                    showEmergenciesList();
                    menuSelect.Text = "Select";
                }
                // prevent no value of menu
                else if (this.ourMenu.SelectedIndices.Count <= 0) {
                    return;
                }
                else if (telEmergShown == true) {
                    // prevent no value of menu
                    if (this.telEmergency.SelectedIndices.Count <= 0) {
                        return;
                    }
                    else {
                        // show em number of chosen country
                        telCountryText.Text = stringTelItemArray[telEmergency.SelectedIndices[0]];
                        // resize
                        telCountryText.Height = CFMeasureString.MeasureString(CreateGraphics(), telCountryText.Text, telCountryText.ClientRectangle, false).Height + 20;
                        telEmergenciesPanel.Visible = false;
                        telEmergenciesPanel.Enabled = false;
                        telCountriesPanel.Visible = true;
                        telCountriesPanel.Enabled = true;
                        telEmergShown = false;

                        // details of telCountries are shown now
                        telCountriesShown = true;
                        menuExit.Text = "";
                        menuExit.Enabled = false;
                        menuSelect.Text = "Back";

                        // set focus to telCountrieList for scrolling
                        telCountriesPanel.Focus();
                    }
                }

                // telEmergency has been chosen
                else if ((detailsShown == false) && (recentItem == 1)) {
                    showEmergenciesList();
                }

                // user clicked on separator -----
                else if ((detailsShown == false) && (recentItem == 60)) {
                    // do nothing 
                }
                // user has clicked for further descriptions
                else if ((menuExit.Text == "Proceed") && (pressedProceed == true)) {
                    // assign resuscitation
                    recentItem = 20; 
                    disposeImages();
                    assignTextAndImages();
                    detailsShown = false;
                }
                // another menu item has been chosen, show detail description page
                else if (detailsShown == false) {
                    // Debug.WriteLine("User has pressed item:" + recentItem); //+ ": " +ourMenu.Items[recentItem].Text);
                    menuPanel.Visible = false;
                    menuPanel.Enabled = false;
                    telEmergenciesPanel.Visible = false;
                    telEmergenciesPanel.Enabled = false;
                    detailsPanel.Visible = true;
                    detailsPanel.Enabled = true;
                    assignTextAndImages();
                }
                // go back to main menu
                else {
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

        PictureBox[] picBoxes;
        int picCount = 0;

        Assembly _assembly;
        Stream _imageStream;

        private void disposeImages() {
            // Debug.WriteLine("Nr of Pics: " + (picCount-1) );
            // remove picBoxes from DetailsPanel + delete/clear all images from memory
            for (int i = 0; i < picCount; i++) {
                detailsPanel.Controls.Remove(picBoxes[i]);
                picBoxes[i].Image.Dispose(); 
            }
            picCount = 0;
        }

        private void assignTextAndImages() {

            // assign first aid text
            detailsText.Text = stringItemArray[recentItem];

            // change menu commands
            menuSelect.Text = "Back";
            menuExit.Text = ""; // clear
            menuExit.Enabled = false;
            // focus 
            detailsPanel.Focus();

            // RESIZE LABEL, see http://www.mobilepractices.com/2007/12/multi-line-graphicsmeasurestring.html
            detailsText.Height = CFMeasureString.MeasureString(CreateGraphics(), detailsText.Text, detailsText.ClientRectangle, false).Height + 20;

            // img:CC_license
            if (recentItem == 0) { 
                LoadOurImages("FirstAid3.Resources.cc88x31.png"); 
            }
            // img:apnoea
            else if (recentItem == 6 || recentItem == 13) {
                LoadOurImages("FirstAid3.Resources.aid067.png");
                LoadOurImages("FirstAid3.Resources.aid010.png");
                LoadOurImages("FirstAid3.Resources.aid011.png");
            }
            // img:backinjury
            else if (recentItem == 8 || recentItem == 49) { 
                LoadOurImages("FirstAid3.Resources.aid065.png"); 
            }
            // img:birth
            else if (recentItem == 9) {
                LoadOurImages("FirstAid3.Resources.aid025.png");
                LoadOurImages("FirstAid3.Resources.aid022.png");
                LoadOurImages("FirstAid3.Resources.aid023.png");
            }
            // img:chemicalburneyes
            else if (recentItem == 18) { 
                LoadOurImages("FirstAid3.Resources.aid019.png"); 
            }
            // img:bleedinglight
            else if (recentItem == 10) {
                LoadOurImages("FirstAid3.Resources.aid084.png");
                LoadOurImages("FirstAid3.Resources.aid085.png");
            }
            // img:bleedingsevere
            else if (recentItem == 11) {
                LoadOurImages("FirstAid3.Resources.aid084.png");
                LoadOurImages("FirstAid3.Resources.aid085.png");
                LoadOurImages("FirstAid3.Resources.aid089.png");
                LoadOurImages("FirstAid3.Resources.aid092.png");
            }
            // img:brainconcussion
            else if (recentItem == 12) { 
                LoadOurImages("FirstAid3.Resources.aid061.png"); 
            }
            // img:dangerzone
            else if (recentItem == 21) { 
                LoadOurImages("FirstAid3.Resources.aid001.png"); 
            }
            // img:drowning
            else if (recentItem == 24) { 
                LoadOurImages("FirstAid3.Resources.aid034.png"); 
            }
            // img:electricityaccident
            else if (recentItem == 25) { 
                LoadOurImages("FirstAid3.Resources.aid045plug.png"); 
            }
            // img:epilepsy
            else if (recentItem == 27) { 
                LoadOurImages("FirstAid3.Resources.aid058.png"); 
            }
            // img:fracture
            else if (recentItem == 29) { 
                LoadOurImages("FirstAid3.Resources.aid107.png"); 
            }
            // img:heartattack
            else if (recentItem == 32) {
                LoadOurImages("FirstAid3.Resources.aid061.png"); 
            }
            // img:icerescue
            else if (recentItem == 37) { 
                LoadOurImages("FirstAid3.Resources.aid041.png"); 
            }
            // img:recoveryposition
            else if (recentItem == 42) {
                LoadOurImages("FirstAid3.Resources.aid008.png");
                LoadOurImages("FirstAid3.Resources.aid009.png");
                LoadOurImages("FirstAid3.Resources.aid028.png");
            }
            // img:resuscitation
            else if (recentItem == 20 || recentItem == 41 || recentItem == 43) {
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
            else if (recentItem == 44 || recentItem == 56) { 
                LoadOurImages("FirstAid3.Resources.aid001.png"); 
            }
            // img:suffocation
            else if (recentItem == 52 || recentItem == 55) {
                LoadOurImages("FirstAid3.Resources.aid031.png");
                LoadOurImages("FirstAid3.Resources.aid069.png");
            }
            // img:sunstroke
            else if (recentItem == 54) { 
                LoadOurImages("FirstAid3.Resources.aid061.png"); 
            }
            // img: unconsciouswithbreath
            else if (recentItem == 57) {
                LoadOurImages("FirstAid3.Resources.aid008.png");
                LoadOurImages("FirstAid3.Resources.aid009.png");
            }

            // append Proceed Button for resuscitation - unconsciouswithoutbreath / drowning / heartattack / brainconcussion / stroke / shock / poisining / electricity / hypothermia
            if (recentItem == 58 || recentItem == 24 || recentItem == 32 || recentItem == 12 || recentItem == 51 || recentItem == 45 || recentItem == 40 || recentItem == 25 || recentItem == 36) {
                menuExit.Text = "Proceed";
                menuExit.Enabled = true;
            }
            // for sunstroke / asthma / hypoglycaemia
            else if (recentItem == 54 || recentItem == 7 || recentItem == 34) {
                LoadOurImages("FirstAid3.Resources.aid010.png");
                LoadOurImages("FirstAid3.Resources.aid011.png");
            }

        }

        private void LoadOurImages(String imageName) {
            try {
                // Debug.WriteLine("TRY TO GET IMAGE stream");
                _assembly = Assembly.GetExecutingAssembly();
                _imageStream = _assembly.GetManifestResourceStream(imageName);
                // Debug.WriteLine(_imageStream);
            }
            catch (IOException e) {
                Debug.WriteLine("COULD NOT LOAD IMAGE RESOURCE!" + e);
            }
            try {
                // create image
                picBoxes[picCount].Image = new Bitmap(_imageStream);
                // size of picture box 
                picBoxes[picCount].Size = new System.Drawing.Size(sz.Width - scrollbarVertWidth, picBoxes[picCount].Image.Size.Height + 40); // +20 Offset below as spacer 
                // center image in screen
                picBoxes[picCount].SizeMode = PictureBoxSizeMode.CenterImage;
                // ...
                if (picCount == 0) {
                    picBoxes[picCount].Location = new System.Drawing.Point(0, detailsText.Height);
                }
                // all following pics orientate their position on the first one set
                else {
                    picBoxes[picCount].Location = new System.Drawing.Point(0, picBoxes[picCount - 1].Location.Y + picBoxes[picCount - 1].Height + 10); // +10 is offset
                }
                // add picBoxes to detailsPanel
                detailsPanel.Controls.Add(picBoxes[picCount]);
            }
            catch {
                MessageBox.Show("Error creating image!");
            }
            picCount++;
        }

        private void Form1_Load(object sender, EventArgs e) {
            // nothing here
        }

    }
}

