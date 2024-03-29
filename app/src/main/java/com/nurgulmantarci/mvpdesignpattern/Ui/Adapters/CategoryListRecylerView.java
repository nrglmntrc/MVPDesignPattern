package com.nurgulmantarci.mvpdesignpattern.Ui.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;
import com.nurgulmantarci.mvpdesignpattern.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListRecylerView extends RecyclerView.Adapter<CategoryListRecylerView.ViewHolder> {

    private List<Category> myItems;
    private ItemListener myListener;

    public CategoryListRecylerView(List<Category> items, ItemListener listener) {
        this.myItems = items;
        this.myListener = listener;
    }

    public void setListener(ItemListener listener) {
        myListener = listener;
    }


    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_category,viewGroup,false));
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
        void onItemClick(Category item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // TODO - Your view members
        public Category item;

        @BindView(R.id.row_category_title_text_view)
        TextView rowCategoryTitleTextView;

        @BindView(R.id.row_category_card_view)
        CardView rowCategoryCardView;

        @BindView(R.id.row_category_image_view)
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this,itemView);
        }


        public void setData(Category item){
            this.item=item;
            rowCategoryTitleTextView.setText(item.getTitle());
            imageView.setImageResource(categoryIcon(item.getTitle()));
        }

        @Override
        public void onClick(View v) {
            if(myListener!=null){
                myListener.onItemClick(item);
            }
        }
    }



    public int categoryIcon(String title){
        if(title.equals("Search Commands") || title.equals("Arama Komutları") || title.equals("Commandes de recherche"))
            return R.drawable.action_search;
        else if(title.equals("System Commands") || title.equals("Sistem Komutları") || title.equals("Commandes système"))
            return R.drawable.action_setting;
        else if (title.equals("Pacman Commands") || title.equals("Pacman Komutları") || title.equals("Pacman Commands"))
            return R.drawable.action_pacman;
        else if(title.equals("File Commands") || title.equals("Dosya Komutları") || title.equals("Commandes de fichiers"))
            return R.drawable.action_file;
        else if(title.equals("Network Commands") || title.equals("Ağ Komutları") || title.equals("Commandes réseau"))
            return R.drawable.action_network;
        else if (title.equals("APT Commands") || title.equals("APT Komutları") || title.equals("Commandes APT"))
            return R.drawable.action_apt;
        else if (title.equals("Compression Commands") || title.equals("Sıkıştırma Komutları") || title.equals("Commandes de compression"))
            return R.drawable.action_zip;
        else if(title.equals("Permission Commands") || title.equals("İzin Komutları") || title.equals("Commandes d'autorisation"))
            return R.drawable.action_permission;
        else if(title.equals("FTP Commands") || title.equals("FTP Komutları") || title.equals("Commandes FTP"))
            return R.drawable.action_ftp;
        else if (title.equals("Git Commands") || title.equals("Git Komutları") || title.equals("commandes git"))
            return R.drawable.action_git;
        else if(title.equals("RPM Komutları") || title.equals("Commandes RPM"))
            return R.drawable.action_rpm;
        else {
            return R.drawable.action_add;
        }
    }
}
