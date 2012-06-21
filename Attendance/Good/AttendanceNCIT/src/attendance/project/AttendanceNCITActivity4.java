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
import android.os.Bundle;
import android.widget.Toast;


public class AttendanceNCITActivity4 extends Activity{	
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.page4);
	       
	      /// NEED TO BE CHANGED
	        String token = "edec61a38543c97f20fa57d510c9a489";
	        String domainName = "http://192.168.0.106/moodle/";
	        
	        /// REST RETURNED VALUES FORMAT
	        String restformat = "xml"; //Also possible in Moodle 2.2 and later: 'json'
	                                   //Setting it to 'json' will fail all calls on earlier Moodle version
	        if (restformat.equals("json")) {
	            restformat = "&moodlewsrestformat=" + restformat;
	        } else {
	            restformat = "";
	        }
	        
	        /// PARAMETERS - NEED TO BE CHANGED IF YOU CALL A DIFFERENT FUNCTION
	        String functionName = "moodle_user_create_users";
	        String urlParameters = null;
			try {
				urlParameters = "users[0][username]=" + URLEncoder.encode("testusername1", "UTF-8") +
				"&users[0][password]=" + URLEncoder.encode("123!Moodle", "UTF-8") +
				"&users[0][firstname]=" + URLEncoder.encode("testfirstname1", "UTF-8") +
				"&users[0][lastname]=" + URLEncoder.encode("testlastname1", "UTF-8") +
				"&users[0][email]=" + URLEncoder.encode("razvanprejbeanu@yahoo.com", "UTF-8") +
				"&users[0][auth]=" + URLEncoder.encode("manual", "UTF-8") +
				"&users[0][idnumber]=" + URLEncoder.encode("testidnumber1", "UTF-8") +
				"&users[0][lang]=" + URLEncoder.encode("en", "UTF-8") +
				"&users[0][theme]=" + URLEncoder.encode("standard", "UTF-8") +
				"&users[0][timezone]=" + URLEncoder.encode("-12.5", "UTF-8") +
				"&users[0][mailformat]=" + URLEncoder.encode("0", "UTF-8") +
				"&users[0][description]=" + URLEncoder.encode("Hello World!", "UTF-8") +
				"&users[0][city]=" + URLEncoder.encode("testcity1", "UTF-8") +
				"&users[0][country]=" + URLEncoder.encode("au", "UTF-8") +
				"&users[0][preferences][0][type]=" + URLEncoder.encode("preference1", "UTF-8") +
				"&users[0][preferences][0][value]=" + URLEncoder.encode("preferencevalue1", "UTF-8") +
				"&users[0][preferences][1][type]=" + URLEncoder.encode("preference2", "UTF-8") +
				"&users[0][preferences][1][value]=" + URLEncoder.encode("preferencevalue2", "UTF-8") +
				"&users[1][username]=" + URLEncoder.encode("testusername2", "UTF-8") +
				"&users[1][password]=" + URLEncoder.encode("123!Moodle", "UTF-8") +
				"&users[1][firstname]=" + URLEncoder.encode("testfirstname2", "UTF-8") +
				"&users[1][lastname]=" + URLEncoder.encode("testlastname2", "UTF-8") +
				"&users[1][email]=" + URLEncoder.encode("razvanprejbeanu@yahoo.com", "UTF-8") +
				"&users[1][timezone]=" + URLEncoder.encode("Pacific/Port_Moresby", "UTF-8");
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
				    rd.close();
			        System.out.println(response.toString());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Toast.makeText(this, "Data sent to Moodle server", Toast.LENGTH_SHORT).show();
	        
	    }

} 