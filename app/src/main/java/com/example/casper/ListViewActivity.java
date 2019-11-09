package com.example.casper;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private List<People> people = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lv = findViewById(R.id.list);
        init();

        PeopleAdapter adapter = new PeopleAdapter(ListViewActivity.this, R.layout.people_item, people);
        ((ListView) findViewById(R.id.list)).setAdapter(adapter);

        //上下文菜单
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }

    //在listview上建上下文菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v==lv) {
            int itemPosition=((AdapterView.AdapterContextMenuInfo)menuInfo).position;
            menu.setHeaderTitle(people.get(itemPosition).getName());
            menu.add(0, 1, 0, "新建");
            menu.add(0, 2, 0, "删除");
            menu.add(0, 3, 0, "关于...");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    //listview建立
    //重写Adapter
    public class PeopleAdapter extends ArrayAdapter<People> {

        private int resourceId;

        public PeopleAdapter(Context context, int resource, List<People> objects) {
            super(context, resource, objects);
            resourceId = resource;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            People cat = getItem(position);//获取当前项的实例
            View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            ((ImageView) view.findViewById(R.id.image)).setImageResource(cat.getImageId());
            ((TextView) view.findViewById(R.id.name)).setText(cat.getName());
            return view;
        }
    }

    private void init() {
        people.add(new People("贪", R.drawable.pic1));
        people.add(new People("嗔", R.drawable.pic2));
        people.add(new People("痴", R.drawable.pic3));

    }
}
