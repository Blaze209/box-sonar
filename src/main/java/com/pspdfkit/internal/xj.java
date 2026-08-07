package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeAndroidHybridId;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class xj {
    public static final HashMap a = MapsKt.hashMapOf(TuplesKt.to(NativeAndroidHybridId.REACTNATIVE, CollectionsKt.listOf((Object[]) new String[]{"com.facebook.react.ReactApplication", "com.facebook.react.bridge.ReactBridge", "com.pspdfkit.react.PSPDFKitPackage", "com.pspdfkit.react.PSPDFKitModule"})), TuplesKt.to(NativeAndroidHybridId.FLUTTER, CollectionsKt.listOf((Object[]) new String[]{"io.flutter.view.FlutterView", "io.flutter.BuildConfig", "io.flutter.app.FlutterActivity", "com.pspdfkit.flutter.pspdfkit.PspdfkitPlugin", "com.pspdfkit.flutter.pspdfkit.FlutterPdfActivity"})), TuplesKt.to(NativeAndroidHybridId.CORDOVA, CollectionsKt.listOf((Object[]) new String[]{"org.apache.cordova.CordovaPlugin", "org.apache.cordova.BuildConfig", "org.apache.cordova.CordovaActivity"})), TuplesKt.to(NativeAndroidHybridId.XAMARIN, CollectionsKt.listOf((Object[]) new String[]{"mono.android.Runtime", "mono.MonoRuntimeProvider", "com.xamarin.forms.platform.android.FormsViewGroup", "com.xamarin.java_interop.internal.JavaProxyObject"})), TuplesKt.to(NativeAndroidHybridId.DOTNETBINDINGS, CollectionsKt.listOf((Object[]) new String[]{"mono.android.Runtime", "mono.MonoRuntimeProvider", "com.xamarin.forms.platform.android.FormsViewGroup", "com.xamarin.java_interop.internal.JavaProxyObject"})));

    public static final class a {
        @JvmStatic
        public static HashSet a() {
            HashSet hashSet = new HashSet();
            for (Map.Entry entry : xj.a.entrySet()) {
                NativeAndroidHybridId nativeAndroidHybridId = (NativeAndroidHybridId) entry.getKey();
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    try {
                        Class.forName((String) it.next());
                        hashSet.add(nativeAndroidHybridId);
                    } catch (Throwable unused) {
                    }
                }
            }
            return hashSet;
        }
    }
}
