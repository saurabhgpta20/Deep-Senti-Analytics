package com.saurabh.onlinetranslation;

import java.io.IOException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class SentimentVisualize extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String inputtweet;
	String inputtweet1;
	private float positive;
	private float negative;
	private float neutral;	
	private String tweetsentiment;
	private Double senti;
	private ArrayList<String> top10posTweets = new ArrayList<String>();
	private ArrayList<String> top10negTweets = new ArrayList<String>();
	private ArrayList<String> top10neuTweets = new ArrayList<String>();

	/**
	 * @throws IOException ****************************************************************/
	public String sentimentAnalysis() throws IOException{
		System.out.println("Input Tweet: " + inputtweet);
		Pythontest objVisualize = new Pythontest();
		tweetsentiment = objVisualize.Pythontest1(inputtweet);
		setNegative(objVisualize.negative1);
		setPositive(objVisualize.positive1);
		setNeutral(objVisualize.neutral1);
		setTop10negTweets(objVisualize.top10negTweets);
		setTop10posTweets(objVisualize.top10posTweets);
		//setTop10neuTweets(objVisualize.top10neuTweets);
		senti = Double.parseDouble(tweetsentiment);
			if(senti < 0.5 && senti >= 0.0)
				tweetsentiment = "Negative";
			else if(senti > 0.5 && senti < 1.0)
				tweetsentiment="Positive";
			else
				tweetsentiment="Neutral";
			
		inputtweet1 = getInputtweet();
		//System.out.println("The value of input tweet1: "+inputtweet1);
		SentimentVisualize1 sv1obj = new SentimentVisualize1();
		sv1obj.setInputtweet(inputtweet1);
		return "SUCCESS";
	}
	
	/******************************************************************/
	

	public String getTweetsentiment() {
		return tweetsentiment;
	}

	public void setTweetsentiment(String tweetsentiment) {
		this.tweetsentiment = tweetsentiment;
	}
	public String getInputtweet() {
		return inputtweet;
	}

	public void setInputtweet(String inputtweet) {
		this.inputtweet = inputtweet;
	}
	public float getPositive() {
		return positive;
	}

	public void setPositive(float positive) {
		this.positive = positive;
	}

	public float getNegative() {
		return negative;
	}

	public void setNegative(float negative) {
		this.negative = negative;
	}

	public float getNeutral() {
		return neutral;
	}

	public void setNeutral(float neutral) {
		this.neutral = neutral;
	}

	public ArrayList<String> getTop10posTweets() {
		return top10posTweets;
	}

	public void setTop10posTweets(ArrayList<String> top10posTweets) {
		this.top10posTweets = top10posTweets;
	}

	public ArrayList<String> getTop10negTweets() {
		return top10negTweets;
	}

	public void setTop10negTweets(ArrayList<String> top10negTweets) {
		this.top10negTweets = top10negTweets;
	}

	public ArrayList<String> getTop10neuTweets() {
		return top10neuTweets;
	}

	public void setTop10neuTweets(ArrayList<String> top10neuTweets) {
		this.top10neuTweets = top10neuTweets;
	}

}
