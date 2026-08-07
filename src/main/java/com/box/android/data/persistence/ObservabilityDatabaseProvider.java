package com.box.android.data.persistence;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObservabilityDatabaseProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/persistence/ObservabilityDatabaseProvider;", "", "observabilityDatabaseCreator", "Lcom/box/android/data/persistence/ObservabilityDatabaseCreator;", "context", "Landroid/content/Context;", "<init>", "(Lcom/box/android/data/persistence/ObservabilityDatabaseCreator;Landroid/content/Context;)V", "observabilityDatabase", "Lcom/box/android/data/persistence/BoxObservabilityDatabase;", "getObservabilityDatabase", "()Lcom/box/android/data/persistence/BoxObservabilityDatabase;", "observabilityDatabase$delegate", "Lkotlin/Lazy;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ObservabilityDatabaseProvider {
    private final Context context;

    /* JADX INFO: renamed from: observabilityDatabase$delegate, reason: from kotlin metadata */
    private final Lazy observabilityDatabase;
    private final ObservabilityDatabaseCreator observabilityDatabaseCreator;

    @Inject
    public ObservabilityDatabaseProvider(ObservabilityDatabaseCreator observabilityDatabaseCreator, Context context) {
        Intrinsics.checkNotNullParameter(observabilityDatabaseCreator, "observabilityDatabaseCreator");
        Intrinsics.checkNotNullParameter(context, "context");
        this.observabilityDatabaseCreator = observabilityDatabaseCreator;
        this.context = context;
        this.observabilityDatabase = LazyKt.lazy(new Function0() { // from class: com.box.android.data.persistence.ObservabilityDatabaseProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ObservabilityDatabaseProvider.observabilityDatabase_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final BoxObservabilityDatabase getObservabilityDatabase() {
        return (BoxObservabilityDatabase) this.observabilityDatabase.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxObservabilityDatabase observabilityDatabase_delegate$lambda$0(ObservabilityDatabaseProvider observabilityDatabaseProvider) {
        return observabilityDatabaseProvider.observabilityDatabaseCreator.createDb(observabilityDatabaseProvider.context, "boxdata_observability.db");
    }
}
