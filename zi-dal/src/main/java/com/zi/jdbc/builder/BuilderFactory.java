package com.zi.jdbc.builder;

/**
 * Created by Administrator on 2016/8/13.
 */
public class BuilderFactory {
    private BuilderFactory() {
    }

    public CreateBuilder createBuilder() {
        return new CreateBuilder();
    }
}
