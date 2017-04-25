package br.com.edilsystem.pedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.edilsystem.pedidos.modelo.Pedido;
import br.com.edilsystem.pedidos.persistence.PedidoDAO;
import br.com.edisystem.pedidos.R;

public class PedidosActivity extends AppCompatActivity {

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshList();
    }

    @Override
    public void onCreateContextMenu(final ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem menuItem = menu.add("Deletar");
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Pedido pedido = (Pedido) listapedidos.getItemAtPosition(info.position);

                PedidoDAO pedidoDAO = new PedidoDAO(PedidosActivity.this);
                pedidoDAO.delete(pedido);
                pedidoDAO.close();

                refreshList();
                Toast.makeText(PedidosActivity.this, "Pedido " +  pedido.getNome() + " deletado com sucesso!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void refreshList() {
        PedidoDAO pedidoDAO = new PedidoDAO(this);
        List<Pedido> pedidosList = pedidoDAO.findList();
        pedidoDAO.close();

        ArrayAdapter<Pedido> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pedidosList);

        listapedidos = (ListView) findViewById(R.id.pedidos_Lista_pedidos);
        listapedidos.setAdapter(adapter);
    }
}
