package app.springbootdemo.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    public List<ReportBean> getReport(long id){
        return  reportRepository.getReportList(id);

    }
}
