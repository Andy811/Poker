package com.andy.poker.poker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tom.poker.R;

public class MainActivity extends AppCompatActivity {
    Poker poker = new Poker();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poker.shuffle();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PokerAdapter());
    }

    class PokerAdapter extends RecyclerView.Adapter<PokerAdapter.PokerHolder>{
        @NonNull
        @Override
        public PokerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PokerHolder(getLayoutInflater().inflate(R.layout.poker_row, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PokerHolder holder, int position) {
            holder.pokerText.setText(poker.cards[position].get());
        }

        @Override
        public int getItemCount() {
            return poker.cards.length;
        }

        class PokerHolder extends RecyclerView.ViewHolder {
            TextView pokerText;
            public PokerHolder(View itemView) {
                super(itemView);
                pokerText = itemView.findViewById(R.id.tv_poker);
            }
        }
    }
}
