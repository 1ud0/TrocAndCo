YUI()
		.use(
				'aui-scheduler',
				function(Y) {
					

					var rep = "repetRdv:";
					var lieu = ":lieuRdv";
					var i = 0;
					var events = [];
					var Lang = 'fr';
					while (document.getElementById(rep + i + lieu) !== null) {

						var monObjet = {

							content : document.getElementById(rep + i + lieu).textContent,
							disabled : true,
							meeting : true,
							reminder : true,
							startDate : new Date(document
									.getElementById("repetRdv:" + i
											+ ":rdvYear").textContent, document
									.getElementById("repetRdv:" + i
											+ ":rdvMonth").textContent,
									document.getElementById("repetRdv:" + i
											+ ":rdvDay").textContent, document
											.getElementById("repetRdv:" + i
													+ ":rdvHours").textContent,
									document.getElementById("repetRdv:" + i
											+ ":rdvMinutes").textContent)
						};
						events.push(monObjet);
						i++;
					}

					var agendaView = new Y.SchedulerAgendaView();
					var dayView = new Y.SchedulerDayView({
						name:"Jour"
						
					});


					var weekView = new Y.SchedulerWeekView({
						name:"Semaine"
						
					});
					var monthView = new Y.SchedulerMonthView({
						name:"Mois"
						
					});
   
					var eventRecorder = new Y.SchedulerEventRecorder({
					    on: {
					        save: function(event) {
					            alert('Save Event:' + this.isNew() + ' --- ' + this.getContentNode().val() + this.getFormattedDate());
					         
					        },
					        edit: function(event) {
					            alert('Edit Event:' + this.isNew() + ' --- ' + this.getContentNode().val());
					        },
					        delete: function(event) {
					            alert('Delete Event:' + this.isNew() + ' --- ' + this.getContentNode().val());
					// Note: The cancel event seems to be buggy and occurs at the wrong times, so I commented it out.
//					      },
//					      cancel: function(event) {
//					          alert('Cancel Event:' + this.isNew() + ' --- ' + this.getContentNode().val());
					        }
					    }
					});
					new Y.Scheduler({
						
						activeView : monthView,
						boundingBox : '#myScheduler',
						date : new Date(),

						items : events,
						render : true,
						views : [ dayView, weekView, monthView, agendaView ]
					});

				});

function evenementEnregistre() {
	console.log(events)
}
