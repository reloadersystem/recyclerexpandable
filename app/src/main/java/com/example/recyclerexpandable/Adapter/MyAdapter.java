package com.example.recyclerexpandable.Adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerexpandable.Interface.ItemClickListener;
import com.example.recyclerexpandable.Model.Item;
import com.example.recyclerexpandable.R;
import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static List<Item> items;
    Context context;
    SparseBooleanArray expandState= new SparseBooleanArray();
    //public static ArrayList<Item> listaid ;


    public MyAdapter(List<Item> items)
    {

        this.items= items;



        // deja  espandido  solo el primer indice

        expandState.append(0,true);

        // sin expander  los demas  inidices

        /*for(int  i=1; i<items.size();i++)
            expandState.append(i, false);*/





    }

    //presionar  ctrl+o


    @Override
    public int getItemViewType(int position) {

        if(items.get(position).isExpandable())
            return 1;
        else
            return 0;

    }

    @NonNull
    @Override

    //crear la  vista  sin personalizar
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


       this.context=parent.getContext();

       if(viewType==0) //sin item
       {
           LayoutInflater inflater= LayoutInflater.from(context);

           View view= inflater.inflate(R.layout.layout_without_child,parent,false);
           return  new MyViewHolderWithoutChild(view);
       }
       else
       {
           LayoutInflater inflater= LayoutInflater.from(context);
           View view= inflater.inflate(R.layout.layout_with_child,parent,false);
           return  new MyViewHolderWithChild(view);

       }

    }

    @Override
    //perzonalizacion de la vista de cada  uno de los  elementos de la vista/ y la  posicion

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        switch (holder.getItemViewType())
        {
            case 0:
            {
                MyViewHolderWithoutChild viewHolder=(MyViewHolderWithoutChild)holder;
                Item item= items.get(position);
                viewHolder.setIsRecyclable(true);
                viewHolder.textView.setText(item.getText());

                //hacer evento del click

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //Toast.makeText(context,"sin  child click :"+items.get(position).getSubText(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
            break;

            case 1:
            {

                //personalizando
               final MyViewHolderWithChild viewHolder=(MyViewHolderWithChild)holder;


                Item item= items.get(position);


                //hace  que los  datos  escritos en el viewholder no se  borren
                viewHolder.setIsRecyclable(true);



                viewHolder.textView.setText(item.getText());
                viewHolder.apellido.setText(item.getApellido());
                viewHolder.nombre.setText(item.getNombre());
                viewHolder.dni.setText(item.getNumerodni());

                viewHolder.radiogroupSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        switch (checkedId)
                        {
                            case R.id.masculinoid:
                            {
                                //viewHolder.radiogroupSexo.check(checkedId);
                               // Toast.makeText(context,"Masculino "+(position+1),Toast.LENGTH_SHORT).show();
                                break;
                            }

                            case R.id.femeninoid:
                            {
                                //Toast.makeText(context,"Femenino "+(position+1),Toast.LENGTH_SHORT).show();

                                break;
                            }
                        }
                    }
                });


                //boolean sexo= item.isHabilitar();

               /* boolean sexo= item.isSexo(0);


                if (sexo) {

                    //holder.grsetEnabled(false);
                    ((MyViewHolderWithChild) holder).radiogroupSexo.check(0);
                    //holder.textView.setBackgroundColor(Color.GRAY);
                    //holder.textView.setTextColor(Color.DKGRAY);


                } else {

                    ((MyViewHolderWithChild) holder).radiogroupSexo.check(0);

                }*/





                //usamos  reccycler View, expandable LinearLayout

                viewHolder.expandableLayout.setInRecyclerView(true);
                viewHolder.expandableLayout.setExpanded(expandState.get(position));

                viewHolder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {
                    @Override
                    public void onAnimationStart() {

                    }

                    @Override
                    public void onAnimationEnd() {

                    }

                    @Override
                    public void onPreOpen() {

                        changeRotate(viewHolder.button,0f,180f).start();
                        expandState.put(position,true);

                    }

                    @Override
                    public void onPreClose() {
                        changeRotate(viewHolder.button,180f,0f).start();
                        expandState.put(position,false);

                    }

                });

                viewHolder.button.setRotation(expandState.get(position)?180f:0f);
                viewHolder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //expandir  el item  hijo
                        viewHolder.expandableLayout.toggle();





                    }
                });

                viewHolder.textViewChild.setText(items.get(position).getText());
                viewHolder.textViewChild.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Toast.makeText(context,"child click :"+items.get(position).getSubText(), Toast.LENGTH_SHORT).show();

                    }
                });


                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                       // Toast.makeText(context,"con child click :"+items.get(position).getSubText(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
            break;
            default:
             break;
        }

    }

    private ObjectAnimator changeRotate(RelativeLayout button, float from, float to) {
        ObjectAnimator animator= ObjectAnimator.ofFloat(button, "rotation", from,to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return  animator;

    }

    @Override
    public int getItemCount() {
        return items.size();

    }


}

