package kyungmin.multimodule.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kyungmin.multimodule.controller.request.CreateTestRequest;
import kyungmin.multimodule.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/test")
@Tag(name = "테스트 관련 API")
public class TestController {

  @Value("${name}")
  private String name;

  private final TestService service;

  @PostMapping(value = "/create")
  public ResponseEntity<Void> create(@RequestBody CreateTestRequest request) {
    service.create(request);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/get")
  public ResponseEntity<String> getTitle(String id) {
    System.out.println(name);
    return ResponseEntity.ok(service.getTitle(id));
  }
}
