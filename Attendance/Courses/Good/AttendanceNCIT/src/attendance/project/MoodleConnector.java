package attendance.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;



import android.util.Log;
import android.widget.Toast;

public class MoodleConnector {
		private String urlParameters;
		//private String domainName = "http://192.168.0.103";
		private String domainName = "";
		//private String token = "ed45f37a9909e546ae68602fbf374847";
		private String token = "";
		private String connectionResult = "";
		private String functionName;
		
		public MoodleConnector(String domainName,String urlParameters, String functionName){
			this.urlParameters = urlParameters;
			this.functionName = functionName;
			this.domainName = domainName;
			
			File f = new File("/mnt/sdcard/moodlesessions/savedTokens.txt");
			Scanner scanner = null;
			
			try {
				scanner = new Scanner(f);
				String mdPass = scanner.nextLine();
				token = scanner.nextLine();
				scanner.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				Log.i("MoodleConnector.class", "con este nenul");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				con.setRequestMethod("POST");
				Log.i("MoodleConnector.class", "POST este nenul");
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				Log.i("MoodleConnector.class", "POST este nul");
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
				wr.writeBytes(urlParameters);
				wr.flush ();
		        wr.close ();
		        Log.i("MoodleConnector.class", "wr este nenul");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.i("MoodleConnector.class", "wr este nul");
				e.printStackTrace();
			}
	        
	        
	        
	        //Get Response
	        InputStream is = null;
			try {
				is = con.getInputStream();
				Log.i("MoodleConnector.class", "Is este nenul");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.i("MoodleConnector.class", "Is este nul");
				e.printStackTrace();
			}
	        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	        String line;
	        StringBuilder response = new StringBuilder(); 
	        try {
				while((line = rd.readLine()) != null) {
				    response.append(line);
				    //response.append('\r');
				}
				connectionResult = response.toString();
				rd.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        String fileName = "/mnt/sdcard/samsungapps/out.txt";
	        BufferedWriter b = null;
			try {
				b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName))));
				b.write(connectionResult);
				b.newLine();
				b.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				Log.i("Buf", "File Not Found");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.i("Buf", "IOExc");
				e.printStackTrace();
			}
	        
	        
	        
	        return connectionResult;
		}
		
}
