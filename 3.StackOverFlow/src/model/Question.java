package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Question implements Commentable, Votable {

	private String id;
	private Date createDate;
	private Author author;
	private String title;
	private String content;
	private List<Answer> answersList;
	private List<Tags> tagsList;
	private List<Comments> commentsList;
	private List<Vote> voterList;

	public Question(Author author, String title, String content, List<Tags> tagsList) {
		this.id = UUID.randomUUID().toString();
		this.createDate = new Date();
		this.author = author;
		this.title = title;
		this.content = content;
		this.answersList = new ArrayList<>();
		this.commentsList = new ArrayList<>();
		this.voterList = new ArrayList<>();
		this.tagsList = new ArrayList<>(tagsList);
	}

	@Override
	public int getVoteCount() {
		return voterList.stream().mapToInt(Vote::getValue).sum();
	}

	@Override
	public void addVote(Author author) {
		Vote vote = new Vote(author, 5);
		voterList.add(vote);
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

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public List<Answer> getAnswersList() {
		return answersList;
	}

	public List<Tags> getTagsList() {
		return tagsList;
	}

	public List<Comments> getCommentsList() {
		return commentsList;
	}

	public List<Vote> getVoterList() {
		return voterList;
	}

	public void addAnswerToList(Answer answer) {
		this.answersList.add(answer);

	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", author=" + author.getUsername() + ", createDate=" + createDate + ", title="
				+ title + ", content=" + content + ", answersList=" + answersList + ", tagsList=" + tagsList
				+ ", commentsList=" + commentsList + ", voterList=" + voterList + "]";
	}

}
