package io.nutrient.data.models;

import java.util.Locale;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lio/nutrient/data/models/Issuer;", "", "<init>", "(Ljava/lang/String;I)V", "USER", "HUMAN", "SYSTEM", "AI", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public enum Issuer {
    USER,
    HUMAN,
    SYSTEM,
    AI;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.nutrient.data.models.Issuer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Issuer._init_$_anonymous_();
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¨\u0006\t"}, d2 = {"Lio/nutrient/data/models/Issuer$Companion;", "", "<init>", "()V", "value", "", "Lio/nutrient/data/models/Issuer;", "serializer", "Lkotlinx/serialization/KSerializer;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) Issuer.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Issuer> serializer() {
            return get$cachedSerializer();
        }

        public final String value(Issuer issuer) {
            issuer.getClass();
            String lowerCase = issuer.name().toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            return lowerCase;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("io.nutrient.data.models.Issuer", values());
    }

    public static EnumEntries<Issuer> getEntries() {
        return $ENTRIES;
    }
}
