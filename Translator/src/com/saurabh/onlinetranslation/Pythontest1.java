package com.saurabh.onlinetranslation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pythontest1 {
	
	private static Scanner scanner;
	private static Process pr;
	private static String[] values1;
	private static String word = "#GE16";
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	float positive1;
	float negative1;
	float neutral1;
	private static ArrayList<TweetList> arrListneg = new ArrayList<TweetList>();
	private static ArrayList<TweetList> arrListpos = new ArrayList<TweetList>();
	private static ArrayList<TweetList> arrListneu = new ArrayList<TweetList>();
	ArrayList<String> top10posTweets = new ArrayList<String>();
	ArrayList<String> top10negTweets = new ArrayList<String>();
	ArrayList<String> top10neuTweets = new ArrayList<String>();
	public static void splittingFunc(String line){
		//String str = "Well done ||| 0.7464316";
		values1 = line.split("\\ \\|\\|\\|\\ ");
		int len = values1.length;
		//System.out.println("length: " + len);

		//System.out.println(values[0]);
		//System.out.println(values[1]);
		//		
		getHashTags(line);
	}

	public static void getHashTags(String line) {
		Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
		Matcher mat = MY_PATTERN.matcher(line);
		List<String> strs = new ArrayList<String>();
		System.out.println("Hash Tags used: ");
		while(mat.find()){
			strs.add(mat.group(1));
			System.out.println(mat.group(1));
			word = mat.group(1);
		}
	}

	
	
	
	
	public String Pythontest11(String inputText) throws IOException{
		// TODO Auto-generated method stub
		String pythonScriptpath = "C:\\Users\\saurabh\\Desktop\\practicum\\SentiFocalTweet\\sentiTweetFocail.py";
		String[] cmd1 = new String[3];
		cmd1[0] = "python";
		cmd1[1] = pythonScriptpath;
		cmd1[2] = inputText;
		System.out.println("inputText at py11: " + inputText);
		Runtime rtirish = Runtime.getRuntime();
		Process prirish = rtirish.exec(cmd1);

		//Retrieving output
		BufferedReader bfrirish = new BufferedReader(new InputStreamReader(prirish.getInputStream()));
		String line2 = "";
		//double score = (Double) null;
		while((line2 = bfrirish.readLine())!= null){
			System.out.println(line2);

			splittingFunc(line2);
		}





		//hooking up the line indexes that has keyword
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		File file = new File("C:\\Users\\saurabh\\Desktop\\practicum\\SentiFocalTweet\\irish_tweets.txt");
		try{
			scanner = new Scanner(file);

			int lineNum = 0;
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lineNum++;
				if(line.contains(word.toLowerCase()) || line.contains(word.toUpperCase())){
					indexes.add(lineNum);
				}
			}
		}catch(FileNotFoundException e){

		}


		/***********************************************************************************************************************************/

		//to extract all the lines only that has the provided keyword
		String[] sentences = new String[indexes.size()];
		String filename = "C:\\Users\\saurabh\\Desktop\\practicum\\SentiFocalTweet\\irish_tweets.txt";
		int counter = 0;
		int j = 0;
		String newLine = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try{
			fileReader = new FileReader(filename);

			bufferedReader = new BufferedReader(fileReader);

			while((newLine = bufferedReader.readLine()) != null){
				counter++;
				if(counter == indexes.get(j)){
					sentences[j] = newLine;
					j++;
				}
			}

		}catch(FileNotFoundException ex){
			System.out.println("File not found: " + filename);
		}catch (IOException ex) {
			System.out.println("Error reading file");
		}
		finally {
			if(fileReader != null){
				bufferedReader.close();
			}
		}

		//output of all the tweets that has provided keyword
		//		for(int i = 0; i < indexes.size(); i++)
		//			System.out.println(sentences[i]);

		/************************************************************************************************************/

		//writing the meaningful tweets to a file
		Writer output = null;
		File outputFile = new File("C:\\Users\\saurabh\\Desktop\\practicum\\SentiFocalTweet\\output1.txt");
		output = new BufferedWriter(new FileWriter(outputFile));
		for(int i = 0; i < indexes.size(); i++){
			output.write(sentences[i] + "\n");
		}
		output.flush();
		output.close();



		/************************************************************************************************************/
		//System.out.println("The sentiments: " + indexes.size());
		double positive = 0,negative = 0,neutral = 0;
		int lengthSentences = indexes.size();
		String pythonScriptpath1 = "C:\\Users\\saurabh\\Desktop\\practicum\\SentiFocalTweet\\sentiTweetFocail.py";
		String outputFile1 = "C:\\Users\\saurabh\\Desktop\\practicum\\SentiFocalTweet\\output1.txt";
		String[] cmdirish = new String[4];

		//for(int i = 0; i < lengthSentences; i++){
		cmdirish[0] = "python";
		cmdirish[1] = pythonScriptpath1;
		cmdirish[2] = "-f";
		cmdirish[3] = outputFile1;//sentences[i];

		//runtime executing at cmd prompt
		Runtime rt1 = Runtime.getRuntime();
		Process pr1 = rt1.exec(cmdirish);

		BufferedReader bfr1 = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
		String line1 = "";
		//double score = (Double) null;
		while((line1 = bfr1.readLine())!= null){

			//System.out.println("LINE: "+ line1);

			String[] values = line1.split("\\ \\|\\|\\|\\ ");




			if(Double.parseDouble(values[1]) < 0.5 && Double.parseDouble(values[1]) >= 0.0){
				arrListneg.add(new TweetList(values[0], Double.parseDouble(values[1])));
				negative++;}
			else if(Double.parseDouble(values[1]) > 0.5 && Double.parseDouble(values[1]) < 1.0){
				arrListpos.add(new TweetList(values[0], Double.parseDouble(values[1])));
				positive++;}
			else{
				arrListneu.add(new TweetList(values[0], Double.parseDouble(values[1])));
				neutral++;}
			//System.out.println(line1);
			//splittingFunc(line);
		}
		//		}

		Double total = positive + negative + neutral;
		positive = (positive/total)*100;
		negative = (negative/total)*100;
		neutral = (neutral/total)*100;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		////////////////////////////////////////////////////////////////////////////////////////////
		if(Double.parseDouble(values1[1]) > 0.0 && Double.parseDouble(values1[1]) < 0.5)
			System.out.println("Sentiment of your tweet: Negative");
		else if(Double.parseDouble(values1[1]) > 0.5 && Double.parseDouble(values1[1]) < 1.0)
			System.out.println("Sentiment of your tweet: Positive");
		else
			System.out.println("Sentiment of your tweet: Neutral");


		////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Analyzed number of tweets on supplied keyword #GE16: " + total.intValue());
		System.out.println("Positive: " + numberFormat.format(positive) + "%");
		System.out.println("Negative: " + numberFormat.format(negative) + "%");
		System.out.println("Neutral: " + numberFormat.format(neutral) + "%");

		positive1 = Float.valueOf(numberFormat.format(positive));
		negative1 = Float.valueOf(numberFormat.format(negative));
		neutral1 = Float.valueOf(numberFormat.format(neutral));

		//////////////////////////////////////////////////////////////////////////////////////////////
		//Output all the top 10 tweets

		//		System.out.println("Negative");
		Collections.sort(arrListneg,TweetList.StuNameComparator1);
		for(TweetList str: arrListneg){
			//top10negTweets[countertop10] = str;
			//System.out.println(str.getcTweet());
			top10negTweets.add(str.getcTweet());

		}

		//		System.out.println("Positive");
		Collections.sort(arrListpos,TweetList.StuNameComparator);
		for(TweetList str: arrListpos){
			//System.out.println(str);
			top10posTweets.add(str.getcTweet());
		}

		//		System.out.println("Neutral");
		Collections.sort(arrListneu,TweetList.StuNameComparator);
		for(TweetList str: arrListneu){
			//System.out.println(str);
			top10neuTweets.add(str.getcTweet());
		}


		int countertop10 = 0;
		System.out.println("Positive");
		while(countertop10 < 10)
		{
			System.out.println(top10posTweets.get(countertop10));
			countertop10++;
		}
		countertop10 = 0;
		System.out.println("Negative");
		while(countertop10 < 10)
		{
			System.out.println(top10negTweets.get(countertop10));
			countertop10++;
		}
		countertop10 = 0;
		System.out.println("Neutral");
		while(countertop10 < 10)
		{
			System.out.println(top10neuTweets.get(countertop10));
			countertop10++;
		}





		return (values1[1]);
	}

}
