package com.upn.proyectaw;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.MyViewHolder> {

    private Context context ;
    private List<Productos> listaProductos = new ArrayList<>();
    public AdaptadorProductos(Context context , List<Productos>listaProductos){
        this.context = context;
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public AdaptadorProductos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(this.context);
        View vista = inflater.inflate(R.layout.filaproducto,parent,false);

        return new MyViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorProductos.MyViewHolder holder, int position) {

        holder.idNombreProducto.setText(listaProductos.get(position).getPnombreproducto()+"");
        holder.idCodigoProducto.setText(listaProductos.get(position).getPid()+"");

        holder.filaproducto.setOnLongClickListener(v -> {

            Intent intent = new Intent(context , Producto.class);
            intent.putExtra("pnombreproducto",listaProductos.get(position).getPnombreproducto()+"");
            intent.putExtra("pidimagenproducto", listaProductos.get(position).getPidimagenproducto()+"");
            intent.putExtra("descripcioncorta",listaProductos.get(position).getDescripcioncorta()+"");
            intent.putExtra("precionormal" , listaProductos.get(position).getDescripcioncorta()+"");
            intent.putExtra("preciodescuento" , listaProductos.get(position).getPrecioOferta()+"");
            intent.putExtra("stock" , listaProductos.get(position).getStock()+"");

            context.startActivity(intent);
            return false;
        });






    }

    @Override
    public int getItemCount() {

        return listaProductos.size();


    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idNombreProducto , idCodigoProducto;
        LinearLayout filaproducto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idNombreProducto = itemView.findViewById(R.id.idfilaNombresApellidos);
            idCodigoProducto = itemView.findViewById(R.id.idfilaEmail);
            filaproducto = itemView.findViewById(R.id.fila);
        }
    }
}


