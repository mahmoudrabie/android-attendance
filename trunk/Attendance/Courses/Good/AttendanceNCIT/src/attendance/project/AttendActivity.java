package attendance.project;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class AttendActivity extends Activity{	
	    
		private CheckBox attendCourse;
		private CheckBox attendLab;
		private Button attendButton;
		private MoodleConnector moodleConnector;
		
		//private String domainName = "http://192.168.0.106/moodle";
		private  String domainName = "";
		//private String token = "a95627c35b4c824d90f9445bf828e571";
		
		
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.page4);
	       
	        Intent sourceIntent = getIntent();
	        domainName = sourceIntent.getExtras().getString("domain");
	        
	        
	        String urlParameters = null;
			try {
				urlParameters = "attendanceid=" + URLEncoder.encode("3","UTF-8");
				
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        moodleConnector = new MoodleConnector(domainName,urlParameters,"mod_attforblock_get_attendance_data");
	        
	        
	        attendCourse = (CheckBox)findViewById(R.id.attend_course);
	        attendLab = (CheckBox)findViewById(R.id.attend_lab);
	        attendButton = (Button)findViewById(R.id.check_attend);
	        
	        attendButton.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					attendSelected();
				}
			});
	        
	        
	    }
	    
	    public void attendSelected(){
	    	//String result = moodleConnector.communicate();
	    	//System.out.println(result);
	    	//Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
	    	
	    	/*
	    	// REST RETURNED VALUES FORMAT
	        String restformat = "xml"; //Also possible in Moodle 2.2 and later: 'json'
	                                   //Setting it to 'json' will fail all calls on earlier Moodle version
	        if (restformat.equals("json")) {
	            restformat = "&moodlewsrestformat=" + restformat;
	        } else {
	            restformat = "";
	        }
	        
	        /// PARAMETERS - NEED TO BE CHANGED IF YOU CALL A DIFFERENT FUNCTION
	        String functionName = "moodle_user_get_users_by_id";
	        String urlParameters = null;
			try {
				urlParameters = "userids[0]=" + URLEncoder.encode("1","UTF-8");
				
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        /// REST CALL
	                
	        // Send request
	        String serverurl = domainName + "/webservice/rest/server.php" + "?wstoken=" + token + "&wsfunction=" + functionName;
	        HttpURLConnection con = null;
			try {
				con = (HttpURLConnection) new URL(serverurl).openConnection();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				con.setRequestMethod("POST");
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        con.setRequestProperty("Content-Type", 
	           "application/x-www-form-urlencoded");
	        con.setRequestProperty("Content-Language", "en-US");
	        con.setDoOutput(true);
	        con.setUseCaches (false);
	        con.setDoInput(true);
	        DataOutputStream wr = null;
			try {
				wr = new DataOutputStream (
				          con.getOutputStream ());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				wr.writeBytes (urlParameters);
				wr.flush ();
		        wr.close ();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        //Get Response
	        InputStream is = null;
			try {
				is = con.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	        String line;
	        StringBuilder response = new StringBuilder(); 
	        try {
				while((line = rd.readLine()) != null) {
				    response.append(line);
				    response.append('\r');
			        //System.out.println(response.toString());
				}
				rd.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Toast.makeText(this, "Data sent to Moodle server", Toast.LENGTH_SHORT).show();
	        */
	    	
	    }

} 