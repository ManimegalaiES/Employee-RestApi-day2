package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> emp = new ArrayList<>(
            Arrays.asList(new Employee(1,"Prasanth","Trainer"),
                    new Employee(2,"Yuvaraj","Faculty"))
    );
    public List<Employee> getMethod() {
        return emp;
    }

    public Employee getEmployeeById(int empid) {
        int ind=0;
        boolean flag=false;
        for(int i=0;i<emp.size();i++){
            if(empid==emp.get(i).getEmpid()){
                System.out.println("Emp_Id: "+emp.get(i).getEmpid()+emp.get(i));
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
           return emp.get(ind);
        }else{
            return new Employee();
        }

    }

    public void postmethodhws(Employee employee) {
        emp.add(employee);
    }


    public String DeleteMethod(){
        return "This is Delete Method";
    }


    public void DeleteById(int empid) {
        int ind=0;
        boolean flag=false;
        for(int i=0;i<emp.size();i++){
            if(empid==emp.get(i).getEmpid()){
                System.out.println("Emp_Id: "+emp.get(i).getEmpid()+emp.get(i));
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
            emp.remove(ind);
        }else{
            System.out.println("Employee no found");
        }
    }

    public String putMethod(Employee employee) {
        int ind=0;
        boolean flag=false;
        for(int i=0;i<emp.size();i++){
            if(employee.getEmpid()==emp.get(i).getEmpid()){
                System.out.println("Emp_Id: "+emp.get(i).getEmpid()+emp.get(i));
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
            emp.set(ind,employee);
            return "Employee updated successfully";
        }else{
            System.out.println("Employee no found");
            return "Employee not updated";
        }

    }
}
