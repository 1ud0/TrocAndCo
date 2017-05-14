function showModalSupp(data) {
	if (data.status == "success") {
		$('#suppressionObjet').modal('show');
	}
}

function hideModalSupp(data) {
	if (data.status == "success") {
		$('#suppressionObjet').modal('hide');
	}
}