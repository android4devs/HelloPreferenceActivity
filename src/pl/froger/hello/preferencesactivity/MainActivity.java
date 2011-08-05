package pl.froger.hello.preferencesactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
public class MainActivity extends Activity {
    private Button btnOpenPreferences;
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnOpenPreferences = (Button)findViewById(R.id.btnOpenPreferences);
        btnOpenPreferences.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startPreferencesActivity();
			}
		});
    }
    
    private void startPreferencesActivity() {
        Intent intent = new Intent(MainActivity.this, MyPreferences.class);
        startActivity(intent);
    }
}