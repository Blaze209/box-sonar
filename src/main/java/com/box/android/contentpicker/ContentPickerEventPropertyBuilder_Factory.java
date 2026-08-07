package com.box.android.contentpicker;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class ContentPickerEventPropertyBuilder_Factory implements Factory<ContentPickerEventPropertyBuilder> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ContentPickerEventPropertyBuilder get() {
        return newInstance();
    }

    public static ContentPickerEventPropertyBuilder_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ContentPickerEventPropertyBuilder newInstance() {
        return new ContentPickerEventPropertyBuilder();
    }

    private static final class InstanceHolder {
        static final ContentPickerEventPropertyBuilder_Factory INSTANCE = new ContentPickerEventPropertyBuilder_Factory();

        private InstanceHolder() {
        }
    }
}
