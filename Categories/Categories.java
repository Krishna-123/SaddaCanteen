package android.aitlindia.com.saddacanteen.Categories;


import android.aitlindia.com.saddacanteen.R;
import android.aitlindia.com.saddacanteen.UseableClasses.Adapter;
import android.aitlindia.com.saddacanteen.UseableClasses.ListItems;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class Categories extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TextView show_item;
    private List<ListItems> listItems = new ArrayList<>();
    private Adapter mAdapter;
    private Context mContext;
    private static Categories categories;
    private int layout;
    private final int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);

        mContext = getApplicationContext();

        show_item = (TextView) findViewById(R.id.show_item);

        layout =  R.layout.activity_categories;
        categories = this;

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mRecyclerView.setHasFixedSize(true);

        mAdapter = new Adapter(mContext,listItems,layout, flag);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mRecyclerView.setAdapter(mAdapter);

       initializeData();


  }
    void initializeData(){
        listItems.add(new ListItems("Emma Wilson",  R.drawable.iimage));
        listItems.add(new ListItems("Lavery Maiss", R.drawable.circularimage));
        listItems.add(new ListItems("Emma Wilson",  R.drawable.iimage));
        listItems.add(new ListItems("Lillie Watts", R.drawable.header));
        listItems.add(new ListItems("Emma Wilson",  R.drawable.iimage));
        mAdapter.notifyDataSetChanged();
    }

    public static Categories getInstance(){
        return categories;
    }

  public  void setTvForShowItem(int totalItem){
        show_item.setText(""+totalItem);

    }

    public Categories(){}
}
