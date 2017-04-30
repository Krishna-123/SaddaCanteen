package android.aitlindia.com.saddacanteen.CartShowItem;

import android.aitlindia.com.saddacanteen.R;
import android.aitlindia.com.saddacanteen.UseableClasses.Adapter;
import android.aitlindia.com.saddacanteen.UseableClasses.ListItems;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartItems extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<ListItems> listItems = new ArrayList<>();
    private Adapter mAdapter;
    private Context mContext;
    private int layout;
    private final int flag = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showcartrecycler);

        mContext = getApplicationContext();
        layout =  R.layout.activity_categories;

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
}
