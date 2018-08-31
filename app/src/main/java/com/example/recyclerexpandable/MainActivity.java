package com.example.recyclerexpandable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.recyclerexpandable.Adapter.MyAdapter;


import com.example.recyclerexpandable.Adapter.MyViewHolderWithChild;
import com.example.recyclerexpandable.Adapter.MyViewHolderWithoutChild;
import com.example.recyclerexpandable.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    RecyclerView.LayoutManager layoutManager;
    List<Item> items = new ArrayList<>();
    Button btncontinuar;
    //ListView lista;


    private static  final String TAG="edson";

    ArrayList<String> listapasj;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listapasj= new ArrayList<>();

        recycler= findViewById(R.id.recycler);

        btncontinuar=findViewById(R.id.btncontinuar);

        recycler.setHasFixedSize(false);

        layoutManager= new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false);

        recycler.setLayoutManager(layoutManager);

       // lista=findViewById(R.id.lista);

        setData();

        final MyAdapter adapter = new MyAdapter(items);
        recycler.setAdapter(adapter);

        btncontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (recycler.getChildCount() > 0) {

                    for (int i = 0; i < recycler.getChildCount(); i++) {
                        if (recycler.findViewHolderForLayoutPosition(i) instanceof MyViewHolderWithChild) {
                            MyViewHolderWithChild holders = (MyViewHolderWithChild) recycler.findViewHolderForLayoutPosition(i);
                             Toast.makeText(MainActivity.this, (i+1) + " Nombre:"+holders.nombre.getText()+ " Apellido: "+holders.apellido.getText() +
                                " DNI:"+holders.dni.getText(), Toast.LENGTH_SHORT).show();



                           //listapasj.add(holders.nombre.getText().toString());




                        }


                    }


                }



                //listarpasajeros();




                /*for( int a =0;a<listapasj.size();a++)
                {

                   Log.d(TAG,"oncreate" + listapasj.get(a));

                }*/



            }
        });


    }

    private void listarpasajeros() {

        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, listapasj);
        //lista.setAdapter(adaptador);
    }

    private void setData() {



       /* for( int i=0;i<5;i++)
        {
            if(i%2==0)
            {
                Item item= new Item("PASAJERO "+ (i+1), "This is  child  item "+(i+1), true);
                items.add(item);

            }else
            {
                //Item item= new Item("This  is item "+(i+1),"",false);
                //items.add(item);
            }
        }*/


                //llena  la lista  vacia

                //Item itemx= new Item("PASAJERO "+ (1), "This is  child  item "+(1), true,"alex","correa", "94138952",true);
                //primer  item desplegado
                Item itemx = new Item("PASAJERO " + (1), "This is  child  item " + (1), true, " ", "", " ", true);
                items.add(itemx);

                //2do o + items  sin desplegar

                for (int i = 1; i < 4; i++) {
                    Item item = new Item("PASAJERO " + (i + 1), "This is  child  item " + (i + 1), true, " ", " ", " ", true);
                    items.add(item);


                }


            }

        }
