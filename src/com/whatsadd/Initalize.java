package com.whatsadd;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Initalize extends ActionBarActivity {
	
	Button publishBtn;
	EditText addsMessage;
	
	/*
	 * Advertisement message
	 */
	// 249928413392@s.whatsapp.net
	String testId = "924813392@s.whatsapp.net";
	String testMessage = "This is test message From whatssAdd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initalize_layout);
        
        publishBtn = (Button) findViewById(R.id.publishBtn);
        addsMessage = (EditText) findViewById(R.id.addsMessage);
        
        publishBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				callWhatsapp(addsMessage.getText().toString());
				Toast.makeText(getApplicationContext(), "Send will be shared...",Toast.LENGTH_LONG).show();
			}
		}); 
    }
    
    public void callWhatsapp(String testMessage) {
		Intent waIntent = new Intent(Intent.ACTION_SEND);
		waIntent.setType("text/plain");
		waIntent.setPackage("com.whatsapp");
		if (waIntent != null) {
		    waIntent.putExtra(Intent.EXTRA_TEXT, testMessage);//
		    startActivity(Intent.createChooser(waIntent, "Share with"));
		} else {
		    Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
		            .show();
		}
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.initalize, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
