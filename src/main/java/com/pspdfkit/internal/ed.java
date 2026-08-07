package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.bx.a;
import com.pspdfkit.internal.jni.NativeDocumentDataStore;
import com.pspdfkit.internal.jni.NativeDocumentDataStoreCreateResult;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Single;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class ed {
    public static ed b;
    public static String c;
    public static bx d;
    public final NativeDocumentDataStore a;

    public ed() {
        Context context = n5.a;
        if (context == null) {
            throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
        }
        if (c == null) {
            File file = new File(context.getFilesDir(), "pspdfkit_data.db");
            c = file.getAbsolutePath();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new IllegalStateException("Unable to create a default file for document data store.", e);
            }
        }
        PdfLog.d("Nutri.DocumentDataStore", "Document data store located at " + c, new Object[0]);
        NativeDocumentDataStoreCreateResult nativeDocumentDataStoreCreateResultCreate = NativeDocumentDataStore.create(c);
        if (nativeDocumentDataStoreCreateResultCreate.getHasError()) {
            throw new NutrientException(nativeDocumentDataStoreCreateResultCreate.getErrorString() + " (" + nativeDocumentDataStoreCreateResultCreate.getErrorCode() + ")");
        }
        NativeDocumentDataStore documentDataStore = nativeDocumentDataStoreCreateResultCreate.getDocumentDataStore();
        if (documentDataStore == null) {
            throw new NutrientException("Could not initialize data store.");
        }
        this.a = documentDataStore;
    }

    public static synchronized ed a() {
        if (b == null) {
            b = new ed();
        }
        return b;
    }

    public static synchronized Single<ed> b() {
        Single singleFromCallable;
        bx bxVar;
        if (d == null) {
            ar.d();
            d = new bx("pspdfkit-data-store", 1);
        }
        singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.ed$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ed.a();
            }
        });
        bxVar = d;
        bxVar.getClass();
        return singleFromCallable.subscribeOn(bxVar.new a(5));
    }
}
