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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tableoneLevel.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shine.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/1.11.2/themes/smoothness/jquery-ui.css">


<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/1.11.2/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="/survay/resources/js/jquery.validate.js"></script>




<sec:authentication var="principal" property="principal" />




<script type="text/javascript">
$(document).ready(function()
{ 
	$(this).click(function(){ shine(); });
	var user = '${principal.username}';
	console.log('log '+ user);
	
	if(user == 'smo_simaz')
	{
		$("#oneTFOMS").attr("disabled", true);
		$("#oneIngos").attr("disabled", true);
		$("#oneRosno").attr("disabled", true);
	}
	
	if(user == 'smo_rosno')
	{
		$("#oneTFOMS").attr("disabled", true);
		$("#oneIngos").attr("disabled", true);
		$("#oneSimaz").attr("disabled", true);
	}
	
	if(user == 'smo_ingos')
	{
		$("#oneTFOMS").attr("disabled", true);
		$("#oneRosno").attr("disabled", true);
		$("#oneSimaz").attr("disabled", true);
	}
	
	$( "#dateBegin" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#datePartOneClinic" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEnd" ).datepicker({dateFormat:'dd.mm.yy'});

	$( "#dateBeginDayStacionar" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndDayStacionar" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#datePartOneDayStac" ).datepicker({dateFormat:'dd.mm.yy'});

	$( "#dateBeginStacionar" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndStacionar" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#datePartOneStac" ).datepicker({dateFormat:'dd.mm.yy'});
	
	$( "#dateBeginOneReport" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndOneReport" ).datepicker({dateFormat:'dd.mm.yy'});

	$( "#dateBeginOneReportlg" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndOneReportlg" ).datepicker({dateFormat:'dd.mm.yy'});
});
</script>
<script>
$(document).ready(function() {
	
$("#formOneReport").validate({
   	submitHandler: function() {
		onepartreports('btnsf');
	  }
	});

});
</script>

</head>
<body>
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
			                        <li><a href="#" id="one_day" onclick="allonedaystacionar('${principal.username}')"><i class="fa fa-medkit"></i>&nbsp;&nbsp;Дневной стационар</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#" id="one_stac" onclick="allonestacionar('${principal.username}')"><i class="fa fa-stethoscope"></i>&nbsp;&nbsp;Стационар</a></li>
			                        
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
			                        
	              					 <li class="dropdown-submenu">
						              <a href="#">Отчеты первого уровня</a>
						              <ul class="dropdown-menu">
						                <li><a href="#"  data-toggle="modal" data-target="#myModal777">Индикатор доступности и качества медицинской помощи</a></li>
						                <li><a href="#"  data-toggle="modal" data-target="#myModal888">Сформировать отчет</a></li>
						                <li class="divider"></li>
						                <li><a href="#">Инфографика</a></li>
						              </ul>
						            </li>	
	              						
			                        <li class="divider"></li>
			                        
			                        <li class="dropdown-submenu">
						              <a href="#">Отчеты второго уровня</a>
						              <ul class="dropdown-menu">
						                <li><a href="#" id="idicAvalibelTwo">Индикатор доступности и качества медицинской помощи</a></li>
						                <li class="divider"></li>
						                <li><a href="#" id="idicInfoTwo">Индикатор информированности застрахованных о своих правах в системе ОМС</a></li>
						                <li class="divider"></li>
						                <li><a href="#">Инфографика</a></li>
						              </ul>
						            </li>
			                        
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
			                                           	<a href="j_spring_security_logout" id="exitfromsite"><b>Выход</b></a><br>
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
			
<!-- BLOCK MODAL WINDOWS FROM MENU -->
          		<div class="modal fade" id="myModal777" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button btn-primary" class="close"
										data-dismiss="modal" aria-hidden="true">&times;</button>
									<h3 class="modal-title">Отчет первого уроня</h3>
									<p>Индикатор доступности и качества медицинской помощи</p><br>
									Количество респондентов которых требуется опросить выводится относительно квартала в выбранном периоде дат. 

								</div>
								<div class="modal-body" style="background: rgb(247, 246, 241);">
										<form class="cmxform" id="formOneReport" action="firstPartReport" method="">
										<table cellspacing='15'>
										<tr>
											<td style="text-decoration: underline;"><h4>Выберите дату:</h4></td>
										</tr>
										<tr>
											<td>
											<input  class="form-control2 required"  aria-describedby="sizing-addon3" id="dateBeginOneReport"  name="datebeginonereport" placeholder="" title="Укажите дату начала отчета">&nbsp;
											<input  class="form-control2 required"  aria-describedby="sizing-addon3" id="dateEndOneReport"  name="dateendonereport" placeholder="" title="Укажите дату окончания отчета">
											</td>
										</tr>
										<tr><td><label class="error" style="display: none; color:red;"></label></td></tr>
										<tr>
											<td style="text-decoration: underline;"><h4>Выберите ЛПУ:</h4></td>
										</tr>
										<tr>
											<td>
												<select class="form-control2 required" id="lpuFormOneRerort" style="width: 350px" id="" title="Введите лечебное учреждение">
											        <option value=""></option>
											        <option>Все</option>
											        <c:forEach var="ls" items="${listmo}">
											        <option>${ls.value}</option>
											        </c:forEach>
											    </select>
											</td>
										</tr>
										<tr>
											<td style="text-decoration: underline;"><h4>Выберите категорию ответа:</h4></td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" id="ansFormOnePart1"  value="" name="ans[]" required minlength="1"> Удовлетворен(а)&nbsp;<br>
												<input type="checkbox" id="ansFormOnePart2" value="" name="ans[]"> Скорее удовлетворен(а), чем не удовлетворен(а)&nbsp;<br>
												<input type="checkbox" id="ansFormOnePart3" value="" name="ans[]"> Скорее не удовлетворен(а), чем удовлетворен(а)&nbsp;<br>
												<input type="checkbox" id="ansFormOnePart4" value="" name="ans[]"> Не удовлетворен(а)&nbsp;<br>
												<input type="checkbox" id="ansFormOnePart5" value="" name="ans[]"> Затрудняюсь ответить&nbsp;
											</td>
										</tr>
										<tr><td><label for="ans[]" class="error" id="ans-error" style="display: none; color:red;">Пожалуйста выберите хотя бы один вариант ответа</label></td></tr>
										<tr>
											<td style="text-decoration: underline;"><h4>Выберите СМО(ТФОМС):</h4></td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" id="oneTFOMS"  value="onetfoms" name="org[]" required minlength="1"> ТФОМС&nbsp;
												<input type="checkbox" id="oneSimaz" value="onesimaz" name="org[]"> СимазМед&nbsp;
												<input type="checkbox" id="oneIngos" value="oneingos" name="org[]"> Ингосстрах&nbsp;
												<input type="checkbox" id="oneRosno" value="onerosno" name="org[]"> РОСНО
											</td>
										</tr>
										<tr><td><label for="org[]" class="error" id="org-error" style="display: none; color:red;">Пожалуйста выберите хотя бы одну организацию</label></td></tr>
										<tr><td>&nbsp;</td></tr>
										<tr>
										<td><button type="submit" value="Submit" id="btnsf"  class="btn btn-primary">Скачать отчет</button></td>
										</tr>
										</table>
									</form>
									
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-primary" id="closereportonepart" data-dismiss="modal">Закрыть окно</button>
								</div>
							</div>
						</div>
					</div>
<!-- CAST BLOCK MODAL WINDOWS FROM MENU -->
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
<div id="fgf" style="overflow-y: scroll; height:100px; margin-top:35px;">			
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
			
			<div  style="position: absolute; left:35%;">
			<TABLE>
				<TR> 
					<TD style="padding-right:15px;">
						<input  class="form-control"  aria-describedby="sizing-addon3" id="dateBeginDayStacionar" placeholder="">
					</TD>
					<td style="padding-right:15px;">
     					<input  class="form-control"  aria-describedby="sizing-addon3" id="dateEndDayStacionar" placeholder="">
     				</td>
     				<td style="padding-right:15px;">
     					<button class="btn btn-success"  onclick="onedaystacbetween('${principal.username}')">Выбрать</button>
     				</td>
     				<td>
     					<button class="btn btn-success" id="addOneDayStacionar" data-toggle="modal" data-target="#myModal1" onclick="oneLevel()">Добавить запись</button>
     				</td>
     			</TR>
     		</TABLE>
			</div>
			<br><br>
<div id="tableOneDayStacionar" style="overflow-y: scroll; height:100px; margin-top:35px;">			
			<table id="records_tableOneDayStacionar" class="table table-striped" style="margin:0px auto; width:85%;"></table>
</div>	
			
		</div>		
<div id="dim3">
			<div class="msgbox3">
				<!-- 	<a class="close" href="#" ><img src="close.jpg"/></a>  -->
				<div class="msgboxp3">
					<h4 id="shadow_oneclinic3">Анкета первого уровня стационарной помощи</h4>
				</div>
			</div>
			<div  style="position: absolute; left:35%;">
			<TABLE>
				<TR> 
					<TD style="padding-right:15px;">
						<input  class="form-control"  aria-describedby="sizing-addon3" id="dateBeginStacionar" placeholder="">
					</TD>
					<td style="padding-right:15px;">
     					<input  class="form-control"  aria-describedby="sizing-addon3" id="dateEndStacionar" placeholder="">
     				</td>
     				<td style="padding-right:15px;">
     					<button class="btn btn-success"  onclick="onestacbetween('${principal.username}')">Выбрать</button>
     				</td>
     				<td>
     					<button class="btn btn-success" id="addOneStacionar" data-toggle="modal" data-target="#myModal2" onclick="oneLevel()">Добавить запись</button>
     				</td>
     			</TR>
     		</TABLE>
			</div>
			<br><br>
<div id="tableOneStacionar" style="overflow-y: scroll; height:100px; margin-top:35px;">			
			<table id="records_tableOneStacionar" class="table table-striped" style="margin:0px auto; width:85%;"></table>
		</div>		
</div> <!-- <div class="conteinerHeader"> -->

<!-- Добавить запись (модальное окно первого уровня АПУ) -->
					<div class="modal  fade" id="myModal" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button btn-primary" class="close"
										data-dismiss="modal" aria-hidden="true">&times;</button>
									<h3 class="modal-title">Добавить анкету первого уровня</h3>
									<p>Добавление анкеты  амбулаторно-поликлинической помощи</p>

								</div>
					<div  id="form1" >			
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


<!-- Добавить запись (модальное окно первого уровня дневного стационара) -->

					<div class="modal fade" id="myModal1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button btn-primary" class="close"
										data-dismiss="modal" aria-hidden="true">&times;</button>
									<h3 class="modal-title">Добавить анкету первого уровня</h3>
									<p>Добавление анкеты  дневного стационара</p>

								</div>
					<div  id="form2" >			
								<div class="modal-body">
									<div>Укажите медицинское учреждение где проходил опрос</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="moDayStac" title="Введите лечебное учреждение">
								        <option value=""></option>
								        <c:forEach var="ls" items="${listmo}">
								        <option>${ls.value}</option>
								        </c:forEach>
								      </select>
								    </div><br><br>
								    
								    
								    <div>Укажите дату проведения опроса в данном мед учреждении</div>
								    <div class="col-xs-4">
								      <input  class="form-control"  aria-describedby="sizing-addon3" id="datePartOneDayStac" name="dataRespDS" placeholder="">
								    </div><br><br>
								    								
									<p>1.	 Оцените уровень вашей удовлетворенности следующими характеристиками работы дневного стационара:</p>
									<div>Насколько Вы удовлетворены качеством бесплатной медицинской помощи, получаемой в дневном стационаре</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="qualityDaystac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
		 						    
								    <div>Техническим состоянием, ремонтом помещений, площадью помещений:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="rapairsDaystac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Комфортностью мест пребывания пациентов:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="comfortDaystac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Комплексом предоставляемых медицинских услуг:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="servicesDaystac">
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
								      <select class="form-control input-sm" id="equipmentDaystac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Обеспеченностью медикаментами и расходными материалами:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="medicineDaystac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div>Работой вспомогательных служб (лаборатория, рентген-кабинет, физиотерапевтический кабинет и т.д.):</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="laboratoryDaystac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Работой лечащего врача:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="therapistDaystac">
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
								      <select class="form-control input-sm" id="ambulanceDaystac">
								      	<option value=""></option>
								        <option>Да</option>
								        <option>Нет</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div><p>3.	На сколько вы удовлетворены качеством оказанной вам скорой медицинскойпомощи?</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="qualityAmbulanceDaystac">
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
								      <select class="form-control input-sm" id="sexDaystac">
								      	<option value=""></option>
								        <option>Мужской</option>
								        <option>Женский</option>
								      </select>
								    </div><br><br>
								    
								    <div><p>5.	Возраст респондента (лет):</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="ageDaystac">
								      	<option value=""></option>
								      	<c:forEach var="ag" items="${listage}">
								        <option>${ag.value}</option>
								        </c:forEach>
								      </select>
								    </div><br><br>
								    
								</div>
								<input type="hidden" id="polzovateldaystacionar" value="${principal.username}"/>
								<input type="hidden" id="idoneDayStac" value=""/>
								
								<div class="modal-footer"><div class="errorOneClinic" style="display:none; margin-bottom: 15px; color:red;"><h4>В анкете все поля обязательны.<br>Заполните все поля.</h4></div> 
								<button type="button" id="cancelOneDayStacionar" class="btn btn-primary" data-dismiss="modal">Отмена</button>
									<button  class="btn btn-success"  onclick='onedaystacionar("${principal.username}")'>Добавить анкету</button>
								</div>
							</div>
						</div>
					</div>
		</div>		
<!-- конец Добавить запись (модальное окно) -->



<!-- Добавить запись (модальное окно первого уровня Стационар) -->
					<div class="modal fade" id="myModal2" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" >
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button btn-primary" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h3 class="modal-title">Добавить анкету первого уровня</h3>
									<p>Добавление анкеты  стационарной помощи</p>

								</div>
					<div id="form3" >			
								<div class="modal-body">
									<div>Укажите медицинское учреждение где проходил опрос</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="moonestac">
								        <option value=""></option>
								        <c:forEach var="ls" items="${listmo}">
								        <option>${ls.value}</option>
								        </c:forEach>
								      </select>
								    </div><br><br>
								    
								    
								    <div>Укажите дату проведения опроса в данном мед учреждении</div>
								    <div class="col-xs-4">
								      <input  class="form-control"  aria-describedby="sizing-addon3" id="datePartOneStac" name="dataonestac" placeholder="">
								    </div><br><br>
								    								
									<p>1.	Оцените уровень  вашей удовлетворенности следующими характеристиками работы стационара:</p>
									<div>Насколько Вы удовлетворены качеством бесплатной медицинской помощи, получаемой в дневном стационаре</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="qualityStac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
		 						    
								    <div>Техническим состоянием, ремонтом помещений, площадью помещений:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="rapairsStac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Комфортностью больничной палаты и мест пребывания пациентов:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="comfortStac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Питанием:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="foodStac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Оснащенностью современным мед. оборудованием:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="equipmentStac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Обеспеченностью медикаментами и расходными материалами:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="medicineStac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div>Сроками ожидания плановой госпитализации:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="termsStac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Работой вспомогательных служб (лаборатория, рентген-кабинет, физиотерапевтический кабинет и т.д.):</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="laboratoryStac">
								      	<option value=""></option>
								        <option>Удовлетворен(а)</option>
								        <option>Скорее удовлетворен(а), чем не удовлетворен(а)</option>
								        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
								        <option>Не удовлетворен(а)</option>
								        <option>Затрудняюсь ответить</option>
								      </select>
								    </div><br><br>
								    
								    <div>Работой лечащего врача:</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="therapistStac">
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
								      <select class="form-control input-sm" id="ambulanceStac">
								      	<option value=""></option>
								        <option>Да</option>
								        <option>Нет</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div><p>3.	На сколько вы удовлетворены качеством оказанной вам скорой медицинскойпомощи?</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="qualityAmbulanceStac">
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
								      <select class="form-control input-sm" id="sexStac">
								      	<option value=""></option>
								        <option>Мужской</option>
								        <option>Женский</option>
								      </select>
								    </div><br><br>
								    
								    <div><p>5.	Возраст респондента (лет):</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" id="ageStac">
								      	<option value=""></option>
								      	<c:forEach var="ag" items="${listage}">
								        <option>${ag.value}</option>
								        </c:forEach>
								      </select>
								    </div><br><br>
								    
								</div>
								<input type="hidden" id="polzovatelonestac" value="${principal.username}"/>
								<input type="hidden" id="idoneStac" value=""/>
								
								<div class="modal-footer"><div class="errorOneClinic" style="display:none; margin-bottom: 15px; color:red;"><h4>В анкете все поля обязательны.<br>Заполните все поля.</h4></div> 
								<button type="button" id="cancelOneStac" class="btn btn-primary" data-dismiss="modal">Отмена</button>
									<button  class="btn btn-success"  onclick='onestacionar("${principal.username}")'>Добавить анкету</button>
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
  <!-- <input onclick='responsiveVoice.speak("К представителям внесистемной оппозиции следует относиться как к предателям и врагам народа, считает Рамзан Кадыров. Своё мнение глава Чечни высказал на встрече с журналистами в Грозном в канун Дня российской печати.","Russian Female");' type='button' value='🔊 Play' />  -->
<script src="${pageContext.request.contextPath}/resources/js/user/firstlevel.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/pressbtnfirslevel.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/other.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/reports.js"></script>  
<!-- <script src="${pageContext.request.contextPath}/resources/js/annyang.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/recognaizervoice.js"></script>  
<script src="${pageContext.request.contextPath}/resources/js/ResponsiveVoice.js"></script> -->
</body>
</html>
