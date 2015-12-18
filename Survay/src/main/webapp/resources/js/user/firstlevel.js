/*
 * Метод обрабатывает нажатие Анкеты первого уровня -> АП помощь
 * 
 */
function alloneclinic() {
	
	
	$.ajax({
		url : 'oneclinic',
		type: 'post',
		dataType: 'json',
		contentType: 'application/json',
	    mimeType: 'application/json',
	    success: function(response){
		      // we have the response 
		      if(response.status == "SUCCESS"){
		    	  userInfo = "<ol>";
		    	  for(i =0 ; i < response.result.length ; i++){
		    		  userInfo += "<br><li><b>Name</b> : " + response.result[i].age + 
		    		  ";<b> Education</b> : " + response.result[i].polzovatel;
		    	  }
		    	  userInfo += "</ol>";
		    	  setTimeout ("$('#info').html('User has been added to the list successfully. ' + userInfo);", 2000);
		    	 
		      }else{
		    	 
		      }	      
		    },  
		    error: function(e){  
		      alert('Error: ' + e);  
		    }
	});
}

/*
 *  Метод обрабатывает нажатие клавиши добавить запись (Добавление анкеты) и обновляет список из базы
 *  с уже добаленной записью
 * 
 */
function oneclinic() {
	
	var search = {}
	
	search["age"] = $("#age").val();     
	search["ambulance"] = $("#ambulance").val();
	search["clinicDoctor"] = $("#clinicDoctor").val();
	search["dataResp"] = $("input[name='dataRespN']").val();
	search["diagnosticTests"] = $("#diagnosticTests").val();
	search["equipment"] = $("#equipment").val();
	search["freeHelp"] = $("#freeHelp").val();
	search["mo"] = $("#mo").val();
	search["laboratoryResearch"] = $("#laboratoryResearch").val();
	search["medicalSpecialists"] = $("#medicalSpecialists").val();
	search["qualityAmbulance"] = $("#qualityAmbulance").val();
	search["repairs"] = $("#repairs").val();
	search["seeADoctor"] = $("#seeADoctor").val();
	search["sex"] = $("#sex").val();
	search["therapist"] = $("#therapist").val();
	search["waitingTime"] = $("#waitingTime").val();
	search["waitingTime2"] = $("#waitingTime2").val();
	
	search["polzovatel"] = $("#polzovatel").val();
	
	$('#cancelOneClinic').trigger('click');
	$.ajax({
		url : 'addoneclinic',
		type: 'Post',
		dataType: 'json',
		contentType: 'application/json',
	    mimeType: 'application/json',
		data : JSON.stringify(search),
		success: function(response){
		      // we have the response 
		      if(response.status == "SUCCESS"){
		    	  userInfo = "<ol>";
		    	  for(i =0 ; i < response.result.length ; i++){
		    		  userInfo += "<br><li><b>Name</b> : " + response.result[i].age + 
		    		  ";<b> Education</b> : " + response.result[i].polzovatel;
		    	  }
		    	  userInfo += "</ol>";
		    	  setTimeout ("$('#info').html('User has been added to the list successfully. ' + userInfo);", 2000);
		    	 
		      }else{
		    	 
		      }	      
		    },  
		    error: function(e){  
		      alert('Error: ' + e);  
		    }
	});
}

/*
 * Метод обрабатывает нажатие Выбрать (период за который надо вывести записи) на листе анк первого уровня АП пом
 * 
 */
function oneclinicbetween() {
	
	var inputText = $("#dateBegin").val();
	var inputText2 = $("#dateEnd").val();
	
	$.ajax({
		url : 'oneclinicbetween',
		type: 'get',
		dataType: 'json',
		data : ({ datebegin: inputText, dateend: inputText2}),
		contentType: 'application/json',
	    mimeType: 'application/json',
	    success: function(response){
		      // we have the response 
		      if(response.status == "SUCCESS"){
		    	  userInfo = "<ol>";
		    	  for(i =0 ; i < response.result.length ; i++){
		    		  userInfo += "<br><li><b>Name</b> : " + response.result[i].age + 
		    		  ";<b> Education</b> : " + response.result[i].polzovatel;
		    	  }
		    	  userInfo += "</ol>";
		    	  setTimeout ("$('#info').html('User has been added to the list successfully. ' + userInfo);", 2000);
		    	 
		      }else{
		    	 
		      }	      
		    },  
		    error: function(e){  
		      alert('Error: ' + e);  
		    }
	});
}