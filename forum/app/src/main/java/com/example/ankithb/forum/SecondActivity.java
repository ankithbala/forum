package com.example.ankithb.forum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {
EditText e1,e2,e3;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mAuth = FirebaseAuth.getInstance();

        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
    }

    public void OnPress(View view){

        String name=e1.getText().toString();
        String email=e2.getText().toString();
        String query=e3.getText().toString();
        String  type="forum"; /*type of operation*/
connectToForum ctf=new connectToForum(this);
ctf.execute(type,name,email,query);        /*execute connectToForum*/

    }
}
