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
       	SharedPreferences settings = getSharedPreferences(Calc.PREFS_NAME, 0);
       	SharedPreferences.Editor editor = settings.edit();
       	editor.putBoolean("silentMode",true);
       	editor.commit();
    }   
	
}