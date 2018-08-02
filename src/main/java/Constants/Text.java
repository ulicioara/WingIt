package Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Text {

	public static String TAB3TEXT1;
	public static String TAB3TEXT2;

	public void readMessages() {
		File file = new File("D:\\PracticeDemo\\resources\\text.properties");
		FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();

		// load messages file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		System.out.println("loaded text");


		TAB3TEXT1 = prop.getProperty("Tab3Text1");
		System.out.println(TAB3TEXT1);
		
		TAB3TEXT2 = prop.getProperty("Tab3Text2");
		System.out.println(TAB3TEXT2);

	
		System.out.println("read text");

	}
	
	
}
