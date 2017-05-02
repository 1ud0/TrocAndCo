window.onload = function() {
	var form = document.formInscription;
	form.addEventListener("submit", function(e) {
		//e.preventDefault();
		var geocoder = new google.maps.Geocoder();
		//recupération de l'adresse depuis les 3 imput text
	    var address = form.elements.adresse.value + ", " + form.elements.code_postal.value + ", " + form.elements.ville.value;
	    console.log(address);
	    //geocoding
	    geocoder.geocode({'address': address}, function(results, status) {
	        if (status === google.maps.GeocoderStatus.OK) {
	            var maLocalisation = results[0].geometry.location;
	            form.elements.latitude.value = results[0].geometry.location.lat();
	            form.elements.longitude.value = results[0].geometry.location.lng();
	        } else {
	            alert('Geocode was not successful for the following reason: ' + status);
	        }
	    });
		console.log("coucou");
	});
}