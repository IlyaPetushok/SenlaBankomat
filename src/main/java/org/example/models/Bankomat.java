package org.example.models;

public class Bankomat {
    private static final int BEGAN_SUM_BANKOMAT=1_000_000;
    private static final Bankomat instance=new Bankomat(false, BEGAN_SUM_BANKOMAT);
    private boolean isCard;
    private int moneyInBankomat;

    private Bankomat(boolean isCard, int moneyInBankomat) {
        this.isCard = isCard;
        this.moneyInBankomat = moneyInBankomat;
    }

    public static Bankomat getInstance(){
        return instance;
    }

    public boolean isCard() {
        return isCard;
    }

    public void setCard(boolean card) {
        isCard = card;
    }

    public int getMoneyInBankomat() {
        return moneyInBankomat;
    }

    public void setMoneyInBankomat(int moneyInBankomat) {
        this.moneyInBankomat = moneyInBankomat;
    }
}
