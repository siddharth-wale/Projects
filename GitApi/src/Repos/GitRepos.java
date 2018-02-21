package Repos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GitRepos {

	public static void main(String[] args) throws JSONException {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter your UserName"); 
		 String userName=sc.next(); 
		 
        JSONParser parser = new JSONParser();
        try {         
            URL url = new URL("https://api.github.com/users/"+ userName+ "/repos"); // URL to Parse
            URLConnection urlConnection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {               
                JSONArray arr = (JSONArray) parser.parse(inputLine);
                
                // Loop through each item
                for (Object o : arr) {
                    JSONObject repos = (JSONObject) o;

                    Long id = (Long) repos.get("id");
                    System.out.println("Repository ID : " + id);

                    String full_name = (String) repos.get("full_name");
                    System.out.println("Repository Name : " + full_name);

                    System.out.println("\n");
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }   
	}
}