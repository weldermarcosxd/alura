package br.com.edilsystem.pedidos.converters;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import br.com.edilsystem.pedidos.modelo.Pedido;

/**
 * Created by welder on 29/04/17.
 */

public class PedidoConverter {
    public String toJson(List<Pedido> alunos) {
        try {
            JSONStringer jsonStringer = new JSONStringer();
            jsonStringer.object().key("list").array()
                    .object().key("aluno").array();

            for (Pedido aluno : alunos) {
                jsonStringer.object()
                        .key("id").value(aluno.getId())
                        .key("nome").value(aluno.getNome())
                        .key("telefone").value(aluno.getTelefone())
                        .key("endereco").value(aluno.getEndereco())
                        .key("site").value(aluno.getSite())
                        .key("nota").value(aluno.getNota())
                        .endObject();
            }
            return jsonStringer.endArray().endObject()
                    .endArray().endObject().toString();


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return "";
    }
}
