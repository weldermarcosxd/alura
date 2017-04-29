package br.com.edilsystem.pedidos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import br.com.edilsystem.pedidos.modelo.Pedido;
import br.com.edisystem.pedidos.R;

/**
 * Created by welder on 22/04/17.
 */

public class FormularioHelper {

    private Pedido pedido;
    private EditText campoNome;
    private EditText campoEndereco;
    private EditText campoTelefone;
    private EditText campoSite;
    private RatingBar campoNota;
    private ImageView campoFoto;

    public FormularioHelper(FormularioActivity formularioActivity) {
        this.pedido = new Pedido();
        this.campoNome = (EditText) formularioActivity.findViewById(R.id.formulario_nome);
        this.campoEndereco = (EditText) formularioActivity.findViewById(R.id.formulario_endereco);
        this.campoTelefone = (EditText) formularioActivity.findViewById(R.id.formulario_telefone);
        this.campoSite = (EditText) formularioActivity.findViewById(R.id.formulario_site);
        this.campoNota = (RatingBar) formularioActivity.findViewById(R.id.formulario_nota);
        this.campoFoto = (ImageView) formularioActivity.findViewById(R.id.formulario_foto);
    }

    public Pedido pegaPedido(){
        pedido.setNome(this.campoNome.getText().toString());
        pedido.setEndereco(this.campoEndereco.getText().toString());
        pedido.setTelefone(this.campoTelefone.getText().toString());
        pedido.setSite(this.campoSite.getText().toString());
        pedido.setNota(Double.valueOf(this.campoNota.getProgress()));
        pedido.setFotoUrl((String) this.campoFoto.getTag());
        return this.pedido;
    }


    public void preencheFormulario(Pedido pedido) {
        this.pedido = pedido;
        this.campoNome.setText(pedido.getNome());
        this.campoEndereco.setText(pedido.getEndereco());
        this.campoTelefone.setText(pedido.getTelefone());
        this.campoSite.setText(pedido.getSite());
        this.campoNota.setProgress(pedido.getNota().intValue());
        if (pedido.getFotoUrl() != null) {
            carregaFoto(pedido.getFotoUrl());
        }
    }

    public void carregaFoto(String caminhoFoto) {
        Bitmap bm = BitmapFactory.decodeFile(caminhoFoto);
        bm = Bitmap.createScaledBitmap(bm, 100, 100, true);
        this.campoFoto.setImageBitmap(bm);
        this.campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
        this.campoFoto.setTag(caminhoFoto);
    }
}
