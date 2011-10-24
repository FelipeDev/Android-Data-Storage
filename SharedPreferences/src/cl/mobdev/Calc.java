package cl.mobdev;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Calc extends Activity {
	
	protected static final String PREFS_NAME = "MyPrefsFile";
	protected static boolean mSilent = false;
   
	@Override
    protected void onCreate(Bundle state){
       super.onCreate(state);
       SharedPreferences settings = getSharedPreferences(Calc.PREFS_NAME, 0);
       boolean silent = settings.getBoolean("silentMode", false);
       Calc.mSilent = silent;
       System.out.println("************** Silent Value: " + Calc.mSilent + " **************");
    }
    
	@Override
    protected void onStop(){
       	super.onStop();
       	//Si al invocar el archivo Žste no existe, entonces se crear‡ uno con ese nombre.
       	SharedPreferences settings = getSharedPreferences(Calc.PREFS_NAME, 0);
       	//SharedPreferences.Editor es la interfaz que se utiliza para modificar los valores en un objeto SharedPreferences. 
       	//Todos los cambios que se realizan en un editor se realizan por lotes, y no se copian en el SharedPreferences original hasta que se ejecute commit() o apply()
       	SharedPreferences.Editor editor = settings.edit();
       	editor.putBoolean("silentMode",true);
       	//S—lo al ejecutar commit(), los cambios ser‡n realziados al archivo.
       	editor.commit();
    }   
	
}