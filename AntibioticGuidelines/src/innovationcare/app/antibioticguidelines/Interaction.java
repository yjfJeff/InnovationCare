package innovationcare.app.antibioticguidelines;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Interaction extends WebViewClient {
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		view.loadUrl(url);
		return true;
	
	}

}
