package br.com.edilsystem.pedidos.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.edilsystem.pedidos.modelo.Pedido;
import br.com.edisystem.pedidos.R;

/**
 * Created by welder on 26/04/17.
 */

public class PedidoListAdapter extends BaseAdapter {

    private final List<Pedido> pedidoList;
    private final Context context;

    public PedidoListAdapter(Context context, List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.pedidoList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.pedidoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.pedidoList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Pedido pedido = this.pedidoList.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.pedido_list_item, parent, false);
        }

        TextView campoNome = (TextView) view.findViewById(R.id.pedidos_item_nome);
        campoNome.setText(pedido.getNome());

        TextView campoTelefone = (TextView) view.findViewById(R.id.pedidos_item_telefone);
        campoTelefone.setText(pedido.getTelefone());

        ImageView campoFoto = (ImageView) view.findViewById(R.id.pedidos_item_avatar);
        String fotoUrl = pedido.getFotoUrl();
        if(fotoUrl != null){
            Bitmap bitmap = BitmapFactory.decodeFile(fotoUrl);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            campoFoto.setImageBitmap(bitmapReduzido);
            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
        }

        return view;
    }

}
