package com.external;
public class ScoreCompImpl implements ScoreComp {
    @Override
    public String findScore(int matchId){
        if(matchId==345)
            return "TestMatch:345/6";
        else if(matchId==567)
            return "oneday: 234/9";
        else 
            return "wrong match id";
    }
}
