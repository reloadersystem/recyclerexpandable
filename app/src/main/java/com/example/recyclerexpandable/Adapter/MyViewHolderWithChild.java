package com.example.recyclerexpandable.Adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.recyclerexpandable.Interface.ItemClickListener;
import com.example.recyclerexpandable.Model.Item;
import com.example.recyclerexpandable.R;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MyViewHolderWithChild extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textView, textViewChild;
    public RelativeLayout button;
    public ExpandableLinearLayout expandableLayout;
    public EditText nombre, apellido, dni;
    public RadioGroup radiogroupSexo;



    String[] datos;












    ItemClickListener itemClickListener;


    //declaracion de  objetos, textos, editText;
    public MyViewHolderWithChild(final View itemView) {

        super(itemView);

        datos= new String[MyAdapter.items.size()];





        // no se muestra
        textViewChild=itemView.findViewById(R.id.textViewChild);

        textView=itemView.findViewById(R.id.textView); //PASJERO 1

        button=itemView.findViewById(R.id.button); //boton que desliza hacia bajo

        expandableLayout= itemView.findViewById(R.id.expandableLayout); //github.aakira.expandablelayout.ExpandableLinearLayout

        nombre=itemView.findViewById(R.id.nombreid);
        apellido=itemView.findViewById(R.id.apellidoid);
        dni=itemView.findViewById(R.id.numerodni);
        radiogroupSexo=(RadioGroup)itemView.findViewById(R.id.radiogroupsexo);

        nombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                datos[getAdapterPosition()]= s.toString();




            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });






        itemView.setOnClickListener(this);


    }

    public String[] getDatos() {
        return datos;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
