package org.example.models.bank;

public enum TypeCardBank {
    CARD_8293(BelarusBank.getInstance()),
    CARD_4356(BTBBank.getInstance()),
    CARD_6546(BelapromBank.getInstance());

    Bank bank;

    TypeCardBank(Bank bank) {
        this.bank=bank;
    }

    public static Bank getBankType(String idBank){
        TypeCardBank typeCardBank = TypeCardBank.valueOf("CARD_"+idBank);
        return typeCardBank.bank;
    }
}
