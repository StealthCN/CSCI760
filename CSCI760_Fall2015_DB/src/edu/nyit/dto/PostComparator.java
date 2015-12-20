package edu.nyit.dto;

import java.util.Comparator;

public class PostComparator implements Comparator<Post>
{
	public int compare(Post o1, Post o2)
	{
		long P1Time = Long.parseLong(o1.getTime());
		long P2Time = Long.parseLong(o2.getTime());
		if (P1Time < P2Time) return 1;
		else return -1;
	}
}
