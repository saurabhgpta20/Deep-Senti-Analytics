package com.saurabh.onlinetranslation;


import java.util.Comparator;

public class TweetList{
	private String cTweet;
	private Double cScore;


	public TweetList(String cTweet, Double cScore) {
		this.cTweet = cTweet;
		this.cScore = cScore;
	}

	public String getcTweet() {
		return cTweet;
	}



	public void setcTweet(String cTweet) {
		this.cTweet = cTweet;
	}



	public Double getcScore() {
		return cScore;
	}



	public void setcScore(Double cScore) {
		this.cScore = cScore;
	}
 
	
	
	
	@Override
    public String toString() {
        return cTweet;
    }

	 public static Comparator<TweetList> StuNameComparator = new Comparator<TweetList>() {

			public int compare(TweetList s1, TweetList s2) {
			   int sc1 = (int) (s1.getcScore()*100);
			   int sc2 = (int) (s2.getcScore()*100);

			   //ascending order
			   return sc2-sc1;

			   //descending order
			   //return StudentName2.compareTo(StudentName1);
		    }};
		    
		    public static Comparator<TweetList> StuNameComparator1 = new Comparator<TweetList>() {

				public int compare(TweetList s1, TweetList s2) {
				   int sc1 = (int) (s1.getcScore()*100);
				   int sc2 = (int) (s2.getcScore()*100);

				   //ascending order
				   return sc1-sc2;

				   //descending order
				   //return StudentName2.compareTo(StudentName1);
			    }};
	

}