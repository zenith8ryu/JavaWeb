package entity;

public class Goods {
    private int gid; //PK of the table "Goods"
    private String gname;
    private int gnum;
    private String made;
    private double price;
    private int balance;

    public Goods(int gid, String gname, int gnum, String made, double price, int balance) {
        this.gid = gid;
        this.gname = gname;
        this.gnum = gnum;
        this.made = made;
        this.price = price;
        this.balance = balance;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGnum() {
        return gnum;
    }

    public void setGnum(int gnum) {
        this.gnum = gnum;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
