package com.cloudshaala.utils;

import java.util.Random;

public class IDGenerator {
public static String getNewId(String prefix)
{
	
	long currentTime=System.currentTimeMillis();
	Random random=new Random(currentTime);
	int next=random.nextInt();
	
	String id="";
	switch (prefix) {
	case "pwd":
		id=currentTime%1000000+"";
		break;

	case "cuid":
		id=next%10000+currentTime+"";		
		break;
		
	case "t":
	case "s":
	case "p":
	case "i":
		id=prefix+next%10000+currentTime;
		break;
		
	default:
		break;
	}
	
	
	return id;
}
}
