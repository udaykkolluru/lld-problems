package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Author {
	private String id;
	private String username;
	private String password;

	private int reputation;
	private List<Question> questionsList;
	private List<Answer> answersList;
	private List<Comments> commentsList;

	public Author(String username, String password) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.password = password;
		this.reputation = 0;
		this.questionsList = new ArrayList<>();
		this.answersList = new ArrayList<>();
		this.commentsList = new ArrayList<>();
	}

	// getters
	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public int getReputation() {
		return reputation;
	}

	public List<Question> getQuestionsList() {
		return questionsList;
	}

	public List<Answer> getAnswersList() {
		return answersList;
	}

	public List<Comments> getCommentsList() {
		return commentsList;
	}

	public Question askQuestion(String title, String content, List<String> tags) {
		List<Tags> tagsList = new ArrayList<>();
		tags.forEach(t -> tagsList.add(new Tags(t)));
		Question question = new Question(this, title, content, tagsList);
		questionsList.add(question);
		this.reputation += 50;
		return question;
	}

	public Answer answerToQuestion(Question question, String content) {
		Answer answer = new Answer(this, question, content);
		answersList.add(answer);
		question.addAnswerToList(answer);
		this.reputation += 25;
		return answer;
	}

	public void addComment(Commentable commentable, String content) {
		Comments comments = new Comments(this, content);
		commentsList.add(comments);
		this.reputation += 10;
		commentable.createComment(comments);

	}

	public void addVote(Votable votable) {
		votable.addVote(this);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", username=" + username + ", password=" + password + ", reputation=" + reputation
				+ ", questionsList=" + questionsList + ", answersList=" + answersList + ", commentsList=" + commentsList
				+ "]";
	}

	

}
