package com.example.demomanager;

import com.example.demomanager.models.Department;
import com.example.demomanager.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Stream;

import static java.lang.System.exit;

@SpringBootApplication
public class DemoManagerApplication{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoManagerApplication.class, args);
	}
}
