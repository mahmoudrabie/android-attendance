package attendance.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AttendanceNCITActivity extends Activity {
		EditText inputUsername;
		EditText inputPassword;
		EditText inputDomain;
		private String token;
		  
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.page1);		
			
			inputUsername = (EditText) findViewById(R.id.username_input);
			inputPassword = (EditText) findViewById(R.id.password_input);
			inputDomain = (EditText) findViewById(R.id.domain_input);
			Button nextPage = (Button) findViewById(R.id.signInButton);
			
			//Listening to button event
			nextPage.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					if (validPassword() == true){
						//Starting a new Intent
						Intent nextScreen = new Intent(AttendanceNCITActivity.this,MainMenuActivity.class);
						nextScreen.putExtra("user",getUsername());
						nextScreen.putExtra("pass",getPassword());
						nextScreen.putExtra("domain",getDomain());
						// starting new activity
						startActivity(nextScreen);
					}
					else{
						Toast.makeText(AttendanceNCITActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
		
		public boolean validPassword(){
			MDCalculator md = new MDCalculator(inputPassword.getText().toString());
			String mdPass = md.getMD();
			File f = new File("/mnt/sdcard/moodlesessions/savedTokens.txt");
			try {
				Scanner s = new Scanner(f);
				String mdStored = s.nextLine();
				String tokenStored = s.nextLine();
				s.close();
				if (mdStored != null && mdStored.equals(mdPass))
					return true;
				System.out.println(mdPass);
				System.out.println(mdStored);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			
			return false;
		}
		
		public String getUsername(){
			return inputUsername.getText().toString();
		}
		
		public String getPassword(){
			return inputPassword.getText().toString();
		}
		
		public String getDomain(){
			return inputDomain.getText().toString();
		}
		
		public String getToken(){
			return token;
		}
} 