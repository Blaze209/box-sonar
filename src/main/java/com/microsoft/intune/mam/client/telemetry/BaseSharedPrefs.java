package com.microsoft.intune.mam.client.telemetry;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.intune.mam.client.app.DirectBootUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseSharedPrefs {
    protected final Context mContext;
    protected final boolean mDirectBootAware;
    protected final String mSharedPrefsName;

    /* JADX INFO: Access modifiers changed from: protected */
    public interface GetPref<T> {
        T execute(SharedPreferences sharedPreferences);
    }

    protected interface GetSetPref {
        void execute(SharedPreferences sharedPreferences, SharedPreferences.Editor editor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface SetPref {
        void execute(SharedPreferences.Editor editor);
    }

    public BaseSharedPrefs(Context context, String str) {
        this(context, str, false);
    }

    public BaseSharedPrefs(Context context, String str, boolean z) {
        this.mContext = context;
        this.mSharedPrefsName = str;
        this.mDirectBootAware = z;
    }

    private SharedPreferences getPrefs() {
        Context directBootAwareContext = this.mContext;
        if (this.mDirectBootAware) {
            directBootAwareContext = DirectBootUtils.getDirectBootAwareContext(directBootAwareContext);
        }
        return directBootAwareContext.getSharedPreferences(this.mSharedPrefsName, 0);
    }

    protected <T> T getSharedPref(GetPref<T> getPref) {
        return getPref.execute(getPrefs());
    }

    protected void setSharedPref(SetPref setPref) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        setPref.execute(editorEdit);
        editorEdit.apply();
    }

    protected void getSetSharedPref(GetSetPref getSetPref) {
        SharedPreferences prefs = getPrefs();
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        getSetPref.execute(prefs, editorEdit);
        editorEdit.apply();
    }
}
