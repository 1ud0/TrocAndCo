$(function() {


	
	// -------------
	// - PIE CHART -
	// -------------
	// Get context with jQuery - using jQuery's .get() method.

	var nomCat = [];
	var longCat = [];
	nomCat = document.getElementsByClassName("intituleCat");
	
	longCat = document.getElementsByClassName("longGraph");

	var couleur = [ "#f56954", "#00a65a", "#f39c12", "#B0C4DE", "#7CFC00",
			"#FFD700", "#D19275", "#00a65a", "#006400", "#BDB76B", "#8B0000",
			"#ADD8E6", "#6B8E23", "#EEE8AA", "#F0FFFF", "#5F9EA0", "#3c8dbc",
			"#d2d6de" ];

	var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
	var pieChart = new Chart(pieChartCanvas);
	var test =[];
	var PieData = [];
	for (var i = 0; i < nomCat.length; i++) {
		 test = {
			value : longCat[i].innerHTML,
			color : couleur[i],
			highlight : "#DCDCDC",
			label : nomCat[i].innerHTML

		};
		 PieData.push(test);
	}
	
	var pieOptions = {
		// Boolean - Whether we should show a stroke on each segment
		segmentShowStroke : true,
		// String - The colour of each segment stroke
		segmentStrokeColor : "#fff",
		// Number - The width of each segment stroke
		segmentStrokeWidth : 2,
		// Number - The percentage of the chart that we cut out of the middle
		percentageInnerCutout : 50, // This is 0 for Pie charts
		// Number - Amount of animation steps
		animationSteps : 100,
		// String - Animation easing effect
		animationEasing : "easeOutBounce",
		// Boolean - Whether we animate the rotation of the Doughnut
		animateRotate : true,
		// Boolean - Whether we animate scaling the Doughnut from the centre
		animateScale : false,
		// Boolean - whether to make the chart responsive to window resizing
		responsive : true,
		// Boolean - whether to maintain the starting aspect ratio or not when
		// responsive, if set to false, will take up entire container
		maintainAspectRatio : true,
		// String - A legend template
		legendTemplate : "",
	};
	// Create pie or douhnut chart
	// You can switch between pie and douhnut using the method below.
	pieChart.Doughnut(PieData, pieOptions);

	// -------------
	// - BAR CHART -
	// -------------
	var barChartCanvas = $("#barChart").get(0).getContext("2d");
	var barChart = new Chart(barChartCanvas);
	

	var dateProp=[];
	var nbProp=[];

	var idateProp=[];
	dateProp = document.getElementsByClassName("stringMoisPropByM");
	for (var i = 0; i < dateProp.length; i++) {
		idateProp.push(dateProp[i].innerHTML);
	}

	var inbProp=[];
	nbProp = document.getElementsByClassName("nbPropByM");
	for (var i = 0; i < nbProp.length; i++) {
		inbProp.push(nbProp[i].innerHTML);
	}

	
	var barChartData = {
			labels : idateProp,
			datasets : [ {
				label : "Nouveaux Objets",
				fillColor : "rgba(234, 181, 42, 0.7)",
				strokeColor : "rgba(234, 181, 42, 0.7)",
				pointColor : "rgba(234, 181, 42, 0.7)",
				pointStrokeColor : "#c1c7d1",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(234, 181, 42, 0.7)",
				data : inbProp
			}
			]
		};
	

	var barChartOptions = {
		// Boolean - Whether the scale should start at zero, or an order of
		// magnitude down from the lowest value
		scaleBeginAtZero : true,
		// Boolean - Whether grid lines are shown across the chart
		scaleShowGridLines : true,
		// String - Colour of the grid lines
		scaleGridLineColor : "rgba(0,0,0,.05)",
		// Number - Width of the grid lines
		scaleGridLineWidth : 1,
		// Boolean - Whether to show horizontal lines (except X axis)
		scaleShowHorizontalLines : true,
		// Boolean - Whether to show vertical lines (except Y axis)
		scaleShowVerticalLines : true,
		// Boolean - If there is a stroke on each bar
		barShowStroke : true,
		// Number - Pixel width of the bar stroke
		barStrokeWidth : 2,
		// Number - Spacing between each of the X value sets
		barValueSpacing : 5,
		// Number - Spacing between data sets within X values
		barDatasetSpacing : 1,
		// String - A legend template
		legendTemplate : "",
		// Boolean - whether to make the chart responsive
		responsive : true,
		maintainAspectRatio : true
	};

	barChartOptions.datasetFill = false;
	barChart.Bar(barChartData, barChartOptions);
	
	// -------------
	// - BAR CHART -
	// -------------
	
	var barChartCanvas1 = $("#barChart1").get(0).getContext("2d");
	var barChart1 = new Chart(barChartCanvas1);
	
	var dateMembre=[];
	var nbMembre=[];
	var idateMembre=[];
	dateMembre = document.getElementsByClassName("stringMoisMemByM");
	for (var i = 0; i < dateMembre.length; i++) {
		idateMembre.push(dateMembre[i].innerHTML);
	}
	var inbMembre=[];
	nbMembre = document.getElementsByClassName("nbMemByM");
	for (var i = 0; i < nbMembre.length; i++) {
		inbMembre.push(nbMembre[i].innerHTML);
	}

	var barChartData1 = {
			labels : idateMembre,
			datasets : [ {
				label : "Nouveaux membres",
				fillColor : "rgba(60,141,188,0.9)",
				strokeColor : "rgba(60,141,188,0.8)",
				pointColor : "#3b8bba",
				pointStrokeColor : "rgba(60,141,188,1)",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(60,141,188,1)",
				data : inbMembre
			}
			]
		};
	

	var barChartOptions1 = {
		// Boolean - Whether the scale should start at zero, or an order of
		// magnitude down from the lowest value
		scaleBeginAtZero : true,
		// Boolean - Whether grid lines are shown across the chart
		scaleShowGridLines : true,
		// String - Colour of the grid lines
		scaleGridLineColor : "rgba(0,0,0,.05)",
		// Number - Width of the grid lines
		scaleGridLineWidth : 1,
		// Boolean - Whether to show horizontal lines (except X axis)
		scaleShowHorizontalLines : true,
		// Boolean - Whether to show vertical lines (except Y axis)
		scaleShowVerticalLines : true,
		// Boolean - If there is a stroke on each bar
		barShowStroke : true,
		// Number - Pixel width of the bar stroke
		barStrokeWidth : 2,
		// Number - Spacing between each of the X value sets
		barValueSpacing : 5,
		// Number - Spacing between data sets within X values
		barDatasetSpacing : 1,
		// String - A legend template
		legendTemplate : "",
		// Boolean - whether to make the chart responsive
		responsive : true,
		maintainAspectRatio : true
	};

	barChartOptions1.datasetFill = false;
	barChart1.Bar(barChartData1, barChartOptions1);



// -------------
// - BAR CHART -
// -------------

var barChartCanvas2 = $("#barChart2").get(0).getContext("2d");
var barChart2 = new Chart(barChartCanvas2);

var dateEchange=[];
var nbEchange=[];
var idateEchange=[];
var inbEchange=[];

dateEchange = document.getElementsByClassName("stringMoisEchangeByM");
for (var i = 0; i < dateEchange.length; i++) {
	idateEchange.push(dateEchange[i].innerHTML);
}
var inbEchange=[];
nbEchange = document.getElementsByClassName("nbeByM");
for (var i = 0; i < nbEchange.length; i++) {
	inbEchange.push(nbEchange[i].innerHTML);
}

var barChartData2 = {
		labels : idateEchange,
		datasets : [ {
			label : "Nombre d'échanges finalisés par mois",
			fillColor : "rgba( 156, 25, 26, 0.8)",
			strokeColor : "rgba( 156, 25, 26, 0.8)",
			pointColor : "#800000",
			pointStrokeColor : "rgba( 156, 25, 26, 0.8)",
			pointHighlightFill : "#EEE8AA",
			pointHighlightStroke : "rgba( 156, 25, 26, 0.8)",
			data : inbEchange
		}
		]
	};


var barChartOptions2 = {
	// Boolean - Whether the scale should start at zero, or an order of
	// magnitude down from the lowest value
	scaleBeginAtZero : true,
	// Boolean - Whether grid lines are shown across the chart
	scaleShowGridLines : true,
	// String - Colour of the grid lines
	scaleGridLineColor : "rgba(0,0,0,.05)",
	// Number - Width of the grid lines
	scaleGridLineWidth : 1,
	// Boolean - Whether to show horizontal lines (except X axis)
	scaleShowHorizontalLines : true,
	// Boolean - Whether to show vertical lines (except Y axis)
	scaleShowVerticalLines : true,
	// Boolean - If there is a stroke on each bar
	barShowStroke : true,
	// Number - Pixel width of the bar stroke
	barStrokeWidth : 2,
	// Number - Spacing between each of the X value sets
	barValueSpacing : 5,
	// Number - Spacing between data sets within X values
	barDatasetSpacing : 1,
	// String - A legend template
	legendTemplate : "",
	// Boolean - whether to make the chart responsive
	responsive : true,
	maintainAspectRatio : true
};

barChartOptions2.datasetFill = false;
barChart2.Bar(barChartData2, barChartOptions2);
});