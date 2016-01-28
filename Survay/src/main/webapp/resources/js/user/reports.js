/*
 * Метод отправляет данные на сервер с формы отчетов первого уровня 
 * 
 */
function onepartreports(buttonId) {
	
	var search = {}
	
	search["datestart"] = $("input[name='datebeginonereport']").val();
	search["dateend"] = $("input[name='dateendonereport']").val();
	
	search["lpu"] = $("#lpuFormOneRerort").val();ansFormOnePart1
	
	search["ans1"] = $("#ansFormOnePart1").is(':checked')
	search["ans2"] = $("#ansFormOnePart2").is(':checked')
	search["ans3"] = $("#ansFormOnePart3").is(':checked')
	search["ans4"] = $("#ansFormOnePar4").is(':checked')
	search["ans5"] = $("#ansFormOnePart5").is(':checked')
	
	
	search["onefoms"] = $("#oneTFOMS").is(':checked')
	search["onesimaz"] = $("#oneSimaz").is(':checked')
	search["oneingos"] = $("#oneIngos").is(':checked')
	search["onerosno"] = $("#oneRosno").is(':checked')
	
	var obj = document.getElementById(buttonId);
	if (obj) {obj.disabled = true;} 
	
	console.log($("input[name='datebeginonereport']").val()+'   '+$("input[name='dateendonereport']").val());
	$.ajax({
		url : 'firstPartReport',
		type: 'Post',
		dataType: 'json',
		data : JSON.stringify(search),
		contentType: 'application/json',
	    mimeType: 'application/json',
							success: function(data)
							{
								// pass to controller
								//document.location.href = '/survay/download'
								// 	
								$("input[name='datebeginonereport']").val('');
								$("input[name='dateendonereport']").val('');
								
								$( "#oneTFOMS" ).prop( "checked", false );
								$( "#oneSimaz" ).prop( "checked", false );
								$( "#oneIngos" ).prop( "checked", false );
								$( "#oneRosno" ).prop( "checked", false );
								
								$( "#ansFormOnePart1" ).prop( "checked", false );
								$( "#ansFormOnePart2" ).prop( "checked", false );
								$( "#ansFormOnePart3" ).prop( "checked", false );
								$( "#ansFormOnePart4" ).prop( "checked", false );
								$( "#ansFormOnePart5" ).prop( "checked", false );
								
								$( "#lpuFormOneRerort" ).val($("#lpuFormOneRerort").prop('defaultSelected'));
								obj.disabled = false;
						    },
						  
							    error: function(e){  
							      alert('Произошла ошибка обновите станицу'); 
							     
							    }		    
	});
}