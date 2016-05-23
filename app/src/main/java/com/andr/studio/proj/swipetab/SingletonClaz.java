package com.andr.studio.proj.swipetab;

/**
 * Created by CIPL310 on 9/16/2015.
 */
public class SingletonClaz {
    public String JSONResponse=null;
    public String JSONResponse2=null;

    private static SingletonClaz ourInstance = new SingletonClaz();

    public static SingletonClaz getInstance() {
        return ourInstance;
    }

    private SingletonClaz() {

    }
}
