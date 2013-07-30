package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MdrdActivity extends Activity {
	private RadioGroup gender,race;
	private RadioButton female, male,a,n;
	private EditText edtAge, edtSC;
	private double temp = 1.00;
	private double ra = 1.21;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cockroft);
		edtAge = (EditText) findViewById(R.id.age);
		edtSC = (EditText) findViewById(R.id.sc);
		gender = (RadioGroup) findViewById(R.id.gender);
		race = (RadioGroup) findViewById(R.id.race);
		male = (RadioButton) findViewById(R.id.male);
		a=(RadioButton) findViewById(R.id.american);
		n=(RadioButton) findViewById(R.id.nonamerican);
		female = (RadioButton) findViewById(R.id.female);
		gender.setOnCheckedChangeListener(mChangeRadio);
		race.setOnCheckedChangeListener(mChangeRace);
	}
	private RadioGroup.OnCheckedChangeListener mChangeRadio = new RadioGroup.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			if (checkedId == male.getId()) {
				temp = 1.00;
			} else if (checkedId == female.getId()) {
				temp = 0.743;
			}
		}
	};
	private RadioGroup.OnCheckedChangeListener mChangeRace = new RadioGroup.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			if (checkedId == a.getId()) {
				ra = 1.21;
			} else if (checkedId == n.getId()) {
				ra=1.0;
			}
		}
	};
	public void calculate(View v) {
		double age = Double.parseDouble(edtAge.getText().toString());
		double sc = Double.parseDouble(edtSC.getText().toString());
		double result = 32788*(Math.pow(age,-0.203))*(Math.pow(sc,-1.154))*ra*temp;
		new AlertDialog.Builder(this).setTitle("Result")
				.setMessage("MDRD=" + result).setPositiveButton("OK", null)
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
