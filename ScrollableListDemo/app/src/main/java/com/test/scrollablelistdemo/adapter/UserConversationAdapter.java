package com.test.scrollablelistdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.scrollablelistdemo.R;
import com.test.scrollablelistdemo.model.Receiver;
import com.test.scrollablelistdemo.model.Sender;
import com.test.scrollablelistdemo.model.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by filippo on 19/02/2018.
 */

public class UserConversationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<User> mUserConversation = new LinkedList<>();
    private final LayoutInflater mLayoutInflater;

    public UserConversationAdapter(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    @Override
    public int getItemViewType(int position) {
        return mUserConversation.get(position).getUserType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if(viewType == 0) {
            viewHolder = new ReceiverViewHolder(mLayoutInflater.inflate(R.layout.receiver_layout, parent, false));
        } else {
            viewHolder = new SenderViewHolder(mLayoutInflater.inflate(R.layout.sender_layout, parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                ((ReceiverViewHolder) holder).bind((Receiver) mUserConversation.get(position));
                break;
            case 1:
                ((SenderViewHolder) holder).bind((Sender) mUserConversation.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mUserConversation.size();
    }

    public void addConversation(User user) {
        mUserConversation.add(user);
        notifyItemInserted(mUserConversation.size() - 1);
    }

    class SenderViewHolder extends RecyclerView.ViewHolder {

        final TextView tv;

        SenderViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView2);
        }

        public void bind(Sender sender) {
            tv.setText(sender.getUserMessage());
        }
    }

    class ReceiverViewHolder extends RecyclerView.ViewHolder {

        final TextView tv;

        ReceiverViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView2);
        }

        public void bind(Receiver receiver) {
            tv.setText(receiver.getUserMessage());
        }
    }
}
