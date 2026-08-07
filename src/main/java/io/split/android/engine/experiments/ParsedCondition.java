package io.split.android.engine.experiments;

import io.split.android.client.dtos.ConditionType;
import io.split.android.client.dtos.Partition;
import io.split.android.engine.matchers.CombiningMatcher;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ParsedCondition {
    private final ConditionType _conditionType;
    private final String _label;
    private final CombiningMatcher _matcher;
    private final List<Partition> _partitions;

    public ParsedCondition(ConditionType conditionType, CombiningMatcher matcher, List<Partition> partitions, String label) {
        this._conditionType = conditionType;
        this._matcher = matcher;
        this._partitions = partitions;
        this._label = label;
    }

    public ConditionType conditionType() {
        return this._conditionType;
    }

    public CombiningMatcher matcher() {
        return this._matcher;
    }

    public List<Partition> partitions() {
        return this._partitions;
    }

    public String label() {
        return this._label;
    }

    public int hashCode() {
        int iHashCode = 527 + this._matcher.hashCode();
        int iHashCode2 = 17;
        for (Partition partition : this._partitions) {
            iHashCode2 = (((iHashCode2 * 31) + partition.treatment.hashCode()) * 31) + partition.size;
        }
        return (iHashCode * 31) + iHashCode2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParsedCondition)) {
            return false;
        }
        ParsedCondition parsedCondition = (ParsedCondition) obj;
        boolean zEquals = this._matcher.equals(parsedCondition._matcher);
        if (!zEquals) {
            return false;
        }
        if (this._partitions.size() != parsedCondition._partitions.size()) {
            return zEquals;
        }
        for (int i = 0; i < this._partitions.size(); i++) {
            Partition partition = this._partitions.get(i);
            Partition partition2 = parsedCondition._partitions.get(i);
            zEquals &= partition.size == partition2.size && partition.treatment.equals(partition2.treatment);
        }
        return zEquals;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._matcher);
        sb.append(" then split ");
        boolean z = true;
        for (Partition partition : this._partitions) {
            if (!z) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(partition.size);
            sb.append(AbstractJsonLexerKt.COLON);
            sb.append(partition.treatment);
            z = false;
        }
        return sb.toString();
    }
}
