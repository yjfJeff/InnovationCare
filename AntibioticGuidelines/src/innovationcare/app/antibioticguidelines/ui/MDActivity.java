package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MDActivity extends Activity {
	private RadioGroup gender, race;
	private RadioButton female, male, a, n;
	private EditText edtAge, edtSC;
	private double temp = 1.00;
	private double ra = 1.21;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_md);
		edtAge = (EditText) findViewById(R.id.age);
		edtSC = (EditText) findViewById(R.id.sc);
		gender = (RadioGroup) findViewById(R.id.gender);
		race = (RadioGroup) findViewById(R.id.race);
		male = (RadioButton) findViewById(R.id.male);
		a = (RadioButton) findViewById(R.id.american);
		n = (RadioButton) findViewById(R.id.nonamerican);
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
				ra = 1.0;
			}
		}
	};

	public void calculate(View v) {
		try {
			double age = Double.parseDouble(edtAge.getText().toString());
			double sc = Double.parseDouble(edtSC.getText().toString());
			double result = 32788 * (Math.pow(age, -0.203))
					* (Math.pow(sc, -1.154)) * ra * temp;
			if (age > 150 || age < 1) {
				new AlertDialog.Builder(this).setTitle("Bad Input")
						.setMessage("Sorry,age out of boundary,limited:1-150")
						.setPositiveButton("OK", null).show();
			} else if (sc > 1 || sc < 0.0005) {
				new AlertDialog.Builder(this).setTitle("Bad Input")
						.setMessage("Sorry,Creatinine Clearance out of boundary,limited:0.0005-1")
						.setPositiveButton("OK", null).show();
			} else {
				new AlertDialog.Builder(this).setTitle("Result")
						.setMessage("MDRD=" + result)
						.setPositiveButton("OK", null).show();
			}
		} catch (NumberFormatException e) {
			new AlertDialog.Builder(this).setTitle("Bad Input")
					.setMessage("Enter Numbers Plz")
					.setPositiveButton("OK", null).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.md, menu);
		return true;
	}

}
