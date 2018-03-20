package net.nlt.cqrsesdemo.todoapp.domain.document.user;

import lombok.Getter;
import lombok.Setter;
import net.nlt.cqrsesdemo.todoapp.domain.document.BaseDocument;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "users")
public class UserDocument extends BaseDocument {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
