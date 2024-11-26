package ak2.services.ak2.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAk2User is a Querydsl query type for Ak2User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAk2User extends EntityPathBase<Ak2User> {

    private static final long serialVersionUID = 462786688L;

    public static final QAk2User ak2User = new QAk2User("ak2User");

    public final StringPath enabled = createString("enabled");

    public final StringPath password = createString("password");

    public final SetPath<UserAuthority, QUserAuthority> roles = this.<UserAuthority, QUserAuthority>createSet("roles", UserAuthority.class, QUserAuthority.class, PathInits.DIRECT2);

    public final StringPath userId = createString("userId");

    public QAk2User(String variable) {
        super(Ak2User.class, forVariable(variable));
    }

    public QAk2User(Path<? extends Ak2User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAk2User(PathMetadata metadata) {
        super(Ak2User.class, metadata);
    }

}

