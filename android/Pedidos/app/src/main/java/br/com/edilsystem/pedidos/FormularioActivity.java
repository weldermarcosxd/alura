package br.com.edilsystem.pedidos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.mediacompat.BuildConfig;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.net.URI;

import br.com.edilsystem.pedidos.modelo.Pedido;
import br.com.edilsystem.pedidos.persistence.PedidoDAO;
import br.com.edisystem.pedidos.R;

public class FormularioActivity extends AppCompatActivity {

    public static final int CAMERA_REQUEST_CODE = 1;
    private FormularioHelper formularioHelper;
    String image_url;

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

        View botaoCamera = findViewById(R.id.formulario_botao_camera);
        botaoCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                image_url = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
                File file = new File(image_url);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));

                if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    // essa parte muda no Android 7, estamos construindo uma URI
                    // para acessar a foto utilizando o FileProvider
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                            FileProvider.getUriForFile(FormularioActivity.this,
                                    BuildConfig.APPLICATION_ID + ".provider", file));
                }

                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            formularioHelper.carregaFoto(image_url);
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
