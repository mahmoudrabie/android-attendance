package attendance.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;


public class CourseSelectionActivity extends Activity{	
	
	    private String selectedCourse = null;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.page3);
	        //get reference to the spinner from the XML layout
	        Spinner spinner = (Spinner) findViewById(R.id.spinner);
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