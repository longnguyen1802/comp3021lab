package comp3021.lab6.base;

import java.io.File;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.io.BufferedWriter;
import java.io.FileWriter;
@SuppressWarnings("unused")
public class TextNote extends Note{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String content;
	public TextNote(String title,String content) {
		super(title);
		this.content = content;
	}
	public TextNote(File f) {
		super(f.getName());
		this.content = getTextFromFile(f.getAbsolutePath());
	}
	private String getTextFromFile(String absolutePath) {
		String result;
		try {
            result = readFile(absolutePath);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
	public void exportTextToFile(String pathFolder) {
        //TODO           
	File file = new File( pathFolder + File.separator +super.getTitle().replace(" ", "_")+ ".txt");
	System.out.println(file.getName());
	// TODO
	try {
	      FileWriter myWriter = new FileWriter(file);
	      myWriter.write(this.content);
	      myWriter.close();
	    } catch (IOException e) {
	      
	      e.printStackTrace();
	    }
	}
	public static String readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
