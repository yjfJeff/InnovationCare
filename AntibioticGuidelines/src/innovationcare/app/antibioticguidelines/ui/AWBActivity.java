package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
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
		getMenuInflater().inflate(R.menu.cockroft, menu);
		return true;
	}

}
