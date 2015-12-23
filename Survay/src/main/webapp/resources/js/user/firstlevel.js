/*
 * Метод обрабатывает нажатие Анкеты первого уровня -> АП помощь
 * 
 */
function alloneclinic(varr) {
	
	    
	
	$.ajax({
		url : 'oneclinic',
		type: 'get',
		dataType: 'json',
		data : ({ test : varr}),
		contentType: 'application/json',
	    mimeType: 'application/json',
	    success: function(response){
 
		      if(response.status == "SUCCESS"){
		    	  userInfo = "<tr><th>№</th><th>МО</th><th>Дата опроса</th><th>Дата ввода</th><th>Пол</th><th>Возраст</th><th>Пользователь</th></tr>";
		    	  for(i =0 ; i < response.result.length ; i++){
		    		  userInfo += "<tr><td><span class='mycount'></span></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].mo + "</a></td><td>" + 
		    		  response.result[i].dataResp+  "</td><td>" +response.result[i].dataInput + "</td><td>" +response.result[i].sex + "</td><td>" +response.result[i].age + "</td><td>"+response.result[i].polzovatel + '</td></tr>';
		    	  }
		    	  
		    	  $('#records_table').html(userInfo);
		    	  $('#records_table').animate({opacity: 0}, 0 );
		    	  $('#records_table').animate({opacity: 1}, 4000 );
		    	 
		      }else{
	//records_table	    	  trHTML += '<tr><td>' + item.rank + '</td><td>' + item.content + '</td><td>' + item.UID + '</td></tr>';
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
	
	if(	!$("#age").val()){  $(".errorOneClinic").css('display','block');	}else{
	
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
							    	  $('#records_table').animate({opacity: 0.0}, 2000 );
							    	  userInfo = "<tr><th>№</th><th>МО</th><th>Дата опроса</th><th>Дата ввода</th><th>Пол</th><th>Возраст</th><th>Пользователь</th></tr>";
							    	  for(i =0 ; i < response.result.length ; i++){
							    		  userInfo += "<tr><td><span class='mycount'></span></td><td>"  + response.result[i].mo + "</td><td>" + 
							    		  response.result[i].dataResp+  "</td><td>" +response.result[i].dataInput + "</td><td>" +response.result[i].sex + "</td><td>" +response.result[i].age + "</td><td>"+response.result[i].polzovatel + '</td></tr>';
							    	  }
							    	  setTimeout ("$('#records_table').html('');",2000);
							    	  setTimeout ("$('#records_table').append(userInfo);", 2000);
							    	  
							    	  $('#records_table').animate({opacity: 1}, 2000 );
							      }else{
							      }	      
							    },  
							    error: function(e){  
							      alert('Error: ' + e);  
							    }
						});
	}					
}

/*
 * Метод обрабатывает нажатие Выбрать (период за который надо вывести записи) на листе анк первого уровня АП пом
 * 
 */
function oneclinicbetween( varr) {
	
	var inputText = $("#dateBegin").val();
	var inputText2 = $("#dateEnd").val();
	console.log('log2 '+inputText+'  '+inputText2);
	
	$.ajax({
		url : 'oneclinicbetween',
		type: 'get',
		dataType: 'json',
		data : ({ datebegin: inputText, dateend: inputText2, userp:varr}),
		contentType: 'application/json',
	    mimeType: 'application/json',
	    success: function(response){
		      // we have the response 
		      if(response.status == "SUCCESS"){
		    	  $('#records_table').animate({opacity: 0.0}, 3000 );
		    	  
		    	  userInfo = "<tr><th>№</th><th>МО</th><th>Дата опроса</th><th>Дата ввода</th><th>Пол</th><th>Возраст</th><th>Пользователь</th></tr>";
		    	  for(i =0 ; i < response.result.length ; i++){
		    		  userInfo += "<tr><td><span class='mycount'></span></td><td>"  + response.result[i].mo + "</td><td>" + 
		    		  response.result[i].dataResp+  "</td><td>" +response.result[i].dataInput + "</td><td>" +response.result[i].sex + "</td><td>" +response.result[i].age + "</td><td>"+response.result[i].polzovatel + '</td></tr>';
		    	  }
		    	  setTimeout ("$('#records_table').html('');",3000);
		    	  setTimeout ("$('#records_table').append(userInfo);", 3000);
		    	  
		    	  $('#records_table').animate({opacity: 1}, 3000 );
		    	 
		      }else{
		    	 
		      }	      
		    },  
		    error: function(e){  
		      alert('Error: ' + e);  
		    }
	});
}

/*
 * Метод обновляет запись в модальном окне первого уровня
 */
function oneLevel() {
	$('#myModal .modal-title').text('Добавить анкету первого уровня');
}
/*
 * Метод заполняет модальное окно первого уровня данными по id записи 
 */
function onecliniceditid( varr,varr2) {
	
	$.ajax({
		url : 'onecliniceditid',
		type: 'get',
		dataType: 'json',
		data : ({ user: varr, id: varr2}),
		contentType: 'application/json',
	    mimeType: 'application/json',
	    success: function(response)
	    {
		      // we have the response 
		      if(response.status == "SUCCESS")
		      {
		    	  $('#addOneClinic').trigger('click');
		    	  $('#myModal .modal-title').text('Редактирование анкеты первого уровня');
		    	  
		    	  for(i =0 ; i < response.result.length ; i++){
		    		  $("#mo option:contains(" + response.result[i].mo +")").attr('selected', true);
		    	  }
		      }else
		      {
		    	 
		      }	      
	    },  
		    error: function(e){  
		      alert('Error: ' + e);  
		    }
	});
}
