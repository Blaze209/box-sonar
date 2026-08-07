package com.pspdfkit.instant.client;

import android.content.Context;
import com.pspdfkit.Nutrient;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantErrorCode;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.internal.jni.NativeInstantError;
import com.pspdfkit.instant.internal.jni.NativeLocalServerDocumentLayers;
import com.pspdfkit.instant.internal.jni.NativeServerClient;
import com.pspdfkit.instant.internal.jni.NativeServerClientResult;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerResult;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentListResult;
import com.pspdfkit.internal.ll;
import com.pspdfkit.internal.lr;
import com.pspdfkit.internal.sj;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wl;
import io.reactivex.rxjava3.core.Single;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
public final class InstantClient {
    private static final String HEADER_NUTRIENT_PLATFORM = "PSPDFKit-Platform";
    private static final String HEADER_NUTRIENT_VERSION = "PSPDFKit-Version";
    private static final String INSTANT_DATA_DIR = "pspdfkit-instant";
    private static final String PLATFORM_ANDROID = "android";
    private static final String PROTOCOL_VERSION = NativeServerClient.getProtocolVersion();
    private static final Map<String, WeakReference<InstantClient>> instances = new HashMap();
    private final String dataPath;
    private final sj httpClient;
    private final NativeServerClient nativeServerClient;
    private final Map<String, Map<String, WeakReference<InstantDocumentDescriptor>>> openedDocuments = new HashMap();
    private final String serverUrl;

    private InstantClient(Context context, String str) {
        Nutrient.ensureInitialized();
        uw.a(context, "context", null);
        uw.a(str, "serverUrl", null);
        File file = new File(context.getCacheDir(), "nutrient");
        file.mkdirs();
        sj sjVar = new sj(file);
        this.httpClient = sjVar;
        HashMap map = new HashMap();
        map.put(HEADER_NUTRIENT_PLATFORM, "android");
        String str2 = PROTOCOL_VERSION;
        map.put(HEADER_NUTRIENT_VERSION, str2);
        sjVar.c.clear();
        sjVar.c.putAll(map);
        this.serverUrl = ll.a(str);
        String dataPath = getDataPath(context);
        this.dataPath = dataPath;
        NativeServerClientResult nativeServerClientResultCreate = NativeServerClient.create(dataPath, str, context.getPackageName(), sjVar, str2);
        if (nativeServerClientResultCreate.isError()) {
            throw lr.a(nativeServerClientResultCreate.error());
        }
        this.nativeServerClient = nativeServerClientResultCreate.value();
    }

    public static synchronized void clearInstanceCache() {
        instances.clear();
    }

    public static synchronized InstantClient create(Context context, String str) {
        uw.a(context, "Context may not be null.", null);
        uw.a(str, "Server URL may not be null.", null);
        String strA = ll.a(str);
        Map<String, WeakReference<InstantClient>> map = instances;
        InstantClient instantClient = map.containsKey(strA) ? map.get(strA).get() : null;
        if (instantClient != null) {
            return instantClient;
        }
        InstantClient instantClient2 = new InstantClient(context, str);
        map.put(strA, new WeakReference<>(instantClient2));
        return instantClient2;
    }

    public static String getDataPath(Context context) {
        return new File(context.getFilesDir(), INSTANT_DATA_DIR).getAbsolutePath();
    }

    public static synchronized Collection<WeakReference<InstantClient>> getInstances() {
        return instances.values();
    }

    private InstantDocumentDescriptor getInstantDocumentDescriptorFromCache(String str, String str2) {
        Map<String, WeakReference<InstantDocumentDescriptor>> map = this.openedDocuments.get(str);
        if (map == null || !map.containsKey(str2)) {
            return null;
        }
        return map.get(str2).get();
    }

    private Map<String, WeakReference<InstantDocumentDescriptor>> getInstantDocumentLayersSetFromCache(String str) {
        Map<String, WeakReference<InstantDocumentDescriptor>> map = this.openedDocuments.get(str);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        this.openedDocuments.put(str, map2);
        return map2;
    }

    private void putInstantDocumentDescriptorToCache(InstantDocumentDescriptor instantDocumentDescriptor) {
        getInstantDocumentLayersSetFromCache(instantDocumentDescriptor.getDocumentId()).put(instantDocumentDescriptor.getLayerName(), new WeakReference<>(instantDocumentDescriptor));
    }

    private InstantDocumentDescriptor wrapNativeLayerResult(NativeServerDocumentLayerResult nativeServerDocumentLayerResult) {
        if (nativeServerDocumentLayerResult.isError()) {
            throw lr.a(nativeServerDocumentLayerResult.error());
        }
        return new InstantDocumentDescriptor(this, nativeServerDocumentLayerResult.value());
    }

    public synchronized InstantDocumentDescriptor getInstantDocumentDescriptorForJwt(String str) {
        uw.a(str, "jwt may not be null.", null);
        wl wlVarA = wl.a(str);
        InstantDocumentDescriptor instantDocumentDescriptorFromCache = getInstantDocumentDescriptorFromCache(wlVarA.a.documentId(), wlVarA.a.layerName());
        if (instantDocumentDescriptorFromCache == null) {
            InstantDocumentDescriptor instantDocumentDescriptorWrapNativeLayerResult = wrapNativeLayerResult(this.nativeServerClient.getLayerForJwt(wlVarA.a));
            putInstantDocumentDescriptorToCache(instantDocumentDescriptorWrapNativeLayerResult);
            return instantDocumentDescriptorWrapNativeLayerResult;
        }
        String strUserId = wlVarA.a.userId();
        String userId = instantDocumentDescriptorFromCache.getUserId();
        if ((strUserId != null && !strUserId.equals(userId)) || (userId != null && !userId.equals(strUserId))) {
            throw new InstantException(InstantErrorCode.USER_MISMATCH, "Attempted to obtain a document descriptor for a JWT with the `user_id` claim '%s' but the one we have belongs to '%s'", strUserId, userId);
        }
        return instantDocumentDescriptorFromCache;
    }

    public synchronized List<InstantDocumentDescriptor> getLocalDocumentDescriptors() {
        NativeServerDocumentListResult nativeServerDocumentListResultListLocalDocuments = this.nativeServerClient.listLocalDocuments();
        if (nativeServerDocumentListResultListLocalDocuments.isError()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<NativeLocalServerDocumentLayers> arrayListValue = nativeServerDocumentListResultListLocalDocuments.value();
        int size = arrayListValue.size();
        int i = 0;
        while (i < size) {
            NativeLocalServerDocumentLayers nativeLocalServerDocumentLayers = arrayListValue.get(i);
            i++;
            NativeLocalServerDocumentLayers nativeLocalServerDocumentLayers2 = nativeLocalServerDocumentLayers;
            Map<String, WeakReference<InstantDocumentDescriptor>> instantDocumentLayersSetFromCache = getInstantDocumentLayersSetFromCache(nativeLocalServerDocumentLayers2.getDocumentId());
            ArrayList<NativeServerDocumentLayer> loadedLayers = nativeLocalServerDocumentLayers2.getLoadedLayers();
            int size2 = loadedLayers.size();
            int i2 = 0;
            while (i2 < size2) {
                NativeServerDocumentLayer nativeServerDocumentLayer = loadedLayers.get(i2);
                i2++;
                NativeServerDocumentLayer nativeServerDocumentLayer2 = nativeServerDocumentLayer;
                String layerName = nativeServerDocumentLayer2.getLayerName();
                InstantDocumentDescriptor instantDocumentDescriptor = instantDocumentLayersSetFromCache.containsKey(layerName) ? instantDocumentLayersSetFromCache.get(layerName).get() : null;
                if (instantDocumentDescriptor == null) {
                    instantDocumentDescriptor = new InstantDocumentDescriptor(this, nativeServerDocumentLayer2);
                    instantDocumentLayersSetFromCache.put(layerName, new WeakReference<>(instantDocumentDescriptor));
                }
                arrayList.add(instantDocumentDescriptor);
            }
        }
        return arrayList;
    }

    public NativeServerClient getNativeClient() {
        return this.nativeServerClient;
    }

    public synchronized Collection<WeakReference<InstantDocumentDescriptor>> getOpenedDocuments() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<Map<String, WeakReference<InstantDocumentDescriptor>>> it = this.openedDocuments.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public InstantPdfDocument openDocument(String str) {
        return getInstantDocumentDescriptorForJwt(str).openDocument(str);
    }

    public Single<InstantPdfDocument> openDocumentAsync(String str) {
        return getInstantDocumentDescriptorForJwt(str).openDocumentAsync(str);
    }

    public synchronized void removeLocalStorage() {
        this.openedDocuments.clear();
        NativeInstantError nativeInstantErrorRemoveLocalStorage = this.nativeServerClient.removeLocalStorage();
        if (nativeInstantErrorRemoveLocalStorage != null) {
            throw new InstantException(lr.a(nativeInstantErrorRemoveLocalStorage.getCode()), nativeInstantErrorRemoveLocalStorage.getMessage(), nativeInstantErrorRemoveLocalStorage.getUnderlyingError());
        }
    }

    public synchronized void removeLocalStorageForDocument(String str) {
        this.openedDocuments.get(str).clear();
        NativeInstantError nativeInstantErrorPurgeDocumentWithId = this.nativeServerClient.purgeDocumentWithId(str);
        if (nativeInstantErrorPurgeDocumentWithId != null) {
            throw new InstantException(lr.a(nativeInstantErrorPurgeDocumentWithId.getCode()), nativeInstantErrorPurgeDocumentWithId.getMessage(), nativeInstantErrorPurgeDocumentWithId.getUnderlyingError());
        }
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public static InstantClient create(Context context, URL url) {
        return create(context, url.toString());
    }

    public static InstantClient create(Context context, HttpUrl httpUrl) {
        return create(context, httpUrl.getUrl());
    }
}
