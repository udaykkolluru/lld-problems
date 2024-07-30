package stackoverflow;

import java.util.List;

import model.Answer;
import model.Author;
import model.Question;

public class Client {

	public static void main(String[] args) {
		StackOverflowSystem stackOverflowSystem = new StackOverflowSystem();
		Author udayAuthor = stackOverflowSystem.createUser("uday", "pwds");
		Author benAuthor = stackOverflowSystem.createUser("ben", "akjn");
		Author gwenAuthor = stackOverflowSystem.createUser("gwen", "akjn");

		Question uq = stackOverflowSystem.askQuestion(udayAuthor, "what is kubectl", "what is kubectl and etc",
				List.of("kubernetes, cloud"));

		Answer baAnswer = stackOverflowSystem.answerToAQuestion(benAuthor, uq,
				"kubectl is used to mange kubernetes resources");
		stackOverflowSystem.addComment(benAuthor, "a comment", baAnswer);
		System.out.println(udayAuthor);
		System.out.println(benAuthor);
		stackOverflowSystem.addVote(gwenAuthor, baAnswer);
		System.out.println(gwenAuthor);
		System.out.println(baAnswer.getVoteCount());
		System.out.println(stackOverflowSystem.getQuestions());

	}

}
