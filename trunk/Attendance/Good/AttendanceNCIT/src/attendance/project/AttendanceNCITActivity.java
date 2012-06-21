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
					Intent nextScreen = new Intent(AttendanceNCITActivity.this,MainMenuActivity.class);
					
					// starting new activity
					startActivity(nextScreen);
					
				}
			});
		}
		
		public String getUsername(){
			return inputUsername.getText().toString();
		}
		
		public String getPassword(){
			return inputPassword.getText().toString();
		}
} 