package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import com.pspdfkit.internal.u30;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface StampAnnotationConfiguration extends AnnotationConfiguration {

    public interface Builder extends AnnotationConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        StampAnnotationConfiguration build();

        Builder setAvailableStampPickerItems(List<StampPickerItem> list);
    }

    static Builder builder(Context context) {
        return new u30(context);
    }

    List<StampPickerItem> getStampsForPicker();
}
