/*
 * Метод отправляет данные на сервер с формы отчетов первого уровня 
 * 
 */
function onepartreports() {
	
	var search = {}
	
	search["datestart"] = $("input[name='datebeginonereport']").val();
	search["dateend"] = $("input[name='dateendonereport']").val();
	search["onefoms"] = $("#oneTFOMS").is(':checked')
	search["onesimaz"] = $("#oneSimaz").is(':checked')
	search["oneingos"] = $("#oneIngos").is(':checked')
	search["onerosno"] = $("#oneRosno").is(':checked')
	
	console.log($("input[name='datebeginonereport']").val()+'   '+$("input[name='dateendonereport']").val());
	$.ajax({
		url : 'firstPartReport',
		type: 'Post',
		dataType: 'json',
		data : JSON.stringify(search),
		contentType: 'application/json',
	    mimeType: 'application/json',
							success: function(data) {
            							//window.location.href = '${pageContext.request.contextPath}/download/'+ data;
            							console.log("success");	      
							    },  
							    error: function(e){  
							      alert('Error: ' + e.data); 
							     
							    }		    
	});
}