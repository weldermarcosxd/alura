package br.com.edilsystem.pedidos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.edilsystem.pedidos.adapters.PedidoListAdapter;
import br.com.edilsystem.pedidos.converters.PedidoConverter;
import br.com.edilsystem.pedidos.modelo.Pedido;
import br.com.edilsystem.pedidos.persistence.PedidoDAO;
import br.com.edilsystem.pedidos.rest.PedidosClient;
import br.com.edisystem.pedidos.R;

public class PedidosActivity extends AppCompatActivity {

    public static final int SMS_CODE = 2;
    public static final int PHONE_REQUEST_CODE = 1;
    ListView listapedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        refreshList();

        Button novoAluno = (Button) findViewById(R.id.novo_pedido);
        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PedidosActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(listapedidos);

        listapedidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Pedido pedido = (Pedido) lista.getItemAtPosition(position);
                Toast.makeText(PedidosActivity.this, "Pedido selecionado: " + pedido.getNome(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(PedidosActivity.this, FormularioActivity.class);
                intent.putExtra("pedido", pedido);
                startActivity(intent);
            }
        });

        if (ContextCompat.checkSelfPermission(PedidosActivity.this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PedidosActivity.this, new String[]{Manifest.permission.RECEIVE_SMS}, SMS_CODE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshList();
    }

    @Override
    public void onCreateContextMenu(final ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Pedido pedido = (Pedido) listapedidos.getItemAtPosition(info.position);

        MenuItem ligarPedido = menu.add("Ligar");
        Intent ligarIntent = new Intent(Intent.ACTION_CALL);

        if (ContextCompat.checkSelfPermission(PedidosActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PedidosActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PHONE_REQUEST_CODE);
        }else{
            ligarIntent.setData(Uri.parse("tel:" + pedido.getTelefone()));
            ligarPedido.setIntent(ligarIntent);
        }

        MenuItem smsPedido = menu.add("Enviar SMS");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("sms:" + pedido.getTelefone()));
        smsPedido.setIntent(smsIntent);

        MenuItem geoPedido = menu.add("Localizaçao");
        Intent geoIntent = new Intent(Intent.ACTION_VIEW);
        geoIntent.setData(Uri.parse("geo:0,0?q=" + pedido.getEndereco()));
        geoPedido.setIntent(geoIntent);

        MenuItem sitePedido = menu.add("Visitar Site");
        String site = pedido.getSite().startsWith("http://") ? pedido.getSite() : "http://" + pedido.getSite();
        Intent siteIntent = new Intent(Intent.ACTION_VIEW);
        siteIntent.setData(Uri.parse(site));
        sitePedido.setIntent(siteIntent);

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                PedidoDAO pedidoDAO = new PedidoDAO(PedidosActivity.this);
                pedidoDAO.delete(pedido);
                pedidoDAO.close();

                refreshList();
                Toast.makeText(PedidosActivity.this, "Pedido " + pedido.getNome() + " deletado com sucesso!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.enviar_notas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.enviar_notas:
               PedidoDAO pedidoDAO = new PedidoDAO(this);
               List<Pedido> pedidoList = pedidoDAO.findList();
               pedidoDAO.close();

               PedidoConverter pedidoConverter = new PedidoConverter();
               String json = pedidoConverter.toJson(pedidoList);

               PedidosClient client = new PedidosClient();
               String resposta = client.post(json);

               Toast.makeText(this, resposta, Toast.LENGTH_LONG).show();
       }

       return super.onOptionsItemSelected(item);
    }

    private void refreshList() {
        PedidoDAO pedidoDAO = new PedidoDAO(this);
        List<Pedido> pedidosList = pedidoDAO.findList();
        pedidoDAO.close();

        PedidoListAdapter adapter =
                new PedidoListAdapter(this, pedidosList);

        listapedidos = (ListView) findViewById(R.id.pedidos_Lista_pedidos);
        listapedidos.setAdapter(adapter);
    }
}
