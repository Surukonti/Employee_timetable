package app.springbootdemo.reports;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


public class ReportRepositoryCustomImpl implements ReportRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
    @Override
   // @Transactional
    public List<ReportBean> getReportList(long id) {

        String sql = "SELECT e.id, e.first_name, e.last_name, monthname(t.date), sum(hour(timediff(t.end_time,t.start_time))) " +
                "FROM testd.time_table t, testd.employee e where employee_id= :id\n" +" and e.id = t.employee_id group by monthname(t.date)";
        List<ReportBean> list = em.createNativeQuery(sql).setParameter("id",id).getResultList();

        return list;

    }
}
