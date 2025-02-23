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
    private Author author;
    private int qty=0;
    public Book(){}
    public Book(String name, Author author, double price) {
        this.name = name;
        this.price = price;
        this.author = author;
        
    }
    public Book(String name,Author author, double price,  int qty) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.qty = qty;
    }
    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.price = price;
        this.author = author;
        
    }
    public Book(String name,Author[] authors, double price,  int qty) {
        this.name = name;
        this.price = price;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public String toString(){
        return "Book["+author.toString()+",price="+price+",qty="+qty+"]";
    }
}
public class Ex2_1 {  
   public static void main(String[] args) {
    // Construct an author instance
    Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
    System.out.println(ahTeck);  // Author's toString()

    Book dummyBook = new Book("Java for dummy", ahTeck, 19.95, 99);  // Test Book's Constructor
    System.out.println(dummyBook);  // Test Book's toString()

    // Test Getters and Setters
    dummyBook.setPrice(29.95);
    dummyBook.setQty(28);
    System.out.println("name is: " + dummyBook.getName());
    System.out.println("price is: " + dummyBook.getPrice());
    System.out.println("qty is: " + dummyBook.getQty());
    System.out.println("Author is: " + dummyBook.getAuthor());  // Author's toString()
    System.out.println("Author's name is: " + dummyBook.getAuthor().getName());
    System.out.println("Author's email is: " + dummyBook.getAuthor().getEmail());

    // Use an anonymous instance of Author to construct a Book instance
    Book anotherBook = new Book("more Java", 
        new Author("Paul Tan", "paul@somewhere.com", 'm'), 29.95);
    System.out.println(anotherBook);  // toString()
    }
}