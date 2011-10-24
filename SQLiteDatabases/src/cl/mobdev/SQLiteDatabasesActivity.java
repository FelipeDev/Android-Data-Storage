package cl.mobdev;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SQLiteDatabasesActivity extends Activity {
    /** Called when the activity is first created. */
	  private TextView output;
	    
	   private DBHelper dh;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	       
	        output = (TextView) findViewById(R.id.myTextView);
	        this.dh = new DBHelper(this);
	        this.dh.deleteAll();
	        this.dh.insert("Erwin San Juan");
	        this.dh.insert("Rodrigo Quiroz");
	        this.dh.insert("Leonardo Ilivares");        
	        List<String> names = this.dh.selectAll();
	        StringBuilder sb = new StringBuilder();
	        sb.append("Nombres en la base de datos:\n");
	        for (String name : names) {
	           sb.append(name + "\n");
	        }
	        Log.d("Ejemplo", "tama–o de los nombres - " + names.size());
	         
	        output.setText(sb.toString());
	     }
}