package com.ch.trello.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ch.trello.R;
import com.ch.trello.vo.CardVO;

public class CardAdapter extends ArrayAdapter<CardVO> {

    public ArrayList<CardVO> mCards;
    private LayoutInflater mInflater;
    
    public CardAdapter(Context context, int textViewResourceId, ArrayList<CardVO> cards) {
        super(context, textViewResourceId, cards);

        mInflater = LayoutInflater.from(context);
        mCards = cards;
    }
    
    public void updateCards(ArrayList<CardVO> cards) {
        mCards = cards;
        notifyDataSetChanged();
    }
    
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView nameText;
        
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.card_row, null);
            
            nameText = (TextView)  convertView.findViewById(R.id.name);
            
            convertView.setTag(R.id.name, nameText);
        } else {
            nameText = (TextView)  convertView.getTag(R.id.name);
        }

        CardVO board = mCards.get(position);
        
        if (board != null) {
            nameText.setText(board.name);
        }
        
        return convertView;
    }
}
