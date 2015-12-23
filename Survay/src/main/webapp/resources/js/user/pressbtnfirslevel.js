/*
 * Модуль обрабатывает различные комбинации между нажатиями на кнопки в подменю АНКЕТЫ ПЕРВОГО УРОВНЯ
 * 
 */
// Кнопка амбул-полик помощь
	   $('#one_ambul_pol').click(function()
               {  
		   			if ($('#dim').is(':visible'))
    	    		{
		   				$("#dim").fadeOut();
    	    		}
		   			else
		   			{
		   				if ($('#dim2,#dim3').is(':visible')){	$("#dim2").fadeOut();$("#dim3").fadeOut();	}
		   				var widthGet = $('.container-fluid').width();
		    	        var heightGet = $(window).height();
		    	        
		    	        $('#dim').width(widthGet-20);
	    	            $('#dim').height(heightGet-300);
	    	            $('#fgf').height(heightGet-440);
	    	            setTimeout("$('#dim').fadeIn();",500);
		   			}
  	     		 	
               });
	   
		// Кнопка дневной стационвр
	   $('#one_day').click(function()
               {  
		   			if ($('#dim2').is(':visible'))
    	    		{
		   				$("#dim2").fadeOut();
    	    		}
		   			else
		   			{
		   				if ($('#dim,#dim3').is(':visible')){	$("#dim").fadeOut();$("#dim3").fadeOut();	}
		   				var widthGet = $('.container-fluid').width();
		    	        var heightGet = $(window).height();
		    	        
		    	        $('#dim2').width(widthGet-20);
	    	            $('#dim2').height(heightGet-300);
	    	            setTimeout("$('#dim2').fadeIn();",500);
		   			}
  	     		 	
               });
	   
		// Кнопка станионар
	   $('#one_stac').click(function()
               {  
		   			if ($('#dim3').is(':visible'))
    	    		{
		   				$("#dim3").fadeOut();
    	    		}
		   			else
		   			{
		   				if ($('#dim2,#dim').is(':visible')){	$("#dim2").fadeOut();$("#dim").fadeOut()	}
		   				
		   				
		   				var widthGet = $('.container-fluid').width();
		    	        var heightGet = $(window).height();
		    	        
		    	        $('#dim3').width(widthGet-20);
	    	            $('#dim3').height(heightGet-300);
	    	            setTimeout("$('#dim3').fadeIn();",500);
		   			}
  	     		 	
               });