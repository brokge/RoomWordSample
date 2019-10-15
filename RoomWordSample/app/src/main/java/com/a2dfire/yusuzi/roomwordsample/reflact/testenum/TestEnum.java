package com.a2dfire.yusuzi.roomwordsample.reflact.testenum;

public class   TestEnum {
    private State state=State.DRIVING;
    public State getState(){
        return state;
    }
    public void setState(State state){
        this.state=state;
    }
}
