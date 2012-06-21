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

import android.widget.Toast;

public class MoodleConnector {
		private String urlParameters;
		private String domainName = "http://192.168.0.106/moodle";
		private String token = "a95627c35b4c824d90f9445bf828e571";
		private String connectionResult = "";
		private String functionName;
		
		public MoodleConnector(String urlParameters, String functionName){
			this.urlParameters = urlParameters;
			this.functionName = functionName;
		}
		
		public String communicate(){
			// REST RETURNED VALUES FORMAT
	        String restformat = "xml"; //Also possible in Moodle 2.2 and later: 'json'
	                                   //Setting it to 'json' will fail all calls on earlier Moodle version
	        if (restformat.equals("json")) {
	            restformat = "&moodlewsrestformat=" + restformat;
	        } else {
	            restformat = "";
	        }
	        
	        /// PARAMETERS - NEED TO BE CHANGED IF YOU CALL A DIFFERENT FUNCTION
	       
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
			        connectionResult += response.toString();
				    //System.out.println(response.toString());
				}
				rd.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        return connectionResult;
		}
		
}
