package com.example.demo.statemachine;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Context {

    private Map<String, Object> parameterMap;

    public Context() {
        this.parameterMap = new HashMap<>();
    }

    public Object putParameter(String key, Object value) {
        return parameterMap.put(key, value);
    }

    public Object getParameter(String key) {
        return parameterMap.get(key);
    }

}
