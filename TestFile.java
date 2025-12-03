//Sahas Maduri and Sreekar Bheemavarapu -> 12/3/2025
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFile
{
	public static void main(String [] args)
	{
	    ExecutorService executor = Executors.newFixedThreadPool(2);

		long start = System.nanoTime();

	    executor.submit(() -> changeFile("frankenstein.txt"));
   		executor.submit(() -> changeFile("mobydick.txt"));
    	executor.shutdown();

		long end = System.nanoTime();

		System.out.println("Took " + (end-start)/100000 + " ms.");
	}

	public static void changeFile(String path) {

		try(BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter("output" + path)))
		{
			String line = "";
			while((line = reader.readLine()) !=null)
			{
				writer.write(line.toUpperCase());
				writer.newLine();
			}

			writer.close();
		} catch(IOException e)
		{
			e.printStackTrace();
		}


	}
}
