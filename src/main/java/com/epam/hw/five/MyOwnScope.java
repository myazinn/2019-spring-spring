package com.epam.hw.five;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyOwnScope implements Scope {

    public static final int SCOPE_REFRESH_RATE = 5;
    private static int counter = 0;

    private Map<String, Object> scopedObjects
            = Collections.synchronizedMap(new HashMap<>());
    private Map<String, Runnable> destructionCallbacks
            = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        if (++counter > SCOPE_REFRESH_RATE) {
            counter = 0;
            scopedObjects.clear();
        }

        if(!scopedObjects.containsKey(name)) {
            scopedObjects.put(name, objectFactory.getObject());
        }

        return scopedObjects.get(name);
    }

    @Override
    public Object remove(String name) {
        destructionCallbacks.remove(name);
        return scopedObjects.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        destructionCallbacks.put(name, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
