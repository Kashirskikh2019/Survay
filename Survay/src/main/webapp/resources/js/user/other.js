		// выпадающей input в вопросе на условие напишите другое
	   $("#questionDS1").click(function()
		{
		    	  if($(this).val() == 'Другое (напишите)')
		    	  {
		    		  //$('#questionDS1dr').css('display', 'block');
		    		  $('#questionDS1dr').fadeIn();
		    	  }
		    	  else{
		    		  $('#questionDS1dr').val(''); $('#questionDS1dr').fadeOut();}
		   
		});
	   
	   // выпадающей input в вопросе на условие напишите другое
	   $("#questionDS2").click(function()
		{
		    	  if($(this).val() == 'Другое (напишите)')
		    	  {
		    		  $('#questionDS2dr').fadeIn();
		    	  }
		    	  else{
		    		  $('#questionDS2dr').val(''); $('#questionDS2dr').fadeOut();}
		   
		});
	   
		// выпадающей input в вопросе на условие напишите другое
	   $("#questionDS3").click(function()
		{
		    	  if($(this).val() == 'Другое (напишите)')
		    	  {
		    		  $('#questionDS3dr').fadeIn();
		    	  }
		    	  else{
		    		  $('#questionDS3dr').val(''); $('#questionDS3dr').fadeOut();}
		   
		});

	   // кнопка отмена (при отмене на модальном окне поликлиника второй уровень)

	   $("#cancelCSL").click(function()
		{
		   // зачищаем селекты
		   var $form = $('#formClinicSecondLevel') 
		      $('select', $form).each(function() {
		       //$(this).prop('defaultSelected');
		    	  $(this).val('');
		      });	
		   // 	зачищаем чекбоксы
		   $('#formClinicSecondLevel input:checkbox').each(function(){
				 $(this).prop('checked', false);
		   })
		   // 	зачищаем ипут текст			   
		   $('#formClinicSecondLevel input:text').each(function(){
				 
				 $(this).val('');
		   })   
		   
		   $("input[name='dataRespNSecondLevel']").val('');
		   $(".errorSecondClinic").css('display','none');
		   $("#idClinicSecondLevel").val('');
		   
		});

	   
	   // кнопка отмена (при отмене на модальном окне ДС второй уровень)

	   $("#cancelDSSL").click(function()
		{
		   // зачищаем селекты
		   var $form = $('#formDSSL') 
		      $('select', $form).each(function() {
		    	  $(this).val('');
		      });	
		   // 	зачищаем чекбоксы
		   $('#formDSSL input:checkbox').each(function(){
				 $(this).prop('checked', false);
		   })
		   // 	зачищаем ипут текст			   
		   $('#formDSSL input:text').each(function(){
				 
				 $(this).val('');
		   })
		   
		   $('#questionDS1dr').fadeOut();
		   
		   $("input[name='dataRespDSSL']").val('');
		   $(".errorOneClinic").css('display','none');
		   $("#idDSSL").val('');
		   
		});


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
			   
			   $( "#ansFormOnePart1" ).prop( "checked", false );
			   $( "#ansFormOnePart2" ).prop( "checked", false );
			   $( "#ansFormOnePart3" ).prop( "checked", false );
			   $( "#ansFormOnePart4" ).prop( "checked", false );
			   $( "#ansFormOnePart5" ).prop( "checked", false );
			   
			   $("#btnsf").attr("disabled", false);
			     
			   $("input[name='datebeginonereport']").val('');
			   $("input[name='dateendonereport']").val('');
			   
			   $( "#lpuFormOneRerort" ).val($("#lpuFormOneRerort").prop('defaultSelected'));
			   
			   
			   $('#dateBeginOneReport-error').hide();
			   $('#dateEndOneReport-error').hide();
			   $('#lpuFormOneRerort-error').hide();
			   $('#ans-error').hide();
			   $('#org-error').hide();
			  
			   
			   
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
	   
	   /*
	    * Метод обновляет запись в модальном окне второго уровня
	    * с режима редактирования в режим добавления
	    */
	   function levelsecond() {
	   	$('#myModalClinicSecondLevel .modal-title').text('Добавить анкету второго уровня');
	   	$('.renamebtn').text('Добавить анкету');
	   	//$('#myModal1 .modal-title').text('Добавить анкету второго уровня');
	   	//$('#myModal2 .modal-title').text('Добавить анкету второго уровня');
	   }
	   
	   /*
	    * Метод обновляет запись в модальном окне второго уровня ДС
	    * с режима редактирования в режим добавления
	    */
	   function levelseconddssl() {
		   
	   	$('#myModal1secondlevel .modal-title').text('Добавить анкету второго уровня');
	   	$('.modal-header p').text('Добавление анкеты дневного стационара');
    	$('.renamebtndssl').text('Добавить');
    	$('#questionDS1dr').fadeOut();
    	$('#questionDS2dr').fadeOut();
    	$('#questionDS3dr').fadeOut();
    	
	   }
	   
	   