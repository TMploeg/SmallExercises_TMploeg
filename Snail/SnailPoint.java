public record SnailPoint(int x, int y){
	
	public SnailPoint rotate(){
		return new SnailPoint(y() * -1, x());
	}
	
	public SnailPoint add(SnailPoint newPoint){
		return new SnailPoint(x() + newPoint.x(), y() + newPoint.y());
	}
	
	@Override
	public String toString(){
		return "(" + x() + ", " + y() + ")";
	}
}