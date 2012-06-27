package attendance.project;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class CourseSelectionActivity extends Activity{	
	
	    private String selectedCourse = null;
	    //private String [] availableCourses;
	    private String domain;
	    private ArrayList<String> courses;
	     
	    MoodleConnector connector;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.page3);
	        //get reference to the spinner from the XML layout
	        Spinner spinner = (Spinner) findViewById(R.id.spinner);
	        
	        /*availableCourses = new String[100];
	        for (int i = 0; i < 100; i ++){
	        	availableCourses[i] = i + "";
	        }*/
	        
	        
	        String functionName = "moodle_enrol_get_users_courses";
	        String urlParameters = "";
	        
	        try {
				urlParameters = "userid="+URLEncoder.encode("5","UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Intent sourceIntent = this.getIntent();
	        String username = sourceIntent.getExtras().getString("user");
	        String password = sourceIntent.getExtras().getString("pass");
	        domain = sourceIntent.getExtras().getString("domain");
	        
	        //Toast.makeText(this, username + " " + password + " " + domain, Toast.LENGTH_SHORT).show();
	   
	        connector = new MoodleConnector(domain,urlParameters,functionName);
	        String results = connector.communicate();
	        String[] splits = results.toString().split("<|VALUE|>");
			int j = 0;
			courses = new ArrayList<String>(100);
			for(int i=33; i<splits.length; i+=64){
				courses.add(j, splits[i]);
				j++;
			}
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	        										android.R.layout.simple_spinner_dropdown_item, 
	        										courses);
	        
	        spinner.setAdapter(adapter);
	        //attach the listener to the spinner
	        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
	        
	    }

	    public class MyOnItemSelectedListener implements OnItemSelectedListener {
	        
	    	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
	            String selectedItem = parent.getItemAtPosition(pos).toString();
	            
	            //check which spinner triggered the listener
	            switch (parent.getId()) {
	            
	            //course spinner
	            case R.id.spinner:
	                
	            	//make sure the course was already selected during the onCreate
	                if(selectedCourse != null){
	                    Toast.makeText(parent.getContext(), "Selected course is " + selectedItem,
	                    Toast.LENGTH_LONG).show();
	                    Intent selectCourse = new Intent(getApplicationContext(), AttendActivity.class);
	                    selectCourse.putExtra("domain", domain);
	                    startActivity(selectCourse);
	                }
	                selectedCourse = selectedItem;
	                
	                break;
	            }
	        }

	        public void onNothingSelected(AdapterView<?> parent) {
	            // Do nothing.
	        }
	    }
} 