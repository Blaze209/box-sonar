package com.box.android.preview.previewtype.document;

import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.boxai.AiCitationModel;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.document.search.SearchResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CitationHighlightReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/box/android/preview/previewtype/document/CitationHighlightReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$State;", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/document/CitationHighlightEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/document/CitationHighlightEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/previewtype/document/CitationHighlightEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CitationHighlightReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CitationHighlightEnvironment environment;

    public CitationHighlightReducer(CitationHighlightEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce(new Function2() { // from class: com.box.android.preview.previewtype.document.CitationHighlightReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CitationHighlightReducer.build$lambda$0(this.f$0, (CitationHighlightReducer.State) obj, (CitationHighlightReducer.Action) obj2);
            }
        });
    }

    public final CitationHighlightEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CitationHighlightReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$State;", "", "citationText", "Lcom/pspdfkit/document/search/SearchResult;", "<init>", "(Lcom/pspdfkit/document/search/SearchResult;)V", "getCitationText", "()Lcom/pspdfkit/document/search/SearchResult;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final SearchResult citationText;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, SearchResult searchResult, int i, Object obj) {
            if ((i & 1) != 0) {
                searchResult = state.citationText;
            }
            return state.copy(searchResult);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SearchResult getCitationText() {
            return this.citationText;
        }

        public final State copy(SearchResult citationText) {
            return new State(citationText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof State) && Intrinsics.areEqual(this.citationText, ((State) other).citationText);
        }

        public int hashCode() {
            SearchResult searchResult = this.citationText;
            if (searchResult == null) {
                return 0;
            }
            return searchResult.hashCode();
        }

        public String toString() {
            return "State(citationText=" + this.citationText + ")";
        }

        public State(SearchResult searchResult) {
            this.citationText = searchResult;
        }

        public /* synthetic */ State(SearchResult searchResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : searchResult);
        }

        public final SearchResult getCitationText() {
            return this.citationText;
        }
    }

    /* JADX INFO: compiled from: CitationHighlightReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action;", "", "<init>", "()V", "HighlightText", "TextFound", "Close", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action$Close;", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action$HighlightText;", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action$TextFound;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CitationHighlightReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action$HighlightText;", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action;", "citation", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "<init>", "(Lcom/box/android/domain/models/boxai/AiCitationModel;)V", "getCitation", "()Lcom/box/android/domain/models/boxai/AiCitationModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HighlightText extends Action {
            public static final int $stable = 8;
            private final AiCitationModel citation;

            public static /* synthetic */ HighlightText copy$default(HighlightText highlightText, AiCitationModel aiCitationModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    aiCitationModel = highlightText.citation;
                }
                return highlightText.copy(aiCitationModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AiCitationModel getCitation() {
                return this.citation;
            }

            public final HighlightText copy(AiCitationModel citation) {
                Intrinsics.checkNotNullParameter(citation, "citation");
                return new HighlightText(citation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof HighlightText) && Intrinsics.areEqual(this.citation, ((HighlightText) other).citation);
            }

            public int hashCode() {
                return this.citation.hashCode();
            }

            public String toString() {
                return "HighlightText(citation=" + this.citation + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HighlightText(AiCitationModel citation) {
                super(null);
                Intrinsics.checkNotNullParameter(citation, "citation");
                this.citation = citation;
            }

            public final AiCitationModel getCitation() {
                return this.citation;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CitationHighlightReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action$TextFound;", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/pspdfkit/document/search/SearchResult;", "<init>", "(Lcom/pspdfkit/document/search/SearchResult;)V", "getResult", "()Lcom/pspdfkit/document/search/SearchResult;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TextFound extends Action {
            public static final int $stable = 8;
            private final SearchResult result;

            public static /* synthetic */ TextFound copy$default(TextFound textFound, SearchResult searchResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchResult = textFound.result;
                }
                return textFound.copy(searchResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final SearchResult getResult() {
                return this.result;
            }

            public final TextFound copy(SearchResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new TextFound(result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TextFound) && Intrinsics.areEqual(this.result, ((TextFound) other).result);
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "TextFound(result=" + this.result + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TextFound(SearchResult result) {
                super(null);
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public final SearchResult getResult() {
                return this.result;
            }
        }

        /* JADX INFO: compiled from: CitationHighlightReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action$Close;", "Lcom/box/android/preview/previewtype/document/CitationHighlightReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Close extends Action {
            public static final int $stable = 0;
            public static final Close INSTANCE = new Close();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Close)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1489510435;
            }

            public String toString() {
                return "Close";
            }

            private Close() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(CitationHighlightReducer citationHighlightReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.HighlightText) {
            return new ReducerResult(state, EffectKt.toEffect(FlowKt.flow(new CitationHighlightReducer$build$1$1(citationHighlightReducer, action, null))));
        }
        if (action instanceof Action.TextFound) {
            return new ReducerResult(state.copy(((Action.TextFound) action).getResult()), null, 2, null);
        }
        if (!(action instanceof Action.Close)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult(state.copy(null), null, 2, null);
    }
}
