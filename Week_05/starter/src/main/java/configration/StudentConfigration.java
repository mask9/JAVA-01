package configration;

import bean.Klass;
import bean.School;
import bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfigration {
    @Bean
    public Student getStudent() {
        return new Student(100, "KK100");
    }
    
    @Bean
    public Klass getKlass() {
        List<Student> stuList = new ArrayList<>();
        stuList.add(getStudent());
        
        Klass k1 = new Klass();
        k1.setStudents(stuList);
        return k1;
    }
    
    @Bean
    public School getSchool() {
        return new School();
    }
}
