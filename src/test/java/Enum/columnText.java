package Enum;

public enum columnText {
    COMPANY(1),
    CONTACT(2),
    COUNTRY(3);
    public int col;

    columnText(int col) {
        this.col = col;
    }

}