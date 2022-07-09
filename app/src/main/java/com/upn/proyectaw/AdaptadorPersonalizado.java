package com.upn.proyectaw;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upn.proyectaw.entidades.Usuarios;

import java.util.ArrayList;
import java.util.List;


public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.MyViewHolder> {

    private Context context;
    private List<Usuarios> listaUsuarios = new ArrayList();
    public AdaptadorPersonalizado(Context context,List<Usuarios> listaUsuarios){
        this.context = context ;
        this.listaUsuarios = listaUsuarios;


    }



    @NonNull
    @Override
    public AdaptadorPersonalizado.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View vista = inflater.inflate(R.layout.fila,parent,false);

        return new MyViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.MyViewHolder holder, int position) {
//


        holder.idfilaNombresApellidos.setText(listaUsuarios.get(position).getNombre()+""+listaUsuarios.get(position).getApellido());
        holder.idfilaEmail.setText(listaUsuarios.get(position).getEmail()+"");
        holder.fila.setOnLongClickListener(v -> {

            Intent intent = new Intent(context, RegistrarActivityUsuario.class);
            intent.putExtra("pid",listaUsuarios.get(position).getId()+"");
            intent.putExtra("pnombre",listaUsuarios.get(position).getNombre()+"");
            intent.putExtra("papellido",listaUsuarios.get(position).getApellido()+"");
            intent.putExtra("pcorreo",listaUsuarios.get(position).getEmail()+"");
            intent.putExtra("pphone",listaUsuarios.get(position).getTelefono()+"");


            context.startActivity(intent);
            return false;
        });


    }

    @Override
    public int getItemCount() {

        return listaUsuarios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView idfilaNombresApellidos , idfilaEmail;
        LinearLayout fila;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idfilaNombresApellidos = itemView.findViewById(R.id.idfilaNombresApellidos);
            idfilaEmail = itemView.findViewById(R.id.idfilaEmail);
            fila = itemView.findViewById(R.id.fila);
        }
    }


}
