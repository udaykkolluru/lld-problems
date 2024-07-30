package stackoverflow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import model.Answer;
import model.Author;
import model.Commentable;
import model.Question;
import model.Tags;
import model.Votable;

public class StackOverflowSystem {
	private  Map<String, Author> users;
	private  Map<String, Question> questions;
	private  Map<String, Answer> answers;
	private  Map<String, Tags> tags;

	public Map<String, Author> getUsers() {
		return users;
	}

	public Map<String, Question> getQuestions() {
		return questions;
	}

	public Map<String, Answer> getAnswers() {
		return answers;
	}

	public Map<String, Tags> getTags() {
		return tags;
	}

	public StackOverflowSystem() {
		this.users = new ConcurrentHashMap<>();
		this.questions = new ConcurrentHashMap<>();
		this.answers = new ConcurrentHashMap<>();
		this.tags = new ConcurrentHashMap<>();
	}

	public Author createUser(String username, String password) {
		Author author = new Author(username, String.valueOf(password.hashCode()));
		users.putIfAbsent(author.getId(), author);
		return author;
	}

	public Question askQuestion(Author author, String title, String content, List<String> list) {
		Question question = author.askQuestion(title, content, list);
		questions.put(question.getId(), question);
		question.getTagsList().stream().forEach(t -> tags.put(t.getName(), t));
		return question;
	}

	public Answer answerToAQuestion(Author author, Question question, String content) {
		Answer answer = author.answerToQuestion(question, content);
		answers.put(answer.getId(), answer);
		return answer;
	}

	public void addComment(Author author, String content, Commentable commentable) {
		author.addComment(commentable, content);
	}

	public void addVote(Author author, Votable votable) {
		votable.addVote(author);
	}

	public List<Question> searchInQUestions(String keywords) {
		List<Question> questionsList = questions.values().stream()
				.filter(q -> (q.getContent().matches(keywords) || q.getTitle().matches(keywords)
						|| q.getTagsList().stream().anyMatch(t -> t.getName().matches(keywords))))
				.collect(Collectors.toList());

		return questionsList;
	}
	
	

}
