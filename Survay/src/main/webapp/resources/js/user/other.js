// кнопка отмена (при отмене на модальном окне анкеты)
	   $("#cancelOneDayStacionar,.close").click(function()
		{
		   var $form = $('#form2') 
		      $('select', $form).each(function() {
		        $(this).val($(this).prop('defaultSelected'));
		      });	

		   $("input[name='dataRespDS']").val('');
		   $(".errorOneClinic").css('display','none');
		   $("#idoneDayStac").val('');
		   
		});
	   
	// кнопка отмена (при отмене на модальном окне анкеты)
	   $("#cancelOneStac,.close").click(function()
		{
		   var $form = $('#form3') 
		      $('select', $form).each(function() {
		        $(this).val($(this).prop('defaultSelected'));
		      });	

		   $("input[name='dataonestac']").val('');
		   $(".errorOneClinic").css('display','none');
		   $("#idoneStac").val('');
		   
		});
		
		// кнопка закрыть окно (окно отчетов певого уровня)
		   $("#closereportonepart,.close").click(function()
			{
			   $( "#oneTFOMS" ).prop( "checked", false );
			   $( "#oneSimaz" ).prop( "checked", false );
			   $( "#oneIngos" ).prop( "checked", false );
			   $( "#oneRosno" ).prop( "checked", false );
			   $("#btnsf").attr("disabled", false);
			     
			   $("input[name='datebeginonereport']").val('');
			   $("input[name='dateendonereport']").val('');
			   
			   
			});
	   
	   // кнопка отмена (при отмене на модальном окне анкеты)
	   $("#cancelOneClinic,.close").click(function()
		{
		   var $form = $('#form1') 
		      $('select', $form).each(function() {
		        $(this).val($(this).prop('defaultSelected'));
		      });	

		   $("input[name='dataRespN']").val('');
		   $(".errorOneClinic").css('display','none');
		   $("#id").val('');
		   
		});
	   
	   
	// ловим нажите на отблекс логотипа
	   function shine()
	   {
	   	$(".mask a").css("background-position", "10px 0");
	   	$(".mask a").css({transition: 'all 8s'});
	   	
	   	//setTimeout("$('.mask a').removeAttr('style');",11000);
	   	setTimeout("$('.mask a').css('background-position','');$('.mask a').css({transition: ''});",11000);
	   	
	   }
	   
   /*
    * Метод проверяет на заполненость всей формы ОТЧЕТА ПЕРВОГО УРОВНЯ ИНДИКАТОР ДОСТУПНОСТИ КАЧЕСТВА
    */
	   /*   function validateOneReportAvalible()
   {
	   
   	if(	($("#oneFirstKv").val()||
   	   !$("#oneSecondKv").val()||
   	   !$("#oneTreeKv").val()||
   	   !$("#oneFourKv").val()||
   	   
   	   
   	   !$("#oneTFOMS").val()||
   	   !$("#oneSimaz").val()||
   	   !$("#oneIngos").val()||
   	   !$("#oneRosno").val() return true;
   	
   		else return false;
   }	   
*/