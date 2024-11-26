package ak2.services.ak2.domain.annotations;

import ak2.services.ak2.domain.validator.CheckUserValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;

import java.lang.annotation.*;

@MustBeDocumented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckUserValidator.class)
@Repeatable(CheckUsername.List.class)
public @interface CheckUsername {
    String message() default "check user name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        CheckUsername[] value();  // CheckUsername アノテーションの配列
    }
}
