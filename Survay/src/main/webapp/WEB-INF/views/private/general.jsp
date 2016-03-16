<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page session="false"%>
<!doctype html>
<html lang="ru">
<head>
<meta charset="utf-8">
<title>Главная</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tableoneLevel.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shine.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/1.11.2/themes/smoothness/jquery-ui.css">


<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/1.11.2/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="/survay/resources/js/jquery.validate.js"></script>

<!-- echart -->
    <script src="${pageContext.request.contextPath}/resources/js/echarts-all.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/green.js"></script>




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
	
	$( "#dateBeginsecondlevel" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#datePartSecondClinic" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndsecondlevel" ).datepicker({dateFormat:'dd.mm.yy'});

	$( "#dateBeginDayStacionar" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndDayStacionar" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#datePartOneDayStac" ).datepicker({dateFormat:'dd.mm.yy'});
	
	$( "#dateBeginDayStacionarsecondlevel" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndDayStacionarsecondlevel" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#datePartOneDayStacsecondlevel" ).datepicker({dateFormat:'dd.mm.yy'});

	$( "#dateBeginStacionar" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndStacionar" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#datePartOneStac" ).datepicker({dateFormat:'dd.mm.yy'});
	
	$( "#dateBeginStacionarsecondlevel" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#dateEndStacionarsecondlevel" ).datepicker({dateFormat:'dd.mm.yy'});
	$( "#datePartOneStacsecondlevel" ).datepicker({dateFormat:'dd.mm.yy'});
	
	// for reports
	
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
<div class="mask pseudo" style="position: static;"><a href="#" style="margin-top:20px;margin-left:50px;margin-bottom:0px;"><img src="${pageContext.request.contextPath}/resources/image/logo.png"/></a></div>
<div class="mask_pseudo2" id="echart_pie2" style="position: static;"></div>
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
<div class="conteinerHeader" style="position: absolute; width:1350px;">
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
			            <li><a href="#" class="menufonts"><i class="fa fa-warning faa-flash animated-hover"></i>&nbsp;&nbsp;Выборка</a></li>
			                <li class="dropdown">
			                    <a href="#" class="dropdown-toggle menufonts" data-toggle="dropdown"><i class="fa fa-list-alt "></i>&nbsp;&nbsp;Анкеты первого уровня <span class="caret"></span></a>
			                    <ul class="dropdown-menu" role="menu">
			                        <li><a href="#" id="one_ambul_pol" onclick="alloneclinic('${principal.username}')"><i class="fa fa-ambulance"></i>&nbsp;&nbsp;Амбул-полик помощь</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#" id="one_day" onclick="allonedaystacionar('${principal.username}')"><i class="fa fa-medkit"></i>&nbsp;&nbsp;Дневной стационар</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#" id="one_stac" onclick="allonestacionar('${principal.username}')"><i class="fa fa-stethoscope"></i>&nbsp;&nbsp;Стационар</a></li>
			                        
			                    </ul>
			                </li>
			                
			                <li class="dropdown">
			                    <a href="#" class="dropdown-toggle menufonts" data-toggle="dropdown"><i class="fa fa-align-right"></i>&nbsp;&nbsp;Анкеты второго уровня <span class="caret"></span></a>
			                    <ul class="dropdown-menu" role="menu">
			                        <li><a href="#" id="one_ambul_polsecondlevel" onclick="alloneclinicsecondlevel('${principal.username}')"><i class="fa fa-ambulance"></i>&nbsp;&nbsp;Амбул-полик помощь</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#" id="one_daysecondlevel" /*onclick="allonedaystacionarsecondlevel('${principal.username}')"*/><i class="fa fa-medkit"></i>&nbsp;&nbsp;Дневной стационар</a></li>
			                        <li class="divider"></li>
			                        <li><a href="#" id="one_stacsecondlevel" /*onclick="allonestacionarsecondlevel('${principal.username}')"*/><i class="fa fa-stethoscope"></i>&nbsp;&nbsp;Стационар</a></li>
			                    </ul>
			                </li>
			                
			                <li class="dropdown">
			                    <a href="#" class="dropdown-toggle menufonts" data-toggle="dropdown"><i class="fa fa-book"></i>&nbsp;&nbsp;Отчеты <span class="caret"></span></a>
			                    <ul class="dropdown-menu" role="menu">
			                        
	              					 <li class="dropdown-submenu">
						              <a href="#">Отчеты первого уровня</a>
						              <ul class="dropdown-menu">
						                <li><a href="#"  data-toggle="modal" data-target="#myModal777">Индикатор доступности и качества медицинской помощи</a></li>
						              </ul>
						            </li>	
	              						
			                        <li class="divider"></li>
			                        
			                        <li class="dropdown-submenu">
						              <a href="#">Отчеты второго уровня</a>
						              <ul class="dropdown-menu">
						                <li><a href="#" id="idicAvalibelTwo">Индикатор доступности и качества медицинской помощи</a></li>
						                <li class="divider"></li>
						                <li><a href="#" id="idicInfoTwo">Индикатор информированности застрахованных о своих правах в системе ОМС</a></li>
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
								<div class="modal-header backgrheader">
									<button type="button btn-primary" class="close"
										data-dismiss="modal" aria-hidden="true">&times;</button>
									<h3 class="modal-title">Отчет первого уроня</h3>
									<p>Индикатор доступности и качества медицинской помощи</p><br>

								</div>
								<div class="modal-body backgr">
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
						<input  class="form-control"  aria-describedby="sizing-addon3" id="dateBegin" name="namedateBegin" placeholder="">
					</TD>
					<td style="padding-right:15px;">
     					<input  class="form-control"  aria-describedby="sizing-addon3" id="dateEnd" name="namedateEnd" placeholder="">
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

<div id="dimsecondlevel">
			<div class="msgbox">
				<!-- 	<a class="close" href="#" ><img src="close.jpg"/></a>  -->
				<div class="msgboxp">
					<h4 id="shadow_oneclinic">Анкета второго уровня амбулаторно-поликлинической помощи</h4>
				</div>
			</div>
			
			<div  style="position: absolute; left:35%;">
			<TABLE>
				<TR> 
					<TD style="padding-right:15px;">
						<input  class="form-control"  aria-describedby="sizing-addon3" id="dateBeginsecondlevel" name="namedateBeginsecondlevel" placeholder="">
					</TD>
					<td style="padding-right:15px;">
     					<input  class="form-control"  aria-describedby="sizing-addon3" id="dateEndsecondlevel" name="namedateEndsecondlevel" placeholder="">
     				</td>
     				<td style="padding-right:15px;">
     					<button class="btn btn-success" id="getqueryoneclinic" /*onclick="oneclinicbetween('${principal.username}')"*/>Выбрать</button>
     				</td>
     				<td>
     					<button class="btn btn-success" id="addOneClinicsecondlevel" data-toggle="modal" data-target="#myModalClinicSecondLevel" onclick="levelsecond()">Добавить запись</button>
     				</td>
     			</TR>
     		</TABLE>
			</div><br><br>
<div id="fgfsecondlevel" style="overflow-y: scroll; height:100px; margin-top:35px;">			
			<table id="records_tablesecondlevel" class="table table-striped" style="margin:0px auto; width:85%;"></table>
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
						<input  class="form-control"  aria-describedby="sizing-addon3" id="dateBeginDayStacionar" name="namedateBeginDayStacionar" placeholder="">
					</TD>
					<td style="padding-right:15px;">
     					<input  class="form-control"  aria-describedby="sizing-addon3" id="dateEndDayStacionar" name="namedateEndDayStacionar" placeholder="">
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
		
<div id="dim2secondlevel">
	<div class="msgbox2">
		<!-- 	<a class="close" href="#" ><img src="close.jpg"/></a>  -->
		<div class="msgboxp2">
			<h4 id="shadow_oneclinic2">Анкета второго уровня дневного стационара</h4>
		</div>
	</div>
	
	<div  style="position: absolute; left:35%;">
	<TABLE>
		<TR> 
			<TD style="padding-right:15px;">
				<input  class="form-control"  aria-describedby="sizing-addon3" id="dateBeginDayStacionarsecondlevel" name="namedateBeginDayStacionarsecondlevel" placeholder="">
			</TD>
			<td style="padding-right:15px;">
   					<input  class="form-control"  aria-describedby="sizing-addon3" id="dateEndDayStacionarsecondlevel" name="namedateEndDayStacionarsecondlevel" placeholder="">
   				</td>
   				<td style="padding-right:15px;">
   					<button class="btn btn-success"  /*onclick="onedaystacbetween('${principal.username}')"*/>Выбрать</button>
   				</td>
   				<td>
   					<button class="btn btn-success" id="addOneDayStacionarsecondlevel" data-toggle="modal" data-target="#myModal1secondlevel" /*onclick="oneLevel()"*/>Добавить запись</button>
     				</td>
     			</TR>
     		</TABLE>
			</div>
			<br><br>
<div id="tableOneDayStacionarsecondlevel" style="overflow-y: scroll; height:100px; margin-top:35px;">			
	<table id="records_tableOneDayStacionarsecondlevel" class="table table-striped" style="margin:0px auto; width:85%;"></table>
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
						<input  class="form-control"  aria-describedby="sizing-addon3" id="dateBeginStacionar" name="namedateBeginStacionar" placeholder="">
					</TD>
					<td style="padding-right:15px;">
     					<input  class="form-control"  aria-describedby="sizing-addon3" id="dateEndStacionar" name="namedateEndStacionar" placeholder="">
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
</div> 

<div id="dim3secondlevel">
			<div class="msgbox3">
				<!-- 	<a class="close" href="#" ><img src="close.jpg"/></a>  -->
				<div class="msgboxp3">
					<h4 id="shadow_oneclinic3">Анкета второго уровня стационарной помощи</h4>
				</div>
			</div>
			<div  style="position: absolute; left:35%;">
			<TABLE>
				<TR> 
					<TD style="padding-right:15px;">
						<input  class="form-control"  aria-describedby="sizing-addon3" id="dateBeginStacionarsecondlevel" name="namedateBeginStacionarsecondlevel" placeholder="">
					</TD>
					<td style="padding-right:15px;">
     					<input  class="form-control"  aria-describedby="sizing-addon3" id="dateEndStacionarsecondlevel" name="namedateEndStacionarsecondlevel" placeholder="">
     				</td>
     				<td style="padding-right:15px;">
     					<button class="btn btn-success"  /*onclick="onestacbetween('${principal.username}')"*/>Выбрать</button>
     				</td>
     				<td>
     					<button class="btn btn-success" id="addOneStacionarsecondlevel" data-toggle="modal" data-target="#myModal2secondlevel" /*onclick="oneLevel()"*/>Добавить запись</button>
     				</td>
     			</TR>
     		</TABLE>
			</div>
			<br><br>
<div id="tableOneStacionarsecondlevel" style="overflow-y: scroll; height:100px; margin-top:35px;">			
			<table id="records_tableOneStacionarsecondlevel" class="table table-striped" style="margin:0px auto; width:85%;"></table>
		</div>		
</div>


<!-- <div class="conteinerHeader"> -->

<!-- Добавить запись (модальное окно первого уровня АПУ) -->
					<div class="modal  fade" id="myModal" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header backgrheader">
									<button type="button btn-primary" class="close"
										data-dismiss="modal" aria-hidden="true">&times;</button>
									<h3 class="modal-title">Добавить анкету первого уровня</h3>
									<p>Добавление анкеты  амбулаторно-поликлинической помощи</p>

								</div>
					<div  id="form1" >			
								<div class="modal-body backgr" >
									<div  class="wrap-hv">
											<div><p class="hv">Укажите медицинское учреждение где проходил опрос</p></div>
										    <div class="col-xs-4">
										      <select class="form-control input-sm" id="mo" title="Введите лечебное учреждение">
										        <option value=""></option>
										        <c:forEach var="ls" items="${listmo}">
										        <option>${ls.value}</option>
										        </c:forEach>
										      </select>
										    </div><br><br>
									</div>	    
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">Укажите дату проведения опроса в данном мед учреждении</p></div>
									    <div class="col-xs-4">
									      <input  class="form-control"  aria-describedby="sizing-addon3" id="datePartOneClinic" name="dataRespN" placeholder="">
									    </div><br><br>
									</div>    
								    								
									<p>1.	Оцените уровень вашей  удовлетворенности следующими характеристиками работы поликлиники:</p>
									<div  class="wrap-hv">
										<div><p class="hv">1.1 Насколько Вы удовлетворены качеством бесплатной медицинской помощи, получаемой в поликлинике</p></div>
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
									 </div>   
		 						    
								    <div  class="wrap-hv">
										<div><p class="hv">1.2 Техническим состоянием, ремонтом помещений:</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.3 Оснащенностью современным медицинским оборудованием:</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.4 Организацией записи на прием к врачу:</p></div>
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
									 </div>   
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.5 Временем ожидания приема врача:</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.6 Сроками ожидания медицинских услуг после записи:</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.7 Доступностью необходимых лабораторных исследований/анализов:</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.8 Доступностью диагностических исследований (ЭКГ, УЗИ и т.д.):</p></div>
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
									</div>
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.9 Доступностью мед.помощи терапевтов:</p></div>
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
									 </div>   
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.10 Доступностью мед.помощи врачей-специалистов:</p></div>
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
								    </div>
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.11 Работой врачей в поликлинике:</p></div>
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
									 </div>   
								    
								    <div  class="wrap-hv">
										<div><p class="hv">2.	Приходилось ли вам лично (для себя) за последние 3 месяца обращаться куслугам скорой медицинской помощи?</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="ambulance" title="Введите обращения к скорой помощи">
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									      </select>
									    </div><br><br>
								    </div>
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">3.	На сколько вы удовлетворены качеством оказанной вам скорой медицинскойпомощи?</p></div>
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
									 </div>   
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">4.	Пол респондента:</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="sex"title="Введите пол">
									      	<option value=""></option>
									        <option>Мужской</option>
									        <option>Женский</option>
									      </select>
									    </div><br><br>
									 </div>   
								    
								    <div  class="wrap-hv">
										<div><p class="hv">5.	Возраст респондента (лет):</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="age"  title="Введите возраст">
									      	<option value=""></option>
									      	<c:forEach var="ag" items="${listage}">
									        <option>${ag.value}</option>
									        </c:forEach>
									      </select>
									    </div><br><br>
									</div>    
								    
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

<!-- Добавить запись (модальное окно второго уровня АПУ) -->
					<div class="modal  fade" id="myModalClinicSecondLevel" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header backgrheader">
								<!-- 	<button type="button btn-primary" class="close"
										data-dismiss="modal" aria-hidden="true">&times;</button>  -->
									<h3 class="modal-title">Добавить анкету второго уровня</h3>
									<p>Добавление анкеты  амбулаторно-поликлинической помощи</p>

								</div>
					<div  id="formClinicSecondLevel" >			
								<div class="modal-body backgr" >
									<div  class="wrap-hv">
											<div><p class="hv">Укажите медицинское учреждение где проходил опрос</p></div>
										    <div class="col-xs-4">
										      <select class="form-control input-sm" id="moSecondLevel" title="Введите лечебное учреждение">
										        <option value=""></option>
										        <c:forEach var="ls" items="${listmo}">
										        <option>${ls.value}</option>
										        </c:forEach>
										      </select>
										    </div><br><br>
									</div>	    
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">Укажите дату проведения опроса в данном мед учреждении</p></div>
									    <div class="col-xs-4">
									      <input  class="form-control"  aria-describedby="sizing-addon3" id="datePartSecondClinic" name="dataRespNSecondLevel" placeholder="">
									    </div><br><br>
									</div>    
								    								
									<div  class="wrap-hv">
										<div><p class="hv">1.	Как часто Вы посещаете поликлинику: (один ответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="visitClinicSecondLevel">
									      	<option value=""></option>
									        <option>Один раз в несколько лет</option>
									        <option>Один - два раза в год</option>
									        <option>В среднем раз в месяц</option>
									        <option>Два - четыре раза в месяц</option>
									        <option>Два - три раза в неделю или чаше</option>
									      </select>
									    </div><br><br>
									 </div>   
		 						    
								    <div  class="wrap-hv" style="height: 180px;">
										<div><p class="hv">2.	Почему Вы посещаете именно эту поликлинику?: (возможно несколько вариантов ответа)</p></div>
									    <div class="col-xs-4" style="width: 800px;">
									      <table>
									      <tr>
											<td>
												<input type="checkbox" id="question2_1_clinic"  value="Близко расположена к дому" > Близко расположена к дому&nbsp;<br>
												<input type="checkbox" id="question2_2_clinic" value="Здесь чисто и уютно, приятно находиться" > Здесь чисто и уютно, приятно находиться&nbsp;<br>
												<input type="checkbox" id="question2_3_clinic" value="Здесь работают хорошие специалисты" > Здесь работают хорошие специалисты&nbsp;<br>
												<input type="checkbox" id="question2_4_clinic" value="Большой спектр медицинских услуг" > Большой спектр медицинских услуг&nbsp;<br>
												<input type="checkbox" id="question2_5_clinic" value="Я прикреплен(а) к этой поликлинике, наблюдался(лась) здесь ранее" > Я прикреплен(а) к этой поликлинике, наблюдался(лась) здесь ранее&nbsp;<br>
												Другое(напишиете)...&nbsp;<input type="text" id="question2_6_clinic" > 
											</td>
										  </tr>
										  </table>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">3.	Представьте, что Вам предложили поменять поликлинику. Вы бы сделали это? (один ответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="replacementClinicSecondLevel" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>     
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">4.	Представьте, что вы не прикреплены ни к одной из поликлиник. Вы бы выбрали вашу поликлинику? (один ответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question4" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div> 
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">5.	Удобен ли для вас график работы врачей и служб поликлиники? (один ответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question5" >
									      	<option value=""></option>
									        <option>Да, полностью удобен</option>
									        <option>По большей части удобен</option>
									        <option>Скорее не удобен</option>
									        <option>Совершенно не удобен</option>
									      </select>
									    </div><br><br>
									</div>       
									<br>
									<div  class="wrap-hv" style="height: 245px;">
										<div><p class="hv">6.1.	Каким образом  в вашей поликлинике можно взять талон/записаться на прием к участковому терапевту</p></div>
									    <div class="col-xs-4" style="width: 800px;">
									      <table>
									      <tr>
											<td>
												<input type="checkbox" id="question6_1_1_clinic"  value="В регистратуре" > В регистратуре&nbsp;<br>
												<input type="checkbox" id="question6_1_2_clinic" value="По телефону" >По телефону&nbsp;<br>
												<input type="checkbox" id="question6_1_3_clinic" value="Через Интернет (портал госуслуг)" > Через Интернет (портал госуслуг)&nbsp;<br>
												<input type="checkbox" id="question6_1_4_clinic" value="Через информационные терминалы в поликлинике" > Через информационные терминалы в поликлинике&nbsp;<br>
												Другое(напишиете)...&nbsp;<input type="text" id="question6_1_5_clinic"> 
											</td>
										  </tr>
										  </table>
									    </div><br><br>
									</div>
									<br>
									<div  class="wrap-hv" style="height: 245px;">
										<div><p class="hv">6.2.	Каким образом  в вашей поликлинике можно взять талон/записаться на прием к узкому специалисту</p></div>
									    <div class="col-xs-4" style="width: 800px;">
									      <table>
									      <tr>
											<td>
												<input type="checkbox" id="question6_2_1_clinic"  value="В регистратуре" > В регистратуре&nbsp;<br>
												<input type="checkbox" id="question6_2_2_clinic" value="По телефону" >По телефону&nbsp;<br>
												<input type="checkbox" id="question6_2_3_clinic" value="Через Интернет (портал госуслуг)" > Через Интернет (портал госуслуг)&nbsp;<br>
												<input type="checkbox" id="question6_2_4_clinic" value="Через информационные терминалы в поликлинике" > Через информационные терминалы в поликлинике&nbsp;<br>
												Другое(напишиете)...&nbsp;<input type="text" id="question6_2_5_clinic"> 
											</td>
										  </tr>
										  </table>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">7.	Можно ли в вашей поликлинике получить по телефону справочную информацию о предоставляемых медицинских услугах, работе специалистов и т.д. (одинответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question7" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">8.1.	Всегда ли в своей поликлинике вы можете своевременно получить медицинскую помощь: Участкового терапевта (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question8_1" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									      </select>
									    </div><br><br>
									</div>       
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">8.2.	Всегда ли в своей поликлинике вы можете своевременно получить медицинскую помощь: Врача-специалиста (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question8_2" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">9.1.	При последнем посещении через какой период времени после записи вы смогли попасть на прием к участковому терапевту (одни ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question9_1" >
									      	<option value=""></option>
									        <option>В тот же день</option>
									        <option>На следующий день</option>
									        <option>В течение 2 - 7 дней</option>
									        <option>Более чем через неделю</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">9.2.	При последнем посещении через какой период времени после записи вы смогли попасть на прием к врачу-специалисту (одни ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question9_2" >
									      	<option value=""></option>
									        <option>В тот же день</option>
									        <option>На следующий день</option>
									        <option>В течение 2 - 7 дней</option>
									        <option>Более чем через неделю</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">10.	Возникали ли у вас проблемы с вызовом врача на дом? (один ответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question10" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									        <option>Мне не приходилось вызывать врача на дом</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">11.	Сколько в среднем вам приходится ожидать приема врача в очереди перед кабинетом? (одни ответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question11" >
									      	<option value=""></option>
									        <option>До 5 минут</option>
									        <option>10 - 15 минут</option>
									        <option>15 - 30 минут</option>
									        <option>Более 30 минут</option>
									        <option>Более 1 часа</option>
									      </select>
									    </div><br><br>
									</div>
									<div  class="wrap-hv">
										<div><p class="hv">12.	Насколько вы удовлетворены качеством бесплатной медицинской помощи, получаемой в поликлинике? (один ответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question12_clinic" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">13.	Приходилось ли вам сталкиваться с проблемами при получении направления в другие медицинские организации для консультации, дополнительного обследования? (один ответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question13" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									        <option>Мне не приходилось получать подобное направление</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">14.	Как вы считаете, достаточно ли внимания уделяют врачи вашей поликлиники профилактике заболеваний? (один ответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question14" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									        <option>Затрудняюсь, ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">15.	Приходилось ли вам проходить в своей поликлинике диспансеризацию? (одинответ)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question15" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">16.	Когда вы проходили диспансеризацию последний раз? (напишите)</p></div>
									    <div class="col-xs-4">
									      <input type="text" id="question16" >
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">17.	Что вы можете сказать о своем последнем опыте прохождения диспансеризации? (один ответ)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question17" >
									      	<option value=""></option>
									        <option>Диспансеризацию прошел(ла) быстро, т.к. все было хорошо организовано</option>
									        <option>Диспансеризацию прошел(ла) быстро, т.к. врачи были недостаточновнимательны и относились ко всему формально</option>
									        <option>Диспансеризация заняла много времени, т.к. приходилось подолгу ждатьприема врачей</option>
									        <option>Другое (напишите)</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">18.	Как  вы считаете, учитывают ли врачи ваше мнение, назначая вам лечение?(один ответ)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question18" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">19.	Если у вас возникают вопросы по поводу назначенных вам медицинских Препаратов, процедур, анализов, обследований и т.п., всегда ли врачи разъясняют необходимость назначений? (один ответ)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question19" >
									      	<option value=""></option>
									        <option>Да, всегда</option>
									        <option>Чаще да, чем нет</option>
									        <option>Чаще нет, чем да</option>
									        <option>Нет</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.1.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Техническим состоянием, ремонтом помещений (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_1_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.2.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Организацией мест ожидания приема перед кабинетами (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_2_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.3.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Чистотой, санитарно-гигиеническими условиями (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_3_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.4.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Оснащенностью современным медицинским оборудованием (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_4_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.5.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Организацией работы регистратуры (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_5_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.6.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Организацией записи на прием к врачу (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_6_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.7.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Временем ожидания приема врача (перед кабинетом) (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_7_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.8.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Сроками ожидания медицинских услуг после записи (перед кабинетом) (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_8_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.9.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Доступностью необходимых лабораторных исследований/анализов (перед кабинетом) (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_9_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.10.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Доступностью диагностических исследований (ЭКГ, УЗИ и т.д.) (перед кабинетом) (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_10_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.11.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Доступностью мед.помощи терапевта (перед кабинетом) (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_11_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.12.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Доступностью мед.помощи врачей-специалистов (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_12_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.13.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Квалификацией врачей (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_13_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.14.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Отношением врачей и медсестер к пациентам (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_14_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.15.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Работой врачей в поликлинике (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_15_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.16.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Комплексом предоставляемых медицинских услуг (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_16_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									<br>
									 <div  class="wrap-hv">
										<div><p class="hv">20.17.	Оцените уровень вашей удовлетворенности следующими характеристиками работы поликлиники: Результатами лечения, обследования, реабилитации (один ответ по каждой строке)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question20_17_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">21.	Приходилось ли вам лично (для себя) за последние 3 месяца обращаться к услугам скорой медицинской помощи? (один ответ)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question21" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									      </select>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">22.	Насколько вы удовлетворены качеством оказанной вам скорой медицинской помощи? (один ответ)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question22_clinic" >
									      	<option value=""></option>
									        <option>Удовлетворен(а)</option>
									        <option>Скорее удовлетворен(а), чем нет</option>
									        <option>Скорее не удовлетворен(а), чем удовлетворен(а)</option>
									        <option>Не удовлетворен(а)</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">23.	Знаете ли вы свои права как застрахованного в системе обязательного медицинского страхования? (один ответ)</p></div>
									    <div class="col-xs-4">
									    <select class="form-control input-sm" id="question23" >
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Не в полной мере</option>
									        <option>Нет</option>
									      </select>
									    </div><br><br>
									</div>
									
									
								 	<div  class="wrap-hv" style="height: 245px;">
										<div><p class="hv">24.	Из каких источников вы узнали о своих правах? (возможно несколько вариантов ответа)</p></div>
									    <div class="col-xs-4" style="width: 800px;">
									      <table>
									      <tr>
											<td>
												<input type="checkbox" id="question24_1_clinic"  value="От медицинских работников" > От медицинских работников&nbsp;<br>
												<input type="checkbox" id="question24_2_clinic" value="От сотрудников страховой компании" > От сотрудников страховой компании&nbsp;<br>
												<input type="checkbox" id="question24_3_clinic" value="От сотрудников Фонда ОМС" > От сотрудников Фонда ОМС&nbsp;<br>
												<input type="checkbox" id="question24_4_clinic" value="От знакомых/родственников" > От знакомых/родственников&nbsp;<br>
												<input type="checkbox" id="question24_5_clinic" value="Из средств массовой информации" > Из средств массовой информации&nbsp;<br>
												<input type="checkbox" id="question24_6_clinic" value="Из информации для населения в медицинских организациях (стенды, брошюры,листовки)" > Из информации для населения в медицинских организациях (стенды, брошюры,листовки)&nbsp;<br>
												<input type="checkbox" id="question24_7_clinic" value="Из сети Интернет" > Из сети Интернет&nbsp;<br>
												<input type="checkbox" id="question24_8_clinic" value="Я не знаю своих прав" > Я не знаю своих прав&nbsp;<br>
												<input type="checkbox" id="question24_9_clinic" value="Затрудняюсь ответить" > Затрудняюсь ответить&nbsp;<br>
												Другое(напишиете)...&nbsp;<input type="text" id="question24_10_clinic" > 
											</td>
										  </tr>
										  </table>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">25.1	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Выбор мед организации</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_1_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>     
									
									<div  class="wrap-hv">
										<div><p class="hv">25.2	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Выбор страховой компании</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_2_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>     
									
									<div  class="wrap-hv">
										<div><p class="hv">25.3	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Выбор врача (с учетом его согласия)</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_3_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">25.4	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Получение полной информации о состоянии собственного здоровья</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_4_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>          
									
									<div  class="wrap-hv">
										<div><p class="hv">25.5	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Сохранение в тайне информации о состоянии своего здоровья, факте обращения за мед.помощью</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_5_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>          
									
									<div  class="wrap-hv">
										<div><p class="hv">25.6	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Отказ от медицинского вмешательства</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_6_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">25.7	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Получение бесплатных лекарств при обращении за скорой и стационарной помощью</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_7_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">25.8	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Получение бесплатной мед.помощи как в поликлинике, так и на дому</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_8_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">25.9	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Получение бесплатной восстановительной помощи и реабилитации</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_9_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">25.10	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Получение бесплатной мед.помощи за пределами региона, в котором Вы проживаете</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_10_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">25.11	Знаете ли вы, что системе обязательного медицинского страхования вы имеете право на: Защиту своих прав в случае их нарушения</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="question25_11_clinic" >
									      	<option value=""></option>
									        <option>Знаю</option>
									        <option>Что-то слышал</option>
									        <option>Не знаю</option>
									        <option>Затрудняюсь ответить</option>
									      </select>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv" style="height: 215px;">
										<div><p class="hv">26.	Если вы считаете, что ваши права в системе ОМС нарушены, куда выпредпочитаете обратиться за помощью? (возможно несколько вариантов ответа)</p></div>
									    <div class="col-xs-4" style="width: 800px;">
									      <table>
									      <tr>
											<td>
												<input type="checkbox" id="question26_1_clinic"  value="Администрация медицинской организации" > Администрация медицинской организации&nbsp;<br>
												<input type="checkbox" id="question26_2_clinic" value="Страховая компания, выдавшая полис ОМС" > Страховая компания, выдавшая полис ОМС&nbsp;<br>
												<input type="checkbox" id="question26_3_clinic" value="Фонд обязательного медицинского страхования" > Фонд обязательного медицинского страхования&nbsp;<br>
												<input type="checkbox" id="question26_4_clinic" value="Органы управления здравоохранением" > Органы управления здравоохранением&nbsp;<br>
												<input type="checkbox" id="question26_5_clinic" value="Гражданский суд" > Гражданский суд&nbsp;<br>
												<input type="checkbox" id="question26_6_clinic" value="Затрудняюсь ответить" > Затрудняюсь ответить&nbsp;<br>
												Другое(напишиете)...&nbsp;<input type="text" id="question26_7_clinic" > 
											</td>
										  </tr>
										  </table>
									    </div><br><br>
									</div>
									
									<div  class="wrap-hv">
										<div><p class="hv">	Пол респондента:</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="sexSecondLevelClinic" title="Введите пол">
									      	<option value=""></option>
									        <option>Мужской</option>
									        <option>Женский</option>
									      </select>
									    </div><br><br>
									 </div>   
								    
								    <div  class="wrap-hv">
										<div><p class="hv">	Возраст респондента (лет):</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="SecondLevelClinic"  title="Введите возраст">
									      	<option value=""></option>
									      	<c:forEach var="ag" items="${listage}">
									        <option>${ag.value}</option>
									        </c:forEach>
									      </select>
									    </div><br><br>
									</div>    
								    
								<input type="hidden" id="polzovatelClinicSecondLevel" value="${principal.username}"/>
								<input type="hidden" id="idClinicSecondLevel" value=""/>
								
								<div class="modal-footer"><div class="errorSecondClinic" style="display:none; margin-bottom: 15px; color:red;"><h4>В анкете все поля обязательны.<br>Заполните все поля.</h4></div> 
							 	<button type="button" id="cancelSecondClinic" class="btn btn-primary" data-dismiss="modal">Отмена</button> 
								<button  class="btn btn-success"  onclick='secondlevelclinic("${principal.username}")'>Добавить анкету</button> 
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
								<div class="modal-header backgrheader">
									<button type="button btn-primary" class="close"
										data-dismiss="modal" aria-hidden="true">&times;</button>
									<h3 class="modal-title">Добавить анкету первого уровня</h3>
									<p>Добавление анкеты  дневного стационара</p>

								</div>
					<div  id="form2" >			
								<div class="modal-body backgr">
									<div  class="wrap-hv">
										<div><p class="hv">Укажите медицинское учреждение где проходил опрос</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="moDayStac" title="Введите лечебное учреждение">
									        <option value=""></option>
									        <c:forEach var="ls" items="${listmo}">
									        <option>${ls.value}</option>
									        </c:forEach>
									      </select>
									    </div><br><br>
								    </div>
								    
								    <div  class="wrap-hv">
										<div><p class="hv">Укажите дату проведения опроса в данном мед учреждении</p></div>
									    <div class="col-xs-4">
									      <input  class="form-control"  aria-describedby="sizing-addon3" id="datePartOneDayStac" name="dataRespDS" placeholder="">
									    </div><br><br>
									</div>    
								    								
									<p>1.	 Оцените уровень вашей удовлетворенности следующими характеристиками работы дневного стационара:</p>
									<div  class="wrap-hv">
										<div><p class="hv">1.1 Насколько Вы удовлетворены качеством бесплатной медицинской помощи, получаемой в дневном стационаре</p></div>
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
									</div>    
		 						    
								    <div  class="wrap-hv">
										<div><p class="hv">1.2 Техническим состоянием, ремонтом помещений, площадью помещений:</p></div>
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
									</div>    
									    
								    <div  class="wrap-hv">
										<div><p class="hv">1.3 Комфортностью мест пребывания пациентов:</p></div>
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
								    </div>
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.4 Комплексом предоставляемых медицинских услуг:</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.5 Оснащенностью современным медицинским оборудованием:</p></div>
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
									 </div>   
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.6 Обеспеченностью медикаментами и расходными материалами:</p></div>
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
								    </div>
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.7 Работой вспомогательных служб (лаборатория, рентген-кабинет, физиотерапевтический кабинет и т.д.):</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.8 Работой лечащего врача:</p></div>
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
									 </div>   

									<div  class="wrap-hv">
										<div><p class="hv">2.	Приходилось ли вам лично (для себя) за последние 3 месяца обращаться куслугам скорой медицинской помощи?</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="ambulanceDaystac">
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									      </select>
									    </div><br><br>
								   </div>   
								    
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">3.	На сколько вы удовлетворены качеством оказанной вам скорой медицинскойпомощи?</p></div>
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
									</div>    
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">4.	Пол респондента:</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="sexDaystac">
									      	<option value=""></option>
									        <option>Мужской</option>
									        <option>Женский</option>
									      </select>
									    </div><br><br>
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">5.	Возраст респондента (лет):</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="ageDaystac">
									      	<option value=""></option>
									      	<c:forEach var="ag" items="${listage}">
									        <option>${ag.value}</option>
									        </c:forEach>
									      </select>
									    </div><br><br>
									</div>    
								    
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
								<div class="modal-header backgrheader">
									<button type="button btn-primary" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h3 class="modal-title">Добавить анкету первого уровня</h3>
									<p>Добавление анкеты  стационарной помощи</p>

								</div>
					<div id="form3" >			
								<div class="modal-body backgr">
									<div  class="wrap-hv">
										<div><p class="hv">Укажите медицинское учреждение где проходил опрос</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="moonestac">
									        <option value=""></option>
									        <c:forEach var="ls" items="${listmo}">
									        <option>${ls.value}</option>
									        </c:forEach>
									      </select>
									    </div><br><br>
									</div>    
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">Укажите дату проведения опроса в данном мед учреждении</p></div>
									    <div class="col-xs-4">
									      <input  class="form-control"  aria-describedby="sizing-addon3" id="datePartOneStac" name="dataonestac" placeholder="">
									    </div><br><br>
								   </div> 
								    								
									<p>1.	Оцените уровень  вашей удовлетворенности следующими характеристиками работы стационара:</p>
									<div  class="wrap-hv">
										<div><p class="hv">1.1 Насколько Вы удовлетворены качеством бесплатной медицинской помощи, получаемой в дневном стационаре</p></div>
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
									</div>    
		 						    
								    <div  class="wrap-hv">
										<div><p class="hv">1.2 Техническим состоянием, ремонтом помещений, площадью помещений:</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.3 Комфортностью больничной палаты и мест пребывания пациентов:</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.4 Питанием:</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.5 Оснащенностью современным мед. оборудованием:</p></div>
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
									</div>    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.6 Обеспеченностью медикаментами и расходными материалами:</p></div>
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
									 </div>   
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.7 Сроками ожидания плановой госпитализации:</p></div>
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
									 </div>   
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.8 Работой вспомогательных служб (лаборатория, рентген-кабинет, физиотерапевтический кабинет и т.д.):</p></div>
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
									 </div>   
								    
								    <div  class="wrap-hv">
										<div><p class="hv">1.9 Работой лечащего врача:</p></div>
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
									 </div>   
								    
									<div  class="wrap-hv">
										<div><p class="hv">2.	Приходилось ли вам лично (для себя) за последние 3 месяца обращаться куслугам скорой медицинской помощи?</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="ambulanceStac">
									      	<option value=""></option>
									        <option>Да</option>
									        <option>Нет</option>
									      </select>
									    </div><br><br>
									</div>    
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">3.	На сколько вы удовлетворены качеством оказанной вам скорой медицинскойпомощи?</p></div>
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
									 </div>   
								    
								    
								    <div  class="wrap-hv">
										<div><p class="hv">4.	Пол респондента:</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="sexStac">
									      	<option value=""></option>
									        <option>Мужской</option>
									        <option>Женский</option>
									      </select>
									    </div><br><br>
									 </div>   
								    
								    <div  class="wrap-hv">
										<div><p class="hv">5.	Возраст респондента (лет):</p></div>
									    <div class="col-xs-4">
									      <select class="form-control input-sm" id="ageStac">
									      	<option value=""></option>
									      	<c:forEach var="ag" items="${listage}">
									        <option>${ag.value}</option>
									        </c:forEach>
									      </select>
									    </div><br><br>
									 </div>   
								    
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
  <script type="text/javascript">

  </script>
  <!-- <input onclick='responsiveVoice.speak("К представителям внесистемной оппозиции следует относиться как к предателям и врагам народа, считает Рамзан Кадыров. Своё мнение глава Чечни высказал на встрече с журналистами в Грозном в канун Дня российской печати.","Russian Female");' type='button' value='🔊 Play' />  -->
<script src="${pageContext.request.contextPath}/resources/js/user/firstlevel.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/secondlevel.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/pressbtnfirslevel.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/pressbtnsecondlevel.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/other.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/reports.js"></script>  
<!-- <script src="${pageContext.request.contextPath}/resources/js/annyang.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/recognaizervoice.js"></script>  
<script src="${pageContext.request.contextPath}/resources/js/ResponsiveVoice.js"></script> -->
</body>

</html>
