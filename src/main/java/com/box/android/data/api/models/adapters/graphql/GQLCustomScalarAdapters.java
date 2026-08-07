package com.box.android.data.api.models.adapters.graphql;

import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.box.android.data.type.DateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GQLCustomScalarAdapters.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/api/models/adapters/graphql/GQLCustomScalarAdapters;", "", "<init>", "()V", "buildCustomScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCustomScalarAdapters {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CustomScalarAdapters customScalars = new GQLCustomScalarAdapters().buildCustomScalarAdapters();

    /* JADX INFO: compiled from: GQLCustomScalarAdapters.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/api/models/adapters/graphql/GQLCustomScalarAdapters$Companion;", "", "<init>", "()V", "customScalars", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "getCustomScalars", "()Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomScalarAdapters getCustomScalars() {
            return GQLCustomScalarAdapters.customScalars;
        }
    }

    public final CustomScalarAdapters buildCustomScalarAdapters() {
        return new CustomScalarAdapters.Builder().add(DateTime.INSTANCE.getType(), GQLBoxDateFormatAdapter.INSTANCE).build();
    }
}
