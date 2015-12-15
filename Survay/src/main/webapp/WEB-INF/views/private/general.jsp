<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page session="false"%>
<!doctype html>
<html lang="ru">
<head>
<meta charset="utf-8">
<title>Главная</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/1.11.2/themes/smoothness/jquery-ui.css">

<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/1.11.2/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>







<script type="text/javascript">

$(document).ready(function()
{ 
	$( "#dateBegin" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#datePartOneClinic" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEnd" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateBeginAppealPay" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndAppealPay" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateBeginConsultOther" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndConsultOther" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateBeginCountDetail" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndCountDetail" ).datepicker({dateFormat:'dd.mm.yy'});
	
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
});
</script>
</head>
<body>
<div class="conteinerHeader">
					 <nav class="navbar navbar-default navbar-inverse" role="navigation">
			    <div class="container-fluid">
			        <!-- Brand and toggle get grouped for better mobile display -->
			        <div class="navbar-header">
			            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			                <span class="sr-only">Toggle navigation</span>
			                <span class="icon-bar"></span>
			                <span class="icon-bar"></span>
			                <span class="icon-bar"></span>
			            </button>
			        </div>
			
			        <!-- Collect the nav links, forms, and other content for toggling -->
			        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			            <ul class="nav navbar-nav">
			            <li><a href="#">Выборка</a></li>
			                <li class="dropdown">
			                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Анкеты первого уровня <span class="caret"></span></a>
			                    <ul class="dropdown-menu" role="menu">
			                        <li><a href="#" id="one_ambul_pol">Амбул-полик помощь</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#" id="one_day">Дневной стационар</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#" id="one_stac">Стационар</a></li>
			                        
			                    </ul>
			                </li>
			                
			                <li class="dropdown">
			                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Анкеты второго уровня <span class="caret"></span></a>
			                    <ul class="dropdown-menu" role="menu">
			                        <li><a href="#">Action</a></li>
			                        <li><a href="#">Another action</a></li>
			                        <li><a href="#">Something else here</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#">Separated link</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#">One more separated link</a></li>
			                    </ul>
			                </li>
			                
			                <li class="dropdown">
			                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Отчеты <span class="caret"></span></a>
			                    <ul class="dropdown-menu" role="menu">
			                        <li><a href="#">Action</a></li>
			                        <li><a href="#">Another action</a></li>
			                        <li><a href="#">Something else here</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#">Separated link</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#">One more separated link</a></li>
			                    </ul>
			                </li>
			            </ul>
			            <ul class="nav navbar-nav navbar-right">
			                <li class="dropdown">
			                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Пользователь</b> <span class="caret"></span></a>
			                    <ul id="login-dp" class="dropdown-menu">
			                        <li>
			                            <div class="row">
			                                <div class="col-md-12">
			                                    <div class="social-buttons">
			                                        <a href="#" class="btn btn-tw">Информация для пользователя</a>
			                                    </div>
			                                        <div class="form-group">
			                                           	<a href="#"><b>Главная</b></a><br>
			                                           	<a href="j_spring_security_logout"><b>Выход</b></a><br>
			                                           	<a href="#"><b>Написать администратору</b></a><br><br>
			                                        </div>
			                                </div>
			                                <div class="bottom text-center">
			                                	<sec:authentication var="principal" property="principal" />
			                                    Вы вошли как: <a href="#"><b>${principal.username}</b></a>
			                                </div>
			                            </div>
			                        </li>
			                    </ul>
			                </li>
			            </ul>
			        </div>
			        <!-- /.navbar-collapse -->
			    </div>
			    <!-- /.container-fluid -->
			</nav>

<div id="dim">
			<div class="msgbox">
				<!-- 	<a class="close" href="#" ><img src="close.jpg"/></a>  -->
				<div class="msgboxp">
					<h4 id="shadow_oneclinic">Анкета первого уровня амбулаторно-поликлинической помощи</h4>
				</div>
			</div>
			
			<div class="col-xs-4" style="position: absolute; left:35%;">
			<TABLE>
				<TR> 
					<TD style="padding-right:15px;">
						<input  class="form-control"  aria-describedby="sizing-addon3" id="dateBegin1" placeholder="">
					</TD>
					<td style="padding-right:15px;">
     					<input  class="form-control"  aria-describedby="sizing-addon3" id="dateEnd" placeholder="">
     				</td>
     				<td style="padding-right:15px;">
     					<button class="btn btn-success" id="">Выбрать</button>
     				</td>
     				<td>
     					<button class="btn btn-success" id="" data-toggle="modal" data-target="#myModal">Добавить запись</button>
     				</td>
     			</TR>
     		</TABLE>
			</div>
			
			
			
</div>
<div id="dim2">
			<div class="msgbox2">
				<!-- 	<a class="close" href="#" ><img src="close.jpg"/></a>  -->
				<div class="msgboxp2">
					<h4 id="shadow_oneclinic2">Анкета первого уровня дневного стационара</h4>
				</div>
			</div>
		</div>		
<div id="dim3">
			<div class="msgbox3">
				<!-- 	<a class="close" href="#" ><img src="close.jpg"/></a>  -->
				<div class="msgboxp3">
					<h4 id="shadow_oneclinic3">Анкета первого уровня стационарной помощи</h4>
				</div>
			</div>
		</div>		
</div> <!-- <div class="conteinerHeader"> -->

<!-- Добавить запись (модальное окно) -->
					<div class="modal fade" id="myModal" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button btn-primary" class="close"
										data-dismiss="modal" aria-hidden="true">&times;</button>
									<h3 class="modal-title">Добавить анкету первого уровня</h3>
									<p>Добавление анкеты  амбулаторно-поликлинической помощи</p>

								</div>
					<form method="post" action="addClinic">			
								<div class="modal-body">
									<div>Укажите медицинское учреждение где проходил опрос</div>
								    <div class="col-xs-4">
								      <form:select class="form-control input-sm" path="" name="">
								        <form:option value="0" label="" />
    									<form:options items="${moList}"/>
								      </form:select>
								    </div><br><br>
								    
								    
								    <div>Укажите дату проведения опроса в данном мед учреждении</div>
								    <div class="col-xs-4">
								      <input  class="form-control"  aria-describedby="sizing-addon3" id="datePartOneClinic" placeholder="">
								    </div><br><br>
								    								
									<p>1.	Оцените уровень вашей  удовлетворенности следующими характеристиками работы поликлиники:</p>
									<div>Насколько Вы удовлетворены качеством бесплатной медицинской помощи, получаемой в поликлинике</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
		 						    
								    <div>Техническим состоянием, ремонтом помещений:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Оснащенностью современным медицинским оборудованием:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Организацией записи на прием к врачу:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Временем ожидания приема врача:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Сроками ожидания медицинских услуг после записи:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div>Доступностью необходимых лабораторных исследований/анализов:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Доступностью диагностических исследований (ЭКГ, УЗИ и т.д.):</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Доступностью мед.помощи терапевтов:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Доступностью мед.помощи врачей-специалистов:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Работой врачей в поликлинике:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    
									<div><p>2.	Приходилось ли вам лично (для себя) за последние 3 месяца обращаться куслугам скорой медицинской помощи?</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Да</option>
								        <option>Нет -к вопросу 4</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div><p>3.	На сколько вы удовлетворены качеством оказанной вам скорой медицинскойпомощи?</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div><p>4.	Пол респондента:</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Мужской</option>
								        <option>Женский</option>
								      </select>
								    </div><br><br>
								    
								    <div><p>5.	Возраст респондента:</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="">
								        <option>Доработать</option>
								      </select>
								    </div><br><br>
								    
								</div>
								<div class="modal-footer">
								<button type="button" class="btn btn-primary" data-dismiss="modal">Отмена</button>
									<button type="submit" class="btn btn-success">Добавить анкету</button>
								</div>
							</div>
						</div>
					</div>
					</form>		
<!-- конец Добавить запись (модальное окно) -->



<c:forEach var="p" items="${oneclinic}">
    Id: ${p.id} Name: ${p.dataInput} Name: ${p.freeHelp}<br/>
  </c:forEach>
  
<!-- <h1>Add New</h1>
  <form method="post" action="addClinic">
  Name: <input type="text" name="freeHelp"/>
  <button>Add</button>
  </form>  -->  
</body>
</html>