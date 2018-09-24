package app.springbootdemo.database.repository;

import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.dbmodel.TimeTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;
import java.util.Set;


public interface TimeTableRepository extends CrudRepository<TimeTable, Long> {

   //@Query("select TimeTable from time_table tt inner join employee_time_table ett on tt.id = ett.time_table_id where ett.employee_emp_id = :employeeId")
   //Set<TimeTable> getTimeTableByEmployee(@Param("employeeId") long employeeId);

   // @Query(value = "select u from Employee u where u.id=?3",name = "findEmployeewithId")
   //
    //public Employee findEmployeewithId(long id);



   @Query("select t from TimeTable t join t.employee e where e.id = :empId and  t.end IS NULL")
    public Set<TimeTable> findForCurrentTimeTableForEmployee(@Param("empId") Long empId);

   @Query("select t from TimeTable t join t.employee e where e.id = :empId and  t.begin_break IS NULL")
    public Set<TimeTable> currentTimeTableForEmployee1(@Param("empId") Long empId);

   @Query("select t from TimeTable t join t.employee e where e.id = :empId and  t.end_break IS NULL")
    public Set<TimeTable> currentTimeTableForEmployee2(@Param("empId") Long empId);

    //@Query("select t from TimeTable t join t.employee e where e.id = :empId and  t.begin IS not  NULL and  CONVERT (date, start_time) =  CONVERT (date, GETDATE()) ")
    //@Query("select t from TimeTable t join t.employee e where e.id = :empId and  t.begin =  current_date() ")
    @Query("select t from TimeTable t join t.employee e where e.id = :empId and  t.begin IS not  NULL and DATE(t.begin)= current_date()")
    public Set<TimeTable> findStartTimeforEmpId(@Param("empId") Long empId);

}