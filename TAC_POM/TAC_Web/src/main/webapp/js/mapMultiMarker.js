 var locations = [
        ['Bondi Beach', -33.890542, 151.274856, 4],
        ['Coogee Beach', -33.923036, 151.259052, 5],
        ['Cronulla Beach', -34.028249, 151.157507, 3],
        ['Manly Beach', -33.80010128657071, 151.28747820854187, 2],
        ['Maroubra Beach', -33.950198, 151.259302, 1]
    ];


    // When the user clicks the marker, an info window opens.

    function initMap() {
        var myLatLng = {lat: -33.90, lng: 151.16};

        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 10,
            center: myLatLng
            });

        var count=0;


        for (count = 0; count < locations.length; count++) {  

            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(locations[count][1], locations[count][2]),
                map: map
                });

            marker.info = new google.maps.InfoWindow({
                content: locations [count][0]
                });


            google.maps.event.addListener(marker, 'click', function() {  
                // this = marker
                var marker_map = this.getMap();
                this.info.open(marker_map, this);
                // Note: If you call open() without passing a marker, the InfoWindow will use the position specified upon construction through the InfoWindowOptions object literal.
                });
        }
    }