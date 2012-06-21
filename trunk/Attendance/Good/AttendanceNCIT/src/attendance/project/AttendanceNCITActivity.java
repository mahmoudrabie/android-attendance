package attendance.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import attendance.project.R;


public class AttendanceNCITActivity extends Activity {
		EditText inputUsername;
		EditText inputPassword;
		  
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.page1);		
			
			inputUsername = (EditText) findViewById(R.id.username_input);
			inputPassword = (EditText) findViewById(R.id.password_input);
			Button nextPage = (Button) findViewById(R.id.signInButton);
			
			//Listening to button event
			nextPage.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					//Starting a new Intent
					//Intent nextScreen = new Intent(getApplicationContext(), AttendanceNCITActivity2.class);
					Intent nextScreen = new Intent(AttendanceNCITActivity.this,MainMenuActivity.class);
					//Sending data to another Activity
					//nextScreen.putExtra("username_input", inputUsername.getText().toString());
					//nextScreen.putExtra("password_input", inputPassword.getText().toString());
					
					// starting new activity
					startActivity(nextScreen);
					
				}
			});
		}
} 