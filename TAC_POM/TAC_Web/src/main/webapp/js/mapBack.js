var mylat=[];
var mylng=[];
var myPseudo=[];
var valLat1;
var valLng1;
var infowindow = null;
var contentString;
var markers=[];
var img=[];
var iconBase = '../';

function init_map() {
	
	mylat = document.getElementsByClassName("tdLat");
	mylng = document.getElementsByClassName("tdLng");
	myPseudo = document.getElementsByClassName("tdNomMembre");
	img = document.getElementsByClassName("avatar");
var val= mylat[0].innerHTML;
var val2= mylng[0].innerHTML;
	var myOptions = {
		zoom : 11,
		center : new google.maps.LatLng(val, val2),
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	
	map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);
	
	infowindow = new google.maps.InfoWindow({
	   content: contentString
	 })
	
	for (var i = 0; i < mylat.length; i++) {
		var marker = markers[i];
		var valLat= mylat[i].innerHTML;
		var valLng= mylng[i].innerHTML;
		
		
		var iconReSize ={
				url :iconBase + img[i].innerHTML,
				scaledSize : new google.maps.Size(50,50),
				origin: new google.maps.Point(0,0),
				anchor : new google.maps.Point(0,0)
		}

		contentString =
			
			'<div id="content">'+
			myPseudo[i].innerHTML + ' '+ 
			'<div>'
			;
		
		
		
		
		
		marker = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(valLat, valLng),
			title : myPseudo[i].innerHTML,
			html : contentString,
			icon: iconReSize

		});

		google.maps.event.addListener(marker, 'click', function() {
			infowindow.setContent(this.html);
			infowindow.open(map, this);
		});
	}

}



window.onload = init_map;