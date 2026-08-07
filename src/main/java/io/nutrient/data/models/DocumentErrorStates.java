package io.nutrient.data.models;

import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lio/nutrient/data/models/DocumentErrorStates;", "", "code", "", "message", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "INGESTED", "NOT_INGESTED", "INGESTED_OUTDATED", "INVALID_ID", "EXCEEDS_LIMIT", "NOT_FOUND", "INGESTED_UPDATED", "UNSUPPORTED_MEDIA", "SERVER_ERROR", "EVALUATION_EXPIRED", "INTERNET_NOT_AVAILABLE", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public enum DocumentErrorStates {
    INGESTED(204, "Document is already ingested and the file hash matches."),
    NOT_INGESTED(404, "Document is not ingested."),
    INGESTED_OUTDATED(409, "Document is ingested but file hash differs and is likely out of date."),
    INVALID_ID(400, "Invalid document ID."),
    EXCEEDS_LIMIT(403, "Document exceeds licensed maximum page count or license restrictions."),
    NOT_FOUND(404, "Document not found."),
    INGESTED_UPDATED(409, "Document is ingested but has been updated."),
    UNSUPPORTED_MEDIA(415, "Unsupported Media Type (not PDF)."),
    SERVER_ERROR(500, "Server error."),
    EVALUATION_EXPIRED(403, "Evaluation period has expired."),
    INTERNET_NOT_AVAILABLE(503, "Internet now available");

    private final int code;
    private final String message;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.nutrient.data.models.DocumentErrorStates$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DocumentErrorStates._init_$_anonymous_();
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lio/nutrient/data/models/DocumentErrorStates$Companion;", "", "<init>", "()V", "getStateByCode", "Lio/nutrient/data/models/DocumentErrorStates;", "code", "", "serializer", "Lkotlinx/serialization/KSerializer;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) DocumentErrorStates.$cachedSerializer$delegate.getValue();
        }

        public final DocumentErrorStates getStateByCode(int code) {
            DocumentErrorStates next;
            Iterator<DocumentErrorStates> it = DocumentErrorStates.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (next.getCode() != code);
            DocumentErrorStates documentErrorStates = next;
            return documentErrorStates == null ? DocumentErrorStates.SERVER_ERROR : documentErrorStates;
        }

        public final KSerializer<DocumentErrorStates> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    DocumentErrorStates(int i, String str) {
        this.code = i;
        this.message = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("io.nutrient.data.models.DocumentErrorStates", values());
    }

    public static EnumEntries<DocumentErrorStates> getEntries() {
        return $ENTRIES;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    /* synthetic */ DocumentErrorStates(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }
}
