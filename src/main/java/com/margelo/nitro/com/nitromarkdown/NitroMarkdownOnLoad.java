package com.margelo.nitro.com.nitromarkdown;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NitroMarkdownOnLoad.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/margelo/nitro/com/nitromarkdown/NitroMarkdownOnLoad;", "", "<init>", "()V", "Companion", "react-native-nitro-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NitroMarkdownOnLoad {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NitroMarkdownOnLoad";
    private static boolean didLoad;

    @JvmStatic
    public static final void initializeNative() {
        INSTANCE.initializeNative();
    }

    /* JADX INFO: compiled from: NitroMarkdownOnLoad.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/margelo/nitro/com/nitromarkdown/NitroMarkdownOnLoad$Companion;", "", "<init>", "()V", "TAG", "", "didLoad", "", "initializeNative", "", "react-native-nitro-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void initializeNative() {
            if (NitroMarkdownOnLoad.didLoad) {
                return;
            }
            try {
                Log.i(NitroMarkdownOnLoad.TAG, "Loading NitroMarkdown C++ library...");
                System.loadLibrary("NitroMarkdown");
                Log.i(NitroMarkdownOnLoad.TAG, "Successfully loaded NitroMarkdown C++ library!");
                NitroMarkdownOnLoad.didLoad = true;
            } catch (Error e) {
                Log.e(NitroMarkdownOnLoad.TAG, "Failed to load NitroMarkdown C++ library! Is it properly installed and linked? Is the name correct? (see `CMakeLists.txt`, at `add_library(...)`)", e);
                throw e;
            }
        }
    }
}
