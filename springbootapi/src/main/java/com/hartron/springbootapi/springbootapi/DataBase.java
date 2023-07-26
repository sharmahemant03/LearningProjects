package com.hartron.springbootapi.springbootapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataBase {


    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);


    final static String DB_URL="jdbc:mysql://localhost/hemant";
        final static String USER="root";
        final static String PASS="Hemant@123";

        final static  String QUERY="select * from employee";


        public Response addEmployee(Employee employee) throws RuntimeException{

            try(Connection conn1= DriverManager.getConnection(DB_URL,USER, PASS)){
                Statement stmt1= conn1.createStatement();

                String name =employee.getName();
                String role=employee.getRole();

                String insert1="INSERT INTO employee( Name, Role)  VALUES ('"+name+"', '"+ role +"');";
                log.info("querystring"+ insert1);

                boolean success = stmt1.execute(insert1);



//                return new Response("Successfully inserted MUBARKAAN ", "200");

                if(success){

                    return new Response("Successfully inserted MUBARKAAN ", "200");

                }else{
                    return new Response("Error Encountered","404");

                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }





    }
}


