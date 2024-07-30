package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Answer implements Commentable, Votable {

	private String id;
	private Date createDate;
	private Author author;
	private String content;
	private Question question;
	private List<Comments> commentsList;
	private List<Vote> voterList;

	public Answer(Author author, Question question, String content) {
		this.id = UUID.randomUUID().toString();
		this.createDate = new Date();
		this.author = author;
		this.content = content;
		this.question = question;
		this.commentsList = new ArrayList<>();
		this.voterList = new ArrayList<>();
	}

	@Override
	public int getVoteCount() {
		return voterList.stream().mapToInt(Vote::getValue).sum();
	}

	@Override
	public void addVote(Author author) {
		Vote vote = new Vote(author, 2);
		voterList.add(vote);
		System.out.println(voterList + " "+ this.getAuthor().getUsername());
	}

	@Override
	public void createComment(Comments comments) {
		commentsList.add(comments);
	}

	@Override
	public List<Comments> getComments() {
		return commentsList;
	}

	public String getId() {
		return id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Author getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	public Question getQuestion() {
		return question;
	}

	public List<Comments> getCommentsList() {
		return commentsList;
	}

	public List<Vote> getVoterList() {
		return voterList;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", author=" + author.getUsername() + ", content=" + content + ", question="
				+ question.getAuthor().getUsername() + ", commentsList=" + commentsList + ", voterList=" + voterList
				+ "]";
	}

}
