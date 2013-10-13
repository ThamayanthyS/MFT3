package com.example.mft3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ContactActivity extends Activity {

	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		db = openOrCreateDatabase("MFTDB", MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS Contacts(fname VARCHAR,fphone VARCHAR PRIMARY KEY,email VARCHAR);");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact, menu);
		return true;
	}

	public void AddContact(View view) {
		Intent addIntent = new Intent(getApplicationContext(),
				AddFriendsActivity.class);
		startActivity(addIntent);

	}

	public void ViewContact(View view) {
		Cursor c = db.rawQuery("SELECT fname,fphone FROM Contacts", null);
		int count = c.getCount();
		c.moveToFirst();

		TableLayout tableLayout = new TableLayout(getApplicationContext());
		tableLayout.setVerticalScrollBarEnabled(true);
		TableRow tableRow;
		TextView textView, textView1;
		tableRow = new TableRow(getApplicationContext());

		textView = new TextView(getApplicationContext());
		textView.setText("Name");
		textView.setTextColor(Color.BLUE);
		textView.setTypeface(null, Typeface.BOLD);
		textView.setPadding(20, 20, 20, 20);
		tableRow.addView(textView);

		textView1 = new TextView(getApplicationContext());
		textView1.setText("Phone No");
		textView1.setTextColor(Color.BLUE);
		textView1.setTypeface(null, Typeface.BOLD);
		textView1.setPadding(20, 20, 20, 20);
		tableRow.addView(textView1);

		tableLayout.addView(tableRow);

		for (int j = 0; j < count; j++) {
			tableRow = new TableRow(getApplicationContext());

			textView = new TextView(getApplicationContext());
			textView.setText(c.getString(c.getColumnIndex("fname")));

			textView1 = new TextView(getApplicationContext());
			textView1.setText(c.getString(c.getColumnIndex("fphone")));

			textView.setPadding(20, 20, 20, 20);
			textView1.setPadding(20, 20, 20, 20);

			tableRow.addView(textView);
			tableRow.addView(textView1);

			tableLayout.addView(tableRow);
			c.moveToNext();
		}
		setContentView(tableLayout);
		db.close();
	}

	public void close(View view) {
		System.exit(0);
	}

}
