package zipkin2.storage;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import zipkin2.Call;
import zipkin2.Component;
import zipkin2.internal.TracesAdapter;

/* JADX INFO: loaded from: classes6.dex */
public abstract class StorageComponent extends Component {
    public abstract SpanConsumer spanConsumer();

    public abstract SpanStore spanStore();

    public Traces traces() {
        return new TracesAdapter(spanStore());
    }

    public AutocompleteTags autocompleteTags() {
        return new AutocompleteTags() { // from class: zipkin2.storage.StorageComponent.1
            @Override // zipkin2.storage.AutocompleteTags
            public Call<List<String>> getKeys() {
                return Call.emptyList();
            }

            @Override // zipkin2.storage.AutocompleteTags
            public Call<List<String>> getValues(String str) {
                return Call.emptyList();
            }

            public String toString() {
                return "EmptyAutocompleteTags{}";
            }
        };
    }

    public ServiceAndSpanNames serviceAndSpanNames() {
        final SpanStore spanStore = spanStore();
        return new ServiceAndSpanNames() { // from class: zipkin2.storage.StorageComponent.2
            @Override // zipkin2.storage.ServiceAndSpanNames
            public Call<List<String>> getServiceNames() {
                return spanStore.getServiceNames();
            }

            @Override // zipkin2.storage.ServiceAndSpanNames
            public Call<List<String>> getRemoteServiceNames(String str) {
                return Call.emptyList();
            }

            @Override // zipkin2.storage.ServiceAndSpanNames
            public Call<List<String>> getSpanNames(String str) {
                return spanStore.getSpanNames(str);
            }

            public String toString() {
                return "ServiceAndSpanNames{" + spanStore + "}";
            }
        };
    }

    public boolean isOverCapacity(Throwable th) {
        return th instanceof RejectedExecutionException;
    }

    public static abstract class Builder {
        public abstract StorageComponent build();

        public abstract Builder searchEnabled(boolean z);

        public abstract Builder strictTraceId(boolean z);

        public Builder autocompleteKeys(List<String> list) {
            Logger.getLogger(getClass().getName()).info("autocompleteKeys not yet supported");
            return this;
        }

        public Builder autocompleteTtl(int i) {
            Logger.getLogger(getClass().getName()).info("autocompleteTtl not yet supported");
            return this;
        }

        public Builder autocompleteCardinality(int i) {
            Logger.getLogger(getClass().getName()).info("autocompleteCardinality not yet supported");
            return this;
        }
    }
}
