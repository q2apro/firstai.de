var search = window.location.search == "?1" ? "?2" : "?1";
var imageURLs = {};

function showMainMenu() {
	if (document.getElementById("imgholder")) {
		document.body.innerHTML="<h1></h1><div id=\"imgholder\" style=\"display:none\">" + document.getElementById("imgholder").innerHTML + "</div><ul></ul>";
	} else {
		document.body.innerHTML="<h1></h1><ul></ul>";
	}
	document.body.firstChild.appendChild(document.createTextNode(langTexts.title));
	for(var i=0; i<langMenu.length; i++) {
		var liElem = document.createElement("li");
		var aElem = document.createElement("a");
		var href = langMenu[i].h;
		if (href.charAt(0) == "#")
			href = search + href;
		aElem.setAttribute("href", href);
		aElem.appendChild(document.createTextNode(langMenu[i].t));
		liElem.appendChild(aElem);
		document.body.lastChild.appendChild(liElem);
	}
}

function createImage(id) {
	var img = document.createElement("img");
	if(imageURLs[id])
		img.src=imageURLs[id];
	else
		img.src="img/"+id+".png";
	return img;
}

function showSection(id) {
	document.body.innerHTML="<a href='"+search+"'></a><h1></h1><div></div>";
	document.body.firstChild.appendChild(document.createTextNode(langTexts.back));
	var stepOpen = false;
	var currentLI = null;
	for(var i=0; i<langSections[id].length; i++) {
		var elem = langSections[id][i];
		if (elem.k == "title") {
			document.body.firstChild.nextSibling.appendChild(document.createTextNode(elem.t));
			if (elem.i) {
				document.body.lastChild.appendChild(createImage(elem.i));
			}
		} else if (elem.k == "description") {
			currentLI = null;
			var p = document.createElement("p");
			p.appendChild(document.createTextNode(elem.t));
			document.body.lastChild.appendChild(p);
		} else if (elem.k == "subsection") {
			currentLI = null;
			var p = document.createElement("p");
			var b = document.createElement("b");
			p.appendChild(b);
			b.appendChild(document.createTextNode(elem.t));
			document.body.lastChild.appendChild(p);
		} else if (elem.k == "image") {
			(currentLI || document.body.lastChild).appendChild(createImage(elem.i));
		} else if (elem.k == "step") {
			var li = document.createElement("li");
			if (currentLI != null) {
				currentLI.parentNode.appendChild(li);
			} else {
				var ol = document.createElement("ol");
				ol.appendChild(li);
				document.body.lastChild.appendChild(ol);
			}
			currentLI = li;
			for(var j=0; j<elem.p.length; j++) {
				if (elem.p[j].h) {
					var a = document.createElement("a");
					a.href=search+elem.p[j].h;
					a.appendChild(document.createTextNode(elem.p[j].t));
					currentLI.appendChild(a);
				} else {
					currentLI.appendChild(document.createTextNode(elem.p[j].t));
				}
			}
		}
	}
}

function showEmergencyMenu() {
	document.body.innerHTML="<a href='"+search+"'></a><h1></h1><ul></ul>";
	document.body.firstChild.appendChild(document.createTextNode(langTexts.back));
	document.body.firstChild.nextSibling.appendChild(document.createTextNode(langTexts.continent));
	for (var i=0; i<langContinents.length; i++) {
		var liElem = document.createElement("li");
		var aElem = document.createElement("a");
		aElem.setAttribute("href", search+"#num_"+langContinents[i].i);
		aElem.appendChild(document.createTextNode(langContinents[i].t));
		liElem.appendChild(aElem);
		document.body.lastChild.appendChild(liElem);
	}
	document.body.appendChild(createImage("aid002"));
}

function showEmergencyContinent(continent) {
	document.body.innerHTML="<a href='"+search+"#numbers'></a><h1></h1><div></div>";
	document.body.firstChild.appendChild(document.createTextNode(langTexts.back));
	for (var i=0; i<langContinents.length; i++) {
		if (langContinents[i].i == continent) {
			document.body.firstChild.nextSibling.appendChild(document.createTextNode(langContinents[i].t));
		}
	}
	var includedCountries = {};
	for(var i=0; i<sosContinents[continent].length; i++) {
		includedCountries[sosContinents[continent][i]] = true;
	}
	for(var i=0; i<langCountries.length; i++) {
		if (includedCountries[langCountries[i].i]) {
			var nums = sosNumbers[langCountries[i].i];
			var h2 = document.createElement("h2");
			h2.appendChild(document.createTextNode(langCountries[i].t));
			document.body.lastChild.appendChild(h2);
			document.body.lastChild.appendChild(formatNumber(langTexts.emergency_fire,nums["fire"]));
			document.body.lastChild.appendChild(formatNumber(langTexts.emergency_medical,nums["medical"]));
			document.body.lastChild.appendChild(formatNumber(langTexts.emergency_police,nums["police"]));
			if (langTexts.emergency_cancelcard != "" && nums["cancelcard"])
				document.body.lastChild.appendChild(formatNumber(langTexts.emergency_cancelcard,nums["cancelcard"]));
		}
	}
}

function formatNumber(label, number) {
	var p = document.createElement("p");
	p.appendChild(document.createTextNode(label+": "));
	if (number == "none")
		p.appendChild(document.createTextNode("(--)"));
	else if (number == "local" || number == "nosystem" || number == "radioonly")
		p.appendChild(document.createTextNode("("+langTexts["emergency_"+number]+")"));
	else if (/^[0-9]+$/.test(number)) {
		var a = document.createElement("a");
		a.href = "tel:"+number;
		a.appendChild(document.createTextNode("("+number+")"));
		p.appendChild(a);
	} else if (/^[0-9]+:(mobile|tourist|):[0-9]+$/.test(number)) {
		var parts = number.split(":");
		var suffix = "";
		if (parts[1] != "")
			suffix = " " + langTexts["emergency_" + parts[1]];
		var a = document.createElement("a");
		a.href = "tel:"+parts[0];
		a.appendChild(document.createTextNode("("+parts[0]+")"));
		p.appendChild(a);
		p.appendChild(document.createTextNode(" "+langTexts.emergency_or+" "));
		a = document.createElement("a");
		a.href="tel:"+parts[2];
		a.appendChild(document.createTextNode("("+parts[2]+suffix+")"));
		p.appendChild(a);
	}
	return p;
}

window.onload = function() {
	var imgs = document.getElementsByTagName("img");
	for(var i=0; i<imgs.length; i++) {
		if (imgs[i].id.substring(0,4) == "img-") {
			imageURLs[imgs[i].id.substring(4)] = imgs[i].src;
		}
	}
	if (location.hash == "")
		showMainMenu();
	else if (location.hash == "#numbers")
		showEmergencyMenu();
	else if (location.hash.substring(0,5) == "#aid_")
		showSection(location.hash.substring(1));
	else if (location.hash.substring(0,5) == "#num_")
		showEmergencyContinent(location.hash.substring(5));
};
