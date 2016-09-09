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
	search["ans4"] = $("#ansFormOnePart4").is(':checked')
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
								document.location.href = '/survay/download'
								 	
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

/*
 * Метод отправляет данные на сервер с формы отчетов второго уровня поликлиника 
 * 
 */
function secondpartreportsbigc(buttonId) {

	var values = {} , org = [] , ans = [], sc2=0 ,  sc = 0;
	
	$.each($("#formslcbReport").serializeArray(), function (i, field) {
	    if(field.name.indexOf('org[]')>=0){
	    	org[sc] = field.value;
	    	sc++;
	    }
	    else{
	    	if(field.name.indexOf('ans[]')>=0){
		    	ans[sc2] = field.value;
		    	console.log('@@@@@@@@@@@@@@ '+field.value);
		    	sc2++;
		    }else{
	        	values[field.name] =field.value;
	        }
	    	
	    }
	    
	});
	values['org'] = org;
	values['ans'] = ans;
	
	$.ajax({
		url : 'slcbPartTwoReport',
		type: 'Post',
		dataType: 'json',
		data : JSON.stringify(values),
		contentType: 'application/json',
	    mimeType: 'application/json',
							success: function(data)
							{
								console.log('YPPPPPPPPPPA');
								// pass to controller
								document.location.href = '/survay/report_big_clinic'
								 	
						/*		$("input[name='datebeginonereport']").val('');
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
								obj.disabled = false;*/
						    },
						  
							    error: function(e){  
							      alert('Произошла ошибка обновите станицу'); 
							     
							    }		    
	});
	
	
	
}

/*
 * Метод отправляет данные на сервер с формы отчетов второго уровня дс
 * 
 */
function secondpartreportsbigds(buttonId) {

	var values = {} , org = [] , ans = [], sc2=0 ,  sc = 0;
	
	$.each($("#formsldsbReport").serializeArray(), function (i, field) {
	    if(field.name.indexOf('org[]')>=0){
	    	org[sc] = field.value;
	    	sc++;
	    }
	    else{
	    	if(field.name.indexOf('ans[]')>=0){
		    	ans[sc2] = field.value;
		    	sc2++;
		    }else{
	        	values[field.name] =field.value;
	        }
	    	
	    }
	    
	});
	values['org'] = org;
	values['ans'] = ans;
	
	
	$.ajax({
		url : 'sldsbPartTwoReport',
		type: 'Post',
		dataType: 'json',
		data : JSON.stringify(values),
		contentType: 'application/json',
	    mimeType: 'application/json',
							success: function(data)
							{
								console.log('YPPPPPPPPPPA');
								// pass to controller
								document.location.href = '/survay/report_big_ds'
								 	
							/*	$("input[name='datebeginonereport']").val('');
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
								obj.disabled = false;*/
						    },
						  
							    error: function(e){  
							      alert('Произошла ошибка обновите станицу'); 
							     
							    }		    
	});
	
	
	
}

/*
 * Метод отправляет данные на сервер с формы отчетов второго уровня стационар
 * 
 */
function secondpartreportsbigs(buttonId) {

	var values = {} , org = [] , ans = [], sc2=0 ,  sc = 0;
	
	$.each($("#formslsbReport").serializeArray(), function (i, field) {
	    if(field.name.indexOf('org[]')>=0){
	    	org[sc] = field.value;
	    	sc++;
	    }
	    else{
	    	if(field.name.indexOf('ans[]')>=0){
		    	ans[sc2] = field.value;
		    	sc2++;
		    }else{
	        	values[field.name] =field.value;
	        }
	    	
	    }
	    
	});
	values['org'] = org;
	values['ans'] = ans;
	
	console.log(JSON.stringify(values));
	
	$.ajax({
		url : 'slsbPartTwoReport',
		type: 'Post',
		dataType: 'json',
		data : JSON.stringify(values),
		contentType: 'application/json',
	    mimeType: 'application/json',
							success: function(data)
							{
								console.log('YPPPPPPPPPPA');
								// pass to controller
								document.location.href = '/survay/report_big_s'
								 	
							/*	$("input[name='datebeginonereport']").val('');
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
								obj.disabled = false;*/
						    },
						  
							    error: function(e){  
							      alert('Произошла ошибка обновите станицу'); 
							     
							    }		    
	});
	
	
	
}

function twopartreports(buttonId) {
	
	var search = {}
	
	search["datestart"] = $("input[name='datebegintworeport']").val();
	search["dateend"] = $("input[name='dateendtworeport']").val();
	
	search["lpu"] = $("#lpuFormTwoRerort").val();ansFormOnePart1
	
	search["ans1"] = $("#ansFormTwoPart1").is(':checked')
	search["ans2"] = $("#ansFormTwoPart2").is(':checked')
	search["ans3"] = $("#ansFormTwoPart3").is(':checked')
	search["ans4"] = $("#ansFormTwoPart4").is(':checked')
	search["ans5"] = $("#ansFormTwoPart5").is(':checked')
	
	
	search["onefoms"] = $("#twoTFOMS").is(':checked')
	search["onesimaz"] = $("#twoSimaz").is(':checked')
	search["oneingos"] = $("#twoIngos").is(':checked')
	search["onerosno"] = $("#twoRosno").is(':checked')
	
	var obj = document.getElementById(buttonId);
	if (obj) {obj.disabled = true;} 
	
	console.log($("input[name='datebegintworeport']").val()+'   '+$("input[name='dateendtworeport']").val());
	$.ajax({
		url : 'secondPartReport',
		type: 'Post',
		dataType: 'json',
		data : JSON.stringify(search),
		contentType: 'application/json',
	    mimeType: 'application/json',
							success: function(data)
							{
								// pass to controller
								document.location.href = '/survay/download'
								 	
								$("input[name='datebegintworeport']").val('');
								$("input[name='dateendtworeport']").val('');
								
								$( "#twoTFOMS" ).prop( "checked", false );
								$( "#twoSimaz" ).prop( "checked", false );
								$( "#twoIngos" ).prop( "checked", false );
								$( "#twoRosno" ).prop( "checked", false );
								
								$( "#ansFormTwoPart1" ).prop( "checked", false );
								$( "#ansFormTwoPart2" ).prop( "checked", false );
								$( "#ansFormTwoPart3" ).prop( "checked", false );
								$( "#ansFormTwoPart4" ).prop( "checked", false );
								$( "#ansFormTwoPart5" ).prop( "checked", false );
								
								$( "#lpuFormTwoRerort" ).val($("#lpuFormTwoRerort").prop('defaultSelected'));
								obj.disabled = false;
						    },
						  
							    error: function(e){  
							      alert('Произошла ошибка обновите станицу'); 
							     
							    }		    
	});
}




