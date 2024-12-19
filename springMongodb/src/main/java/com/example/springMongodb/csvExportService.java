package com.example.springMongodb;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class csvExportService {
	

	@Autowired(required=true)
    StedentRepository studentRepository;

    public void CsvExportService(StedentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void writeStudentsToCsv(Writer writer) {

        List<Student> students = studentRepository.findAll();
        
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("ID", "First Name", "Last Name", "city","college");
            for (Student student : students) {
            	String FirstName = null;
                String LastName = null;
                String nameArray[] = student.getName().split(" ");
            	FirstName = nameArray[0];
            	LastName = nameArray[1];
            	
                csvPrinter.printRecord(student.getId(), FirstName, LastName, student.getCity(), student.getCollege());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
