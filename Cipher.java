import java.util.Random;
import java.util.Scanner;

public class Cipher {
	
	public final static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', +
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
	
	public static void main (String[] args)
	{
		char[] cipher = createCipher();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the sentence to be encrypted:");
		String myString = input.nextLine();
		input.close();
		System.out.println(myString);
		char[] inputString = myString.toLowerCase().toCharArray();
		char[] encryptedString = encrypt(inputString, cipher);
		System.out.println(encryptedString);
		char[] decryptedString = decrypt(encryptedString, cipher);
		System.out.println(decryptedString);
	}
	
	public static char[] createCipher()
	{
		char[] cipher = new char[27];
		Random rand = new Random();
		for(int i = 0; i < cipher.length; i++)
		{
			int randomInt;
			do
			{
				randomInt = rand.nextInt(cipher.length);
			} while (cipher[randomInt] != 0);
			cipher[randomInt] = alphabet[i];
		}
		return cipher;
	}
	
	public static char[] encrypt(char[] input, char[] cipher)
	{
		char[] output = new char[input.length];
		for(int i = 0; i < input.length; i++)
		{
			int index = getIndex(input[i], alphabet);
			output[i] = cipher[index];
		}
		return output;
	}
	
	public static char[] decrypt(char[] input, char[] cipher)
	{
		char[] output = new char[input.length];
		for(int i = 0; i < input.length; i++)
		{
			int index = getIndex(input[i], cipher);
			output[i] = alphabet[index];
		}
		return output;
	}
	
	public static int getIndex(char input, char[] cipher)
	{
		for(int i = 0; i < cipher.length; i++)
		{
			if(input == cipher[i])
			{
				return i;
			}
		}
		return -1;
	}
}
