		

/*
 * Метод обрабатывает нажатие Анкеты второго уровня -> АП помощь
 * 
 */
function alloneclinicsecondlevel(varr) {
	
	$.ajax({
		url : 'clinicsecondlevel',
		type: 'get',
		dataType: 'json',
		data : ({ test : varr}),
		contentType: 'application/json',
	    mimeType: 'application/json',
	    success: function(response){
 
		      if(response.status == "SUCCESS"){
		    	  userInfo = "<tr><th>№</th><th>МО</th><th>Дата опроса</th><th>Дата ввода</th><th>Пол</th><th>Возраст</th><th>Пользователь</th></tr>";
		    	  for(i =0 ; i < response.result.length ; i++){
		    		  userInfo += "<tr><td><span class='mycount'></span></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].moSecondlevel + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].replacementClinicSecondlevelsurvayClinicSec1 + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].survayClinicSec1+"')>"  +response.result[i].dataInput + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].sex + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].age + "</a></td><td><a href='#' onclick=onecliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].polzovatel + "</a></td></tr>";
		    	  }
		    	  console.log("log "+response.result.length);
		    	  $('#records_tablesecondlevel').html(userInfo);
		    	  $('#records_tablesecondlevel').animate({opacity: 0}, 0 );
		    	  $('#records_tablesecondlevel').animate({opacity: 1}, 4000 );
		    	 
		      }else{
		      }	      
		    },  
		    error: function(e){  
		      alert('Произошла ошибка. Обновите страницу. ' + e);  
		    }
	});
	
	setTimeout( function () { secondclinic(varr);},4000);	
}

/*
 *  Метод обрабатывает нажатие клавиши добавить запись (Добавление анкеты) и обновляет список из базы
 *  с уже добаленной записью
 * 
 */
function secondclinic(varr) {
	
	if(	validateSecondClinic()){  $(".errorSecondClinic").css('display','block');	}else{
	
						var search = {}
						
						search["moSecondlevel"] = $("#moSecondLevel").val();
						search["dataRespSecondlevel"] = $("input[name='dataRespNSecondLevel']").val();
						search["visitClinicSecondlevel"] = $("#visitClinicSecondLevel").val();
						search["visitOptionSecondlevel"] = $("#visitOptionSecondLvel").val();
						search["replacementClinicSecondlevel"] = $("#replacementClinicSecondLevel").val();
						search["sexSecondlevel"] = $("#sexSecondLevelClinic").val();
						search["ageSecondlevel"] = $("#SecondLevelClinic").val();
						
						search["polzovatelSecondlevel"] = $("#polzovatelClinicSecondLevel").val();
						
						$("input[name='namedateBeginsecondlevel']").val('');
						$("input[name='namedateEndsecondlevel']").val('');
						
						/*
						 * После того как была нажато редактирование и вылезло модальное с данными по редактированию ловим
						 * id этой записи. Если же была нажата просто кнопка "добавить запись" то if не отрабатывает и новая
						 * запись улетает с null id там он генериться тк запись новая.
						 * 
						 * Обрати внимание после отработки этого ajax поле input #id зануляется
						 * иначе при добавлении новой записи этот айдишник постоянно будет и соответственно не добавляться будет а 
						 * редактироваться по этому id
						 */
						if($("#idClinicSecondLevel").val()){ 	search["id"] = parseInt($("#idClinicSecondLevel").val());}
						
						$('#cancelSecondClinic').trigger('click');
						//+ отрабатывает метод в other.js
				
						$.ajax({
							url : 'addsecondclinic',
							type: 'Post',
							dataType: 'json',
							contentType: 'application/json',
						    mimeType: 'application/json',
							data : JSON.stringify(search),
							success: function(response){
							      // we have the response 
							      
							    },
							    error: function(e){  
							      alert('Error: ' + e); 
							      //  зануляем id input 
						    	  $("#idClinicSecondLevel").val('');
							    }
						})
	
					
						
	}	
	

	
/*
 * Метод проверяет на заполненость всей формы второй уровень АП-П
 */
function validateSecondClinic()
{
	if(!$("#moSecondLevel").val()||
			!$("input[name='dataRespNSecondLevel']").val()||
			!$("#visitClinicSecondLevel").val()||
			!$("#visitOptionSecondLvel").val()||
			!$("#replacementClinicSecondLevel").val()||
			!$("#sexSecondLevelClinic").val()||
			!$("#SecondLevelClinic").val()) return true;
	
		else return false;
}


}
