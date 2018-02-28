package com.test.scrollablelistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.test.scrollablelistdemo.adapter.UserConversationAdapter;
import com.test.scrollablelistdemo.model.Receiver;
import com.test.scrollablelistdemo.model.Sender;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView conversationList;
    private EditText sendTxt;
    private EditText receiveTxt;

    private UserConversationAdapter conversationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendTxt = findViewById(R.id.editTextSend);
        receiveTxt = findViewById(R.id.editTextReceive);

        conversationList = findViewById(R.id.recyclerView);
        conversationList.setHasFixedSize(true);
        conversationList.setLayoutManager(new LinearLayoutManager(this));


        conversationAdapter = new UserConversationAdapter(getLayoutInflater());
        conversationList.setAdapter(conversationAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSend:
                conversationAdapter.addConversation(new Sender("Kate", "Thomas", sendTxt.getText().toString()));
                break;
            case R.id.buttonReceive:
                conversationAdapter.addConversation(new Receiver("John", "Doe", receiveTxt.getText().toString()));
                break;
        }
        conversationList.scrollToPosition(conversationAdapter.getItemCount() - 1);
    }
}
