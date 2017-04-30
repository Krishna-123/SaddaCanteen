package android.aitlindia.com.saddacanteen.Categories;

import android.aitlindia.com.saddacanteen.R;
import android.aitlindia.com.saddacanteen.UseableClasses.Adapter;
import android.aitlindia.com.saddacanteen.UseableClasses.ListItems;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import static android.aitlindia.com.saddacanteen.R.id.add_items;
import static android.aitlindia.com.saddacanteen.R.id.toolbar;
import static android.support.design.R.attr.title;

/**
 * Created by krishna on 25/4/17.
 */

public class SetItems {



    private List<ListItems> items;
    private static int totalItem = 0;
    private Context mContext;
   
  /* public  void itemsForSelection(View itemView){


    }
*/
    public void setItemForSelection(final Adapter.ItemViewHolder holder, int position){

        holder.title1.setText(items.get(position).getTitle());
        holder.itemPhoto.setImageResource(items.get(position).getPhotoId());
        holder.add_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalItem = totalItem + 1;

                Categories.getInstance().setTvForShowItem(totalItem);
                Toast.makeText(mContext,"item added"+totalItem,Toast.LENGTH_SHORT).show();
                holder.add_items.setVisibility(View.GONE);
                holder.remove_items.setVisibility(View.VISIBLE);
            }
        });
        holder.remove_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalItem = totalItem - 1;
                Categories.getInstance().setTvForShowItem(totalItem);
                Toast.makeText(mContext,"item removed"+totalItem,Toast.LENGTH_SHORT).show();
                holder.remove_items.setVisibility(View.GONE);
                holder.add_items.setVisibility(View.VISIBLE);
            }
        });

    }

    public SetItems(Context context, List<ListItems> items){
        this.items = items;
        mContext = context;

    }

    public SetItems(){
          }
}
