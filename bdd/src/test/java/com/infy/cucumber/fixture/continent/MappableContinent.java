package com.infy.cucumber.fixture.continent;

import java.util.HashMap;
import java.util.Map;

public abstract class MappableContinent<T> {

    private static final String DEFAULT_KEY = "DEFAULT";
    private Map<String, T> map = new HashMap<>();

    abstract T generate(String qualifier, String... extraParam);

    public T get(String qualifier) {
        if (null == qualifier)
            qualifier = DEFAULT_KEY;
        return map.get(qualifier);
    }

    public T get() {
        return get(DEFAULT_KEY);
    }

    public T getOrGenerate(String qualifier, String... extraParam) {
        if (null == qualifier)
            qualifier = DEFAULT_KEY;

        if (null != map.get(qualifier))
            return map.get(qualifier);
        else
            return generate(qualifier, extraParam);
    }

    public T getOrGenerate(String qualifier) {
        return getOrGenerate(qualifier,null);
    }
}
