package kyungmin.multimodule.service;

import kyungmin.multimodule.controller.request.CreateTestRequest;
import kyungmin.multimodule.domain.Test;
import kyungmin.multimodule.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
  private final TestRepository repository;

  public void create(CreateTestRequest request) {
    repository.save(
      Test.builder()
        .title(request.title())
        .content(request.content())
        .build()
    );
  }

  public String getTitle(String id) {
    return repository.getById(Long.parseLong(id)).getTitle();
  }
}
