package com.saurabh.onlinetranslation;

import java.io.IOException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class SentimentVisualize1 extends ActionSupport{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



		String inputtweet;
		private String inputtweet1;
		private float positive1;
		private float negative1;
		private float neutral1;	
		private String tweetsentiment1;
		private Double senti1;
		private ArrayList<String> top10posTweets1 = new ArrayList<String>();
		private ArrayList<String> top10negTweets1 = new ArrayList<String>();
		private ArrayList<String> top10neuTweets1 = new ArrayList<String>();

		/**
		 * @throws IOException ****************************************************************/
		public String sentimentAnalysis1() throws IOException{
			SentimentVisualize svobj = new SentimentVisualize();
			SentimentVisualize1 someobj = new SentimentVisualize1();
//			setInputtweet(svobj.inputtweet1);
			System.out.println("value of svjobj: " + getInputtweet1() );
//			System.out.println("Input Tweet: " + getInputtweet());
//			System.out.println("Value from the jsp: " + inputtweet);
//			System.out.println("Value from object: " + someobj.getInputtweet());
//			System.out.println("Value from object: " + someobj.inputtweet);
			Pythontest1 objVisualize1 = new Pythontest1();
			tweetsentiment1 = objVisualize1.Pythontest11(getInputtweet1());
			setNegative1(objVisualize1.negative1);
			setPositive1(objVisualize1.positive1);
			setNeutral1(objVisualize1.neutral1);
			setTop10negTweets1(objVisualize1.top10negTweets);
			setTop10posTweets1(objVisualize1.top10posTweets);
			//setTop10neuTweets(objVisualize.top10neuTweets);
			senti1 = Double.parseDouble(tweetsentiment1);
				if(senti1 < 0.5 && senti1 >= 0.0)
					tweetsentiment1 = "Negative";
				else if(senti1 > 0.5 && senti1 < 1.0)
					tweetsentiment1="Positive";
				else
					tweetsentiment1="Neutral";
			return "SUCCESS";
		}

		public String getInputtweet1() {
			return inputtweet1;
		}


		public void setInputtweet1(String inputtweet1) {
			this.inputtweet1 = inputtweet1;
		}

		public String getInputtweet() {
			return inputtweet;
		}


		public void setInputtweet(String inputtweet) {
			this.inputtweet = inputtweet;
		}

		public String getTweetsentiment1() {
			return tweetsentiment1;
		}

		public void setTweetsentiment1(String tweetsentiment1) {
			this.tweetsentiment1 = tweetsentiment1;
		}

		public float getPositive1() {
			return positive1;
		}

		public void setPositive1(float positive1) {
			this.positive1 = positive1;
		}

		public float getNegative1() {
			return negative1;
		}

		public void setNegative1(float negative1) {
			this.negative1 = negative1;
		}

		public float getNeutral1() {
			return neutral1;
		}

		public void setNeutral1(float neutral1) {
			this.neutral1 = neutral1;
		}

		public ArrayList<String> getTop10posTweets1() {
			return top10posTweets1;
		}

		public void setTop10posTweets1(ArrayList<String> top10posTweets1) {
			this.top10posTweets1 = top10posTweets1;
		}

		public ArrayList<String> getTop10negTweets1() {
			return top10negTweets1;
		}

		public void setTop10negTweets1(ArrayList<String> top10negTweets1) {
			this.top10negTweets1 = top10negTweets1;
		}

		public ArrayList<String> getTop10neuTweets1() {
			return top10neuTweets1;
		}

		public void setTop10neuTweets1(ArrayList<String> top10neuTweets1) {
			this.top10neuTweets1 = top10neuTweets1;
		}
	}

