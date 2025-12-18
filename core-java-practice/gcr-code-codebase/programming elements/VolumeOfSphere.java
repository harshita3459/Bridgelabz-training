package programming_elements;

public class VolumeOfSphere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radius = 6378;
		double volume = (4/3)*Math.PI*Math.pow(radius, 3);
		double miles = volume*1.6;
		System.out.println("The Volume of earth in cubic Kilometers is "+volume+" and cubic miles is "+miles);
	}

}
