package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeCertificateRevocationManager;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativeKeyStore;
import com.pspdfkit.internal.jni.NativeX509Certificate;
import com.pspdfkit.utils.PdfLog;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.Json;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class t8 {
    public static final String a(NativeDocument nativeDocument, List<? extends NativeX509Certificate> list, NativeKeyStore nativeKeyStore) throws JSONException {
        nativeDocument.getClass();
        list.getClass();
        nativeKeyStore.getClass();
        ArrayList<String> arrayListGenerateHttpRevocationRequests = NativeCertificateRevocationManager.generateHttpRevocationRequests(nativeDocument.getDocumentProviders().get(0), nativeKeyStore, new ArrayList(list));
        arrayListGenerateHttpRevocationRequests.getClass();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = arrayListGenerateHttpRevocationRequests.iterator();
        it.getClass();
        while (it.hasNext()) {
            String next = it.next();
            nz.b bVar = nz.Companion;
            next.getClass();
            bVar.getClass();
            Json.Companion companion = Json.INSTANCE;
            companion.getSerializersModule();
            nz nzVar = (nz) companion.decodeFromString(bVar.serializer(), next);
            try {
                Response responseA = nzVar.a();
                oz.b bVar2 = oz.Companion;
                String str = nzVar.c;
                bVar2.getClass();
                oz ozVarA = oz.b.a(str, responseA);
                companion.getSerializersModule();
                jSONArray.put(new JSONObject(companion.encodeToString(bVar2.serializer(), ozVarA)));
            } catch (UnknownServiceException e) {
                PdfLog.e("Nutri.CertRevocManager", e, "UnknownServiceException caught during certificate revocation check. If it's an issue with 'CLEARTEXT communication', it is likely that the revocation URL in the certificate uses http instead of https. For the revocation check (and LTV) to work, you must first enable 'usesCleartextTraffic' for your app.", new Object[0]);
                JSONObject jSONObjectPut = new JSONObject().put("token", nzVar.c).put("response_code", 0);
                jSONObjectPut.getClass();
                jSONArray.put(jSONObjectPut);
            } catch (Exception e2) {
                PdfLog.e("Nutri.CertRevocManager", e2, "Error while generating certificate revocation responses. This means we can't embed LTV info in the signature. We will continue signing, but the signature will not be PAdES level B-LT.", new Object[0]);
                JSONObject jSONObjectPut2 = new JSONObject().put("token", nzVar.c).put("response_code", 0);
                jSONObjectPut2.getClass();
                jSONArray.put(jSONObjectPut2);
            }
        }
        String string = jSONArray.toString();
        string.getClass();
        return string;
    }
}
