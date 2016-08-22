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

public class Pythontest {


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



	public String Pythontest1(String inputText) throws IOException {

		//Scanner scanner = new Scanner(System.in);
		//System.out.println("Enter some text for sentiment Analysis: ");
		//String inputText = scanner.nextLine();
		//String this.inputText = inputText;
		String pythonScriptpath = "C:\\Users\\saurabh\\Desktop\\practicum\\SentiTweetWords-0.2\\sentiTweetWords-0.2.py";
		String[] cmd = new String[3];
		cmd[0] = "python";
		cmd[1] = pythonScriptpath;
		cmd[2] = inputText;
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec(cmd);

		//Retrieving output
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line2 = "";
		//double score = (Double) null;
		while((line2 = bfr.readLine())!= null){
			//System.out.println(line);
			splittingFunc(line2);
		}





		//hooking up the line indexes that has keyword
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		File file = new File("C:\\Users\\saurabh\\Desktop\\practicum\\SentiTweetWords-0.2\\test.txt");
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
		String filename = "C:\\Users\\saurabh\\Desktop\\practicum\\SentiTweetWords-0.2\\test.txt";
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
		File outputFile = new File("C:\\Users\\saurabh\\Desktop\\practicum\\SentiTweetWords-0.2\\output.txt");
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
		String pythonScriptpath1 = "C:\\Users\\saurabh\\Desktop\\practicum\\SentiTweetWords-0.2\\sentiTweetWords-0.2.py";
		String outputFile1 = "C:\\Users\\saurabh\\Desktop\\practicum\\SentiTweetWords-0.2\\output.txt";
		String[] cmd1 = new String[4];

		//for(int i = 0; i < lengthSentences; i++){
		cmd1[0] = "python";
		cmd1[1] = pythonScriptpath1;
		cmd1[2] = "-f";
		cmd1[3] = outputFile1;//sentences[i];

		//runtime executing at cmd prompt
		Runtime rt1 = Runtime.getRuntime();
		Process pr1 = rt1.exec(cmd1);

		BufferedReader bfr1 = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
		String line1 = "";
		//double score = (Double) null;
		while((line1 = bfr1.readLine())!= null){
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
		/////////////////////////////////////////////////////////////////////////////////////////////
		//writing "data.csv" for the sentiment percentage
		//		String FILE_HEADER = "sentiment,percentage";
		//		try{
		//			URL url = getClass().getResource("data.csv");
		//			File fi = new File(url.getPath());
		//			FileWriter fw1 = new FileWriter(fi, false);
		//			fw1.append(FILE_HEADER);
		//			//StringBuilder fw = new StringBuilder();
		//			//CSV file header
		////			fw1.append("sentiment");
		////			fw1.append(COMMA_DELIMITER);
		////			fw1.append("percentage");
		//			fw1.append(NEW_LINE_SEPARATOR);
		//			
		//			//appending the data.csv file
		//			fw1.append("Positive");
		//			fw1.append(COMMA_DELIMITER);
		//			fw1.append(Double.toString(positive));
		//			fw1.append(NEW_LINE_SEPARATOR);
		//			
		//			fw1.append("Negative");
		//			fw1.append(COMMA_DELIMITER);
		//			fw1.append(Double.toString(negative));
		//			fw1.append(NEW_LINE_SEPARATOR);
		//			
		//			fw1.append("Neutral");
		//			fw1.append(COMMA_DELIMITER);
		//			fw1.append(Double.toString(neutral));
		//			fw1.append(NEW_LINE_SEPARATOR);
		//			
		//			System.out.println("data.csv file was written successfully");
		//			fw1.flush();
		//			fw1.close();
		//			
		//		}catch(Exception e){
		//			System.out.println("Error in CSV File Writer");
		//			e.printStackTrace();
		//		}
		//		
	}

	
}
