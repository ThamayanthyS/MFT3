package com.thamaya.mft3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends Activity {
	public static String uname;
	public static String pword;
	public static String phone;

	
	SQLiteDatabase db;
	String dbuname,dbpword,dbphone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		db=openOrCreateDatabase("MFTDB", MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS Owner(uname VARCHAR,pword VARCHAR,pnone VARCHAR);");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}
	public void register(View view) {
		String localuname,localphone,localpword="",localrepword="";
		EditText editText1=(EditText)findViewById(R.id.username);
		EditText editText2=(EditText)findViewById(R.id.phoneno);
		EditText editText3=(EditText)findViewById(R.id.password);
		EditText editText4=(EditText) findViewById(R.id.repassword);
		
		localuname=editText1.getText().toString();
		localphone=editText2.getText().toString();
		localpword=editText3.getText().toString();
		localrepword=editText4.getText().toString();
		
		if((localpword.equals(localrepword))&&!(localuname==null||localphone==null)){
			
			db.execSQL("INSERT INTO Owner VALUES('"+localuname+"','"+localpword+"','"+localphone+"');");
			uname=localuname;
			pword=localpword;
			phone=localphone;
		
//			
			System.out.println("DDDDD");
			
			Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
			startActivity(loginIntent);
		}	
	}
	public void cancel() {
		Intent regIntent = new Intent(getApplicationContext(), RegisterActivity.class);
		startActivity(regIntent);
	}
	public void close(View view) {
		System.exit(0);
	}

}
