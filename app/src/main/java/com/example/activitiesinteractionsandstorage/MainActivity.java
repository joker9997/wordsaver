package com.example.activitiesinteractionsandstorage;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private ListView listViewNotes;
    private ArrayList<String> notesList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNotes = findViewById(R.id.listViewNotes);
        notesList = new ArrayList<>();

        // Initialize the adapter and attach it to the ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        listViewNotes.setAdapter(adapter);
        loadNotes();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                Intent addNoteIntent = new Intent(this, AddNoteActivity.class);
                startActivityForResult(addNoteIntent, 1); // Start AddNoteActivity for result
                return true;
            case R.id.action_delete:
                Intent deleteNoteIntent = new Intent(this, DeleteNoteActivity.class);
                startActivityForResult(deleteNoteIntent, 2); // Start DeleteNoteActivity for result
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void loadNotes() {
        notesList.add("Sample Note: Click Add to add more notes.");
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String newNote = data.getStringExtra("note");
            if (newNote != null && !newNote.isEmpty()) {
                notesList.add(newNote);
                adapter.notifyDataSetChanged();
            }
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            notesList.clear();
            loadNotes();
        }
    }
}
