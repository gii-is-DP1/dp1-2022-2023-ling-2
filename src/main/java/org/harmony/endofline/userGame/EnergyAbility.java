package org.harmony.endofline.userGame;

public enum EnergyAbility {
    NONE, BACK_IN_TIME, BOOST, BREAK;

    public EnergyAbility parse(String text){
        switch (text){
            case "Back in time": return BACK_IN_TIME;
            case "Boost": return BOOST;
            case "Break": return BREAK;
            default: return NONE;
        }
    }

}
