package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.internal.nd;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lio/nutrient/data/models/DocumentLinkResponse;", "", "rects", "", "Lio/nutrient/data/models/LinkRect;", "pageIndex", "", "document", "Lio/nutrient/data/models/Document;", "<init>", "(Ljava/util/List;ILio/nutrient/data/models/Document;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ILio/nutrient/data/models/Document;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRects", "()Ljava/util/List;", "getPageIndex", "()I", "getDocument", "()Lio/nutrient/data/models/Document;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sdk_nutrient", "$serializer", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class DocumentLinkResponse {
    private final Document document;
    private final int pageIndex;
    private final List<LinkRect> rects;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.nutrient.data.models.DocumentLinkResponse$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DocumentLinkResponse._childSerializers$_anonymous_();
        }
    }), null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/nutrient/data/models/DocumentLinkResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/nutrient/data/models/DocumentLinkResponse;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DocumentLinkResponse> serializer() {
            return DocumentLinkResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DocumentLinkResponse(int i, List list, int i2, Document document, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, DocumentLinkResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.rects = list;
        this.pageIndex = i2;
        this.document = document;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(LinkRect$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentLinkResponse copy$default(DocumentLinkResponse documentLinkResponse, List list, int i, Document document, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = documentLinkResponse.rects;
        }
        if ((i2 & 2) != 0) {
            i = documentLinkResponse.pageIndex;
        }
        if ((i2 & 4) != 0) {
            document = documentLinkResponse.document;
        }
        return documentLinkResponse.copy(list, i, document);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sdk_nutrient(DocumentLinkResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0].getValue(), self.rects);
        output.encodeIntElement(serialDesc, 1, self.pageIndex);
        output.encodeSerializableElement(serialDesc, 2, Document$$serializer.INSTANCE, self.document);
    }

    public final List<LinkRect> component1() {
        return this.rects;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Document getDocument() {
        return this.document;
    }

    public final DocumentLinkResponse copy(List<LinkRect> rects, int pageIndex, Document document) {
        rects.getClass();
        document.getClass();
        return new DocumentLinkResponse(rects, pageIndex, document);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentLinkResponse)) {
            return false;
        }
        DocumentLinkResponse documentLinkResponse = (DocumentLinkResponse) other;
        return Intrinsics.areEqual(this.rects, documentLinkResponse.rects) && this.pageIndex == documentLinkResponse.pageIndex && Intrinsics.areEqual(this.document, documentLinkResponse.document);
    }

    public final Document getDocument() {
        return this.document;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final List<LinkRect> getRects() {
        return this.rects;
    }

    public int hashCode() {
        return this.document.hashCode() + nd.a(this.pageIndex, this.rects.hashCode() * 31, 31);
    }

    public String toString() {
        return "DocumentLinkResponse(rects=" + this.rects + ", pageIndex=" + this.pageIndex + ", document=" + this.document + ")";
    }

    public DocumentLinkResponse(List<LinkRect> list, int i, Document document) {
        list.getClass();
        document.getClass();
        this.rects = list;
        this.pageIndex = i;
        this.document = document;
    }
}
