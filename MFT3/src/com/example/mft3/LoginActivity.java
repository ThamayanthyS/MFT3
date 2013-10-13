package com.example.mft3;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.StaticLayout;
import android.view.Menu;
import android.view.View;
//import android.view.KeyCharacterMap.UnavailableException;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mft3.RegisterActivity;
import android.view.SurfaceView;

public class LoginActivity extends Activity {

	RegisterActivity ra = new RegisterActivity();

	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		db = openOrCreateDatabase("MFTDB", MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS Owner(uname VARCHAR,pword VARCHAR,pnone VARCHAR);");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@SuppressWarnings("static-access")
	public void login(View view) {
		System.out.println("TTTTTTTTTT");

		String localuname = "";
		String localpword = "";
		EditText editText1 = (EditText) findViewById(R.id.lusername);
		EditText editText2 = (EditText) findViewById(R.id.lpassword);

		localuname = editText1.getText().toString();
		localpword = editText2.getText().toString();

		System.out.println("KKKKKK" + localpword + localuname + ra.uname
				+ ra.pword);
		// //System.out.print(RegisterActivity.getuname()+RegisterActivity.getpword());
		//
		// Cursor
		// c=db.rawQuery("SELECT * FROM Owner WHERE uname=? AND pword=? ",new
		// String[]{localuname,localpword});
		Cursor c = db.rawQuery("SELECT uname,pword FROM Owner", null);
		// WHERE uname="+localuname+"AND pword="+localpword
		c.moveToFirst();

		//
		// System.out.print("LLLLL");
		boolean b = false;

		for (int i = 0; i < c.getCount(); i++) {
			String uname = c.getString(c.getColumnIndex("uname"));
			String pword = c.getString(c.getColumnIndex("pword"));

			System.out.print("MMMMM");

			if (pword.equals(localpword) && uname.equals(localuname)) {
				// if(ra.pword.equals(localpword)&&ra.uname.equals(localuname)){
				b = true;
				Intent WelcomeIntent = new Intent(getApplicationContext(),
						WelcomeActivity.class);
				startActivity(WelcomeIntent);

				System.out.print("NNNNNnnnnnnn");
				break;
			}

			System.out.print("NNNNN");

			c.moveToNext();
		}
		if (b == false) {
			Intent loginAct = new Intent(getApplicationContext(),
					LoginActivity.class);
			startActivity(loginAct);
		}
	}
	public void cancel() {
		Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(mainIntent);
	}
	public void close(View view) {
		System.exit(0);
	}
}
