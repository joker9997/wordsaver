package com.example.activitiesinteractionsandstorage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String content = editTextContent.getText().toString();
                if (title.isEmpty() || content.isEmpty()) {
                    Toast.makeText(AddNoteActivity.this, "Title and Content cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("note", title + ": " + content);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}
