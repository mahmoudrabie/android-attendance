package attendance.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuActivity extends Activity {
    Button select;
    Button attend;
    Button close;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        
        select = (Button) findViewById(R.id.selectButton);
        attend = (Button) findViewById(R.id.attendanceButton);
        close = (Button) findViewById(R.id.updateButton);
        
        
        select.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				//Starting a new Intent
				Intent selectCourse = new Intent(getApplicationContext(), CourseSelectionActivity.class);
				// starting new activity
				startActivity(selectCourse);
				
			}
		});
        
        close.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				//Closing SecondScreen Activity
				finish();
			}
		});
    }
}
