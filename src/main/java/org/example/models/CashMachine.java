package org.example.models;

public class CashMachine {
    private static final int START_SUM=1_000_000;
    private static final CashMachine instance=new CashMachine(false, START_SUM);
    private boolean isCard;
    private int moneyInCahMachine;

    private CashMachine(boolean isCard, int moneyInCahMachine) {
        this.isCard = isCard;
        this.moneyInCahMachine = moneyInCahMachine;
    }

    public static CashMachine getInstance(){
        return instance;
    }

    public boolean isCard() {
        return isCard;
    }

    public void setCard(boolean isCard) {
        this.isCard = isCard;
    }

    public int getMoneyInCashMachine() {
        return moneyInCahMachine;
    }

    public void setMoneyInCashMachine(int moneyInBankomat) {
        this.moneyInCahMachine = moneyInBankomat;
    }
}
