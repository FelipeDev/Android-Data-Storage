package cl.mobdev;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class ExternalStorageActivity extends Activity {
    /** Called when the activity is first created. */
	
	/**
	 * El almacenamiento en medios externos también es posible de realizar en el simulador.
	 * Al crear un nuevo AVD, es posible definir un medio externo e incluso asignarle un tamaño por defecto.
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;
       
        //La clase Environment provee acceso a las variables del ambiente Android.
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // Se puede leer y escribir el medio
            mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // Sólo se puede leer el medio
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            // Para este ejemplo, el "else" nos indica que algo anda mal. Cualquiera de los otros dos estados es suficiente,
        	// pues sólo necesitamos saber si podemos leer y/o escribir en el medio externo
            mExternalStorageAvailable = mExternalStorageWriteable = false;
        }
        
        System.out.println("mExternalStorageAvailable: " + mExternalStorageAvailable);
        System.out.println("mExternalStorageWriteable: " + mExternalStorageWriteable);
    }
}