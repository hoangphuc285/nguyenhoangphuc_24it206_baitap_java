class MyLine {
    MyPoint begin, end;

    public MyLine() {
        begin = new MyPoint();
        end = new MyPoint();
    }

    public MyLine(MyPoint begin, MyPoint end) {
        this.begin = begin;
        this.end = end;
    }

    public MyPoint getBegin() {
        return begin;
    }

    public void setBegin(MyPoint begin) {
        this.begin = begin;
    }

    public MyPoint getEnd() {
        return end;
    }

    public void setEnd(MyPoint end) {
        this.end = end;
    }

    public void setBeginX(int x) {
        this.begin.setX(x);
    
    }
    public void setBeginY(int y) {
        this.begin.setY(y);
    
    }

    public void setEndX(int x) {
       
        this.end.setX(x);
    }
    public void setEndY(int y) {
       
        this.end.setY(y);
    }
    public int[] getBeginXY(){
        return new int[] {begin.getX(),begin.getY()};
    }
    public int[] setBeginXY(int x,int y){
        begin.setX(x);
        begin.setY(y);
         return new int[] {begin.getX(),begin.getY()};
    }
    public int[] getEndXY(){
         return new int[] {end.getX(),end.getY()};
    }
    public int[] setEndXY(int x,int y){
        end.setX(x);
        end.setY(y);
         return new int[] {end.getX(),end.getY()};
    }
    public double getLength(){
        return begin.distance(end);
    }
    public double getGradient(){
        int xDiff = end.getX() - begin.getX();
        int yDiff = end.getY() - begin.getY();
        return Math.atan2(yDiff, xDiff);
    }
    public String toString(){
        return "MyLine [begin=" + begin + ", end=" + end + "]";
    }

}
