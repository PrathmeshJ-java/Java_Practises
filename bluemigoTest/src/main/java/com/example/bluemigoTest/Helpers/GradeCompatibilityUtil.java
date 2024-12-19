package com.example.bluemigoTest.Helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GradeCompatibilityUtil {

	public static Map<String, Set<String>> loadCompatibleGradesFromFile(String filePath) throws IOException {
        Map<String, Set<String>> compatibleGrades = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    String grade1 = parts[0].trim();
                    String grade2 = parts[1].trim();
                    
                    compatibleGrades.computeIfAbsent(grade1, k -> new HashSet<>()).add(grade2);
                    compatibleGrades.computeIfAbsent(grade2, k -> new HashSet<>()).add(grade1);
                }
            }
        }
        return compatibleGrades;
    }
    
	public static String getL1Group(String grade, Map<String, String> gradeToGroupMap) {
        return gradeToGroupMap.keySet().stream()
            .filter(g -> gradeToGroupMap.get(g).contains(grade))
            .findFirst()
            .orElse("Unknown");
    }

	
	}




