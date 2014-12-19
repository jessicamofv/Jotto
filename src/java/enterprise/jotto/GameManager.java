/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.jotto;

import enterprise.jotto.entities.Jgame;
import enterprise.jotto.entities.Jguess;
import enterprise.jotto.entities.Jword;
import enterprise.jotto.entities.Juser;
import enterprise.jotto.entities.Jstats;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

/**
 *
 * @author Jessica
 */
@ManagedBean(name="gamemanager")
@SessionScoped
public class GameManager {
     /**
     * <p>The <code>PersistenceContext</code>.</p>
     */
    @PersistenceContext(unitName = "JottoPU") 
    private EntityManager em;
    
    /**
     * <p>The transaction resource.</p>
     */
    @Resource 
    private UserTransaction utx;
    
    // THE GAME WILL ALWAYS BE IN
    // ONE OF THESE THREE STATES
    public enum JottoGameState
    {
        GAME_NOT_STARTED,
        GAME_IN_PROGRESS,
        GAME_OVER
    }
    
    // STORES THE CURRENT STATE OF THIS GAME
    private JottoGameState currentGameState;
    private String guess;
    private List guessesList;
    private String guessedWords;
    private HashMap<Character,String> letters;
    private String aClass;
    private String bClass;
    private String cClass;
    private String dClass;
    private String eClass;
    private String fClass;
    private String gClass;
    private String hClass;
    private String iClass;
    private String jClass;
    private String kClass;
    private String lClass;
    private String mClass;
    private String nClass;
    private String oClass;
    private String pClass;
    private String qClass;
    private String rClass;
    private String sClass;
    private String tClass;
    private String uClass;
    private String vClass;
    private String wClass;
    private String xClass;
    private String yClass;
    private String zClass;
    private String letterSpans;
    private int lettersInGuess;
    private String subheaderText;
    private String wordListString;
    private int gamesPlayed;
    private int wins;
    private int losses;
    private String fewestGuessesWin;
    private String fastestWin;
    private Juser currentUser;
    private String secretWord;
    private String winMessage;
    private String cheatText;
    // START AND END TIME WILL BE USED TO CALCULATE THE 
    // TIME IT TAKES TO PLAY THIS GAME
    private GregorianCalendar startTime;
    private GregorianCalendar endTime;
    private String gameResults;
    
    public String getWordListString() {
        return wordListString;
    }

    public void setWordListString(String wordListString) {
        this.wordListString = wordListString;
    }
    
    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getSubheaderText() {
        return subheaderText;
    }

    public void setSubheaderText(String subheaderText) {
        this.subheaderText = subheaderText;
    }

    public String getGuessedWords() {
        return guessedWords;
    }

    public void setGuessedWords(String guessedWords) {
        this.guessedWords = guessedWords;
    }

    public String getWinMessage() {
        return winMessage;
    }

    public void setWinMessage(String winMessage) {
        this.winMessage = winMessage;
    }

    public String getCheatText() {
        return cheatText;
    }

    public void setCheatText(String cheatText) {
        this.cheatText = cheatText;
    }
    
    public String getGameResults() {
        return gameResults;
    }

    public void setGameResults(String gameResults) {
        this.gameResults = gameResults;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
    
    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getFewestGuessesWin() {
        return fewestGuessesWin;
    }

    public void setFewestGuessesWin(String fewestGuessesWin) {
        this.fewestGuessesWin = fewestGuessesWin;
    }

    public String getFastestWin() {
        return fastestWin;
    }

    public void setFastestWin(String fastestWin) {
        this.fastestWin = fastestWin;
    }

    public Juser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Juser currentUser) {
        this.currentUser = currentUser;
    }
    
    public String getAClass() {
        return aClass;
    }

    public void setAClass(String aClass) {
        this.aClass = aClass;
    }

    public String getBClass() {
        return bClass;
    }

    public void setBClass(String bClass) {
        this.bClass = bClass;
    }

    public String getCClass() {
        return cClass;
    }

    public void setCClass(String cClass) {
        this.cClass = cClass;
    }

    public String getDClass() {
        return dClass;
    }

    public void setDClass(String dClass) {
        this.dClass = dClass;
    }

    public String getEClass() {
        return eClass;
    }

    public void setEClass(String eClass) {
        this.eClass = eClass;
    }

    public String getFClass() {
        return fClass;
    }

    public void setFClass(String fClass) {
        this.fClass = fClass;
    }

    public String getGClass() {
        return gClass;
    }

    public void setGClass(String gClass) {
        this.gClass = gClass;
    }

    public String getHClass() {
        return hClass;
    }

    public void setHClass(String hClass) {
        this.hClass = hClass;
    }

    public String getIClass() {
        return iClass;
    }

    public void setIClass(String iClass) {
        this.iClass = iClass;
    }

    public String getJClass() {
        return jClass;
    }

    public void setJClass(String jClass) {
        this.jClass = jClass;
    }

    public String getKClass() {
        return kClass;
    }

    public void setKClass(String kClass) {
        this.kClass = kClass;
    }

    public String getLClass() {
        return lClass;
    }

    public void setLClass(String lClass) {
        this.lClass = lClass;
    }

    public String getMClass() {
        return mClass;
    }

    public void setMClass(String mClass) {
        this.mClass = mClass;
    }

    public String getNClass() {
        return nClass;
    }

    public void setNClass(String nClass) {
        this.nClass = nClass;
    }

    public String getOClass() {
        return oClass;
    }

    public void setOClass(String oClass) {
        this.oClass = oClass;
    }

    public String getPClass() {
        return pClass;
    }

    public void setPClass(String pClass) {
        this.pClass = pClass;
    }

    public String getQClass() {
        return qClass;
    }

    public void setQClass(String qClass) {
        this.qClass = qClass;
    }

    public String getRClass() {
        return rClass;
    }

    public void setRClass(String rClass) {
        this.rClass = rClass;
    }

    public String getSClass() {
        return sClass;
    }

    public void setSClass(String sClass) {
        this.sClass = sClass;
    }

    public String getTClass() {
        return tClass;
    }

    public void setTClass(String tClass) {
        this.tClass = tClass;
    }

    public String getUClass() {
        return uClass;
    }

    public void setUClass(String uClass) {
        this.uClass = uClass;
    }

    public String getVClass() {
        return vClass;
    }

    public void setVClass(String vClass) {
        this.vClass = vClass;
    }

    public String getWClass() {
        return wClass;
    }

    public void setWClass(String wClass) {
        this.wClass = wClass;
    }

    public String getXClass() {
        return xClass;
    }

    public void setXClass(String xClass) {
        this.xClass = xClass;
    }

    public String getYClass() {
        return yClass;
    }

    public void setYClass(String yClass) {
        this.yClass = yClass;
    }

    public String getZClass() {
        return zClass;
    }
    
    public void initGame(Juser user)
    {
        currentGameState = JottoGameState.GAME_IN_PROGRESS;
        guessesList = new ArrayList();
        guessedWords = "";
        currentUser = user;
        subheaderText = "";
        winMessage = "";
        startTime = new GregorianCalendar();
        endTime = null;
        
        aClass = "grayLetter";
        bClass = "grayLetter";
        cClass = "grayLetter";
        dClass = "grayLetter";
        eClass = "grayLetter";
        fClass = "grayLetter";
        gClass = "grayLetter";
        hClass = "grayLetter";
        iClass = "grayLetter";
        jClass = "grayLetter";
        kClass = "grayLetter";
        lClass = "grayLetter";
        mClass = "grayLetter";
        nClass = "grayLetter";
        oClass = "grayLetter";
        pClass = "grayLetter";
        qClass = "grayLetter";
        rClass = "grayLetter";
        sClass = "grayLetter";
        tClass = "grayLetter";
        uClass = "grayLetter";
        vClass = "grayLetter";
        wClass = "grayLetter";
        xClass = "grayLetter";
        yClass = "grayLetter";
        zClass = "grayLetter";
        
        letters = new HashMap();
        letters.put('A', aClass);
        letters.put('B', bClass);
        letters.put('C', cClass);
        letters.put('D', dClass);
        letters.put('E', eClass);
        letters.put('F', fClass);
        letters.put('G', gClass);
        letters.put('H', hClass);
        letters.put('I', iClass);
        letters.put('J', jClass);
        letters.put('K', kClass);
        letters.put('L', lClass);
        letters.put('M', mClass);
        letters.put('N', nClass);
        letters.put('O', oClass);
        letters.put('P', pClass);
        letters.put('Q', qClass);
        letters.put('R', rClass);
        letters.put('S', sClass);
        letters.put('T', tClass);
        letters.put('U', uClass);
        letters.put('V', vClass);
        letters.put('W', wClass);
        letters.put('X', xClass);
        letters.put('Y', yClass);
        letters.put('Z', zClass);
        
        if (getStats() == null)
            initializeStats();
        else
            loadStats();
        
        secretWord = getSecretWord();
        // if the selected secret word has repeating letters,
        // keep picking a new one until it doesn't
        while (hasRepeatingLetters(secretWord))
        {
            secretWord = getSecretWord();
        }
        cheatText = secretWord.toUpperCase();
    }
    
    public void processGuess(AjaxBehaviorEvent event)
    {
        if (currentGameState == JottoGameState.GAME_IN_PROGRESS)
        {
            FacesContext context = FacesContext.getCurrentInstance();

            if (guess.length() != 5)
            {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                        "",
                                        "Your guess must have five letters.");
                context.addMessage(null, message);
            }
            else if (guessesList.contains(guess))
            {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                            "",
                                            "That word has already been guessed.");
                    context.addMessage(null, message);
            }
            else
            {
                String wordToFind = guess.toLowerCase();

                if (checkForWord(wordToFind) == null)
                {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                            "",
                                            "That word is not in the dictionary.");
                    context.addMessage(null, message);
                }
                else
                {
                    if (subheaderText.equals(""))
                    {
                        subheaderText = "Guesses (# of letters in secret word)";
                    }

                    guessesList.add(guess);
                    guessedWords = "";

                    for (int i = 0; i < guessesList.size(); i++)
                    {
                        String guessInList = "" + guessesList.get(i);
                        guessInList = guessInList.toUpperCase();
                        letterSpans = "";

                        for (int j = 0; j < guessInList.length(); j++)
                        {
                            char c = guessInList.charAt(j);
                            String letterClass = letters.get(c);
                            letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
                        }

                        lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());

                        guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
                    }

                    if (wordToFind.equals(secretWord))
                    {
                        winMessage = "You win!";
                        endTime = new GregorianCalendar();
                        recordGame(getTimeOfGame());
                        updateGameResults();
                        currentGameState = JottoGameState.GAME_OVER;
                        wins += 1;
                        gamesPlayed += 1;
                        updateWins();
                        updateGamesPlayed();
                        updateWinStats();
                    }

                    // clear textfield
                    guess = "";
                }
            }
        }
    }
    
    public void startNewGame()
    {
        if (currentGameState == JottoGameState.GAME_IN_PROGRESS)
        {
            endTime = new GregorianCalendar();
            recordGame(getTimeOfGame());
            updateGameResults();
            currentGameState = JottoGameState.GAME_OVER;
            losses += 1;
            gamesPlayed += 1;
            updateLosses();
            updateGamesPlayed();
        }
        
        // clear textfield
        guess = "";
        initGame(currentUser);
    }
    
    public boolean hasRepeatingLetters(String testWord)
    {
        for (int i = 0; i < testWord.length(); i++)
        {
            char testChar = testWord.charAt(i);
            for (int j = i + 1; j < testWord.length(); j++)
            {
                char testChar2 = testWord.charAt(j);
                if (testChar == testChar2)
                    return true;
            }
        }
        return false;
    }
    
    public int calcLettersInGuess(String guess)
    {
        int counter = 0;
        for (int i = 0; i < guess.length(); i++)
        {
            char testChar = guess.charAt(i);
            if (secretWord.indexOf(testChar) >= 0)
                counter++;
        }
        return counter;
    }
    
    public void initializeStats()
    {
        gamesPlayed = 0;
        wins = 0;
        losses = 0;
        fewestGuessesWin = "-";
        fastestWin = "-";
        Jstats jstats = new Jstats();
        jstats.setGamesplayed(gamesPlayed);
        jstats.setWins(wins);
        jstats.setLosses(losses);
        jstats.setFewestguessesjgameid(0);
        jstats.setFastestwinjgameid(0);
        jstats.setJuserid(currentUser);
        try {
            utx.begin();
            em.persist(jstats);
            utx.commit();
        } catch (Exception e) {
                
        }
    }
    public void loadStats()
    {
        Jstats stats = getStats();
        gamesPlayed = stats.getGamesplayed();
        wins = stats.getWins();
        losses = stats.getLosses();
        
        String guessesString = "";
        Jguess guessInGame;
        List guessesForGame; 
        
        if (stats.getFewestguessesjgameid() == 0)
        {
            fewestGuessesWin = "-";        
        }
        else
        {
            Jgame fewestGuessesGame = getGameById(stats.getFewestguessesjgameid());
            guessesForGame = getGuessesForGame(fewestGuessesGame);

            for (int i = 0; i < guessesForGame.size(); i++)
            {
                guessInGame = (Jguess)guessesForGame.get(i);
                if (i == 0)
                    guessesString += guessInGame.getGuess();
                else
                    guessesString += ", " + guessInGame.getGuess();
            }

            fewestGuessesWin = fewestGuessesGame.getSecretword() + " (" + getGameTimeString(fewestGuessesGame.getGametime()) + ") - " + guessesString;
        }
        
        guessesString = "";
        
        if (stats.getFastestwinjgameid() == 0)
        {
            fastestWin = "-";
        }
        else
        {
            Jgame fastestWinGame = getGameById(stats.getFastestwinjgameid());
            guessesForGame = getGuessesForGame(fastestWinGame);

            for (int i = 0; i < guessesForGame.size(); i++)
            {
                guessInGame = (Jguess)guessesForGame.get(i);
                if (i == 0)
                    guessesString += guessInGame.getGuess();
                else
                    guessesString += ", " + guessInGame.getGuess();
            }

            fastestWin = fastestWinGame.getSecretword() + " (" + getGameTimeString(fastestWinGame.getGametime()) + ") - " + guessesString;
        }
        
        updateGameResults();
    }
    
    public String getGameTimeString(long gameTime)
    {
        // CALCULATE GAME TIEM USING HOURS : MINUTES : SECONDS
        long timeInMillis = gameTime;
        long hours = timeInMillis/(1000 * 60 * 60);
        timeInMillis -= hours * (1000 * 60 * 60);        
        long minutes = timeInMillis/(1000 * 60);
        timeInMillis -= minutes * (1000 * 60);
        long seconds = timeInMillis/1000;
        
        String timeText = "";
        String minutesText = "" + minutes;
        if (minutes < 10)
            minutesText = "0" + minutesText;
        String secondsText = "" + seconds;
        if (seconds < 10)
            secondsText = "0" + secondsText;
        timeText = hours + ":" + minutesText + ":" + secondsText;
        return timeText;
    }
    
    public long getTimeOfGame()
    {
        // IF THE GAME ISN'T OVER YET, THERE IS NO POINT IN CONTINUING
        if (endTime == null)
        {
            return -1;
        }
        
        // THE TIME OF THE GAME IS END-START
        long startTimeInMillis = startTime.getTimeInMillis();
        long endTimeInMillis = endTime.getTimeInMillis();
        
        // CALC THE DIFF AND RETURN IT
        long diff = endTimeInMillis - startTimeInMillis;
        return diff;
    }
    
    public void recordGame(long gameTime)
    {
        Jgame jgame = new Jgame();
        jgame.setSecretword(secretWord.toUpperCase());
        jgame.setGametime(gameTime);
        jgame.setNumguesses(guessesList.size());
        jgame.setJuserid(currentUser);
        try {
            utx.begin();
            em.persist(jgame);
            utx.commit();
        } catch (Exception e) {
                
        }
        
        Jguess jguess;
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            
            jguess = new Jguess();
            jguess.setGuess(guessInList);
            jguess.setJgameid(jgame);
            try {
                utx.begin();
                em.persist(jguess);
                utx.commit();
            } catch (Exception e) {
                
            }
        }
    }
    
    public void updateGameResults()
    {
        gameResults = "";
        List gamesList = getGames();
        Jgame gameInList;
        String guessesString = "";
        Jguess guessInGame;
        
        for (int i = 0; i < gamesList.size(); i++)
        {
            gameInList = (Jgame)gamesList.get(i);
            List guessesForGame = getGuessesForGame(gameInList);
            for (int j = 0; j < guessesForGame.size(); j++)
            {
                guessInGame = (Jguess)guessesForGame.get(j);
                if (j == 0)
                    guessesString += guessInGame.getGuess();
                else
                    guessesString += ", " + guessInGame.getGuess();
            }
            
            gameResults += "<li>" + gameInList.getSecretword() + " (" + getGameTimeString(gameInList.getGametime()) + ") - " + guessesString + "</li>";
            
            guessesString = "";
        }
    }
    
    public void updateGamesPlayed()
    {
        Jstats stats = getStats();
        stats.setGamesplayed(gamesPlayed);
        try {
            utx.begin();
            em.merge(stats);
            utx.commit();
        } catch (Exception e) {
                
        }
    }
    
    public void updateWins()
    {
        Jstats stats = getStats();
        stats.setWins(wins);
        try {
            utx.begin();
            em.merge(stats);
            utx.commit();
        } catch (Exception e) {
                
        }
    }
    
    public void updateLosses()
    {
        Jstats stats = getStats();
        stats.setLosses(losses);
        try {
            utx.begin();
            em.merge(stats);
            utx.commit();
        } catch (Exception e) {
                
        }
    }
    
    public void updateWinStats()
    {
        Jgame currentGame = getCurrentGame();
        String guessesString = "";
        String guessInCurrentGame = "";
        String currentGameResult = "";
        
        // construct a game summary for this game
        for (int i = 0; i < guessesList.size(); i++)
        {
            guessInCurrentGame = ((String)guessesList.get(i)).toUpperCase();
            
            if (i == 0)
                guessesString += guessInCurrentGame;
            else
                guessesString += ", " + guessInCurrentGame;
        }
            
        currentGameResult = "" + currentGame.getSecretword() + " (" + getGameTimeString(currentGame.getGametime()) + ") - " + guessesString;
        
        Jstats stats = getStats();
        
        if (stats.getFewestguessesjgameid() == 0)
        {
            stats.setFewestguessesjgameid(currentGame.getId());
            try {
                utx.begin();
                em.merge(stats);
                utx.commit();
            } catch (Exception e) {

            }

            fewestGuessesWin = currentGameResult;
        }
        else
        {
            Jgame currentFewestGuessesGame = getGameById(stats.getFewestguessesjgameid());
            int currentFewestNumGuesses = currentFewestGuessesGame.getNumguesses();
            int currentNumGuesses = guessesList.size();
            if (currentNumGuesses < currentFewestNumGuesses)
            {
                stats.setFewestguessesjgameid(currentGame.getId());
                try {
                    utx.begin();
                    em.merge(stats);
                    utx.commit();
                } catch (Exception e) {

                }

                fewestGuessesWin = currentGameResult;
            }
        }
        
        if (stats.getFastestwinjgameid() == 0)
        {
            stats.setFastestwinjgameid(currentGame.getId());
            try {
                utx.begin();
                em.merge(stats);
                utx.commit();
            } catch (Exception e) {

            }

            fastestWin = currentGameResult;
        }
        else
        {
            Jgame currentFastestWinGame = getGameById(stats.getFastestwinjgameid());
            long currentFastestTime = currentFastestWinGame.getGametime();
            long currentGameTime = getTimeOfGame();
            if (currentGameTime < currentFastestTime)
            {
                stats.setFastestwinjgameid(currentGame.getId());
                try {
                    utx.begin();
                    em.merge(stats);
                    utx.commit();
                } catch (Exception e) {

                }

                fastestWin = currentGameResult;
            }
        }
    }
    
    public void changeAClass(AjaxBehaviorEvent event) {
        if (aClass.equals("grayLetter"))
        {
            aClass = "greenLetter";
        }
        else if (aClass.equals("greenLetter"))
        {
            aClass = "redLetter";
        }
        else
        {
            aClass = "grayLetter";
        }
        
        letters.put('A', aClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeBClass(AjaxBehaviorEvent event) {
        if(bClass.equals("grayLetter"))
        {
            bClass = "greenLetter";
        }
        else if(bClass.equals("greenLetter"))
        {
            bClass = "redLetter";
        }
        else
        {
            bClass = "grayLetter";
        }
        
        letters.put('B', bClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeCClass(AjaxBehaviorEvent event) {
        if(cClass.equals("grayLetter"))
        {
            cClass = "greenLetter";
        }
        else if(cClass.equals("greenLetter"))
        {
            cClass = "redLetter";
        }
        else
        {
            cClass = "grayLetter";
        }
        
        letters.put('C', cClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeDClass(AjaxBehaviorEvent event) {
        if(dClass.equals("grayLetter"))
        {
            dClass = "greenLetter";
        }
        else if(dClass.equals("greenLetter"))
        {
            dClass = "redLetter";
        }
        else
        {
            dClass = "grayLetter";
        }
        
        letters.put('D', dClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeEClass(AjaxBehaviorEvent event) {
        if(eClass.equals("grayLetter"))
        {
            eClass = "greenLetter";
        }
        else if(eClass.equals("greenLetter"))
        {
            eClass = "redLetter";
        }
        else
        {
            eClass = "grayLetter";
        }
        
        letters.put('E', eClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeFClass(AjaxBehaviorEvent event) {
        if(fClass.equals("grayLetter"))
        {
            fClass = "greenLetter";
        }
        else if(fClass.equals("greenLetter"))
        {
            fClass = "redLetter";
        }
        else
        {
            fClass = "grayLetter";
        }
        
        letters.put('F', fClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeGClass(AjaxBehaviorEvent event) {
        if(gClass.equals("grayLetter"))
        {
            gClass = "greenLetter";
        }
        else if(gClass.equals("greenLetter"))
        {
            gClass = "redLetter";
        }
        else
        {
            gClass = "grayLetter";
        }
        
        letters.put('G', gClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeHClass(AjaxBehaviorEvent event) {
        if(hClass.equals("grayLetter"))
        {
            hClass = "greenLetter";
        }
        else if(hClass.equals("greenLetter"))
        {
            hClass = "redLetter";
        }
        else
        {
            hClass = "grayLetter";
        }
        
        letters.put('H', hClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeIClass(AjaxBehaviorEvent event) {
        if(iClass.equals("grayLetter"))
        {
            iClass = "greenLetter";
        }
        else if(iClass.equals("greenLetter"))
        {
            iClass = "redLetter";
        }
        else
        {
            iClass = "grayLetter";
        }
        
        letters.put('I', iClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeJClass(AjaxBehaviorEvent event) {
        if(jClass.equals("grayLetter"))
        {
            jClass = "greenLetter";
        }
        else if(jClass.equals("greenLetter"))
        {
            jClass = "redLetter";
        }
        else
        {
            jClass = "grayLetter";
        }
        
        letters.put('J', jClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeKClass(AjaxBehaviorEvent event) {
        if(kClass.equals("grayLetter"))
        {
            kClass = "greenLetter";
        }
        else if(kClass.equals("greenLetter"))
        {
            kClass = "redLetter";
        }
        else
        {
            kClass = "grayLetter";
        }
        
        letters.put('K', kClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeLClass(AjaxBehaviorEvent event) {
        if(lClass.equals("grayLetter"))
        {
            lClass = "greenLetter";
        }
        else if(lClass.equals("greenLetter"))
        {
            lClass = "redLetter";
        }
        else
        {
            lClass = "grayLetter";
        }
        
        letters.put('L', lClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeMClass(AjaxBehaviorEvent event) {
        if(mClass.equals("grayLetter"))
        {
            mClass = "greenLetter";
        }
        else if(mClass.equals("greenLetter"))
        {
            mClass = "redLetter";
        }
        else
        {
            mClass = "grayLetter";
        }
        
        letters.put('M', mClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeNClass(AjaxBehaviorEvent event) {
        if(nClass.equals("grayLetter"))
        {
            nClass = "greenLetter";
        }
        else if(nClass.equals("greenLetter"))
        {
            nClass = "redLetter";
        }
        else
        {
            nClass = "grayLetter";
        }
        
        letters.put('N', nClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeOClass(AjaxBehaviorEvent event) {
        if(oClass.equals("grayLetter"))
        {
            oClass = "greenLetter";
        }
        else if(oClass.equals("greenLetter"))
        {
            oClass = "redLetter";
        }
        else
        {
            oClass = "grayLetter";
        }
        
        letters.put('O', oClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changePClass(AjaxBehaviorEvent event) {
        if(pClass.equals("grayLetter"))
        {
            pClass = "greenLetter";
        }
        else if(pClass.equals("greenLetter"))
        {
            pClass = "redLetter";
        }
        else
        {
            pClass = "grayLetter";
        }
        
        letters.put('P', pClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeQClass(AjaxBehaviorEvent event) {
        if(qClass.equals("grayLetter"))
        {
            qClass = "greenLetter";
        }
        else if(qClass.equals("greenLetter"))
        {
            qClass = "redLetter";
        }
        else
        {
            qClass = "grayLetter";
        }
        
        letters.put('Q', qClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeRClass(AjaxBehaviorEvent event) {
        if(rClass.equals("grayLetter"))
        {
            rClass = "greenLetter";
        }
        else if(rClass.equals("greenLetter"))
        {
            rClass = "redLetter";
        }
        else
        {
            rClass = "grayLetter";
        }
        
        letters.put('R', rClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeSClass(AjaxBehaviorEvent event) {
        if(sClass.equals("grayLetter"))
        {
            sClass = "greenLetter";
        }
        else if(sClass.equals("greenLetter"))
        {
            sClass = "redLetter";
        }
        else
        {
            sClass = "grayLetter";
        }
        
        letters.put('S', sClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeTClass(AjaxBehaviorEvent event) {
        if(tClass.equals("grayLetter"))
        {
            tClass = "greenLetter";
        }
        else if(tClass.equals("greenLetter"))
        {
            tClass = "redLetter";
        }
        else
        {
            tClass = "grayLetter";
        }
        
        letters.put('T', tClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeUClass(AjaxBehaviorEvent event) {
        if(uClass.equals("grayLetter"))
        {
            uClass = "greenLetter";
        }
        else if(uClass.equals("greenLetter"))
        {
            uClass = "redLetter";
        }
        else
        {
            uClass = "grayLetter";
        }
        
        letters.put('U', uClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeVClass(AjaxBehaviorEvent event) {
        if(vClass.equals("grayLetter"))
        {
            vClass = "greenLetter";
        }
        else if(vClass.equals("greenLetter"))
        {
            vClass = "redLetter";
        }
        else
        {
            vClass = "grayLetter";
        }
        
        letters.put('V', vClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeWClass(AjaxBehaviorEvent event) {
        if(wClass.equals("grayLetter"))
        {
            wClass = "greenLetter";
        }
        else if(wClass.equals("greenLetter"))
        {
            wClass = "redLetter";
        }
        else
        {
            wClass = "grayLetter";
        }
        
        letters.put('W', wClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeXClass(AjaxBehaviorEvent event) {
        if(xClass.equals("grayLetter"))
        {
            xClass = "greenLetter";
        }
        else if(xClass.equals("greenLetter"))
        {
            xClass = "redLetter";
        }
        else
        {
            xClass = "grayLetter";
        }
        
        letters.put('X', xClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeYClass(AjaxBehaviorEvent event) {
        if(yClass.equals("grayLetter"))
        {
            yClass = "greenLetter";
        }
        else if(yClass.equals("greenLetter"))
        {
            yClass = "redLetter";
        }
        else
        {
            yClass = "grayLetter";
        }
        
        letters.put('Y', yClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }

    public void changeZClass(AjaxBehaviorEvent event) {
        if(zClass.equals("grayLetter"))
        {
            zClass = "greenLetter";
        }
        else if(zClass.equals("greenLetter"))
        {
            zClass = "redLetter";
        }
        else
        {
            zClass = "grayLetter";
        }
        
        letters.put('Z', zClass);
        
        guessedWords = "";
        
        for (int i = 0; i < guessesList.size(); i++)
        {
            String guessInList = "" + guessesList.get(i);
            guessInList = guessInList.toUpperCase();
            letterSpans = "";
                
            for (int j = 0; j < guessInList.length(); j++)
            {
                char c = guessInList.charAt(j);
                String letterClass = letters.get(c);
                letterSpans = letterSpans + "<span class ='" + letterClass + "'>" + c + "</span>";
            }
                
            lettersInGuess = calcLettersInGuess(guessInList.toLowerCase());
                
            guessedWords = guessedWords + "<li>" + letterSpans + " (" + lettersInGuess +  ")</li>";
        }
    }
    
    private Jword checkForWord(String wordToSearch) {
        try {
            Jword word = (Jword)
            em.createNamedQuery("Jword.findByWord").
                    setParameter("word", wordToSearch).getSingleResult();
            return word; 
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    private String getSecretWord() {
        try {
            int randomId = (int)(Math.random() * 5757 + 1);
            Jword jword = (Jword)
            em.createNamedQuery("Jword.findById").
                    setParameter("id", randomId).getSingleResult();
            String word = jword.getWord();
            return word; 
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    private Jstats getStats() {
        try {
            Jstats stats = (Jstats)
            em.createNamedQuery("Jstats.findByJuserId").
                    setParameter("juserid", currentUser.getId()).getSingleResult();
            return stats; 
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    private Jgame getCurrentGame() {
        List usersGames = getGames();
        int numGamesSoFar = usersGames.size();
        Jgame game = (Jgame)usersGames.get(numGamesSoFar-1);
        
        return game;
    }
    
    private Jgame getGameById(int idToFind) {
        try {
            Jgame game = (Jgame)
            em.createNamedQuery("Jgame.findById").
                    setParameter("id", idToFind).getSingleResult();
            return game;
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    private List getGames()
    {
        try {
            List gamesList =
            em.createNamedQuery("Jgame.findByJuserId").
                    setParameter("juserid", currentUser.getId()).getResultList();
            return gamesList; 
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    private List getGuessesForGame(Jgame game)
    {
        try {
            List guessesForGame =
            em.createNamedQuery("Jguess.findByJgameId").
                    setParameter("jgameid", game.getId()).getResultList();
            return guessesForGame; 
        } catch (NoResultException nre) {
            return null;
        }
    }
}