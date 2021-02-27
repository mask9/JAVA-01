package bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class School implements ISchool {
    
    // Resource
    @Autowired(required = true)
            Klass klass;
    
    @Resource
    Student student;
    
    @Override
    public void doSomeThing(){
        System.out.println("student:"+student.getName());
    }
}