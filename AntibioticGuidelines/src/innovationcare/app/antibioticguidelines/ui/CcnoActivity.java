package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class CcnoActivity extends Activity {
	private EditText edtAge, edtMess, edtTime, edtRuine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ccno);
		edtAge = (EditText) findViewById(R.id.age);
		edtMess = (EditText) findViewById(R.id.mess);
		edtTime = (EditText) findViewById(R.id.time);
		edtRuine = (EditText) findViewById(R.id.vruine);
	}

	public void calculate(View v) {
		try {
			double age = Double.parseDouble(edtAge.getText().toString());
			double mess = Double.parseDouble(edtMess.getText().toString());
			double time = Double.parseDouble(edtTime.getText().toString());
			double ruine = Double.parseDouble(edtRuine.getText().toString());
			double result = age * ruine / (mess * time * 60);
			new AlertDialog.Builder(this).setTitle("Result")
					.setMessage("CreatinineClearance=" + result)
					.setPositiveButton("OK", null).show();
		} catch (NumberFormatException e) {
			new AlertDialog.Builder(this).setTitle("Bad Input")
					.setMessage("Enter Numbers Plz")
					.setPositiveButton("OK", null).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cockroft, menu);
		return true;
	}

}
