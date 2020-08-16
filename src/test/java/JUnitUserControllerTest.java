import com.pyruz.SpringBootAOPExampleApplication;
import com.pyruz.controller.UserController;
import com.pyruz.model.domain.User;
import com.pyruz.model.dto.ResultDTO;
import com.pyruz.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAOPExampleApplication.class)
public class JUnitUserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void testGetUserController() {
        String result = userController.home();
        assertEquals(result, "This is home Controller!");
    }

    @Test
    public void testPostUserController() {
        ResultDTO correctResultDTO = ResultDTO.builder()
                .code(0)
                .message("User created successfully!")
                .build();
        ResultDTO result = userController.addUser(
                User.builder()
                        .firstName("Pyruz")
                        .lastName("Janbaaz")
                        .phoneNumber(98912001700170l)
                        .build()
        );
        assertEquals(result, correctResultDTO);
    }
}