package gamingappflow.dao;

import java.util.Random;

public class RandomNumberGenerator {
	public  int[] generator()
	{
		int[] arr=new int[3];
		Random random=new Random();
		for (int i = 0; i <= 2; i++) {
			arr[i]=random.nextInt(10);
		}
		return arr;
	}
}
