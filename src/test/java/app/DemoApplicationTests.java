package app;

import app.springbootdemo.controller.model.EmployeeView;
import app.springbootdemo.controller.model.TimeTableView;
import app.springbootdemo.service.mapper.EmployeeBOMapper;
import app.springbootdemo.service.model.EmployeeBO;
import app.springbootdemo.service.model.TimeTableBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testEmployeeBoMapper() {
        // Create input employee
        final Set<TimeTableView> timeTableViews = new HashSet<>();
        final TimeTableView ttv = new TimeTableView();
        ttv.setId(21L);
        ttv.setBegin(new Date());
        ttv.setEnd(new Date());
        ttv.setBegin_break(new Date());
        ttv.setEnd_break(new Date());
        timeTableViews.add(ttv);

        final EmployeeView input = new EmployeeView();
        input.setId(21L);
        input.setFirstName("ram");
        input.setLastName("Mohan");
        input.setTimeTable(timeTableViews);

        // Create output exployee
        final Set<TimeTableBO> timeTable = new HashSet<>();
        final TimeTableBO tt = new TimeTableBO();
        tt.setId(21);
        tt.setBegin(new Date());
        tt.setEnd(new Date());
        tt.setBegin_break(new Date());
        tt.setEnd_break(new Date());
        timeTable.add(tt);

        final EmployeeBO expectedOutput = new EmployeeBO();
        expectedOutput.setId(42);
        expectedOutput.setFirstName("ram");
        expectedOutput.setLastName("Mohan");
        expectedOutput.setTimeTable(timeTable);

        // Run mapper method
        final EmployeeBO actualOutput = EmployeeBOMapper.from(input);

        assertEquals(expectedOutput, actualOutput);
    }

}


