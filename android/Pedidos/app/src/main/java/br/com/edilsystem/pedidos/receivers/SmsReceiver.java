package br.com.edilsystem.pedidos.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.telephony.SmsMessage;
import android.widget.Toast;

import br.com.edilsystem.pedidos.modelo.Pedido;
import br.com.edilsystem.pedidos.persistence.PedidoDAO;
import br.com.edisystem.pedidos.R;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Object[] pdus = (Object[]) intent.getSerializableExtra("pdus");
        byte[] pdu = (byte[]) pdus[0];

        String format = (String) intent.getSerializableExtra("format");

        SmsMessage message = SmsMessage.createFromPdu(pdu, format);
        String telefone = message.getDisplayOriginatingAddress();

        PedidoDAO pedidoDAO = new PedidoDAO(context);
        if(pedidoDAO.findByPhone(telefone)){
            Toast.makeText(context, "Chegou mensagem de aluno!", Toast.LENGTH_LONG).show();
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.msg);
            mediaPlayer.start();
        }
        pedidoDAO.close();
    }
}