class Rectangle{
    private float length=1.0f;
    private float width=1.0f;
    public Rectangle(){}
    public Rectangle(float length, float width){
        this.length=length;
        this.width=width;
    }
    public float getLength(){
        return length;
    }
    public void setLength(float length){
        this.length=length;
    }
    public float getWidth(){
        return width;
    }
    public void setWidth(float width){
        this.width=width;
    }
    public double getArea(){
        return length*width;
    }
    public double getPerimeter(){
        return (length+width)*2;
    }
    public String toString(){
        return "Rectangle[length="+length+",width="+width+"]";
    }
    
}
public class Ex1_3 {
   public static void main(String[] args) {
      // Test constructors and toString()
      // You need to append a 'f' or 'F' to a float literal
      Rectangle r1 = new Rectangle(1.2f, 3.4f);
      System.out.println(r1);  // toString()
      Rectangle r2 = new Rectangle();  // default constructor
      System.out.println(r2);

      // Test setters and getters
      r1.setLength(5.6f);
      r1.setWidth(7.8f);
      System.out.println(r1);  // toString()
      System.out.println("length is: " + r1.getLength());
      System.out.println("width is: " + r1.getWidth());

      // Test getArea() and getPerimeter()
      System.out.printf("area is: %.2f%n", r1.getArea());
      System.out.printf("perimeter is: %.2f%n", r1.getPerimeter());
   }
}