package com.box.android.preview.previewtype.document.copytext;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class TextSelectionManager_Factory implements Factory<TextSelectionManager> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TextSelectionManager get() {
        return newInstance();
    }

    public static TextSelectionManager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TextSelectionManager newInstance() {
        return new TextSelectionManager();
    }

    private static final class InstanceHolder {
        static final TextSelectionManager_Factory INSTANCE = new TextSelectionManager_Factory();

        private InstanceHolder() {
        }
    }
}
