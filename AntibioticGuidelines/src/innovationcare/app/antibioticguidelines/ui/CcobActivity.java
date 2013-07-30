package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CcobActivity extends Activity {
	private RadioGroup gender;
	private RadioButton female, male;
	private EditText edtAge, edtMess, edtSC;
	private double h =12.1,h2=0.916,a=136,w=0.285; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cockroft);
		edtAge = (EditText) findViewById(R.id.age);
		edtMess = (EditText) findViewById(R.id.mess);
		edtSC = (EditText) findViewById(R.id.sc);
		gender = (RadioGroup) findViewById(R.id.gender);
		male = (RadioButton) findViewById(R.id.male);
		female = (RadioButton) findViewById(R.id.female);
		gender.setOnCheckedChangeListener(mChangeRadio);
	}

	private RadioGroup.OnCheckedChangeListener mChangeRadio = new RadioGroup.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			if (checkedId == male.getId()) {
				h =12.1;h2=0.916;a=137;w=0.285;
			} else if (checkedId == female.getId()) {
				h =9.74;h2=0.679;a=146;w=0.287;
			}
		}
	};

	public void calculate(View v) {
		double age = Double.parseDouble(edtAge.getText().toString());
		double mess = Double.parseDouble(edtMess.getText().toString());
		double sc = Double.parseDouble(edtSC.getText().toString());
		double result = (a-age)*w*mess+(sc*h)/h2;
		new AlertDialog.Builder(this).setTitle("Result")
				.setMessage("Crreatinine Clearance=" + result).setPositiveButton("OK", null)
				.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.returnToHomeButton:
	            Intent intent = new Intent(this, MainActivity.class);
	            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
