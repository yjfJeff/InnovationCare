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

public class AWBActivity extends Activity {
	private EditText edtAge, edtMess;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cockroft);
		edtAge = (EditText) findViewById(R.id.age);
		edtMess = (EditText) findViewById(R.id.mess);
	}

	public void calculate(View v) {
		double age = Double.parseDouble(edtAge.getText().toString());
		double mess = Double.parseDouble(edtMess.getText().toString());
		double result = age * 0.6 + mess * 0.4;
		new AlertDialog.Builder(this).setTitle("Result")
				.setMessage("ABW=" + result).setPositiveButton("OK", null)
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
