/*
 * Метод отправляет данные на сервер с формы отчетов первого уровня 
 * 
 */
function onepartreports(buttonId) {
	
	var search = {}
	
	search["datestart"] = $("input[name='datebeginonereport']").val();
	search["dateend"] = $("input[name='dateendonereport']").val();
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
								
								document.location.href = '/survay/download'
								$("input[name='datebeginonereport']").val('');
								$("input[name='dateendonereport']").val('');
								
								$( "#oneTFOMS" ).prop( "checked", false );
								$( "#oneSimaz" ).prop( "checked", false );
								$( "#oneIngos" ).prop( "checked", false );
								$( "#oneRosno" ).prop( "checked", false );
								
								obj.disabled = false;
						    },
						  
							    error: function(e){  
							      alert('Произошла ошибка обновите станицу'); 
							     
							    }		    
	});
}