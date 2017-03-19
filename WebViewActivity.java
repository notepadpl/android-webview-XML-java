package com.web;
import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
public class WebViewActivity extends Activity {
   Button b1;
   EditText ed1;

	 private WebView wv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		 b1=(Button)findViewById(R.id.button);
                ed1=(EditText)findViewById(R.id.editText);
		wv1 = (WebView) findViewById(R.id.webView);
		wv1.setWebViewClient(new MyBrowser());
		

      b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            String url = ed1.getText().toString();

            wv1.getSettings().setLoadsImagesAutomatically(true);
            wv1.getSettings().setJavaScriptEnabled(true);
            wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            wv1.loadUrl(url);
         }
      });
}
   private class MyBrowser extends WebViewClient {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
         view.loadUrl(url);
         return true;
      }
   }
}