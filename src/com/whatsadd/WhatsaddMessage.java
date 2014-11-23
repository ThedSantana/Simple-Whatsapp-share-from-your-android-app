package com.whatsadd;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

public class WhatsaddMessage extends ActionBarActivity {
	
	/*
	 * this method makes request to whatsapp 
	 * Activity passing message as string.
	 */
    
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
	
	public void sendWhatsAppMessageTo(String whatsappid, String testMessage) {
		
		// 				getSherlockActivity()
		//						||
		//						\/
		Cursor c = this.getApplication().getContentResolver().query(ContactsContract.Data.CONTENT_URI,
		        new String[] { ContactsContract.Contacts.Data._ID }, ContactsContract.Data.DATA1 + "=?",
		        new String[] { whatsappid }, null);
		c.moveToFirst();

		Intent whatsapp = new Intent(Intent.ACTION_VIEW, Uri.parse("content://com.android.contacts/data/" + c.getString(0)));
		c.close();
		
		// Call Whats app
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, testMessage);
		sendIntent.setType("text/plain");
		
		// Calling whatsapp activity
		sendIntent.setPackage("com.whatsapp");
		sendIntent.putExtra("chat",true);
		
		// Start Activity
		startActivity(sendIntent);

		 if (whatsapp != null) {

		startActivity(whatsapp);      

		} else {
		        Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
		                .show();
		//download for example after dialog
		                Uri uri = Uri.parse("market://details?id=com.whatsapp");
		                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
		    }

		}
}
