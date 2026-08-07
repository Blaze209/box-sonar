package io.split.android.client.impressions;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class Impression {
    private final String _appliedRule;
    private final Map<String, Object> _attributes;
    private final String _bucketingKey;
    private final Long _changeNumber;
    private final String _key;
    private Long _previousTime;
    private final String _propertiesJson;
    private final String _split;
    private final long _time;
    private final String _treatment;

    public Impression(String key, String bucketingKey, String split, String treatment, long time, String appliedRule, Long changeNumber, Map<String, Object> attributes, String propertiesJson) {
        this._key = key;
        this._bucketingKey = bucketingKey;
        this._split = split;
        this._treatment = treatment;
        this._time = time;
        this._appliedRule = appliedRule;
        this._changeNumber = changeNumber;
        this._attributes = attributes;
        this._propertiesJson = propertiesJson;
    }

    public String key() {
        return this._key;
    }

    public String bucketingKey() {
        return this._bucketingKey;
    }

    public String split() {
        return this._split;
    }

    public String treatment() {
        return this._treatment;
    }

    public long time() {
        return this._time;
    }

    public String appliedRule() {
        return this._appliedRule;
    }

    public Long changeNumber() {
        return this._changeNumber;
    }

    public Map<String, Object> attributes() {
        return this._attributes;
    }

    public String properties() {
        return this._propertiesJson;
    }

    public Long previousTime() {
        return this._previousTime;
    }

    public Impression withPreviousTime(Long pt) {
        this._previousTime = pt;
        return this;
    }
}
