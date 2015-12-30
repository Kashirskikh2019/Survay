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
		    		  userInfo += "<tr><td><span class='mycount'></span></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].mo + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].dataResp + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].dataInput + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].sex + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].age + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].polzovatel + "</a></td></tr>";
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
function oneclinic(varr) {
	
	if(	validateOneClinic()){  $(".errorOneClinic").css('display','block');	}else{
	
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
						/*
						 * После того как была нажато редактирование и вылезло модальное с данными по редактированию ловим
						 * id этой записи. Если же была нажата проста кнопка "добавить запись" то if не отрабатывает и новая
						 * запись улетает с null id там он генериться тк запись новая.
						 * 
						 * Обрати внимание полсле отработки этого ajax поле input #id зануляется
						 * иначе при добавлении новой записи этот одишник постоянно будет и соответственно не добавляться будет а 
						 * редактироваться по этому id
						 */
						if($("#id").val()){ 	search["id"] = parseInt($("#id").val());}
						
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
							    		  userInfo += "<tr><td><span class='mycount'></span></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].mo + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].dataResp + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].dataInput + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].sex + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].age + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].polzovatel + "</a></td></tr>";
							    	  }
							    	  setTimeout ("$('#records_table').html('');",2000);
							    	  setTimeout ("$('#records_table').append(userInfo);", 2000);
							    	  
							    	  $('#records_table').animate({opacity: 1}, 2000 );
							    	  //  зануляем id input 
							    	  $("#id").val('');
							      }else{
							      }	      
							    },  
							    error: function(e){  
							      alert('Error: ' + e); 
							      //  зануляем id input 
						    	  $("#id").val('');
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
		    		  userInfo += "<tr><td><span class='mycount'></span></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].mo + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].dataResp + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].dataInput + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].sex + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].age + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].polzovatel + "</a></td></tr>";
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
	console.log(varr+'  '+varr2);
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
		    		  $("#age option:contains(" + response.result[i].age +")").attr('selected', true);
		    		  $("#ambulance option:contains(" + response.result[i].ambulance +")").attr('selected', true);
		    		  $("#clinicDoctor option:contains(" + response.result[i].clinicDoctor +")").attr('selected', true);
		    		  $("#diagnosticTests option:contains(" + response.result[i].diagnosticTests +")").attr('selected', true);
		    		  $("#equipment option:contains(" + response.result[i].equipment +")").attr('selected', true);
		    		  $("#freeHelp option:contains(" + response.result[i].freeHelp +")").attr('selected', true);
		    		  $("#laboratoryResearch option:contains(" + response.result[i].laboratoryResearch +")").attr('selected', true);
		    		  $("#medicalSpecialists option:contains(" + response.result[i].medicalSpecialists +")").attr('selected', true);
		    		  $("#qualityAmbulance option:contains(" + response.result[i].qualityAmbulance +")").attr('selected', true);
		    		  $("#repairs option:contains(" + response.result[i].repairs +")").attr('selected', true);
		    		  $("#seeADoctor option:contains(" + response.result[i].seeADoctor +")").attr('selected', true);
		    		  $("#sex option:contains(" + response.result[i].sex +")").attr('selected', true);
		    		  $("#therapist option:contains(" + response.result[i].therapist +")").attr('selected', true);
		    		  $("#waitingTime option:contains(" + response.result[i].waitingTime +")").attr('selected', true);
		    		  $("#waitingTime2 option:contains(" + response.result[i].waitingTime2 +")").attr('selected', true);
		    		  
		    		  $("#id").val(response.result[i].id);
					  $("input[name='dataRespN']").val(response.result[i].dataResp);
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

/*
 * Метод проверяет на заполненость всей формы первый уровень АП-П
 */
function validateOneClinic()
{
	if(!$("#age").val()||
	   !$("#ambulance").val()||
	   !$("#clinicDoctor").val()||
	   !$("input[name='dataRespN']").val()||
	   !$("#diagnosticTests").val()||
	   !$("#equipment").val()||
	   !$("#freeHelp").val()||
	   !$("#mo").val()||
	   !$("#laboratoryResearch").val()||
	   !$("#medicalSpecialists").val()||
	   !$("#qualityAmbulance").val()||
	   !$("#repairs").val()||
	   !$("#seeADoctor").val()||
	   !$("#sex").val()||
	   !$("#therapist").val()||
	   !$("#waitingTime").val()||
	   !$("#waitingTime2").val()) return true;
	
		else return false;
}
