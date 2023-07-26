package com.hartron.springbootapi.springbootapi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController

public class Controller {
    private static final Logger log = LoggerFactory.getLogger(Controller.class);


    private final EmployeeRepository repository;
    DataBase DB ;
     Controller ( EmployeeRepository repository){
         this.repository = repository;
         DB=new DataBase();
     }
         @GetMapping("/employees")
         List<Employee> all(){
             return repository.findAll();

         }
         @PostMapping("/employees")
         Employee newEmployee(@RequestBody Employee newEmployee)  {
         DB.addEmployee(newEmployee);
         return repository.save(newEmployee);


         }

   






    @GetMapping("/employees/{id}")
        Employee one(@PathVariable Long id) throws Exception {
         return repository.findById(id).orElseThrow(()-> new Exception ("id"));
        }


        @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){
         return repository.findById(id).map(employee ->{
             employee.setName( newEmployee.getName());
             employee.setRole(newEmployee.getRole());
             return repository.save(employee);
        })
                 .orElseGet(()-> {newEmployee.setId(id);
                 return repository.save(newEmployee);});}

        @DeleteMapping("/employees/{id}")
        String deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
        return "OK";
     }



    @PatchMapping("/newemployees/{id}")
    Optional<Employee> updateRequest(@RequestBody Employee newEmployee,@PathVariable Long id){
        log.info("Saved response "+ newEmployee.toString());

         return repository.findById(id).map(employee -> {
             employee.setName(newEmployee.getName());
             employee.setRole(newEmployee.getRole());
             log.info("Saved response" + employee.toString());

              repository.save(employee);

                return employee;
         });





    }}

