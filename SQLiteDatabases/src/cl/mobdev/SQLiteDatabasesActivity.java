package cl.mobdev;

import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Activity que muestra datos creados en la base de datos en la clase DBHelper.java
 * @author FelipeDev
 */
public class SQLiteDatabasesActivity extends Activity {
	private TextView output;
	private DBHelper dh;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		    setContentView(R.layout.main);
		    output = (TextView) findViewById(R.id.myTextView);
		    this.dh = new DBHelper(this);
		    this.dh.deleteAll();
		    this.dh.insert("Pedro San Juan");
		    this.dh.insert("Guillermo Quiroz");
		    this.dh.insert("Bernardo Olivares");        
		    List<String> names = this.dh.selectAll();
		    StringBuilder sb = new StringBuilder();
		    sb.append("Nombres en la base de datos:\n");
		    for (String name : names) {
		    	sb.append(name + "\n");
		    }	        
		    Log.d("Ejemplo de SQL", "cantidad de nombres en DB: " + names.size());
		    output.setText(sb.toString());
	}	        
}