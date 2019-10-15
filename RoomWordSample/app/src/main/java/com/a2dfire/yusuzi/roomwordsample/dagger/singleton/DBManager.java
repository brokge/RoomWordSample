package com.a2dfire.yusuzi.roomwordsample.dagger.singleton;

public class DBManager {

    private static DBManager instance;

    private DBManager(){

    }

    public static DBManager getInstance(){
        if(instance==null){
            synchronized (DBManager.class){
                if(instance==null){
                    instance=new DBManager();
                }
            }
        }
        return instance;
    }
}
