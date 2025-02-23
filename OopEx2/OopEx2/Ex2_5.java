class Customer {
    private int id;
    private String name;
    private char gender;
    public Customer(){}
    public Customer(int id, String name, char gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }
}
class Account{
    private int id;
    private Customer customer;
    private double balance;
    public Account(){}
    public Account(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        
    }
    public Account(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }
    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String toString(){
        return customer.toString()+" balance=$"+balance;
    }
    public String getCustomerName(){
        return customer.getName();
    }
    public Account deposit(double amount){
        balance+=amount;
        return this;
    }
    public Account withdraw(double amount){
        if(balance>=amount){
            balance-=amount;
        } else System.out.println("amount withdraw exceeds the current balance!");
        return this;
    }
}
