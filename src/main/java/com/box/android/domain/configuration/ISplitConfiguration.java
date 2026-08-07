package com.box.android.domain.configuration;

import com.box.androidsdk.content.models.BoxUser;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SplitConfiguration.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH¦@¢\u0006\u0002\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/configuration/ISplitConfiguration;", "", "init", "", "boxUser", "Lcom/box/androidsdk/content/models/BoxUser;", "getTreatment", "", "split", "Lcom/box/android/domain/configuration/Split;", NativeAuthConstants.GrantType.ATTRIBUTES, "", "", "(Lcom/box/android/domain/configuration/Split;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ISplitConfiguration {
    Object getTreatment(Split split, Map<String, ? extends Object> map, Continuation<? super Boolean> continuation);

    void init(BoxUser boxUser);

    /* JADX INFO: compiled from: SplitConfiguration.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object getTreatment$default(ISplitConfiguration iSplitConfiguration, Split split, Map map, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTreatment");
        }
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return iSplitConfiguration.getTreatment(split, map, continuation);
    }
}
