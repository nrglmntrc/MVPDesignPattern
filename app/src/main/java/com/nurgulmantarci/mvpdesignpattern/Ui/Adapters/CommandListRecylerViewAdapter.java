package com.nurgulmantarci.mvpdesignpattern.Ui.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;
import com.nurgulmantarci.mvpdesignpattern.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommandListRecylerViewAdapter extends RecyclerView.Adapter<CommandListRecylerViewAdapter.ViewHolder> {

    private List<Command> myItems;
    private ItemListener myListener;

    public CommandListRecylerViewAdapter(List<Command> items, ItemListener listener) {
        myItems = items;
        myListener = listener;
    }

    public void setListener(ItemListener listener) {
        myListener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_command,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
          viewHolder.setData(myItems.get(i));
    }


    @Override
    public int getItemCount() {
        return myItems.size();
    }

    public interface ItemListener {
        void onItemClick(Command item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
         public Command item;

         @BindView(R.id.row_command_title_text_view)
         TextView rowCommandTitleTextView;

         @BindView(R.id.row_command_detail_text_view)
         TextView rowCommandDetailtextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this,itemView);
        }

        public void setData(Command item){
            this.item=item;
            rowCommandTitleTextView.setText(item.getText());
            rowCommandDetailtextView.setText(item.getDetail());
        }

        @Override
        public void onClick(View v) {
                if(myListener!=null){
                    myListener.onItemClick(item);
                }
        }
    }
}
