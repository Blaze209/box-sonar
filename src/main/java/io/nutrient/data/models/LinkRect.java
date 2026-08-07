package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonIgnoreUnknownKeys;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreUnknownKeys
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006("}, d2 = {"Lio/nutrient/data/models/LinkRect;", "", ViewProps.TOP, "", "left", "width", "height", "<init>", "(DDDD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IDDDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTop", "()D", "getLeft", "getWidth", "getHeight", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sdk_nutrient", "$serializer", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class LinkRect {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double height;
    private final double left;
    private final double top;
    private final double width;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/nutrient/data/models/LinkRect$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/nutrient/data/models/LinkRect;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<LinkRect> serializer() {
            return LinkRect$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public LinkRect(double d, double d2, double d3, double d4) {
        this.top = d;
        this.left = d2;
        this.width = d3;
        this.height = d4;
    }

    public static /* synthetic */ LinkRect copy$default(LinkRect linkRect, double d, double d2, double d3, double d4, int i, Object obj) {
        if ((i & 1) != 0) {
            d = linkRect.top;
        }
        double d5 = d;
        if ((i & 2) != 0) {
            d2 = linkRect.left;
        }
        double d6 = d2;
        if ((i & 4) != 0) {
            d3 = linkRect.width;
        }
        return linkRect.copy(d5, d6, d3, (i & 8) != 0 ? linkRect.height : d4);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sdk_nutrient(LinkRect self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeDoubleElement(serialDesc, 0, self.top);
        output.encodeDoubleElement(serialDesc, 1, self.left);
        output.encodeDoubleElement(serialDesc, 2, self.width);
        output.encodeDoubleElement(serialDesc, 3, self.height);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    public final LinkRect copy(double top, double left, double width, double height) {
        return new LinkRect(top, left, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkRect)) {
            return false;
        }
        LinkRect linkRect = (LinkRect) other;
        return Double.compare(this.top, linkRect.top) == 0 && Double.compare(this.left, linkRect.left) == 0 && Double.compare(this.width, linkRect.width) == 0 && Double.compare(this.height, linkRect.height) == 0;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getLeft() {
        return this.left;
    }

    public final double getTop() {
        return this.top;
    }

    public final double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return Double.hashCode(this.height) + ((Double.hashCode(this.width) + ((Double.hashCode(this.left) + (Double.hashCode(this.top) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "LinkRect(top=" + this.top + ", left=" + this.left + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public /* synthetic */ LinkRect(int i, double d, double d2, double d3, double d4, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, LinkRect$$serializer.INSTANCE.getDescriptor());
        }
        this.top = d;
        this.left = d2;
        this.width = d3;
        this.height = d4;
    }
}
