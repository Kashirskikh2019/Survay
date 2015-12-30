<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page session="false"%>
<!doctype html>
<html lang="ru">
<head>
<meta charset="utf-8">
<title>Главная</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tableoneClinic.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shine.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/1.11.2/themes/smoothness/jquery-ui.css">

<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/1.11.2/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>

<sec:authentication var="principal" property="principal" />




<script type="text/javascript">
// ловим нажите на отблекс логотипа
function shine()
{
	$(".mask a").css("background-position", "10px 0");
	$(".mask a").css({transition: 'all 8s'});
	
	//setTimeout("$('.mask a').removeAttr('style');",11000);
	setTimeout("$('.mask a').css('background-position','');$('.mask a').css({transition: ''});",11000);
	
}

function doAjax() {
	
	var inputText = $("#input_str").val(); 
	
	$.ajax({
		url : 'getCharNum',
		type: 'GET',
		dataType: 'json',
		contentType: 'application/json',
	    mimeType: 'application/json',
		data : ({
			text: inputText
		}),
		success: function (data) {	
			
			var result = '"'+data.text+'", '+data.count+' characters';
			$("#result_text").text(result);
		}
	});
} 


$(document).ready(function()
{ 
	$(this).click(function(){ shine(); });
	var user = '${principal.username}';
	console.log('log '+ user);
	
	$( "#dateBegin" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#datePartOneClinic" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEnd" ).datepicker({dateFormat:'dd.mm.yy'});
		
		
	   // кнопка отмена (при отмене на модальном окне анкеты)
	   $("#cancelOneClinic").click(function()
		{
		   var $form = $('#form1') 
		      $('select', $form).each(function() {
		        $(this).val($(this).prop('defaultSelected'));
		      });	
		//   $('input', $form).each(function() {
		  //      $(this).val($(this).prop('defaultSelected'));
		    //  });	
		   $("input[name='dataRespN']").val('');
		   $(".errorOneClinic").css('display','none');
		   $("#id").val('');
		   
		});

});
</script>
</head>
<body>
<!-- <div><img src="${pageContext.request.contextPath}/resources/image/logo.png"  style="width:40%;height:50%;margin-left:50px;margin-top:15px;"></div> --> 
<div class="mask pseudo"><a href="#" style="margin-top:20px;margin-left:50px;margin-bottom:0px;"><img src="${pageContext.request.contextPath}/resources/image/logo.png"/></a></div>
<svg height="0">
  <!-- THE mask -->
  <mask id="mask-firefox">
    <image width="150" height="64" xlink:href="http://dev.iamvdo.me/newLogoCSS3create2.png" filter="url(#filter)" /> 
  </mask>
  
  <!-- the filter to make the image white -->
  <filter id="filter">
    <feFlood flood-color="white" />
    <feComposite in2="SourceAlpha" operator="in" />
  </filter>
</svg>
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
			            <li><a href="#"><i class="fa fa-warning faa-flash animated-hover"></i>&nbsp;&nbsp;Выборка</a></li>
			                <li class="dropdown">
			                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-list-alt "></i>&nbsp;&nbsp;Анкеты первого уровня <span class="caret"></span></a>
			                    <ul class="dropdown-menu" role="menu">
			                        <li><a href="#" id="one_ambul_pol" onclick="alloneclinic('${principal.username}')"><i class="fa fa-ambulance"></i>&nbsp;&nbsp;Амбул-полик помощь</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#" id="one_day"><i class="fa fa-medkit"></i>&nbsp;&nbsp;Дневной стационар</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#" id="one_stac"><i class="fa fa-stethoscope"></i>&nbsp;&nbsp;Стационар</a></li>
			                        
			                    </ul>
			                </li>
			                
			                <li class="dropdown">
			                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-align-right"></i>&nbsp;&nbsp;Анкеты второго уровня <span class="caret"></span></a>
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
			                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-book"></i>&nbsp;&nbsp;Отчеты <span class="caret"></span></a>
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
			
			<div  style="position: absolute; left:35%;">
			<TABLE>
				<TR> 
					<TD style="padding-right:15px;">
						<input  class="form-control"  aria-describedby="sizing-addon3" id="dateBegin" placeholder="">
					</TD>
					<td style="padding-right:15px;">
     					<input  class="form-control"  aria-describedby="sizing-addon3" id="dateEnd" placeholder="">
     				</td>
     				<td style="padding-right:15px;">
     					<button class="btn btn-success" id="getqueryoneclinic" onclick="oneclinicbetween('${principal.username}')">Выбрать</button>
     				</td>
     				<td>
     					<button class="btn btn-success" id="addOneClinic" data-toggle="modal" data-target="#myModal" onclick="oneLevel()">Добавить запись</button>
     				</td>
     			</TR>
     		</TABLE>
			</div><br><br>
<div id="fgf"style="overflow-y: scroll; height:100px; margin-top:35px;">			
			<table id="records_table" class="table table-striped" style="margin:0px auto; width:85%;"></table>
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
					<div class="cmxform" id="form1" >			
								<div class="modal-body">
									<div>Укажите медицинское учреждение где проходил опрос</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="mo" title="Введите лечебное учреждение">
								        <option value=""></option>
								        <c:forEach var="ls" items="${listmo}">
								        <option>${ls.value}</option>
								        </c:forEach>
								      </select>
								    </div><br><br>
								    
								    
								    <div>Укажите дату проведения опроса в данном мед учреждении</div>
								    <div class="col-xs-4">
								      <input  class="form-control"  aria-describedby="sizing-addon3" id="datePartOneClinic" name="dataRespN" placeholder="">
								    </div><br><br>
								    								
									<p>1.	Оцените уровень вашей  удовлетворенности следующими характеристиками работы поликлиники:</p>
									<div>Насколько Вы удовлетворены качеством бесплатной медицинской помощи, получаемой в поликлинике</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="freeHelp" title="Введите качество удовлетворенности бесплатной мед помощи">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
		 						    
								    <div>Техническим состоянием, ремонтом помещений:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="repairs" title="Введите удовлетворенность техническим состоянием">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Оснащенностью современным медицинским оборудованием:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="equipment" title="Введите удовлетворенность оснащенностью мед оборудованием">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Организацией записи на прием к врачу:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="seeADoctor" title="Введите удовлетворенность организации записи на прием к врачу">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Временем ожидания приема врача:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="waitingTime" title="Введите удовлетворенность временем ожидания">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Сроками ожидания медицинских услуг после записи:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="waitingTime2" title="Введите удовлетворенность сроками ожидания после записи">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div>Доступностью необходимых лабораторных исследований/анализов:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="laboratoryResearch" title="Введите удовлетворенность доступностью необходимыми лабораторными исследованиями или анализами">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Доступностью диагностических исследований (ЭКГ, УЗИ и т.д.):</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="diagnosticTests" title="Введите удовлетворенность доступностью диагностическими исследованиями">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Доступностью мед.помощи терапевтов:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="therapist" title="Введите удовлетворенность мед помощью терапевтов">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Доступностью мед.помощи врачей-специалистов:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="medicalSpecialists" title="Введите удовлетворенность мед помощью врачей-специалистов">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Работой врачей в поликлинике:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="clinicDoctor" title="Введите удовлетворенность работой врачей в поликлинике">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    
									<div><p>2.	Приходилось ли вам лично (для себя) за последние 3 месяца обращаться куслугам скорой медицинской помощи?</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="ambulance" title="Введите обращения к скорой помощи">
								      	<option value=""></option>
								        <option>Да</option>
								        <option>Нет</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div><p>3.	На сколько вы удовлетворены качеством оказанной вам скорой медицинскойпомощи?</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="qualityAmbulance" title="Введите удовлетворенность качеством скорой помощи">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div><p>4.	Пол респондента:</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="sex"title="Введите пол">
								      	<option value=""></option>
								        <option>Мужской</option>
								        <option>Женский</option>
								      </select>
								    </div><br><br>
								    
								    <div><p>5.	Возраст респондента (лет):</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="age"  title="Введите возраст">
								      	<option value=""></option>
								      	<c:forEach var="ag" items="${listage}">
								        <option>${ag.value}</option>
								        </c:forEach>
								      </select>
								    </div><br><br>
								    
								</div>
								<input type="hidden" id="polzovatel" value="${principal.username}"/>
								<input type="hidden" id="id" value=""/>
								
								<div class="modal-footer"><div class="errorOneClinic" style="display:none; margin-bottom: 15px; color:red;"><h4>В анкете все поля обязательны.<br>Заполните все поля.</h4></div> 
								<button type="button" id="cancelOneClinic" class="btn btn-primary" data-dismiss="modal">Отмена</button>
									<button  class="btn btn-success"  onclick='oneclinic("${principal.username}")'>Добавить анкету</button>
								</div>
							</div>
						</div>
					</div>
		</div>		
<!-- конец Добавить запись (модальное окно) -->


  
<!-- <h1>Add New</h1>
  <form method="post" action="addClinic">
  Name: <input type="text" name="freeHelp"/>
  <button>Add</button>
  </form>  -->  
  
  <script src="${pageContext.request.contextPath}/resources/js/user/firstlevel.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/pressbtnfirslevel.js"></script>
</body>
</html>