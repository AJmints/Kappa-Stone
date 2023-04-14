package org.backend.kappastoneletsgo.data;

import org.backend.kappastoneletsgo.models.postmodels.NewPost;
import org.backend.kappastoneletsgo.models.postmodels.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
