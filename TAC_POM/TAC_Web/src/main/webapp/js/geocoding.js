window.onload = function() {
	var btnVisible = document.getElementById("btnVisible");
	var btnCache = document.getElementById("formInscription:btn");
	btnVisible.onclick = function() {
		var geocoder = new google.maps.Geocoder();
		var chpLatitude = document.getElementById("formInscription:latitude");
		var chpLongitude = document.getElementById("formInscription:longitude");
		var chpAdresse = document.getElementById("formInscription:adresse");
		var chpCodePostal = document.getElementById("formInscription:code_postal");
		var chpVille = document.getElementById("formInscription:ville");
		//recupération de l'adresse depuis les 3 imput text
	    var address = chpAdresse.value + ", " + chpCodePostal.value + ", " + chpVille.value;
	    //geocoding
	    geocoder.geocode({'address': address}, function(results, status) {
	        if (status === google.maps.GeocoderStatus.OK) {
	            var maLocalisation = results[0].geometry.location;
	            chpLatitude.value = results[0].geometry.location.lat();
	            chpLongitude.value = results[0].geometry.location.lng();
	            btnCache.click();
	        } else {
	            console.log('Geocode was not successful for the following reason: ' + status);
	        }
	    });
	}
	document.getElementById("btnDemo").onclick = function() {
		document.getElementById("formInscription:prenom").value = "Chuck";
		document.getElementById("formInscription:nom").value = "Norris";
		document.getElementById("formInscription:date_naissance").value = "01/01/1950";
		document.getElementById("formInscription:mail").value = "jemetlespieds@oujeveux.pow";
		document.getElementById("formInscription:adresse").value = "Rue de l'annexion";
		document.getElementById("formInscription:code_postal").value = "74000";
		document.getElementById("formInscription:ville").value = "Annecy";
		document.getElementById("formInscription:pseudo").value = "Chucky la Praline";
		document.getElementById("formInscription:password").value = "pass";
		document.getElementById("formInscription:confirmPassword").value = "pass";
	}
}

