package com.box.android.base.compose.popup.model;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.MenuDefaults;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PopupMenuItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001:\u000212BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fB5\b\u0016\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0012BM\b\u0016\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0015BM\b\u0016\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0019BK\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u001a\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u001bJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003JO\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0011HÖ\u0001J\t\u00100\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010%¨\u00063"}, d2 = {"Lcom/box/android/base/compose/popup/model/PopupMenuItem;", "", "text", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$TextSource;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "", "leadingIcon", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;", "trailingIcon", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "isEnabled", "", "<init>", "(Lcom/box/android/base/compose/popup/model/PopupMenuItem$TextSource;Lkotlin/jvm/functions/Function0;Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;Landroidx/compose/foundation/layout/PaddingValues;Z)V", "textRes", "", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;Z)V", "leadingIconRes", "trailingIconRes", "(ILkotlin/jvm/functions/Function0;Ljava/lang/Integer;Ljava/lang/Integer;Landroidx/compose/foundation/layout/PaddingValues;Z)V", "leadingIconVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "trailingIconVector", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/foundation/layout/PaddingValues;Z)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;Landroidx/compose/foundation/layout/PaddingValues;Z)V", "getText", "()Lcom/box/android/base/compose/popup/model/PopupMenuItem$TextSource;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getLeadingIcon", "()Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;", "getTrailingIcon", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "TextSource", "IconResource", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PopupMenuItem {
    public static final int $stable = 0;
    private final PaddingValues contentPadding;
    private final boolean isEnabled;
    private final IconResource leadingIcon;
    private final Function0<Unit> onClick;
    private final TextSource text;
    private final IconResource trailingIcon;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PopupMenuItem copy$default(PopupMenuItem popupMenuItem, TextSource textSource, Function0 function0, IconResource iconResource, IconResource iconResource2, PaddingValues paddingValues, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            textSource = popupMenuItem.text;
        }
        if ((i & 2) != 0) {
            function0 = popupMenuItem.onClick;
        }
        if ((i & 4) != 0) {
            iconResource = popupMenuItem.leadingIcon;
        }
        if ((i & 8) != 0) {
            iconResource2 = popupMenuItem.trailingIcon;
        }
        if ((i & 16) != 0) {
            paddingValues = popupMenuItem.contentPadding;
        }
        if ((i & 32) != 0) {
            z = popupMenuItem.isEnabled;
        }
        PaddingValues paddingValues2 = paddingValues;
        boolean z2 = z;
        return popupMenuItem.copy(textSource, function0, iconResource, iconResource2, paddingValues2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TextSource getText() {
        return this.text;
    }

    public final Function0<Unit> component2() {
        return this.onClick;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IconResource getLeadingIcon() {
        return this.leadingIcon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final IconResource getTrailingIcon() {
        return this.trailingIcon;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PaddingValues getContentPadding() {
        return this.contentPadding;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final PopupMenuItem copy(TextSource text, Function0<Unit> onClick, IconResource leadingIcon, IconResource trailingIcon, PaddingValues contentPadding, boolean isEnabled) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        return new PopupMenuItem(text, onClick, leadingIcon, trailingIcon, contentPadding, isEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PopupMenuItem)) {
            return false;
        }
        PopupMenuItem popupMenuItem = (PopupMenuItem) other;
        return Intrinsics.areEqual(this.text, popupMenuItem.text) && Intrinsics.areEqual(this.onClick, popupMenuItem.onClick) && Intrinsics.areEqual(this.leadingIcon, popupMenuItem.leadingIcon) && Intrinsics.areEqual(this.trailingIcon, popupMenuItem.trailingIcon) && Intrinsics.areEqual(this.contentPadding, popupMenuItem.contentPadding) && this.isEnabled == popupMenuItem.isEnabled;
    }

    public int hashCode() {
        int iHashCode = ((this.text.hashCode() * 31) + this.onClick.hashCode()) * 31;
        IconResource iconResource = this.leadingIcon;
        int iHashCode2 = (iHashCode + (iconResource == null ? 0 : iconResource.hashCode())) * 31;
        IconResource iconResource2 = this.trailingIcon;
        return ((((iHashCode2 + (iconResource2 != null ? iconResource2.hashCode() : 0)) * 31) + this.contentPadding.hashCode()) * 31) + Boolean.hashCode(this.isEnabled);
    }

    public String toString() {
        return "PopupMenuItem(text=" + this.text + ", onClick=" + this.onClick + ", leadingIcon=" + this.leadingIcon + ", trailingIcon=" + this.trailingIcon + ", contentPadding=" + this.contentPadding + ", isEnabled=" + this.isEnabled + ")";
    }

    public PopupMenuItem(TextSource text, Function0<Unit> onClick, IconResource iconResource, IconResource iconResource2, PaddingValues contentPadding, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        this.text = text;
        this.onClick = onClick;
        this.leadingIcon = iconResource;
        this.trailingIcon = iconResource2;
        this.contentPadding = contentPadding;
        this.isEnabled = z;
    }

    public final TextSource getText() {
        return this.text;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public final IconResource getLeadingIcon() {
        return this.leadingIcon;
    }

    public final IconResource getTrailingIcon() {
        return this.trailingIcon;
    }

    public /* synthetic */ PopupMenuItem(TextSource textSource, Function0 function0, IconResource iconResource, IconResource iconResource2, PaddingValues paddingValues, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textSource, (Function0<Unit>) function0, (i & 4) != 0 ? null : iconResource, (i & 8) != 0 ? null : iconResource2, (i & 16) != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues, (i & 32) != 0 ? true : z);
    }

    public final PaddingValues getContentPadding() {
        return this.contentPadding;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public /* synthetic */ PopupMenuItem(int i, Function0 function0, PaddingValues paddingValues, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function0, (i2 & 4) != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues, (i2 & 8) != 0 ? true : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupMenuItem(int i, Function0<Unit> onClick, PaddingValues contentPadding, boolean z) {
        this(new TextSource.Resource(i), onClick, (IconResource) null, (IconResource) null, contentPadding, z);
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
    }

    public /* synthetic */ PopupMenuItem(int i, Function0 function0, Integer num, Integer num2, PaddingValues paddingValues, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (Function0<Unit>) function0, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues, (i2 & 32) != 0 ? true : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupMenuItem(int i, Function0<Unit> onClick, Integer num, Integer num2, PaddingValues contentPadding, boolean z) {
        this(new TextSource.Resource(i), onClick, num != null ? new IconResource.DrawableResource(num.intValue()) : null, num2 != null ? new IconResource.DrawableResource(num2.intValue()) : null, contentPadding, z);
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
    }

    public /* synthetic */ PopupMenuItem(int i, Function0 function0, ImageVector imageVector, ImageVector imageVector2, PaddingValues paddingValues, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (Function0<Unit>) function0, (i2 & 4) != 0 ? null : imageVector, (i2 & 8) != 0 ? null : imageVector2, (i2 & 16) != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues, (i2 & 32) != 0 ? true : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupMenuItem(int i, Function0<Unit> onClick, ImageVector imageVector, ImageVector imageVector2, PaddingValues contentPadding, boolean z) {
        this(new TextSource.Resource(i), onClick, imageVector != null ? new IconResource.ImageVectorResource(imageVector) : null, imageVector2 != null ? new IconResource.ImageVectorResource(imageVector2) : null, contentPadding, z);
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
    }

    public /* synthetic */ PopupMenuItem(String str, Function0 function0, IconResource iconResource, IconResource iconResource2, PaddingValues paddingValues, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (Function0<Unit>) function0, (i & 4) != 0 ? null : iconResource, (i & 8) != 0 ? null : iconResource2, (i & 16) != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues, (i & 32) != 0 ? true : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopupMenuItem(String text, Function0<Unit> onClick, IconResource iconResource, IconResource iconResource2, PaddingValues contentPadding, boolean z) {
        this(new TextSource.Value(text), onClick, iconResource, iconResource2, contentPadding, z);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
    }

    /* JADX INFO: compiled from: PopupMenuItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/compose/popup/model/PopupMenuItem$TextSource;", "", "<init>", "()V", "Resource", "Value", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$TextSource$Resource;", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$TextSource$Value;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class TextSource {
        public static final int $stable = 0;

        public /* synthetic */ TextSource(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PopupMenuItem.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/compose/popup/model/PopupMenuItem$TextSource$Resource;", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$TextSource;", "resId", "", "<init>", "(I)V", "getResId", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Resource extends TextSource {
            public static final int $stable = 0;
            private final int resId;

            public static /* synthetic */ Resource copy$default(Resource resource, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = resource.resId;
                }
                return resource.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getResId() {
                return this.resId;
            }

            public final Resource copy(int resId) {
                return new Resource(resId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Resource) && this.resId == ((Resource) other).resId;
            }

            public int hashCode() {
                return Integer.hashCode(this.resId);
            }

            public String toString() {
                return "Resource(resId=" + this.resId + ")";
            }

            public Resource(int i) {
                super(null);
                this.resId = i;
            }

            public final int getResId() {
                return this.resId;
            }
        }

        private TextSource() {
        }

        /* JADX INFO: compiled from: PopupMenuItem.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/compose/popup/model/PopupMenuItem$TextSource$Value;", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$TextSource;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Value extends TextSource {
            public static final int $stable = 0;
            private final String value;

            public static /* synthetic */ Value copy$default(Value value, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = value.value;
                }
                return value.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public final Value copy(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new Value(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Value) && Intrinsics.areEqual(this.value, ((Value) other).value);
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "Value(value=" + this.value + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Value(String value) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public final String getValue() {
                return this.value;
            }
        }
    }

    /* JADX INFO: compiled from: PopupMenuItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;", "", "<init>", "()V", "DrawableResource", "ImageVectorResource", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource$DrawableResource;", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource$ImageVectorResource;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class IconResource {
        public static final int $stable = 0;

        public /* synthetic */ IconResource(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PopupMenuItem.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource$DrawableResource;", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;", "value", "", "<init>", "(I)V", "getValue", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DrawableResource extends IconResource {
            public static final int $stable = 0;
            private final int value;

            public static /* synthetic */ DrawableResource copy$default(DrawableResource drawableResource, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = drawableResource.value;
                }
                return drawableResource.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getValue() {
                return this.value;
            }

            public final DrawableResource copy(int value) {
                return new DrawableResource(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DrawableResource) && this.value == ((DrawableResource) other).value;
            }

            public int hashCode() {
                return Integer.hashCode(this.value);
            }

            public String toString() {
                return "DrawableResource(value=" + this.value + ")";
            }

            public DrawableResource(int i) {
                super(null);
                this.value = i;
            }

            public final int getValue() {
                return this.value;
            }
        }

        private IconResource() {
        }

        /* JADX INFO: compiled from: PopupMenuItem.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource$ImageVectorResource;", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;", "value", "Landroidx/compose/ui/graphics/vector/ImageVector;", "<init>", "(Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getValue", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ImageVectorResource extends IconResource {
            public static final int $stable = 0;
            private final ImageVector value;

            public static /* synthetic */ ImageVectorResource copy$default(ImageVectorResource imageVectorResource, ImageVector imageVector, int i, Object obj) {
                if ((i & 1) != 0) {
                    imageVector = imageVectorResource.value;
                }
                return imageVectorResource.copy(imageVector);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ImageVector getValue() {
                return this.value;
            }

            public final ImageVectorResource copy(ImageVector value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new ImageVectorResource(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ImageVectorResource) && Intrinsics.areEqual(this.value, ((ImageVectorResource) other).value);
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "ImageVectorResource(value=" + this.value + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageVectorResource(ImageVector value) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public final ImageVector getValue() {
                return this.value;
            }
        }
    }
}
