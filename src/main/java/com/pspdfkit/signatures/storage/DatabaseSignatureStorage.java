package com.pspdfkit.signatures.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.field.FieldType;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.pspdfkit.internal.ic;
import com.pspdfkit.internal.uw;
import com.pspdfkit.signatures.Signature;
import io.split.android.client.service.ServiceConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DatabaseSignatureStorage implements SignatureStorage {
    public static final String SIGNATURE_DB_NAME = "pspdfkit_db";
    private final ic databaseHelper;

    private DatabaseSignatureStorage(Context context, String str) {
        this.databaseHelper = new ic(context, str);
    }

    public static DatabaseSignatureStorage withName(Context context, String str) {
        uw.a(context, "context", null);
        uw.a(str, ServiceConstants.WORKER_PARAM_DATABASE_NAME, null);
        return new DatabaseSignatureStorage(context, str);
    }

    @Override // com.pspdfkit.signatures.storage.SignatureStorage
    public void addSignature(Signature signature) throws JSONException, SQLException {
        uw.a(signature, FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, null);
        addSignatures(Collections.singletonList(signature));
    }

    @Override // com.pspdfkit.signatures.storage.SignatureStorage
    public void addSignatures(List<Signature> list) throws JSONException, SQLException {
        uw.a(list, "signatures", null);
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            Iterator<Signature> it = list.iterator();
            while (it.hasNext()) {
                contentValues.put("signature_json", it.next().toJson().toString());
                writableDatabase.insertOrThrow("signatures", null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }

    @Override // com.pspdfkit.signatures.storage.SignatureStorage
    public void clear() throws SQLException {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            writableDatabase.execSQL("DELETE FROM signatures");
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }

    public void deleteDatabase(Context context) {
        this.databaseHelper.a(context);
    }

    @Override // com.pspdfkit.signatures.storage.SignatureStorage
    public List<Signature> getSignatures() throws JSONException, SQLException {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase readableDatabase = this.databaseHelper.getReadableDatabase();
        Cursor cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM signatures", null);
        try {
            if (cursorRawQuery.moveToFirst()) {
                do {
                    int columnIndex = cursorRawQuery.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX);
                    int columnIndex2 = cursorRawQuery.getColumnIndex("signature_json");
                    if (columnIndex != -1 && columnIndex2 != -1) {
                        arrayList.add(Signature.INSTANCE.fromJson(cursorRawQuery.getLong(columnIndex), new JSONObject(cursorRawQuery.getString(columnIndex2))));
                    }
                } while (cursorRawQuery.moveToNext());
            }
            return arrayList;
        } finally {
            if (!cursorRawQuery.isClosed()) {
                cursorRawQuery.close();
            }
            readableDatabase.close();
        }
    }

    @Override // com.pspdfkit.signatures.storage.SignatureStorage
    public void removeSignature(Signature signature) throws SQLException, IllegalArgumentException {
        uw.a(signature, FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, null);
        removeSignatures(Collections.singletonList(signature));
    }

    @Override // com.pspdfkit.signatures.storage.SignatureStorage
    public void removeSignatures(List<Signature> list) throws SQLException, IllegalArgumentException {
        uw.a(list, "signatures", null);
        Iterator<Signature> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == -1) {
                throw new IllegalArgumentException("Trying to remove the signature from the database whose id is not set.");
            }
        }
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<Signature> it2 = list.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next().getId()).append(",");
            }
            sb.setLength(sb.length() - 1);
            writableDatabase.execSQL("DELETE FROM signatures WHERE _id IN (" + sb.toString() + ")");
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }
}
