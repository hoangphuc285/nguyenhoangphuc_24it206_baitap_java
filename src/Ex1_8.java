class Time{
    private int hour,minute,second;
    public Time() {}

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() {
        String hour,minute,second;
        if(this.hour<10) hour="0"+ this.hour+"";
        else hour=this.hour+"";
        if(this.minute<10) minute="0"+  this.minute+"";
        else minute=this.minute+"";
        if(this.second<10) second="0"+  this.second+"";
        else second= this.second+"";
        return hour+":"+minute+":"+second;
    }
    public Time nextSecond(){
        setSecond(second+1);
        if(second>=60){
            setSecond(0);
            setMinute(minute+1);
            if(minute>=60){
                setMinute(0);
                setHour(hour+1);
                if(hour>=24){
                    setHour(0);
                }
            }
        }
        return this;
    }
    public Time previousSecond(){
        setSecond(second-1);
        if(second<0) {
            setSecond(59);
            setMinute(minute-1);
            if(minute<0){
                setMinute(59);
                setHour(hour-1);
                if(hour<0){
                    setHour(23);
                }
            }
        }
        return this;
    }
}
public class Ex1_8 {
   public static void main(String[] args) {
      // Test constructors and toString()
      Time t1 = new Time(1, 2, 3);
      System.out.println(t1);  // toString()

      // Test Setters and Getters
      t1.setHour(4);
      t1.setMinute(5);
      t1.setSecond(6);
      System.out.println(t1);  // toString()
      System.out.println("Hour: " + t1.getHour());
      System.out.println("Minute: " + t1.getMinute());
      System.out.println("Second: " + t1.getSecond());

      // Test setTime()
      t1.setTime(23, 59, 58);
      System.out.println(t1);  // toString()

      // Test nextSecond();
      System.out.println(t1.nextSecond());
      System.out.println(t1.nextSecond().nextSecond());

      // Test previousSecond()
      System.out.println(t1.previousSecond());
      System.out.println(t1.previousSecond().previousSecond());
   }
}