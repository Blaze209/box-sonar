package com.pspdfkit.document.providers;

import com.box.boxandroidlibv2private.model.BoxTask;
import io.reactivex.rxjava3.core.Flowable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/document/providers/ProgressDataProvider;", "", "observeProgress", "Lio/reactivex/rxjava3/core/Flowable;", "", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ProgressDataProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/pspdfkit/document/providers/ProgressDataProvider$Companion;", "", "<init>", "()V", BoxTask.REQUEST_STATUS_COMPLETE, "Lio/reactivex/rxjava3/core/Flowable;", "", "getCOMPLETE", "()Lio/reactivex/rxjava3/core/Flowable;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Flowable<Double> COMPLETE;

        static {
            Flowable<Double> flowableJust = Flowable.just(Double.valueOf(1.0d));
            flowableJust.getClass();
            COMPLETE = flowableJust;
        }

        private Companion() {
        }

        public final Flowable<Double> getCOMPLETE() {
            return COMPLETE;
        }
    }

    Flowable<Double> observeProgress();
}
