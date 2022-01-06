package de.htw.webtech.SafePass.service;

import de.htw.webtech.SafePass.persistence.ItemEntity;
import de.htw.webtech.SafePass.persistence.UserEntity;
import de.htw.webtech.SafePass.persistence.UserRole;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.doReturn;

class UserTransformerTest implements WithAssertions {

    private final UserTransformer underTest = new UserTransformer();


    @Test
    @DisplayName("should transform PersonEntity to Person")
    void should_transform_user_entity_to_user() {
        // given
        var userEntity = Mockito.mock(UserEntity.class);
        doReturn(10L).when(userEntity).getId();
        doReturn("test@email.de").when(userEntity).getEmail();
        doReturn("testname").when(userEntity).getUsername();
        doReturn("testpassword").when(userEntity).getPassword();
        doReturn(UserRole.ADMIN).when(userEntity).getUserRole();
        doReturn(List.of(new ItemEntity())).when(userEntity).getItemList();

        // when
        var result = underTest.transformEntity(userEntity);

        // then
        assertThat(result.getId()).isEqualTo(10L);
        assertThat(result.getEmail()).isEqualTo("test@email.de");
        assertThat(result.getUsername()).isEqualTo("testname");
        assertThat(result.getPassword()).isEqualTo("testpassword");
        assertThat(result.getUserRole()).isEqualTo("ADMIN");
        assertThat(result.getItemIds()).hasSize(1);
    }
}
