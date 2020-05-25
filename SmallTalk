package chat;

public class SmallTalk implements Domain
{
    public String getDescription()
    {
        return "Small Talk: complaining about shit, procrastinating, making ca$h bank";
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
                response = "dying cause of midterms, hbu?";
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
            statement = statement.trim();
            String lastChar = statement.substring(statement.length() - 1);
            if (lastChar.equals("."))
            {
                statement = statement.substring(0, statement.length() - 1);
            }
            int position = findKeyword (statement, "I want to", 0);
            String restOfStatement = statement.substring(position + 9).trim();
            return "What would it mean to " + restOfStatement + "?";
	}

	private String transformYouMeStatement(String statement)
	{
            statement = statement.trim();
            String lastChar = statement.substring(statement.length() - 1);
            if (lastChar.equals("."))
            {
                statement = statement.substring(0, statement.length() - 1);
            }
		
            int positionOfYou = findKeyword (statement, "you", 0);
            int positionOfMe = findKeyword (statement, "me", positionOfYou + 3);
		
            String restOfStatement = statement.substring(positionOfYou + 3, positionOfMe).trim();
            return "What makes you think that I " + restOfStatement + " you?";
	}
        
        private int findKeyword(String statement, String goal, int start)
	{
            String phrase = statement.trim();
            int position = phrase.toLowerCase().indexOf(goal.toLowerCase(), start);
		
            while (position >= 0) 
            {
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
			
                if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
                {
                    return position;
                }
			
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
                response = "no balls lmao";
            }
            else if (whichResponse == 2)
            {
                response = "fuck off";
            }
            else if (whichResponse == 3)
            {
                response = "You don't say.";
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
