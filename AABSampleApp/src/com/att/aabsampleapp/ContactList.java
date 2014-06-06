package com.att.aabsampleapp;


import com.att.api.aab.service.ContactResultSet;
import com.att.api.error.AttSdkError;
import com.att.sdk.listener.AttSdkListener;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class ContactList extends TabActivity {
	
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_list);
		
		final TabHost tabHost = getTabHost();
		
		i = new Intent(this, AllContacts.class);
		i.putExtra("groupId", "-1");
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("CONTCTS")
				.setContent(i));
		
		i = new Intent(this, ContactDetails.class);
		i.putExtra("contactId", "MY_INFO");
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("MYINFO")
				.setContent(i));
	
		i = new Intent(this, GroupList.class);
		i.putExtra("groupId", "-1");
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("GROUPS")
				.setContent(i));
		
		i = new Intent(this, ContactDetails.class);
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("NEW")
				.setContent(i));
		
		i = new Intent(this, ContactDetails.class);
		i.putExtra("contactId", "NEW_CONTACT");
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("CONTACT")
				.setContent(i));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_list, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		//Contact c = getContactFromFields();
		switch(item.getItemId()) {
			case R.id.action_save :
				//UpdateMyInfo or UpdateContact API
				Toast.makeText(getApplicationContext(), "List Save clicked", Toast.LENGTH_LONG).show();
				break;
				
			case R.id.action_new :
				// Create new contact based on the values in the fields
				//Toast.makeText(getApplicationContext(), "List New clicked", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(ContactList.this, ContactDetails.class);
				intent.putExtra("contactId", "NEW_CONTACT");
				startActivity(intent);
				break;
			
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
		
}
