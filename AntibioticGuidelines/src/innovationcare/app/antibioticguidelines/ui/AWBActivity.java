package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import android.app.Activity;
import android.app.AlertDialog;
<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
=======
import android.os.Bundle;
import android.view.Menu;
>>>>>>> bac665e2a53258f4685a4814cf9b48a49db1fac1
import android.view.View;
import android.widget.EditText;

public class AWBActivity extends Activity {
	private EditText edtAge, edtMess;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
<<<<<<< HEAD
		setContentView(R.layout.activity_cockroft);
=======
		setContentView(R.layout.activity_awb);
>>>>>>> bac665e2a53258f4685a4814cf9b48a49db1fac1
		edtAge = (EditText) findViewById(R.id.age);
		edtMess = (EditText) findViewById(R.id.mess);
	}

	public void calculate(View v) {
<<<<<<< HEAD
		double age = Double.parseDouble(edtAge.getText().toString());
		double mess = Double.parseDouble(edtMess.getText().toString());
		double result = age * 0.6 + mess * 0.4;
		new AlertDialog.Builder(this).setTitle("Result")
				.setMessage("ABW=" + result).setPositiveButton("OK", null)
				.show();
=======
		try {
			double age = Double.parseDouble(edtAge.getText().toString());
			double mess = Double.parseDouble(edtMess.getText().toString());
			double result = age * 0.6 + mess * 0.4;
			if (mess > 200 || mess < 10) {
				new AlertDialog.Builder(this)
						.setTitle("Bad Input")
						.setMessage(
								"Sorry,actual weight out of boundary,limited:10-200")
						.setPositiveButton("OK", null).show();
			} else {
				new AlertDialog.Builder(this).setTitle("Result")
						.setMessage("ABW=" + result)
						.setPositiveButton("OK", null).show();
			}
		} catch (NumberFormatException e) {
			new AlertDialog.Builder(this).setTitle("Bad Input")
					.setMessage("Enter Numbers Plz")
					.setPositiveButton("OK", null).show();
		}
>>>>>>> bac665e2a53258f4685a4814cf9b48a49db1fac1

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
<<<<<<< HEAD
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
=======
		getMenuInflater().inflate(R.menu.cockroft, menu);
		return true;
	}

>>>>>>> bac665e2a53258f4685a4814cf9b48a49db1fac1
}
