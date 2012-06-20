package attendance.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AttendanceNCITActivity2 extends Activity {
    Button select;
    Button attend;
    Button close;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        
        //TextView txtName = (TextView) findViewById(R.id.txtUsername);
        //TextView txtEmail = (TextView) findViewById(R.id.txtPassword);
        select = (Button) findViewById(R.id.selectButton);
        attend = (Button) findViewById(R.id.attendanceButton);
        close = (Button) findViewById(R.id.updateButton);
        
        //Intent i = getIntent();
        // Receiving the Data
        //String username = i.getStringExtra("username_input");
        //String password = i.getStringExtra("password_input");
        
        // Displaying Received data
        //txtName.setText(username);
        //txtEmail.setText(password);
        
        // Binding Click event to Button
        
        
        select.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				//Starting a new Intent
				Intent selectCourse = new Intent(getApplicationContext(), AttendanceNCITActivity3.class);
				//Intent selectCourse = new Intent(AttendanceNCITActivity2.this,AttendanceNCITActivity3.class);
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
