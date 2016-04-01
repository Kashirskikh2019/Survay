/*
 * Метод обрабатывает такие моменты в анкете как 'хотел(а), но не смог(а)   к вопросу 31'
 * т.е. блокирует возможность проставить ответ в данном примере на вопрос 30
 * обрабатывает все вопросы сразу....
 */
function testclic(){
	if($("#question15").val() == 'Нет (к вопросу 18)'){
		$('#question16').prop('disabled', true);
		$('#question17').prop('disabled', true);
		$(".del15").css({'opacity':0.4,'pointer-events':'none'});
		}
	else{ $(".del15").css({'opacity':1,'pointer-events':'visible'}); $('#question16').prop('disabled', false); $('#question17').prop('disabled', false);}
	
	if($("#question21").val() == 'Нет (к вопросу 23)'){
		$('#question22_clinic').prop('disabled', true);
		$(".del21").css({'opacity':0.4,'pointer-events':'none'});
		}
	else{$(".del21").css({'opacity':1,'pointer-events':'visible'}); $('#question22_clinic').prop('disabled', false);}
	
	if($("#question27").val() == 'Да (к вопросу 29)'){
		
		 $('.validquest28 input:checkbox').each(function(){
			 $(this).prop('disabled', true);
		 })
		 $(".validquest28  input:text").prop('disabled', true);
		 
		$(".del29").css({'opacity':0.4,'pointer-events':'none'});
	}
	else{
		 $('.validquest28 input:checkbox').each(function(){
			 $(this).prop('disabled', false);
		 })
		 $(".validquest28  input:text").prop('disabled', false);
		$(".del29").css({'opacity':1,'pointer-events':'visible'});
		}
	
	if($("#question27").val() == 'Нет, не было необходимости (к вопросу 30)'){
		
		$('.validquest29 input:checkbox').each(function(){
			 $(this).prop('disabled', true);
		 })
		 $(".validquest29  input:text").prop('disabled', true);
		
		$('.validquest28 input:checkbox').each(function(){
			 $(this).prop('disabled', true);
		 })
		 $(".validquest28  input:text").prop('disabled', true);
		
		$(".del30,.del29").css({'opacity':0.4,'pointer-events':'none'});
		}
	else{
		$('.validquest29 input:checkbox').each(function(){
			 $(this).prop('disabled', false);
		 })
		 $(".validquest29  input:text").prop('disabled', false);
		$(".del30").css({'opacity':1,'pointer-events':'visible'});
		}

	 var tt = 0;
	 $('div#quest28 input:checkbox').each(function(){
		 
		 if($(this).is(':checked')){tt ++;}
	   })
	 if(tt > 0){
		 
		 $('.validquest29 input:checkbox').each(function(){
			 $(this).prop('disabled', true);
		 })
		 $(".validquest29  input:text").prop('disabled', true);
		 $(".del30").css({'opacity':0.4,'pointer-events':'none'});
		 }
	 else{
		 if($.trim($('div#quest28 input:text').val()) != '') {
			 
			 $('.validquest29 input:checkbox').each(function(){
				 $(this).prop('disabled', true);
			 })
			 $(".validquest29  input:text").prop('disabled', true);
			 
			$(".del30").css({'opacity':0.4,'pointer-events':'none'});
			 }
	 }
	 // зануляем тк буду использовать ниже
	 tt = 0;
	 
	 if($("#question30").val() == 'Да (к вопросу 32)'){
		 
		 $('.validquest31 input:checkbox').each(function(){
			 $(this).prop('disabled', true);
		 })
		 $(".validquest31  input:text").prop('disabled', true);
		 $(".del31").css({'opacity':0.4,'pointer-events':'none'});
	 }
		else{
			$('.validquest31 input:checkbox').each(function(){
				 $(this).prop('disabled', false);
			 })
			 $(".validquest31  input:text").prop('disabled', false);
			$(".del31").css({'opacity':1,'pointer-events':'visible'});
	 }
	 
	 if($("#question30").val() == 'Нет, не было необходимости (к вопросу 33)'){
		 
		 $('.validquest32 input:checkbox').each(function(){
			 $(this).prop('disabled', true);
		 })
		 $(".validquest32  input:text").prop('disabled', true);
		 
		 $('.validquest31 input:checkbox').each(function(){
			 $(this).prop('disabled', true);
		 })
		 $(".validquest31  input:text").prop('disabled', true);
		 
		 $(".del31,.del32").css({'opacity':0.4,'pointer-events':'none'});
		 }
		else{
			$('.validquest32 input:checkbox').each(function(){
				 $(this).prop('disabled', false);
			 })
			 $(".validquest32  input:text").prop('disabled', false);
			
			$(".del32").css({'opacity':1,'pointer-events':'visible'});
			}
	 
	 
	 
	 $('div#quest31 input:checkbox').each(function(){
		 if($(this).is(':checked')){tt ++;}
	   })
	   if(tt == 0){ 
		 	if($.trim($('div#quest31 input:text').val()) != '') {
		 		$('.validquest32 input:checkbox').each(function(){
					 $(this).prop('disabled', true);
				 })
				 $(".validquest32  input:text").prop('disabled', true);
		 		
				 $(".del32").css({'opacity':0.4,'pointer-events':'none'});
				 }
	   }
	 if(tt > 0){
		 $('.validquest32 input:checkbox').each(function(){
			 $(this).prop('disabled', true);
		 })
		 $(".validquest32  input:text").prop('disabled', true);
		 
		 $(".del32").css({'opacity':0.4,'pointer-events':'none'});
		 }
	   
	 
	 if($("#question33").val() == 'Да, я получал(а) бесплатную медицинскую помощь на других территориях РФ по полису ОМС (к вопросу 35)'){$('#question34').prop('disabled', true);$(".del34").css({'opacity':0.4,'pointer-events':'none'});}
		else{
			if($("#question33").val() == 'Нет, не приходилось (к вопросу 35)'){$(".del34").css({'opacity':0.4,'pointer-events':'none'}); $('#question34').prop('disabled', true);}
			else{$(".del34").css({'opacity':1,'pointer-events':'visible'}); $('#question34').prop('disabled', false);}
			}
	 
	 if($("#question35").val() == 'Не приходилось (к вопросу 37)'){$(".del36").css({'opacity':0.4,'pointer-events':'none'}); $('#question36').prop('disabled', true);}
		else{$(".del36").css({'opacity':1,'pointer-events':'visible'}); $('#question36').prop('disabled', false);}  
		
		if($("#question37").val() == 'Нет, никогда не приходилось к (вопросу 39)'){$(".del38").css({'opacity':0.4,'pointer-events':'none'}); $('#question38').prop('disabled', true);}
		else{$(".del38").css({'opacity':1,'pointer-events':'visible'}); $('#question38').prop('disabled', false);}
	
	}		

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
		    		  userInfo += "<tr><td><span class='mycount'></span></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].moSecondlevel + "</a></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].dataRespSecondlevel + "</a></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].dataInputSecondlevel + "</a></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].sexSecondlevel + "</a></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].ageSecondlevel + "</a></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].polzovatelSecondlevel + "</a></td></tr>";
		    	  }
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
	
}


function secondlevelclinic(varr) {
	
	
	if(	validateSecondClinic()){  $(".errorSecondClinic").css('display','block');	}else{
	
						var general = {}
						var sec1 = {}
						var sec2 = {}
						var question25 = {}
						var many = {}
						
						general["moSecondlevel"] = $("#moSecondLevel").val();
						general["dataRespSecondlevel"] = $("input[name='dataRespNSecondLevel']").val();
						general["visitClinicSecondlevel"] = $("#visitClinicSecondLevel").val();
						
						if($("#question2_1_clinic").is(':checked')){ many["question2_1_clinic"] = $("#question2_1_clinic").val();} else{ many["question2_1_clinic"] = "пусто";	}
						if($("#question2_2_clinic").is(':checked')){ many["question2_2_clinic"] = $("#question2_2_clinic").val();} else{ many["question2_2_clinic"] = "пусто";	}
						if($("#question2_3_clinic").is(':checked')){ many["question2_3_clinic"] = $("#question2_3_clinic").val();} else{ many["question2_3_clinic"] = "пусто";	}
						if($("#question2_4_clinic").is(':checked')){ many["question2_4_clinic"] = $("#question2_4_clinic").val();} else{ many["question2_4_clinic"] = "пусто";	}
						if($("#question2_5_clinic").is(':checked')){ many["question2_5_clinic"] = $("#question2_5_clinic").val();} else{ many["question2_5_clinic"] = "пусто";	}
						if($("#question2_6_clinic").val() != ''){many["question2_6_clinic"] = $("#question2_6_clinic").val();	}else{ many["question2_6_clinic"] = 'пусто';	}
						
						sec1["replacementClinicSecondlevel"] = $("#replacementClinicSecondLevel").val();
						sec1["question4"] = $("#question4").val();
						general["question5"] = $("#question5").val();
						
						if($("#question6_1_1_clinic").is(':checked')){ many["question6_1_1_clinic"] = $("#question6_1_1_clinic").val();} else{ many["question6_1_1_clinic"] = "пусто";	}
						if($("#question6_1_2_clinic").is(':checked')){ many["question6_1_2_clinic"] = $("#question6_1_2_clinic").val();} else{ many["question6_1_2_clinic"] = "пусто";	}
						if($("#question6_1_3_clinic").is(':checked')){ many["question6_1_3_clinic"] = $("#question6_1_3_clinic").val();} else{ many["question6_1_3_clinic"] = "пусто";	}
						if($("#question6_1_4_clinic").is(':checked')){ many["question6_1_4_clinic"] = $("#question6_1_4_clinic").val();} else{ many["question6_1_4_clinic"] = "пусто";	}
						if($("#question6_1_5_clinic").val() != ''){many["question6_1_5_clinic"] = $("#question6_1_5_clinic").val();	}else{ many["question6_1_5_clinic"] = 'пусто';	}
						
						if($("#question6_2_1_clinic").is(':checked')){ many["question6_2_1_clinic"] = $("#question6_2_1_clinic").val();} else{ many["question6_2_1_clinic"] = "пусто";	}
						if($("#question6_2_2_clinic").is(':checked')){ many["question6_2_2_clinic"] = $("#question6_2_2_clinic").val();} else{ many["question6_2_2_clinic"] = "пусто";	}
						if($("#question6_2_3_clinic").is(':checked')){ many["question6_2_3_clinic"] = $("#question6_2_3_clinic").val();} else{ many["question6_2_3_clinic"] = "пусто";	}
						if($("#question6_2_4_clinic").is(':checked')){ many["question6_2_4_clinic"] = $("#question6_2_4_clinic").val();} else{ many["question6_2_4_clinic"] = "пусто";	}
						if($("#question6_2_5_clinic").val() != ''){many["question6_2_5_clinic"] = $("#question6_2_5_clinic").val();	}else{ many["question6_2_5_clinic"] = 'пусто';	}
						
						sec1["question7"] = $("#question7").val();
						sec1["question8_1"] = $("#question8_1").val();
						sec1["question8_2"] = $("#question8_2").val();
						general["question9_1"] = $("#question9_1").val();
						general["question9_2"] = $("#question9_2").val();
						sec1["question10"] = $("#question10").val();
						general["question11"] = $("#question11").val();
						sec2["question12_clinic"] = $("#question12_clinic").val();
						sec1["question13"] = $("#question13").val();
						sec1["question14"] = $("#question14").val();
						sec1["question15"] = $("#question15").val();
						general["question16"] = $("#question16").val();
						general["question17"] = $("#question17").val();
						sec1["question18"] = $("#question18").val();
						general["question19"] = $("#question19").val();
						
						sec2["question20_1_clinic"] = $("#question20_1_clinic").val();
						sec2["question20_2_clinic"] = $("#question20_2_clinic").val();
						sec2["question20_3_clinic"] = $("#question20_3_clinic").val();
						sec2["question20_4_clinic"] = $("#question20_4_clinic").val();
						sec2["question20_5_clinic"] = $("#question20_5_clinic").val();
						sec2["question20_6_clinic"] = $("#question20_6_clinic").val();
						sec2["question20_7_clinic"] = $("#question20_7_clinic").val();
						sec2["question20_8_clinic"] = $("#question20_8_clinic").val();
						sec2["question20_9_clinic"] = $("#question20_9_clinic").val();
						sec2["question20_10_clinic"] = $("#question20_10_clinic").val();
						sec2["question20_11_clinic"] = $("#question20_11_clinic").val();
						sec2["question20_12_clinic"] = $("#question20_12_clinic").val();
						sec2["question20_13_clinic"] = $("#question20_13_clinic").val();
						sec2["question20_14_clinic"] = $("#question20_14_clinic").val();
						sec2["question20_15_clinic"] = $("#question20_15_clinic").val();
						sec2["question20_16_clinic"] = $("#question20_16_clinic").val();
						sec2["question20_17_clinic"] = $("#question20_17_clinic").val();
						sec1["question21"] = $("#question21").val();
						sec2["question22_clinic"] = $("#question22_clinic").val();
						sec1["question23"] = $("#question23").val();
						
						if($("#question24_1_clinic").is(':checked')){ many["question24_1_clinic"] = $("#question24_1_clinic").val();} else{ many["question24_1_clinic"] = "пусто";	}
						if($("#question24_2_clinic").is(':checked')){ many["question24_2_clinic"] = $("#question24_2_clinic").val();} else{ many["question24_2_clinic"] = "пусто";	}
						if($("#question24_3_clinic").is(':checked')){ many["question24_3_clinic"] = $("#question24_3_clinic").val();} else{ many["question24_3_clinic"] = "пусто";	}
						if($("#question24_4_clinic").is(':checked')){ many["question24_4_clinic"] = $("#question24_4_clinic").val();} else{ many["question24_4_clinic"] = "пусто";	}
						if($("#question24_5_clinic").is(':checked')){ many["question24_5_clinic"] = $("#question24_5_clinic").val();} else{ many["question24_5_clinic"] = "пусто";	}
						if($("#question24_6_clinic").is(':checked')){ many["question24_6_clinic"] = $("#question24_6_clinic").val();} else{ many["question24_6_clinic"] = "пусто";	}
						if($("#question24_7_clinic").is(':checked')){ many["question24_7_clinic"] = $("#question24_7_clinic").val();} else{ many["question24_7_clinic"] = "пусто";	}
						if($("#question24_8_clinic").is(':checked')){ many["question24_8_clinic"] = $("#question24_8_clinic").val();} else{ many["question24_8_clinic"] = "пусто";	}
						if($("#question24_9_clinic").is(':checked')){ many["question24_9_clinic"] = $("#question24_9_clinic").val();} else{ many["question24_9_clinic"] = "пусто";	}
						if($("#question24_10_clinic").val() != ''){many["question24_10_clinic"] = $("#question24_10_clinic").val();	}else{ many["question24_10_clinic"] = 'пусто';	}
					
						question25["question25_1_clinic"] = $("#question25_1_clinic").val();
						question25["question25_2_clinic"] = $("#question25_2_clinic").val();
						question25["question25_3_clinic"] = $("#question25_3_clinic").val();
						question25["question25_4_clinic"] = $("#question25_4_clinic").val();
						question25["question25_5_clinic"] = $("#question25_5_clinic").val();
						question25["question25_6_clinic"] = $("#question25_6_clinic").val();
						question25["question25_7_clinic"] = $("#question25_7_clinic").val();
						question25["question25_8_clinic"] = $("#question25_8_clinic").val();
						question25["question25_9_clinic"] = $("#question25_9_clinic").val();
						question25["question25_10_clinic"] = $("#question25_10_clinic").val();
						question25["question25_11_clinic"] = $("#question25_11_clinic").val();
						
						if($("#question26_1_clinic").is(':checked')){ many["question26_1_clinic"] = $("#question26_1_clinic").val();} else{ many["question26_1_clinic"] = "пусто";	}
						if($("#question26_2_clinic").is(':checked')){ many["question26_2_clinic"] = $("#question26_2_clinic").val();} else{ many["question26_2_clinic"] = "пусто";	}
						if($("#question26_3_clinic").is(':checked')){ many["question26_3_clinic"] = $("#question26_3_clinic").val();} else{ many["question26_3_clinic"] = "пусто";	}
						if($("#question26_4_clinic").is(':checked')){ many["question26_4_clinic"] = $("#question26_4_clinic").val();} else{ many["question26_4_clinic"] = "пусто";	}
						if($("#question26_5_clinic").is(':checked')){ many["question26_5_clinic"] = $("#question26_5_clinic").val();} else{ many["question26_5_clinic"] = "пусто";	}
						if($("#question26_6_clinic").is(':checked')){ many["question26_6_clinic"] = $("#question26_6_clinic").val();} else{ many["question26_6_clinic"] = "пусто";	}
						if($("#question26_7_clinic").val() != ''){many["question26_7_clinic"] = $("#question26_7_clinic").val();	}else{ many["question26_7_clinic"] = 'пусто';	}
						
						general["question27"] = $("#question27").val();
						
						if($("#question28_1_clinic").is(':checked')){ many["question28_1_clinic"] = $("#question28_1_clinic").val();} else{ many["question28_1_clinic"] = "пусто";	}
						if($("#question28_2_clinic").is(':checked')){ many["question28_2_clinic"] = $("#question28_2_clinic").val();} else{ many["question28_2_clinic"] = "пусто";	}
						if($("#question28_3_clinic").is(':checked')){ many["question28_3_clinic"] = $("#question28_3_clinic").val();} else{ many["question28_3_clinic"] = "пусто";	}
						if($("#question28_4_clinic").is(':checked')){ many["question28_4_clinic"] = $("#question28_4_clinic").val();} else{ many["question28_4_clinic"] = "пусто";	}
						if($("#question28_5_clinic").val() != ''){many["question28_5_clinic"] = $("#question28_5_clinic").val();	}else{ many["question28_5_clinic"] = 'пусто';	}
						if($("#question28_6_clinic").val() != ''){many["question28_6_clinic"] = $("#question28_6_clinic").val();	}else{ many["question28_6_clinic"] = 'пусто';	}
						
						if($("#question29_1_clinic").is(':checked')){ many["question29_1_clinic"] = $("#question29_1_clinic").val();} else{ many["question29_1_clinic"] = "пусто";	}
						if($("#question29_2_clinic").is(':checked')){ many["question29_2_clinic"] = $("#question29_2_clinic").val();} else{ many["question29_2_clinic"] = "пусто";	}
						if($("#question29_3_clinic").is(':checked')){ many["question29_3_clinic"] = $("#question29_3_clinic").val();} else{ many["question29_3_clinic"] = "пусто";	}
						if($("#question29_4_clinic").is(':checked')){ many["question29_4_clinic"] = $("#question29_4_clinic").val();} else{ many["question29_4_clinic"] = "пусто";	}
						if($("#question29_5_clinic").is(':checked')){ many["question29_5_clinic"] = $("#question29_5_clinic").val();} else{ many["question29_5_clinic"] = "пусто";	}
						if($("#question29_6_clinic").is(':checked')){ many["question29_6_clinic"] = $("#question29_6_clinic").val();} else{ many["question29_6_clinic"] = "пусто";	}
						if($("#question29_7_clinic").is(':checked')){ many["question29_7_clinic"] = $("#question29_7_clinic").val();} else{ many["question29_7_clinic"] = "пусто";	}
						if($("#question29_8_clinic").val() != ''){many["question29_8_clinic"] = $("#question29_8_clinic").val();	}else{ many["question29_8_clinic"] = 'пусто';	}
						
						general["question30"] = $("#question30").val();
						
						if($("#question31_1_clinic").is(':checked')){ many["question31_1_clinic"] = $("#question31_1_clinic").val();} else{ many["question31_1_clinic"] = "пусто";	}
						if($("#question31_2_clinic").is(':checked')){ many["question31_2_clinic"] = $("#question31_2_clinic").val();} else{ many["question31_2_clinic"] = "пусто";	}
						if($("#question31_3_clinic").val() != ''){many["question31_3_clinic"] = $("#question31_3_clinic").val();	}else{ many["question31_3_clinic"] = 'пусто';	}
						if($("#question31_4_clinic").val() != ''){many["question31_4_clinic"] = $("#question31_4_clinic").val();	}else{ many["question31_4_clinic"] = 'пусто';	}
						
						if($("#question32_1_clinic").is(':checked')){ many["question32_1_clinic"] = $("#question32_1_clinic").val();} else{ many["question32_1_clinic"] = "пусто";	}
						if($("#question32_2_clinic").is(':checked')){ many["question32_2_clinic"] = $("#question32_2_clinic").val();} else{ many["question32_2_clinic"] = "пусто";	}
						if($("#question32_3_clinic").is(':checked')){ many["question32_3_clinic"] = $("#question32_3_clinic").val();} else{ many["question32_3_clinic"] = "пусто";	}
						if($("#question32_4_clinic").is(':checked')){ many["question32_4_clinic"] = $("#question32_4_clinic").val();} else{ many["question32_4_clinic"] = "пусто";	}
						if($("#question32_5_clinic").is(':checked')){ many["question32_5_clinic"] = $("#question32_5_clinic").val();} else{ many["question32_5_clinic"] = "пусто";	}
						if($("#question32_6_clinic").val() != ''){many["question32_6_clinic"] = $("#question32_6_clinic").val();	}else{ many["question32_6_clinic"] = 'пусто';	}
						
						general["question33"] = $("#question33").val();
						general["question34"] = $("#question34").val();
						general["question35"] = $("#question35").val();
						general["question36"] = $("#question36").val();
						general["question37"] = $("#question37").val();
						general["question38"] = $("#question38").val();
						general["sexSecondlevel"] = $("#sexSecondLevelClinic").val();
						general["ageSecondlevel"] = $("#ageSecondLevelClinic").val();
						general["question41"] = $("#question41").val();
						general["question42"] = $("#question42").val();
						general["question43"] = $("#question43").val();
						
						general["polzovatelSecondlevel"] = $("#polzovatelClinicSecondLevel").val();
						
						// после нажатия добавить -> зачищаются периоды для кнопки выбрать
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
						if($("#idClinicSecondLevel").val()){ 	general["id"] = parseInt($("#idClinicSecondLevel").val());}
						
						$('#cancelSecondClinic').trigger('click');
						//+ отрабатывает метод в other.js
						
						var sender = ({ survay1:general, survay2:sec1,survay3:sec2,survay4:question25,survay5:many}); 
						
				
						$.post('addsecondclinic',JSON.stringify(sender),function(response)
    	      	                {
								    	  $('#records_tablesecondlevel').animate({opacity: 0.0}, 2000 );
								    	  userInfo = "<tr><th>№</th><th>МО</th><th>Дата опроса</th><th>Дата ввода</th><th>Пол</th><th>Возраст</th><th>Пользователь</th></tr>";
								    	  for(i =0 ; i < response.result.length ; i++){
								    		  userInfo += "<tr><td><span class='mycount'></span></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].moSecondlevel + "</a></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  + response.result[i].dataRespSecondlevel + "</a></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].dataInputSecondlevel + "</a></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].sexSecondlevel + "</a></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].ageSecondlevel + "</a></td><td><a href='#' onclick=secondcliniceditid('"+varr+"','"+response.result[i].id+"')>"  +response.result[i].polzovatelSecondlevel + "</a></td></tr>";
								    	  }
								    	  setTimeout ("$('#records_tablesecondlevel').html('');",2000);
								    	  setTimeout ("$('#records_tablesecondlevel').append(userInfo);", 2000);
								    	  
								    	  $('#records_tablesecondlevel').animate({opacity: 1}, 2000 );
								    	  //  зануляем id input 
								    	  $("#idClinicSecondLevel").val('');
								      
    	      	                	console.log('test OK');
        	      	            },'json')
        	      	          	.error(function(msg) {console.log('test BAD'); $("#idClinicSecondLevel").val('');});
	}				
						
	}	
	

	
/*
 * Метод проверяет на заполненость всей формы второй уровень АП-П
 * метод учитывает если вопрос отключен
 */
function validateSecondClinic()
{
	      
		  // проверяем селекты
	     var t=0;
	      var $form = $('#formClinicSecondLevel') 
	      $('select', $form).each(function() {
	    	  if(!$(this).is(':disabled')){
	    		  // выбираем выбранное
	    		  if($(this).find('option:selected').text().length == 0){
		  	        	t++;
	    		  }  
	    	  }
	      });
	      //	про чекбоксы вопрос2
	      var d = 0;
		   $('.validquest2 input:checkbox').each(function(){
				 if(!$(this).is(':checked')){d++;}
		   })
		   // если все 5 чекбоксов не проставлены
		   if(d == 5){	if($.trim($(".validquest2  input:text").val()) != '') d=0; }
		   // если хотя бы один чек бокс проставлен т.е. d будет меньше 5
		   else{d =	0;}
		   
	      var d6_1 = 0;
		   $('.validquest6_1 input:checkbox').each(function(){
				 if(!$(this).is(':checked')){d6_1++;}
		   })
		   if(d6_1 == 4){	if($.trim($(".validquest6_1  input:text").val()) != '') d6_1=0; }
		   else{d6_1 =	0;}
		   
		   var d6_2 = 0;
		   $('.validquest6_2 input:checkbox').each(function(){
				 if(!$(this).is(':checked')){d6_2++;}
		   })
		   if(d6_2 == 4){	if($.trim($(".validquest6_2  input:text").val()) != '') d6_2=0; }
		   else{d6_2 =	0;}
		   
		   var d24 = 0;
		   $('.validquest24 input:checkbox').each(function(){
				 if(!$(this).is(':checked')){d24++;}
		   })
		   if(d24 == 9){	if($.trim($(".validquest24  input:text").val()) != '') d24=0; }
		   else{d24 =	0;}
		   
		   var d26 = 0;
		   $('.validquest26 input:checkbox').each(function(){
				 if(!$(this).is(':checked')){d26++;}
		   })
		   if(d26 == 6){	if($.trim($(".validquest26  input:text").val()) != '') d26=0; }
		   else{d26 =	0;}
		   
		   var d28 = 0;
		   // проверека на disable - исключаем из валидации отключенные вопросы (достаточно проверить хотя бы один чекбокс из вопроса)
		   if(!$('#question28_1_clinic').is(':disabled')){
			   $('.validquest28 input:checkbox').each(function(){
					 if(!$(this).is(':checked')){d28++;}
			   })
			   if(d28 == 4){	if($.trim($(".validquest28  input:text").val()) != '') d28=0; }
			   else{d28 =	0;}
		   }
		   
		   var d29 = 0;
		   if(!$('#question29_1_clinic').is(':disabled')){
			   $('.validquest29 input:checkbox').each(function(){
					 if(!$(this).is(':checked')){d29++;}
			   })
			   if(d29 == 7){	if($.trim($(".validquest29  input:text").val()) != '') d29=0; }
			   else{d29 =	0;}
		   }
		   
		   var d31 = 0;
		   if(!$('#question31_1_clinic').is(':disabled')){
			   $('.validquest31 input:checkbox').each(function(){
					 if(!$(this).is(':checked')){d31++;}
				   
			   })
			   if(d31 == 2){	if($.trim($("#question31_3_clinic").val()) != '' || $.trim($("#question31_4_clinic").val()) != '') d31=0; }
			   else{d31 =	0;}
		   }
		   
		   var d32 = 0;
		   if(!$('#question32_1_clinic').is(':disabled')){
			   $('.validquest32 input:checkbox').each(function(){
					 if(!$(this).is(':checked')){d32++;}
			   })
			   if(d32 == 5){	if($.trim($(".validquest32  input:text").val()) != '') d32=0; }
			   else{d32 =	0;}
		   }
		   
		   var d36= 0 ;
		   if(!$('#question36').is(':disabled')){	if($("#question36").val() == '') d36++;	}
		   
		   var d16= 0 ;
		   if(!$('#question16').is(':disabled')){	if($("#question16").val() == '') d16++;	}
		   
		   

	   console.log('t '+t+' d '+d+' d6_1 '+ d6_1+' d6_2 '+ d6_2+' d24 '+ d24+' d26 '+ d26+' d28 '+ d28+' d29 '+ d29+' d32 '+ d32+' d31 '+ d31+' d36 '+ d36+' d16 '+ d16);
	   if((t+d+d6_1+d6_2+d24+d26+d28+d29+d32+d31+d36+d16) > 0) return true; else false;   
}

/*
 * Метод заполняет модальное окно второго уровня данными по id записи (редакитирование)
 */
function secondcliniceditid( varr,varr2) {
	console.log(varr+'  '+varr2);
	$.ajax({
		url : 'secondcliniceditid',
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
		    	  /*  console.log('test '+JSON.stringify(response));
		    		  console.log('=======================');
		    		  console.log('test '+JSON.stringify(response.result[0]));
		    		  console.log('=======================');
		    		  console.log('test '+JSON.stringify(response.result[0].survayClinicSec1));
		    		  console.log('=======================');
		    		  console.log('test '+JSON.stringify(response.result[0].question_many));
		    	  */
		    	  
		    	  $('#addOneClinicsecondlevel').trigger('click');
		    	  $('#myModalClinicSecondLevel .modal-title').text('Редактирование анкеты первого уровня');
		    	  $('.renamebtn').text('Редактировать');
		    	  
		    	  for(i =0 ; i < response.result.length ; i++){
		    		  $("#idClinicSecondLevel").val(response.result[i].id);
		    		  $("input[name='dataRespNSecondLevel']").val(response.result[i].dataRespSecondlevel);
		    		  
		    		  $("#ageSecondLevelClinic option:contains(" + response.result[i].ageSecondlevel +")").prop('selected', true);
		    		  $("#moSecondLevel option:contains(" + response.result[i].moSecondlevel +")").prop('selected', true);
		    		  $("#sexSecondLevelClinic option:contains(" + response.result[i].sexSecondlevel +")").prop('selected', true);
		    		  $("#visitClinicSecondLevel option:contains(" + response.result[i].visitClinicSecondlevel +")").prop('selected', true);
		    		  $("#question5 option:contains(" + response.result[i].question5 +")").prop('selected', true);
		    		  $("#question9_1 option:contains(" + response.result[i].question9_1 +")").prop('selected', true);
		    		  $("#question9_2 option:contains(" + response.result[i].question9_2 +")").prop('selected', true);
		    		  $("#question11 option:contains(" + response.result[i].question11 +")").prop('selected', true);
		    		  $("#question16").val(response.result[i].question16);
		    		  $("#question17 option:contains(" + response.result[i].question17 +")").prop('selected', true);
		    		  $("#question19 option:contains(" + response.result[i].question19 +")").prop('selected', true);
		    		  $("#question27 option:contains(" + response.result[i].question27 +")").prop('selected', true);
		    		  $("#question30 option:contains(" + response.result[i].question30 +")").prop('selected', true);
		    		  $("#question33 option:contains(" + response.result[i].question33 +")").prop('selected', true);
		    		  $("#question34 option:contains(" + response.result[i].question34 +")").prop('selected', true);
		    		  $("#question35 option:contains(" + response.result[i].question35 +")").prop('selected', true);
		    		  $("#question36").val(response.result[i].question36);
		    		  $("#question37 option:contains(" + response.result[i].question37 +")").prop('selected', true);
		    		  $("#question38 option:contains(" + response.result[i].question38 +")").prop('selected', true);
		    		  $("#question41 option:contains(" + response.result[i].question41 +")").prop('selected', true);
		    		  $("#question42 option:contains(" + response.result[i].question42 +")").prop('selected', true);
		    		  $("#question43 option:contains(" + response.result[i].question43 +")").prop('selected', true);
		    	  }
		    	  
		    	  $("#replacementClinicSecondLevel option:contains(" + response.result[0].survayClinicSec1.replacementClinicSecondlevel +")").prop('selected', true);
		    	  $("#question4 option:contains(" + response.result[0].survayClinicSec1.question4 +")").prop('selected', true);
		    	  $("#question7 option:contains(" + response.result[0].survayClinicSec1.question7 +")").prop('selected', true);
		    	  $("#question8_1 option:contains(" + response.result[0].survayClinicSec1.question8_1 +")").prop('selected', true);
		    	  $("#question8_2 option:contains(" + response.result[0].survayClinicSec1.question8_2 +")").prop('selected', true);
		    	  $("#question10 option:contains(" + response.result[0].survayClinicSec1.question10 +")").prop('selected', true);
		    	  $("#question13 option:contains(" + response.result[0].survayClinicSec1.question13 +")").prop('selected', true);
		    	  $("#question14 option:contains(" + response.result[0].survayClinicSec1.question14 +")").prop('selected', true);
		    	  $("#question15 option:contains(" + response.result[0].survayClinicSec1.question15 +")").prop('selected', true);
		    	  $("#question18 option:contains(" + response.result[0].survayClinicSec1.question18 +")").prop('selected', true);
		    	  $("#question21 option:contains(" + response.result[0].survayClinicSec1.question21 +")").prop('selected', true);
		    	  $("#question23 option:contains(" + response.result[0].survayClinicSec1.question23 +")").prop('selected', true);
		    	  
		    	  $("#question12_clinic option:contains(" + response.result[0].survayClinicSec2.question12_clinic +")").prop('selected', true);
		    	  $("#question22_clinic option:contains(" + response.result[0].survayClinicSec2.question22_clinic +")").prop('selected', true);
		    	  $("#question20_1_clinic option:contains(" + response.result[0].survayClinicSec2.question20_1_clinic +")").prop('selected', true);
		    	  $("#question20_2_clinic option:contains(" + response.result[0].survayClinicSec2.question20_2_clinic +")").prop('selected', true);
		    	  $("#question20_3_clinic option:contains(" + response.result[0].survayClinicSec2.question20_3_clinic +")").prop('selected', true);
		    	  $("#question20_4_clinic option:contains(" + response.result[0].survayClinicSec2.question20_4_clinic +")").prop('selected', true);
		    	  $("#question20_5_clinic option:contains(" + response.result[0].survayClinicSec2.question20_5_clinic +")").prop('selected', true);
		    	  $("#question20_6_clinic option:contains(" + response.result[0].survayClinicSec2.question20_6_clinic +")").prop('selected', true);
		    	  $("#question20_7_clinic option:contains(" + response.result[0].survayClinicSec2.question20_7_clinic +")").prop('selected', true);
		    	  $("#question20_8_clinic option:contains(" + response.result[0].survayClinicSec2.question20_8_clinic +")").prop('selected', true);
		    	  $("#question20_9_clinic option:contains(" + response.result[0].survayClinicSec2.question20_9_clinic +")").prop('selected', true);
		    	  $("#question20_10_clinic option:contains(" + response.result[0].survayClinicSec2.question20_10_clinic +")").prop('selected', true);
		    	  $("#question20_11_clinic option:contains(" + response.result[0].survayClinicSec2.question20_11_clinic +")").prop('selected', true);
		    	  $("#question20_12_clinic option:contains(" + response.result[0].survayClinicSec2.question20_12_clinic +")").prop('selected', true);
		    	  $("#question20_13_clinic option:contains(" + response.result[0].survayClinicSec2.question20_13_clinic +")").prop('selected', true);
		    	  $("#question20_14_clinic option:contains(" + response.result[0].survayClinicSec2.question20_14_clinic +")").prop('selected', true);
		    	  $("#question20_15_clinic option:contains(" + response.result[0].survayClinicSec2.question20_15_clinic +")").prop('selected', true);
		    	  $("#question20_16_clinic option:contains(" + response.result[0].survayClinicSec2.question20_16_clinic +")").prop('selected', true);
		    	  $("#question20_17_clinic option:contains(" + response.result[0].survayClinicSec2.question20_17_clinic +")").prop('selected', true);
		    	  
		    	  $("#question25_1_clinic option:contains(" + response.result[0].survayClinicSec25.question25_1_clinic +")").prop('selected', true);
		    	  $("#question25_2_clinic option:contains(" + response.result[0].survayClinicSec25.question25_2_clinic +")").prop('selected', true);
		    	  $("#question25_3_clinic option:contains(" + response.result[0].survayClinicSec25.question25_3_clinic +")").prop('selected', true);
		    	  $("#question25_4_clinic option:contains(" + response.result[0].survayClinicSec25.question25_4_clinic +")").prop('selected', true);
		    	  $("#question25_5_clinic option:contains(" + response.result[0].survayClinicSec25.question25_5_clinic +")").prop('selected', true);
		    	  $("#question25_6_clinic option:contains(" + response.result[0].survayClinicSec25.question25_6_clinic +")").prop('selected', true);
		    	  $("#question25_7_clinic option:contains(" + response.result[0].survayClinicSec25.question25_7_clinic +")").prop('selected', true);
		    	  $("#question25_8_clinic option:contains(" + response.result[0].survayClinicSec25.question25_8_clinic +")").prop('selected', true);
		    	  $("#question25_9_clinic option:contains(" + response.result[0].survayClinicSec25.question25_9_clinic +")").prop('selected', true);
		    	  $("#question25_10_clinic option:contains(" + response.result[0].survayClinicSec25.question25_10_clinic +")").prop('selected', true);
		    	  $("#question25_11_clinic option:contains(" + response.result[0].survayClinicSec25.question25_11_clinic +")").prop('selected', true);
		    	  
		    	  for(i =0 ; i < response.result[0].question_many.length ; i++){
		    		  // ВТОРОЙ ВОПРОС
		    		  if(response.result[0].question_many[i].question2_clinic == 'Близко расположена к дому') {	$("#question2_1_clinic").prop("checked", true);} 
		    		  else{
		    			  if(response.result[0].question_many[i].question2_clinic == 'Здесь чисто и уютно, приятно находиться') { $("#question2_2_clinic").prop("checked", true);}
		    			  else{
		    				  if(response.result[0].question_many[i].question2_clinic == 'Здесь работают хорошие специалисты') {$("#question2_3_clinic").prop("checked", true);}
		    				  else{
		    					  if(response.result[0].question_many[i].question2_clinic == 'Большой спектр медицинских услуг') {$("#question2_4_clinic").prop("checked", true);}
		    					  else{
		    						  if(response.result[0].question_many[i].question2_clinic == 'Я прикреплен(а) к этой поликлинике, наблюдался(лась) здесь ранее') {$("#question2_5_clinic").prop("checked", true);}
		    						  else{
		    							  $("#question2_6_clinic").val(response.result[0].question_many[i].question2_clinic);
		    						  }
		    					  }
		    				  }
		    			  }
		    		  } 
		    		  //  ВОПРОС 6.1
		    		  if(response.result[0].question_many[i].question6_1_clinic == 'В регистратуре') {	$("#question6_1_1_clinic").prop("checked", true);}
		    		  else{
		    			  if(response.result[0].question_many[i].question6_1_clinic == 'По телефону') {	$("#question6_1_2_clinic").prop("checked", true);}
		    			  else{
		    				  if(response.result[0].question_many[i].question6_1_clinic == 'Через интернет (портал госуслуг)') {	$("#question6_1_3_clinic").prop("checked", true);}
		    				  else{
		    					  if(response.result[0].question_many[i].question6_1_clinic == 'Через информационные терминалы в поликлинике') {	$("#question6_1_4_clinic").prop("checked", true);}
		    					  else{
		    						  $("#question6_1_5_clinic").val(response.result[0].question_many[i].question6_1_clinic);
		    					  }
		    				  }
		    			  }
		    		  }
		    		  //  ВОПРОС 6.2
		    		  if(response.result[0].question_many[i].question6_2_clinic == 'В регистратуре') {	$("#question6_2_1_clinic").prop("checked", true);}
		    		  else{
		    			  if(response.result[0].question_many[i].question6_2_clinic == 'По телефону') {	$("#question6_2_2_clinic").prop("checked", true);}
		    			  else{
		    				  if(response.result[0].question_many[i].question6_2_clinic == 'Через интернет (портал госуслуг)') {	$("#question6_2_3_clinic").prop("checked", true);}
		    				  else{
		    					  if(response.result[0].question_many[i].question6_2_clinic == 'Через информационные терминалы в поликлинике') {	$("#question6_2_4_clinic").prop("checked", true);}
		    					  else{
		    						  $("#question6_2_5_clinic").val(response.result[0].question_many[i].question6_2_clinic);  
		    					  }
		    				  }
		    			  }
		    		  }
		    		  //  ВОПРОС 24  
		    		  if(response.result[0].question_many[i].question24_clinic == 'От медицинских работников') {	$("#question24_1_clinic").prop("checked", true);}
		    		  else{
		    			  if(response.result[0].question_many[i].question24_clinic == 'От сотрудников страховой компании') {	$("#question24_2_clinic").prop("checked", true);}
		    			  else{
		    				  if(response.result[0].question_many[i].question24_clinic == 'От сотрудников Фонда ОМС') {	$("#question24_3_clinic").prop("checked", true);}
		    				  else{
		    					  if(response.result[0].question_many[i].question24_clinic == 'От знакомых/родственников') {	$("#question24_4_clinic").prop("checked", true);}
		    					  else{
		    						  if(response.result[0].question_many[i].question24_clinic == 'из средств массовой информации') {	$("#question24_5_clinic").prop("checked", true);}
		    						  else{
		    							  if(response.result[0].question_many[i].question24_clinic == 'из информации для населения в медицинских организациях (стенды, брошюры,листовки)') {	$("#question24_6_clinic").prop("checked", true);}
		    							  else{
		    								  if(response.result[0].question_many[i].question24_clinic == 'из сети интернет') {	$("#question24_7_clinic").prop("checked", true);}
		    								  else{
		    									  if(response.result[0].question_many[i].question24_clinic == 'Я не знаю своих прав') {	$("#question24_8_clinic").prop("checked", true);}
		    									  else{
		    										  if(response.result[0].question_many[i].question24_clinic == 'Затрудняюсь ответить') {	$("#question24_9_clinic").prop("checked", true);}
		    										  else{
		    											  $("#question24_10_clinic").val(response.result[0].question_many[i].question24_clinic);
		    										  }
		    									  }
		    								  }
		    							  }
		    						  }
		    					  }
		    				  }
		    			  }
		    		  }
		    		  //  ВОПРОС 26  
		    		  if(response.result[0].question_many[i].question26_clinic == 'Администрация медицинской организации') {	$("#question26_1_clinic").prop("checked", true);}
		    		  else{
		    			  if(response.result[0].question_many[i].question26_clinic == 'Страховая компания, выдавшая полис ОМС') {	$("#question26_2_clinic").prop("checked", true);}
		    			  else{
		    				  if(response.result[0].question_many[i].question26_clinic == 'Фонд обязательного медицинского страхования') {	$("#question26_3_clinic").prop("checked", true);}
		    				  else{
		    					  if(response.result[0].question_many[i].question26_clinic == 'Органы управления здравоохранением') {	$("#question26_4_clinic").prop("checked", true);}
		    					  else{
		    						  if(response.result[0].question_many[i].question26_clinic == 'Гражданский суд') {	$("#question26_5_clinic").prop("checked", true);}
		    						  else{
		    							  if(response.result[0].question_many[i].question26_clinic == 'Затрудняюсь ответить') {	$("#question26_6_clinic").prop("checked", true);}
		    							  else{
		    								  $("#question26_7_clinic").val(response.result[0].question_many[i].question26_clinic);
		    							  }
		    						  }
		    					  }
		    				  }
		    			  }
		    		  }
		    		  // вопрос 28
		    		  if(response.result[0].question_many[i].question28_clinic == 'Не знал(а), куда обратиться') {	$("#question28_1_clinic").prop("checked", true);}
		    		  else{
		    			  if(response.result[0].question_many[i].question28_clinic == 'Решил(а), что пытаться бесполезно') {	$("#question28_2_clinic").prop("checked", true);}
		    			  else{
		    				  if(response.result[0].question_many[i].question28_clinic == 'Побоялся(лась) огласки') {	$("#question28_3_clinic").prop("checked", true);}
		    				  else{
		    					  if(response.result[0].question_many[i].question28_clinic == 'Не хотел(а) портить отношения с врачом') {	$("#question28_4_clinic").prop("checked", true);}
		    					  else{
		    						  $("#question28_5_clinic").val(response.result[0].question_many[i].question28_clinic);
		    					  }
		    				  }
		    			  }
		    		  }
		    		  // ВОПРОС 29
		    		  if(response.result[0].question_many[i].question29_clinic == 'Врачом оказана некачественная медицинская помощь') {	$("#question29_1_clinic").prop("checked", true);}
		    		  else{
		    			  if(response.result[0].question_many[i].question29_clinic == 'Врачом разглашена конфиденциальная информация о состоянии здоровья') {	$("#question29_2_clinic").prop("checked", true);}
		    			  else{
		    				  if(response.result[0].question_many[i].question29_clinic == 'Врачом не были назначены необходимые диагностические процедуры') {	$("#question29_3_clinic").prop("checked", true);}
		    				  else{
		    					  if(response.result[0].question_many[i].question29_clinic == 'Врачом не было назначено необходимое лечение') {	$("#question29_4_clinic").prop("checked", true);}
		    					  else{
		    						  if(response.result[0].question_many[i].question29_clinic == 'Врач не дал направление на обследование в другую медицинскую организацию') {	$("#question29_5_clinic").prop("checked", true);}
		    						  else{
		    							  if(response.result[0].question_many[i].question29_clinic == 'Врач  пытался  получить деньги за те услуги, которые должны быть оказаны бесплатно') {	$("#question29_6_clinic").prop("checked", true);}
		    							  else{
		    								  if(response.result[0].question_many[i].question29_clinic == 'Врач вел себя грубо, безразлично, невежливо') {	$("#question29_7_clinic").prop("checked", true);}
		    								  else{
		    									  $("#question29_8_clinic").val(response.result[0].question_many[i].question29_clinic);
		    								  }
		    							  }
		    						  }
		    					  }
		    				  }
		    			  }
		    		  }
		    		  // вопрос 31
		    		  if(response.result[0].question_many[i].question31_clinic == 'Не знал(а), куда обратиться') {	$("#question31_1_clinic").prop("checked", true);}
		    		  else{
		    			  if(response.result[0].question_many[i].question31_clinic == 'Решил(а), что пытаться бесполезно') {	$("#question31_2_clinic").prop("checked", true);}
		    			  else{
		    				   $("#question31_3_clinic").val(response.result[0].question_many[i].question31_clinic);
		    			  }
		    		  }
		    		  // вопрос 32
		    		  if(response.result[0].question_many[i].question32_clinic == 'в связи с переездом на новое место жительства') {	$("#question32_1_clinic").prop("checked", true);}
		    		  else{
		    			  if(response.result[0].question_many[i].question32_clinic == 'из-за неудобного режима работы') {	$("#question32_2_clinic").prop("checked", true);}
		    			  else{
		    				  if(response.result[0].question_many[i].question32_clinic == 'из-за плохих санитарно-гигиенических условий') {	$("#question32_3_clinic").prop("checked", true);}
		    				  else{
		    					  if(response.result[0].question_many[i].question32_clinic == 'в  связи  с  недостаточным  спектром  медицинских  услуг  (анализы, узи, флюорография, рентген и т.д.)') {	$("#question32_4_clinic").prop("checked", true);}
		    					  else{
		    						  if(response.result[0].question_many[i].question32_clinic == 'из-за недостаточно квалифицированного медицинского персонала') {	$("#question32_5_clinic").prop("checked", true);}
		    						  else{
		    							  $("#question32_6_clinic").val(response.result[0].question_many[i].question32_clinic);
		    						  }
		    					  }
		    				  }
		    			  }
		    		  }
		    		  
		    		  
		    	  }
		    	 // пробегаемся по модальному окну формы редактирования/заполнения  и делаем не активными вопросы которые пропускаются
		    	  testclic();
		    	  
		    	  if($("#question15").val() == 'Нет (к вопросу 18)') $(".del15").css({'opacity':0.4,'pointer-events':'none'});
		    	  if($("#question21").val() == 'Нет (к вопросу 23)') $(".del21").css({'opacity':0.4,'pointer-events':'none'});
		    	  
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
*
*   АНКЕТА ВТОРОГО УРОВНЯ ДНЕВНОЙ СТАЦИОНАР
*
*
*
*/

function secondlevelds(varr) {
	
	
	//if(	validateSecondClinic()){  $(".errorSecondClinic").css('display','block');	}else{}
	
						var general = {}
						var sec1 = {}
						var sec2 = {}
						var question25 = {}
						var question15 = {}
						//var many = {}
						
						general["moSecondleveldaystacionar"] = $("#moSecondleveldaystacionar").val();
						general["dataRespSecondleveldaystacionar"] = $("input[name='dataRespDSSL']").val();
						general["questionDS1"] = $("#questionDS1").val();
						
						sec2["question7sec2"] = $("#question7sec2").val();
						sec1["question8sec1"] = $("#question8sec1").val();
						question15["question15_1_clinic"] = $("#question15_1_clinic").val();
						question25["question25_1"] = $("#question25_1").val();
						
						
						
						general["polzSecondleveldaystacionar"] = $("#polzSecondleveldaystacionar").val();
						
						// после нажатия добавить -> зачищаются периоды для кнопки выбрать
						//$("input[name='namedateBeginsecondlevel']").val('');
						//$("input[name='namedateEndsecondlevel']").val('');
						
						/*
						 * После того как была нажато редактирование и вылезло модальное с данными по редактированию ловим
						 * id этой записи. Если же была нажата просто кнопка "добавить запись" то if не отрабатывает и новая
						 * запись улетает с null id там он генериться тк запись новая.
						 * 
						 * Обрати внимание после отработки этого ajax поле input #id зануляется
						 * иначе при добавлении новой записи этот айдишник постоянно будет и соответственно не добавляться будет а 
						 * редактироваться по этому id
						 */
						if($("#idDSSL").val()){ 	general["id"] = parseInt($("#idDSSL").val());}
						
						//$('#cancelSecondClinic').trigger('click');
						//+ отрабатывает метод в other.js
						
						var sender = ({ survay1:general, survay2:sec1,survay3:sec2,survay4:question15,survay5:question25}); 
						
				
						$.post('adddssl',JSON.stringify(sender),function(response)
    	      	                {
								    	  
								      
    	      	                	console.log('test OK');
        	      	            },'json')
        	      	          	.error(function(msg) {console.log('test BAD'); $("#idDSSL").val('');});
					
						
	}	


