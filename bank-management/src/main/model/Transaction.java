package src.main.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction implements Comparable<Transaction>{

    public enum Type {
        WITHDRAW, DEPOSIT
    }

    private Type type;
    private long timestamp;
    private String id;
    private double amount;


    public Transaction(Type type, long timestamp, String id, double amount) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id");
        }
        if (amount < 0){
            throw new IllegalArgumentException("Amount can not be negative!");
        }
        this.type = type;
        this.timestamp = timestamp;
        this.id = id;
        this.amount = amount;
    }

    public Transaction(Transaction source) {
        
        this.type = source.type;
        this.timestamp = source.timestamp;
        this.id = source.id;
        this.amount = source.amount;
    }


    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid Id+");
        }
        this.id = id;
    }

    public double getAmount() {
        if (amount < 0){
            throw new IllegalArgumentException("Amount can not be negative!");
        }
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String returnDate(){

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date dateInMiliSecond = new Date(this.timestamp * 1000);
        return df.format(dateInMiliSecond);
        
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return this.type.equals(transaction.type) && 
                this.timestamp == transaction.timestamp && 
                this.id.equals(transaction.id) && 
                this.amount == transaction.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, timestamp, id, amount);
    }

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.timestamp, o.timestamp);
    }

    @Override
    public String toString() {
        return (this.type) + "    " +
            "\t" + this.returnDate() + "" +
            "\t" + this.id + "" +
            "\t$" + this.amount + "";
    }


}
