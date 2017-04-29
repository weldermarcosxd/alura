package br.com.edilsystem.pedidos.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import br.com.edilsystem.pedidos.converters.PedidoConverter;
import br.com.edilsystem.pedidos.modelo.Pedido;
import br.com.edilsystem.pedidos.persistence.PedidoDAO;
import br.com.edilsystem.pedidos.rest.PedidosClient;

/**
 * Created by welder on 29/04/17.
 */

public class EnviarPedidos extends AsyncTask<Void, Void, String> {

    private Context context;
    private ProgressDialog progressDialog;

    public EnviarPedidos(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(context, "Aguarde", "Enviando Pedidos...", true, true);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        PedidosClient pedidosClient = new PedidosClient();
        PedidoConverter pedidoConverter = new PedidoConverter();

        PedidoDAO pedidoDAO = new PedidoDAO(context);
        List<Pedido> pedidoList = pedidoDAO.findList();
        pedidoDAO.close();

        String json = pedidoConverter.toJson(pedidoList);
        String resposta = pedidosClient.post(json);

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        progressDialog.dismiss();
        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
        super.onPostExecute(resposta);
    }
}
