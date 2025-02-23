class Author{
    private String name,email;
    private char gender;
    public Author(){}
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }
    public String toString(){
        return "Author[name="+name+",email="+email+",gender="+gender+"]";
    }
}
class Book{
    private String name;
    private double price;
    private Author[] authors;
    private int qty=0;
    public Book(){}
    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.price = price;
        this.authors = authors;
        
    }
    public Book(String name,Author[] authors, double price,  int qty) {
        this.name = name;
        this.price = price;
        this.authors = authors;
        this.qty = qty;
    }
    public String getName() {
        return name;
    }
    public Author[] getAuthors(){
        return authors;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public String toString(){
        return "Book[name="+name+"authors={"+getAuthorNames()+"},price="+price+",qty="+qty+"]";
    }
    public String getAuthorNames(){
        String s="";
        for(Author x:authors){
            s+=x.toString();
            s+=",";
        }
        return s;
    }
}
public class Ex2_2 {  
   public static void main(String[] args) {
    // Declare and allocate an array of Authors
    Author[] authors = new Author[2];
    authors[0] = new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
    authors[1] = new Author("Paul Tan", "Paul@nowhere.com", 'm');

    // Declare and allocate a Book instance
    Book javaDummy = new Book("Java for Dummy", authors, 19.99, 99);
    System.out.println(javaDummy);  // toString()
    }
}