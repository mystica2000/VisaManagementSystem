import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation{
	public boolean validateEmail(String email)
	{
		String regex="^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern=Pattern.compile(regex);
		
		Matcher matcher=pattern.matcher(email);
		return matcher.matches()==true;
	}
	public boolean validatePassword(String pass)
	{
		String regex="^[.{8,15}]";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(pass);
		return matcher.matches()==true;
	}
	public boolean validatePhone(String phone)
	{	

		String regex="^[0-9]{10}";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(phone);
		return matcher.matches()==true;
	}

	public boolean dob(Date entry)
	{
		String wholeString=entry.toString();
		String year=wholeString.substring(wholeString.length()-4,wholeString.length());
		System.out.println(year);
		int year_converted=Integer.parseInt(year);
		Date curs=new Date();
		String cur=curs.toString();
		String current=cur.substring(cur.length()-4,cur.length());
		int cur_year=Integer.valueOf(current);
		System.out.println(cur_year);
		System.out.println(cur_year-year_converted);
		if((cur_year-year_converted)<18)
		{
			return false;
		}
		return true;
	}
	public String generatePassword()
	{
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[10];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));

	      for(int i = 4; i< 10 ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      return password.toString();
	}
}