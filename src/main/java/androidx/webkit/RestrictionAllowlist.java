package androidx.webkit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.chromium.support_lib_boundary.WebViewBuilderBoundaryInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class RestrictionAllowlist {
    private final List<ConfigTask> mConfigTasks;

    /* JADX INFO: Access modifiers changed from: private */
    interface ConfigTask {
        void configure(WebViewBuilderBoundaryInterface.Config config);
    }

    private RestrictionAllowlist(List<ConfigTask> list) {
        this.mConfigTasks = list;
    }

    void configure(WebViewBuilderBoundaryInterface.Config config) {
        Iterator<ConfigTask> it = this.mConfigTasks.iterator();
        while (it.hasNext()) {
            it.next().configure(config);
        }
    }

    public static final class Builder {
        private final List<ConfigTask> mConfigTasks = new ArrayList();
        private final List<String> mOriginPatterns;

        public Builder(Set<String> set) {
            this.mOriginPatterns = new ArrayList(set);
        }

        public Builder addJavaScriptInterface(final Object obj, final String str) {
            this.mConfigTasks.add(new ConfigTask() { // from class: androidx.webkit.RestrictionAllowlist$Builder$$ExternalSyntheticLambda0
                @Override // androidx.webkit.RestrictionAllowlist.ConfigTask
                public final void configure(WebViewBuilderBoundaryInterface.Config config) {
                    this.f$0.m11086xa22786c9(obj, str, config);
                }
            });
            return this;
        }

        /* JADX INFO: renamed from: lambda$addJavaScriptInterface$0$androidx-webkit-RestrictionAllowlist$Builder, reason: not valid java name */
        /* synthetic */ void m11086xa22786c9(Object obj, String str, WebViewBuilderBoundaryInterface.Config config) {
            config.addJavascriptInterface(obj, str, this.mOriginPatterns);
        }

        public RestrictionAllowlist build() {
            return new RestrictionAllowlist(this.mConfigTasks);
        }
    }
}
