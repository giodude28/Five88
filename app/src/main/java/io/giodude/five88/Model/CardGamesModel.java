package io.giodude.five88.Model;

public class CardGamesModel {

    String cname;
    Integer cimange;
    String cdesc;

    public CardGamesModel(String cname, Integer cimange, String cdesc) {
        this.cname = cname;
        this.cimange = cimange;
        this.cdesc = cdesc;
    }

    public String getCdesc() {
        return cdesc;
    }

    public String getCname() {
        return cname;
    }

    public Integer getCimange() {
        return cimange;
    }
}
