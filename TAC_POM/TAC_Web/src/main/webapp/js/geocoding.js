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
	            alert('Geocode was not successful for the following reason: ' + status);
	        }
	    });
	}
}