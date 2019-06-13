public class TennisGame {
    public static final int ZEROSCORE=0;
    public static final int ONESCORE=1;
    public static final int TWOSCORE=2;
    public static final int THREESCORE=3;
    public static final int FOURSCORE=4;
    public static String getScore(String playerone, String playertwo, int scoreplayerone, int scoreplayertwo) {
        String result = "";
        int tempScore;
        if (scoreplayerone==scoreplayertwo)
        {
            switch (scoreplayerone)
            {
                case ZEROSCORE:
                    result = "Love-All";
                    break;
                case ONESCORE:
                    result = "Fifteen-All";
                    break;
                case TWOSCORE:
                    result = "Thirty-All";
                    break;
                case THREESCORE:
                    result = "Forty-All";
                    break;
                default:
                    result = "Deuce";
                    break;

            }
        }
        else if (scoreplayerone>=FOURSCORE || scoreplayertwo>=FOURSCORE)
        {
            result = getString(scoreplayerone, scoreplayertwo);
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = scoreplayerone;
                else { result+="-"; tempScore = scoreplayertwo;}
                switch(tempScore)
                {
                    case ZEROSCORE:
                        result+="Love";
                        break;
                    case ONESCORE:
                        result+="Fifteen";
                        break;
                    case TWOSCORE:
                        result+="Thirty";
                        break;
                    case THREESCORE:
                        result+="Forty";
                        break;
                }
            }
        }

        System.out.println(result);
        return result;
    }

    private static String getString(int scoreplayerone, int scoreplayertwo) {
        String result;
        int minusResult = scoreplayerone-scoreplayertwo;
        if (minusResult==ONESCORE) result ="Advantage player1";
        else if (minusResult ==-ONESCORE) result ="Advantage player2";
        else if (minusResult>=TWOSCORE) result = "Win for player1";
        else result ="Win for player2";
        return result;
    }
}
