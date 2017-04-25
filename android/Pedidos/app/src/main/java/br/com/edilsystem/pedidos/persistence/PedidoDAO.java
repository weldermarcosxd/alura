package br.com.edilsystem.pedidos.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.edilsystem.pedidos.modelo.Pedido;

/**
 * Created by welder on 22/04/17.
 */

public class PedidoDAO extends SQLiteOpenHelper {

    public PedidoDAO(Context context) {
        super(context, "Pedidos", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS pedidos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, telefone TEXT, site TEXT, nota REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS pedidos;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void persist(Pedido pedido) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = getContentValues(pedido);

        sqLiteDatabase.insert("pedidos", null, contentValues);
    }

    private ContentValues getContentValues(Pedido pedido) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("id", pedido.getId());
        contentValues.put("nome", pedido.getNome());
        contentValues.put("endereco", pedido.getEndereco());
        contentValues.put("telefone", pedido.getTelefone());
        contentValues.put("site", pedido.getSite());
        contentValues.put("nota", pedido.getNota());
        return contentValues;
    }

    public List<Pedido> findList() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM pedidos", null);
        List<Pedido> pedidoList = new ArrayList<Pedido>();

        while(cursor.moveToNext()){
            Pedido pedido = new Pedido();
            pedido.setId(cursor.getLong(cursor.getColumnIndex("id")));
            pedido.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            pedido.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            pedido.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            pedido.setSite(cursor.getString(cursor.getColumnIndex("site")));
            pedido.setNota(cursor.getDouble(cursor.getColumnIndex("nota")));
            pedidoList.add(pedido);
        }
        cursor.close();

        return pedidoList;
    }

    public void delete(Pedido pedido) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String[] params = {pedido.getId().toString()};
        sqLiteDatabase.delete("pedidos", "id = ?", params);
    }

    public void merge(Pedido pedido) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String[] params = {pedido.getId().toString()};
        ContentValues contentValues = getContentValues(pedido);

        sqLiteDatabase.update("pedidos", contentValues , "id = ?", params);
    }
}
