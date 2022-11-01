package JavaUtility;

import java.util.Random;

public class Randomnum 
{
public static int generateRandomenum()
{
	Random ran=new Random();
	int ranNum=ran.nextInt(2000);
	return ranNum;
}
}
