package com.pspdfkit.document;

import android.graphics.Typeface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.GoToAction;
import com.pspdfkit.internal.mv;
import com.pspdfkit.internal.nd;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b \b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0003,-.Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00000\u000fHÆ\u0003Je\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000fHÆ\u0001J\u0014\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/pspdfkit/document/OutlineElement;", "", "title", "", "color", "", "style", "typeface", "Landroid/graphics/Typeface;", "isExpanded", "", Analytics.Data.ACTION, "Lcom/pspdfkit/annotations/actions/Action;", "pageLabel", "children", "", "<init>", "(Ljava/lang/String;IILandroid/graphics/Typeface;ZLcom/pspdfkit/annotations/actions/Action;Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getColor", "()I", "getStyle", "getTypeface", "()Landroid/graphics/Typeface;", "()Z", "getAction", "()Lcom/pspdfkit/annotations/actions/Action;", "getPageLabel", "getChildren", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "Companion", "OutlineElementStyle", "Builder", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class OutlineElement {
    public static final int DEFAULT_COLOR = -16777216;
    private final Action action;
    private final List<OutlineElement> children;
    private final int color;
    private final boolean isExpanded;
    private final String pageLabel;
    private final int style;
    private final String title;
    private final Typeface typeface;
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/pspdfkit/document/OutlineElement$OutlineElementStyle;", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface OutlineElementStyle {
    }

    public OutlineElement(String str, int i, int i2, Typeface typeface, boolean z, Action action, String str2, List<OutlineElement> list) {
        str.getClass();
        list.getClass();
        this.title = str;
        this.color = i;
        this.style = i2;
        this.typeface = typeface;
        this.isExpanded = z;
        this.action = action;
        this.pageLabel = str2;
        this.children = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OutlineElement copy$default(OutlineElement outlineElement, String str, int i, int i2, Typeface typeface, boolean z, Action action, String str2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = outlineElement.title;
        }
        if ((i3 & 2) != 0) {
            i = outlineElement.color;
        }
        if ((i3 & 4) != 0) {
            i2 = outlineElement.style;
        }
        if ((i3 & 8) != 0) {
            typeface = outlineElement.typeface;
        }
        if ((i3 & 16) != 0) {
            z = outlineElement.isExpanded;
        }
        if ((i3 & 32) != 0) {
            action = outlineElement.action;
        }
        if ((i3 & 64) != 0) {
            str2 = outlineElement.pageLabel;
        }
        if ((i3 & 128) != 0) {
            list = outlineElement.children;
        }
        String str3 = str2;
        List list2 = list;
        boolean z2 = z;
        Action action2 = action;
        return outlineElement.copy(str, i, i2, typeface, z2, action2, str3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Typeface getTypeface() {
        return this.typeface;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Action getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPageLabel() {
        return this.pageLabel;
    }

    public final List<OutlineElement> component8() {
        return this.children;
    }

    public final OutlineElement copy(String title, int color, int style, Typeface typeface, boolean isExpanded, Action action, String pageLabel, List<OutlineElement> children) {
        title.getClass();
        children.getClass();
        return new OutlineElement(title, color, style, typeface, isExpanded, action, pageLabel, children);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutlineElement)) {
            return false;
        }
        OutlineElement outlineElement = (OutlineElement) other;
        return Intrinsics.areEqual(this.title, outlineElement.title) && this.color == outlineElement.color && this.style == outlineElement.style && Intrinsics.areEqual(this.typeface, outlineElement.typeface) && this.isExpanded == outlineElement.isExpanded && Intrinsics.areEqual(this.action, outlineElement.action) && Intrinsics.areEqual(this.pageLabel, outlineElement.pageLabel) && Intrinsics.areEqual(this.children, outlineElement.children);
    }

    public final Action getAction() {
        return this.action;
    }

    public final List<OutlineElement> getChildren() {
        return this.children;
    }

    public final int getColor() {
        return this.color;
    }

    public final String getPageLabel() {
        return this.pageLabel;
    }

    public final int getStyle() {
        return this.style;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Typeface getTypeface() {
        return this.typeface;
    }

    public int hashCode() {
        int iA = nd.a(this.style, nd.a(this.color, this.title.hashCode() * 31, 31), 31);
        Typeface typeface = this.typeface;
        int iA2 = mv.a(this.isExpanded, (iA + (typeface == null ? 0 : typeface.hashCode())) * 31, 31);
        Action action = this.action;
        int iHashCode = (iA2 + (action == null ? 0 : action.hashCode())) * 31;
        String str = this.pageLabel;
        return this.children.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31);
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public String toString() {
        return "OutlineElement(title=" + this.title + ", color=" + this.color + ", style=" + this.style + ", typeface=" + this.typeface + ", isExpanded=" + this.isExpanded + ", action=" + this.action + ", pageLabel=" + this.pageLabel + ", children=" + this.children + ")";
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0003J\u0014\u0010\"\u001a\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0006\u0010#\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/pspdfkit/document/OutlineElement$Builder;", "", "title", "", "<init>", "(Ljava/lang/String;)V", "document", "Lcom/pspdfkit/document/PdfDocument;", "targetPageIndex", "", "(Lcom/pspdfkit/document/PdfDocument;Ljava/lang/String;I)V", "color", "style", "getStyle$annotations", "()V", "typeface", "Landroid/graphics/Typeface;", "isExpanded", "", Analytics.Data.ACTION, "Lcom/pspdfkit/annotations/actions/Action;", "pageLabel", "children", "", "Lcom/pspdfkit/document/OutlineElement;", "setTitle", "setColor", "textColor", "setStyle", "textStyle", "setTypeface", "setExpanded", "setAction", "setPageLabel", "setChildren", "build", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private Action action;
        private List<OutlineElement> children;
        private int color;
        private boolean isExpanded;
        private String pageLabel;
        private int style;
        private String title;
        private Typeface typeface;

        public Builder(String str) {
            str.getClass();
            this.color = -16777216;
            this.typeface = Typeface.DEFAULT;
            this.children = CollectionsKt.emptyList();
            this.title = str;
        }

        private static /* synthetic */ void getStyle$annotations() {
        }

        public final OutlineElement build() {
            return new OutlineElement(this.title, this.color, this.style, this.typeface, this.isExpanded, this.action, this.pageLabel, this.children);
        }

        public final Builder setAction(Action action) {
            action.getClass();
            this.action = action;
            return this;
        }

        public final Builder setChildren(List<OutlineElement> children) {
            children.getClass();
            this.children = new ArrayList(children);
            return this;
        }

        public final Builder setColor(int textColor) {
            this.color = textColor;
            return this;
        }

        public final Builder setExpanded(boolean isExpanded) {
            this.isExpanded = isExpanded;
            return this;
        }

        public final Builder setPageLabel(String pageLabel) {
            pageLabel.getClass();
            this.pageLabel = pageLabel;
            return this;
        }

        public final Builder setStyle(int textStyle) {
            this.style = textStyle;
            return this;
        }

        public final Builder setTitle(String title) {
            title.getClass();
            this.title = title;
            return this;
        }

        public final Builder setTypeface(Typeface typeface) {
            typeface.getClass();
            this.typeface = typeface;
            return this;
        }

        public Builder(PdfDocument pdfDocument, String str, int i) {
            pdfDocument.getClass();
            str.getClass();
            this.color = -16777216;
            this.typeface = Typeface.DEFAULT;
            this.children = CollectionsKt.emptyList();
            this.title = str;
            this.action = new GoToAction(i, null, null, 6, null);
            this.pageLabel = pdfDocument.getPageLabel(i, false);
        }
    }

    public /* synthetic */ OutlineElement(String str, int i, int i2, Typeface typeface, boolean z, Action action, String str2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? -16777216 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? Typeface.DEFAULT : typeface, (i3 & 16) == 0 ? z : false, (i3 & 32) != 0 ? null : action, (i3 & 64) == 0 ? str2 : null, (i3 & 128) != 0 ? CollectionsKt.emptyList() : list);
    }
}
