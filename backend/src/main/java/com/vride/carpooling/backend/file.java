package com.vride.carpooling.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class file {

	public static void main(String[] ardfg) {
		StringBuilder sb = new StringBuilder();
        String strLine = "";
        List<String> list = new ArrayList<String>();
        try {
             BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kirankishore\\Desktop\\file.txt"));
              while (strLine != null)
               {
                strLine = br.readLine();
                if (strLine==null)
                   break;
                list.add("\"" + strLine + "\"");
               }
              System.out.print(list);
      
             br.close();
        } catch (Exception e) {
            System.err.println("Unable to read the file.");
        }
	}
}
