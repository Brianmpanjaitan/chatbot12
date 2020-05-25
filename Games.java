
package chat;

/**
 *
 * @author Brain
 */
public class Games implements Domain
{
    public String getDescription()
    {
        return "Small Talk: Cash$";
    }
    	public String getGreeting()
	{
		return "Stranger Danger!";
	}
        
        public String getResponse(String statement)
	{
            String response = "";
            if (statement.length() == 0)
            {
                response = "Are you afk?";
            }
            else if (statement.indexOf("hi") >= 0 || statement.indexOf("hello") >= 0)
            {
                response = "sup bitch";
            }
            else if (statement.indexOf("how are you") >= 0)
            {
                response = "Just fucking hoes nm, hbu?";
            }
            else if (statement.indexOf("your name?") >= 0)
            {
                response = "My name is Daddy";
            }
            else if (statement.trim().length() <= 0)
            {
                response = "Why did you ff@20.";
            }     
            else if (statement.indexOf("feed") >= 0 || statement.indexOf("feeder") >= 0)
            {
                response = "Why are you feeding?";
            }
            else if (statement.indexOf("feeder") >= 0)
            {
                response = "Whaaat are you talking about?";
            }
            else if (statement.indexOf("lost") >= 0 || statement.indexOf("lose") >= 0)
            {
                response = "GG rip 5.";
            }
            else if (statement.indexOf("ez") >= 0 || statement.indexOf("win") >= 0)
            {
                response = "EZ$";
            }
            else if (statement.indexOf("dood") >= 0)
            {
                response = "Stop trolling";
            }
            else if (statement.indexOf("troll") >= 0)
            {
                response = "hell yeah dood.";
            }
            else if (statement.indexOf("bm") >= 0)
            {
                response = "idk what you're talking about dood";
            }
            else if (findKeyword(statement, "I want to", 0) >= 0)
            {
                response = transformIWantToStatement(statement);
            }
            else
            {
                int position = findKeyword(statement, "you", 0);

		if (position >= 0 && findKeyword(statement, "me", position) >= 0)
		{
                    response = transformYouMeStatement(statement);
                }
                else
		{
                    response = getRandomResponse();
		}
            }
            return response;
        }
        private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int position = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(position + 9).trim();
		return "What does it mean to " + restOfStatement + "?";
	}

	private String transformYouMeStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int positionOfYou = findKeyword (statement, "you", 0);
		int positionOfMe = findKeyword (statement, "me", positionOfYou + 3);
		
		String restOfStatement = statement.substring(positionOfYou + 3, positionOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}
        
        private int findKeyword(String statement, String goal, int start)
	{
		String phrase = statement.trim();
		//  The only change to incorporate the start is in the line below
		int position = phrase.toLowerCase().indexOf(goal.toLowerCase(), start);
		
		//  Refinement--make sure the goal isn't part of a word 
		while (position >= 0) 
		{
			//  Find the string of length 1 before and after the word
			String before = "";
                        String after = ""; 
			if (position > 0)
			{
                            before = phrase.substring (position - 1, position).toLowerCase();
			}
			if (position + goal.length() < phrase.length())
			{
                            after = phrase.substring(position + goal.length(), position + goal.length() + 1).toLowerCase();
			}
			
			//  If before and after aren't letters, we've found the word
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
					&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return position;
			}
			
			//  The last position didn't work, so let's find the next, if there is one.
			position = phrase.indexOf(goal.toLowerCase(), position + 1);	
		}
		return -1;
	}
        private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
        
        public String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "new phone who dis";
		}
		else if (whichResponse == 1)
		{
			response = "fucking";
		}
		else if (whichResponse == 2)
		{
			response = "fuck off";
		}
		else if (whichResponse == 3)
		{
			response = "k";
		}
                else if (whichResponse == 4)
                {
                    response = "Chills.";
                }
                else if (whichResponse == 5)
                {
                response = "Awks bro.";
                }   
		return response;
	}
}
