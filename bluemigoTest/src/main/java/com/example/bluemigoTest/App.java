package com.example.bluemigoTest;

import java.io.IOException;


import com.example.bluemigoTest.Helpers.CSVReaderUtil;
import com.example.bluemigoTest.Helpers.GlobalConstants;

import com.opencsv.exceptions.CsvException;

public class App {
  public static void main(String[] args) {
	  try {
		  CSVReaderUtil.generateOutput(GlobalConstants.OUTPUT_FILEPATH);
      } catch (IOException | CsvException e) {
          e.printStackTrace();
      }
  }
}
