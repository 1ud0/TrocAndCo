var mylat=[];
var mylng=[];
var valLat1;
var valLng1;

var infowindow;

function init_map() {
	var bounds = new google.maps.LatLngBounds();
	mylat = document.getElementsByClassName("tdLat");
	mylng = document.getElementsByClassName("tdLng");
var val= mylat[0].innerHTML;
var val2= mylng[0].innerHTML;
	var myOptions = {
		zoom : 9,
		center : new google.maps.LatLng(val, val2),
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	
	map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);
	
	for (var i = 0; i < mylat.length; i++) {
		var valLat= mylat[i].innerHTML;
		var valLng= mylng[i].innerHTML;
		marker = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(valLat, valLng)
		});
	}
	
	

	 var contentString="Adresse principale";
	 infowindow = new google.maps.InfoWindow({
	    content: contentString
	  });


	marker.addListener(marker, 'click', function() {
		infowindow.open(map, marker);
	});

	infowindow.open(map, marker);

}

// google.maps.event.addDomListener(window, 'load', init_map);

window.onload = init_map;