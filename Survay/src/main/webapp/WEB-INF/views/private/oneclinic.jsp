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
								      <select class="form-control input-sm" name="mo">
								        <option value=""></option>
								        <c:forEach var="ls" items="${listmo}">
								        <option>${ls.value}</option>
								        </c:forEach>
								      </select>
								    </div><br><br>
								    
								    
								    <div>Укажите дату проведения опроса в данном мед учреждении</div>
								    <div class="col-xs-4">
								      <input  class="form-control"  aria-describedby="sizing-addon3" id="datePartOneClinic" placeholder="" name="">
								    </div><br><br>
								    								
									<p>1.	Оцените уровень вашей  удовлетворенности следующими характеристиками работы поликлиники:</p>
									<div>Насколько Вы удовлетворены качеством бесплатной медицинской помощи, получаемой в поликлинике</div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="freeHelp">
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
								      <select class="form-control input-sm" name="repairs">
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
								      <select class="form-control input-sm" name="equipment">
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
								      <select class="form-control input-sm" name="seeADoctor">
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
								      <select class="form-control input-sm" name="waitingTime">
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
								      <select class="form-control input-sm" name="waitingTime2">
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
								      <select class="form-control input-sm" name="laboratoryResearch">
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
								      <select class="form-control input-sm" name="diagnosticTests">
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
								      <select class="form-control input-sm" name="therapist">
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
								      <select class="form-control input-sm" name="medicalSpecialists">
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
								      <select class="form-control input-sm" name="clinicDoctor">
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
								      <select class="form-control input-sm" name="ambulance">
								      	<option value=""></option>
								        <option>Да</option>
								        <option>Нет -к вопросу 4</option>
								      </select>
								    </div><br><br>
								    
								    
								    <div><p>3.	На сколько вы удовлетворены качеством оказанной вам скорой медицинскойпомощи?</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="qualityAmbulance">
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
								      <select class="form-control input-sm" name="sex">
								      	<option value=""></option>
								        <option>Мужской</option>
								        <option>Женский</option>
								      </select>
								    </div><br><br>
								    
								    <div><p>5.	Возраст респондента (лет):</p></div>
								    <div class="col-xs-4">
								      <select class="form-control input-sm" name="age">
								      	<option value=""></option>
								      	<c:forEach var="ag" items="${listage}">
								        <option>${ag.value}</option>
								        </c:forEach>
								      </select>
								    </div><br><br>
								    
								</div>
								<input type="hidden" name="polzovatel" value="${principal.username}"/>
								<div class="modal-footer">
								<button type="button" class="btn btn-primary" data-dismiss="modal">Отмена</button>
									<button type="submit" class="btn btn-success">Добавить анкету</button>
								</div>
							</div>
						</div>
					</div>
					</form>		
<!-- конец Добавить запись (модальное окно) -->