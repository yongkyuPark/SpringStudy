package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HelloBootTest
public class HelloRepositoryTest {
    @Autowired
    HelloRepository helloRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void findHelloFailed() {
        Assertions.assertThat(helloRepository.findHello("Park")).isNull();
    }

    @Test
    void increaseCount() {
        Assertions.assertThat(helloRepository.countOf("Park")).isEqualTo(0);

        helloRepository.increaseCount("Park");
        Assertions.assertThat(helloRepository.countOf("Park")).isEqualTo(1);

        helloRepository.increaseCount("Park");
        Assertions.assertThat(helloRepository.countOf("Park")).isEqualTo(2);
    }
}
