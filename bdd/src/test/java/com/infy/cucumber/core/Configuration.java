package com.infy.cucumber.core;

import com.google.common.base.Suppliers;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigResolveOptions;

import java.util.function.Supplier;

public class Configuration {

    public static Supplier<Config> conf = Suppliers.memoize(() ->
       ConfigFactory.systemProperties()
                    .withFallback(ConfigFactory.parseResources("defaults.conf"))
                    .resolve(ConfigResolveOptions.noSystem())
    );

    public static String getConfig(String configName) {
        return conf.get().getString(configName);
    }
}
