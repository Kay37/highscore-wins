package com.pluralsight;

// ! importing Scanner for user input receiving

import java.util.Scanner;

public class HighscoreWins {

    // ! public static Scanner that any method can call and use
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // TODO - Prompt the user to enter team and score info of an event.
        // * Input will be a single string that contains both team names and the final score of the match.
        // Score should be in the following format: Home:Visitor|21:9
        System.out.print("Please enter team and score information (e.g. Home:Visitor|21:9) : ");
        String eventInfo = sc.nextLine();


        // TODO - Process and format event information
        // * Hint: Will have to split the user input multiple times - once on the pipe (|) and once on the colon ( : )
        // * -1 tells split() to keep empty sections! split() has a second optional parameter called limit.
        // * -1 tells Java to keep empty pieces at the end of the string. .split("\\|) would return [0] = "Home:Visitor"
        // * .split("\\|", -1) would return [0] = "Home:Visitor" and [1] = "" (empty string) so we can detect a missing
        // * score section
        String trimmedEventInfo = eventInfo.trim();
        String[] eventInfoParts = trimmedEventInfo.split("\\|", -1);
        // result should be 0 = Home:Visitor and 1 = 21:9

        if (eventInfoParts.length != 2) {
            System.out.println("Please enter the team and score information in the example format.");
            return;
        }
//
        String[] teamNames = eventInfoParts[0].split(":", -1);
        // result should be 0 = Home, 1 = Visitor
        String[] teamScores = eventInfoParts[1].split(":", -1);
        // result should be 0 = 21, 1 = 9

        // * trimming team names to remove extra spaces if present.
        teamNames[0] = teamNames[0].trim();
        teamNames[1] = teamNames[1].trim();
        // * checking that we have exactly two teams and two scores.
        // * || means OR. != means not equal to.
        // * return; exits the method and stops the program before any errors.

        if (teamNames.length != 2 || teamScores.length != 2) {
            System.out.println("Please enter exactly two teams and two scores.");
            return;

        }
        // * checking that neither team name is blank.
        if (teamNames[0].trim().isEmpty()
                || teamScores[1].trim().isEmpty()) {
            System.out.println("Team names can't be empty. Please fill in the team names.");
            return;
        }

        // * score validation - making sure they inputed numbers and not letters.
        if (!teamScores[0].matches("[0-9]+")
                || !teamScores[1].matches("[0-9]+")) {
            System.out.println("Scores must be whole numbers only.");
            return;
        }

        // TODO - Determine what score is higher, and which team the higher score belongs to given the format
        // * Can use if statement here.
        // * convert teamScores to an integer with ParseInt, and determine if teamScores[0] is higher than teamScores[1]
        // * if [0] is higher than Visitor, or the team at [1] position in teamNames, then [0] is the winner.
        // * if [1] is higher than Home, or the team at [0] position in teamNames, then [1] is the winner.
        int teamOneScore = Integer.parseInt(teamScores[0]);
        int teamTwoScore = Integer.parseInt(teamScores[1]);

        if (teamOneScore > teamTwoScore) {
            int scoreDifferenceHome = teamOneScore - teamTwoScore;
            System.out.printf("Team %s wins by %d points! The score was %d to %d%n", teamNames[0], scoreDifferenceHome, teamOneScore, teamTwoScore);

        } else if (teamTwoScore > teamOneScore) {
            int scoreDifferenceVisitor = teamTwoScore - teamOneScore;
            System.out.printf("Team %s wins by %d points! The score was %d to %d%n", teamNames[1], scoreDifferenceVisitor, teamTwoScore, teamOneScore);
        } else {
            System.out.printf("%s tied with %s! The score was %d to %d%n", teamNames[0], teamNames[1], teamOneScore, teamTwoScore);
        }

    } // ! main method cBracket

} // ! main class cBracket
