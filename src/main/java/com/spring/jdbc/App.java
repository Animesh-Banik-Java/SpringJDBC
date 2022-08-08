package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.spring.jdbc.dao.StudentDaoImp;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Please wait..! work in progress..!" );
       // ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/com/spring/jdbc/config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDaoImp dao = context.getBean("studentDao", StudentDaoImp.class);
        Student s = new Student();
        
		/* this code only for insert records
		   s.setId(0); s.setName("Pankaj"); s.setCity("Loni");
		   int r = dao.insert(s);
            System.out.println(r+" Row inserted..!");
		 */
        
        // this is the update code
		/*
		 * s.setId(6); s.setName("Rajesh"); s.setCity("Roorkee"); int r = dao.change(s);
		 * System.out.println(r+" Row updated..!");
		 */
        
// ********* this is the delete code 
//        s.setName("rajesh");
//        int r = dao.delete(s);
//        System.out.println(r+" row is deleted...!");
        
//*********select single student data 
//         Student student = dao.getStudent(1);
//         System.out.println(student.toString());
         
	        // ****************** select all student from table  
            System.out.println("Using forEach loop");
	        List<Student> allStudent = dao.getAllStudent();
	        for(Student s1: allStudent) {
	        	System.out.println(s1.toString());
	        } 
        
        	System.out.println("Using for loop");
        	for(int i=0; i<allStudent.size(); i++) {
            	System.out.println(allStudent.get(i));
            }
        
         
    }
}
