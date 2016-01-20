/*
 * Метод отправляет данные на сервер с формы отчетов первого уровня 
 * 
 */
function onepartreports() {
	
	var search = {}
	
	search["onefirstkv"] = $("#oneFirstKv").is(':checked')
	search["onesecondkv"] = $("#oneSecondKv").is(':checked')
	search["onetreekv"] = $("#oneTreeKv").is(':checked')
	search["onefourkv"] =$("#oneFourKv").is(':checked')
	search["onefoms"] = $("#oneTFOMS").is(':checked')
	search["onesimaz"] = $("#oneSimaz").is(':checked')
	search["oneingos"] = $("#oneIngos").is(':checked')
	search["onerosno"] = $("#oneRosno").is(':checked')
	
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