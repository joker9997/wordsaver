package com.example.activitiesinteractionsandstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {

    private ListView listViewNotes;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> notesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);
        listViewNotes = findViewById(R.id.listViewNotes);
        notesList = new ArrayList<>(); // Populate this list from saved data
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        listViewNotes.setAdapter(adapter);
        listViewNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String note = notesList.get(position);
                notesList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(DeleteNoteActivity.this, "Deleted: " + note, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
