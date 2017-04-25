package br.com.edilsystem.pedidos;

import android.widget.EditText;
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

    public FormularioHelper(FormularioActivity formularioActivity) {
        this.pedido = new Pedido();
        this.campoNome = (EditText) formularioActivity.findViewById(R.id.formulario_nome);
        this.campoEndereco = (EditText) formularioActivity.findViewById(R.id.formulario_endereco);
        this.campoTelefone = (EditText) formularioActivity.findViewById(R.id.formulario_telefone);
        this.campoSite = (EditText) formularioActivity.findViewById(R.id.formulario_site);
        this.campoNota = (RatingBar) formularioActivity.findViewById(R.id.formulario_nota);
    }

    public Pedido pegaPedido(){
        pedido.setNome(this.campoNome.getText().toString());
        pedido.setEndereco(this.campoEndereco.getText().toString());
        pedido.setTelefone(this.campoTelefone.getText().toString());
        pedido.setSite(this.campoSite.getText().toString());
        pedido.setNota(Double.valueOf(this.campoNota.getProgress()));
        return this.pedido;
    }


    public void preencheFormulario(Pedido pedido) {
        this.pedido = pedido;
        this.campoNome.setText(pedido.getNome());
        this.campoEndereco.setText(pedido.getEndereco());
        this.campoTelefone.setText(pedido.getTelefone());
        this.campoSite.setText(pedido.getSite());
        this.campoNota.setProgress(pedido.getNota().intValue());
    }
}
