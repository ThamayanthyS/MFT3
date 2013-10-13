package com.example.mft3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class AddFriendsActivity extends Activity {
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_friends);
		db = openOrCreateDatabase("MFTDB", MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS Contacts(fname VARCHAR,fphone VARCHAR PRIMARY KEY,email VARCHAR);");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_friends, menu);
		return true;
	}
	
	public void back(View view) {
		Intent back=new Intent(getApplicationContext(),ContactActivity.class);
		startActivity(back);
	}

	public void AddContact(View view) {
		
		String frname;
		String frphno;
		String fremail;
		System.out.println("DDDDdddddDDDD");
		EditText editText1 = (EditText) findViewById(R.id.friendName);
		EditText editText2 = (EditText) findViewById(R.id.friendPhoneno);
		EditText editText3 = (EditText) findViewById(R.id.friendemail);

		frname = editText1.getText().toString();
		frphno = editText2.getText().toString();
		fremail = editText3.getText().toString();
		
		db.execSQL("INSERT INTO Contacts VALUES('" + frname + "','" + frphno	+ "','" + fremail + "');");

		System.out.println(frname + "DDDDDDDD" + frphno);
		Intent addfriendAct=new Intent(getApplicationContext(), AddFriendsActivity.class);
		startActivity(addfriendAct);

	}
	public void cancel(View view) {	
		Intent addfriendAct=new Intent(getApplicationContext(), AddFriendsActivity.class);
		startActivity(addfriendAct);
	}

}
