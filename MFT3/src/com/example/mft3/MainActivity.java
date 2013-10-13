package com.example.mft3;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db=openOrCreateDatabase("MFTDB", MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS Contact(uname VARCHAR,pword VARCHAR,pnone VARCHAR,owner VARCHAR);");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void login(View view) {
		Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
		startActivity(loginIntent);
	}
	
	public void register(View view) {
		Intent registerIntent = new Intent(getApplicationContext(), RegisterActivity.class);
		startActivity(registerIntent);
	}

}
