package com.toastturbomodule.TurboModules;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;

import java.util.HashMap;
import java.util.Map;

public class CustomPackages extends TurboReactPackage {

    /**
     * getModule() method that creates the native module object, when required.
     * */

    @Override
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        switch (name) {
            case CustomToastModule.NAME:
                return new CustomToastModule(reactContext);

            default:
                throw new IllegalArgumentException(
                        "In CustomToastPackage, could not find Native module for " + name);
        }
    }


    /**
     * ReactModuleInfoProvider() method which returns a list of all the native modules
     * the package can instantiate. We can add more modules by using reactModuleInfoMap.put(),
     * as in line 42(based on linting).
     * */

    @Override
    public ReactModuleInfoProvider getReactModuleInfoProvider() {

        final Map<String, ReactModuleInfo> reactModuleInfoMap = new HashMap<>();

        reactModuleInfoMap.put(CustomToastModule.NAME,
                new ReactModuleInfo(CustomToastModule.NAME,
                        "com.toastturbomodule.TurboModules.CustomToastPackage",
                        false,
                        false,
                        false,
                        false,
                        true));


        return new ReactModuleInfoProvider() {
            @Override
            public Map<String, ReactModuleInfo> getReactModuleInfos() {
                return reactModuleInfoMap;
            }
        };
    }
}
