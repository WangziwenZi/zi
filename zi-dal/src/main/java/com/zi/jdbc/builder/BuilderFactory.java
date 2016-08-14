package com.zi.jdbc.builder;

import com.sun.javafx.scene.layout.region.BackgroundImage;

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
