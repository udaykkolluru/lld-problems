package model;

import java.util.List;

public interface Commentable {
	public void createComment(Comments comments);

	public List<Comments> getComments();

}
