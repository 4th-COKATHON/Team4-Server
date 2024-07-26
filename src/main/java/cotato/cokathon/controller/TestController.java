package cotato.cokathon.controller;

import cotato.cokathon.entity.TestEntity;
import cotato.cokathon.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestRepository testRepository;

    @GetMapping("/")
    public String test() {
        return "test";
    }

    @GetMapping("/test/data")
    public String testData() {
        TestEntity testEntity = new TestEntity(1L, "data");
        TestEntity save = testRepository.save(testEntity);
        return save.getData();
    }


}
