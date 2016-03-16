		

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

/*
 *  Метод обрабатывает нажатие клавиши добавить запись (Добавление анкеты) и обновляет список из базы
 *  с уже добаленной записью
 * 
 */
function secondlevelclinictest(varr) {
	
	//if(	validateSecondClinic()){  $(".errorSecondClinic").css('display','block');	}else{}
	
						var general = {}
						var sec1 = {}
						var sec2 = {}
						var question25 = {}
						var many = {}
						
						general["moSecondlevel"] = $("#moSecondLevel").val();
						general["dataRespSecondlevel"] = $("input[name='dataRespNSecondLevel']").val();
						general["visitClinicSecondlevel"] = $("#visitClinicSecondLevel").val();
						many["question2_clinic"] = $("#question2_clinic").val();
						sec1["replacementClinicSecondlevel"] = $("#replacementClinicSecondLevel").val();
						sec2["question12_clinic"] = $("#question12_clinic").val();
						question25["question25_1_clinic"] = $("#question25_1_clinic").val();
						general["sexSecondlevel"] = $("#sexSecondLevelClinic").val();
						general["ageSecondlevel"] = $("#SecondLevelClinic").val();
						
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
						
						console.log('generalmod '+sender.survay1);
				
						$.post('addsecondclinic',JSON.stringify(sender),function(res)
    	      	                {
    	      	                	
    	      	                	console.log('test OK');
        	      	            },'json')
        	      	          	.error(function(msg) {console.log('test BAD');});
						
						
	}	

function secondlevelclinic(varr) {
	
	//if(	validateSecondClinic()){  $(".errorSecondClinic").css('display','block');	}else{}
	
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
						
						general["sexSecondlevel"] = $("#sexSecondLevelClinic").val();
						general["ageSecondlevel"] = $("#SecondLevelClinic").val();
						
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
						
				
						$.post('addsecondclinic',JSON.stringify(sender),function(res)
    	      	                {
    	      	                	
    	      	                	console.log('test OK');
        	      	            },'json')
        	      	          	.error(function(msg) {console.log('test BAD');});
						
						
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



