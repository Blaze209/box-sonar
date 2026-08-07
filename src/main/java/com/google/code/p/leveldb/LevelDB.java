package com.google.code.p.leveldb;

import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
public class LevelDB {
    String mDBdir;

    private native boolean dbClear();

    private native boolean dbClearByKey(String str);

    private native boolean dbClose(String str);

    private native String[] dbDelete(String str);

    private native boolean dbDestroy(String str);

    private native String[] dbGet(String str);

    private native boolean dbKeyExists(String str);

    private native boolean dbOpen(String str);

    private native String[] dbPut(String str, String str2);

    static {
        System.loadLibrary("leveldb");
    }

    public LevelDB(String str) {
        this.mDBdir = str;
        new File(this.mDBdir).mkdirs();
    }

    public boolean open() {
        return dbOpen(this.mDBdir);
    }

    public boolean close() {
        return dbClose(this.mDBdir);
    }

    public boolean destroy() {
        return dbDestroy(this.mDBdir);
    }

    public String put(String str, String str2) {
        String[] strArrDbPut = dbPut(str, str2);
        if (strArrDbPut.length == 2 && strArrDbPut[0].equals("1")) {
            return strArrDbPut[1];
        }
        return null;
    }

    public String get(String str) {
        String[] strArrDbGet = dbGet(str);
        if (strArrDbGet.length == 2 && strArrDbGet[0].equals("1")) {
            return strArrDbGet[1];
        }
        return null;
    }

    public String delete(String str) {
        String[] strArrDbDelete = dbDelete(str);
        if (strArrDbDelete.length == 2 && strArrDbDelete[0].equals("1")) {
            return strArrDbDelete[1];
        }
        return null;
    }

    public boolean keyExists(String str) {
        return dbKeyExists(str);
    }

    public boolean clear() {
        return dbClear();
    }

    public boolean clear(String str) {
        return dbClearByKey(str);
    }
}
