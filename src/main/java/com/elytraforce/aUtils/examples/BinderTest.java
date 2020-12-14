package com.elytraforce.aUtils.examples;

import com.elytraforce.aUtils.spigot.ASpigotBinder;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class BinderTest extends ASpigotBinder {
    private final PluginTest plugin;

    public BinderTest(PluginTest plugin) {
        super(plugin);

        this.plugin = plugin;
    }

    @Override
    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    public void configureSpecific() {
        bind(PluginTest.class).toInstance(plugin);
    }
}
