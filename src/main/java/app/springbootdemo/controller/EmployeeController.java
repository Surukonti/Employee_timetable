package app.springbootdemo.controller;


import app.springbootdemo.controller.mapper.EmployeeViewMapper;
import app.springbootdemo.controller.model.EmployeeView;
import app.springbootdemo.controller.model.HoliDayView;
import app.springbootdemo.controller.model.IllView;
import app.springbootdemo.controller.model.TelephoneView;
import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.service.EmployeeService;
import app.springbootdemo.service.mapper.EmployeeBOMapper;
import app.springbootdemo.service.mapper.HoliDayBOMapper;
import app.springbootdemo.service.mapper.IllBOMapper;
import app.springbootdemo.service.mapper.TelephoneBOMapper;
import app.springbootdemo.service.model.EmployeeBO;
import app.springbootdemo.service.model.TelephoneBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;


	@GetMapping(value="/employee",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@PostMapping(value="/postemployee" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeView postEmployee(@RequestBody EmployeeView employeeView) {
		EmployeeBO employeeBO = EmployeeBOMapper.from(employeeView);
		employeeBO = employeeService.postEmployee(employeeBO);
		EmployeeView employeeView1 = EmployeeViewMapper.from(employeeBO);

		return employeeView1;
	}


	@PostMapping(value="/ill" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void ill(@RequestBody IllView illView) {
		System.out.println("****************************************    " + illView.getEmpId());
		employeeService.ill(IllBOMapper.from(illView));
	}


	@PostMapping(value="/holiday" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void holiDay(@RequestBody HoliDayView holiDayView) {
		employeeService.holiDay(HoliDayBOMapper.from(holiDayView));
	}

	/*@PostMapping(value="/telephone" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public TelephoneView postTelephone(@RequestBody TelephoneView telephoneView) {
		employeeService.telephone(TelephoneBOMapper.from(telephoneView));
	     return telephoneView;}*/


	@GetMapping(value="/findbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByLastName(@PathVariable("lastName") String lastName) {
		return employeeService.findByLastName(lastName);
	}

	@DeleteMapping(value="/employee/{id}/delete")
	public void deleteEmployee(@PathVariable long id){
		employeeService.deleteEmployee(id);
	}

	@PostMapping(value="/employee/{id}/start" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void startTime(@PathVariable long id) {
		employeeService.startTime(id);
	}

	@PostMapping(value="/employee/{id}/stop" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void endTime(@PathVariable long id) {
		employeeService.endTime(id);
	}

	@PostMapping(value="/employee/startBreakTime/{id}" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void startBreakTime(@PathVariable long id) {
		employeeService.startBreakTime(id);
	}


	@PostMapping(value="/employee/stopBreakTime/{id}" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void endBreakTime(@PathVariable long id) {
		employeeService.stopBreakTime(id);
	}

	/*@GetMapping(value="/findbyId/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee findEmployeewithId(@PathVariable("id") long id) {
		return employeeService.findEmployeewithId(id);
	}*/

/*
	@PostMapping(value="/employee/illStartTime/{id}" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void illStartTime(@PathVariable long id) {
		employeeService.illStartTime(id);
	}

	@PostMapping(value="/employee/illEndTime/{id}" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void illEndTime(@PathVariable long id) {
		employeeService.illEndTime(id);
	}


	@PostMapping(value="/employee/holidayStartTime/{id}" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void holidayStartTime(@PathVariable long id) {
		employeeService.holidayStartTime(id);
	}

	@PostMapping(value="/employee/holidayEndTime/{id}" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void holidayEndTime(@PathVariable long id) {
		employeeService.holidayEndTime(id);
	}*/
}
