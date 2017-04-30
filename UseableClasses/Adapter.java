package android.aitlindia.com.saddacanteen.UseableClasses;

import android.aitlindia.com.saddacanteen.Categories.Categories;
import android.aitlindia.com.saddacanteen.Categories.SetItems;
import android.aitlindia.com.saddacanteen.R;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.aitlindia.com.saddacanteen.R.id.add_items;
import static android.support.design.R.attr.title;

/**
 * Created by krishna on 20/4/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ItemViewHolder>{

    private static int totalItem = 0;
    private  List<ListItems> items;
    private  Context context;
    private int layout;
    public SetItems setItems;
    private static int flag ;

    @Override
    public Adapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter.ItemViewHolder holder, final int position) {

       //
            if (flag ==0 ) {
                setItems.setItemForSelection(holder, position);
            }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private Context context = new Adapter().getContext();
       // public SetItems setItems = new Adapter().setItems;
        public CardView cardView;
        public TextView title1;
        public ImageView itemPhoto;
        public Button add_items,remove_items;

        ItemViewHolder(View itemView) {
        super(itemView);
               if(flag == 0) {
                   cardView = (CardView) itemView.findViewById(R.id.card_view);
                   title1 = (TextView) itemView.findViewById(R.id.title);
                   itemPhoto = (ImageView) itemView.findViewById(R.id.items_image);
                   add_items = (Button) itemView.findViewById(R.id.add_items);
                   remove_items = (Button) itemView.findViewById(R.id.remove_items);
               }


    }
   }

  public Adapter( Context context, List<ListItems> items,int layout, int flag){
        this.items = items;
        this.layout = layout;
        this.context = context;
        this.flag = flag;
      setItems = new SetItems(context,items);
    }


    public  Adapter(){
        }

    public Context getContext() {
        return context;
    }
}