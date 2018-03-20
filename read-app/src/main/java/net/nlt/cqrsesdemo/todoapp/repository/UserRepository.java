package net.nlt.cqrsesdemo.todoapp.repository;

import net.nlt.cqrsesdemo.todoapp.domain.document.user.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {
}
