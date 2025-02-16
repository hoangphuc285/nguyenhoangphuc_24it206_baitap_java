class Account{
    private String name,id;
    private int balance=0;
    public Account() {}

    public Account( String id, String name) {
        this.name = name;
        this.id = id;
    }
    public Account( String id,String name, int balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount){
        balance+=amount;
        return balance;
    }
    public int debit(int amount){
        if(amount <=balance) balance-=amount;
        else System.out.println("Amount exceeded balance");
        return balance;
    }
    public int transferTo(Account another,int amount){
        if(amount <=balance) {
            another.credit(amount);
            balance-=amount;
        }
        else System.out.println("Amount exceeded balance");
        return balance;
    }
    @Override
    public String toString() {
        return "Account[id="+id+",name="+name+",balance="+balance+"]";
    }
}
public class Ex1_6 {
   public static void main(String[] args) {
      // Test constructor and toString()
      Account a1 = new Account("A101", "Tan Ah Teck", 88);
      System.out.println(a1);  // toString();
      Account a2 = new Account("A102", "Kumar"); // default balance
      System.out.println(a2);

      // Test Getters
      System.out.println("ID: " + a1.getID());
      System.out.println("Name: " + a1.getName());
      System.out.println("Balance: " + a1.getBalance());

      // Test credit() and debit()
      a1.credit(100);
      System.out.println(a1);
      a1.debit(50);
      System.out.println(a1);
      a1.debit(500);  // debit() error
      System.out.println(a1);

      // Test transfer()
      a1.transferTo(a2, 100);  // toString()
      System.out.println(a1);
      System.out.println(a2);
   }
}