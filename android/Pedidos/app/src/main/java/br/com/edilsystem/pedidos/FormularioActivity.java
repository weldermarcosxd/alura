package br.com.edilsystem.pedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.edilsystem.pedidos.modelo.Pedido;
import br.com.edilsystem.pedidos.persistence.PedidoDAO;
import br.com.edisystem.pedidos.R;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper formularioHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Intent intent = getIntent();
        Pedido pedido = (Pedido) intent.getSerializableExtra("pedido");
        this.formularioHelper = new FormularioHelper(this);

        if(null != pedido){
            this.formularioHelper.preencheFormulario(pedido);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_salvar:
                Pedido pedido = this.formularioHelper.pegaPedido();

                PedidoDAO pedidoDAO = new PedidoDAO(this);

                if(null == pedido.getId()){
                    pedidoDAO.persist(pedido);
                }else{
                    pedidoDAO.merge(pedido);
                }

                pedidoDAO.close();

                Toast.makeText(FormularioActivity.this, "Pedido " + pedido.getNome() + " salvo com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
