import java.util.*;
class CaeserCipher
{
    static String ALPHABET="abcdefghijklmnopqrstuvwxyz";
    
	public static String encrypt(String text, int s)
	{
		StringBuffer result= new StringBuffer();

		for (int i=0; i<text.length(); i++)
		{
			if (Character.isUpperCase(text.charAt(i)))
			{
				char ch = (char)(((int)text.charAt(i) +
								s - 65) % 26 + 65);
				result.append(ch);
			}
			else
			{
				char ch = (char)(((int)text.charAt(i) +
								s - 97) % 26 + 97);
				result.append(ch);
			}
		}
		return result.toString();
	}
  
   public static String decrypt(String cipherText, int shiftKey) {
    cipherText = cipherText.toLowerCase();
    String message = "";
    for (int ii = 0; ii < cipherText.length(); ii++) {
      int charPosition = ALPHABET.indexOf(cipherText.charAt(ii));
      int keyVal = (charPosition - shiftKey) % 26;
      if (keyVal < 0) {
        keyVal = ALPHABET.length() + keyVal;
      }
      char replaceVal = ALPHABET.charAt(keyVal);
      message += replaceVal;
    }
    return message;
  }
  
	public static void main(String[] args)
	{
	Scanner sc=new Scanner(System.in);
    System.out.println("Enter a new String");
    String s=sc.nextLine();
    System.out.println("Enter the value by which character gets shifted");
    int key=sc.nextInt();
    String e=encrypt(s, key);
    System.out.println("Cipher: " + e);
    System.out.println("Cipher: " + decrypt(e, key));
	}
}
