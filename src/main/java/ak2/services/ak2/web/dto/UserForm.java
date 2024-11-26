package ak2.services.ak2.web.dto;

import ak2.services.ak2.domain.annotations.CheckUsername;
import jakarta.validation.constraints.NotEmpty;

public record UserForm(
        @CheckUsername
        String username,

        @NotEmpty
        String password
) {
}
