package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.Interaction;
import innovationcare.app.antibioticguidelines.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class DisplayAntibioticLinkActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_antibiotic_link);
		
		Intent intent = getIntent();
		String URL = intent.getStringExtra("URL");
		String name = intent.getStringExtra("name");
		setTitle(name);
		if(!URL.contains("http://"))
			URL = "http://" + URL;
		final WebView wv = (WebView) findViewById(R.id.wvinteraction);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		wv.getSettings().setSupportZoom(true);
		wv.setWebViewClient(new Interaction());
		wv.loadUrl(URL);
		final Button btnback=(Button)findViewById(R.id.btnback);
		btnback.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				wv.goBack();
			}
		});
		final Button btnforward=(Button)findViewById(R.id.btnforward);
		btnforward.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				wv.goForward();
			}
		});
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
