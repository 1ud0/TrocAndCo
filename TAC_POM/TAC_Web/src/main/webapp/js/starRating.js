var done=false
var starVide = "fa fa-star-o fa-2x";
var starPleine = "fa fa-star fa-2x";
 
 function rate(level){
	 if (done){return false;}
	 for(i=1;i<6;i++){ 
		 document.getElementById("star"+i).className = (level<i) ? starVide:starPleine;
	 }	
 }
 function unrate(level){
	 if (done){return false;}
	 for(i=5;i>0;i--){ 
		 document.getElementById("star"+i).className = starVide;
	 }	
 }
 
 function zero(){
     for(i=1;i<6;i++){ 
    	 document.getElementById("star"+i).className=starVide;
    	 done=false;
    	 document.getElementById("vote").innerHTML="Votre vote : 0 étoile(s)";
    	 document.getElementById("formEval:etoile").value = level;
     }
 }
 function valider(level){
	 done=true;
	 for(i=1;i<6;i++){ 
		 document.getElementById("star"+i).className = (level<i) ? starVide:starPleine;
		 document.getElementById("HiddenVote").value=level;
	 }	

	 document.getElementById("vote").innerHTML="Votre vote : "+level+" étoile(s)";
	 document.getElementById("formEval:etoile").value = level;
 }
 
