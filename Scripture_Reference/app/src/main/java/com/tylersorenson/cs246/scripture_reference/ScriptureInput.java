package com.tylersorenson.cs246.scripture_reference;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class ScriptureInput extends AppCompatActivity {
    public final static String EXTRA_SCRIPTURE = "com.tylersorenson.cs246.SCRIPTURE";
    EditText book, chapter, verse;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scripture_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScriptureOutput.class);
                intent.putExtra(EXTRA_SCRIPTURE, getInputs(book, chapter, verse));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scripture_input, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String[] getInputs(EditText book, EditText chapter, EditText verse) {
        book = (EditText) findViewById(R.id.book_input);
        chapter = (EditText) findViewById(R.id.chapter_input);
        verse = (EditText) findViewById(R.id.verse_input);

        String bookString = book.getText().toString();
        String chapterString = chapter.getText().toString();
        String verseString = verse.getText().toString();
        String inputs[] = {bookString, chapterString, verseString};
        return inputs;
    }
}
