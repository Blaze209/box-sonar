package io.noties.markwon;

import android.content.Context;
import android.widget.TextView;
import io.noties.markwon.core.MarkwonTheme;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes4.dex */
class MarkwonBuilderImpl implements Markwon.Builder {
    private final Context context;
    private Markwon.TextSetter textSetter;
    private final List<MarkwonPlugin> plugins = new ArrayList(3);
    private TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
    private boolean fallbackToRawInputWhenEmpty = true;

    MarkwonBuilderImpl(Context context) {
        this.context = context;
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon.Builder bufferType(TextView.BufferType bufferType) {
        this.bufferType = bufferType;
        return this;
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon.Builder textSetter(Markwon.TextSetter textSetter) {
        this.textSetter = textSetter;
        return this;
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon.Builder usePlugin(MarkwonPlugin markwonPlugin) {
        this.plugins.add(markwonPlugin);
        return this;
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon.Builder usePlugins(Iterable<? extends MarkwonPlugin> iterable) {
        for (MarkwonPlugin markwonPlugin : iterable) {
            markwonPlugin.getClass();
            this.plugins.add(markwonPlugin);
        }
        return this;
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon.Builder fallbackToRawInputWhenEmpty(boolean z) {
        this.fallbackToRawInputWhenEmpty = z;
        return this;
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon build() {
        if (this.plugins.isEmpty()) {
            throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
        }
        List<MarkwonPlugin> listPreparePlugins = preparePlugins(this.plugins);
        Parser.Builder builder = new Parser.Builder();
        MarkwonTheme.Builder builderBuilderWithDefaults = MarkwonTheme.builderWithDefaults(this.context);
        MarkwonConfiguration.Builder builder2 = new MarkwonConfiguration.Builder();
        MarkwonVisitorImpl.BuilderImpl builderImpl = new MarkwonVisitorImpl.BuilderImpl();
        MarkwonSpansFactoryImpl.BuilderImpl builderImpl2 = new MarkwonSpansFactoryImpl.BuilderImpl();
        for (MarkwonPlugin markwonPlugin : listPreparePlugins) {
            markwonPlugin.configureParser(builder);
            markwonPlugin.configureTheme(builderBuilderWithDefaults);
            markwonPlugin.configureConfiguration(builder2);
            markwonPlugin.configureVisitor(builderImpl);
            markwonPlugin.configureSpansFactory(builderImpl2);
        }
        MarkwonConfiguration markwonConfigurationBuild = builder2.build(builderBuilderWithDefaults.build(), builderImpl2.build());
        return new MarkwonImpl(this.bufferType, this.textSetter, builder.build(), MarkwonVisitorFactory.create(builderImpl, markwonConfigurationBuild), markwonConfigurationBuild, Collections.unmodifiableList(listPreparePlugins), this.fallbackToRawInputWhenEmpty);
    }

    private static List<MarkwonPlugin> preparePlugins(List<MarkwonPlugin> list) {
        return new RegistryImpl(list).process();
    }
}
