package cl.mobdev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class InternalStorageActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        String FILENAME = "myFile";
        String string = "Hello world!";
        FileOutputStream fos;
        FileInputStream fis;
		try {
			//Escritura
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.write(string.getBytes());
		    fos.close();
		    
		    //Lectura
		    fis = openFileInput(FILENAME);
		    byte[] buffer = new byte[12];//Un caracter son 8 bits = 1 byte.
			fis.read(buffer);
			String fileContent = new String(buffer);
			System.out.println("------>"+fileContent);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException!\n");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException!\n");
			e.printStackTrace();
		}
    }
}